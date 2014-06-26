
/*
- Vídeo Individual
     - 50% do valor para professor
*/

-- videos individuais
select count(*) as quantidade_individual, sum(valor) as valor_individual, cast(sum(valor) * 0.5 as numeric(8, 2)) as valor_professor from (
select distinct l.id_video, l.id_cliente, m.valor
  from log_video l
  join video v on l.id_video = v.id_video
  join cliente_movimentacao m on m.id_movimentacao = l.id_movimentacao
 where 1 = 1
   and date_trunc('day', l.data_hora) between '2014-01-01' and '2014-12-31'
   and tipo_visualizacao = 'I'
   and v.id_professor = 3
) as tab1


