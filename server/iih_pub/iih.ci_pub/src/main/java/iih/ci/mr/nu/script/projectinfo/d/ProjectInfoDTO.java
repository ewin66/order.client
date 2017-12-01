package iih.ci.mr.nu.script.projectinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 项目信息 DTO数据 
 * 
 */
public class ProjectInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目主键
	 * @return String
	 */
	public String getId_project() {
		return ((String) getAttrVal("Id_project"));
	}
	/**
	 * 项目主键
	 * @param Id_project
	 */
	public void setId_project(String Id_project) {
		setAttrVal("Id_project", Id_project);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 路径
	 * @return String
	 */
	public String getPath() {
		return ((String) getAttrVal("Path"));
	}
	/**
	 * 路径
	 * @param Path
	 */
	public void setPath(String Path) {
		setAttrVal("Path", Path);
	}
	/**
	 * 文件类型
	 * @return Integer
	 */
	public Integer getType() {
		return ((Integer) getAttrVal("Type"));
	}
	/**
	 * 文件类型
	 * @param Type
	 */
	public void setType(Integer Type) {
		setAttrVal("Type", Type);
	}
	/**
	 * 内容
	 * @return byte[]
	 */
	public byte[] getContent() {
		return ((byte[]) getAttrVal("Content"));
	}
	/**
	 * 内容
	 * @param Content
	 */
	public void setContent(byte[] Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 输出路径
	 * @return String
	 */
	public String getOutputpath() {
		return ((String) getAttrVal("Outputpath"));
	}
	/**
	 * 输出路径
	 * @param Outputpath
	 */
	public void setOutputpath(String Outputpath) {
		setAttrVal("Outputpath", Outputpath);
	}
	/**
	 * 类文件列表
	 * @return FArrayList
	 */
	public FArrayList getFilelist() {
		return ((FArrayList) getAttrVal("Filelist"));
	}
	/**
	 * 类文件列表
	 * @param Filelist
	 */
	public void setFilelist(FArrayList Filelist) {
		setAttrVal("Filelist", Filelist);
	}
}