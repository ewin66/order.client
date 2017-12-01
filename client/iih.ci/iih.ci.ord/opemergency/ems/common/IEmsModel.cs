using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.ci.iih.ci.ord.ems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.ems.d;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 : 医疗单数据处理接口             </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems.dp  </para>    
    /// <para>类 名 称 :     public interface IEmsDP </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                           </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                  </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05             </para> 
    /// <para>说    明 :                              </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public interface IEmsModel
    {
        /// <summary>
        /// 增加空的模型条目
        /// </summary>
        /// <returns></returns>
        object AddNew();

        /// <summary>
        /// 编辑医嘱信息
        /// </summary>
        /// <param name="ciOrderDO"></param>
        void EditOrder(CiOrderDO ciOrderDO);

        void EditEms(CiEmsDTO ems);

        /// <summary>
        /// 从 Med 加载医嘱信息
        /// </summary>
        /// <param name="med"></param>
        /// <param name="pos"></param>
        /// <returns></returns>
        bool LoadMedSrv(EmsCreatedParameter emsCreateParameter, int pos = -1);

        bool CreateEmsFrom(String id_srv, String id_mm);

        /// <summary>
        /// 删除数据
        /// </summary>
        /// <param name="index"></param>
        void DeleteItemData(int index);

        /// <summary>
        /// 删除数据
        /// </summary>
        /// <param name="value"></param>
        void DeleteItemData(object value);

        /// <summary>
        /// 保存数据，返回CiOrderDO
        /// </summary>
        CiOrderDO Save2Order();
        /// <summary>
        /// 医嘱新的保存返回集合
        /// </summary>
        /// <returns></returns>
        CiOrderTransMissionDTO SaveNew();
        /// <summary>
        /// 设置当前编辑条目
        /// </summary>
        /// <param name="cursel"></param>
        void SetSelectedObject(object cursel);

        /// <summary>
        /// 获取当前编辑服务条目
        /// </summary>
        /// <returns></returns>
        object GetSelectedObject();

        /// <summary>
        /// 整体UI对象集合
        /// </summary>
        /// <returns></returns>
        object GetEmsUIDTO();
    }
}
