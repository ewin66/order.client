using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.form;
using xap.mw.serviceframework;
using xap.rui.control.basecontrol;
using xap.rui.appfw;
using iih.mm.itf.material.i;
using iih.mm.itf.material.d;
using xap.cli.sdk.render;
using xap.cli.sdk.controls;
/********************************************************************************

** 作者： 张万青

** 创始时间：

** 修改人：张万青

** 修改时间：2016-6-30

** 描述： 服务物品的弹出框

*********************************************************************************/
namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class ExtMmForm : ContextMenuForm
    {
        public Point Local { get; set; }
        public EmsOrDrug drugmm { get; set; }
        private ExtMmRefView mm;

        public ExtMmForm()
        {
        }
        private void InitializeComponent()
        {
            this.orCom = new XBaseControl();
            orCom.Size = new System.Drawing.Size(450, 75);
            saveButton = new XButton();
            saveButton.Size = new System.Drawing.Size(75, 25);
            saveButton.Location = new Point(150, 0);
            saveButton.Text = "确认";
            this.orCom.AddRender(saveButton);
            cancelButton = new XButton();
            cancelButton.Size = new System.Drawing.Size(75, 25);
            cancelButton.Location = new Point(245, 0);
            cancelButton.Text = "取消";
            this.orCom.AddRender(cancelButton);
            splitContainer1 = new XLayoutPanel();
            this.splitContainer1.Size = new System.Drawing.Size(475, 190);
            this.Text = "MmForm";

        }
        private XButton saveButton;
        private XButton cancelButton;
        public XLayoutPanel splitContainer1;
        public XBaseControl orCom;
        public ExtMmForm(XapDataList<EmsOrDrug> list, EmsDrugItemDO drugItemDO, EmsOrDrug emsordrug): this()
        {
            InitializeComponent();
            //IMaterialStockService stoctService = XapServiceMgr.find<IMaterialStockService>();
            //GetStockReqDTO[] reqDtos = new GetStockReqDTO[list.Count];
            //for (int i = 0; i < list.Count; i++)
            //{
            //    GetStockReqDTO reqDTO = new GetStockReqDTO();
            //    reqDTO.Id_mm = list[i].Id_mm;
            //    reqDTO.Id_dep = emsordrug.Id_mp_dep;
            //    reqDTO.Req_unit_id = list[i].Id_unit_sale;
            //    reqDtos[i] = reqDTO;
            //}

            //MaterialStockDTO[] stockdto = stoctService.getMaterialStocks(reqDtos);
            //for (int i = list.Count - 1; i >= 0; i--)
            //{
            //    MaterialStockDTO materialDo = stockdto.FirstOrDefault(p => p.Id_mm == list[i].Id_mm);
            //    if (materialDo != null)
            //    {
            //        double mmcount = (double)materialDo.Quan_stock;
            //        if (mmcount <= 0)
            //        {
            //            list.RemoveAt(i);
            //        }
            //        else
            //        {
            //            list[i].Fact_count = mmcount;
            //            list[i].Price = materialDo.Price_act;
            //        }
            //    }
            
            IEnumerable<EmsOrDrug> query = null;
            query = from items in list orderby items.Fact_count descending select items;
            int flag = 0;
            foreach (var item in query)
            {
                list[flag] = item;
                flag++;
            }
            mm = new ExtMmRefView(list, emsordrug);
            mm.DoubleClickEvent +=new EventHandler(mm_DoubleClickEvent);
            splitContainer1.AddControl(this.orCom, xap.cli.sdk.controls.ControlPosition.Bottom, 30);
            splitContainer1.AddControl(mm, xap.cli.sdk.controls.ControlPosition.Center);
            this.saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);
            this.cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);
            this.Controls.Add(splitContainer1);
        }

        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            Close();
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            this.drugmm = mm.xapFormControl.GetSelected<EmsOrDrug>().FirstOrDefault(); ;
            mm.setFgSelfValue();
            DialogResult = DialogResult.OK;
            Invalidate();
        }
        

        private void mm_DoubleClickEvent(object sender, EventArgs e)
        {
            this.drugmm = sender as EmsOrDrug;
            mm.setFgSelfValue();
            this.DialogResult = DialogResult.OK;
            Invalidate();
        }
        public void setEdit(bool flag) {
            this.mm.Enabled = flag;
            this.saveButton.Enabled = flag;
            this.cancelButton.Enabled = true;
        }
    }
}
