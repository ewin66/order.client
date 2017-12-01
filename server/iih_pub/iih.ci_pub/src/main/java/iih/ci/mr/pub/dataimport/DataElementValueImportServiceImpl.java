package iih.ci.mr.pub.dataimport;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import iih.mkr.std.commondeval.d.DataElementValDO;
import iih.mkr.std.commondeval.i.ICommondevalCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class DataElementValueImportServiceImpl extends BaseDataImport<DataElementValDO> implements IDataImport {
	
	@Override
	public boolean checkNotNull() throws BizException {
		DataElementValDO[] dataElementValDOs =getDOsFromImportDB(new  DataElementValDO(),"1=1",false);
		
		if (ArrayUtils.isEmpty(dataElementValDOs))
    		throw new BizException("数据元值域导入数据为空！");
		
    	checkNullValue(Arrays.asList(DataElementValDO.ID_DE_VAL,DataElementValDO.CODE,DataElementValDO.NAME),dataElementValDOs);
    	
		return true;
	}
	
	@Override
	public boolean importData() throws BizException {
		
		DataElementValDO[] dataElementValDOs =getDOsFromImportDB(new  DataElementValDO(),"1=1",true);
		
		if (ArrayUtils.isEmpty(dataElementValDOs))
    		throw new BizException("数据元值域导入数据为空！");
		
    	processDOs(dataElementValDOs);
    	
    	ServiceFinder.find(ICommondevalCudService.class).insert(dataElementValDOs);
    	
		return true;
	}
	
	
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_de_val");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		// TODO Auto-generated method stub
		return new String[]{"bd_de_val"};
	}
}