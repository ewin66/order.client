package iih.ci.ord.s.bp.orsrvsplit;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;

/***
 * 按按请领类型对服务拆分结果进行归类操作BP
  */
public class SrvSplitRsGrpByAppTypeBP {
	private String roundingbybatch_rangemode="";  //按批次取整时，分组归类方式设置  
	private String remains_rangemode="";          //按剩余法时，分组归类方式设置
	private String wardmerge_rangemode=IOrAndSrvSplitConst.SPLITRS_GRPRANGEMODE_WD;////按合用法时，分组归类方式
	private String srv_rangemode="";
	
	/***
	 * 按按请领类型对服务拆分结果进行归类操
	 * @param srvsplitorders
	 * @return
	 * @throws BizException
	 */
	public  Hashtable exec(SrvSplitOrderDTO[] srvsplitorders)  throws BizException{
		//有效性校验
		if(srvsplitorders==null || srvsplitorders.length==0)return null;
		
		Hashtable rtnHt=new Hashtable();
		//遍历 IOrAndSrvSplitConst  SPLITRS_GRPTP_OUTP
		for(int i=0;i<srvsplitorders.length;i++){
			if(OrSrvSplitUtil.isTrue(srvsplitorders[i].getFg_mm())){
				setRangeMode();
				MmGroupHandle(rtnHt,srvsplitorders[i]);
			}else{
				setRangeMode();
				SrvGroupHandle(rtnHt,srvsplitorders[i]);
			}
		}
		
		return rtnHt;
	}
	
	/***
	 * 根据参数设置进行归类模式设置
	 */
	private void setRangeMode(){
		String orgid=Context.get().getOrgId();
		roundingbybatch_rangemode=IOrAndSrvSplitConst.SPLITRS_GRPRANGEMODE_OR;//ParamsetQryUtil.getParaString(orgid, ICiOrdSysParamConst.SPLITRS_GRPRANGEMODE_BYBATCH);
		remains_rangemode=IOrAndSrvSplitConst.SPLITRS_GRPRANGEMODE_OR;//ParamsetQryUtil.getParaString(orgid, ICiOrdSysParamConst.SPLITRS_GRPRANGEMODE_BYBATCH);
		wardmerge_rangemode=IOrAndSrvSplitConst.SPLITRS_GRPRANGEMODE_WD;
		srv_rangemode=IOrAndSrvSplitConst.SPLITRS_GRPRANGEMODE_OR;
	}
	
	/***
	 * 按服务分组处理逻辑
	 * @param ht
	 * @param splitdto
	 * @throws BizException 
	 */
	private void SrvGroupHandle(Hashtable ht,SrvSplitOrderDTO splitdto) throws BizException{
		HtAddBaseHandle(IOrAndSrvSplitConst.SPLITRS_GRPTP_SRV,ht,splitdto,srv_rangemode);
		return;
	}
	
	/***
	 * 按物品分组处理逻辑
	 * @param ht
	 * @param splitdto
	 * @throws BizException 
	 */
	private void MmGroupHandle(Hashtable ht,SrvSplitOrderDTO splitdto) throws BizException{
		String key="";
		//出院带药逻辑
		if(OrSrvSplitUtil.isTrue(splitdto.getFg_pres_outp())){
			HtAddBaseHandle(IOrAndSrvSplitConst.SPLITRS_GRPTP_OUTP,ht,splitdto);
			return;
		}
		
		//草药逻辑
		if(OrSrvSplitUtil.isDtSrvTypeSame(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG,splitdto.getSd_srvtp(),true)){
			HtAddBaseHandle(IOrAndSrvSplitConst.SPLITRS_GRPTP_HERB,ht,splitdto);
			return;
		}
		
		//按次取整
		if(IOrAndSrvSplitConst.SPLITRS_GRPTP_NBYT.equals(splitdto.getPkuroundmode())){
			HtAddBaseHandle(IOrAndSrvSplitConst.SPLITRS_GRPTP_NBYT,ht,splitdto);
			return;
		}
		
		//按批取整
		if(IOrAndSrvSplitConst.SPLITRS_GRPTP_NBYB.equals(splitdto.getPkuroundmode())){
			HtAddBaseHandle(IOrAndSrvSplitConst.SPLITRS_GRPTP_NBYB,ht,splitdto,roundingbybatch_rangemode);
			return;
		}	
		
		//按余量法时
		if(IOrAndSrvSplitConst.SPLITRS_GRPTP_REMAINS.equals(splitdto.getPkuroundmode())){
			HtAddBaseHandle(IOrAndSrvSplitConst.SPLITRS_GRPTP_REMAINS,ht,splitdto,remains_rangemode);
			return;
		}
		
		//按合用法时
		if(IOrAndSrvSplitConst.SPLITRS_GRPTP_WDSUM.equals(splitdto.getPkuroundmode())){
			HtAddBaseHandle(IOrAndSrvSplitConst.SPLITRS_GRPTP_WDSUM,ht,splitdto,wardmerge_rangemode);
			return;
		}
	}
	
	/***
	 * HashTable数据增加基本处理
	 * @param key
	 * @param ht
	 * @param splitdto
	 */
	private void HtAddBaseHandle(String key,Hashtable ht,SrvSplitOrderDTO splitdto){
		
		List<SrvSplitOrderDTO> list = new ArrayList<SrvSplitOrderDTO>();
		if(ht.containsKey(key)){
			list = (ArrayList<SrvSplitOrderDTO>)ht.get(key);
		}else{
			ht.put(key, list);
		}
		list.add(splitdto);
	}
	
	/***
	 * HashTable数据增加的处理（按归类模式）
	 * @param key
	 * @param ht
	 * @param splitdto
	 * @param grouprangemode
	 * @throws BizException 
	 */
	private void HtAddBaseHandle(String key,Hashtable ht,SrvSplitOrderDTO splitdto,String grouprangemode) throws BizException{
		String keyn=getKey(splitdto,grouprangemode);
		if(ht.containsKey(key)){
			Hashtable htn=(Hashtable)ht.get(key);
			if(htn.containsKey(keyn)){
				((ArrayList<SrvSplitOrderDTO>)htn.get(keyn)).add(splitdto);
			}else{
				ArrayList<SrvSplitOrderDTO> list = new ArrayList<SrvSplitOrderDTO>();
				list.add(splitdto);
				htn.put(keyn, list);
			}
		}else{
			Hashtable htn = new Hashtable();
			ArrayList<SrvSplitOrderDTO> list = new ArrayList<SrvSplitOrderDTO>();
			list.add(splitdto);
			htn.put(keyn, list);
			
			ht.put(key,htn);
		}
	}
	
	/***
	 * 获得归类键值串
	 * @param splitorder
	 * @param grouprangemode
	 * @return
	 * @throws BizException 
	 */
	private String getKey(SrvSplitOrderDTO splitorder,String grouprangemode) throws BizException{
		GetGrpRangeKeyBP bp=new GetGrpRangeKeyBP();
		return bp.exec(splitorder, grouprangemode);
	}
}
