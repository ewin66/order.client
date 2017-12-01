using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using System.Drawing;
using xap.cli.sdk.controls.banner.renders;
using System.Windows.Forms;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.ortpl.d;
using xap.mw.core.data;
using xap.sys.xbd.measdoc.d;
using iih.ci.ord.dto.newordertemplatedto.d;
using System.Reflection;

namespace iih.ci.ord.ciorder.render
{
    /*

* ==============================================================================
*
* Filename: 树伟
* Description: 
*
* Version: 1.0
* Created: 2015/11/13 15:17:19
* Compiler: Visual Studio 2010
*
* Author: 常树伟
* Company: 北大医信
*
* ==============================================================================
*/
    public class OrderRender : XRenderGroup
    {
        //判断是单选框还是多选框默认是多选框
        private bool isRadio;

        public delegate void CheckValuechanged(OrderRender render, bool flag);
        public event CheckValuechanged Checkchanged;
        public event CheckValuechanged CancelChecked;
        //可能是单选或者多选
        protected XCheckBox check;
        protected XRadiobox radio;
        //复选框是否可编辑（默认都可编辑）
        public bool EditFlag;
        public int LastBottm;
        public List<Brieflabel> lablelist = new List<Brieflabel>();
        //医嘱模板多药品情况下每一种药品对应的数据源
        //private List<XComboBoxUnit> XComboBoxUnitList;
        private List<XUnitTextBoxMul> XUnitTextBoxList;

        public override Size Size
        {
            get
            {
                return base.Size;
            }
            set
            {
                base.Size = value;
            }
        }
        //设置check属性
        public bool Check
        {
            get
            {
                if (isRadio)
                {
                    return this.radio.Checked;
                }
                else
                {
                    return this.check.Checked;
                }
            }
            set
            {
                if (isRadio)
                {
                    if (!this.radio.Enabled)
                    {
                       this.radio.Checked = false;
                    }
                    else
                    {
                       this.radio.Checked = value;
                    }
                }
                else
                {
                    if (!this.check.Enabled)
                    {
                        this.check.Checked = false;
                    }
                    else 
                    {
                        this.check.Checked = value;
                    }
                }
            }
        }

        #region  单独带单位控件

        //若是带单位控件的话单位的数据源
        private Dictionary<object, string> freUnitDataSource;
        public Dictionary<object, string> FreUnitDataSource
        {
            get
            {
                return this.freUnitDataSource;
            }
            set
            {
                this.freUnitDataSource = value;
                if (this.hasUnit && freUnitRender != null)
                {
                    freUnitRender.DataSource = value;
                }
            }
        }
        //单位控件的数量
        private string freUnitValueText;
        public string FreUnitValueText
        {
            get
            {
                return this.freUnitValueText;
            }
            set
            {
                this.freUnitValueText = value;
                if (this.hasUnit && freUnitRender != null)
                {
                    freUnitRender.ValueText = value;
                }
            }
        }
        //单位控件默认选中的单位
        private string freUnitValueUnit;
        public string FreUnitValueUnit
        {
            get
            {
                return this.freUnitValueUnit;
            }
            set
            {
                this.freUnitValueUnit = value;
                if (this.hasUnit && freUnitRender != null)
                {
                    freUnitRender.ValueUnit = value;
                }
            }
        }

        private XComboBoxUnit freUnitRender;
        //是否是单独带计量单位
        private bool hasUnit;
        public bool HasUnit
        {
            get
            {
                return this.hasUnit;
            }
            set
            {
                this.hasUnit = value;
                if (freUnitRender != null)
                {
                    this.RemoveRender(freUnitRender);
                }
                if (value)
                {
                    freUnitRender = new XComboBoxUnit();
                    freUnitRender.Size = new Size(92, 24);
                    freUnitRender.ValueText = FreUnitValueText;
                    freUnitRender.DataSource = freUnitDataSource;
                    freUnitRender.ValueUnit = FreUnitValueUnit;
                    freUnitRender.Location = new Point(this.Bound.Right - freUnitRender.Size.Width - 10, this.Bound.Top);
                    this.AddRender(freUnitRender);
                }
            }
        }

        #endregion

        #region 单独带文本label

        private string note;
        private string[] noteArray;
        private List<Brieflabel> noteList;
        private Brieflabel noteLabel;
        public Dictionary<int, Brieflabel> noteDict = new Dictionary<int, Brieflabel>();
        public string Note
        {
            get
            {
                return this.note;
            }
            set
            {
                if (value != null)
                {
                    this.note = value;
                    this.noteArray = value.Split(',');
                    this.noteList = new List<Brieflabel>();
                    this.noteDict.Clear();
                    for (int i = 0; i < this.noteArray.Length; i++)
                    {
                        if (!string.IsNullOrWhiteSpace(this.noteArray[i]))
                        {
                            noteLabel = new Brieflabel();
                            //noteLabel.Size = new Size(165, 24);
                            //noteLabel.Topspace = 3;
                            noteLabel.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                            noteLabel.Text = this.noteArray[i];
                            if (TextRenderer.MeasureText(noteLabel.Text, noteLabel.Font).Width > 165 )
                            {
                                noteLabel.Size = new Size(165, 24);
                            }
                            else
                            {
                                noteLabel.Size = new Size(TextRenderer.MeasureText(noteLabel.Text, noteLabel.Font).Width, 24);
                            }

                            this.noteList.Add(noteLabel);
                            this.AddRender(noteLabel);
                            if (!this.noteDict.ContainsKey(i))
                            {
                                this.noteDict.Add(i, noteLabel);
                            }
                        }
                    }
                }
            }
        }

