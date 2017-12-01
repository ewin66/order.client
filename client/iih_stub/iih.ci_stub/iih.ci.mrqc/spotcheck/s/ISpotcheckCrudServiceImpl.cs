using System;
using System.Collections.Generic;
//using iih.ci.mrqc.spotcheck.s.itf;
using xap.mw.core.utils;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme; 
using iih.ci.mrqc.spotcheck.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.spotcheck.i
{
    public class ISpotcheckCrudServiceImpl : ISpotcheckCrudService
    {
        private string url   = XapSvrConfig.BaseUrl + "iihci.mrqc/iih.ci.mrqc.spotcheck.i.ISpotcheckCudService";//ConfigUtil.getServiceUrl();
        private string url_r = XapSvrConfig.BaseUrl + "iihci.mrqc/iih.ci.mrqc.spotcheck.i.ISpotcheckRService";//ConfigUtil.getServiceUrl();
        
        private ServiceInvocation si;
		private CacheHelper<CiAmrSpotCheckRecordDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public ISpotcheckCrudServiceImpl()
        {
        	ch = new CacheHelper<CiAmrSpotCheckRecordDO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 门诊病历抽查AggDO数据真删除
        /// </summary>
        /// <param name="aggdos"></param>
        public void delete(CiAmrSpotCheckRecordDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            si.invokeList<CiAmrSpotCheckRecordDO>("delete", param.ToArray());  
        }

        /// <summary>
        /// 门诊病历抽查AggDO数据插入保存
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public CiAmrSpotCheckRecordDO[] insert(CiAmrSpotCheckRecordDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("insert", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 门诊病历抽查AggDO数据保存
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public CiAmrSpotCheckRecordDO[] save(CiAmrSpotCheckRecordDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("save", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 门诊病历抽查AggDO数据更新
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public CiAmrSpotCheckRecordDO[] update(CiAmrSpotCheckRecordDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("update", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 门诊病历抽查AggDO数据逻辑删除
        /// </summary>
        /// <param name="aggdos"></param>
        public void logicDelete(CiAmrSpotCheckRecordDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            si.invokeList<CiAmrSpotCheckRecordDO>("logicDelete", param.ToArray());  //??
        }

        /// <summary>
        /// 根据id值查找门诊病历抽查AggDO数据
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public CiAmrSpotCheckRecordDO findById(String id)
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
            CiAmrSpotCheckRecordDO rtn = si.invoke<CiAmrSpotCheckRecordDO>("findById", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据id值集合查找门诊病历抽查AggDO数据集合
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public CiAmrSpotCheckRecordDO[] findByIds(String[] ids, FBoolean isLazy)
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
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("findByIds", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据id值集合查找门诊病历抽查AggDO数据集合--大数据量
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public CiAmrSpotCheckRecordDO[] findByBIds(String[] ids, FBoolean isLazy)
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
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("findByBIds", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据condition条件查找门诊病历抽查AggDO数据集合
        /// </summary>
        /// <param name="condition"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public CiAmrSpotCheckRecordDO[] find(String condition, string orderStr, FBoolean isLazy)
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
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("find", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据查询方案查找门诊病历抽查AggDO数据集合
        /// </summary>
        /// <param name="qscheme"></param>
        /// <returns></returns>
        public CiAmrSpotCheckRecordDO[] findByQScheme(IQryScheme qscheme)
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
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("findByQScheme", param.ToArray());
            return rtn;
        }

	 	/// <summary>
        /// 根据分页信息及查询与分组条件获得分页数据
        /// </summary>
        /// <param name="pg"></param>
		/// <param name="wherePart"></param>
		/// <param name="orderByPart"></param>
        /// <returns>PagingRtnData</returns>
        public PagingRtnData<CiAmrSpotCheckRecordDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart)
        {
            List<object> param = new List<object>();
	    	param.Add(pg);
	    	param.Add(wherePart);
	   		param.Add(orderByPart);
            si.url = url_r;
            PagingRtnData<CiAmrSpotCheckRecordDO> rtn = si.invokePaging<CiAmrSpotCheckRecordDO>("findByPageInfo", param.ToArray());
            return rtn;
        }
        
        /// <summary>
        /// 根据查询模板条件、分页信息查询分页数据集合
        /// </summary>
        /// <param name="qryRootNodeDTO"></param>
        /// <param name="orderStr"></param>
        /// <param name="pg"></param>
        public PagingRtnData<CiAmrSpotCheckRecordDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg)
        {
            List<object> param = new List<object>();
	    	param.Add(qryRootNodeDTO);
	    	param.Add(orderStr);
	   		param.Add(pg);
            si.url = url_r;
            PagingRtnData<CiAmrSpotCheckRecordDO> rtn = si.invokePaging<CiAmrSpotCheckRecordDO>("findByQCondAndPageInfo", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 批量启用：全部都启用；或者出现异常，启用全部失败
        /// </summary>
        /// <param name="dos"></param>
	    public CiAmrSpotCheckRecordDO[] enableWithoutFilter(CiAmrSpotCheckRecordDO[] dos)
	    {
	        List<object> param = new List<object>();
	        param.Add(dos);
	        si.url = url;
	        CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("enableWithoutFilter", param.ToArray());
	        return rtn;
	    }
	    
	    /// <summary>
        /// 批量启用：可部分启用成功；
        /// 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
        /// </summary>
        /// <param name="dos"></param>
	    public DOWithErrLog enableDO(CiAmrSpotCheckRecordDO[] dos) 
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
	    public CiAmrSpotCheckRecordDO[] disableVOWithoutFilter(CiAmrSpotCheckRecordDO[] dos) 
	    {
	        List<object> param = new List<object>();
	        param.Add(dos);
	        si.url = url;
	        CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("disableVOWithoutFilter", param.ToArray());
	        return rtn;
	    }
	    
	    /// <summary>
        /// 批量停用：可部分停用成功；
        /// 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
        /// </summary>
        /// <param name="dos"></param>
	    public DOWithErrLog disableDO(CiAmrSpotCheckRecordDO[] dos) 
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
        public CiAmrSpotCheckRecordDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(orderStr);
            param.Add(isLazy);
            si.url = url_r;
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("findByQCond", param.ToArray());
            return rtn;
        }
        
        /// <summary>
        /// 根据DO某一字符类型属性值查询DO数据
        /// <summary>
        /// <param name="attr"></param>
        /// <param name="value"></param>
        /// <returns>CiAmrSpotCheckRecordDO[]</return>
        public CiAmrSpotCheckRecordDO[] findByAttrValString(string attr, string value)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(value);
            si.url=url_r;
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("findByAttrValString", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 根据DO某一字符类型属性值数组查询DO数据
        /// <summary>
        /// <param name="attr"></param>
        /// <param name="values"></param>
        /// <returns>CiAmrSpotCheckRecordDO[]</return>
        public CiAmrSpotCheckRecordDO[] findByAttrValStrings(string attr, string[] values)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(values);
            si.url=url_r;
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("findByAttrValStrings", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 根据DO某一属性值List查询DO数据
        /// <summary>
        /// <param name="attr"></param>
        /// <param name="values"></param>
        /// <returns>CiAmrSpotCheckRecordDO[]</return>
        public CiAmrSpotCheckRecordDO[] findByAttrValList(string attr, FArrayList values)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(values);
            si.url=url_r;
            CiAmrSpotCheckRecordDO[] rtn = si.invokeList<CiAmrSpotCheckRecordDO>("findByAttrValList", param.ToArray());
            return rtn;
        }
    }
}