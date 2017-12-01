using System;
using System.Collections.Generic;
using iih.bd.srv.dto.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.mw.core.data;
using iih.ci.mr.mrdocrefvalue.d;
using iih.ci.mr.cimrfs.d;
using iih.ci.mr.cimr.d;
using iih.ci.mr.mrfs.d;

namespace iih.ci.mr.mrserviceext.i {
    public class IMrServiceExtImpl : IMrServiceExt {
    	
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.mrserviceext.i.IMrServiceExt";
        //private string url = "http://127.0.0.1.:8080" + "/bin/testDOService";

        private ServiceInvocation si;

        public IMrServiceExtImpl(){
            si = new ServiceInvocationImpl();
            si.url = url;
        }
        
        /// 根据自定义分类获取病历文书 
        public CiMrDO[] GetMrByMrCa( string id_ent , string id_mrcactm , string code_entp , string docornur ) {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(id_mrcactm);
            ps.Add(code_entp);
            ps.Add(docornur);
            CiMrDO[] rt = si.invokeList<CiMrDO>("GetMrByMrCa", ps.ToArray());
            return rt;
        } 
               
        /// 获取指定病人医疗文件DTO 
        public MrDTO[] GetMrDtoForTree( string id_ent , string id_mrcactm , string code_entp , string paramtype , string docornur ) {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(id_mrcactm);
            ps.Add(code_entp);
            ps.Add(paramtype);
            ps.Add(docornur);
            MrDTO[] rt = si.invokeList<MrDTO>("GetMrDtoForTree", ps.ToArray());
            return rt;
        } 
               
        /// 批量获取病历记录 
        public CiMrDO[] GetAuditMrs( string id_dep , string id_user , string auditStatus , string docornur ) {
            List<object> ps = new List<object>();
            ps.Add(id_dep);
            ps.Add(id_user);
            ps.Add(auditStatus);
            ps.Add(docornur);
            CiMrDO[] rt = si.invokeList<CiMrDO>("GetAuditMrs", ps.ToArray());
            return rt;
        } 
               
        /// 完成病历 
        public FBoolean CompleteEdit( string id_ent ) {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            FBoolean rt = si.invoke<FBoolean>("CompleteEdit", ps.ToArray());
            return rt;
        } 
               
        /// 保存引用 
        public MrDocRefValueDO[] SaveSourceReferences( MrDocRefValueDO[] ReferenceValues ) {
            List<object> ps = new List<object>();
            ps.Add(ReferenceValues);
            MrDocRefValueDO[] rt = si.invokeList<MrDocRefValueDO>("SaveSourceReferences", ps.ToArray());
            return rt;
        }
        /// 根据就诊号获取已删除的文书 
        public CiMrDO[] GetHasDelMrByEnt(string id_ent)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            CiMrDO[] rt = si.invokeList<CiMrDO>("GetHasDelMrByEnt", ps.ToArray());
            return rt;
        }

        /// <summary>
        /// 清空引用，逻辑删除
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public void ClearSourceReferences(string id_ent)
        {
            si.invoke<int>("ClearSourceReferences", id_ent);
        }
               
        /// 获取最新病程记录 
        public CiMrFsDO GetLeastPgNote( string id_mrcactm , string code_entp , string id_ent ) {
            List<object> ps = new List<object>();
            ps.Add(id_mrcactm);
            ps.Add(code_entp);
            ps.Add(id_ent);
            CiMrFsDO rt = si.invoke<CiMrFsDO>("GetLeastPgNote", ps.ToArray());
            return rt;
        } 
               
        /// 获取医疗记录数据流 
        public MrfsDTO[] GetMrfsByDos( CiMrDO[] mrdos ) {
            List<object> ps = new List<object>();
            ps.Add(mrdos);
            MrfsDTO[] rt = si.invokeList<MrfsDTO>("GetMrfsByDos", ps.ToArray());
            return rt;
        }

