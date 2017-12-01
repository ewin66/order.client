using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciordems.d;
using iih.en.pv.dto.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.ci.ord.cards.thread.dp;
using iih.ci.diag.dto.d;
using iih.bd.bc.udi;
using iih.mkr.ms.mkrms.d;
using xap.rui.control.extentions;
using iih.ci.diag.cidiag.i;
using xap.mw.coreitf.d;
using iih.ci.diag.cidiag.d;
using System.Text.RegularExpressions;
using iih.ci.ord.dto.d;
using iih.ci.iih.ci.ord.dto.ordsrvchangeddto.d;
using iih.ci.iih.ci.ord.i;
using xap.mw.core.data;

namespace iih.ci.ord.opemergency.tool
{
    class AssToolEx
    {
        public static DictionaryEventArgs DictionaryEventArgsWith(string uiEventCode, string dataTag = null, Object objData = null, object param = null)
        {
            DictionaryEventArgs dic = new DictionaryEventArgs();
            dic.Data[UIConst.UI_EVENT] = uiEventCode;

            if (dataTag != null && dataTag.Length > 0)
            {
                Dictionary<String, Object> paramDic = new Dictionary<string, object>();
                // 添加主数据参数
                paramDic.Add(dataTag, objData);
                // 添加附加参数
                if (param != null)
                {
                    paramDic.Add("param", param);
                }

                dic.Data.Add(UIConst.DATA, paramDic);
            }
            return dic;
        }
      
        /// <summary>
        ///  说明：HandleState 形式的消息通知发送
        /// </summary>
        /// <param name="owner">已在通知中心注册的对象</param>
        /// <param name="uiEventCode"></param>
        /// <param name="dataTag"></param>
        /// <param name="objData"></param>
        /// <param name="param"></param>

        public static void SentMessage(XapBaseControl owner, string uiEventCode, string dataTag = null, Object objData = null, object param = null)
        {
            owner.FireEventSent(owner, DictionaryEventArgsWith(uiEventCode, dataTag, objData, param));
        }

        public static void SentMessage(XapBaseControl owner, DictionaryEventArgs args)
        {
            owner.FireEventSent(owner, args);
        }

        public static string EventCodeOfEventArgs(DictionaryEventArgs eventArgs)
        {
            return eventArgs.Data[UIConst.UI_EVENT] as string;
        }

        public static DictionaryEventArgs ResetDataOfEventArgs(DictionaryEventArgs eventArgs, object dataObj)
        {
            eventArgs.Data[UIConst.DATA] = dataObj;
            return eventArgs;
        }

        public static DictionaryEventArgs ResetEventOfEventArgs(DictionaryEventArgs eventArgs, object eventCode)
        {
            eventArgs.Data[UIConst.UI_EVENT] = eventCode;
            return eventArgs;
        }

        public static object ObjectOfEventArgs(DictionaryEventArgs eventArgs, String dataTag )
        {
            Dictionary<string, Object> dataDict = null;

            if (eventArgs.Data.ContainsKey(UIConst.DATA))
            {
                dataDict = (eventArgs.Data[UIConst.DATA] as Dictionary<string, Object>);
                if (dataDict != null && dataDict.ContainsKey(dataTag))
                    return dataDict[dataTag];
            }

            return null;
        }

        public static object ParameterOfEventArgs(DictionaryEventArgs eventArgs)
        {
            return ObjectOfEventArgs(eventArgs, "param");
        }

        public static string CheckTestSkinSrv(XapBaseControl ctrl, EmsOrDrug drug, Ent4BannerDTO patInfo)
        {
            //数据回写后，进行皮试判断

            if (drug.Fg_skintest != null && drug.Fg_skintest == true)
            {
                SkinTestLogic logic = new SkinTestLogic(patInfo);
                string code = logic.skinTestLogic(drug);
                if ("0".Equals(code)) {//皮试为阳性，禁用
                    return "患者存在该药品过敏史并禁用该药！";
                }
                else if ("9".Equals(code)) {
                    return "患者存在该药品过敏史,未录入强制使用原因，禁用该药！";
                }
            }
            return "";
        }

