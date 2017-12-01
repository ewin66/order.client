package iih.ci.mr.nu.script.fileinfo.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface FileTypeEnum {

    @DmEnumDesc(name="项目文件",description="项目文件")
	public static final Integer PROJECT=0; //项目文件
    @DmEnumDesc(name="代码文件",description="代码文件")
	public static final Integer CODE=1; //代码文件
    @DmEnumDesc(name="动态链接库",description="动态链接库")
	public static final Integer DLL=2; //动态链接库
}	
