package iih.ci.mrqc.i;

import xap.sys.jdbc.facade.DAException;

public interface IMrPigeonholeUpdateAffair {
	
	public abstract void updateStateWhenAutoPigeonhole()throws DAException;
}
