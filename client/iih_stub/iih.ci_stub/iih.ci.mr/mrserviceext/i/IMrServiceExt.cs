using System;
using iih.bd.srv.dto.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using iih.ci.mr.mrdocrefvalue.d;
using iih.ci.mr.cimrfs.d;
using iih.ci.mr.cimr.d;
using iih.ci.mr.mrfs.d;

namespace iih.ci.mr.mrserviceext.i {
    public interface IMrServiceExt {  
        /// 根据自定义分类获取病历文书 
         CiMrDO[] GetMrByMrCa( string id_ent , string id_mrcactm , string code_entp , string docornur );
        /// 获取指定病人医疗文件DTO 
         MrDTO[] GetMrDtoForTree( string id_ent , string id_mrcactm , string code_entp , string paramtype , string docornur );
        /// 批量获取病历记录 
         CiMrDO[] GetAuditMrs( string id_dep , string id_user , string auditStatus , string docornur );
        /// 完成病历 
         FBoolean CompleteEdit( string id_ent );
        /// 保存引用 
         MrDocRefValueDO[] SaveSourceReferences( MrDocRefValueDO[] ReferenceValues );
         /// 根据就诊号获取已删除的文书 
         CiMrDO[] GetHasDelMrByEnt(string id_ent);
        /// <summary>
        /// 清空引用，逻辑删除
        /// </summary>
        /// <param name="id_ent"></param>
         void ClearSourceReferences(String id_ent);

        /// 获取最新病程记录 
         CiMrFsDO GetLeastPgNote( string id_mrcactm , string code_entp , string id_ent );
        /// 获取医疗记录数据流 
         MrfsDTO[] GetMrfsByDos( CiMrDO[] mrdos );
         /// <summary>
         /// 获取指定病人医疗文件DTO   
         /// 门诊医生站使用
         /// </summary>
         /// <param name="id_ent"></param>
         /// <param name="id_mrcactm"></param>
         /// <param name="code_entp"></param>
         /// <returns></returns>
         MrDTO[] GetMrDtoForOpTree(String id_ent, String id_mrcactm, String code_entp);
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
         MrDTO[] GetMrDtoForHelperTree(String id_ent, String id_mrcactm, String code_entp, String paramtype,
             String docornur);
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
         MrDTO[] GetMrDtoForPastTree(String idEnt, String idMrcactm, String codeEntp, String paramtype,
             String docornur);
        /// <summary>
         /// 根据用户id  和  签名密码获取64位base码
        /// </summary>
        /// <param name="userid"></param>
        /// <param name="password"></param>
        /// <returns></returns>
        String GetBase64ByUserIdAndPassWord(String userid, String password);
        /// <summary>
        /// 根据用户id  和  签名密码 
        /// 校验密码是否正确
        /// </summary>
        /// <param name="userid"></param>
        /// <param name="password"></param>
        /// <returns></returns>
        bool CheckPassWord(String userid , String password);
        /// <summary>
        /// 根据用户id 判断该用户是否设置过签名密码  和 签名图片
        /// </summary>
        /// <param name="userid"></param>
        /// <returns></returns>
        bool IsPicExist(String userid);
        /// <summary>
        /// 根据用户id 获取图片
        /// </summary>
        /// <param name="userid"></param>
        /// <param name="password"></param>
        /// <returns></returns>
        FMap2 GetPicExist(String userid, String password);
        /// <summary>
        /// 根据用户id 获取图片
        /// </summary>
        /// <param name="userid"></param>
        /// <returns></returns>
        string GetPicByUserId(String userid);
        /// <summary>
        /// 根据就诊号判断该患者是否可以执行完成书写操作
        /// </summary>
        /// <param name="idEnt"></param>
        /// <returns></returns>
        string CanCompleteEdit(String idEnt);
        /// <summary>
        /// 获取指定病人医疗文件DTO   
        /// 护士工作站使用
        /// </summary>
        /// <param name="idEnt"></param>
        /// <param name="idMrcactm"></param>
        /// <param name="codeEntp"></param>
        /// <returns></returns>
        MrDTO[] GetMrDtoForNurTree(String idEnt, String idMrcactm, String codeEntp);
        /// <summary>
        /// 根据文书号获取文书信息
        /// </summary>
        /// <param name="idMr"></param>
        /// <returns></returns>
        CiMrDO[] GetCiMrByIdMr(string idMr);
        /// <summary>
        /// 根据就诊号查询所有的病历文书列表
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        CiMrDO[] getAllCiMrList(String idEnt);
        /// <summary>
        /// 根据就诊号查询所有的病历文书列表
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        CiMrDO[] getAllCiMrListButDelete(String idEnt);

        /// <summary>
        /// 根据患者就诊号，获取患者所有病例文书
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        CiMrDO[] GetPatCiMrList(String id_ent);
    }
}
