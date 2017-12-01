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

namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class MmForm : XDialog
    {
        public Point Local { get; set; }
        public EmsOrDrug drugmm { get; set; }
        private MmRefView mm;

        public MmForm()
        {
            this.Text = "药品选择";
            this.Size = new Size(470, 300);
            //mm

            this.Load += new EventHandler(MmForm_Load);

        }
        public MmForm(XapDataList<EmsOrDrug> list) : this()
        {
            mm = new MmRefView(list);
            mm.DoubleClickEvent += new EventHandler(mm_DoubleClickEvent);

            this.Panel = mm;
        }
        public MmForm(XapDataList<EmsOrDrug> list,EmsDrugItemDO drugItemDO) : this()
        {
            IMaterialStockService stoctService = XapServiceMgr.find<IMaterialStockService>();
            GetStockReqDTO[] reqDtos = new GetStockReqDTO[list.Count];
            for (int i = 0; i < list.Count; i++) {
                GetStockReqDTO reqDTO = new GetStockReqDTO();
                reqDTO.Id_mm = list[i].Id_mm;
                reqDTO.Id_dep = "";
                reqDTO.Req_unit_id = list[i].Id_unit_sale;
                reqDtos[i] = reqDTO;
            }
            MaterialStockDTO[] stockdto =   stoctService.getMaterialStocks(reqDtos);
            for (int i = list.Count-1; i >= 0; i--)
            {
                MaterialStockDTO materialDo = stockdto.FirstOrDefault(p => p.Id_mm == list[i].Id_mm);
                if (materialDo != null)
                {
                    double mmcount = (double)materialDo.Quan_stock;
                    if (mmcount <= 0)
                    {
                        list.RemoveAt(i);
                    }
                    else
                    {
                        list[i].Fact_count = Math.Round(mmcount);
                        list[i].Price = materialDo.Price_act;
                    }
                }
            }
            IEnumerable<EmsOrDrug> query = null;
            query = from items in list orderby items.Fact_count descending select items;
            int flag = 0;
            foreach (var item in query)
            {
                list[flag] = item;
                flag++;
                 //Console.WriteLine(item.Id+":"+item.Name);
            }



            mm = new MmRefView(list);
            mm.DoubleClickEvent += new EventHandler(mm_DoubleClickEvent);

            this.Panel = mm;
        }
        

        private void mm_DoubleClickEvent(object sender, EventArgs e)
        {
            this.drugmm = sender as EmsOrDrug;
            this.DialogResult = DialogResult.OK;
        }

        private void MmForm_Load(object sender, EventArgs e)
        {
            //this.Location = Local;
        }
       
    }
}