        #endregion

        private object[] Listdo;
        public object[] ListDo //Do集合
        {
            get
            {
                return this.Listdo;
            }
            set
            {
                this.Listdo = value;
            }
        }

        private Object objdo;
        public Object ObjDo// 对应的do
        {
            get
            {
                return this.objdo;
            }
            set
            {
                this.objdo = value;
                Load();
            }
        }

        public override Point Location
        {
            get
            {
                return base.Location;
            }
            set
            {
                base.Location = value;
                RecLocat();
            }
        }

        protected bool isparent = true;
        public bool IsParent
        {
            get
            {
                return this.isparent;
            }
            set
            {
                if (this.isparent != value)
                {
                    this.isparent = value;
                }
            }
        }

        private Image disableImage;
        private Rectangle disableImageRect;
        /// <summary>
        /// 禁用提示标题
        /// </summary>
        public string DisableTipText { get; set; }
        private bool isEnabled = true;
        //对象是否可以被选择
        public bool IsEnabled
        {
            get
            {
                return this.isEnabled;
            }
            set
            {
                if (this.isEnabled != value)
                {
                    this.isEnabled = value;
                }
                foreach (UserRender user in this.UserRenderList)
                {
                    user.Enabled = value;
                }
            }
        }

        private XToolTipRender tooltip = new XToolTipRender();

        public bool IsOpenTooltip
        {
            get { return (this.tooltip != null && this.tooltip.IsShowing); }
        }

        Brieflabel lable;

        private OrderRender parentOrderRender;
        public OrderRender ParentOrderRender
        {
            get
            {
                return this.parentOrderRender;
            }
        }

        public List<OrderRender> OrderRenderList;
        public string Id;

        /// <summary>
        /// 参与location处理的对象的列表（不包括单选或多选按钮和其余特殊存在之外的集合）
        /// </summary>
        public List<UserRender> RenderList;
        /// <summary>
        /// 模板render
        /// </summary>
        /// <param name="parent">父容器</param>
        /// <param name="isRadio">是否是单选</param>
        public OrderRender(Control parent, bool isRadio = false)
        {
            this.parent = parent;
            this.isRadio = isRadio;
            this.EditFlag = true;
            this.disableImage = Bitmap.FromStream(Assembly.GetCallingAssembly().GetManifestResourceStream("iih.ci.ord.res.image.ci.报错.png"));
            if (this.isRadio)
            {
                this.radio = new XRadiobox();
                this.radio.Size = new Size(17, 24);
                this.radio.ValueTextChanged += new EventHandler(render_ValueTextChanged);
                this.AddRender(radio);
            }
            else
            {
                this.check = new XCheckBox();
                this.check.Size = new Size(17, 24);
                this.check.ValueTextChanged += new EventHandler(render_ValueTextChanged);
                this.AddRender(check);
            }
            this.Check = false;
        }

        void render_ValueTextChanged(object sender, EventArgs e)
        {
            if (isRadio)
            {
                if (this.radio.Checked && this.Checkchanged != null)
                {
                    this.Checkchanged(this, true);
                }
                if (!this.radio.Checked && this.CancelChecked != null)
                {
                    this.CancelChecked(this,false);
                }
                this.Check = this.radio.Checked;
            }
            else
            {
                if (this.Checkchanged != null)
                {
                    this.Checkchanged(this, true);
                }
                this.Check = this.check.Checked;
            }
        }

