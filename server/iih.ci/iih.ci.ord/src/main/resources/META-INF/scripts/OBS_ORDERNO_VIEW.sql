create or replace view OBS_ORDERNO_VIEW
as
select
CI_AP_OBS.no_applyform Id_Orobs,
CI_AP_OBS.no_applyform,
EN_ENT.Code EN_CODE,
EN_ENT.Name_Pat,
ci_order.name_or,
CI_AP_OBS.Ds,
CI_AP_OBS.Sv
from ci_order 
inner join CI_AP_OBS 
on CI_AP_OBS.Id_Or = ci_order.id_or 
left outer join EN_ENT
on EN_ENT.id_ent = ci_order.id_en
and EN_ENT.ds = 0
where ci_order.sd_srvtp like '02%' 
and ci_order.fg_canc = 'N'
and ci_order.ds = 0
and CI_AP_OBS.ds = 0
order by CI_AP_OBS.no_applyform;