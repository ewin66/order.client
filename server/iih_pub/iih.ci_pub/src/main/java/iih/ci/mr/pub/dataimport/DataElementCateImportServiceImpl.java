package iih.ci.mr.pub.dataimport;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import iih.mkr.std.deca.d.DataElemCateDO;
import iih.mkr.std.deca.i.IDecaCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class DataElementCateImportServiceImpl extends BaseDataImport<DataElemCateDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		
		DataElemCateDO[] dataEleCateDOs =getDOsFromImportDB(new  DataElemCateDO(),"1=1",false);
		
		if (ArrayUtils.isEmpty(dataEleCateDOs))
    		throw new BizException("公共数据元分类导入数据为空！");
		
		checkNullValue(Arrays.asList(DataElemCateDO.ID_DECA,DataElemCateDO.ID_DECATP,DataElemCateDO.CODE,DataElemCateDO.NAME),dataEleCateDOs);
		
		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		
		DataElemCateDO[] dataElementDOs =getDOsFromImportDB(new  DataElemCateDO(),"1=1",true);
		
		if (ArrayUtils.isEmpty(dataElementDOs))
    		throw new BizException("公共数据元分类导入数据为空！");
		
    	processDOs(dataElementDOs);
    	
    	ServiceFinder.find(IDecaCudService.class).insert(dataElementDOs);
    	
		return true;
	}

	@Override
	public boolean importData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_deca");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		// TODO Auto-generated method stub
		return new String[]{"bd_deca"};

	}

}
