using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using xap.mw.core.data;
using iih.ci.mr.cimr.d;
using iih.bd.srv.emrtpl.d;


namespace iih.ci.mr.i
{
    public class IOPMrServiceImpl : IOPMrService
    {
        /// <summary>
        /// 接口地址
        /// </summary>
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.i.IOPMrService";
        /// <summary>
        /// 调接口服务
        /// </summary>
        private ServiceInvocation si;

        /// <summary>
        /// 构造函数 
        /// 初始化数据
        /// </summary>
        public IOPMrServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 门诊保存病历
        /// </summary>
        /// <param name="mrDocRefValueDOs"></param>
        /// <param name="ciMrDOs"></param>
        /// <param name="ciMrFsDOs"></param>
        /// <returns></returns>
        public FArrayList2 SaveMr(mrdocrefvalue.d.MrDocRefValueDO[] mrDocRefValueDOs, cimr.d.CiMrDO ciMrDO, cimrfs.d.CiMrFsDO ciMrFsDO)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(mrDocRefValueDOs);
            param.Add(ciMrDO);
            param.Add(ciMrFsDO);
            FArrayList2 result = si.invoke<FArrayList2>("SaveMr", param.ToArray());
            
            return result;
        }

        /// <summary>
        /// 获取处置模板信息
        /// </summary>
        /// <param name="id_dept"></param>
        /// <returns></returns>
        public FArrayList2 GetDefaultMrPreFormats(string id_dept)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(id_dept);
            FArrayList2 result = si.invoke<FArrayList2>("GetDefaultMrPreFormats", param.ToArray());

            return result;
        }

        /// <summary>
        /// 获取模板所属自定义分类
        /// </summary>
        /// <param name="id_mrtp"></param>
        /// <param name="code_entp"></param>
        /// <returns></returns>
        public string GetIdMrctm(string id_mrtp, string code_entp)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(id_mrtp);
            param.Add(code_entp);
            string result = si.invokeString("GetIdMrctm", param.ToArray());

            return result;
        }

        /// <summary>
        /// 根据当前数据获取所需基本数据
        /// </summary>
        /// <param name="ciMrDO"></param>
        /// <returns></returns>
        public FArrayList2 GetData(cimr.d.CiMrDO ciMrDO)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(ciMrDO);
            FArrayList2 result = si.invoke<FArrayList2>("GetData", param.ToArray());

            return result;
        }

        public CiMrDO[] GetCiMrByIdEnt(String id_ent, String[] code_sets)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(id_ent);
            param.Add(code_sets);
            CiMrDO[] result = si.invokeList<CiMrDO>("GetCiMrByIdEnt", param.ToArray());
            return result;
        }

        public string GetBdSetCodeByMrtp(string id_mrtp)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(id_mrtp);
           string code = si.invoke<string>("GetBdSetCodeByMrtp", param.ToArray());
            return code;
        }


        /// <summary>
        ///  保存模板另存为
        /// </summary>
        /// <param name="emrTplStreamDo"></param>
        /// <param name="emrTplDo"></param>
        /// <returns></returns>
        public EmrTplDO SaveTplAs(bd.srv.mrtplstream.d.EmrTplStreamDO emrTplStreamDo, EmrTplDO emrTplDo)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(emrTplStreamDo);
            param.Add(emrTplDo);
            EmrTplDO result = si.invoke<EmrTplDO>("SaveTplAs", param.ToArray());

            return result;
        }
        /// <summary>
        ///  强制更新CiMrDO的提交状态
        /// </summary>
        /// <param name="CiMrDO"></param>
        /// <returns></returns>
        public void UpdateMrForce(CiMrDO ciMrDo)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(ciMrDo);
            si.invoke<object>("UpdateMrForce", param.ToArray());

        }
    }
}
