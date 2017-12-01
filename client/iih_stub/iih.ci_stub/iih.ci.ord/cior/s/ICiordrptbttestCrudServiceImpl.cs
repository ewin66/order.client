using System;
using System.Collections.Generic;
//using iih.ci.ord.cior.s.itf;
using xap.mw.core.utils;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme; 
using iih.ci.ord.cior.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cior.i
{
    public class ICiordrptbttestCrudServiceImpl : ICiordrptbttestCrudService
    {
        private string url   = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.cior.i.ICiordrptbttestCudService";//ConfigUtil.getServiceUrl();
        private string url_r = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.cior.i.ICiordrptbttestRService";//ConfigUtil.getServiceUrl();
        
        private ServiceInvocation si;
		private CacheHelper<CiordrptbttestAggDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public ICiordrptbttestCrudServiceImpl()
        {
        	ch = new CacheHelper<CiordrptbttestAggDO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 备血检验结果AggDO数据真删除
        /// </summary>
        /// <param name="aggdos"></param>
        public void delete(CiordrptbttestAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            si.invokeList<CiordrptbttestAggDO>("delete", param.ToArray());  
        }

        /// <summary>
        /// 备血检验结果AggDO数据插入保存
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public CiordrptbttestAggDO[] insert(CiordrptbttestAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("insert", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 备血检验结果AggDO数据保存
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public CiordrptbttestAggDO[] save(CiordrptbttestAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("save", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 备血检验结果AggDO数据更新
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public CiordrptbttestAggDO[] update(CiordrptbttestAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("update", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 备血检验结果AggDO数据逻辑删除
        /// </summary>
        /// <param name="aggdos"></param>
        public void logicDelete(CiordrptbttestAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            si.invokeList<CiordrptbttestAggDO>("logicDelete", param.ToArray());  //??
        }

        /// <summary>
        /// 根据id值查找备血检验结果AggDO数据
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public CiordrptbttestAggDO findById(String id)
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
            CiordrptbttestAggDO rtn = si.invoke<CiordrptbttestAggDO>("findById", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据id值集合查找备血检验结果AggDO数据集合
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public CiordrptbttestAggDO[] findByIds(String[] ids, FBoolean isLazy)
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
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("findByIds", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据id值集合查找备血检验结果AggDO数据集合--大数据量
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public CiordrptbttestAggDO[] findByBIds(String[] ids, FBoolean isLazy)
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
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("findByBIds", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据condition条件查找备血检验结果AggDO数据集合
        /// </summary>
        /// <param name="condition"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public CiordrptbttestAggDO[] find(String condition, string orderStr, FBoolean isLazy)
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
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("find", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据查询方案查找备血检验结果AggDO数据集合
        /// </summary>
        /// <param name="qscheme"></param>
        /// <returns></returns>
        public CiordrptbttestAggDO[] findByQScheme(IQryScheme qscheme)
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
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("findByQScheme", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据分页信息及查询与分组条件获得分页数据
        /// </summary>
        /// <param name="pg"></param>
        /// <param name="wherePart"></param>
        /// <param name="orderByPart"></param>
        /// <param name="isLazy"></param>
        /// <returns>PagingRtnData</returns>
        public PagingRtnData<CiordrptbttestAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy)
        {
            List<object> param = new List<object>();
		    param.Add(pg);
		    param.Add(wherePart);
		    param.Add(orderByPart);
		    param.Add(isLazy);
            si.url = url_r;
            PagingRtnData<CiordrptbttestAggDO> rtn = si.invokePaging<CiordrptbttestAggDO>("findByPageInfo", param.ToArray());
            return rtn;
        }  
        
        /// <summary>
        /// 根据查询模板条件、分页信息查询分页数据集合
        /// </summary>
        /// <param name="qryRootNodeDTO"></param>
        /// <param name="orderStr"></param>
        /// <param name="pg"></param>
        /// <param name="isLazy"></param>
        public PagingRtnData<CiordrptbttestAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy)
        {
            List<object> param = new List<object>();
		    param.Add(qryRootNodeDTO);
		    param.Add(orderStr);
		    param.Add(pg);
		    param.Add(isLazy);
            si.url = url_r;
            PagingRtnData<CiordrptbttestAggDO> rtn = si.invokePaging<CiordrptbttestAggDO>("findByQCondAndPageInfo", param.ToArray());
            return rtn;
        }

		#region "数据缓存逻辑新增"
        /// <summary>
        /// 查询返回数据的处理
        /// </summary>
        /// <param name="aggdos"></param>
        private void handleRtn(BaseAggDO[] aggdos)
        {
            if (aggdos == null || aggdos.Length == 0 || aggdos.Length == 1) return;
            foreach (BaseAggDO agg in aggdos)
            {
                agg.service = this;
            }
        }
        #endregion
        
        /// <summary>
        /// 根据查询方案查询聚合数据集合
        /// </summary>
        /// <param name="qryRootNodeDTO"></param>
        /// <param name="orderStr"></param>
        /// <param name="isLazy"></param>
        public CiordrptbttestAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(orderStr);
            param.Add(isLazy);
            si.url = url_r;
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("findByQCond", param.ToArray());
            return rtn;
        }
        
        /// <summary>
        /// 根据DO某一字符类型属性值查询DO数据
        /// <summary>
        /// <param name="attr"></param>
        /// <param name="value"></param>
        /// <returns>CiordrptbttestAggDO[]</return>
        public CiordrptbttestAggDO[] findByAttrValString(string attr, string value)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(value);
            si.url=url_r;
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("findByAttrValString", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 根据DO某一字符类型属性值数组查询DO数据
        /// <summary>
        /// <param name="attr"></param>
        /// <param name="values"></param>
        /// <returns>CiordrptbttestAggDO[]</return>
        public CiordrptbttestAggDO[] findByAttrValStrings(string attr, string[] values)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(values);
            si.url=url_r;
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("findByAttrValStrings", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 根据DO某一属性值List查询DO数据
        /// <summary>
        /// <param name="attr"></param>
        /// <param name="values"></param>
        /// <returns>CiordrptbttestAggDO[]</return>
        public CiordrptbttestAggDO[] findByAttrValList(string attr, FArrayList values)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(values);
            si.url=url_r;
            CiordrptbttestAggDO[] rtn = si.invokeList<CiordrptbttestAggDO>("findByAttrValList", param.ToArray());
            return rtn;
        }
    }
}