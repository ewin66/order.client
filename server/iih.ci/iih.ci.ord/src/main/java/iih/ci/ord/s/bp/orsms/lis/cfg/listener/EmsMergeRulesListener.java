package iih.ci.ord.s.bp.orsms.lis.cfg.listener;

import iih.ci.ord.s.bp.orsms.lis.cfg.EmsMergeRulesCfg;
import xap.lui.core.zookeeper.NodeChangeEvent;
import xap.lui.core.zookeeper.NodeCreateEvent;
import xap.lui.core.zookeeper.NodeListener;
import xap.lui.core.zookeeper.NodeRemoveEvent;

public class EmsMergeRulesListener implements NodeListener {

	@Override
	public void childNodeChanged(NodeChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void childNodeCreate(NodeCreateEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void childNodeRemove(NodeRemoveEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nodeChanged(NodeChangeEvent arg0) {
		// TODO Auto-generated method stub
		EmsMergeRulesCfg.getInstance().reload();
	}

	

}
