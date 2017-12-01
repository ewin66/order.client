package iih.ci.ord.ciordems.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;

/**
 * 医嘱医疗单 DTO数据 
 * 
 */
public class EmsHeadDO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	public String getId_srv(){
		return ((String) getAttrVal("Id_srv"));
	}
	public void setId_srv(String Id_srv){
		  setAttrVal("Id_srv",Id_srv);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 医嘱类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 医嘱类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 医疗单类型
	 * @return Integer
	 */
	public Integer getEmstype() {
		return ((Integer) getAttrVal("Emstype"));
	}
	/**
	 * 医疗单类型
	 * @param Emstype
	 */
	public void setEmstype(Integer Emstype) {
		setAttrVal("Emstype", Emstype);
	}
	/**
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 医嘱频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 用法要求描述
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}
	/**
	 * 用法要求描述
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法名称
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}
	/**
	 * 煎法名称
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 煎法要求名称
	 * @return String
	 */
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}
	/**
	 * 煎法要求名称
	 * @param Name_boildes
	 */
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
	}
	/**
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 代煎付数
	 * @return Integer
	 */
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}
	/**
	 * 代煎付数
	 * @param Orders_boil
	 */
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
	}
	/**
	 * 总数量
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}
	/**
	 * 总数量
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 医嘱编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 医嘱名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 医嘱内容
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 开立医生姓名
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 开立医生姓名
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 开立科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 医疗组
	 * @return String
	 */
	public String getId_wg_or() {
		return ((String) getAttrVal("Id_wg_or"));
	}
	/**
	 * 医疗组
	 * @param Id_wg_or
	 */
	public void setId_wg_or(String Id_wg_or) {
		setAttrVal("Id_wg_or", Id_wg_or);
	}
	/**
	 * 开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_begin_ui() {
		return ((FDateTime) getAttrVal("Dt_begin_ui"));
	}
	/**
	 * 开始日期
	 * @param Dt_begin_ui
	 */
	public void setDt_begin_ui(FDateTime Dt_begin_ui) {
		setAttrVal("Dt_begin_ui", Dt_begin_ui);
	}
	/**
	 * 结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end_ui() {
		return ((FDateTime) getAttrVal("Dt_end_ui"));
	}
	/**
	 * 结束日期
	 * @param Dt_end_ui
	 */
	public void setDt_end_ui(FDateTime Dt_end_ui) {
		setAttrVal("Dt_end_ui", Dt_end_ui);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	
	public void getPri(String Pri) {
		setAttrVal("Pri", Pri);
	}
	 
	
	public String getPri() {
		return ((String) getAttrVal("Pri"));
	}
	//====================
	
	 public FArrayList getEmsdrugitems()
     {
           return (FArrayList)getAttrVal("Emsdrugitems"); 
         
     }
	 
	 public void setEmsdrugitems(FArrayList Emsdrugitems )
     {
         
          setAttrVal("Emsdrugitems", Emsdrugitems);  
     }
	 
     public String getEmsrisitems()
     {
          return (String)getAttrVal("Emsrisitems"); 
    
     }
     
     public void setEmsrisitems(String Emsrisitems)
     {
       setAttrVal("Emsrisitems", Emsrisitems);  
     }
     
     /// <summary>
     /// 药品医疗单do
     /// </summary>
     /// <value>
     /// The emsdrugs.
     /// </value>
     /// Author:admin
     /// Date:2015-10-14
     public EmsDrugItemDO getEmsdrugs()
     {
       return (EmsDrugItemDO)getAttrVal("Emsdrugs");
        
     }
	public void setEmsdrugs(EmsDrugItemDO  Emsdrugs)
	{
	   setAttrVal("Emsdrugs",Emsdrugs); 
	   
	}
     /// <summary>
     ///检查医疗单do
     /// </summary>
     /// <value>
     /// The emsobs.
     /// </value>
     /// Author:admin
     /// Date:2015-10-14
     public EmsObsItemDO getEmsapobs()
     {
          return (EmsObsItemDO)getAttrVal("Emsapobs"); 
        
     }
     public void setEmsapobs(EmsObsItemDO Emsapobs)
     {
    
         setAttrVal("Emsapobs", Emsapobs); 
     }
     /// <summary>
     ///检验医疗单do
     /// </summary>
     /// <value>
     /// The emsobs.
     /// </value>
     public EmsObsItemDO getEmsaplab()
     {
        return (EmsObsItemDO)getAttrVal("Emsaplab");
         
     }
     
     public void  setEmsaplab(EmsObsItemDO Emsaplab)
     {
      
          setAttrVal("Emsaplab", Emsaplab); 
     }

      /// <summary>
     ///输血医疗单do
     /// </summary>
     /// <value>
     /// The Emsapbt.
     /// </value>
     public EsmBtItemDO getEmsapbt()
     {     
         return (EsmBtItemDO)getAttrVal("Emsapbt"); 
        
     } 
     public void setEmsapbt(EsmBtItemDO Emsapbt){
    	  setAttrVal("Emsapbt", Emsapbt);  
     }
 
     
      public EmsOpitemDO getEmsapop(){
    	  return (EmsOpitemDO)getAttrVal("EmsOpitemDO"); 
      }
      public void setEmsapop(EmsOpitemDO EmsOpitemDO){
    	  setAttrVal("EmsOpitemDO", EmsOpitemDO);  
      }
      
     
      public EmsPathgyItemDO getEmsappathgy(){
    	  return (EmsPathgyItemDO)getAttrVal("Emsappathgy"); 
      }
      public void setEmsappathgy(EmsPathgyItemDO Emsappathgy){
    	  setAttrVal("Emsappathgy", Emsappathgy);  
      }
      
    
      
      
      public EmsConsItemDO getEmsapcons(){
    	  return (EmsConsItemDO)getAttrVal("Emsapcons"); 
      }
      public void setEmsapcons(EmsConsItemDO Emsapcons){
    	  setAttrVal("Emsapcons", Emsapcons);  
      }
}