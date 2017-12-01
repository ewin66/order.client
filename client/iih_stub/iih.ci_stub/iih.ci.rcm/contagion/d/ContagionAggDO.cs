using System;
using xap.mw.core.data;
using xap.mw.core.meta;

namespace iih.ci.rcm.contagion.d
{
	/// <summary>
	/// 传染病报告卡DO
	/// </summary>
	public class ContagionAggDO : BaseAggDO
	{	
	    private static string CONTAGIONDO_STDDO="iih.ci.rcm.contagion.d.StdDO";
	    private static string CONTAGIONDO_HEPATITISBDO="iih.ci.rcm.contagion.d.HepatitisBDO";
	    private static string CONTAGIONDO_SYPHILISDO="iih.ci.rcm.contagion.d.SyphilisDO";
	    private static string CONTAGIONDO_HFMDO="iih.ci.rcm.contagion.d.HFMDO";
	    private static string CONTAGIONDO_AIDSDO="iih.ci.rcm.contagion.d.AidsDO";
	    private static string CONTAGIONDO_CONDYLOMADO="iih.ci.rcm.contagion.d.CondylomaDO";

        public ContagionAggDO() {
            this.setParentDO(new ContagionDO());
        }

  	    public ContagionDO getParentDO() {
		    return ((ContagionDO) base.ParentDO);
	    }      
	    
	    public void setParentDO(ContagionDO headDO) {
		    base.ParentDO=headDO;
	    }
	    
	    public StdDO[] getStdDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CONTAGIONDO_STDDO));
		    if (dos == null || dos.Length==0){return null;}
            StdDO[] r = new StdDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as StdDO;
            }
	        return r;
		    
	    }
	    
	    public void setStdDO(StdDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public HepatitisBDO[] getHepatitisBDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CONTAGIONDO_HEPATITISBDO));
		    if (dos == null || dos.Length==0){return null;}
            HepatitisBDO[] r = new HepatitisBDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as HepatitisBDO;
            }
	        return r;
		    
	    }
	    
	    public void setHepatitisBDO(HepatitisBDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public SyphilisDO[] getSyphilisDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CONTAGIONDO_SYPHILISDO));
		    if (dos == null || dos.Length==0){return null;}
            SyphilisDO[] r = new SyphilisDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as SyphilisDO;
            }
	        return r;
		    
	    }
	    
	    public void setSyphilisDO(SyphilisDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public HFMDO[] getHFMDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CONTAGIONDO_HFMDO));
		    if (dos == null || dos.Length==0){return null;}
            HFMDO[] r = new HFMDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as HFMDO;
            }
	        return r;
		    
	    }
	    
	    public void setHFMDO(HFMDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public AidsDO[] getAidsDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CONTAGIONDO_AIDSDO));
		    if (dos == null || dos.Length==0){return null;}
            AidsDO[] r = new AidsDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as AidsDO;
            }
	        return r;
		    
	    }
	    
	    public void setAidsDO(AidsDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }
	    public CondylomaDO[] getCondylomaDO() {		    
		    
		    BaseDO[] dos=getChildren(Type.GetType(CONTAGIONDO_CONDYLOMADO));
		    if (dos == null || dos.Length==0){return null;}
            CondylomaDO[] r = new CondylomaDO[dos.Length];
            for (int i = 0; i < dos.Length;i++ ){
                r[i] = dos[i] as CondylomaDO;
            }
	        return r;
		    
	    }
	    
	    public void setCondylomaDO(CondylomaDO[] dos) {
            if (dos == null || dos.Length == 0) return;
            setChildren(dos[0].GetType(), dos);
	    }


	    public override BaseDO createParentDO()
	    {
	        return new ContagionDO();
	    }

        public override BaseDO createChildDO(string clzName)
	    {
            if (CONTAGIONDO_STDDO == clzName)
	        {
                return new StdDO();
	        }
           else if (CONTAGIONDO_HEPATITISBDO == clzName)
	        {
                return new HepatitisBDO();
	        }
           else if (CONTAGIONDO_SYPHILISDO == clzName)
	        {
                return new SyphilisDO();
	        }
           else if (CONTAGIONDO_HFMDO == clzName)
	        {
                return new HFMDO();
	        }
           else if (CONTAGIONDO_AIDSDO == clzName)
	        {
                return new AidsDO();
	        }
           else if (CONTAGIONDO_CONDYLOMADO == clzName)
	        {
                return new CondylomaDO();
	        }
	        return null;
	    }
	    
	    /// <summary>
        /// 获取子类全路径名数组
        /// </summary>
        /// <returns></returns>
        public override string[] getChildClassNames(){
            return  new string[]{"iih.ci.rcm.contagion.d.StdDO","iih.ci.rcm.contagion.d.HepatitisBDO","iih.ci.rcm.contagion.d.SyphilisDO","iih.ci.rcm.contagion.d.HFMDO","iih.ci.rcm.contagion.d.AidsDO","iih.ci.rcm.contagion.d.CondylomaDO"};
        }
	    public new static AggMeta GetMeta()
	    {
	        AggMeta meta = new AggMeta();
	        meta.OneToOneDOs = new string[]{};
	        return meta;
	    }
	    
	}
}
