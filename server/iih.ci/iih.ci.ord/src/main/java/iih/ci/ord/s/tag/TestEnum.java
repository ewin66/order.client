package iih.ci.ord.s.tag;

public interface TestEnum {
	@DmEnumDesc(name="医疗服务",description="医疗服务词频统计类型")
    public static final String MEDSRV="medsrv"; 
	
	@DmEnumDesc(name="临床诊断",description="医疗服务词频统计类型")
    public static final String DIAGDEF="diagdef"; 
}	
