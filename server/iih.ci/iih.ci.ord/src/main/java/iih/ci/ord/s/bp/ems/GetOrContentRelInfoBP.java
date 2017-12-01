package iih.ci.ord.s.bp.ems;

import java.util.Date;
import java.util.Random;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.content.d.CiOrIdentifcationInfo;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.DateUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 获得医嘱内容相关信息
 * code name content srvtp等
 */
public class GetOrContentRelInfoBP {
	/**
	 * CI医嘱开立医疗单保存操作
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public  CiOrIdentifcationInfo exec(CiEmsDTO ems)  throws BizException{
		CiOrIdentifcationInfo rtn=new CiOrIdentifcationInfo();
		if(ems==null)return rtn;
		String[] srvinfo=getCiEmsMainSrvInfo(ems.getEmssrvs());
		rtn.setCode(getOrCode());
		rtn.setName(srvinfo[2]);
		rtn.setId_srvtp(srvinfo[0]);
		rtn.setSd_srvtp(srvinfo[1]);
		rtn.setContent(getOrContent(ems));
		return rtn;
	}
	
	/**
	 * 获得医嘱内容
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private String getOrContent(CiEmsDTO ems) throws BizException{
		return CiOrContentManager.getCiOrContentStr(ems);
	}
	
	private String getOrCode() throws BizException{
		
		return CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
		/*String code="";
		code=DateUtils.getDateTimeStr(new Date(),"yyyyMMddHHssSSS");	//暂时先这样吧
		//code=CiOrdUtils.getBillCode(CiOrderDODesc.CLASS_FULLNAME);    //配置编码规则后可取该逻辑
		return ICiDictCodeConst.IIH+code+getRandom();*/
	}
	
	/**
	 * 返回六位的随机数
	 * @return
	 * @throws BizException
	 */
	private String getRandom()throws BizException{
		int max = 999999;
   	    int min =100000;
   	   Random rand = new Random();
   	   int tmp = Math.abs(rand.nextInt());
       return (tmp % (max - min + 1) + min)+"";
		 
	}
	
	/**
	 * 获得医嘱主服务信息
	 * @param srvpdvos
	 * @return
	 */
	private CiEmsSrvDTO getCiEmsSrv(FArrayList orsrvlist){
		if(orsrvlist==null ||orsrvlist.size()==0)return null;
		CiEmsSrvDTO srvdo=(CiEmsSrvDTO)orsrvlist.get(0);
		return srvdo;
	}
	
	
	/**
	 * 获得医嘱主服务信息
	 * @param orsrvlist
	 * @return
	 */
	private String[] getCiEmsMainSrvInfo(FArrayList orsrvlist){
		String[] rtn=new String[]{"","",""};
		CiEmsSrvDTO mainsrv=getCiEmsSrv(orsrvlist);
		if(mainsrv==null)return rtn;
		rtn[0]=mainsrv.getId_srvtp();
		rtn[1]=mainsrv.getSd_srvtp();
		rtn[2]=mainsrv.getName_srv();
		return rtn;
	}
	
}
