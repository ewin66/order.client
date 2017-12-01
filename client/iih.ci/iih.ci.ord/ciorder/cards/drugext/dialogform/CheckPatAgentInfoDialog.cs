
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.extentions;
using iih.ci.ord.ciord.d;
using xap.cli.sdk.render;
using System.Drawing;
using System.Windows.Forms;
using iih.bd.bc.udi;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.common.util;
using iih.common_stub.idcheck;
using xap.mw.func;
using xap.mw.core.data;
using iih.ci.ord.ciorder.d;
using xap.cli.sdk.render.Items;
using iih.ci.ord.opemergency.tool;

namespace iih.ci.ord.ciorder.cards.drugext.dialogform
{
    /// <summary>
    /// <para>描    述 :       核对患者和代理人信息 	</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.cards.drugext.dialogform    </para>    
    /// <para>类 名 称 :  CheckPat_AgentInfo					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  zhangwq        				</para> 
    /// <para>修 改 人 :  zhangwq         				</para> 
    /// <para>创建时间 :  2016/7/20 17:16:58             </para>
    /// <para>更新时间 :  2016/7/20 17:16:58             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class CheckPatAgentInfoDialog : XBaseDialog
    {
        protected OrSrvAgentInfoDO viewModel { get; set; }
        protected FArrayList srvDos { get; set; }
        XLabelBaseUserRender patAgeRender;
        XLabelBaseUserRender agentAgeRender;
        Dictionary<String, String> patInfoCache = new Dictionary<string, string>();
        public CheckPatAgentInfoDialog(OrSrvAgentInfoDO agentInfodo,FArrayList srvDos)
        {
            this.viewModel = agentInfodo;
            this.srvDos = srvDos;
            InitializeComponent();
            AddButtons(true);
            xapFormControl.Load += new EventHandler(xapFormControl_Load);
            xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            xapFormControl.DataChanged += new EventHandler<xap.rui.control.forms.model.DataChangedEventArgs>(xapFormControl_DataChanged);
            xapFormControl.RefFilter += new EventHandler<xap.rui.control.refcontrol.events.RefActivatingEventArgs>(xapFormControl_RefFilter);
           
            saveButton.MouseClick += new MouseEventHandler(Add_MouseClick);
            this.Panel = xapFormControl;
        }


        public CheckPatAgentInfoDialog(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }
        void xapFormControl_Load(object sender, EventArgs e)
        {
            OnFillData();
            if (!string.IsNullOrEmpty(viewModel.Id_idtp_pat))
                patInfoCache.Add(viewModel.Id_idtp_pat, viewModel.Idno_pat);
            if (!string.IsNullOrEmpty(viewModel.Id_idtp_agent))
                patInfoCache.Add(viewModel.Id_idtp_agent, viewModel.Idno_agent);
        }
        protected override void OnFillData()
        {
            FormFile file = new FormFile
            {
                FormId = "20160720040323484BB2",
                FormStyle = FormStyle.Card,
                ViewModel = this.viewModel
            };
            xapFormControl.ViewFile = file;
        }
        #region 事件
        void xapFormControl_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_agent")) {
                string id_ent = this.viewModel.Id_en;
                e.WherePart = string.Format("en_ent_cont.ds=0 and en_ent_cont.Id_ent='{0}'",id_ent);
            }
        }
        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            patAgeRender = this.xapFormControl.GetUserRender("pat_card", "patAge") as XLabelBaseUserRender;
            
            XUnitTextBoxMul utxt = patAgeRender.UserRender as XUnitTextBoxMul;
            utxt.UnitText = "岁";

            agentAgeRender = this.xapFormControl.GetUserRender("pat_card", "agentAge") as XLabelBaseUserRender;
            agentAgeRender.ValueTextChanged += new EventHandler(ageRender_ValueTextChanged);
            agentAgeRender.ValueTextChanging += ageender_ValueTextChanging;
            agentAgeRender.MaxLength = 4;
            agentAgeRender.MultilineNum = 1;
            XUnitTextBoxMul wutxt = agentAgeRender.UserRender as XUnitTextBoxMul;
            wutxt.UnitText = "岁";
           
        }    
        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            setEditPolicy(true);
            patAgeRender.Enabled = false;
            viewModel.PropertyChanged += new PropertyChangedEventHandler(viewModel_PropertyChanged);
            string name_srvs="";
            foreach(OrdSrvDO srvdo in srvDos){
                name_srvs += ","+srvdo.Name_srv ;
            }
            patAgeRender.ValueText = Convert.ToString(viewModel.Age_pat);
            agentAgeRender.ValueText = Convert.ToString(viewModel.Age_agent);
            (this.xapFormControl.GetUserRender("pat_card", "warninfo") as XLabel).ValueText = string.Format("{0}属于麻醉、精一药品，根据处方管理办法要求需要核对患者身份信息！",name_srvs.Substring(1));
            XLabelBaseUserRender XLabelidPatName = this.xapFormControl.GetUserRender("pat_card", "id_idtp_pat.name") as XLabelBaseUserRender;
            if (XLabelidPatName != null)
            {
                XLabelidPatName.UserRender.Focus();
            }
        }
        private void ageender_ValueTextChanging(object sender, ChangingEventArgs e)
        {
            if (null != e.NewValue)
                e.Cancel = !AssToolEx.IsUnsign(e.NewValue.ToString());

        }
        void ageRender_ValueTextChanged(object sender, EventArgs e)
        {
            XLabelBaseUserRender xLabel = sender as XLabelBaseUserRender;
            if (xLabel.Name.Equals("pat_card_agentAge"))
            {
                string value = xLabel.ValueText;
                if (string.IsNullOrEmpty(value))
                {
                    viewModel.Age_agent = null;
                }
                else {
                    viewModel.Age_agent = int.Parse(value);
                }
            }
        }
        void viewModel_PropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            if (e.PropertyName.Equals("Name_agent"))
            { 
               setIsNullFlag();
            }
        }
        private void Add_MouseClick(object sender, MouseEventArgs e)
        {
            if (saveButton.Contains(e.Location))
            {
                if (xapFormControl.HasErrors)
                {
                    this.ShowInfo("请先处理页面错误");
                    return;
                }
                if (!checkValidate()) {
                    return;
                }
                object obj = xapFormControl.ViewFile.ViewModel;
                xapFormControl.SaveForm();
                DialogResult = DialogResult.OK;
            }

            
            Invalidate();
        }
        void xapFormControl_DataChanged(object sender, xap.rui.control.forms.model.DataChangedEventArgs e)
        {
            if (string.IsNullOrEmpty(e.PropName)) return;
            if (e.PropName.Equals("Id_agent")) {
                //代办人的信息是否必填
                setIsNullFlag();
            }
            OrSrvAgentInfoDO orSrvAgent = e.Data as OrSrvAgentInfoDO;
            if (e.PropName=="Age_agent")
            {
                if (orSrvAgent.Age_agent < 0 || orSrvAgent.Age_agent > 200)
                {
                    this.ShowAlert("年龄输入在0-200岁之间！");
                    return;
                }
            }
            else if (e.PropName.Equals("Idno_agent")) {
                DateTime birth;
                try
                {
                     birth = IDUtil.GetBirthdayByIdentityCardId(orSrvAgent.Idno_agent, true);
                }
                catch (Exception) {
                    return;
                }
                if (birth != null) {
                    int[] ages = CalcAgeArray.getAgeArray(birth);
                    if (ages != null)
                    {
                        orSrvAgent.Age_agent = ages[0];
                    }
                }
                var idsex=0;
                Int32.TryParse(IDUtil.GetCardIdInfo(orSrvAgent.Idno_agent)[3], out idsex);
                orSrvAgent.Sd_sextp_agent = idsex.ToString();
                orSrvAgent.Id_sextp_agent = idsex.ToString().Equals(PiDictCodeConst.SD_SEX_MALE) ? PiDictCodeConst.ID_SEX_MALE : PiDictCodeConst.ID_SEX_FEMALE;
                orSrvAgent.Name_sextp_agent = idsex.ToString().Equals(PiDictCodeConst.SD_SEX_MALE) ? PiDictCodeConst.NAME_SEX_MALE : PiDictCodeConst.NAME_SEX_FEMALE;
            }
            else if (e.PropName.Equals("Id_idtp_pat"))
            {
                if (!string.IsNullOrEmpty(orSrvAgent.Id_idtp_pat) && patInfoCache.Keys.Contains(orSrvAgent.Id_idtp_pat))
                    orSrvAgent.Idno_pat = this.patInfoCache[orSrvAgent.Id_idtp_pat];
                else
                    orSrvAgent.Idno_pat = "";
            }
        }
        #endregion
        /// <summary>
        /// 添加按钮，设置窗口名称
        /// </summary>
        /// <param name="add">false为编辑，ture为新增</param>
        private void AddButtons(bool add)
        {
            saveButton = new XButton { Size = new Size(75, 25), Text = "确定" };
            Text = @"患者信息核对";
            AddRender_Btn(saveButton);
        }
        private void setEditPolicy(bool edit)
        {
            xapFormControl.SetEditPolicy(edit);
        }
        private bool checkValidate() {
            if (viewModel == null) return false;
            if (viewModel.Sd_idtp_pat == PiDictCodeConst.SD_IDTP_IDCARD)
            {
                if (string.IsNullOrEmpty(viewModel.Idno_pat)||!IdChecker.CheckIDCard(viewModel.Idno_pat))
                {
                    this.ShowInfo("请录入正确的患者身份证号！");
                    (this.xapFormControl.GetUserRender("pat_card", "idno_pat") as XLabelBaseUserRender).UserRender.Focus();
                    return false;
                }
            }
            if (viewModel.Sd_idtp_agent == PiDictCodeConst.SD_IDTP_IDCARD) {
                if (string.IsNullOrEmpty(viewModel.Idno_agent) || !IdChecker.CheckIDCard(viewModel.Idno_agent)) // (^\d{18}$)|(^\d{15}$)<= 错误， 在 18位身份证号码最后一位允许一位字母，
                {
                    this.ShowInfo("请录入正确的代办人身份证号！");
                    (this.xapFormControl.GetUserRender("pat_card", "idno_agent") as XLabelBaseUserRender).UserRender.Focus();
                    return false;
                }
            }
            if (viewModel.Age_agent!=null&&(viewModel.Age_agent<0||viewModel.Age_agent>200))
            {
                this.ShowAlert("年龄输入在0-200岁之间！");
                return false;    
            }
            if (!String.IsNullOrWhiteSpace(viewModel.Id_idtp_agent) && 
                !String.IsNullOrWhiteSpace(viewModel.Id_idtp_pat) &&
                !String.IsNullOrWhiteSpace(viewModel.Idno_pat) &&
                !String.IsNullOrWhiteSpace(viewModel.Idno_agent)&& 
                viewModel.Id_idtp_agent.Equals(viewModel.Id_idtp_pat) &&
                viewModel.Idno_pat.Equals(viewModel.Idno_agent))
            {
                this.ShowInfo("患者证件号码不能与代办人证件号码相同！");
                return false;
            }
            return true;
        }
        private void setIsNullFlag()
        {
            string name_agent = (this.xapFormControl.GetUserRender("pat_card", "name_agent") as XLabelBaseUserRender).ValueText;
                if (name_agent == null || name_agent == "")
                {
                    (this.xapFormControl.GetUserRender("pat_card", "id_idtp_agent.name") as XLabelBaseUserRender).NullFlag = true;
                    (this.xapFormControl.GetUserRender("pat_card", "idno_agent") as XLabelBaseUserRender).NullFlag = true;
                }
                else
                {
                    (this.xapFormControl.GetUserRender("pat_card", "id_idtp_agent.name") as XLabelBaseUserRender).NullFlag = false;
                    (this.xapFormControl.GetUserRender("pat_card", "idno_agent") as XLabelBaseUserRender).NullFlag = false;
                }
        }
    }
}
