using iih.bd.bc.udi;
using iih.ci.diag.cidiag.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.orddi;
using iih.ci.ord.opemergency.view;
using iih.en.pv.dto.d;
using System;
using xap.cli.sdk.controls.tabControl;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.control;

namespace iih.ci.ord.opemergency.orddi
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ordiag    </para>    
    /// <para>类 名 称 :  OrderDiInfoView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  10/12/2016 3:15:48 PM             </para>
    /// <para>更新时间 :  10/12/2016 3:15:48 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrderDiInfoView : BaseFormBizView
    {
        private OrderDiInfoViewModel model = new OrderDiInfoViewModel();

        private XapBaseControl ownerControl;
        private Ent4BannerDTO ent4BannerDTO;

        private int nSelectIndex = 0;

        public OrderDiInfoView(XapBaseControl owner, Ent4BannerDTO e)
        {
            this.ownerControl = owner;
            this.ent4BannerDTO = e;
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.GetXapFormControl().Load += OrderDiInfoView_Load;
            this.GetXapFormControl().FormCreated += OrderDiInfoView_FormCreated;
        }

        void OrderDiInfoView_FormCreated(object sender, EventArgs e)
        {
            this.GetXapFormControl().DataVisible += OrderDiInfoView_DataVisible;

            this.GetXapFormControl().TabPageSelectChanged += OrderDiInfoView_TabPageSelectChanged;

           
        }

        void OrderDiInfoView_TabPageSelectChanged(object sender, EventArgs e)
        {
            XTabPage page = sender as XTabPage;
            if (page.Owner.SelectedIndex == 0)
            {

            }
            else if (page.Owner.SelectedIndex == 1)
            {

            }
            nSelectIndex = page.Owner.SelectedIndex;
        }

        void OrderDiInfoView_DataVisible(object sender, xap.rui.control.formcontrol.model.DataVisibleEventArgs e)
        {
            XapFormGridControl formGridCtrl = sender as XapFormGridControl;
            CiDiagItemDO item = e.Data as CiDiagItemDO;
            if (formGridCtrl.Name.Equals("xydi_grid"))
            {
                e.Visible = item.Id_disys == CiDictCodeConst.ID_CI_DISYS_XYZDTX && !item.IsDELETED;
            }
            else
            {
                e.Visible = item.Id_disys == CiDictCodeConst.ID_CI_DISYS_ZYZDTX && !item.IsDELETED;
            }
        }

        

        void OrderDiInfoView_Load(object sender, EventArgs e)
        {
            OnInit();


        }

        protected override void OnLoadData()
        {
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_OrderDiInfoView/*"20161012032732374000"*/);

            //
            if (this.ent4BannerDTO != null && model.Reload(this.ent4BannerDTO)){
                this.SetFormDataSource(model.GetFormDataSource());
            }
            
        }


        public void AddRow()
        {
            this.model.AddRow((nSelectIndex == 0 ? CiDictCodeConst.ID_CI_DISYS_XYZDTX : CiDictCodeConst.ID_CI_DISYS_ZYZDTX));
        }

      

    }
}
