//using System;
//using System.Collections.Generic;
////using iih.ci.ord.ciorder.s.itf;
//using xap.mw.core.utils;
//using xap.mw.coreitf.d;
//using xap.mw.serviceframework;
//using xap.rui.appfw;
//using xap.mw.core.data;
//using xap.sys.appfw.tmpl.qryscheme; 
//using iih.ci.ord.ciorder.d;
//using xap.sys.basebiz.appfwdata;
//using xap.sys.appfw.tmpl.qryscheme.qrydto;

//namespace iih.ci.ord.ciorder.i
//{
//    public class IOrdApConsDOCrudServiceImpl : IOrdApConsDOCrudService
//    {
//        private string url   = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.ciorder.i.IOrdApConsDOCudService";//ConfigUtil.getServiceUrl();
//        private string url_r = XapSvrConfig.BaseUrl + "iihci.ord/iih.ci.ord.ciorder.i.IOrdApConsDORService";//ConfigUtil.getServiceUrl();
        
//        private ServiceInvocation si;
//        private CacheHelper<OrdApConsDO> ch;
//        /// <summary>
//        /// 构造函数
//        /// </summary>
//        public IOrdApConsDOCrudServiceImpl()
//        {
//            ch = new CacheHelper<OrdApConsDO>();
//            si = new ServiceInvocationImpl();
//            si.url = url;
//        }

//        /// <summary>
//        /// 临床医嘱AggDO数据删除
//        /// </summary>
//        /// <param name="aggdos"></param>
//        public void delete(OrdApConsDO[] aggdos)
//        {
//            List<object> param = new List<object>();
//            param.Add(aggdos);
//            si.url = url;
//            si.invokeList<OrdApConsDO>("delete", param.ToArray());  
//        }

//        /// <summary>
//        /// 临床医嘱AggDO数据插入保存
//        /// </summary>
//        /// <param name="aggdos"></param>
//        /// <returns></returns>
//        public OrdApConsDO[] insert(OrdApConsDO[] aggdos)
//        {
//            List<object> param = new List<object>();
//            param.Add(aggdos);
//            si.url = url;
//            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("insert", param.ToArray());
//            return rtn;
//        }

//        /// <summary>
//        /// 临床医嘱AggDO数据保存
//        /// </summary>
//        /// <param name="aggdos"></param>
//        /// <returns></returns>
//        public OrdApConsDO[] save(OrdApConsDO[] aggdos)
//        {
//            List<object> param = new List<object>();
//            param.Add(aggdos);
//            si.url = url;
//            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("save", param.ToArray());
//            return rtn;
//        }

//        /// <summary>
//        /// 临床医嘱AggDO数据更新
//        /// </summary>
//        /// <param name="aggdos"></param>
//        /// <returns></returns>
//        public OrdApConsDO[] update(OrdApConsDO[] aggdos)
//        {
//            List<object> param = new List<object>();
//            param.Add(aggdos);
//            si.url = url;
//            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("update", param.ToArray());
//            return rtn;
//        }

//        /// <summary>
//        /// 临床医嘱AggDO数据真删
//        /// </summary>
//        /// <param name="aggdos"></param>
//        public void logicDelete(OrdApConsDO[] aggdos)
//        {
//            List<object> param = new List<object>();
//            param.Add(aggdos);
//            si.url = url;
//            si.invokeList<OrdApConsDO>("logicDelete", param.ToArray());  //??
//        }

//        /// <summary>
//        /// 根据id值查找临床医嘱AggDO数据
//        /// </summary>
//        /// <param name="id"></param>
//        /// <returns></returns>
//        public OrdApConsDO findById(String id)
//        {
//            #region "缓存处理"
//            if (ch.IsCached("findById"))
//            {
//                return ch.findById(id);
//            }
//            #endregion
//            List<object> param = new List<object>();
//            param.Add(id);
//            si.url = url_r;
//            OrdApConsDO rtn = si.invoke<OrdApConsDO>("findById", param.ToArray());
//            return rtn;
//        }

//        /// <summary>
//        /// 根据id值集合查找临床医嘱AggDO数据集合
//        /// </summary>
//        /// <param name="ids"></param>
//        /// <param name="isLazy"></param>
//        /// <returns></returns>
//        public OrdApConsDO[] findByIds(String[] ids, FBoolean isLazy)
//        {
//            #region "缓存处理"
//            if (ch.IsCached("findByIds"))
//            {
//                return ch.findByIds(ids, isLazy);
//            }
//            #endregion
//            List<object> param = new List<object>();
//            param.Add(ids);
//            param.Add(isLazy);
//            si.url = url_r;
//            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("findByIds", param.ToArray());
//            return rtn;
//        }