        protected void Load()
        {
            this.RenderList = new List<UserRender>();

            if (this.ListDo != null && this.ListDo.Length > 0)
            {
                if (this.ListDo.Length > 0)
                {
                    OrderRender TMP = new OrderRender(this.parent);
                    #region Ui_flag=1 套
                    if ((ObjDo as NewOrderTemplateDTO).Ui_flag == "1")
                    {
                        lable = new Brieflabel();
                        lable.ForeColor = Color.FromArgb(0, 153, 229);
                        //lable.Size = new Size(141, 24);
                        //lable.Topspace = 4;
                        lable.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                        lable.Text = (ObjDo as NewOrderTemplateDTO).Name;
                        if (TextRenderer.MeasureText(lable.Text, lable.Font).Width > 141 )
                        {
                            lable.Size = new Size(141, 24);
                        }
                        else
                        {
                            lable.Size = new Size(TextRenderer.MeasureText(lable.Text, lable.Font).Width, 24);
                        }
                        this.lablelist.Add(lable);
                        this.AddRender(lable);
                        this.RenderList.Add(lable);
                        OrderRenderList = new List<OrderRender>();
                        foreach (OrTplNItmDO Second in this.ListDo)
                        {
                            OrderRender ThreadRender = new OrderRender(this.parent);
                            ThreadRender.ObjDo = Second;
                            ThreadRender.EditFlag = Second.Fg_edit.Value;
                            ThreadRender.Id = Second.Id_ortmplitm;
                            ThreadRender.Size = new Size(260, 24);
                            ThreadRender.parentOrderRender = this;
                            ThreadRender.isparent = false;
                            OrderRenderList.Add(ThreadRender);
                            this.AddRender(ThreadRender);
                            this.RenderList.Add(ThreadRender);
                            TMP = ThreadRender;
                        }
                    }
                    #endregion

                    #region 2:(多药品)药品
                    else if ((ObjDo as NewOrderTemplateDTO).Ui_flag == "2")
                    {
                        lable = new Brieflabel();
                        lable.ForeColor = Color.FromArgb(0, 153, 229);
                        //lable.Size = new System.Drawing.Size(141, 24);
                        //lable.Topspace = 4;
                        lable.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                        lable.Text = (ObjDo as NewOrderTemplateDTO).Name;
                        if (TextRenderer.MeasureText(lable.Text, lable.Font).Width > 141)
                        {
                            lable.Size = new Size(141, 24);
                        }
                        else
                        {
                            lable.Size = new Size(TextRenderer.MeasureText(lable.Text, lable.Font).Width, 24);
                        }
                        XComboBox freqnc = new XComboBox(this.parent);
                        freqnc.Location = new Point(lable.Bound.Right + 5, lable.Bound.Top - 3);
                        //freqnc.DataSource = (ObjDo as NewOrderTemplateDTO).getFreqdefdo();
                        freqnc.ValueText = (this.ListDo[0] as OrTplNItmDO).Ortplnitm_srv_name;
                        freqnc.Size = new System.Drawing.Size(92, 24);
                        freqnc.ValueTextChanged += new EventHandler(freqnc_ValueTextChanged);
                        this.lablelist.Add(lable);
                        this.AddRender(lable);
                        this.AddRender(freqnc);
                        this.RenderList.Add(lable);
                        this.RenderList.Add(freqnc);
                        OrderRenderList = new List<OrderRender>();
                        XUnitTextBoxList = new List<XUnitTextBoxMul>();
                        foreach (OrTplNItmDO Second in this.ListDo)
                        {
                            OrderRender ThreadRender = new OrderRender(this.parent);
                            ThreadRender.ObjDo = Second;
                            ThreadRender.Id = Second.Id_ortmplitm;
                            ThreadRender.Size = new Size(260, 24);
                            ThreadRender.parentOrderRender = this;
                            ThreadRender.isparent = false;
                            this.AddRender(ThreadRender);
                            this.RenderList.Add(ThreadRender);
                            OrderRenderList.Add(ThreadRender);
                            //XComboBoxUnitList = new List<XComboBoxUnit>();
                            //XComboBoxUnit UnitReUnder = new XComboBoxUnit(this.parent);
                            //UnitReUnder.ValueText = Second.Quan_med.ToString();
                            //UnitReUnder.DataSource = (ObjDo as NewOrderTemplateDTO).getmeasList();
                            //UnitReUnder.ValueUnit = Second.Id_unit_med;
                            //ThreadRender.Check = false;
                            //UnitReUnder.Location = new Point(ThreadRender.Bound.Right, ThreadRender.Bound.Top);
                            //UnitReUnder.ValueTextChanged += new EventHandler(ComBoxUnitReUnder_ValueTextChanged);
                            //UnitReUnder.SelectValueChanged += new EventHandler(ComBoxUnitReUnder_SelectValueChanged);
                            //ThreadRender.AddRender(UnitReUnder);
                            //ThreadRender.RenderList.Add(UnitReUnder);
                            //XComboBoxUnitList.Add(UnitReUnder);

                            XUnitTextBoxMul UnitTextBoxUnder = new XUnitTextBoxMul();
                            UnitTextBoxUnder.Size = new System.Drawing.Size(92, 24);
                            UnitTextBoxUnder.IsNumber = true;
                            UnitTextBoxUnder.NullFlag = false;
                            UnitTextBoxUnder.MinValue = 0;
                            UnitTextBoxUnder.MaxLength = 4;
                            UnitTextBoxUnder.ValueText = Second.Quan_med.ToString();
                            UnitTextBoxUnder.UnitText = Second.Ortplnitm_unit_name;
                            ThreadRender.Check = false;
                            UnitTextBoxUnder.Location = new Point(ThreadRender.Bound.Right, ThreadRender.Bound.Top);
                            UnitTextBoxUnder.ValueTextChanged += new EventHandler(UnitTextBoxUnder_ValueTextChanged);
                            ThreadRender.AddRender(UnitTextBoxUnder);
                            ThreadRender.RenderList.Add(UnitTextBoxUnder);
                            XUnitTextBoxList.Add(UnitTextBoxUnder);
                            TMP = ThreadRender;
                        }
                    }
                    #endregion
                    #region 5 草药
                    else if ((ObjDo as NewOrderTemplateDTO).Ui_flag == "5")
                    {
                        lable = new Brieflabel();
                        lable.ForeColor = Color.FromArgb(0, 153, 229);
                        //lable.Size = new System.Drawing.Size(141, 24);
                        //lable.Topspace = 4;
                        lable.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                        lable.Text = (ObjDo as NewOrderTemplateDTO).Name;
                        if (TextRenderer.MeasureText(lable.Text, lable.Font).Width > 141)
                        {
                            lable.Size = new Size(141, 24);
                        }
                        else
                        {
                            lable.Size = new Size(TextRenderer.MeasureText(lable.Text, lable.Font).Width, 24);
                        }
                        // XComboBox freqnc = new XComboBox(this.parent);
                        //freqnc.Location = new Point(lable.Bound.Right + 5, lable.Bound.Top - 3);
                        //freqnc.DataSource = (ObjDo as NewOrderTemplateDTO).getFreqdefdo();
                        //freqnc.ValueText = (this.ListDo[0] as OrTplNItmDO).Ortplnitm_srv_name;
                        //freqnc.Size = new System.Drawing.Size(92, 24);
                        //freqnc.ValueTextChanged += new EventHandler(freqnc_ValueTextChanged);
                        this.lablelist.Add(lable);
                        this.AddRender(lable);
                        // this.AddRender(freqnc);
                        this.RenderList.Add(lable);
                        //this.RenderList.Add(freqnc);
                        OrderRenderList = new List<OrderRender>();
                        XUnitTextBoxList = new List<XUnitTextBoxMul>();
                        foreach (OrTplNItmDO Second in this.ListDo)
                        {
                            OrderRender ThreadRender = new OrderRender(this.parent);
                            ThreadRender.ObjDo = Second;
                            ThreadRender.Id = Second.Id_ortmplitm;
                            ThreadRender.Size = new Size(260, 24);
                            ThreadRender.parentOrderRender = this;
                            ThreadRender.isparent = false;
                            this.AddRender(ThreadRender);
                            this.RenderList.Add(ThreadRender);
                            OrderRenderList.Add(ThreadRender);
                            //XComboBoxUnitList = new List<XComboBoxUnit>();
                            //XComboBoxUnit UnitReUnder = new XComboBoxUnit(this.parent);
                            //UnitReUnder.ValueText = Second.Quan_med.ToString();
                            //UnitReUnder.DataSource = (ObjDo as NewOrderTemplateDTO).getmeasList();
                            //UnitReUnder.ValueUnit = Second.Id_unit_med;
                            //ThreadRender.Check = false;
                            //UnitReUnder.Location = new Point(ThreadRender.Bound.Right, ThreadRender.Bound.Top);
                            //UnitReUnder.ValueTextChanged += new EventHandler(ComBoxUnitReUnder_ValueTextChanged);
                            //UnitReUnder.SelectValueChanged += new EventHandler(ComBoxUnitReUnder_SelectValueChanged);
                            //ThreadRender.AddRender(UnitReUnder);
                            //ThreadRender.RenderList.Add(UnitReUnder);
                            //XComboBoxUnitList.Add(UnitReUnder);

                            XUnitTextBoxMul UnitTextBoxUnder = new XUnitTextBoxMul();
                            UnitTextBoxUnder.Size = new System.Drawing.Size(92, 24);
                            UnitTextBoxUnder.IsNumber = true;
                            UnitTextBoxUnder.NullFlag = false;
                            UnitTextBoxUnder.MinValue = 0;
                            UnitTextBoxUnder.MaxLength = 4;
                            UnitTextBoxUnder.ValueText = Second.Quan_med.ToString();
                            UnitTextBoxUnder.UnitText = Second.Ortplnitm_unit_name;
                            ThreadRender.Check = false;
                            UnitTextBoxUnder.Location = new Point(ThreadRender.Bound.Right, ThreadRender.Bound.Top);
                            UnitTextBoxUnder.ValueTextChanged += new EventHandler(UnitTextBoxUnder_ValueTextChanged);
                            ThreadRender.AddRender(UnitTextBoxUnder);
                            ThreadRender.RenderList.Add(UnitTextBoxUnder);
                            XUnitTextBoxList.Add(UnitTextBoxUnder);
                            TMP = ThreadRender;
                        }
                    }
                    #endregion
                    #region 3:(单一药品),4其他
                    else if ((ObjDo as NewOrderTemplateDTO).Ui_flag == "3")
                    {
                        if (this.ListDo[0] is OrTplNItmDO)
                        {
                            this.isparent = false;
                            this.Id = (this.ListDo[0] as OrTplNItmDO).Id_ortmplitm;
                            lable = new Brieflabel();
                            lable.ForeColor = Color.FromArgb(0, 153, 229);
                            //lable.Size = new System.Drawing.Size(141, 24);
                            //lable.Topspace = 4;
                            lable.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                            lable.Text = (this.ListDo[0] as OrTplNItmDO).Ortplnitm_srv_name;
                            if (TextRenderer.MeasureText(lable.Text, lable.Font).Width > 141)
                            {
                                lable.Size = new Size(141, 24);
                            }
                            else
                            {
                                lable.Size = new Size(TextRenderer.MeasureText(lable.Text, lable.Font).Width, 24);
                            }
                            lablelist.Add(lable);
                            this.AddRender(lable);
                            this.RenderList.Add(lable);
                            XOrderUnitFreqGroup unitFreqGroup = new XOrderUnitFreqGroup(this.parent, false);
                            this.Check = false;
                            unitFreqGroup.ValueText = (this.ListDo[0] as OrTplNItmDO).Quan_med.ToString();
                            // unitFreqGroup.UnitDataSource = (ObjDo as NewOrderTemplateDTO).getmeasList();
                            unitFreqGroup.UnitValueText = (this.ListDo[0] as OrTplNItmDO).Ortplnitm_unit_name;
                            unitFreqGroup.FreqncDataSource = (ObjDo as NewOrderTemplateDTO).getFreqdefdo();
                            unitFreqGroup.FreqncValueText = (this.ListDo[0] as OrTplNItmDO).Ortplnitm_freq_name;
                            // unitFreqGroup.UnitReUnderSelectValueChanged += new EventHandler(UnitReUnder_SelectValueChanged);
                            unitFreqGroup.UnitTextBoxValueTextChanged += new EventHandler(unitFreqGroup_UnitTextBoxValueTextChanged);
                            unitFreqGroup.FreqncRenderValueTextChanged += new EventHandler(FreqncRender_ValueTextChanged);
                            this.AddRender(unitFreqGroup);
                            this.RenderList.Add(unitFreqGroup);
                        }
                    }
                    else
                    {
                        if (this.ListDo[0] is OrTplNItmDO)
                        {
                            this.isparent = false;
                            this.Id = (this.ListDo[0] as OrTplNItmDO).Id_ortmplitm;
                            lable = new Brieflabel();
                            //lable.Size = new System.Drawing.Size(141, 24);
                            lable.ForeColor = Color.FromArgb(0, 153, 229);
                            //lable.Topspace = 4;
                            lable.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                            lable.Text = (this.ListDo[0] as OrTplNItmDO).Ortplnitm_srv_name;
                            if (TextRenderer.MeasureText(lable.Text, lable.Font).Width > 141)
                            {
                                lable.Size = new Size(141, 24);
                            }
                            else
                            {
                                lable.Size = new Size(TextRenderer.MeasureText(lable.Text, lable.Font).Width, 24);
                            }
                            lablelist.Add(lable);
                            this.AddRender(lable);
                            this.RenderList.Add(lable);
                        }
                    }
                    #endregion
                    this.LastBottm = TMP.Bound.Bottom;
                }
            }
            #region 单一使用没有子元素
            else if (this.ObjDo != null)
            {
                if (this.ObjDo is MedSrvDO)
                {
                    lable = new Brieflabel();
                    //lable.Size = new System.Drawing.Size(171, 24);
                    //lable.Topspace = 4;
                    lable.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                    lable.Text = (this.ObjDo as MedSrvDO).Name;
                    if (TextRenderer.MeasureText(lable.Text, lable.Font).Width > 171)
                    {
                        lable.Size = new Size(171, 24);
                    }
                    else
                    {
                        lable.Size = new Size(TextRenderer.MeasureText(lable.Text, lable.Font).Width, 24);
                    }
                    lablelist.Add(lable);
                    this.AddRender(lable);
                    this.RenderList.Add(lable);
                }
                if (this.ObjDo is OrTplItmDtDO)
                {
                    lable = new Brieflabel();
                    //lable.Size = new System.Drawing.Size(141, 24);
                    //lable.Topspace = 4;
                    lable.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                    lable.Text = (this.ObjDo as OrTplItmDtDO).Name_srv;
                    if (TextRenderer.MeasureText(lable.Text, lable.Font).Width > 141)
                    {
                        lable.Size = new Size(141, 24);
                    }
                    else
                    {
                        lable.Size = new Size(TextRenderer.MeasureText(lable.Text, lable.Font).Width, 24);
                    }
                    lablelist.Add(lable);
                    this.AddRender(lable);
                    this.RenderList.Add(lable);
                }
                if (this.ObjDo is SrvortplitemAggDO)
                {
                    lable = new Brieflabel();
                    //lable.Size = new System.Drawing.Size(141, 24);
                    //lable.Topspace = 4;
                    lable.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                    lable.Text = (this.ObjDo as SrvortplitemAggDO).getParentDO().Name_srv;
                    if (TextRenderer.MeasureText(lable.Text, lable.Font).Width > 141)
                    {
                        lable.Size = new Size(141, 24);
                    }
                    else
                    {
                        lable.Size = new Size(TextRenderer.MeasureText(lable.Text, lable.Font).Width, 24);
                    }
                    lablelist.Add(lable);
                    this.AddRender(lable);
                    this.RenderList.Add(lable);
                }
                if (this.ObjDo is RegularOrRelSrvDO)
                {
                    lable = new Brieflabel();
                    //lable.Size = new System.Drawing.Size(171, 24);
                    //lable.Topspace = 4;
                    lable.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                    lable.Text = (this.ObjDo as RegularOrRelSrvDO).Name_srv;
                    if (TextRenderer.MeasureText(lable.Text, lable.Font).Width > 171)
                    {
                        lable.Size = new Size(171, 24);
                    }
                    else
                    {
                        lable.Size = new Size(TextRenderer.MeasureText(lable.Text, lable.Font).Width, 24);
                    }
                    lablelist.Add(lable);
                    this.AddRender(lable);
                    this.RenderList.Add(lable);
                }
                if (this.ObjDo is OrTplNItmDO)
                {
                    lable = new Brieflabel();
                    //lable.Size = new System.Drawing.Size(141, 24);
                    //lable.Topspace = 4;
                    lable.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
                    lable.Text = (this.ObjDo as OrTplNItmDO).Ortplnitm_srv_name;
                    if (TextRenderer.MeasureText(lable.Text, lable.Font).Width > 141)
                    {
                        lable.Size = new Size(141, 24);
                    }
                    else
                    {
                        lable.Size = new Size(TextRenderer.MeasureText(lable.Text, lable.Font).Width, 24);
                    }
                    lablelist.Add(lable);
                    this.AddRender(lable);
                    this.RenderList.Add(lable);
                }
            #endregion
            }
            RecLocat();
        }

