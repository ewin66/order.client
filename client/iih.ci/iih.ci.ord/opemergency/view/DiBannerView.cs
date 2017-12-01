using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.forms.model;
using iih.ci.ord.opemergency.view;
using iih.en.pv.dto.d;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using iih.ci.ord.opemergency.viewmodel;
using xap.cli.sdk.common;
using xap.rui.engine.eventbroker;
using iih.ci.diag.dto.d;
using xap.cli.sdk.controls.banner.renders;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.ems.common;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.common.log;
using iih.ci.ord.opemergency.orddi.model;
using iih.bd.bc.udi;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.action.costant;
using xap.rui.control.extentions;

namespace iih.ci.ord.opemergency.view
{

    /// <summary>
    /// <para>描    述 : 门急诊医生工作站- banner中 【诊断修改】视图 </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view       </para>    
    /// <para>类 名 称 : DiBannerView                      </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 : qzwang                            </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class DiBannerView : XapBaseControl
    {
       
        /*private const string CIDI_SAVE_SUCC_EVENT = "CidiSaveSuccEvent";*/
        #region 变量定义区域
        private DiListViewModel model = new DiListViewModel();
        private Ent4BannerDTO ent4BannerDTO;
        
        private ContainerLabelAndInput textBoxDi;
        #endregion

        #region 构造函数区域

        public DiBannerView()
        {
            this.Size = new System.Drawing.Size(247, 72);
            this.Name = "cidiView";
            constructViewControls();
            this.Enabled = false;
            this.BackColor = SkinFactory.Instance().CurrentSkin.BannerBackColor;
            SkinFactory.Instance().SkinChanged += new SkinFactory.SkinChangedEventHandler(cidiView_SkinChanged);
            this.SizeChanged += new EventHandler(DiBannerView_SizeChanged);

            
        }

        private void DiBannerView_SizeChanged(object sender, EventArgs e)
        {
            textBoxDi.Contentsize = new Size(this.Size.Width - 45, this.Size.Height - 17);
        }

        void cidiView_SkinChanged()
        {
            this.BackColor = SkinFactory.Instance().CurrentSkin.BannerBackColor;
            this.Invalidate();
        }

        protected override void DisposeManaged()
        {
            SkinFactory.Instance().SkinChanged -= new SkinFactory.SkinChangedEventHandler(cidiView_SkinChanged);
            base.DisposeManaged();
        }
        #endregion


        #region 内部事件区域
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (sender is xap.rui.bizcontrol.bannerview.bannerOpdocstation)
            {
                if ((e.Object is xap.rui.bizcontrol.bannercontrol.BannerData) &&
                    (e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO != null)
                {
                    this.Enabled = true;

                    this.ent4BannerDTO = (e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO;

                    this.LoadData();
                }
                else
                {
                    this.ent4BannerDTO = null;
                    this.textBoxDi.Contentstr = string.Empty;
                    this.Enabled = false;
                    this.textBoxDi.Editor = false;
                }
            }
        }

        protected override void OnLoadData()
        {
            if (null != model)
            {
                model.Reload(ent4BannerDTO.Id_ent);
            }
        }

        protected override void OnFillData()
        {
            this.textBoxDi.Contentstr = model.GetPatDiDescription();
            this.textBoxDi.Editor = true;

            this.textBoxDi.Enabled = !(ent4BannerDTO.Sd_status == EnDictCodeConst.SD_ENSTATUS_OP_FINISH);
        }


        void textBoxDi_MouseClick(object sender, MouseEventArgs e)
        {

            AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDI_EDIT);
        }
        #endregion

        #region 辅助处理函数
        private void constructViewControls()
        {
            Font CaptionfontU = new Font("微软雅黑", 12, FontStyle.Underline, GraphicsUnit.Pixel);
            textBoxDi = new ContainerLabelAndInput();
            textBoxDi.Captionstr = "诊断";
            textBoxDi.Contentstr = "";
            textBoxDi.TextLineAlignment = StringAlignment.Near;
            textBoxDi.Captionsize=new Size(30,24);
            textBoxDi.Location = new Point(0, 9);
            textBoxDi.Contentsize =new Size(this.Size.Width - 45, this.Size.Height-17);
            
            textBoxDi.TextTitleFont = CaptionfontU;
            textBoxDi.Editor = true;

            if (RelativeUIParam.RELATIVERATIO < 1920)
            {
                textBoxDi.MouseClick += new MouseEventHandler(textBoxDi_MouseClick);
            }
 
            this.AddRender(textBoxDi);

        }

        /// <summary>
        /// 校验诊断状态
        /// </summary>
        /// <param name="bCheckEmpty">是否检验空诊断</param>
        /// <returns></returns>
        public bool CheckDiEditable()
        {
            if (RelativeUIParam.RELATIVERATIO <= RelativeUIParam.TEMPLETECHANGEDRATIO)
            {
                if (this.model.IsEmptyModel(this.ent4BannerDTO.Id_ent))
                {
                    this.ShowInfo("请先下达诊断信息！");
                    return false;
                }
            }
            return true;
        }

        /// <summary>
        /// 发送消息
        /// </summary>
        /// <param name="strEventCode"></param>
        /// <param name="dataDic"></param>
        /// <param name="sender"></param>
        private void sentMessage(String strEventCode, Dictionary<string, object> dataDic, object sender)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, strEventCode);
            args.Data.Add(UIConst.DATA, dataDic);
            this.FireEventSent(sender, args);
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;