//        /// <summary>
//        /// 根据id值集合查找临床医嘱AggDO数据集合--大数据量
//        /// </summary>
//        /// <param name="ids"></param>
//        /// <param name="isLazy"></param>
//        /// <returns></returns>
//        public OrdApConsDO[] findByBIds(String[] ids, FBoolean isLazy)
//        {
//            #region "缓存处理"
//            if (ch.IsCached("findByBIds"))
//            {
//                return ch.findByBIds(ids, isLazy);
//            }
//            #endregion
//            List<object> param = new List<object>();
//            param.Add(ids);
//            param.Add(isLazy);
//            si.url = url_r;
//            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("findByBIds", param.ToArray());
//            return rtn;
//        }

//        /// <summary>
//        /// 根据condition条件查找临床医嘱AggDO数据集合
//        /// </summary>
//        /// <param name="condition"></param>
//        /// <param name="isLazy"></param>
//        /// <returns></returns>
//        public OrdApConsDO[] find(String condition, string orderStr, FBoolean isLazy)
//        {
//            #region "缓存处理"
//            if (ch.IsCached("find"))
//            {
//                return ch.find(condition, orderStr, isLazy);
//            }
//            #endregion
//            List<object> param = new List<object>();
//            param.Add(condition);
//            param.Add(orderStr);
//            param.Add(isLazy);
//            si.url = url_r;
//            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("find", param.ToArray());
//            return rtn;
//        }

//        /// <summary>
//        /// 根据查询方案查找临床医嘱AggDO数据集合
//        /// </summary>
//        /// <param name="qscheme"></param>
//        /// <returns></returns>
//        public OrdApConsDO[] findByQScheme(IQryScheme qscheme)
//        {
//            #region "缓存处理"
//            if (ch.IsCached("findByQScheme"))
//            {
//                return ch.findByQScheme(qscheme);
//            }
//            #endregion
//            List<object> param = new List<object>();
//            param.Add(qscheme);
//            si.url = url_r;
//            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("findByQScheme", param.ToArray());
//            return rtn;
//        }

//        /// <summary>
//        /// 根据分页信息及查询与分组条件获得分页数据
//        /// </summary>
//        /// <param name="pg"></param>
//        /// <param name="wherePart"></param>
//        /// <param name="orderByPart"></param>
//        /// <returns>PagingRtnData</returns>
//        public PagingRtnData<OrdApConsDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart)
//        {
//            List<object> param = new List<object>();
//            param.Add(pg);
//            param.Add(wherePart);
//            param.Add(orderByPart);
//            si.url = url_r;
//            PagingRtnData<OrdApConsDO> rtn = si.invokePaging<OrdApConsDO>("findByPageInfo", param.ToArray());
//            return rtn;
//        }
        
//        /// <summary>
//        /// 批量启用：全部都启用；或者出现异常，启用全部失败
//        /// </summary>
//        /// <param name="dos"></param>
//        public OrdApConsDO[] enableWithoutFilter(OrdApConsDO[] dos)
//        {
//            List<object> param = new List<object>();
//            param.Add(dos);
//            si.url = url;
//            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("enableWithoutFilter", param.ToArray());
//            return rtn;
//        }
	    
//        /// <summary>
//        /// 批量启用：可部分启用成功；
//        /// 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
//        /// </summary>
//        /// <param name="dos"></param>
//        public DOWithErrLog enableDO(OrdApConsDO[] dos) 
//        {
//            List<object> param = new List<object>();
//            param.Add(dos);
//            si.url = url;
//            DOWithErrLog rtn = si.invoke<DOWithErrLog>("enableDO", param.ToArray());
//            return rtn;
//        }
	    
//        /// <summary>
//        /// 批量停用：要不全部都停用；或者出现异常，停用全部失败
//        /// </summary>
//        /// <param name="dos"></param>
//        public OrdApConsDO[] disableVOWithoutFilter(OrdApConsDO[] dos) 
//        {
//            List<object> param = new List<object>();
//            param.Add(dos);
//            si.url = url;
//            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("disableVOWithoutFilter", param.ToArray());
//            return rtn;
//        }
	    
//        /// <summary>
//        /// 批量停用：可部分停用成功；
//        /// 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
//        /// </summary>
//        /// <param name="dos"></param>
//        public DOWithErrLog disableDO(OrdApConsDO[] dos) 
//        {
//            List<object> param = new List<object>();
//            param.Add(dos);
//            si.url = url;
//            DOWithErrLog rtn = si.invoke<DOWithErrLog>("disableDO", param.ToArray());
//            return rtn;
//        }
        
//        /// <summary>
//        /// 根据查询方案查询聚合数据集合
//        /// </summary>
//        /// <param name="qryRootNodeDTO"></param>
//        /// <param name="orderStr"></param>
//        /// <param name="isLazy"></param>
//        public OrdApConsDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy)
//        {
//            List<object> param = new List<object>();
//            param.Add(qryRootNodeDTO);
//            param.Add(orderStr);
//            param.Add(isLazy);
//            si.url = url_r;
//            OrdApConsDO[] rtn = si.invokeList<OrdApConsDO>("findByQCond", param.ToArray());
//            return rtn;
//        }
//    }
//}