package iih.ci.ord.s.bp.ems;

import java.util.HashMap;

import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorsrvhp.d.CiOrSrvHpDO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;

/**
 * 医嘱项目数据
 */
public class OrdSrvItemDatum {
	private HashMap<String,CiOrSrvHpDO> ciorsrvhpdo;
	private OrdSrvDO srvdo;  
	private OrdSrvMmDO srvmm;      //FMap.put(id_srv,OrdSrvMmDO)
	private OrdSrvDoseDO[] srvdoses;   //FMap.put(id_srv,OrdSrvDoseDO[])
	private OrSrvAgentInfoDO srvagent;  //FMap.put(id_srv,OrSrvAgentInfoDO)
	private CiOrAggAndRelDatum skintestagginfo;

	
	public HashMap<String, CiOrSrvHpDO> getCiorsrvhpdo() {
		return ciorsrvhpdo;
	}
	public void setCiorsrvhpdo(HashMap<String, CiOrSrvHpDO> ciorsrvhpdo) {
		this.ciorsrvhpdo = ciorsrvhpdo;
	}
	public OrdSrvDO getSrvdo() {
		return srvdo;
	}
	public void setSrvdo(OrdSrvDO srvdo) {
		this.srvdo = srvdo;
	}
	public OrdSrvMmDO getSrvmm() {
		return srvmm;
	}
	public void setSrvmm(OrdSrvMmDO srvmm) {
		this.srvmm = srvmm;
	}
	public OrdSrvDoseDO[] getSrvdoses() {
		return srvdoses;
	}
	public void setSrvdoses(OrdSrvDoseDO[] srvdoses) {
		this.srvdoses = srvdoses;
	}
	public CiOrAggAndRelDatum getSkintestagginfo() {
		return skintestagginfo;
	}
	public void setSkintestagginfo(CiOrAggAndRelDatum skintestagginfo) {
		this.skintestagginfo = skintestagginfo;
	}
	public OrSrvAgentInfoDO getSrvagent() {
		return srvagent;
	}
	public void setSrvagent(OrSrvAgentInfoDO srvagent) {
		this.srvagent = srvagent;
	}
	
	
}
