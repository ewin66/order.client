using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view.basic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.opemergency.assi.rationaldrug.viewmodel;
using iih.ci.ord.opemergency.tool;
using xap.rui.engine;
using iih.ci.ord.opemergency.assi.rationaldrug.view;

namespace iih.ci.ord.opemergency.ems
{
   public class EmsDrugsViewGrid : EmsDrugSrvGridView
    {
        public EmsDrugsViewGrid(IEventDelegate o = null)
            : base(o)
        {}

        protected override void InitializeBizView()
        {
            base.InitializeBizView();
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsDrugsViewGrid);
        }

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            AttachQuanMedEditor();
        }
        /// <summary>
        /// 鼠标右键点击时触发合理用药
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapGridFormControl_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            base.OnXapGridFormControl_MouseClick(sender, e);

            if (e.Button == System.Windows.Forms.MouseButtons.Right)
            {
                var row = sender as XDataRow;
                if (row != null) {

                    EmsOrDrug emsOrDrug = row.RowDataSource as EmsOrDrug;
                    
                    Dictionary<string, string> mmDic = new Dictionary<string, string>();
                    //mmDic.Add(RationalDrugConstant.CODE_MM, emsOrDrug.Code_mm);
                    //mmDic.Add(RationalDrugConstant.NAME_MM, emsOrDrug.Name_mm);
                    //mmDic.Add(RationalDrugConstant.CODE_MM, "200002");
                    //mmDic.Add(RationalDrugConstant.NAME_MM, "头孢克洛");

                    RationalDrugView rationalDrug = RationalDrugViewFactory.GetInstance();
                    if (rationalDrug != null) {
                        rationalDrug.ShowDrugInstruction(emsOrDrug.Code_mm, emsOrDrug.Name_mm);
                        //rationalDrug.ShowDrugInstruction("200002", "头孢克洛");
                    }                  
                }               
            }
        }

        
    }
}
