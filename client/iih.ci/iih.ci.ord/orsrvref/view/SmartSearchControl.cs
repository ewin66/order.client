using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.cards.extend;
using xap.cli.sdk.controls;
using xap.cli.sdk.render.Items;
using xap.rui.appfw;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.rui.engine.registers;
using iih.ci.ord.ciorder.utils;
using xap.cli.sdk.form;
using System.Runtime.InteropServices;
using iih.ci.ord.ciorder.render;
using iih.ci.ord.srvref.d;
using xap.mw.serviceframework;
using iih.ci.ord.i;
using iih.ci.ord.ciorder.cards;
using xap.rui.bizcontrol.bannercontrol;
using iih.en.pv.dto.d;
using xap.cli.context;
using xap.sys.orgfw.dept.d;
using xap.mw.coreitf.d;

namespace iih.ci.ord.orsrvref.view
{

    public class SmartSearchControl : XSearch, IXEventPublication, IRegister, IXapBaseControl, IXStateSubscription
    {

        #region 变量定义区域

        /// <summary>
        /// 参数参数对象
        /// </summary>
        private CiSrvRefParamDTO srvRefParamDto;

        /// <summary>
        /// banner数据
        /// </summary>
        private Ent4BannerDTO ent4BannerDto;



        private SmartQueryResultForm resultFrm;
        //TODO srvSearch,lastSrvCa是否应该设置为全局变量
        //private string srvSearch;
        //private string lastSrvCa;
        private OrdChildfrm form;
        private bool Shoutflag;
        private SmartSearchService searchService = new SmartSearchService();
        //private bool Secondflag;
        //private string defDisplayText = "请输入";

        #endregion

        #region 构造函数区域

        public SmartSearchControl()
        {

            this.EnterFlag = false;
            this.dipItemsCout = 8;
            this.DataSource = this.searchService.srvtps; //搜索框分类数据
            this.Size = new Size(300, 24);
            this.SelectedItem = 10;
            this.ForeColor = Color.FromArgb(47, 47, 47);


            this.ValueTextChanging += new ChangingEventHandler(SmartSearchControl_ValueTextChanging);
            this.MouseClick += new MouseEventHandler(SmartSearchControl_MouseClick);
            //this.SelectValueChanged += new EventHandler(SmartSearchControl_SelectValueChanged);

            this.srvRefParamDto = new CiSrvRefParamDTO();

        }

        #endregion

        #region 公开属性区域

        /// <summary>
        /// 展现查询结果的表单ID
        /// </summary>
        private string formId;

        /// <summary>
        /// 展现查询结果的表单ID
        /// </summary>
        public string FormId
        {
            set { formId = value; }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
        private string code_entp;

        /// <summary>
        /// 就诊类型
        /// </summary>
        public string Code_entp
        {
            set { code_entp = value; }
        }

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        /// <summary>
        /// 不实现接口会导致报错
        /// </summary>
        public new void LoadData()
        {

        }

        /// <summary>
        /// 不实现接口会导致报错
        /// </summary>
        public void OnInit()
        {

        }

        #endregion

        #region 内部事件区域

        /// <summary>
        /// 医嘱服务查询输入框值改变时触发
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// Author:hums
        /// Date:2016-05-10
        protected void SmartSearchControl_ValueTextChanging(object sender, ChangingEventArgs e)
        {

            // 加载必要的查询参数，如果加载失败不进行查询
            if (!this.loadSrvRefParamSucc())
            {
                return;
            }


            //界面输入的查询条件
            string inputStr = this.ValueText;

            if (string.IsNullOrEmpty(inputStr))
            {
                //TODO 显示的哪个窗体,后续需要确认是否还有用
                if (form != null)
                {
                    if (form.Handle != GetForegroundWindow())
                    {
                        if (resultFrm.Visible)
                        {
                            resultFrm.Hide();
                            this.ParentForm.Invalidate();
                        }
                    }
                }
            }
            else
            {
                if (resultFrm == null || !resultFrm.Created)
                {
                    resultFrm = new SmartQueryResultForm();
                    //TODO ？
                    resultFrm.IsSwitch = false;

                    resultFrm.DbClickEvent += new SmartQueryResultForm.DbClickHandle(resultFrm_DbClickEvent);
                    resultFrm.StartPosition = FormStartPosition.Manual;

                    // 设置服务结果窗体展现位置
                    Point p = this.ParentForm.PointToScreen(this.Location);
                    this.ParentForm.Invalidate();
                    resultFrm.Local = new Point(p.X, p.Y + this.Size.Height);
                    resultFrm.Size = new Size(this.ParentForm.Parent.Parent.Size.Width - this.ParentForm.Location.X, this.ParentForm.Parent.Parent.Size.Height - (this.Size.Height + this.ParentForm.Location.Y));
                    resultFrm.Show(this.ParentForm);

                    Shoutflag = true;
                }
                else
                {
                    if (!resultFrm.Visible)
                    {
                        Shoutflag = false;
                        resultFrm.IsSwitch = false;
                        resultFrm.Show(this.ParentForm);
                        Shoutflag = true;
                    }
                }


                // 输入内容
                this.srvRefParamDto.Inputstr = inputStr;

                // 调用查询服务方法
                this.SearchSrvData(srvRefParamDto);
                this.Focus();
            }
        }

        /// <summary>
        /// 查询框内点鼠标点击事件</br>
        /// 添加鼠标点击右键时弹出自定义设置框
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnMouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                IndividualForm individualForm = new IndividualForm(srvRefParamDto);
                individualForm.Show();
            }
            else
            {
                base.OnMouseClick(sender, e);
            }
        }

