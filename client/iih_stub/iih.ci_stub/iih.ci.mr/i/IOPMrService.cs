using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mr.mrdocrefvalue.d;
using iih.ci.mr.cimr.d;
using iih.ci.mr.cimrfs.d;
using xap.mw.core.data;
using iih.bd.srv.emrtpl.d;
using iih.bd.srv.mrtplstream.d;

namespace iih.ci.mr.i
{
    public interface IOPMrService
    {
        /// <summary>
        /// 门诊保存病历
        /// </summary>
        /// <param name="mrDocRefValueDOs"></param>
        /// <param name="ciMrDOs"></param>
        /// <param name="ciMrFsDOs"></param>
        /// <returns></returns>
        FArrayList2 SaveMr(MrDocRefValueDO[] mrDocRefValueDOs, CiMrDO ciMrDO, CiMrFsDO ciMrFsDO);

        /// <summary>
        /// 获取处置模板信息
        /// </summary>
        /// <param name="id_dept"></param>
        /// <returns></returns>
        FArrayList2 GetDefaultMrPreFormats(string id_dept);

        /// <summary>
        /// 获取模板所属自定义分类
        /// </summary>
        /// <param name="id_mrtp"></param>
        /// <param name="code_entp"></param>
        /// <returns></returns>
        string GetIdMrctm(string id_mrtp, string code_entp);

        /// <summary>
        /// 根据当前数据获取所需基本数据
        /// </summary>
        /// <param name="ciMrDO"></param>
        /// <returns></returns>
        FArrayList2 GetData(CiMrDO ciMrDO);

        /// <summary>
        /// 根据就诊号和数据集获取病历文书
        /// </summary>
        /// <param name="id_ent">就诊号</param>
        /// <param name="code_sets">数据集code</param>
        /// <returns></returns>
        CiMrDO[] GetCiMrByIdEnt(String id_ent, String[] code_sets);

        string GetBdSetCodeByMrtp(string id_mrtp);


        /// <summary>
        ///  保存模板另存为
        /// </summary>
        /// <param name="emrTplStreamDo"></param>
        /// <param name="emrTplDo"></param>
        /// <returns></returns>
        EmrTplDO SaveTplAs(EmrTplStreamDO emrTplStreamDo, EmrTplDO emrTplDo);
        /// <summary>
        ///  强制更新CiMrDO的提交状态
        /// </summary>
        /// <param name="CiMrDO"></param>
        /// <returns></returns>
        void UpdateMrForce(CiMrDO ciMrDo);
    }
}
