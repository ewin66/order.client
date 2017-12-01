package iih.ci.mr.pub.dataimport;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import iih.mkr.std.dedg.d.DeDataGrpDO;
import iih.mkr.std.dedg.i.IDedgMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class DataGroupImportServiceImpl extends BaseDataImport<DeDataGrpDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		DeDataGrpDO[] deDataGrpDOs =getDOsFromImportDB(new DeDataGrpDO(),"1=1",false);
		
		if (ArrayUtils.isEmpty(deDataGrpDOs))
    		throw new BizException("数据组导入数据为空！");
		
    	checkNullValue(Arrays.asList(DeDataGrpDO.ID_DG,DeDataGrpDO.NAME,DeDataGrpDO.CODE),deDataGrpDOs);
    	
		return true;
	}
	
	@Override
	public boolean importData() throws BizException {
		
		DeDataGrpDO[] deDataGrpDOs =getDOsFromImportDB(new DeDataGrpDO(),"1=1",true);
		
		if (ArrayUtils.isEmpty(deDataGrpDOs))
    		throw new BizException("数据组导入数据为空！");
		
    	processDOs(deDataGrpDOs);
    	
    	ServiceFinder.find(IDedgMDOCudService.class).insert(deDataGrpDOs);
    	
		return true;
	}
	
	
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_dg");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		// TODO Auto-generated method stub
		return new String[]{"bd_dg"};
	}
}