        /// <summary>
        /// 鼠标点击查询框放大镜图标事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void SmartSearchControl_MouseClick(object sender, MouseEventArgs e)
        {

        }

        /// <summary>
        /// 查询控件中服务类型选择事件<br>
        /// 将选择的服务类型赋值给查询条件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void SmartSearchControl_SelectValueChanged(object sender, EventArgs e)
        {
            this.srvRefParamDto.Sd_srvtp = this.SelectKey as string;
        }


        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 加载固定参数
        /// </summary>
        private bool loadSrvRefParamSucc()
        {
            // 校验是否设置表单属性
            if (string.IsNullOrEmpty(this.formId))
            {
                MessageBox.Show("请设置参照表单属性[FormId]");
                return false;
            }
            //绑定表单id
            srvRefParamDto.Id_billform = this.formId;

            // 校验是否设置就诊类型编码
            if (string.IsNullOrEmpty(this.code_entp))
            {
                MessageBox.Show("请设置就诊类型属性[Code_entp]");
                return false;
            }
            // 就诊类型
            srvRefParamDto.Code_entp = this.code_entp;

            // 设置所属的集团、组织、科室（部门）
            UserManager userManager = UserManager.getInstance();
            DeptDO deptDO = userManager.CurrentDept;
            srvRefParamDto.Id_grp = deptDO.Id_grp;
            srvRefParamDto.Id_org = deptDO.Id_org;
            srvRefParamDto.Id_dep = deptDO.Id_dep;


            //TODO 医生使用场景,确定属性值来源
            srvRefParamDto.Fg_doctor = FBoolean.True;

            this.loadDefaultParam();

            return true;
        }

        /// <summary>
        /// 设置查询参数中对应个性化设置的属性值
        /// <para>后续通过该方法获取个性化设置结果</para>
        /// </summary>
        private void loadDefaultParam()
        {

            // 按名称查询标识
            srvRefParamDto.Fg_name = FBoolean.True;

            //// 按编码查询标识
            //srvRefParamDto.Fg_code = FBoolean.True;

            //// 按简称查询标识
            //srvRefParamDto.Fg_shortname = FBoolean.True;
            // 按拼音码查询标识
            srvRefParamDto.Fg_pycode = FBoolean.True;
            //// 按五笔查询标识
            //srvRefParamDto.Fg_wbcode = FBoolean.True;
            //// 按助记码查询标识
            //srvRefParamDto.Fg_mnemonic = FBoolean.True;
        }

        private void showSrvResultForm() { 
            
        }

        #endregion

        #region 状态处理区域

