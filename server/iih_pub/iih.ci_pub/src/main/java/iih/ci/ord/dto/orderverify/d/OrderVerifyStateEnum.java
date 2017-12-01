package iih.ci.ord.dto.orderverify.d;

public interface OrderVerifyStateEnum {

	public static final Integer NOTVERIFY=0; //未审核
	public static final Integer PASS=1; //审核通过
	public static final Integer REJECT=2; //审核驳回
	public static final Integer FORCE=3; //强制执行
}	
