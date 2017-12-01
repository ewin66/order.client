using System;
using System.Collections.Generic;
//using iih.ci.pre.obspre.s.itf;
using xap.mw.core.utils;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme; 
using iih.ci.pre.obspre.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.pre.obspre.i
{
    public class IObspreCrudServiceImpl : IObspreCrudService
    {
        private string url   = XapSvrConfig.BaseUrl + "iihci.pre/iih.ci.pre.obspre.i.IObspreCudService";//ConfigUtil.getServiceUrl();
        private string url_r = XapSvrConfig.BaseUrl + "iihci.pre/iih.ci.pre.obspre.i.IObspreRService";//ConfigUtil.getServiceUrl();
        
        private ServiceInvocation si;
		private CacheHelper<ObspreAggDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IObspreCrudServiceImpl()
        {
        	ch = new CacheHelper<ObspreAggDO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 预检AggDO数据删除
        /// </summary>
        /// <param name="aggdos"></param>
        public void delete(ObspreAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            si.invokeList<ObspreAggDO>("delete", param.ToArray());  
        }

        /// <summary>
        /// 预检AggDO数据插入保存
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public ObspreAggDO[] insert(ObspreAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            ObspreAggDO[] rtn = si.invokeList<ObspreAggDO>("insert", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 预检AggDO数据保存
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public ObspreAggDO[] save(ObspreAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            ObspreAggDO[] rtn = si.invokeList<ObspreAggDO>("save", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 预检AggDO数据更新
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public ObspreAggDO[] update(ObspreAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            ObspreAggDO[] rtn = si.invokeList<ObspreAggDO>("update", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 预检AggDO数据真删
        /// </summary>
        /// <param name="aggdos"></param>
        public void logicDelete(ObspreAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            si.invokeList<ObspreAggDO>("logicDelete", param.ToArray());  //??
        }

        /// <summary>
        /// 根据id值查找预检AggDO数据
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public ObspreAggDO findById(String id)
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
            ObspreAggDO rtn = si.invoke<ObspreAggDO>("findById", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据id值集合查找预检AggDO数据集合
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public ObspreAggDO[] findByIds(String[] ids, FBoolean isLazy)
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
            ObspreAggDO[] rtn = si.invokeList<ObspreAggDO>("findByIds", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据id值集合查找预检AggDO数据集合--大数据量
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public ObspreAggDO[] findByBIds(String[] ids, FBoolean isLazy)
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
            ObspreAggDO[] rtn = si.invokeList<ObspreAggDO>("findByBIds", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据condition条件查找预检AggDO数据集合
        /// </summary>
        /// <param name="condition"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public ObspreAggDO[] find(String condition, string orderStr, FBoolean isLazy)
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
            ObspreAggDO[] rtn = si.invokeList<ObspreAggDO>("find", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据查询方案查找预检AggDO数据集合
        /// </summary>
        /// <param name="qscheme"></param>
        /// <returns></returns>
        public ObspreAggDO[] findByQScheme(IQryScheme qscheme)
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
            ObspreAggDO[] rtn = si.invokeList<ObspreAggDO>("findByQScheme", param.ToArray());
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
        public PagingRtnData<ObspreAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy)
        {
            List<object> param = new List<object>();
		    param.Add(pg);
		    param.Add(wherePart);
		    param.Add(orderByPart);
		    param.Add(isLazy);
            si.url = url_r;
            PagingRtnData<ObspreAggDO> rtn = si.invokePaging<ObspreAggDO>("findByPageInfo", param.ToArray());
            return rtn;
        }  

		#region "数据缓存逻辑新增"
        /// <summary>
        /// 查询返回数据的处理
        /// </summary>
        /// <param name="aggdos"></param>
        private void handleRtn(xap.mw.core.data.BaseAggDO[] aggdos)
        {
            if (aggdos == null || aggdos.Length == 0 || aggdos.Length == 1) return;
            foreach (xap.mw.core.data.BaseAggDO agg in aggdos)
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
        public ObspreAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(orderStr);
            param.Add(isLazy);
            si.url = url_r;
            ObspreAggDO[] rtn = si.invokeList<ObspreAggDO>("findByQCond", param.ToArray());
            return rtn;
        }
    }
}