        public void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.LOAD:

                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null && dic.ContainsKey("PatientData") && (dic["PatientData"] != null))
                    {
                        ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                    }

                    break;
            }
        }

        #endregion


        /// <summary>
        /// 医嘱服务查询
        /// </summary>
        /// <param name="srvCa">医嘱服务类型</param>
        /// <param name="inputStr">界面输入的查询条件</param>
        /// Author:hums
        /// Date:2016-05-10
        protected void SearchSrvData(CiSrvRefParamDTO paramDto)
        {
            XapDataList<CiSrvRefResultDTO> srvRefList = null;
            if (paramDto.Inputstr == string.Empty)
            {
                srvRefList = new XapDataList<CiSrvRefResultDTO>();
            }
            else
            {
                srvRefList = searchService.getSrvRefData(paramDto);
            }

            resultFrm.setSrvRefData(srvRefList);
        }



        /// <summary>
        /// 医嘱服务查询输入框值获取焦点
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// Author:hums
        /// Date:2016-05-10
        protected override void TextboxOnGotFocus(object sender, EventArgs e)
        {
            //if (this.ValueText == defDisplayText)
            //{
            //    this.ValueText = string.Empty;
            //    this.ForeColor = Color.Black;

            //}

            //base.TextboxOnGotFocus(sender, e);
        }

        [DllImport("user32.dll")]
        private static extern IntPtr GetForegroundWindow();
        /// <summary>
        /// 医嘱服务查询输入框值失去焦点
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// Author:hums
        /// Date:2016-05-10
        protected override void TextboxOnLostFocus(object sender, EventArgs e)
        {
            // 恢复输入框默认状态
            if (string.IsNullOrEmpty(this.ValueText))
            {
                //this.ValueText = defDisplayText;
                //this.ForeColor = Color.FromArgb(188, 188, 188);
            }

            if (resultFrm != null && resultFrm.Created)
            {
                if (resultFrm.Handle != GetForegroundWindow())
                {
                    if (resultFrm != null && resultFrm.Created && !this.IsFocus)
                    {
                        if (Shoutflag)
                        {
                            resultFrm.Hide();
                        }
                        Shoutflag = true;
                    }
                }
            }

            if (form != null)
            {
                if (form.Handle != GetForegroundWindow())
                {
                    if (form != null && form.Created)
                    {
                        form.Hide();
                    }
                }
            }

            base.TextboxOnLostFocus(sender, e);
        }



        void SearchControlView_MouseClick(object sender, MouseEventArgs e)
        {
            if (form == null || !form.Created)
            {
                form = new OrdChildfrm();
                form.Text = "常用模板";
                form.btnClick += new MouseEventHandler(btnOk_MouseClick);
                form.StartPosition = FormStartPosition.CenterScreen;
                this.form.Size = new Size(this.ParentForm.Parent.Size.Width - this.Location.X + 20, this.ParentForm.Parent.Size.Height - (this.Size.Height + this.Location.Y));
                form.ShowDialog(this.ParentForm);
            }
            else
            {
                form.ShowDialog(this.ParentForm);
            }
        }


        void btnOk_MouseClick(object sender, MouseEventArgs e)
        {
            //if (form != null)
            //{
            //    Dictionary<string, Object> dict = new Dictionary<string, Object>();
            //    dict.Add("newListSelected", form.SelectOrder);
            //    DictionaryEventArgs de = new DictionaryEventArgs();
            //    de.Data.Add(UIConst.UI_EVENT, "ListSelected");
            //    de.Data.Add(UIConst.DATA, dict);
            //    this.EventSent(this, de);
            //}
        }



        public override bool ExecuteDialogKey(Keys keyData)
        {
            if (keyData == Keys.Enter)
            {
                if (resultFrm.or.gv.DataTable != null)
                    resultFrm.or.gv_DoubleClick(null, null);
            }
            else if (keyData == Keys.Up || keyData == Keys.Down)
            {
                int flag = 0;
                if (resultFrm.or.gv.DataTable.SelectedRows.Count != 0)
                {
                    flag = resultFrm.or.gv.DataTable.SelectedRows[0].Index;
                }
                else
                {
                    flag = 0;
                }
                if (keyData == Keys.Down)
                {
                    flag++;
                    resultFrm.or.gv.SelectRow(flag);
                }
                else if (keyData == Keys.Up)
                {
                    flag--;
                    resultFrm.or.gv.SelectRow(flag);
                }
                resultFrm.or.gv.Invalidate();
            }
            return base.ExecuteDialogKey(keyData);
        }


        protected void SearchControlView_KeyClick(object sender, KeyEventArgs e)
        {
            //SearchControlView_ValueTextChanging(null, null);

        }

        public void SetSearchDataSouse(string srvca, string strWhere)
        {

            if (resultFrm != null)
            {
                XapDataList<CiSrvRefResultDTO> dtoList = new XapDataList<CiSrvRefResultDTO>();
                if (strWhere.Length > 0)
                {
                    XapDataList<EmsOrSrvSc> list = searchService.GetSrv(srvca, strWhere.ToUpper());
                    resultFrm.SCTextChanged(list);
                }
                else
                {
                    resultFrm.SCTextChanged(new XapDataList<EmsOrSrvSc>());
                }
            }
        }



        /// <summary>
        /// 医嘱服务列表双击事件
        /// </summary>
        /// <param name="obj">The object.</param>
        /// Author:admin
        /// Date:2015-09-17
        void resultFrm_DbClickEvent(OrScArgs obj)
        {
            //this.IsFocus = false;
            Dictionary<string, Object> dict = new Dictionary<string, Object>();
            dict.Add("newListSelected", obj);
            DictionaryEventArgs de = new DictionaryEventArgs();
            de.Data.Add(UIConst.UI_EVENT, "ListSelected");
            de.Data.Add(UIConst.DATA, dict);
            this.EventSent(this, de);
        }
        public event EventHandler<DictionaryEventArgs> EventSent;


        public object GetRegister()
        {
            return this;
        }




        protected override void DisposeManaged()
        {
            if (resultFrm != null)
            {
                resultFrm.Dispose();
            }
            base.DisposeManaged();
        }






    }
}
