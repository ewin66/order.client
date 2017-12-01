using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view.basic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.ems.dp;
using xap.mw.core.data;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.control.refcontrol.data;
using xap.rui.control.refcontrol.events;

namespace iih.ci.ord.opemergency.ems
{
    public class EmsHerbsViewGrid : EmsDrugSrvGridView
    {
        public EmsHerbsViewGrid(IEventDelegate o = null)
            : base(o)
        {
            
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsHerbsViewGrid);
        }

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            AttachQuanMedEditor();
        }

        /// <summary>
        /// 引用参照结果处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
           
            RefDataCollection data = e.RefResultSet;
            EmsOrDrug drug = e.DataObject as EmsOrDrug;
            if (e.BindingFieldName.Equals("Name_srv") && !string.IsNullOrEmpty(drug.Id_srv) && drug.Status==DOStatus.NEW)
            {
               (this.GetViewModel() as EmsHerbsViewModel).AddNewHerbControl();
            }
            base.OnXapFormControl_RefResult(sender, e);
            
            
        }

    }
}