        /// <summary>
        /// 判断皮试结果
        /// </summary>
        /// <param name="drug">物品</param>
        /// <param name="skinTestRst">皮试结果</param>
        /// <param name="patInfo">患者信息</param>
        /// <returns></returns>
        public static string CheckSkinTestRst(EmsOrDrug drug, SkinTestRstDTO skinTestRst, Ent4BannerDTO patInfo)
        {
            //数据回写后，进行皮试判断

            if (drug.Fg_skintest != null && drug.Fg_skintest == true)
            {
                SkinTestLogic logic = new SkinTestLogic(patInfo);
                string code = logic.CheckSkinTestRst(drug, skinTestRst);
                if ("0".Equals(code))
                {//皮试为阳性，禁用
                    return "";
                    //return "患者存在该药品过敏史并禁用该药！";
                }
                else if ("9".Equals(code))
                {
                    return "患者存在该药品过敏史,未录入强制使用原因，禁用该药！";
                }
            }
            return null;
        }

        public static DIDTO DIDTOWith(MkrMsDiDO o, Ent4BannerDTO e = null, BaseContext c = null)
        {
            return new DIDTO()
            {
                Code_entp = (e != null ? e.Code_entp : ""),
                Des_di = "",
                Di_disease = "",
                Di_standard = "",
                Di_standard_code = "",
                Di_standard_name = "",
                Didef_code = o.Didef_code,
                Didef_name = o.Didef_name,
                Dt_create = CommonExtentions.NowTime(o),
                Dt_di = CommonExtentions.NowTime(o),
                Dt_sign = CommonExtentions.NowTime(o),
                Fg_infedi = false,
                Fg_majdi = o.Fg_majdi,
                Fg_med = false,
                Fg_sign = true,
                Fg_suspdi = o.Fg_majdi != true,
                Id_dep = "",
                Id_dep_create = "",
                Id_dep_create_name = "",
                Id_dep_sign = (c != null ? c.Dept.Id_dep : ""),
                Id_di = null,
                Id_didef = o.Id_didef,
                //         Id_didef_syn { get; set; }
                //         Id_didef_syn_code { get; set; }
                //         Id_didef_syn_name { get; set; }
                //         Id_diitm = "",
                //         Id_disease_code { get; set; }
                //         Id_disease_name { get; set; }
                Id_disys = o.Id_cdsys,
                Id_disys_name = o.Cdsys_name,
                //         Id_ditp { get; set; }
                //         Id_ditp_name { get; set; }
                Id_emp_create = (c != null ? c.PsnInfo.Id_psndoc : ""),
                Id_emp_create_name = (c != null ? c.PsnInfo.Name : ""),
                Id_emp_sign = (c != null ? c.PsnInfo.Id_psndoc : ""),
                Id_en = (e != null ? e.Id_ent : ""),
                Id_entp = (e != null ? e.Id_entp : ""),
                Id_par = o.Id_par,
                Id_pat = (e != null ? e.Id_pat : ""),
                Name_emp_sign = (c != null ? c.PsnInfo.Name : ""),
                //         Sd_disys { get; set; }
                //         Sd_ditp { get; set; }
                Sortno = null,
                Supplement = o.Supplement

            };
        }

