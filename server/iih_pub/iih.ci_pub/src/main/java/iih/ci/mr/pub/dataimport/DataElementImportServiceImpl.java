package iih.ci.mr.pub.dataimport;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import iih.mkr.std.commonde.d.DataElementDO;
import iih.mkr.std.commonde.i.ICommondeCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class DataElementImportServiceImpl extends BaseDataImport<DataElementDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		DataElementDO[] dataElementDOs = getDOsFromImportDB(new DataElementDO(), "1=1", false);

		if (ArrayUtils.isEmpty(dataElementDOs))
			throw new BizException("数据元导入数据为空！");

		checkNullValue(Arrays.asList(DataElementDO.ID_DE, DataElementDO.CODE, DataElementDO.NAME), dataElementDOs);

		return true;
	}

	@Override
	public boolean importData() throws BizException {

		DataElementDO[] dataElementDOs = getDOsFromImportDB(new DataElementDO(), "1=1", true);

		if (ArrayUtils.isEmpty(dataElementDOs))
			throw new BizException("数据元导入数据为空！");

		processDOs(dataElementDOs);

		ServiceFinder.find(ICommondeCudService.class).insert(dataElementDOs);

		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_de");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		// TODO Auto-generated method stub
		return new String[] { "bd_de" };
	}
}