        /// <summary>
        /// 获取指定病人医疗文件DTO   
        /// 门诊医生站使用
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="id_mrcactm"></param>
        /// <param name="code_entp"></param>
        /// <returns></returns>
        public MrDTO[] GetMrDtoForOpTree(string id_ent, string id_mrcactm, string code_entp)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(id_mrcactm);
            ps.Add(code_entp);
            MrDTO[] rt = si.invokeList<MrDTO>("GetMrDtoForOPTree", ps.ToArray());
            return rt;
        }
        /// <summary>
        /// 获取指定病人医疗文件DTO
        /// 助手使用
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="id_mrcactm"></param>
        /// <param name="code_entp"></param>
        /// <param name="paramtype"></param>
        /// <param name="docornur"></param>
        /// <returns></returns>
        public MrDTO[] GetMrDtoForHelperTree(string id_ent, string id_mrcactm, string code_entp, string paramtype, string docornur)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(id_mrcactm);
            ps.Add(code_entp);
            ps.Add(paramtype);
            ps.Add(docornur);
            MrDTO[] rt = si.invokeList<MrDTO>("GetMrDtoForHelperTree", ps.ToArray());
            return rt;
        }
        /// <summary>
        /// 获取指定病人医疗文件DTO
        /// 既往病例使用
        /// </summary>
        /// <param name="idEnt"></param>
        /// <param name="idMrcactm"></param>
        /// <param name="codeEntp"></param>
        /// <param name="paramtype"></param>
        /// <param name="docornur"></param>
        /// <returns></returns>
        public MrDTO[] GetMrDtoForPastTree(string idEnt, string idMrcactm, string codeEntp, string paramtype, string docornur)
        {
            List<object> ps = new List<object>();
            ps.Add(idEnt);
            ps.Add(idMrcactm);
            ps.Add(codeEntp);
            ps.Add(paramtype);
            ps.Add(docornur);
            MrDTO[] rt = si.invokeList<MrDTO>("GetMrDtoForPastTree", ps.ToArray());
            return rt;
        }

        /// <summary>
        /// 根据用户id  和  签名密码获取64位base码
        /// </summary>
        /// <param name="userid"></param>
        /// <param name="password"></param>
        /// <returns></returns>
        public String GetBase64ByUserIdAndPassWord(String userid, String password)
        {
            List<object> ps = new List<object>();
            ps.Add(userid);
            ps.Add(password);
            string rt = si.invoke<String>("GetBase64ByUserIdAndPassWord", ps.ToArray());
            return rt;
        }
        /// <summary>
        /// 根据用户id  和  签名密码 
        /// 校验密码是否正确
        /// </summary>
        /// <param name="userid"></param>
        /// <param name="password"></param>
        /// <returns></returns>
        public bool CheckPassWord(string userid, string password)
        {
            List<object> ps = new List<object>();
            ps.Add(userid);
            ps.Add(password);
            bool rt = si.invoke<bool>("CheckPassWord", ps.ToArray());
            return rt;
        }
        /// <summary>
        /// 根据用户id 判断该用户是否设置过签名密码  和 签名图片
        /// </summary>
        /// <param name="userid"></param>
        /// <returns></returns>
        public bool IsPicExist(String userid)
        {
            List<object> ps = new List<object>();
            ps.Add(userid);
            bool rt = si.invoke<bool>("IsPicExist", ps.ToArray());
            return rt;
        }

        /// <summary>
        /// 根据用户id 获取图片
        /// </summary>
        /// <param name="userid"></param>
        /// <param name="password"></param>
        /// <returns></returns>
        public FMap2 GetPicExist(String userid, String password)
        {
            List<object> ps = new List<object>();
            ps.Add(userid);
            ps.Add(password);
            FMap2 dict = si.invoke<FMap2>("getPicExist", ps.ToArray());
            return dict;
            
        }

        public string GetPicByUserId(string userid)
        {
            List<object> ps = new List<object>();
            ps.Add(userid);
            string rt = si.invoke<String>("GetPicByUserId", ps.ToArray());
            return rt;
        }

        /// <summary>
        /// 根据就诊号判断该患者是否可以执行完成书写操作
        /// </summary>
        /// <param name="idEnt"></param>
        /// <returns></returns>
        public string CanCompleteEdit(string idEnt)
        {
            List<object> ps = new List<object>();
            ps.Add(idEnt);
            string rt = si.invoke<String>("CanCompleteEdit", ps.ToArray());
            return rt;
        }

        public MrDTO[] GetMrDtoForNurTree(string idEnt, string idMrcactm, string codeEntp)
        {
            List<object> ps = new List<object>();
            ps.Add(idEnt);
            ps.Add(idMrcactm);
            ps.Add(codeEntp);
            MrDTO[] rt = si.invokeList<MrDTO>("getMrDtoForNurTree", ps.ToArray());
            return rt;
        }

        public CiMrDO[] GetCiMrByIdMr(string idMr)
        {
            List<object> ps = new List<object>();
            ps.Add(idMr);
            CiMrDO[] rt = si.invokeList<CiMrDO>("getCiMrByIdMr", ps.ToArray());
            return rt;
        }
        public CiMrDO[] getAllCiMrList(String idEnt)
        {
            List<object> ps = new List<object>();
            ps.Add(idEnt);
            CiMrDO[] rt = si.invokeList<CiMrDO>("getAllCiMrList", ps.ToArray());
            return rt;
        }
        public CiMrDO[] getAllCiMrListButDelete(String idEnt)
        {
            List<object> ps = new List<object>();
            ps.Add(idEnt);
            CiMrDO[] rt = si.invokeList<CiMrDO>("getAllCiMrListButDelete", ps.ToArray());
            return rt;
        }

     /*
	 * 根据患者就诊号，获取患者所有的病历文书
	 */
	public CiMrDO[] GetPatCiMrList (String id_ent)
	{
        List<object> ps = new List<object>();
        ps.Add(id_ent);
        CiMrDO[] rt = si.invokeList<CiMrDO>("getPatCiMrList", ps.ToArray());
        return rt;
		
	}
    }
}
