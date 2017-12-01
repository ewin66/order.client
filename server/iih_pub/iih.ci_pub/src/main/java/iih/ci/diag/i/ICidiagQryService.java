package iih.ci.diag.i;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.diag.dto.d.IpViewDiagDTO;
import xap.mw.core.data.BizException;
import xap.sys.xbd.udi.d.UdidocDO;

public interface ICidiagQryService {
	
	public abstract IpViewDiagDTO [] getCiDiagItemDOlist(String id_ent)throws BizException;
    
	/**
	 * getCiDiagDTO
	 * @param aggdos
	 * @throws BizException
	 */
	@Deprecated
    public abstract void getCiDiagDTO(DIDTO[] aggdos) throws BizException;
    
    /**
     * QueryCiDiagDTO
     * @param id
     * @return
     * @throws BizException
     */
	@Deprecated
    public abstract DIDTO[] QueryCiDiagDTO(String id,String type) throws BizException;
    
    /**
	  * 病案首页诊断显示
	  * @param id_ent
	  * @return
	  * @throws BizException
	  */
	 public abstract DIDTO[] getMedicalRecordDiag(String id_ent)throws BizException;
	 /**
	  * 取得疾病诊断 信息
	  * @param value 名称 拼音码 五笔码
	  * @return
	  * @throws BizException
	  */
	 public abstract DiagDefDO[] getDiagDefDOS(String value)throws BizException;
     /**
      * 诊断类型
      * param  id_en 就诊号
      * param  type  门诊 0    住院  1
      * @return UdidocDO【】
      * @throws BizException
      */
	 public abstract UdidocDO[] getDiType(String id_en,String type)throws BizException;
     /**
      * 诊断参数 中医 西医
      * @return
      * @throws BizException
      */
	 public abstract String getParamType()throws BizException;
	 
	 /**
	  * 根据 就诊查询所有诊断
	  * @return
	  * @throws BizException
	  */
	 @Deprecated
	 public abstract CidiagAggDO getCidiagAggDOIdEnAndDiTp(String id_en,String id_ditp) throws BizException;
     
	 /**
      * 根据就诊取得所有诊断信息
      * @param id_en
      * @return CidiagAggDO[]
      * @throws BizException
      */
      
	 public abstract CidiagAggDO[] getIdEntCiDiS(String id_en)throws BizException;
     /**
      *本次就诊的最新诊断
      * @param id_en
      * @return
      * @throws BizException
      */
     public abstract CidiagAggDO[] getLastCiDiags(String id_en) throws BizException;
     /**
      * 当前最新诊断的主诊断（id_en）
      * @param id_en
      * @param entp_code
      * @return
      * @throws BizException
      */
    public abstract CiDiagItemDO getCiDiagItemDO(String id_en,String entp_code)throws BizException;
    
    /**
     * 获取当前就诊对应的诊断
     * @param id_en 就诊id
     * @param sd_ditp 诊断类型编码
     * @return 本次就诊指定类型的诊断
     * @throws BizException
     */
    public CiDiagItemDO[] getCiDiagItems(String id_en, String sd_ditp) throws BizException ;
    
    /**
     * 获取当前就诊的保外诊断明细集合
     * @param id_en 就诊id
     * @return
     * @throws BizException
     */
    public CiDiagItemDO[] getHpjudgetpCiDiagItems(String id_en) throws BizException;
    
}
