package iih.ci.ord.s.bp.iemsg.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.xip.d.MsgMappingEntry;
import xap.xip.i.IMsgMappingEntryCudService;
import xap.xip.i.IMsgMappingEntryRService;

/**
 * 临时功能，拷贝集成平台的消息映射配置
 * @author HUMS
 *
 */
public class SyncIEMsgMappingBP {
	
	private static int idIndex = 0;
	
	private ICiOrdQryService ciOrdQryService = CiOrdAppUtils.getCiOrdQryService();
	
	// 读取集成平台信息
	private IMsgMappingEntryRService  msgMappingEntryRService = (IMsgMappingEntryRService)ServiceFinder.find(IMsgMappingEntryRService.class);;
	
	
	private IMsgMappingEntryCudService  msgMappingEntryCudService = (IMsgMappingEntryCudService)ServiceFinder.find(IMsgMappingEntryCudService.class);;;
	
	public void exec() throws BizException{
		createCopy();
	}
	
	public void createCopy () throws BizException{
		
		idIndex = 0;
		// 住院的消息映射
		String whereStr = "mapping_id='1000Z710000000021R3P'"; //检验 门诊
		
		MsgMappingEntry[]  msgEntrys = msgMappingEntryRService.find(whereStr, "id_parent desc", FBoolean.FALSE);
		
		for(MsgMappingEntry entry :  msgEntrys){
			System.out.println("id = " + entry.getEntry_id() + " parentId =" + entry.getId_parent() + " property = " + entry.getEntity_class());
		}
		MsgMappingEntry root = getRoot(msgEntrys);
		String[] entryIds = ciOrdQryService.getOIDs(msgEntrys.length);
		
		List<MsgMappingEntry> entryList = new ArrayList<MsgMappingEntry>();
		getChildren(root,msgEntrys,entryList,entryIds);
		
		System.out.println("记录数：" + entryList.size());
		
		for(MsgMappingEntry entry : entryList){
			System.out.println("id="+entry.getEntry_id() +" ; parentId = " + entry.getId_parent() +" ; property = " + entry.getEntity_path() + "***" + entry.getEntity_class());
		}
		System.out.println("记录数：" + entryList.size());
		msgMappingEntryCudService.insert(entryList.toArray(new MsgMappingEntry[entryList.size()]));
	}
	
	private void getChildren(MsgMappingEntry root, MsgMappingEntry[]  msgEntrys,List<MsgMappingEntry> entryList,String[] entryIds){		
		
		// 获取当前递归根节点id
		String rootId = root.getEntry_id();
		
		String newRootId =entryIds[idIndex];
		root.setEntry_id(newRootId);
		root.setMapping_id("BS006_02");
		idIndex++;
		
		System.out.println("老Id = " + rootId + "  新Id = " + newRootId);
		
		for(MsgMappingEntry msgEntry :  msgEntrys){
			if(rootId.equals(msgEntry.getId_parent())){
				
				msgEntry.setId_parent(newRootId);
				getChildren(msgEntry,msgEntrys,entryList,entryIds);								
			}
		}		
				
		entryList.add(root);
	}
	
	/**
	 * 获取根节点
	 * @param msgEntrys
	 * @return
	 */
	private MsgMappingEntry getRoot(MsgMappingEntry[]  msgEntrys){
		
		for(MsgMappingEntry msgEntry : msgEntrys){
			if(StringUtils.isBlank(msgEntry.getId_parent())){
				return msgEntry;
			}
		}
		
		return null;
	}

}
