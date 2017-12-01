package iih.ci.mr.nu.script.fileinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 文件信息 DTO数据 
 * 
 */
public class FileInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 文件信息主键
	 * @return String
	 */
	public String getId_fileinfo() {
		return ((String) getAttrVal("Id_fileinfo"));
	}
	/**
	 * 文件信息主键
	 * @param Id_fileinfo
	 */
	public void setId_fileinfo(String Id_fileinfo) {
		setAttrVal("Id_fileinfo", Id_fileinfo);
	}
	/**
	 * 文件名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 文件名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 文件内容
	 * @return byte[]
	 */
	public byte[] getContent() {
		return ((byte[]) getAttrVal("Content"));
	}
	/**
	 * 文件内容
	 * @param Content
	 */
	public void setContent(byte[] Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 文件路径
	 * @return String
	 */
	public String getPath() {
		return ((String) getAttrVal("Path"));
	}
	/**
	 * 文件路径
	 * @param Path
	 */
	public void setPath(String Path) {
		setAttrVal("Path", Path);
	}
}