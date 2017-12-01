create or replace view LAB_ORDERNO_VIEW
as
select 
CI_AP_LAB.no_applyform ID_ORLAB,
CI_AP_LAB.no_applyform,
EN_ENT.Code EN_CODE,
EN_ENT.Name_Pat,
ci_order.name_or,
CI_AP_LAB.Ds,
CI_AP_LAB.Sv
from ci_order 
inner join CI_AP_LAB 
on CI_AP_LAB.Id_Or = ci_order.id_or
left outer join EN_ENT
on EN_ENT.id_ent = ci_order.id_en
and EN_ENT.ds = 0
where ci_order.sd_srvtp like '03%' 
and ci_order.fg_canc = 'N'
and ci_order.ds = 0
and CI_AP_LAB.ds = 0
order by CI_AP_LAB.no_applyform;