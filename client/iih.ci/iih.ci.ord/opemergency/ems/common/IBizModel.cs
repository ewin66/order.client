using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciorder.d;
using xap.rui.control.refcontrol.data;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.ems.dp
{
    /// <summary>
    /// <para>描    述 : 模型数据处理接口                </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems.dp  </para>    
    /// <para>类 名 称 : IBizModel                       </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                           </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                  </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05             </para> 
    /// <para>说    明 :                     </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public interface IBizModel
    {
        /// <summary>
        /// 初始化方法
        /// </summary>
        void Init();

        /// <summary>
        /// 获取列表数据模型
        /// </summary>
        /// <returns></returns>
        object GetTableDataSource();

        /// <summary>
        /// 获取表单数据模型
        /// </summary>
        /// <returns></returns>
        object GetFormDataSource();

        /// <summary>
        /// 清除模型数据
        /// </summary>
        void ClearTableDataSource();

        /// <summary>
        /// 向模型设置用户自定义参数数据
        /// </summary>
        /// <param name="param"></param>
        void SetCustomParam(object param);

        /// <summary>
        /// 获取用户参数数据
        /// </summary>
        /// <returns></returns>
        object GetCustomParam();

        

        /// <summary>
        /// 引用参照过滤
        /// </summary>
        /// <param name="filedName"></param>
        /// <returns></returns>
        string OnRefFilterData(string fieldName,StringObjectMap sbm);

        /// <summary>
        /// 参照结果回写
        /// </summary>
        /// <param name="fieldName"></param>
        /// <param name="data"></param>
        /// <returns></returns>
        bool OnRefResultData(string fieldName, Object ds);
       

        /// <summary>
        /// 模型数据改变
        /// </summary>
        /// <param name="index">非列表为 -1</param>
        /// <param name="fieldName"></param>
        /// <param name="value"></param>
        void OnDataChanged(Object ds, String fieldName, string value);

       

        /// <summary>
        /// 内部错误信息
        /// </summary>
        /// <returns></returns>
        string GetErrorMsg();

        /// <summary>
        /// 隐藏列
        /// </summary>
        /// <returns></returns>
        string[] GetHiddenFields();

        /// <summary>
        /// 只读列
        /// </summary>
        /// <returns></returns>
        string[] GetReadonlyFields();

        /// <summary>
        /// 固定列
        /// </summary>
        /// <returns></returns>
        string[] GetFixedFields();

        /// <summary>
        /// 获取就诊Banner信息
        /// </summary>
        /// <returns></returns>
        Ent4BannerDTO GetEnt4BannerDTO();
    }
}
