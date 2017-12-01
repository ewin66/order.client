create or replace view BT_ORDERNO_VIEW
as
select
CI_AP_BT.no_applyform Id_Apbt,
CI_AP_BT.no_applyform,
EN_ENT.Code EN_CODE,
EN_ENT.Name_Pat,
CI_OR_SRV.Name blood_comp,
CI_AP_BT.Ds,
CI_AP_BT.Sv
from ci_order 
inner join CI_AP_BT 
on CI_AP_BT.Id_Or = ci_order.id_or 
inner join CI_OR_SRV
on CI_OR_SRV.id_or = ci_order.id_or and CI_OR_SRV.id_srv = ci_order.id_srv
left outer join EN_ENT
on EN_ENT.id_ent = ci_order.id_en
and EN_ENT.ds = 0
where ci_order.sd_srvtp = '140101' 
and ci_order.fg_canc = 'N'
and ci_order.ds = 0
and CI_AP_BT.ds = 0
and CI_OR_SRV.ds = 0
order by CI_AP_BT.no_applyform;