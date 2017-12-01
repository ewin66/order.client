package iih.ci.ord.s.bp.impt;

import java.util.Arrays;

import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvVtDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

import org.apache.commons.lang3.ArrayUtils;

public class MedSrvVtImportServiceImpl extends BaseDataImport<MedSrvVtDO>
		implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		// 1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		MedSrvVtDO[] dos = getDOsFromImportDB(new MedSrvVtDO(),"1=1",false);
    	if (ArrayUtils.isEmpty(dos))
    		throw new BizException("医疗服务导入数据为空！");
    	
		// 2、名称编码校验
	//	checkNullValue(Arrays.asList(MedSrvDO.NAME, MedSrvDO.CODE), dos);
		return true;
	}
	
	@Override
	public boolean importData() throws BizException {
		// 1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		MedSrvVtDO[] dos = getDOsFromImportDB(new MedSrvVtDO(),"1=1",true);
    	if (ArrayUtils.isEmpty(dos))
    		throw new BizException("医疗服务导入数据为空！");
    	
		// 3、状态改为New
		processDOs(dos);

		// 4、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
		ServiceFinder.find(IMedSrvVtDOCudService.class).insert(dos);

		return true;
	}
	
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from "+new MedSrvVtDO().getTableName()+""+ " where "+new MedSrvVtDO().getPKFieldName() +" not like '@@@@%'");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{new MedSrvVtDO().getTableName()};
	}
}
