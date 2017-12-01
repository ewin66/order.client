using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.cards.extend;
using xap.cli.sdk.render.Items;
using xap.mw.log;
using xap.rui.appfw;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.rui.engine.registers;
using xap.cli.sdk.form;
using iih.ci.ord.ciorder.viewmodel;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.cli.sdk.controls.DataView;
using iih.bd.bc.udi;
using iih.ci.ord.ciorder.view;

/********************************************************************************

** 作者： 张万青

** 创始时间：2017-1-11

** 修改人：张万青

** 修改时间：2017-1-11

** 描述： 医嘱服务查询


*********************************************************************************/
namespace iih.ci.ord.ciorder.takedrug4outhosp.view
{
    public class TakeDrugOurtSearchControlView : SearchControlView{
     
        #region 构造

        public TakeDrugOurtSearchControlView():base()
        {
            this.DataSource = new Dictionary<object, string>() {
                {BdSrvDictCodeConst.SD_SRVTP_DRUG ,"药品"}
            };
        }
        #endregion
    }
}