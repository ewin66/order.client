/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.devcfg.func.d.PageDO;

/**
 * @ClassName: getPageDOListBP
 * @Description:  医嘱助手页签列表
 * @author Comsys-li_zheng
 * @date 2016年2月27日 下午1:22:54
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getPageDOListBP {
	  
	   private String biz = "46105560"; // 功能号
       /**
        * 医生 id 和科室id 为以后的权限预留参数 todo 
        * 
        * @param doctor_id 医生id
        * @param dept_id   科室id
        * @param biz_id    业务功能
        * @return
        * @throws BizException
        */
	  public PageDO[] getPageDOList(String doctor_id,String dept_id,String biz_id)throws BizException{
		  if(biz_id == null){
			 return CiOrdAppUtils.getIPageRService().find(" a0.ds ='0' and a0.biz_id like '"+this.biz+"%'", "a0.biz_id", FBoolean.FALSE); 
		  }else {
			return CiOrdAppUtils.getIPageRService().find("a0.ds ='0' and a0.biz_id  =  '"+biz_id+"'", "a0.biz_id", FBoolean.FALSE); 
		  }
	  }
	
}
