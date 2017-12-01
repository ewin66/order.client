using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.cards.extend;
using xap.cli.sdk.render.Items;
using xap.mw.log;
using xap.rui.appfw;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.rui.engine.registers;
using xap.cli.sdk.form;
using iih.ci.ord.ciorder.viewmodel;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.cli.sdk.controls.DataView;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 医嘱服务查询


*********************************************************************************/
namespace iih.ci.ord.ciorder.view
{
    /// <summary>
    /// 检索框
    /// zhou_zhijian 7.3做阅读注释
    /// </summary>
    public class SearchControlView : XSearch, IXEventPublication, IRegister, IXapBaseControl, IXStateSubscription
    {

        #region 成员变量
        /// <summary>
        /// 患者信息DTO
        /// </summary>
        public Ent4BannerDTO ent4BannerDto;
        /// <summary>
        /// 选择类型
        /// </summary>
        private string lastSrvCa;
        /// <summary>
        /// 数据模型
        /// </summary>
        private OrderSrvListViewModel model = new OrderSrvListViewModel("");
        /// <summary>
        /// 弹出框内部容器
        /// </summary>
        private OrderScEx contentControl;
        /// <summary>
        /// 弹出对话框
        /// </summary>
        private XContextForm frm;
        /// <summary>
        /// 
        /// </summary>
        public event EventHandler<DictionaryEventArgs> EventSent;
        #endregion

        #region 构造

        public SearchControlView()
        {
            this.EnterFlag = false;
            this.dipItemsCout = 8;
            this.DataSource = this.model.srvtps; //搜索框分类数据
            this.lastSrvCa = this.SelectKey as string;
            this.Size = new Size(300, 24);
            this.SelectedItem = 10;
            this.ForeColor = Color.FromArgb(47, 47, 47);

            this.ValueTextChanging += new ChangingEventHandler(SearchControlView_ValueTextChanging);
            this.MouseClick += new MouseEventHandler(SearchControlView_MouseClick);
            this.SelectValueChanged += new EventHandler(SearchControlView_new_SelectValueChanged);

            contentControl = new OrderScEx();
            contentControl.IsShowBorder = true;
            contentControl.Size = new Size(600, 500);
            contentControl.DbClickEvent += new OrderScEx.DbClickHandle(contentControl_DbClickEvent);
            contentControl.KeyPress += new KeyPressEventHandler(contentControl_KeyPress);
            contentControl.KeyDown += new KeyEventHandler(contentControl_KeyDown);
            contentControl.ModelFilled += new EventHandler(contentControl_ModelFilled);
        }

        void contentControl_KeyDown(object sender, KeyEventArgs e)
        {
            switch (e.KeyData)
            {
                case Keys.Left:
                    if (frm != null && frm.Created && !frm.IsDisposed)
                    {
                        frm.Close();
                        this.ParentForm.Invalidate();
                    }
                    this.ExecuteDialogKeyForTextBox(Keys.Left);
                    break;
                case Keys.Right:
                    if (frm != null && frm.Created && !frm.IsDisposed)
                    {
                        frm.Close();
                        this.ParentForm.Invalidate();
                    }
                    this.ExecuteDialogKeyForTextBox(Keys.Right);
                    break;
            }
        }

        #endregion

