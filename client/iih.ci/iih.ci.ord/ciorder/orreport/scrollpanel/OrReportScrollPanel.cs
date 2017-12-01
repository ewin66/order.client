
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.cli.sdk.controls;
using xap.rui.appfw;
using iih.ci.ord.ems.d;
using System.Drawing;
using iih.ci.ord.ciorder.orreport.scrollpanel.view;
using iih.ci.ord.ciorder.d;
using xap.cli.sdk.render;
using xap.rui.control.extentions;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.orreport.scrollpanel
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.donot    </para>    
    /// <para>类 名 称 :  OrReportScrollPanel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/10/27 15:20:59             </para>
    /// <para>更新时间 :  2016/10/27 15:20:59             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class OrReportScrollPanel : XAPScrollBarPanel
    {
        private OrReport orReport;
        private Dictionary<int, object> dataDic;
        private Dictionary<int, int> vDic = new Dictionary<int,int>();
        private List<BaseCheckRepoatView> panelItemList;
        private string[] id_ors;
        private CiOrderDO ciOrderDO;
        public OrReportScrollPanel(OrReport orReport, Dictionary<int, object> dataDic, string[] id_ors, CiOrderDO ciOrderDO)
        {
            this.orReport = orReport;
            this.dataDic = dataDic;
            this.id_ors = id_ors;
            this.ciOrderDO = ciOrderDO;
            InitializeComponent();
            this.Dock = DockStyle.Fill;
            this.Load += new EventHandler(OrReportScrollPanel_Load);
            this.vScroll.ScollChanged += new xap.cli.sdk.render.ScollChangedDelegate(OnVScroll_ScollChanged);
            init();
        }

        void OrReportScrollPanel_Load(object sender, EventArgs e)
        {
            
        }
        public void init() {
            panelItemList = new List<BaseCheckRepoatView>();
            foreach(KeyValuePair<int, object> pair in dataDic){
                int key = pair.Key;
                switch (key) { 
                    case ReportCodeDict.HP_REPORT_CODE:
                       XapDataList<OrdSrvDO> dataList =  pair.Value as XapDataList<OrdSrvDO>;
                       BaseCheckRepoatView reportview = new HealthCheckRepoatView(dataList, this.id_ors, ReportCodeDict.REPORT_DICT[key], key,this.ciOrderDO);
                       panelItemList.Add(reportview);
                       this.AddRender(reportview);
                        break;
                    case ReportCodeDict.UNCPOR_REPORT_CODE:
                        XapDataList<CiOrderDO> cpordataList = pair.Value as XapDataList<CiOrderDO>;
                        BaseCheckRepoatView cporReportview = new CporCheckRepoatView(cpordataList, this.id_ors, ReportCodeDict.REPORT_DICT[key], key);
                        panelItemList.Add(cporReportview);
                        this.AddRender(cporReportview);
                        break;
                }
            }
            ReLocation();
            this.getScrollBarRect();
        }
        private void ReLocation()
        {
            if (panelItemList == null) return;
            BaseCheckRepoatView preView = null;
            foreach(BaseCheckRepoatView view in panelItemList){
                if (preView != null) {
                    view.Location = new Point(preView.Location.X, preView.Location.Y + preView.Height + 15);
                }
                preView = view;
                vDic.Add(view.getKey(),view.Location.Y);
            }
            this.Invalidate();
        }
        public bool validate() {
            List<string> errorList = new List<string>();
            foreach (BaseCheckRepoatView view in panelItemList)
            {
                view.validate(view, errorList);
            }
            if (errorList.Count > 0) {
                return true;
            }
            return false;
        }
        public void save()
        {
            foreach (BaseCheckRepoatView view in panelItemList)
            {
                view.save();
            }
        }
         protected override void OnVScroll_ScollChanged(object sender, xap.cli.sdk.render.events.ScollEventArgs e)
         {
             base.OnVScroll_ScollChanged(sender,e);
             int scrollValue = e.NewValue;
             foreach (BaseCheckRepoatView view in panelItemList)
             {
                if(scrollValue*this.Bounds.Height/this.vScroll.MaxValue<=(int)vDic[view.getKey()]){
                    orReport.selectedMenuRender(view.getKey());
                    break;
                }
             }
         }
         public List<BaseCheckRepoatView> getPanelItemList() {
             return this.panelItemList;
         }


         internal void scrollToCard(int p)
         {
             if (!this.EnabledVertical) return;
             BaseCheckRepoatView preView = null;
             int scrollValue = this.vScroll.Value;
             int maxValue = this.vScroll.MaxValue;
             foreach (BaseCheckRepoatView view in panelItemList)
             {
                 try {
                     if (view.getKey() == p)
                     {

                         scrollValue = ((int)vDic[view.getKey()])*this.vScroll.MaxValue / this.Bounds.Height;
                         this.vScroll.Value = scrollValue;
                         this.vScroll.Invalidate();
                     }
                     preView = view;
                 }
                 catch (Exception ex)
                 {
                     this.ShowInfo(ex.Message);
                 }
             }
         }

         internal void setEditPlogy(bool p)
         {
             foreach (BaseCheckRepoatView view in panelItemList)
             {
                 view.setEditPlogy(p);
                 view.setCanEdit(p);
             }
         }
    }
}
