using iih.ci.ord.opemergency.medreferral.controller;
using iih.ci.ord.opemergency.medreferral.model;
using iih.en.pv.dto.d;
using System;
using System.Windows.Forms;
using xap.cli.sdk.form;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using System.Drawing;

namespace iih.ci.ord.opemergency.medreferral.view
{
    /// <summary>
    /// <para>描    述 :  医疗转诊单对话框                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.medreferral.view    </para>    
    /// <para>类 名 称 :  MedReferralDialog					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  10/21/2016 9:23:55 AM             </para>
    /// <para>更新时间 :  10/21/2016 9:23:55 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiMedReferralDialog : XSingleDialog
    {
        #region 变量定义区域
        private XapBaseControl mOwnerControl;
        private Ent4BannerDTO mEnt4BannerDTO;

        private XUserControl xUserControl;
        #endregion

        #region 构造函数区域
        public CiMedReferralDialog(XapBaseControl o, Ent4BannerDTO e)
        {
            mOwnerControl = o;

            mEnt4BannerDTO = e;

            this.Formsize = FormSize.ExtraLarge;
            //this.AutoScaleDimensions = new SizeF(8.2F, 18F);

            this.Text = "医保转诊单";
            this.HasbtnBackRec = false;

            this.Load += CiMedReferralDialog_Load;
        }
        #endregion

        private void CiMedReferralDialog_Load(object sender, EventArgs e)
        {
            this.InitBizDialog();

            CiMedReferralController c = xUserControl.GetConfig().GetInstance("CiMedReferralController") as CiMedReferralController;
            c.EventDelegate = mOwnerControl;
            c.ViewModel = new CiMedReferralViewModel(mOwnerControl.Context, mEnt4BannerDTO);

            CiMedReferralView m = xUserControl.GetConfig().GetInstance("CiMedReferralView") as CiMedReferralView;
            m.SetModel(c.ViewModel);

            c.eventPrint += m.ReloadForm;

            // 触发执行表单中的 onLoadData 和 onFillData 方法
            xUserControl.LoadData();
        }

        private void InitBizDialog()
        {
            xUserControl = new XUserControl();
            xUserControl.Init(Application.StartupPath + "\\modules\\iihci\\ui\\medreferral\\medreferral_config.xml");
            xUserControl.Dock = DockStyle.Fill;
            xUserControl.Location = this.Panel.Location;
            xUserControl.Size = this.Panel.Size;
            this.Panel = xUserControl;
        }
    }
}