        private void UnitTextBoxUnder_ValueTextChanged(object sender, EventArgs e)
        {
            XUnitTextBoxMul render = sender as XUnitTextBoxMul;
            if (this.XUnitTextBoxList != null && this.XUnitTextBoxList.Count > 0 && this.XUnitTextBoxList.Count == this.ListDo.Length)
            {
                for (int i = 0; i < this.XUnitTextBoxList.Count; i++)
                {
                    if (this.XUnitTextBoxList[i] == render && this.ListDo[i] is OrTplNItmDO)
                    {
                        if (render.ValueText != "-")
                        {
                             if (string.IsNullOrWhiteSpace(render.ValueText))
                            {
                                (this.ListDo[i] as OrTplNItmDO).Quan_med = 0;
                            }
                            else
                            {
                                (this.ListDo[i] as OrTplNItmDO).Quan_med = Convert.ToDouble(render.ValueText);
                            }
                            break;
                        }
                    }
                }
            }
        }

        private void FreqncRender_ValueTextChanged(object sender, EventArgs e)
        {
            XComboBox render = sender as XComboBox;
            if (this.ListDo != null && this.ListDo.Length > 0 && (this.ListDo[0] is OrTplNItmDO))
            {
                (this.ListDo[0] as OrTplNItmDO).Id_freq = render.ValueText;
                (this.ListDo[0] as OrTplNItmDO).Ortplnitm_freq_name = render.ShowText;
            }
        }

