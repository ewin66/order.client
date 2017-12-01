package iih.ci.ord.s.bp.impt;
import java.util.List;

import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrTplNItmDOCudService;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.jdbc.datasource.DataSourceManager;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class OrTmplItmImportServiceImpl extends BaseDataImport<OrTplNItmDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		// 1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		OrTplNItmDO[] dos = getDOsFromImportDB(new OrTplNItmDO(), "1=1 ", false);
		if (ArrayUtils.isEmpty(dos))
			throw new BizException("医嘱模板明细导入数据为空！");

		// 2、名称编码校验
		// checkNullValue(Arrays.asList(OrTplNItmDO.NAME, OrTplNItmDO.CODE),
		// dos);

		return true;
	}

	@Override
	public boolean importData() throws BizException {
		// 1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		OrTplNItmDO[] dos = getDOsFromImportDB(new OrTplNItmDO(), "1=1", true);
		if (ArrayUtils.isEmpty(dos))
			throw new BizException("医嘱模板明细导入数据为空！");

		// 3、状态改为New
		processDOs(dos);

		// 4、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
		ServiceFinder.find(IOrTplNItmDOCudService.class).insert(dos);

		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from " + new OrTplNItmDO().getTableName() + ""+ " where "+new OrTplNItmDO().getPKFieldName() +" not like '@@@@%'");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[] { new OrTplNItmDO().getTableName() };
	}

	@Override
	public boolean checkBusiness() throws BizException {
		// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
//		OrTplNItmDO[] dos = getDOsFromImportDB(new OrTplNItmDO(), "1=1", false);
	//	DAFacade daFacade = new DAFacade();
		DAFacade daFacade = new DAFacade(DataSourceManager.DEFAULT_IMPORT_DS);
		List<OrTplNItmDO> doses =(List<OrTplNItmDO>) daFacade.findByCond((new OrTplNItmDO()).getClass(), " (id_srv not in (select id_srv from bd_srv union select id_ortmpl from bd_srv_ortmpl union select id_srv from xapdevelop2.bd_srv union select id_ortmpl from xapdevelop2.bd_srv_ortmpl))  ");
		if(doses!=null&&doses.size()>0){
			StringBuilder sb=new StringBuilder();
			for (OrTplNItmDO orTplNItmDO : doses) {
				if(sb.length()==0){
				sb.append("'"+orTplNItmDO.getId_srv()+"'");
				}else{
					sb.append(",'"+orTplNItmDO.getId_srv()+"'");
				}
			}
			
			throw new BizException("IIH.CI.LC表[bd_srv_ortmpl_itm]的字段[id_srv]中的值"+sb.toString()+"在引用表[bd_srv][bd_srv_ortmpl]中查询不到相应记录！(请检查中间库和目标库数据)");
		}
		return true;
	}

}
