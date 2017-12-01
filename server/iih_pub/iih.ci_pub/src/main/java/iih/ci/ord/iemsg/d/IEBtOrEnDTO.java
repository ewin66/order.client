package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE输血申请就诊信息DTO DTO数据 
 * 
 */
public class IEBtOrEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE输血申请就诊主键标识
	 * @return String
	 */
	public String getId_iebtoren() {
		return ((String) getAttrVal("Id_iebtoren"));
	}	
	/**
	 * IE输血申请就诊主键标识
	 * @param Id_iebtoren
	 */
	public void setId_iebtoren(String Id_iebtoren) {
		setAttrVal("Id_iebtoren", Id_iebtoren);
	}
	/**
	 * IE血液要求集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIebtdemands() {
		return ((FArrayList2) getAttrVal("Iebtdemands"));
	}	
	/**
	 * IE血液要求集合
	 * @param Iebtdemands
	 */
	public void setIebtdemands(FArrayList2 Iebtdemands) {
		setAttrVal("Iebtdemands", Iebtdemands);
	}
	/**
	 * IE输血诊断集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIebtdiags() {
		return ((FArrayList2) getAttrVal("Iebtdiags"));
	}	
	/**
	 * IE输血诊断集合
	 * @param Iebtdiags
	 */
	public void setIebtdiags(FArrayList2 Iebtdiags) {
		setAttrVal("Iebtdiags", Iebtdiags);
	}
	/**
	 * IE输血病史集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIebtillhiss() {
		return ((FArrayList2) getAttrVal("Iebtillhiss"));
	}	
	/**
	 * IE输血病史集合
	 * @param Iebtillhiss
	 */
	public void setIebtillhiss(FArrayList2 Iebtillhiss) {
		setAttrVal("Iebtillhiss", Iebtillhiss);
	}
	/**
	 * IE输血数值检验项目集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIebtnumlisitms() {
		return ((FArrayList2) getAttrVal("Iebtnumlisitms"));
	}	
	/**
	 * IE输血数值检验项目集合
	 * @param Iebtnumlisitms
	 */
	public void setIebtnumlisitms(FArrayList2 Iebtnumlisitms) {
		setAttrVal("Iebtnumlisitms", Iebtnumlisitms);
	}
	/**
	 * IE输血cd检验项目集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIebtcdlisitms() {
		return ((FArrayList2) getAttrVal("Iebtcdlisitms"));
	}	
	/**
	 * IE输血cd检验项目集合
	 * @param Iebtcdlisitms
	 */
	public void setIebtcdlisitms(FArrayList2 Iebtcdlisitms) {
		setAttrVal("Iebtcdlisitms", Iebtcdlisitms);
	}
	/**
	 * IE输血字串检验项目集合
	 * @return FArrayList2
	 */
	public FArrayList2 getIebtstrlisitms() {
		return ((FArrayList2) getAttrVal("Iebtstrlisitms"));
	}	
	/**
	 * IE输血字串检验项目集合
	 * @param Iebtstrlisitms
	 */
	public void setIebtstrlisitms(FArrayList2 Iebtstrlisitms) {
		setAttrVal("Iebtstrlisitms", Iebtstrlisitms);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatientid() {
		return ((String) getAttrVal("Patientid"));
	}	
	/**
	 * 患者ID
	 * @param Patientid
	 */
	public void setPatientid(String Patientid) {
		setAttrVal("Patientid", Patientid);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSexid() {
		return ((String) getAttrVal("Sexid"));
	}	
	/**
	 * 性别
	 * @param Sexid
	 */
	public void setSexid(String Sexid) {
		setAttrVal("Sexid", Sexid);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 生日
	 * @return FDate
	 */
	public FDate getBirthdaydate() {
		return ((FDate) getAttrVal("Birthdaydate"));
	}	
	/**
	 * 生日
	 * @param Birthdaydate
	 */
	public void setBirthdaydate(FDate Birthdaydate) {
		setAttrVal("Birthdaydate", Birthdaydate);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getPatientseqnum() {
		return ((String) getAttrVal("Patientseqnum"));
	}	
	/**
	 * 就诊号
	 * @param Patientseqnum
	 */
	public void setPatientseqnum(String Patientseqnum) {
		setAttrVal("Patientseqnum", Patientseqnum);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getAdmiss_times() {
		return ((String) getAttrVal("Admiss_times"));
	}	
	/**
	 * 就诊次数
	 * @param Admiss_times
	 */
	public void setAdmiss_times(String Admiss_times) {
		setAttrVal("Admiss_times", Admiss_times);
	}
	/**
	 * 病人科室id
	 * @return String
	 */
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	/**
	 * 病人科室id
	 * @param Deptcode
	 */
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	/**
	 * 病人科室名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getWardcode() {
		return ((String) getAttrVal("Wardcode"));
	}	
	/**
	 * 病区编码
	 * @param Wardcode
	 */
	public void setWardcode(String Wardcode) {
		setAttrVal("Wardcode", Wardcode);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getWardname() {
		return ((String) getAttrVal("Wardname"));
	}	
	/**
	 * 病区名称
	 * @param Wardname
	 */
	public void setWardname(String Wardname) {
		setAttrVal("Wardname", Wardname);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBedcode() {
		return ((String) getAttrVal("Bedcode"));
	}	
	/**
	 * 床号
	 * @param Bedcode
	 */
	public void setBedcode(String Bedcode) {
		setAttrVal("Bedcode", Bedcode);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}	
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTelephone() {
		return ((String) getAttrVal("Telephone"));
	}	
	/**
	 * 联系电话
	 * @param Telephone
	 */
	public void setTelephone(String Telephone) {
		setAttrVal("Telephone", Telephone);
	}
	/**
	 * 地址
	 * @return String
	 */
	public String getHomeaddress() {
		return ((String) getAttrVal("Homeaddress"));
	}	
	/**
	 * 地址
	 * @param Homeaddress
	 */
	public void setHomeaddress(String Homeaddress) {
		setAttrVal("Homeaddress", Homeaddress);
	}
	/**
	 * 出生地
	 * @return String
	 */
	public String getBirthplace() {
		return ((String) getAttrVal("Birthplace"));
	}	
	/**
	 * 出生地
	 * @param Birthplace
	 */
	public void setBirthplace(String Birthplace) {
		setAttrVal("Birthplace", Birthplace);
	}
	/**
	 * 婚姻状况编码
	 * @return String
	 */
	public String getMarrycode() {
		return ((String) getAttrVal("Marrycode"));
	}	
	/**
	 * 婚姻状况编码
	 * @param Marrycode
	 */
	public void setMarrycode(String Marrycode) {
		setAttrVal("Marrycode", Marrycode);
	}
	/**
	 * 病人信息隐私
	 * @return String
	 */
	public String getBrxxsycode() {
		return ((String) getAttrVal("Brxxsycode"));
	}	
	/**
	 * 病人信息隐私
	 * @param Brxxsycode
	 */
	public void setBrxxsycode(String Brxxsycode) {
		setAttrVal("Brxxsycode", Brxxsycode);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getR_tel() {
		return ((String) getAttrVal("R_tel"));
	}	
	/**
	 * 联系人电话
	 * @param R_tel
	 */
	public void setR_tel(String R_tel) {
		setAttrVal("R_tel", R_tel);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getR_name() {
		return ((String) getAttrVal("R_name"));
	}	
	/**
	 * 联系人姓名
	 * @param R_name
	 */
	public void setR_name(String R_name) {
		setAttrVal("R_name", R_name);
	}
	/**
	 * 就诊类别
	 * @return String
	 */
	public String getAdmiss_type() {
		return ((String) getAttrVal("Admiss_type"));
	}	
	/**
	 * 就诊类别
	 * @param Admiss_type
	 */
	public void setAdmiss_type(String Admiss_type) {
		setAttrVal("Admiss_type", Admiss_type);
	}
	/**
	 * 费用类别
	 * @return String
	 */
	public String getFbcode() {
		return ((String) getAttrVal("Fbcode"));
	}	
	/**
	 * 费用类别
	 * @param Fbcode
	 */
	public void setFbcode(String Fbcode) {
		setAttrVal("Fbcode", Fbcode);
	}
	/**
	 * 就诊/住院时间
	 * @return FDateTime
	 */
	public FDateTime getJzdate() {
		return ((FDateTime) getAttrVal("Jzdate"));
	}	
	/**
	 * 就诊/住院时间
	 * @param Jzdate
	 */
	public void setJzdate(FDateTime Jzdate) {
		setAttrVal("Jzdate", Jzdate);
	}
	/**
	 * 输血目的编码
	 * @return String
	 */
	public String getSxmdcode() {
		return ((String) getAttrVal("Sxmdcode"));
	}	
	/**
	 * 输血目的编码
	 * @param Sxmdcode
	 */
	public void setSxmdcode(String Sxmdcode) {
		setAttrVal("Sxmdcode", Sxmdcode);
	}
	/**
	 * 输血目的描述
	 * @return String
	 */
	public String getSxmdname() {
		return ((String) getAttrVal("Sxmdname"));
	}	
	/**
	 * 输血目的描述
	 * @param Sxmdname
	 */
	public void setSxmdname(String Sxmdname) {
		setAttrVal("Sxmdname", Sxmdname);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}	
	/**
	 * 域id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
	/**
	 * 输血品种代码
	 * @return String
	 */
	public String getSxbzcode() {
		return ((String) getAttrVal("Sxbzcode"));
	}	
	/**
	 * 输血品种代码
	 * @param Sxbzcode
	 */
	public void setSxbzcode(String Sxbzcode) {
		setAttrVal("Sxbzcode", Sxbzcode);
	}
	/**
	 * 输血品种名称
	 * @return String
	 */
	public String getSxbzname() {
		return ((String) getAttrVal("Sxbzname"));
	}	
	/**
	 * 输血品种名称
	 * @param Sxbzname
	 */
	public void setSxbzname(String Sxbzname) {
		setAttrVal("Sxbzname", Sxbzname);
	}
	/**
	 * 申请ABO血型编码
	 * @return String
	 */
	public String getAbocode() {
		return ((String) getAttrVal("Abocode"));
	}	
	/**
	 * 申请ABO血型编码
	 * @param Abocode
	 */
	public void setAbocode(String Abocode) {
		setAttrVal("Abocode", Abocode);
	}
	/**
	 * 申请ABO血型值
	 * @return String
	 */
	public String getAbovalue() {
		return ((String) getAttrVal("Abovalue"));
	}	
	/**
	 * 申请ABO血型值
	 * @param Abovalue
	 */
	public void setAbovalue(String Abovalue) {
		setAttrVal("Abovalue", Abovalue);
	}
	/**
	 * 申请Rh(D)编码
	 * @return String
	 */
	public String getRhcode() {
		return ((String) getAttrVal("Rhcode"));
	}	
	/**
	 * 申请Rh(D)编码
	 * @param Rhcode
	 */
	public void setRhcode(String Rhcode) {
		setAttrVal("Rhcode", Rhcode);
	}
	/**
	 * 申请Rh(D)值
	 * @return String
	 */
	public String getRhvalue() {
		return ((String) getAttrVal("Rhvalue"));
	}	
	/**
	 * 申请Rh(D)值
	 * @param Rhvalue
	 */
	public void setRhvalue(String Rhvalue) {
		setAttrVal("Rhvalue", Rhvalue);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getSqdcode() {
		return ((String) getAttrVal("Sqdcode"));
	}	
	/**
	 * 申请单号
	 * @param Sqdcode
	 */
	public void setSqdcode(String Sqdcode) {
		setAttrVal("Sqdcode", Sqdcode);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getSq_memo() {
		return ((String) getAttrVal("Sq_memo"));
	}	
	/**
	 * 备注
	 * @param Sq_memo
	 */
	public void setSq_memo(String Sq_memo) {
		setAttrVal("Sq_memo", Sq_memo);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getSqdate() {
		return ((FDateTime) getAttrVal("Sqdate"));
	}	
	/**
	 * 申请时间
	 * @param Sqdate
	 */
	public void setSqdate(FDateTime Sqdate) {
		setAttrVal("Sqdate", Sqdate);
	}
	/**
	 * 紧急程度编码
	 * @return String
	 */
	public String getEmrgid() {
		return ((String) getAttrVal("Emrgid"));
	}	
	/**
	 * 紧急程度编码
	 * @param Emrgid
	 */
	public void setEmrgid(String Emrgid) {
		setAttrVal("Emrgid", Emrgid);
	}
	/**
	 * 紧急程度
	 * @return String
	 */
	public String getEmrgname() {
		return ((String) getAttrVal("Emrgname"));
	}	
	/**
	 * 紧急程度
	 * @param Emrgname
	 */
	public void setEmrgname(String Emrgname) {
		setAttrVal("Emrgname", Emrgname);
	}
	/**
	 * 申请血量
	 * @return String
	 */
	public String getSqxl() {
		return ((String) getAttrVal("Sqxl"));
	}	
	/**
	 * 申请血量
	 * @param Sqxl
	 */
	public void setSqxl(String Sqxl) {
		setAttrVal("Sqxl", Sqxl);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getDw() {
		return ((String) getAttrVal("Dw"));
	}	
	/**
	 * 单位
	 * @param Dw
	 */
	public void setDw(String Dw) {
		setAttrVal("Dw", Dw);
	}
	/**
	 * 用血时间
	 * @return FDateTime
	 */
	public FDateTime getYxdate() {
		return ((FDateTime) getAttrVal("Yxdate"));
	}	
	/**
	 * 用血时间
	 * @param Yxdate
	 */
	public void setYxdate(FDateTime Yxdate) {
		setAttrVal("Yxdate", Yxdate);
	}
	/**
	 * 申请医师编码
	 * @return String
	 */
	public String getSqdoctorcode() {
		return ((String) getAttrVal("Sqdoctorcode"));
	}	
	/**
	 * 申请医师编码
	 * @param Sqdoctorcode
	 */
	public void setSqdoctorcode(String Sqdoctorcode) {
		setAttrVal("Sqdoctorcode", Sqdoctorcode);
	}
	/**
	 * 申请医师姓名
	 * @return String
	 */
	public String getSqdoctorname() {
		return ((String) getAttrVal("Sqdoctorname"));
	}	
	/**
	 * 申请医师姓名
	 * @param Sqdoctorname
	 */
	public void setSqdoctorname(String Sqdoctorname) {
		setAttrVal("Sqdoctorname", Sqdoctorname);
	}
	/**
	 * 申请科室编码
	 * @return String
	 */
	public String getSqdeptcode() {
		return ((String) getAttrVal("Sqdeptcode"));
	}	
	/**
	 * 申请科室编码
	 * @param Sqdeptcode
	 */
	public void setSqdeptcode(String Sqdeptcode) {
		setAttrVal("Sqdeptcode", Sqdeptcode);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getSqdeptname() {
		return ((String) getAttrVal("Sqdeptname"));
	}	
	/**
	 * 申请科室名称
	 * @param Sqdeptname
	 */
	public void setSqdeptname(String Sqdeptname) {
		setAttrVal("Sqdeptname", Sqdeptname);
	}
	/**
	 * 审核（主治）医师编码
	 * @return String
	 */
	public String getShdoctorcode() {
		return ((String) getAttrVal("Shdoctorcode"));
	}	
	/**
	 * 审核（主治）医师编码
	 * @param Shdoctorcode
	 */
	public void setShdoctorcode(String Shdoctorcode) {
		setAttrVal("Shdoctorcode", Shdoctorcode);
	}
	/**
	 * 审核（主治）医师姓名
	 * @return String
	 */
	public String getShdoctorname() {
		return ((String) getAttrVal("Shdoctorname"));
	}	
	/**
	 * 审核（主治）医师姓名
	 * @param Shdoctorname
	 */
	public void setShdoctorname(String Shdoctorname) {
		setAttrVal("Shdoctorname", Shdoctorname);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getOrdercode() {
		return ((String) getAttrVal("Ordercode"));
	}	
	/**
	 * 医嘱号
	 * @param Ordercode
	 */
	public void setOrdercode(String Ordercode) {
		setAttrVal("Ordercode", Ordercode);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getOrgname() {
		return ((String) getAttrVal("Orgname"));
	}	
	/**
	 * 医疗机构名称
	 * @param Orgname
	 */
	public void setOrgname(String Orgname) {
		setAttrVal("Orgname", Orgname);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getOrgcode() {
		return ((String) getAttrVal("Orgcode"));
	}	
	/**
	 * 医疗机构编码
	 * @param Orgcode
	 */
	public void setOrgcode(String Orgcode) {
		setAttrVal("Orgcode", Orgcode);
	}
}