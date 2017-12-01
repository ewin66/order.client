package iih.ci.ord.s.bp.impt;

import iih.bd.srv.medsrv.d.MedSrvDO;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import xap.mw.core.data.BizException;
import xap.mw.jdbc.datasource.DataSourceManager;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

public class BdSrvImportServiceImpl extends BaseDataImport<MedSrvDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		// 1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		MedSrvDO[] dos = getDOsFromImportDB(new MedSrvDO(), "1=1", false);
		if (ArrayUtils.isEmpty(dos))
			throw new BizException("医疗服务导入数据为空！");

		// 2、名称编码校验
		// checkNullValue(Arrays.asList(MedSrvDO.NAME, MedSrvDO.CODE), dos);
		return true;
	}

	@Override
	public boolean importData() throws BizException {
		// 1、从导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		MedSrvDO[] dos = getDOsFromImportDB(new MedSrvDO(), "1=1", true);
		if (ArrayUtils.isEmpty(dos))
			throw new BizException("医疗服务导入数据为空！");

		// 3、状态改为New
		processDOs(dos);

		// 4、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOArrayWithPK(dos);
		// ServiceFinder.find(IMedsrvMDOCudService.class).insert(dos);
		DAFacade da = new DAFacade();
		da.execUpdate(
				"update bd_srv set srvca_innercode=(select innercode from bd_srvca where bd_srv.id_srvca = bd_srvca.id_srvca)");
		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from " + new MedSrvDO().getTableName() + "" + " where "
				+ new MedSrvDO().getPKFieldName() + " not like '@@@@%'");
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[] { new MedSrvDO().getTableName() };
	}

	@Override
	public boolean checkBusiness() throws BizException {
		// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得

		// DAFacade daFacade = new DAFacade();
		DAFacade daFacade = new DAFacade(DataSourceManager.DEFAULT_IMPORT_DS);
		List<MedSrvDO> doses = (List<MedSrvDO>) daFacade.findByCond((new MedSrvDO()).getClass(), " 1=1  ");
		StringBuilder sb = new StringBuilder();
		for (MedSrvDO medSrvDO : doses) {
			String med = medSrvDO.toString();
			char[] sc = med.toCharArray();

			int k = 0;
			for (char c : sc) {
				// sb.append(c + ",");

				if (c < 0x20 || c == 0x7F) {

					sb.append(medSrvDO.getId_srv() + ","+getvalname( med,sc, k)+";");
					// break;
				}
				k++;
			}

		}
		if (sb.length() > 0) {
			throw new BizException("IIH.CI.LC表[bd_srv] [id_srv]中的值为" + sb.toString() + "的数据存在不可见字符");

		}

		return true;
	}
	
	private String getvalname(String med,char[] sc,int k){
		
		StringBuilder sb = new StringBuilder();
		int j=0;
		for (int i=k;i>0; i--) {
			// sb.append(c + ",");
         if(sc[i]=='('&&sc[i-1]==':'){
        	 j=i-1;
        	 break;
         }
		
		
		}
		
		for (int i=j-1;i>=0; i--) {
			// sb.append(c + ",");
			
         if(sc[i]==','){
        	 break;
         }	
		sb.append(sc[i]);
		}
		return sb.reverse().toString();
		
	}

}
