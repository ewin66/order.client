package iih.ci.mr.nu.i;

import iih.ci.mr.nu.dto.d.NurDocStructDEDTO;
import iih.ci.mr.nu.dto.d.NurDocStructDGDTO;
import iih.ci.mr.nu.dto.d.NurDocStructGridDTO;
import iih.ci.mr.nu.dto.d.NurDocStructTreeDTO;
import iih.ci.mr.nu.dto.d.StructTreeDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年5月10日 下午5:31:27
 * 类说明：护理文书结构化浏览自定义服务
 * Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public interface INurDocStructBrowserExtService {
	
	/**
	 * 查询医疗记录类型自定义分类和医疗记录类型组成的树
	 * @return
	 * @throws BizException
	 */
	public abstract NurDocStructTreeDTO[] getNurDocStructTreeDTOs()throws BizException;
	
	/**
	 * 查询结构化浏览器医疗记录列表数据
	 * @param id 医疗记录类型自定义分类ID 或者医疗记录类型ID
	 * @param id_dep_nur 住院病区ID
	 * @param id_bed 住院床号ID
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<NurDocStructGridDTO> getNurDocStructGridDTOs(PaginationInfo pg,String id,String id_dep_nur,String id_bed) throws BizException;
	
	/**
	 * 查询数据组相关属性
	 * @param id_mrdg 医疗记录数组ID
	 * @return
	 * @throws BizException
	 */
	public abstract NurDocStructDGDTO getNurDocStructDGDTO(String id_mrdg)throws BizException;
	
	/**
	 * 查询数据元相关属性以及父数据组属性
	 * @param id_mrdg 医疗记录数元ID
	 * @return
	 * @throws BizException
	 */
	public abstract NurDocStructDEDTO getNurDocStructDEDTO(String id_mrde)throws BizException;
	
	/**
	 * 查询数据生成结构化树
	 * @param id 医疗记录数元ID
	 * @return
	 * @throws BizException
	 */
	public abstract StructTreeDTO[] getStructTreeDTO(String id_mr)throws BizException;
}


