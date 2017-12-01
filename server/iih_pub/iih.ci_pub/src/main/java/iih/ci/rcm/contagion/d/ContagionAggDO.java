package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.rcm.contagion.d.desc.ContagionAggDODesc;



/**
 * 传染病报告卡
 */
public class ContagionAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ContagionDO getParentDO() {
		return ((ContagionDO) super.getParentDO());
	}

	public void setParentDO(ContagionDO headDO) {
		setParent(headDO);
	}

	public StdDO[] getStdDO() {
		IBaseDO[] dos = getChildren(StdDO.class);
		if(dos==null) return null;
		StdDO[] result=new StdDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StdDO)dos[i];
		}
		return result;
	}
	
	public void setStdDO(StdDO[] dos) {
		setChildren(StdDO.class, dos);
	}
	public HepatitisBDO[] getHepatitisBDO() {
		IBaseDO[] dos = getChildren(HepatitisBDO.class);
		if(dos==null) return null;
		HepatitisBDO[] result=new HepatitisBDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HepatitisBDO)dos[i];
		}
		return result;
	}
	
	public void setHepatitisBDO(HepatitisBDO[] dos) {
		setChildren(HepatitisBDO.class, dos);
	}
	public SyphilisDO[] getSyphilisDO() {
		IBaseDO[] dos = getChildren(SyphilisDO.class);
		if(dos==null) return null;
		SyphilisDO[] result=new SyphilisDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SyphilisDO)dos[i];
		}
		return result;
	}
	
	public void setSyphilisDO(SyphilisDO[] dos) {
		setChildren(SyphilisDO.class, dos);
	}
	public HFMDO[] getHFMDO() {
		IBaseDO[] dos = getChildren(HFMDO.class);
		if(dos==null) return null;
		HFMDO[] result=new HFMDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HFMDO)dos[i];
		}
		return result;
	}
	
	public void setHFMDO(HFMDO[] dos) {
		setChildren(HFMDO.class, dos);
	}
	public AidsDO[] getAidsDO() {
		IBaseDO[] dos = getChildren(AidsDO.class);
		if(dos==null) return null;
		AidsDO[] result=new AidsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(AidsDO)dos[i];
		}
		return result;
	}
	
	public void setAidsDO(AidsDO[] dos) {
		setChildren(AidsDO.class, dos);
	}
	public CondylomaDO[] getCondylomaDO() {
		IBaseDO[] dos = getChildren(CondylomaDO.class);
		if(dos==null) return null;
		CondylomaDO[] result=new CondylomaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CondylomaDO)dos[i];
		}
		return result;
	}
	
	public void setCondylomaDO(CondylomaDO[] dos) {
		setChildren(CondylomaDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ContagionAggDODesc desc = new ContagionAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ContagionDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.rcm.contagion.d.StdDO")) {
             return new StdDO();
         }
	    else if (clzName.equals("iih.ci.rcm.contagion.d.HepatitisBDO")) {
             return new HepatitisBDO();
         }
	    else if (clzName.equals("iih.ci.rcm.contagion.d.SyphilisDO")) {
             return new SyphilisDO();
         }
	    else if (clzName.equals("iih.ci.rcm.contagion.d.HFMDO")) {
             return new HFMDO();
         }
	    else if (clzName.equals("iih.ci.rcm.contagion.d.AidsDO")) {
             return new AidsDO();
         }
	    else if (clzName.equals("iih.ci.rcm.contagion.d.CondylomaDO")) {
             return new CondylomaDO();
         }
         return null;
     }
}