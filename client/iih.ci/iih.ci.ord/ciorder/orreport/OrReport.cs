
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.cli.sdk.form;
using xap.cli.sdk.controls;
using xap.cli.sdk.render.labelcontrol;
using xap.cli.sdk.render.Items;
using System.Drawing;
using xap.cli.sdk.render;
using iih.ci.ord.ciorder.orreport.scrollpanel;
using iih.ci.ord.ciorder.orreport.scrollpanel.model;
using xap.rui.appfw;
using iih.ci.ord.ciorder.d;
using System.Windows.Forms;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.extentions;
using xap.mw.core.utils;

namespace iih.ci.ord.ciorder.orreport
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.donot    </para>    
    /// <para>类 名 称 :  OrReport					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/10/27 11:16:18             </para>
    /// <para>更新时间 :  2016/10/27 11:16:18             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class OrReport : XForm
    {
        protected Dictionary<int, SetMenunrender> labelDic = new Dictionary<int, SetMenunrender>();
        protected string[] id_ors;
        private OrReportModel orReportModel = new OrReportModel();
        private Dictionary<int,object> dataDic = new Dictionary<int,object>();
        private OrReportScrollPanel orReportScrollPanel;
        private XCellRender cell;
        private CiOrderDO ciOrderDO;
        //private int type;
        public OrReport(string[] id_ors)
        {
            this.id_ors = id_ors;
            init();
        }
        public OrReport(XCellRender cell, CiOrderDO ciOrderDO, int type)
        {
            this.cell = cell;
            this.ciOrderDO = ciOrderDO;
            this.id_ors = new string[1] { ciOrderDO.Id_or };
            init();
            scrollPanel(type);
        }
        #region 初始化数据和界面
        void init(){
            InitializeComponent();
            initData();
            initView();
            saveButton.MouseClick += new System.Windows.Forms.MouseEventHandler(saveButton_MouseClick);
            cancelButton.MouseClick += new System.Windows.Forms.MouseEventHandler(cancelButton_MouseClick);
        }

        /// <summary>
        /// 初始化数据
        /// </summary>
        private void initData()
        {
            dataDic = orReportModel.getReportData(this.id_ors);
        }
        private void initView()
        {
            addLeftLabel(dataDic);
            orReportScrollPanel = new OrReportScrollPanel(this, dataDic,this.id_ors,this.ciOrderDO);
            if (this.ciOrderDO != null) {
                bool canEdit = (this.ciOrderDO.Sd_su_or == null || this.ciOrderDO.Sd_su_or=="0");
                orReportScrollPanel.setEditPlogy(canEdit);
                saveButton.Enabled = canEdit;
            }
            this.centerXLayoutPanel.AddControl(orReportScrollPanel, ControlPosition.Center);
        }
        #endregion

        #region 左侧的label

        /// <summary>
        /// 构造医保审核，临床路径审核左侧的导航页签
        /// </summary>
        /// <param name="dataDic"></param>
        private void addLeftLabel(Dictionary<int, object> dataDic)
        {
            int StartY = 0;
            SetMenunrender Menurender;
            foreach(KeyValuePair<int, object> pair in dataDic){
                int key = pair.Key;
                string labelValue = "";
                switch (key)
                {
                    case ReportCodeDict.HP_REPORT_CODE:
                        XapDataList<OrdSrvDO> dataList = pair.Value as XapDataList<OrdSrvDO>;
                        labelValue = ReportCodeDict.REPORT_DICT[key] + "（" + dataList.Count + "）";
                        break;
                    case ReportCodeDict.UNCPOR_REPORT_CODE:
                        XapDataList<CiOrderDO> orderList = pair.Value as XapDataList<CiOrderDO>;
                        labelValue = ReportCodeDict.REPORT_DICT[key] + "（" + orderList.Count + "）";
                        break;
                }
                Menurender = new SetMenunrender();
                Menurender.MouseClick += new System.Windows.Forms.MouseEventHandler(label2_MouseClick);
                Menurender.Text = labelValue;
                Menurender.Font = new System.Drawing.Font("微软雅黑", 14, GraphicsUnit.Pixel);
                Menurender.DownButtonBrush = new SolidBrush(Color.FromArgb(225, 225, 225));
                Menurender.Location = new Point(0, StartY);
                Menurender.Size = new Size(185, Menurender.Size.Height);
                StartY += Menurender.Size.Height;
                labelDic.Add(key, Menurender);
                this.leftXLayoutPanel.AddRender(Menurender);
               
            }
            leftXLayoutPanel.BackColor = Color.FromArgb(212, 235, 255);
        }
        #endregion
        void label2_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            foreach (KeyValuePair<int, SetMenunrender> pair in this.labelDic)
            {
                try
                {
                    SetMenunrender render = (pair.Value as SetMenunrender);
                    if (render == (sender as SetMenunrender))
                    {
                        render.IsSelect = true;
                        orReportScrollPanel.scrollToCard(pair.Key);
                        render.DownButtonBrush = new SolidBrush(Color.FromArgb(255, 255, 255));
                    }
                    else
                    {
                        render.IsSelect = false;
                    }
                    render.Invalidate();
                }
                catch (Exception)
                {

                    //throw;
                }
            }
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="p"></param>
        public void selectedMenuRender(int p)
        {
            foreach (KeyValuePair<int, SetMenunrender> pair in this.labelDic)
            {
                try
                {
                    SetMenunrender render = (pair.Value as SetMenunrender);
                    if (pair.Key == p) {
                        render.IsSelect = true;
                        render.DownButtonBrush = new SolidBrush(Color.FromArgb(255, 255, 255));
                    }
                    else
                    {
                        render.IsSelect = false;
                    }
                    render.Invalidate();
                }
                catch (Exception)
                {

                    //throw;
                }
            }
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void cancelButton_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void saveButton_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            //校验数据正确性
            bool isHasError = this.orReportScrollPanel.validate();
            if (isHasError) return;
            //保存
            try
            {
                this.orReportScrollPanel.save();
            }
            catch (Exception ex) {
                ex.Publish();
            }
            this.DialogResult = DialogResult.OK;
            this.SetStatusMsg("保存成功！");
            if (this.ciOrderDO != null)
            {
                this.orReportModel.buildOrderResultData(this.ciOrderDO, this.cell);
            }
        }
        /// <summary>
        /// 
        /// </summary>
        /// <param name="key"></param>
        void scrollPanel(int key) {
            selectedMenuRender(key);
            orReportScrollPanel.scrollToCard(key);
        }
    }
}
