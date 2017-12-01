package iih.ci.ord.s.bp.base.pien;

import java.lang.reflect.Array;
import java.util.ArrayList;

import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 毒麻药品服务代办人信息保存操作BP
 */
public class CiOrSrvAgentInfoSaveBP {
	/**
	 * 毒麻药品服务代办人信息保存
	 * @param agentdo
	 * @throws BizException
	 */
	public void exec(ArrayList<OrSrvAgentInfoDO> agentdo)  throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(agentdo))return;
		
		//参数设置
		ArrayList<EntContDO> insertlist=new ArrayList<EntContDO>();
		ArrayList<EntContDO> updatelist=new ArrayList<EntContDO>();
		ArrayList<Integer> insertdoIndex=new ArrayList<Integer>();
		
		//获得就诊联系人数据信息
		getEntContDOs(agentdo,insertlist, updatelist,insertdoIndex); 
		EntContDO[]  insertdos=null;
		
		//就诊联系人保存并将id数据回写代办人信息中（新建）
		if(!CiOrdUtils.isEmpty(insertlist)){
			insertdos=CiOrdAppUtils.getEntcontService().save((EntContDO[]) insertlist.toArray((EntContDO[]) Array.newInstance(EntContDO.class, 0)));
			fillAgentDOId(agentdo,insertdos,insertdoIndex);
		}
		
		//就诊联系人保存并将id数据回写代办人信息中（修改）
		if(!CiOrdUtils.isEmpty(updatelist)){
			CiOrdAppUtils.getEntcontService().update((EntContDO[]) updatelist.toArray((EntContDO[]) Array.newInstance(EntContDO.class, 0)));
		}
		
		
		//代办人数据保存
		CiOrdAppUtils.getOrsrvagentService().save((OrSrvAgentInfoDO[]) agentdo.toArray((OrSrvAgentInfoDO[]) Array.newInstance(OrSrvAgentInfoDO.class, 0)));

	}
	
	/**
	 * 获得就诊联系人数据信息
	 * @param agentdos
	 * @param insertdos
	 * @param updatedos
	 * @param insertdoIndex
	 * @throws BizException 
	 */
	private void getEntContDOs(ArrayList<OrSrvAgentInfoDO> agentdos,
			ArrayList<EntContDO> insertdos, ArrayList<EntContDO> updatedos,
			ArrayList<Integer> insertdoIndex) throws BizException {
		OrSrvAgentInfoDO agentdo=null;
		
		//遍历
		for(int i=0;i<agentdos.size();i++){
			agentdo=agentdos.get(i);
			if(DOStatus.NEW==agentdo.getStatus()){
				insertdos.add(createEntContDO(agentdo));
				insertdoIndex.add(i);
			}else if(DOStatus.UPDATED==agentdo.getStatus()){
				updatedos.add(createEntContDO(agentdo));
			}else if(DOStatus.DELETED==agentdo.getStatus()){
				//联系人  不做处理
			}
		}
	}
	
	/**
	 * 回写代理人ID数据
	 * @param agentdos
	 * @param insertdos
	 * @param insertdoIndex
	 */
	private void fillAgentDOId(ArrayList<OrSrvAgentInfoDO> agentdos,EntContDO[] insertdos, ArrayList<Integer> insertdoIndex) {
		
		//遍历
		for(int i=0;i<insertdos.length;i++){
			(agentdos.get(insertdoIndex.get(i))).setId_agent(insertdos[i].getId_entcont());;
		}
	}

	
	/**
	 * 创建就诊联系人信息
	 * @param agentdo
	 * @return
	 * @throws BizException 
	 */
	private EntContDO createEntContDO(OrSrvAgentInfoDO agentdo) throws BizException{
		EntContDO rtndo=getEntContDO(agentdo.getId_agent());
		rtndo.setContaddr(agentdo.getAddr_agent());
		rtndo.setConttel(agentdo.getPhone_agent());
		rtndo.setEu_entconttp(EuEntContTp.AGENT);
		rtndo.setId_conttp(agentdo.getId_conttp());
		rtndo.setSd_conttp(agentdo.getSd_conttp());
		rtndo.setId_ent(agentdo.getId_en());
		//rtndo.setId_patcontid(Id_patcontid);
		rtndo.setId_idtp(agentdo.getId_idtp_agent());
		rtndo.setSd_idtp(agentdo.getSd_idtp_agent());
		rtndo.setIdcode(agentdo.getIdno_agent());
		rtndo.setName(agentdo.getName_agent());
		//rtndo.setName_conttp(Name_conttp);
		//rtndo.setMnecode(Mnecode);
		//rtndo.setPycode(Pycode);
		rtndo.setSortno(0);
		//rtndo.setWbcode(Wbcode);
		rtndo.setZip(agentdo.getZip_agent());
		//rtndo.setId_entcont(Id_entcont); 
	
		return rtndo;
	}
	
	/**
	 * 获得就诊联系人实体数据
	 * @param id_agent
	 * @return
	 * @throws BizException
	 */
	private EntContDO getEntContDO(String id_agent) throws BizException{
		EntContDO rtn=null;
		
		//新建情况
		if(CiOrdUtils.isEmpty(id_agent)){
			rtn=new EntContDO();
			rtn.setStatus(DOStatus.NEW);
			return rtn;
		}
		
		//已有联系人情况
		rtn=CiOrdAppUtils.getEntcontQryService().findById(id_agent);
		rtn.setStatus(DOStatus.UPDATED);
		return rtn;
	}
	
}
