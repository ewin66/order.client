
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using iih.ci.ord.ciorder.d;

namespace iih.ci.iih.ci.ord.dto.d
{
    /// <summary>
    /// <para>描    述 :  医嘱聚集和关联信息            </para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.iih.ci.ord.dto.d       </para>    
    /// <para>类 名 称 :  CiOrAggAndRelInfo				</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/8 8:18:10              </para>
    /// <para>更新时间 :  2016/7/8 8:18:10              </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiOrAggAndRelInfo : BaseDTO
    {
        public CiOrAggAndRelInfo()
        {
        }
        /// <summary>
        /// 医嘱聚合DO
        /// </summary>
        public CiorderAggDO OrAggDO
        {
            get { return getAttrVal<CiorderAggDO>("OrAggDO", null); }
            set { setAttrVal<CiorderAggDO>("OrAggDO", value); }
        }

        /// <summary>
        /// 医嘱物品映射表
        /// </summary>
        public FMap OrSrvMmMap
        {
            get { return getAttrVal<FMap>("OrSrvMmMap", null); }
            set { setAttrVal<FMap>("OrSrvMmMap", value); }
        }

        /// <summary>
        /// 医嘱费用服务映射表
        /// </summary>
        public FMap BlSrvMap
        {
            get { return getAttrVal<FMap>("BlSrvMap", null); }
            set { setAttrVal<FMap>("BlSrvMap", value); }
        }

        public override string[] getAttrNames()
        {
            return new string[] { "OrAggDO", "OrSrvMmMap" };
        }

        public override string getFullClassName()
        {
            return "iih.ci.iih.ci.ord.dto.d.CiOrAggAndRelInfo";
        }
    }
}
