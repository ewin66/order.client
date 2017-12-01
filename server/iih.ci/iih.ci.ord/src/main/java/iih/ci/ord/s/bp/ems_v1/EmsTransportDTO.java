package iih.ci.ord.s.bp.ems_v1;

import xap.mw.core.data.FMap2;

/**
 * 医疗单传输协议
 * @author vivi
 *
 * @param <T>
 */
public class EmsTransportDTO<T> extends FMap2
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public T GetData(String pk, T def )
    {
        if (this.containsKey(pk))
            return (T)this.get(pk) ;
        return def;
    }
}
