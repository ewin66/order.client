package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊输血申请就诊信息DTO DTO数据 
 * 
 */
public class IEOpBtOrEnDTO extends BaseDTO {
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
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 生日
	 * @return FDate
	 */
	public FDate getBirthday() {
		return ((FDate) getAttrVal("Birthday"));
	}	
	/**
	 * 生日
	 * @param Birthday
	 */
	public void setBirthday(FDate Birthday) {
		setAttrVal("Birthday", Birthday);
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
	 * 地址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}	
	/**
	 * 地址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
	/**
	 * 婚姻状况编码
	 * @return String
	 */
	public String getMarriagecode() {
		return ((String) getAttrVal("Marriagecode"));
	}	
	/**
	 * 婚姻状况编码
	 * @param Marriagecode
	 */
	public void setMarriagecode(String Marriagecode) {
		setAttrVal("Marriagecode", Marriagecode);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getContacttel() {
		return ((String) getAttrVal("Contacttel"));
	}	
	/**
	 * 联系人电话
	 * @param Contacttel
	 */
	public void setContacttel(String Contacttel) {
		setAttrVal("Contacttel", Contacttel);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getContactname() {
		return ((String) getAttrVal("Contactname"));
	}	
	/**
	 * 联系人姓名
	 * @param Contactname
	 */
	public void setContactname(String Contactname) {
		setAttrVal("Contactname", Contactname);
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
	 * 身份证号
	 * @return String
	 */
	public String getSocialno() {
		return ((String) getAttrVal("Socialno"));
	}	
	/**
	 * 身份证号
	 * @param Socialno
	 */
	public void setSocialno(String Socialno) {
		setAttrVal("Socialno", Socialno);
	}
	/**
	 * 献血证号
	 * @return String
	 */
	public String getBloodno() {
		return ((String) getAttrVal("Bloodno"));
	}	
	/**
	 * 献血证号
	 * @param Bloodno
	 */
	public void setBloodno(String Bloodno) {
		setAttrVal("Bloodno", Bloodno);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getPbarcode() {
		return ((String) getAttrVal("Pbarcode"));
	}	
	/**
	 * 就诊号
	 * @param Pbarcode
	 */
	public void setPbarcode(String Pbarcode) {
		setAttrVal("Pbarcode", Pbarcode);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getWardno() {
		return ((String) getAttrVal("Wardno"));
	}	
	/**
	 * 病区编码
	 * @param Wardno
	 */
	public void setWardno(String Wardno) {
		setAttrVal("Wardno", Wardno);
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
	public String getBedno() {
		return ((String) getAttrVal("Bedno"));
	}	
	/**
	 * 床号
	 * @param Bedno
	 */
	public void setBedno(String Bedno) {
		setAttrVal("Bedno", Bedno);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 联系电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 病人信息隐私级别编码
	 * @return String
	 */
	public String getPrivatecode() {
		return ((String) getAttrVal("Privatecode"));
	}	
	/**
	 * 病人信息隐私级别编码
	 * @param Privatecode
	 */
	public void setPrivatecode(String Privatecode) {
		setAttrVal("Privatecode", Privatecode);
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
	 * 费用类别
	 * @return String
	 */
	public String getFeeclass() {
		return ((String) getAttrVal("Feeclass"));
	}	
	/**
	 * 费用类别
	 * @param Feeclass
	 */
	public void setFeeclass(String Feeclass) {
		setAttrVal("Feeclass", Feeclass);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}	
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 就诊类别
	 * @return String
	 */
	public String getJztype() {
		return ((String) getAttrVal("Jztype"));
	}	
	/**
	 * 就诊类别
	 * @param Jztype
	 */
	public void setJztype(String Jztype) {
		setAttrVal("Jztype", Jztype);
	}
	/**
	 * 就诊/住院时间
	 * @return FDateTime
	 */
	public FDateTime getVisit_date() {
		return ((FDateTime) getAttrVal("Visit_date"));
	}	
	/**
	 * 就诊/住院时间
	 * @param Visit_date
	 */
	public void setVisit_date(FDateTime Visit_date) {
		setAttrVal("Visit_date", Visit_date);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}	
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getComment1() {
		return ((String) getAttrVal("Comment1"));
	}	
	/**
	 * 备注
	 * @param Comment1
	 */
	public void setComment1(String Comment1) {
		setAttrVal("Comment1", Comment1);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getApplytime() {
		return ((FDateTime) getAttrVal("Applytime"));
	}	
	/**
	 * 申请时间
	 * @param Applytime
	 */
	public void setApplytime(FDateTime Applytime) {
		setAttrVal("Applytime", Applytime);
	}
	/**
	 * 用血紧急程度
	 * @return String
	 */
	public String getEmergencycode() {
		return ((String) getAttrVal("Emergencycode"));
	}	
	/**
	 * 用血紧急程度
	 * @param Emergencycode
	 */
	public void setEmergencycode(String Emergencycode) {
		setAttrVal("Emergencycode", Emergencycode);
	}
	/**
	 * 紧急程度
	 * @return String
	 */
	public String getEmergencyname() {
		return ((String) getAttrVal("Emergencyname"));
	}	
	/**
	 * 紧急程度
	 * @param Emergencyname
	 */
	public void setEmergencyname(String Emergencyname) {
		setAttrVal("Emergencyname", Emergencyname);
	}
	/**
	 * 申请血量
	 * @return String
	 */
	public String getBloodamount() {
		return ((String) getAttrVal("Bloodamount"));
	}	
	/**
	 * 申请血量
	 * @param Bloodamount
	 */
	public void setBloodamount(String Bloodamount) {
		setAttrVal("Bloodamount", Bloodamount);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getBloodunit() {
		return ((String) getAttrVal("Bloodunit"));
	}	
	/**
	 * 单位
	 * @param Bloodunit
	 */
	public void setBloodunit(String Bloodunit) {
		setAttrVal("Bloodunit", Bloodunit);
	}
	/**
	 * 用血时间
	 * @return FDateTime
	 */
	public FDateTime getUsetime() {
		return ((FDateTime) getAttrVal("Usetime"));
	}	
	/**
	 * 用血时间
	 * @param Usetime
	 */
	public void setUsetime(FDateTime Usetime) {
		setAttrVal("Usetime", Usetime);
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
	 * 输血品种代码
	 * @return String
	 */
	public String getBloodcode() {
		return ((String) getAttrVal("Bloodcode"));
	}	
	/**
	 * 输血品种代码
	 * @param Bloodcode
	 */
	public void setBloodcode(String Bloodcode) {
		setAttrVal("Bloodcode", Bloodcode);
	}
	/**
	 * 输血品种名称
	 * @return String
	 */
	public String getBloodname() {
		return ((String) getAttrVal("Bloodname"));
	}	
	/**
	 * 输血品种名称
	 * @param Bloodname
	 */
	public void setBloodname(String Bloodname) {
		setAttrVal("Bloodname", Bloodname);
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
	 * 申请Rh（D）血型编码
	 * @return String
	 */
	public String getRhcode() {
		return ((String) getAttrVal("Rhcode"));
	}	
	/**
	 * 申请Rh（D）血型编码
	 * @param Rhcode
	 */
	public void setRhcode(String Rhcode) {
		setAttrVal("Rhcode", Rhcode);
	}
	/**
	 * 申请Rh（D）血型值
	 * @return String
	 */
	public String getRhvalue() {
		return ((String) getAttrVal("Rhvalue"));
	}	
	/**
	 * 申请Rh（D）血型值
	 * @param Rhvalue
	 */
	public void setRhvalue(String Rhvalue) {
		setAttrVal("Rhvalue", Rhvalue);
	}
	/**
	 * 申请医师编码
	 * @return String
	 */
	public String getApplydoctor() {
		return ((String) getAttrVal("Applydoctor"));
	}	
	/**
	 * 申请医师编码
	 * @param Applydoctor
	 */
	public void setApplydoctor(String Applydoctor) {
		setAttrVal("Applydoctor", Applydoctor);
	}
	/**
	 * 申请医师姓名
	 * @return String
	 */
	public String getApplydoctorname() {
		return ((String) getAttrVal("Applydoctorname"));
	}	
	/**
	 * 申请医师姓名
	 * @param Applydoctorname
	 */
	public void setApplydoctorname(String Applydoctorname) {
		setAttrVal("Applydoctorname", Applydoctorname);
	}
	/**
	 * 申请科室编码
	 * @return String
	 */
	public String getApplydept() {
		return ((String) getAttrVal("Applydept"));
	}	
	/**
	 * 申请科室编码
	 * @param Applydept
	 */
	public void setApplydept(String Applydept) {
		setAttrVal("Applydept", Applydept);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getApplydeptname() {
		return ((String) getAttrVal("Applydeptname"));
	}	
	/**
	 * 申请科室名称
	 * @param Applydeptname
	 */
	public void setApplydeptname(String Applydeptname) {
		setAttrVal("Applydeptname", Applydeptname);
	}
	/**
	 * 审核（主治）医师编码
	 * @return String
	 */
	public String getRespdoctor() {
		return ((String) getAttrVal("Respdoctor"));
	}	
	/**
	 * 审核（主治）医师编码
	 * @param Respdoctor
	 */
	public void setRespdoctor(String Respdoctor) {
		setAttrVal("Respdoctor", Respdoctor);
	}
	/**
	 * 审核（主治）医师姓名
	 * @return String
	 */
	public String getRespdoctorname() {
		return ((String) getAttrVal("Respdoctorname"));
	}	
	/**
	 * 审核（主治）医师姓名
	 * @param Respdoctorname
	 */
	public void setRespdoctorname(String Respdoctorname) {
		setAttrVal("Respdoctorname", Respdoctorname);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getYz_no() {
		return ((String) getAttrVal("Yz_no"));
	}	
	/**
	 * 医嘱号
	 * @param Yz_no
	 */
	public void setYz_no(String Yz_no) {
		setAttrVal("Yz_no", Yz_no);
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