        private void unitFreqGroup_UnitTextBoxValueTextChanged(object sender, EventArgs e)
        {
            XUnitTextBoxMul render = sender as XUnitTextBoxMul;
            if (this.ListDo != null && this.ListDo.Length > 0)
            {
                if (render.ValueText != "-")
                {
                    if (string.IsNullOrWhiteSpace(render.ValueText))
                    {
                        (this.ListDo[0] as OrTplNItmDO).Quan_med = 0;
                    }
                    else
                    {
                        (this.ListDo[0] as OrTplNItmDO).Quan_med = Convert.ToDouble(render.ValueText);
                    }
                }
            }
        }

        private void freqnc_ValueTextChanged(object sender, EventArgs e)
        {
            XComboBox render = sender as XComboBox;
            if (this.ListDo != null && this.ListDo.Length > 0)
            {
                for (int i = 0; i < this.ListDo.Length; i++)
                {
                    (this.ListDo[i] as OrTplNItmDO).Id_freq = render.ValueText;
                }
            }
        }

        #region 注释掉暂时不用的方法
        //private void UnitReUnder_SelectValueChanged(object sender, EventArgs e)
        //{
        //    XComboBoxUnit render = sender as XComboBoxUnit;
        //    if (this.ListDo != null && this.ListDo.Length > 0 && (this.ListDo[0] is OrTplNItmDO))
        //    {
        //        (this.ListDo[0] as OrTplNItmDO).Id_unit_med = render.SelectedItem.ToString();
        //        (this.ListDo[0] as OrTplNItmDO).Ortplnitm_unit_name = render.ValueUnit;
        //    }
        //}