            if (null == model)
                return;
        
            switch (uiEvent)
            {
                case OpActionConstant.OP_REFRESH_ALL_ACTION:// 门诊刷新
                case EventCodeType.EVENT_ORDI_SAVESUCCE:
                  if (this.ent4BannerDTO != null && !string.IsNullOrEmpty(this.ent4BannerDTO.Id_ent))
                    {
                        model.Reload(this.ent4BannerDTO.Id_ent);
                        this.textBoxDi.Contentstr = model.GetPatDiDescription();
                        this.textBoxDi.Invalidate();
                    }

                    break;
                case "EmrPer":
                    model.Reload(this.ent4BannerDTO.Id_ent);
                    String info = model.GetPatDiDescription();
                    AssToolEx.SentMessage(this, "PatDiDesc", "PatDiDesc", info);
                    break;

                case OpActionConstant.OP_COMPLETE_DI_SEND_ACTION:
                    if (RelativeUIParam.RELATIVERATIO <= RelativeUIParam.TEMPLETECHANGEDRATIO)
                    {
                        if (CheckDiEditable())
                        {
                            Dictionary<string, object> dataDic = new Dictionary<string, object>();
                            dataDic.Add(OpActionConstant.OP_COMPLETE_DI_RECEIVE_ACTION, null);
                            sentMessage(OpActionConstant.OP_COMPLETE_DI_RECEIVE_ACTION, dataDic, sender);
                        }
                    }
                    break;
                case OpActionConstant.OP_DI_SEND_OR_SIGN_ACTION:
                    if (RelativeUIParam.RELATIVERATIO <= RelativeUIParam.TEMPLETECHANGEDRATIO)
                    {
                        if (CheckDiEditable())
                        {
                            Dictionary<string, object> dataDic = new Dictionary<string, object>();
                            dataDic.Add(OpActionConstant.OP_DI_RECEIVE_OR_SIGN_ACTION, null);
                            sentMessage(OpActionConstant.OP_DI_RECEIVE_OR_SIGN_ACTION, dataDic, sender);
                        }
                    }
                    break;
                case OpActionConstant.OP_DI_SEND_OR_OPEN_ACTION:
                    if (RelativeUIParam.RELATIVERATIO <= RelativeUIParam.TEMPLETECHANGEDRATIO)
                    {
                        if (CheckDiEditable())
                        {
                            Dictionary<string, object> dataDic = new Dictionary<string, object>();
                            dataDic.Add(OpActionConstant.OP_DI_RECEIVE_OR_OPEN_ACTION, null);
                            sentMessage(OpActionConstant.OP_DI_RECEIVE_OR_OPEN_ACTION, dataDic, sender);
                        }
                    }
                    break;
            }
        }

        #endregion
    }
}