        public static string DescrStringWithDIDTOs(DIDTO[] szDI)
        {
            string xyDescString = "", zyDescString = "";
            int xyIndex = 1, zyIndex = 1;
            foreach (DIDTO di in szDI)
            {
                if (di.Didef_code == null && di.Didef_name == null)
                    continue;

                if (di.Id_disys == CiDictCodeConst.ID_CI_DISYS_XYZDTX)
                {
                    xyDescString += di.Didef_name;
                    if (di.Fg_majdi == true)
                    {
                        xyDescString = "★" + xyDescString;
                    }
                    if (di.Fg_suspdi == true)
                    {
                        xyDescString += "?";
                    }
                    xyDescString += di.Didef_name;
                    xyDescString = xyIndex + "、" + xyDescString + "\n";
                    ++xyIndex;
                }
                else
                {
                    zyDescString += di.Id_disease_name;
                    if (di.Fg_majdi == true)
                    {
                        zyDescString = "★" + zyDescString;
                    }
                    if (di.Fg_suspdi == true)
                    {
                        zyDescString += "?";
                    }
                    zyDescString += "——" + di.Id_didef_syn_name;
                    zyDescString = zyIndex + "、" + zyDescString + "\n";
                    ++zyIndex;
                }


            }

            return xyDescString + zyDescString;
        }


        #region XapFormControl
        public static T Cast<T>(object o)
        {
            return (T)o ;
        }

        class PatDiInfoContext
        {
            public PatDiInfoContext() { hasDiInfo = false; }
            public String id_ent { get; set; }

            public Boolean hasDiInfo { get; set; }
        }

        static PatDiInfoContext glPatDiInfoContext = new PatDiInfoContext();
        public static bool CheckPatDiInfo(Ent4BannerDTO e)
        {
            
            if (e != null && e.Id_ent != glPatDiInfoContext.id_ent) {
                ICidiagCrudService diagservice = XapServiceMgr.find<ICidiagCrudService>();
                CidiagAggDO[] diaglist = diagservice.find("a0.id_en ='" + e.Id_ent + "'", "a0.sv desc", FBoolean.False);
                glPatDiInfoContext.hasDiInfo = (diaglist != null && diaglist.Length > 0 && diaglist[0].getCiDiagItemDO() != null && diaglist[0].getCiDiagItemDO().Length > 0);
            }

            return !glPatDiInfoContext.hasDiInfo;
        }
        #endregion

        #region 正则数字判断
        public static bool IsNumeric(string value)
        {
            return Regex.IsMatch(value, @"^[+-]?\d*[.]?\d*$");
        }
        public static bool IsInt(string value)
        {
            return Regex.IsMatch(value, @"^[+-]?\d*$");
        }
        public static bool IsUnsign(string value)
        {
            return Regex.IsMatch(value, @"^\d*[.]?\d*$");
        }

        public static bool isTel(string strInput)
        {
            return Regex.IsMatch(strInput, @"\d{3}-\d{8}|\d{4}-\d{7}");
        }
        #endregion

        /// <summary>
        /// 服务不可开立判断
        /// </summary>
        /// <param name="idsrvs"></param>
        /// <returns></returns>
        public static Dictionary<string, string> OrdEnabelValivate(String[] idsrvs, String code_entp)
        {
            Dictionary<string, string> dic = new Dictionary<string, string>();
            if (idsrvs != null && idsrvs.Length > 0)
            {
                List<OrdSrvChangedInfoDTO> lstDOs = new List<OrdSrvChangedInfoDTO>();
                foreach (var idsrv in idsrvs)
                {
                    lstDOs.Add(new OrdSrvChangedInfoDTO() { Id_srv = idsrv });
                }

                ICiOrdQryService ciOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
                FMap2 map = ciOrdQryService.JudgeOrdChangedSrv(lstDOs.ToArray(), code_entp);
                if (map != null)
                {
                    foreach (var key in map.Keys)
                    {
                        dic.Add(key, map[key].ToString());
                    }
                }
            }

            return dic;
        }
        /// <summary>
        /// 判断当前登录医生是否有处方权限
        /// </summary>
        /// <param name="id_psn"></param>
        /// <returns>true有权限</returns>
        public static bool GetPsnPresRt(string id_psn)
        {
            IPsnAuthorityCertifyService service = XapServiceMgr.find<IPsnAuthorityCertifyService>();
            return service.CertifyPsnPresAuthority(id_psn);
        }
    }
}
