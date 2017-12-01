package iih.ci.ord.s.bp.orsrvsplit;

import java.util.ArrayList;
import java.util.Hashtable;

import iih.ci.ord.dto.blexorder.d.OrSrvSplitOrModParamDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;

/***
 * 医嘱服务拆分后医嘱相关信息回写操作BP
 */
public class CiOrInfoUpdateAfterSplitBP {
	/***
	 * 医嘱服务拆分后医嘱相关信息回写操作
	 * @param params
	 * @throws BizException
	 */
	public void exec(OrSrvSplitOrModParamDTO[] params)  throws BizException{
		//有效性校验
		if(params==null || params.length==0)return;
		
		//获得医嘱服务拆分后医嘱回写相关信息对象集合
		Hashtable modobjs=getModifiedCiOrObjs(params);
		
		//更新服务拆分后医嘱相关回写对象
		updateModCiOrObjs(modobjs);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Hashtable getModifiedCiOrObjs(OrSrvSplitOrModParamDTO[] params) throws BizException{
		Hashtable ht=new Hashtable();
		BaseDO[] tm=null;
		ht.put(keys[0], new ArrayList());
		ht.put(keys[1], new ArrayList());
		ht.put(keys[2], new ArrayList());
		for(int i=0;i<params.length;i++){
			tm=getModifiedCiOrObjs(params[i]);
			if(tm[0]!= null){
				((ArrayList)ht.get(keys[0])).add(tm[0]);
			}
			if(tm[1]!= null){
				((ArrayList)ht.get(keys[1])).add(tm[1]);
			}
			if(tm[2]!= null){
				((ArrayList)ht.get(keys[2])).add(tm[2]);
			}
		}
		return ht;
	}
	private String[] keys=new String[]{"or","srv","mm"};
	
	/***
	 * 获得医嘱服务拆分后医嘱回写相关信息对象集合
	 * @param id_orsrv
	 * @param dt_last_split
	 * @param quan_bed_ap_medu
	 * @param isCharged
	 * @return
	 * @throws BizException
	 */
	private BaseDO[] getModifiedCiOrObjs(OrSrvSplitOrModParamDTO param) throws BizException{
		GetModCiOrObjsAfterSplitBP bp=new GetModCiOrObjsAfterSplitBP();
		return bp.exec(param);
	}
	
	/***
	 * 更新服务拆分后医嘱相关回写对象
	 * @param modobjs
	 * @throws BizException 
	 */
	private void updateModCiOrObjs(Hashtable modobjs) throws BizException{
		UpdateModCiOrObjsAfterSplitBP bp=new UpdateModCiOrObjsAfterSplitBP();
		bp.exec(modobjs);
	}
	
	
}