        //private void ComBoxUnitReUnder_ValueTextChanged(object sender, EventArgs e)
        //{
        //    XComboBoxUnit render = sender as XComboBoxUnit;
        //    if (this.XComboBoxUnitList != null && this.XComboBoxUnitList.Count > 0 && this.XComboBoxUnitList.Count == this.ListDo.Length)
        //    {
        //        for (int i = 0; i < this.XComboBoxUnitList.Count;i++ )
        //        {
        //            if (this.XComboBoxUnitList[i] == render && this.ListDo[i] is OrTplNItmDO)
        //            {
        //                (this.ListDo[i] as OrTplNItmDO).Quan_med = Convert.ToDouble(render.ValueText);
        //                break;
        //            }
        //        }
        //    }
        //}

        //private void ComBoxUnitReUnder_SelectValueChanged(object sender, EventArgs e)
        //{
        //    XComboBoxUnit render = sender as XComboBoxUnit;
        //    if (this.XComboBoxUnitList != null && this.XComboBoxUnitList.Count > 0 && this.XComboBoxUnitList.Count == this.ListDo.Length)
        //    {
        //        for (int i = 0; i < this.XComboBoxUnitList.Count; i++)
        //        {
        //            if (this.XComboBoxUnitList[i] == render && this.ListDo[i] is OrTplNItmDO)
        //            {
        //                (this.ListDo[i] as OrTplNItmDO).Id_unit_med = render.ValueCode;
        //                break;
        //            }
        //        }
        //    }
        //}

