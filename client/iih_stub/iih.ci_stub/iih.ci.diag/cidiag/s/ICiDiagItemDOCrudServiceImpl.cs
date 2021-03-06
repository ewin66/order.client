using System;
using System.Collections.Generic;
//using iih.ci.diag.cidiag.s.itf;
using xap.mw.core.utils;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme; 
using iih.ci.diag.cidiag.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.diag.cidiag.i
{
    public class ICiDiagItemDOCrudServiceImpl : ICiDiagItemDOCrudService
    {
        private string url   = XapSvrConfig.BaseUrl + "iihci.diag/iih.ci.diag.cidiag.i.ICiDiagItemDOCudService";//ConfigUtil.getServiceUrl();
        private string url_r = XapSvrConfig.BaseUrl + "iihci.diag/iih.ci.diag.cidiag.i.ICiDiagItemDORService";//ConfigUtil.getServiceUrl();
        
        private ServiceInvocation si;
		private CacheHelper<CiDiagItemDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public ICiDiagItemDOCrudServiceImpl()
        {
        	ch = new CacheHelper<CiDiagItemDO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 临床诊断AggDO数据删除
        /// </summary>
        /// <param name="aggdos"></param>
        public void delete(CiDiagItemDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            si.invokeList<CiDiagItemDO>("delete", param.ToArray());  
        }

        /// <summary>
        /// 临床诊断AggDO数据插入保存
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public CiDiagItemDO[] insert(CiDiagItemDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("insert", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 临床诊断AggDO数据保存
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public CiDiagItemDO[] save(CiDiagItemDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("save", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 临床诊断AggDO数据更新
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public CiDiagItemDO[] update(CiDiagItemDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("update", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 临床诊断AggDO数据真删
        /// </summary>
        /// <param name="aggdos"></param>
        public void logicDelete(CiDiagItemDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            si.invokeList<CiDiagItemDO>("logicDelete", param.ToArray());  //??
        }

        /// <summary>
        /// 根据id值查找临床诊断AggDO数据
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public CiDiagItemDO findById(String id)
        {
        	#region "缓存处理"
        	if (ch.IsCached("findById"))
            {
                return ch.findById(id);
            }
            #endregion
            List<object> param = new List<object>();
            param.Add(id);
            si.url = url_r;
            CiDiagItemDO rtn = si.invoke<CiDiagItemDO>("findById", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据id值集合查找临床诊断AggDO数据集合
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public CiDiagItemDO[] findByIds(String[] ids, FBoolean isLazy)
        {
        	#region "缓存处理"
         	if (ch.IsCached("findByIds"))
            {
                return ch.findByIds(ids, isLazy);
            }
            #endregion
            List<object> param = new List<object>();
            param.Add(ids);
            param.Add(isLazy);
            si.url = url_r;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("findByIds", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据id值集合查找临床诊断AggDO数据集合--大数据量
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public CiDiagItemDO[] findByBIds(String[] ids, FBoolean isLazy)
        {
        	#region "缓存处理"
        	if (ch.IsCached("findByBIds"))
            {
                return ch.findByBIds(ids, isLazy);
            }
            #endregion
            List<object> param = new List<object>();
            param.Add(ids);
            param.Add(isLazy);
            si.url = url_r;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("findByBIds", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据condition条件查找临床诊断AggDO数据集合
        /// </summary>
        /// <param name="condition"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public CiDiagItemDO[] find(String condition, string orderStr, FBoolean isLazy)
        {
        	#region "缓存处理"
        	if (ch.IsCached("find"))
            {
                return ch.find(condition, orderStr, isLazy);
            }
            #endregion
            List<object> param = new List<object>();
            param.Add(condition);
            param.Add(orderStr);
            param.Add(isLazy);
            si.url = url_r;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("find", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据查询方案查找临床诊断AggDO数据集合
        /// </summary>
        /// <param name="qscheme"></param>
        /// <returns></returns>
        public CiDiagItemDO[] findByQScheme(IQryScheme qscheme)
        {
        	#region "缓存处理"
        	if (ch.IsCached("findByQScheme"))
            {
                return ch.findByQScheme(qscheme);
            }
            #endregion
            List<object> param = new List<object>();
            param.Add(qscheme);
            si.url = url_r;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("findByQScheme", param.ToArray());
            return rtn;
        }

	 	/// <summary>
        /// 根据分页信息及查询与分组条件获得分页数据
        /// </summary>
        /// <param name="pg"></param>
		/// <param name="wherePart"></param>
		/// <param name="orderByPart"></param>
        /// <returns>PagingRtnData</returns>
        public PagingRtnData<CiDiagItemDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart)
        {
            List<object> param = new List<object>();
	    	param.Add(pg);
	    	param.Add(wherePart);
	   		param.Add(orderByPart);
            si.url = url_r;
            PagingRtnData<CiDiagItemDO> rtn = si.invokePaging<CiDiagItemDO>("findByPageInfo", param.ToArray());
            return rtn;
        }
        
        /// <summary>
        /// 批量启用：全部都启用；或者出现异常，启用全部失败
        /// </summary>
        /// <param name="dos"></param>
	    public CiDiagItemDO[] enableWithoutFilter(CiDiagItemDO[] dos)
	    {
	        List<object> param = new List<object>();
	        param.Add(dos);
	        si.url = url;
	        CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("enableWithoutFilter", param.ToArray());
	        return rtn;
	    }
	    
	    /// <summary>
        /// 批量启用：可部分启用成功；
        /// 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
        /// </summary>
        /// <param name="dos"></param>
	    public DOWithErrLog enableDO(CiDiagItemDO[] dos) 
	    {
	        List<object> param = new List<object>();
	        param.Add(dos);
	        si.url = url;
	        DOWithErrLog rtn = si.invoke<DOWithErrLog>("enableDO", param.ToArray());
	        return rtn;
	    }
	    
	    /// <summary>
        /// 批量停用：要不全部都停用；或者出现异常，停用全部失败
        /// </summary>
        /// <param name="dos"></param>
	    public CiDiagItemDO[] disableVOWithoutFilter(CiDiagItemDO[] dos) 
	    {
	        List<object> param = new List<object>();
	        param.Add(dos);
	        si.url = url;
	        CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("disableVOWithoutFilter", param.ToArray());
	        return rtn;
	    }
	    
	    /// <summary>
        /// 批量停用：可部分停用成功；
        /// 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
        /// </summary>
        /// <param name="dos"></param>
	    public DOWithErrLog disableDO(CiDiagItemDO[] dos) 
	    {
	        List<object> param = new List<object>();
	        param.Add(dos);
	        si.url = url;
	        DOWithErrLog rtn = si.invoke<DOWithErrLog>("disableDO", param.ToArray());
	        return rtn;
	    }
        
        /// <summary>
        /// 根据查询方案查询聚合数据集合
        /// </summary>
        /// <param name="qryRootNodeDTO"></param>
        /// <param name="orderStr"></param>
        /// <param name="isLazy"></param>
        public CiDiagItemDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(orderStr);
            param.Add(isLazy);
            si.url = url_r;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("findByQCond", param.ToArray());
            return rtn;
        }
        
        public CiDiagItemDO[] findByAttrValString(string attr, string value)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(value);
            si.url=url_r;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("findByAttrValString", param.ToArray());
            return rtn;
        }
        public CiDiagItemDO[] findByAttrValStrings(string attr, string[] values)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(values);
            si.url=url_r;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("findByAttrValStrings", param.ToArray());
            return rtn;
        }
        public CiDiagItemDO[] findByAttrValList(string attr, FArrayList values)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(values);
            si.url=url_r;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("findByAttrValList", param.ToArray());
            return rtn;
        }
    }
}