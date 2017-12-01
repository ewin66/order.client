package iih.ci.ord.ciorderms.s;

import iih.bd.srv.d.DiagDicaDTO;
import iih.ci.ord.ciordems.d.EmsHeadDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciordems.i.ICiordermsCudService;
import iih.ci.ord.ciordems.i.ICiordermsRService;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.desc.CiorderAggDODesc;
import iih.ci.ord.ciorder.i.ICiorderCudService;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
 

/**
 * 医嘱数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiordermsCudService.class,ICiordermsRService.class}, binding=Binding.JSONRPC)
public class CiordermsCrudServiceImpl implements ICiordermsCudService,ICiordermsRService{

 



 
	@Override
	public EmsHeadDO[] save(EmsHeadDO[] aggdos,Integer ordertype) throws BizException {
		CiorderAggDO[] aggs=new CiorderAggDO[aggdos.length];
	 for(int i=0;i< aggdos.length;i++)
	 {
		 aggs[i].getParentDO().setCode_or(aggdos[i].getCode()) ;
		 
		
	 }
	 switch (ordertype) {
	case 1:
		
		break;

	default:
		break;
	}
	 ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
	 
        service.insert(aggs);
	 
		// TODO Auto-generated method stub
		return aggdos;
	}

	@Override
	public void delete(EmsHeadDO[] aggdos, Integer ordertype) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmsHeadDO[] insert(EmsHeadDO[] aggdos, Integer ordertype)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmsHeadDO[] update(EmsHeadDO[] aggdos, Integer ordertype)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logicDelete(EmsHeadDO[] aggdos,Integer ordertype)
			throws BizException {
		// TODO Auto-generated method stub
		
	}




	@Override
	public EmsHeadDO[] find(String whereStr, String orderStr, Integer ordertype)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmsHeadDO findById(String id, Integer ordertype) throws BizException {
		// TODO Auto-generated method stub
		EmsHeadDO emdo=new EmsHeadDO();
		//String sql ="select * from BD_SRV t left join bd_srv_rel_mm t1 on t.id_srv = t1.id_srv left join bd_mm t2 on t1.id_mm=t2.id_mm  where t1.sortno=1";
		String sql="select * from BD_SRV A left outer join bd_mm B on A.id_srv=B.id_srv ";
		
	@SuppressWarnings("unchecked")
	List<EmsHeadDO> list = (List<EmsHeadDO>)new DAFacade().execQuery(sql, new BeanListHandler(DiagDicaDTO.class));
		if(list.size()>0)
		return  list.get(0);
		return null; 
	}
}
