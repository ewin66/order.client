package iih.ci.ord.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;

/***
 * 保存核对的患者信息
 * @author Administrator
 *
 */
public class SaveCheckPatInfoBP {
	public void exec(FArrayList checkpatinfo,OrSrvAgentInfoDO agentInfo) throws BizException{
		//新建情况
		if(CiOrdUtils.isEmpty(agentInfo.getId_agent())&&!CiOrdUtils.isEmpty(agentInfo.getName_agent())){
			EntContDO entContdo = createEntContDO(agentInfo);
			EntContDO[] endContdos = CiOrdAppUtils.getEntcontService().insert(new EntContDO[]{entContdo});
			agentInfo.setId_agent(endContdos[0].getId_entcont());
		}
		OrSrvAgentInfoDO[] agentInfos = new OrSrvAgentInfoDO[checkpatinfo.size()];
		for(int i=0;i<checkpatinfo.size();i++){
			OrdSrvDO srvdo = (OrdSrvDO)checkpatinfo.get(i);
			OrSrvAgentInfoDO newAgentInfo = new OrSrvAgentInfoDO();
			newAgentInfo.deSerializeJson(agentInfo.serializeJson());
			//CiOrdUtils.copyObject(agentInfo, newAgentInfo);
			newAgentInfo.setId_orsrv(srvdo.getId_orsrv());
			newAgentInfo.setId_or(srvdo.getId_or());
			agentInfos[i] = newAgentInfo;
		}
		CiOrdAppUtils.getOrsrvagentService().insert(agentInfos);
	}
	public EntContDO createEntContDO(OrSrvAgentInfoDO agentdo) throws BizException{
		EntContDO rtndo= new EntContDO();
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
}
