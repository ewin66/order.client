﻿using System;
using System.Collections.Generic;
//using iih.ci.mr.nu.obstetrics.gynurafter.s.itf;
using xap.mw.core.utils;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme; 
using iih.ci.mr.nu.obstetrics.gynurafter.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.gynurafter.i
{
    public class IGynurafterCrudServiceImpl : IGynurafterCrudService
    {
        private string url   = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.nu.obstetrics.gynurafter.i.IGynurafterCudService";//ConfigUtil.getServiceUrl();
        private string url_r = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.nu.obstetrics.gynurafter.i.IGynurafterRService";//ConfigUtil.getServiceUrl();
        
        private ServiceInvocation si;
		private CacheHelper<GynurafterAggDO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IGynurafterCrudServiceImpl()
        {
        	ch = new CacheHelper<GynurafterAggDO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 妇科护理记录单(术后)AggDO数据真删除
        /// </summary>
        /// <param name="aggdos"></param>
        public void delete(GynurafterAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            si.invokeList<GynurafterAggDO>("delete", param.ToArray());  
        }

        /// <summary>
        /// 妇科护理记录单(术后)AggDO数据插入保存
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public GynurafterAggDO[] insert(GynurafterAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("insert", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 妇科护理记录单(术后)AggDO数据保存
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public GynurafterAggDO[] save(GynurafterAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("save", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 妇科护理记录单(术后)AggDO数据更新
        /// </summary>
        /// <param name="aggdos"></param>
        /// <returns></returns>
        public GynurafterAggDO[] update(GynurafterAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("update", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 妇科护理记录单(术后)AggDO数据逻辑删除
        /// </summary>
        /// <param name="aggdos"></param>
        public void logicDelete(GynurafterAggDO[] aggdos)
        {
            List<object> param = new List<object>();
            param.Add(aggdos);
            si.url = url;
            si.invokeList<GynurafterAggDO>("logicDelete", param.ToArray());  //??
        }

        /// <summary>
        /// 根据id值查找妇科护理记录单(术后)AggDO数据
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public GynurafterAggDO findById(String id)
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
            GynurafterAggDO rtn = si.invoke<GynurafterAggDO>("findById", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 根据id值集合查找妇科护理记录单(术后)AggDO数据集合
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public GynurafterAggDO[] findByIds(String[] ids, FBoolean isLazy)
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
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("findByIds", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据id值集合查找妇科护理记录单(术后)AggDO数据集合--大数据量
        /// </summary>
        /// <param name="ids"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public GynurafterAggDO[] findByBIds(String[] ids, FBoolean isLazy)
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
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("findByBIds", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据condition条件查找妇科护理记录单(术后)AggDO数据集合
        /// </summary>
        /// <param name="condition"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public GynurafterAggDO[] find(String condition, string orderStr, FBoolean isLazy)
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
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("find", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据condition条件及管控查找妇科护理记录单(术后)AggDO数据集合
        /// </summary>
        /// <param name="condition"></param>
        /// <param name="isLazy"></param>
        /// <returns></returns>
        public GynurafterAggDO[] findByBDMode(String condition, string orderStr, FBoolean isLazy)
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
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("findByBDMode", param.ToArray());
            #region "数据缓存逻辑新增"
            handleRtn(rtn);
            #endregion
            return rtn;
        }

        /// <summary>
        /// 根据查询方案查找妇科护理记录单(术后)AggDO数据集合
        /// </summary>
        /// <param name="qscheme"></param>
        /// <returns></returns>
        public GynurafterAggDO[] findByQScheme(IQryScheme qscheme)
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
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("findByQScheme", param.ToArray());
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
        public PagingRtnData<GynurafterAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy)
        {
            List<object> param = new List<object>();
		    param.Add(pg);
		    param.Add(wherePart);
		    param.Add(orderByPart);
		    param.Add(isLazy);
            si.url = url_r;
            PagingRtnData<GynurafterAggDO> rtn = si.invokePaging<GynurafterAggDO>("findByPageInfo", param.ToArray());
            return rtn;
        }  
        
        /// <summary>
        /// 根据分页信息、查询与分组条件及管控获得分页数据
        /// </summary>
        /// <param name="pg"></param>
        /// <param name="wherePart"></param>
        /// <param name="orderByPart"></param>
        /// <param name="isLazy"></param>
        /// <returns>PagingRtnData</returns>
        public PagingRtnData<GynurafterAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy)
        {
            List<object> param = new List<object>();
		    param.Add(pg);
		    param.Add(wherePart);
		    param.Add(orderByPart);
		    param.Add(isLazy);
            si.url = url_r;
            PagingRtnData<GynurafterAggDO> rtn = si.invokePaging<GynurafterAggDO>("findByPageInfoAndBDMode", param.ToArray());
            return rtn;
        }  
        
        /// <summary>
        /// 根据查询模板条件、分页信息查询分页数据集合
        /// </summary>
        /// <param name="qryRootNodeDTO"></param>
        /// <param name="orderStr"></param>
        /// <param name="pg"></param>
        /// <param name="isLazy"></param>
        public PagingRtnData<GynurafterAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy)
        {
            List<object> param = new List<object>();
		    param.Add(qryRootNodeDTO);
		    param.Add(orderStr);
		    param.Add(pg);
		    param.Add(isLazy);
            si.url = url_r;
            PagingRtnData<GynurafterAggDO> rtn = si.invokePaging<GynurafterAggDO>("findByQCondAndPageInfo", param.ToArray());
            return rtn;
        }
        
        /// <summary>
        /// 根据主DO对妇科护理记录单(术后)AggDO数据真删除
        /// </summary>
        /// <param name="mainDos"></param>
        public void deleteByParentDO(GyNurAfterAssDO[] mainDos){
            List<object> param = new List<object>();
            param.Add(mainDos);
            si.url = url;
            si.invokeList<GyNurAfterAssDO>("deleteByParentDO", param.ToArray());  
        }
        
        /// <summary>
        /// 根据主DO对妇科护理记录单(术后)AggDO数据逻辑删除
        /// </summary>
        /// <param name="mainDos"></param>
        public void logicDeleteByParentDO(GyNurAfterAssDO[] mainDos){
            List<object> param = new List<object>();
            param.Add(mainDos);
            si.url = url;
            si.invokeList<GyNurAfterAssDO>("logicDeleteByParentDO", param.ToArray());  
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
        public GynurafterAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(orderStr);
            param.Add(isLazy);
            si.url = url_r;
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("findByQCond", param.ToArray());
            return rtn;
        }
        
        /// <summary>
        /// 根据DO某一字符类型属性值查询DO数据
        /// <summary>
        /// <param name="attr"></param>
        /// <param name="value"></param>
        /// <returns>GynurafterAggDO[]</return>
        public GynurafterAggDO[] findByAttrValString(string attr, string value)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(value);
            si.url=url_r;
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("findByAttrValString", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 根据DO某一字符类型属性值数组查询DO数据
        /// <summary>
        /// <param name="attr"></param>
        /// <param name="values"></param>
        /// <returns>GynurafterAggDO[]</return>
        public GynurafterAggDO[] findByAttrValStrings(string attr, string[] values)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(values);
            si.url=url_r;
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("findByAttrValStrings", param.ToArray());
            return rtn;
        }
        /// <summary>
        /// 根据DO某一属性值List查询DO数据
        /// <summary>
        /// <param name="attr"></param>
        /// <param name="values"></param>
        /// <returns>GynurafterAggDO[]</return>
        public GynurafterAggDO[] findByAttrValList(string attr, FArrayList values)
        {
            List<object> param = new List<object>();
            param.Add(attr);
            param.Add(values);
            si.url=url_r;
            GynurafterAggDO[] rtn = si.invokeList<GynurafterAggDO>("findByAttrValList", param.ToArray());
            return rtn;
        }
    }
}