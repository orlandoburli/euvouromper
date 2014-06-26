

/*
- Pacote 
     - Coeficiente = Valor de Vendas do Pacote / Quantidade de Vídeos assistidos (por cliente, individualmente)
     - Percentual Professor = Quantidade de vídeos do professor X Coeficiente
     - Valor Comissão = Valor Vendas do Pacote X Percentual Professor X 50%
*/

select valor_vendas, videos_modulo, videos_professor, cast(videos_professor / (videos_modulo + 0.0000000001) as numeric(8, 4)) as percentual_professor, cast((videos_professor /  (videos_modulo + 0.0000000001)) * valor_vendas * 0.5 as numeric(8,2)) as valor_comissao
  from (
     select (
     -- Vendas do modulo
     select coalesce(sum(i.valor), 0.00) from pacote pc
       join produto p on p.id_pacote = pc.id_pacote
       join item_pedido i on i.id_produto = p.id_produto
       join pedido ped on ped.id_pedido = i.id_pedido
      where 1=1
        and ped.status_pedido = 'P'
        and pc.id_pacote = 20
        and date_trunc('day', ped.data_hora_pedido) between '2014-01-01' and '2014-12-31'
     ) as valor_vendas,

     (-- Views do modulo
  select cast( count(*)  as numeric(8,4)) as quantidade_views from (
  select distinct l.id_video, l.id_cliente
    from log_video l
    join item_pedido i on i.id_item_pedido = l.id_item_pedido
    join video v on l.id_video = v.id_video
   where 1 = 1
     and date_trunc('day', l.data_hora) between '2014-01-01' and '2014-12-31'
     and tipo_visualizacao = 'P'
     and i.id_pacote = 20

    ) as tab1 ) as videos_modulo,

     (-- Views do professor
    select cast( count(*) as numeric(8,4)) as quantidade_views from (
  select distinct l.id_video, l.id_cliente
    from log_video l
    join item_pedido i on i.id_item_pedido = l.id_item_pedido
    join video v on l.id_video = v.id_video
   where 1 = 1
     and date_trunc('day', l.data_hora) between '2014-01-01' and '2014-12-31'
     and tipo_visualizacao = 'P'
     and i.id_pacote = 20
     and id_professor = 3) as tab1 )  as videos_professor
     )
as tab2