        #endregion

        protected void RecLocat()
        {
            int x = this.Location.X + 4;
            int y = this.Location.Y;
            int boundRight;
            int boundBottom;
            int boundWidth;
            if (isRadio)
            {
                this.radio.Location = new Point(x, y);
                boundRight = this.radio.Bound.Right;
                boundBottom = this.radio.Bound.Bottom;
                boundWidth = this.radio.Bound.Width;

            }
            else
            {
                this.check.Location = new Point(x, y);
                boundRight = this.check.Bound.Right;
                boundBottom = this.check.Bound.Bottom;
                boundWidth = this.check.Bound.Width;

            }
            if (this.hasUnit && freUnitRender != null)
            {
                freUnitRender.Location = new Point(this.Bound.Right - freUnitRender.Size.Width - 10, this.Bound.Top);
            }

            int startY = y;
            UserRender Tmprender = null;
            foreach (UserRender render in this.RenderList)
            {
                if (render is Brieflabel)
                {
                    render.Location = new Point(boundRight, startY);
                    startY = render.Bound.Bottom;
                    Tmprender = render;
                }
                if (Tmprender is Brieflabel && render is XComboBox)
                {
                    if(this.IsParent && !this.IsEnabled && this.disableImage != null)
                    {
                        render.Location = new Point(Tmprender.Bound.Right + boundWidth + 8 + this.disableImage.Width , Tmprender.Bound.Top);
                    }
                    else
                    {
                        render.Location = new Point(Tmprender.Bound.Right + boundWidth + 4, Tmprender.Bound.Top);
                    }
                }
                if (Tmprender is Brieflabel && render is XUnitTextBoxMul)
                {
                    if(this.IsParent && !this.IsEnabled && this.disableImage != null)
                    {
                        render.Location = new Point(Tmprender.Bound.Right + 4 + this.disableImage.Width, Tmprender.Bound.Top);
                    }
                    else
                    {
                       render.Location = new Point(Tmprender.Bound.Right, Tmprender.Bound.Top);
                    }
                }
                if (Tmprender is Brieflabel && render is XOrderUnitFreqGroup)
                {
                    render.Location = new Point(Tmprender.Bound.Left, Tmprender.Bound.Bottom + 6);
                    startY = render.Bound.Bottom;
                }
                if (render is OrderRender)
                {
                    render.Location = new Point(boundRight, startY + 6);
                    startY = render.Bound.Bottom;
                }
            }

            //如果是单独使用并且有下边的子note
            if (this.noteList != null && this.noteList.Count > 0)
            {
                Brieflabel pre = null;
                foreach (Brieflabel label in this.noteList)
                {
                    if (pre == null)
                    {
                        label.Location = new Point(boundRight + 18, startY);
                    }
                    else
                    {
                        label.Location = new Point(boundRight + 18, startY);
                    }
                    pre = label;
                    startY = pre.Bound.Bottom;
                }
            }
            this.Size = new Size(this.Size.Width, startY - this.Location.Y);
        }

