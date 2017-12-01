
using System;
using System.Collections.Generic;
using xap.rui.control.basecontrol;
using xap.cli.sdk.controls.herbalPrescription;
using xap.cli.sdk.controls;
using System.Drawing;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using System.Windows.Forms;
using xap.cli.sdk.controls.SpreadControl;
using iih.ci.ord.dto.ordpres.d;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.controls.DataView;
using xap.dp.rptview.viewer;
using xap.rui.control.extentions;
using xap.rui.engine;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.model.spltpres;
using iih.bd.bc.udi;
using xap.rui.control.forms.control;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.view.basic;

namespace iih.ci.ord.opemergency.spltpres
{

    /// <summary>
    /// <para>描    述 : 处方视图                          </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view       </para>    
    /// <para>类 名 称 : SpltPrescriptionView              </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 : qzwang                            </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class SpltPrescriptionView : BaseBizView
    {
        #region 内部模型和变量
        private XLayoutPanel rootPanel;
        protected XSpreadView spreadView;
        private ReportViewer rptViewer;

        protected SpltPrescriptionViewModel model;
      
        #endregion

        #region 构造函数区域
        public SpltPrescriptionView()
        {
            
        }
        public SpltPrescriptionView(BaseBizView o):base(o)
        {
            
        }

        protected override void InitializeBizView()
        {
            this.Name = "处方";
            model = new SpltPrescriptionViewModel();

            this.Load += new EventHandler(SpltPrescriptionView_Load);
        }
        #endregion

        #region 父类继承区域
        protected override void OnLoadData()
        {
            if (null == this.model || this.model.GetEnt4BannerDTO() == null)
                return;
            
            this.model.Reload();
        }

        protected override void OnFillData()
        {
            if (null == this.spreadView)
            {
                return;
            }
            this.spreadView.RemoveItemAll();

            if (this.model == null)
                return;
            if (this.model.ListWestDrugOrdPresDTO!=null)
                this.model.ListWestDrugOrdPresDTO.ForEach(p => { spreadView.AddItem(this.CreateWestDrugPresPanel(p)); });
            if (this.model.ListHerbalDrugOrdPresDTO != null)
                this.model.ListHerbalDrugOrdPresDTO.ForEach(p => { spreadView.AddItem(this.CreateHerbalDrugPresPanel(p)); });
        }

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (null == this.model)
            {
                return;
            }

            if (e.Object == null || !(e.Object is xap.rui.bizcontrol.bannercontrol.BannerData)
                ||(e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO == null)
            {
                spreadView.RemoveItemAll();

                this.model.Clear();
                return;
            }

            this.model.SetEnt4BannerDTO((e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO);

            if (null != this.model)
            {
                this.model.Reload();

                OnFillData();
            }
        }
        #endregion

        #region 内部事件区域
        private void SpltPrescriptionView_Load(object sender, EventArgs e)
        {
            rootPanel = new XLayoutPanel();
            rootPanel.Dock = DockStyle.Fill;
            this.AddRender(rootPanel);
           

            spreadView = new XSpreadView();
            spreadView.CancelItemSelected += SpreadView_CancelItemSelected;
            rptViewer = new ReportViewer(true);
            spreadView.Dock = DockStyle.None;
            this.getRootPanel().AddControl(spreadView, ControlPosition.Center);
        }

        private void SpreadView_CancelItemSelected(object sender, EventArgs e)
        {
            if (sender is XapFormControl)
            {
                var row = (sender as XapFormControl).GetGridView("drugtable").DataTable.SelectedRow;
                if (null != row)
                {
                    row.Selected = false;
                    row.Invalidate();
                }
            }


        }
        #endregion

        #region 业务处理区域
        /// <summary>
        /// 创建药品处方面板
        /// </summary>
        /// <param name="presDto"></param>
        /// <param name="width"></param>
        /// <param name="height"></param>
        /// <returns></returns>
        private XSpreadPanel CreateWestDrugPresPanel(OrdPresDTO presDto)
        {
            var drugs = this.model.GetPresDrugDataSource(presDto);
            if (drugs == null || drugs.Count == 0) return null;

            XSpreadPanel panel = new XSpreadPanel();
            panel.TitleText = this.model.GetWestDrugCaption(presDto);
            panel.Panel = this.CreatePresDrugFormGrid(drugs);
            panel.PanelHeight = drugs.Count * (xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 30 : 26) + 2;
            panel.Panel.Size = new Size(spreadView.Width, panel.PanelHeight);//大小屏分辨率

            if ("Y".Equals(model.DicPrestp[presDto.Sd_prestp].Ctrl1))
            {
                panel.TitleBackColor = Color.FromArgb(236, 152, 186);
                panel.IsChangedSkin = false;
            }

            return panel;
        }

        /// <summary>
        /// 创建分方药品列表控件
        /// </summary>
        /// <param name="ds"></param>
        /// <returns></returns>
        private XapFormControl CreatePresDrugFormGrid(object ds)
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_OP_SpltPrescriptionView;// "20160627093640542K69";
            file.FormStyle = FormStyle.List;
            file.ViewModel = ds;

            XapFormControl xfc = new XapFormControl()
            {
                TabIndex = 0,
                File = null,
                Location = new Point(0, 0),
                Name = "xapFormControl",
                Dock = DockStyle.None,
                AutoSize = true,
                Context = this.Context,
                ViewFile = file
            };

            xfc.FormCreated += new EventHandler(xfc_FormCreated);
            xfc.DataDisplay += new EventHandler<XDataDisplayEventArgs>(xfc_DataDisplay);
            
            xfc.AfterFocused += Xfc_AfterFocused;
            return xfc;
        }

        private void Xfc_AfterFocused(object sender, xap.rui.control.forms.model.DataFocusedEventArgs e)
        {
            var table = sender as XBaseControl;
            this.spreadView.ItemSelected(sender);
        }

       

        private void xfc_FormCreated(object sender, EventArgs e)
        {
            var xfc = sender as XBaseControl;
            var table = (xfc as XapFormControl).GetGridView("drugtable");
            //好多层的容器，控件组给出的方案
            if (table != null && table.Parent != null && table.Parent.Parent != null && table.Parent.Parent.Parent != null && table.Parent.Parent.Parent.Parent != null)
            {
                XSpreadPanel ctrParent = table.Parent.Parent.Parent.Parent as XSpreadPanel;
                XBaseControl ctr = table.Parent.Parent.Parent as XBaseControl;
                
                if (spreadView.Width <= table.Width)
                {
                    ctr.Size = new Size(ctr.Size.Width, ctrParent.PanelHeight + 10);
                }

                table.DataTable.Columns.Visible = false;
                table.SizeChanged -= new EventHandler(drugtable_SizeChanged);
                table.SizeChanged += new EventHandler(drugtable_SizeChanged);
            }
        }


        private void drugtable_SizeChanged(object sender, EventArgs e)
        {
            XapFormGridControl table = sender as XapFormGridControl;
            //好多层的容器，控件组给出的方案
            if (table != null && table.Parent != null && table.Parent.Parent != null && table.Parent.Parent.Parent != null && table.Parent.Parent.Parent.Parent != null)
            {
                XSpreadPanel ctrParent = table.Parent.Parent.Parent.Parent as XSpreadPanel;
                XBaseControl ctr = table.Parent.Parent.Parent as XBaseControl;
                if (table.HScroll.Visible)
                {
                    ctr.Size = new Size(ctr.Size.Width, ctrParent.PanelHeight + 10);
                }
                else
                {
                    ctr.Size = new Size(ctr.Size.Width, ctrParent.PanelHeight);
                }
            }

        }

        /// <summary>
        /// XapFormControl 数据显示时间响应
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xfc_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            PresDrugDTO drug = e.Object as PresDrugDTO;
            if (drug.Id_freq.Equals(CiDictCodeConst.ID_FREQ_ONCE)) 
            {
                drug.Use_day = null;
            }
            this.updateCustomerControlInfo(row, drug);
        }

