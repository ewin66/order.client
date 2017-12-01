package iih.ci.ord.s.utils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;
/**
 * 获取
 * @author qzwang
 *
 */
public class GetUDiDocBP {

	public UdidocDO exec() throws BizException{
		// 检查目的编码
		IUdidocRService service=ServiceFinder.find(IUdidocRService.class);
        UdidocDO[] udidoc = service.find("id_udidoclist ='0001ZZ20000000000075'", "", FBoolean.FALSE);
        if (udidoc != null && udidoc.length > 0) {
            return udidoc[0];
        }
        return null;
	}
}