        public override void Render(System.Drawing.Graphics g)
        {
            //g.FillRectangle(new SolidBrush(Color.Red), this.lable.Bound);
            //if (isRadio)
            //{
            //    g.FillRectangle(new SolidBrush(Color.Green), this.radio.Bound);
            //}
            //else
            //{
            //    g.FillRectangle(new SolidBrush(Color.Green), this.check.Bound);
            //}
            //g.DrawRectangle(new Pen(Color.Green), this.Bound);
            //g.DrawRectangle(new Pen(Color.Green), this.lablelist[0].Bound);
            //g.DrawLine(new Pen(Color.FromArgb(202, 242, 252)), new Point(check.Bound.Left, this.Bound.Bottom - 5), new Point(this.Bound.Right-20, this.Bound.Bottom - 5));
            //g.FillRectangle(new SolidBrush(Color.Red), this.Bound);
            if (this.IsParent && !this.IsEnabled && this.disableImage != null && this.lable != null)
            {
                disableImageRect = new Rectangle(new Point(this.lable.Bound.Right + 4, this.Bound.Top + (this.lable.Bound.Height - this.disableImage.Height) / 2), this.disableImage.Size);
                g.DrawImage(this.disableImage, disableImageRect);
            }
            base.Render(g);
        }

        protected override void OnMouseDown(object sender, MouseEventArgs e)
        {
            //必选模式，如果选中子项，则父和其他必选子项也选中，且必选项不可取消 
            //一般模式，只有点击check和后边的文字框能选中当前项，选中子项相应父项也选中，选中父所有的子都选中
            if (((isRadio && this.radio.Bound.Contains(e.Location)) || (!isRadio && this.check.Bound.Contains(e.Location))) || this.lable.Bound.Contains(e.Location))
            {
                #region 如果是子项，需要考虑各种情况
                if (!this.IsParent)
                {
                    //不可编辑时，只能有父决定是否选中取消
                    if (!this.EditFlag)
                    {
                        if (Check)
                        {
                            Check = true;
                        }
                        else
                        {
                            Check = (!Check);
                        }
                    }
                    //可编辑时，需要自己控制自己的选中状态
                    else
                    {
                        Check = (!Check);
                    }
                    //当子项选中时，父也应该选中
                    if (this.ParentOrderRender != null)
                    {
                        if (Check)
                        {
                            this.ParentOrderRender.Check = true;
                            //当同级子项有不可编辑的项，则该子项选中时其余不可编辑子项应一起被选中
                            if (this.ParentOrderRender.OrderRenderList != null && this.ParentOrderRender.OrderRenderList.Count > 0)
                            {
                                foreach (OrderRender render in this.ParentOrderRender.OrderRenderList)
                                {
                                    if (!render.EditFlag)
                                    {
                                        render.Check = true;
                                    }
                                }
                            }
                        }
                        else
                        {
                            //如果子项全部取消选中，则父也应该取消选中
                            if (this.ParentOrderRender.OrderRenderList != null && this.ParentOrderRender.OrderRenderList.Count > 0)
                            {
                                bool flag = false;
                                foreach (OrderRender render in this.ParentOrderRender.OrderRenderList)
                                {
                                    if (render.Check)
                                    {
                                        flag = true;
                                    }
                                }
                                if (!flag)
                                {
                                    this.ParentOrderRender.Check = false;
                                }
                            }
                        }
                    }
                }
                #endregion

                #region  如果是父，则若选中则子项全部选中，反之子项全部取消
                else
                {
                    Check = (!Check);
                    SetRenderCheck(Check);
                }
                #endregion
            }
            else
            {
                base.OnMouseDown(sender, e);
            }

            //if (!Check)
            //{
            //    if (((isRadio && !this.radio.Bound.Contains(e.Location)) || (!isRadio && !this.check.Bound.Contains(e.Location))) && (!this.lable.Bound.Contains(e.Location)))
            //    {
            //        this.Check = true;
            //    }
            //}
        }

        //设置子项与父一致
        public void SetRenderCheck(bool Check)
        {
            if (this.OrderRenderList != null && this.OrderRenderList.Count > 0)
            {
                foreach (OrderRender render in this.OrderRenderList)
                {
                    render.Check = Check;
                }
            }
        }

        protected override void OnMouseMove(object sender, MouseEventArgs e)
        {
            if (!IsOpenTooltip)
            {
                if ((disableImageRect != null && disableImageRect.Contains(e.Location)) && !string.IsNullOrEmpty(this.DisableTipText))
                {
                    tooltip.CanShow = true;
                    tooltip.Show(this.DisableTipText, Control.MousePosition);
                }
            }

            this.Invalidate();
            base.OnMouseMove(sender, e);
        }

        protected override void OnMouseLeave(object sender, EventArgs e)
        {
            if (IsOpenTooltip)
            {
                tooltip.CanShow = false;
                tooltip.Hide();
            }
            this.Invalidate();
            base.OnMouseLeave(sender, e);
        }
    }
}