        #region 事件处理函数
        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void contentControl_ModelFilled(object sender, EventArgs e)
        {
            if (frm != null)
            {
                if (this.ParentForm.Parent.Parent.Size.Height - (this.Size.Height + this.ParentForm.Location.Y) - 10 < (sender as XDataTable).Size.Height)
                {
                    frm.Size = new Size(frm.Width, this.ParentForm.Parent.Parent.Size.Height - (this.Size.Height + this.ParentForm.Location.Y) - 10);
                }
                else
                {
                    frm.Size = new Size(frm.Width, (sender as XDataTable).Size.Height + 17);
                }
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void contentControl_KeyPress(object sender, KeyPressEventArgs e)
        {
            switch (e.KeyChar)
            {
                case (char)Keys.Back:
                    // Backspace 回退
                    string text = this.ValueText;
                    if (!string.IsNullOrEmpty(this.ValueText))
                    {
                        text = text.Remove(this.ValueText.Length - 1);
                        this.ValueText = text;
                        e.Handled = true;
                    }
                    break;
                default:
                    if (char.IsLetterOrDigit(e.KeyChar) || char.IsPunctuation(e.KeyChar))
                    {
                        //字符或数字转发给TextBox
                        this.InsertString(e.KeyChar.ToString());
                        e.Handled = true;
                    }
                    break;
            }
        }


        /// <summary>
        /// 类型发生变化
        /// </summary>
        void SearchControlView_new_SelectValueChanged(object sender, EventArgs e)
        {
            this.lastSrvCa = this.SelectKey as string;
            this.Invalidate();
        }

        /// <summary>
        /// 医嘱服务列表双击事件
        /// </summary>
        void contentControl_DbClickEvent(OrScArgs obj)
        {
            //需要将文本框内部隐藏
            TextBoxVisibleChanged();
            this.ValueText = string.Empty;
            Dictionary<string, Object> dict = new Dictionary<string, Object>();
            dict.Add("newListSelected", obj);
            DictionaryEventArgs de = new DictionaryEventArgs();
            de.Data.Add(UIConst.UI_EVENT, "ListSelected");
            de.Data.Add(UIConst.DATA, dict);
            this.EventSent(this, de);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void SearchControlView_MouseClick(object sender, MouseEventArgs e)
        {
            if (string.IsNullOrEmpty(this.lastSrvCa))
            {
                this.lastSrvCa = this.SelectKey as string;
            }
            if (string.IsNullOrEmpty(this.ValueText))
            {
                SetSearchDataSouse(this.lastSrvCa, " ");
            }
            else
            {
                SetSearchDataSouse(this.lastSrvCa, this.ValueText);
            }
            ShowForm();
            this.Focus();
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void SearchControlView_ValueTextChanging(object sender, ChangingEventArgs e)
        {

            if (string.IsNullOrEmpty(this.lastSrvCa))
            {
                this.lastSrvCa = this.SelectKey as string;
            }
            if (string.IsNullOrEmpty(this.ValueText))
            {
                if (frm != null && frm.Created && !frm.IsDisposed)
                {
                    frm.Close();
                    this.ParentForm.Invalidate();
                }
            }
            else
            {
                SetSearchDataSouse(this.lastSrvCa, this.ValueText);
                ShowForm();
            }
        }

        #endregion

        #region 覆写父类函数
        protected override void TextboxOnGotFocus(object sender, EventArgs e)
        {
            base.TextboxOnGotFocus(sender, e);
        }

        protected override void TextboxOnLostFocus(object sender, EventArgs e)
        {
            if (frm != null && frm.Created)
            {
                frm.Close();
                this.ParentForm.Invalidate();
            }
            base.TextboxOnLostFocus(sender, e);
        }

        protected override void DisposeManaged()
        {
            if (frm != null)
            {
                frm.Dispose();
            }
            base.DisposeManaged();
        }
        #endregion

        #region 私有函数
        /// <summary>
        /// 显示弹出的服务选择对话框
        /// </summary>
        private void ShowForm()
        {
            try
            {
                var pt = this.ParentForm.PointToScreen(new Point(Location.X, Location.Y + Size.Height - 1));
                if (frm == null || !frm.Created)
                {
                    frm = new XContextForm(contentControl);
                    frm.Size = new Size(this.ParentForm.Parent.Parent.Size.Width - this.ParentForm.Location.X - 10,
                        this.ParentForm.Parent.Parent.Size.Height - (this.Size.Height + this.ParentForm.Location.Y) - 10);
                    frm.Show(new Rectangle(pt.X, pt.Y, 0, 0));
                }
                else
                {
                    if (!frm.Visible)
                    {
                        frm.Size = new Size(this.ParentForm.Parent.Parent.Size.Width - this.ParentForm.Location.X - 10,
                            this.ParentForm.Parent.Parent.Size.Height - (this.Size.Height + this.ParentForm.Location.Y) - 10);
                        frm.Show(new Rectangle(pt.X, pt.Y, 0, 0));
                    }
                }
                this.ParentForm.Invalidate();
            }
            catch (Exception e)
            {
                LogManager.GetLogger().ErrorEx("显示服务选择对话框报错", e);
            }
        }
        /// <summary>
        /// 设置搜索的数据源
        /// </summary>
        /// <param name="srvca">服务类型</param>
        /// <param name="strWhere">对应的where条件</param>
        public void SetSearchDataSouse(string srvca, string strWhere)
        {
            try
            {
                contentControl.ScTextChanged(new XapDataList<EmsOrSrvSc>());
                if (strWhere.Length > 0)
                {
                    XapDataList<EmsOrSrvSc> list = model.GetSrv(srvca, strWhere.ToUpper(), this.ent4BannerDto.Code_entp);
                    contentControl.ScTextChanged(list);
                }
                else
                {
                    contentControl.ScTextChanged(new XapDataList<EmsOrSrvSc>());
                }
                contentControl.Invalidate();
            }
            catch { }
        }
        #endregion

        #region IRegister接口实现函数
        public object GetRegister()
        {
            return this;
        }
        #endregion

        #region IXapBaseControl接口实现函数 -- 无用
        public void OnInit()
        {

        }

        public new void LoadData()
        {

        }
        #endregion

        #region IXStateSubscription接口实现函数
        public void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            Dictionary<string, Object> dict = eventArgs.Data[UIConst.DATA] as Dictionary<string, Object>;
            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        if (dic.ContainsKey("PatientData") && dic["PatientData"] != null)
                        {
                            this.ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        #endregion

    }
}