        /// <summary>
        /// 更新自定义列控件中的值
        /// </summary>
        /// <param name="row"></param>
        /// <param name="drug"></param>
        private void updateCustomerControlInfo(XDataRow row, PresDrugDTO drug)
        {
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_str_quan_med"))
            {
                if (drug.Quan_med == null)
                    drug.Quan_med = 0;
                if (drug.Name_unit_med == null)
                    drug.Name_unit_med = "";
                string strMed_unit = drug.Quan_med.ToString() + drug.Name_unit_med;
                row.ColumnCellDict["customercolumn_str_quan_med"].SetValue(strMed_unit);
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_str_quan_cur"))
            {

                if (drug.Quan_cur == null)
                    drug.Quan_cur = 0;
                if (drug.Name_unit_sale == null)
                    drug.Name_unit_sale = "";
                string strMed_unit = drug.Quan_cur.ToString() + drug.Name_unit_sale;
                row.ColumnCellDict["customercolumn_str_quan_cur"].SetValue(strMed_unit);
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_Use_days"))
            {

                if (drug.Use_day == null) {
                    row.ColumnCellDict["customercolumn_Use_days"].SetValue("");
                }
                else {
                    string strUseDay = drug.Use_day.ToString() + "天";
                    row.ColumnCellDict["customercolumn_Use_days"].SetValue(strUseDay);
                }
            }
        }

        private XSpreadPanel CreateHerbalDrugPresPanel(OrdPresDTO presDto)
        {
            var drugs = this.model.GetPresDrugDataSource(presDto);
            if (drugs == null || drugs.Count == 0) return null;

            XSpreadPanel panel = new XSpreadPanel();
            panel.PanelHeight = drugs.Count;
            int n = spreadView.Width < 147 ? 1 : spreadView.Width / 147;
            panel.Size = new Size(spreadView.Width, (drugs.Count / n + 1) * 42 + 33);
            panel.TitleText = this.model.GetHerbalDrugCaption(presDto);
            HerBalMedicineCtr herbCrt= new HerBalMedicineCtr()
            {
                MedicineName = "Name_mm",
                DosageName = "Quan_med",
                UsgeName = "Name_boildes",
                UnitName = "Name_unit_med",
                HerbalWidth = 99,
                HerbalHeight = 35,
                DataSource = drugs
            };
            herbCrt.SizeChanged -= new EventHandler(herbCrt_SizeChanged);
            herbCrt.SizeChanged += new EventHandler(herbCrt_SizeChanged);
            panel.Panel = herbCrt;
            
            return panel;
        }

        private void herbCrt_SizeChanged(object sender, EventArgs e)
        {
            HerBalMedicineCtr herbCrt = sender as HerBalMedicineCtr;
            if (herbCrt.Parent != null)
            {
                XSpreadPanel ctrParent = herbCrt.Parent as XSpreadPanel;
                int n = spreadView.Width < 147 ? 1 : spreadView.Width / 147;
                ctrParent.Size = new Size(ctrParent.Size.Width, (ctrParent.PanelHeight / n + 1) * 42 + 33);
            }
        }

        protected XLayoutPanel getRootPanel()
        {
            return rootPanel;
        }

       

        private void PrintPres()
        {
            
            string westids = this.model.GetWestDrugPresIds();
            string herbids = this.model.GetHerbDrugPresIds();
            string poisids = this.model.GetPoisPresIds();
            if (westids != "")
            {
                string servRptfile = @"iih_report/461010_menzhenyishengzhan/westpres.xml";
                Dictionary<string, string> qry_params = new Dictionary<string, string>();
                qry_params.Add("$id_ent", this.model.GetEnt4BannerDTO().Id_ent);
                qry_params.Add("$ids_orpres", westids);
                OnPrint(servRptfile, qry_params);
            }
            if (herbids != "")
            {
                string servRptfile = @"iih_report/461010_menzhenyishengzhan/herbpres.xml";
                Dictionary<string, string> qry_params = new Dictionary<string, string>();
                qry_params.Add("$id_ent", this.model.GetEnt4BannerDTO().Id_ent);
                qry_params.Add("$ids_orpres", herbids);
                OnPrint(servRptfile, qry_params);
            }
            if (poisids != "")
            {
                string servRptfile = @"iih_report/461010_menzhenyishengzhan/poispres.xml";
                Dictionary<string, string> qry_params = new Dictionary<string, string>();
                qry_params.Add("$id_ent", this.model.GetEnt4BannerDTO().Id_ent);
                qry_params.Add("$ids_orpres", poisids);
                OnPrint(servRptfile, qry_params);
            }
        }

        public void OnPrint(string str,Dictionary<string, string> qparams)
        {
            

            bool result = rptViewer.PrintRptFile(str, qparams, true);
            if (!result)
            {
                this.ShowInfo(rptViewer.GetLastMsg());
            }
        }

        #endregion

        public OrdPresDTO[] GetAllOrdPresDTOs()
        {
            return this.model.AllOrdPresDTOs;
        }

        public SpltPrescriptionViewModel GetModel()
        {
            return model;
        }
    }
}
