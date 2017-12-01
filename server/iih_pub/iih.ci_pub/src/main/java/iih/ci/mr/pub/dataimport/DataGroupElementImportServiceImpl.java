package iih.ci.mr.pub.dataimport;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import iih.mkr.std.dedg.d.DgDeDO;
import iih.mkr.std.dedg.i.IDgDeDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class DataGroupElementImportServiceImpl extends BaseDataImport<DgDeDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		DgDeDO[] dgDeDOs =getDOsFromImportDB(new  DgDeDO(),"1=1",false);
		
		if (ArrayUtils.isEmpty(dgDeDOs))
    		throw new BizException("数据组下数据元导入数据为空！");
		
    	checkNullValue(Arrays.asList(DgDeDO.ID_DGDE,DgDeDO.ID_DG,DgDeDO.ID_DE,DgDeDO.NAME),dgDeDOs);
    	
		return true;
	}
	
	
	@Override
	public boolean importData() throws BizException {
		
		DgDeDO[] dgDeDOs =getDOsFromImportDB(new DgDeDO(),"1=1",true);
		
		if (ArrayUtils.isEmpty(dgDeDOs))
    		throw new BizException("数据组下数据元导入数据为空！");
		
    	processDOs(dgDeDOs);
    	
    	ServiceFinder.find(IDgDeDOCudService.class).insert(dgDeDOs);
    	
		return true;
	}
	
	
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_dg_de");
		return true;
	}


	@Override
	public String[] getImportTable() throws BizException {
		// TODO Auto-generated method stub
		return new String[]{"bd_dg_de"};
	}
}
