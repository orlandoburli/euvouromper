/*
- Módulo
     - Coeficiente = Valor de Vendas do Modulo / Quantidade de Vídeos assistidos (por cliente, individualmente)
     - Percentual Professor = Quantidade de vídeos do professor X Coeficiente
     - Valor Comissão = Valor Vendas do Modulo X Percentual Professor X 50%
*/


select valor_vendas, videos_modulo, videos_professor, cast(videos_professor / (videos_modulo + 0.0000000001) as numeric(8, 4)) as percentual_professor, cast((videos_professor /  (videos_modulo + 0.0000000001)) * valor_vendas * 0.5 as numeric(8,2)) as valor_comissao
  from (
     select (
     -- Vendas do modulo
     select sum(i.valor) from modulo m
       join produto p on p.id_modulo = m.id_modulo
       join item_pedido i on i.id_produto = p.id_produto
       join pedido ped on ped.id_pedido = i.id_pedido
      where 1=1
        and ped.status_pedido = 'P'
        and m.id_modulo = 11
        and date_trunc('day', ped.data_hora_pedido) between '2014-01-01' and '2014-12-31'
     ) as valor_vendas,

     (-- Views do modulo
  select cast( count(*) as numeric(8,4)) as quantidade_views from (
  select distinct l.id_video, l.id_cliente
    from log_video l
    join item_pedido i on i.id_item_pedido = l.id_item_pedido
    join video v on l.id_video = v.id_video
   where 1 = 1
     and date_trunc('day', l.data_hora) between '2014-01-01' and '2014-12-31'
     and tipo_visualizacao = 'M'
     and i.id_modulo = 11

    ) as tab1 ) as videos_modulo,

     (-- Views do professor
    select cast( count(*) as numeric(8,4)) as quantidade_views from (
  select distinct l.id_video, l.id_cliente
    from log_video l
    join item_pedido i on i.id_item_pedido = l.id_item_pedido
    join video v on l.id_video = v.id_video
   where 1 = 1
     and date_trunc('day', l.data_hora) between '2014-01-01' and '2014-12-31'
     and tipo_visualizacao = 'M'
     and i.id_modulo = 11
     and id_professor = 3) as tab1 )  as videos_professor
     )
as tab2