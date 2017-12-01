using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using System.Drawing;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.render
{
    /// <summary>
    /// 频次单位双下拉框控件（频次下拉单位文本框组合控件）
    /// </summary>
    public class XOrderUnitFreqGroup : XRenderGroup
    {
        private bool isDoubleDrop;
        private XComboBoxUnit unitReUnder;
        private XUnitTextBoxMul unitTextBox;
        private XComboBox freqncRender;

        /// <summary>
        /// 单位文本框值改变事件
        /// </summary>
        public event EventHandler UnitTextBoxValueTextChanged;

        /// <summary>
        /// 下拉文本框下拉选择改变事件
        /// </summary>
        public event EventHandler UnitReUnderSelectValueChanged;

        /// <summary>
        /// 下拉文本框值改变事件
        /// </summary>
        public event EventHandler UnitReUnderValueTextChanged;

        /// <summary>
        /// 频次下拉框值改变事件
        /// </summary>
        public event EventHandler FreqncRenderValueTextChanged;

        /// <summary>
        /// 数量文本
        /// </summary>
        public new string ValueText 
        {
             get 
            { 
                if (unitReUnder != null)
                {
                    return unitReUnder.ValueText;
                }
                else
                {
                    return unitTextBox.ValueText ;
                }

            }
            set 
            {
                if(unitReUnder != null)
                {
                   unitReUnder.ValueText = value;
                }
                else
                {
                    unitTextBox.ValueText = value;
                }
            }
        }

        /// <summary>
        /// 单位文本
        /// </summary>
        public string UnitValueText 
        {
            get 
            { 
                if (unitReUnder != null)
                {
                    return unitReUnder.ValueUnit;
                }
                else
                {
                    return unitTextBox.UnitText ;
                }
            }
            set 
            {
                if(unitReUnder != null)
                {
                   unitReUnder.ValueUnit = value;
                }
                else
                {
                    unitTextBox.UnitText = value;
                }
            }
        }

        /// <summary>
        /// 单位下拉框数据源
        /// </summary>
        public Dictionary<object, string> UnitDataSource 
        {
            set
            {
                if (unitReUnder !=null )
                {
                    unitReUnder.DataSource = value;
                }
            }
        }

        /// <summary>
        /// 频次文本
        /// </summary>
        public string FreqncValueText
        {
            get
            {
                return freqncRender.ValueText;
            }
            set
            {
                freqncRender.ValueText = value;
            }
        }

        /// <summary>
        /// 单位下拉框数据源
        /// </summary>
        public Dictionary<object, string> FreqncDataSource
        {
            set
            {
                freqncRender.DataSource = value;
            }
        }

        /// <summary>
        /// 频次单位双下拉框控件（频次下拉单位文本框组合控件）
        /// </summary>
        /// <param name="parent"></param>
        /// <param name="isDoubleDrop">是否是双下拉形式</param>
        public XOrderUnitFreqGroup(Control parent,bool isDoubleDrop)
        {
            this.Size = new System.Drawing.Size(205,24);
            this.isDoubleDrop = isDoubleDrop;
            if (isDoubleDrop)
            {
                unitReUnder = new XComboBoxUnit(parent);
                unitReUnder.Size = new System.Drawing.Size(102,24);
                unitReUnder.Location = new Point(this.Bound.X ,this.Bound.Y);
                unitReUnder.RightTophorn = false;
                unitReUnder.RightBottmhorn = false;
                unitReUnder.SelectValueChanged += new EventHandler(UnitReUnder_SelectValueChanged);
                unitReUnder.ValueTextChanged += new EventHandler(UnitReUnder_ValueTextChanged);
                this.AddRender(unitReUnder);

                freqncRender = new XComboBox(parent);
                freqncRender.Size = new Size(102,24);
                freqncRender.Location = new Point(unitReUnder.Bound.Right - 1, unitReUnder.Bound.Top);
                freqncRender.ValueTextChanged += new EventHandler(FreqncRender_ValueTextChanged);
                freqncRender.LeftTophorn = false;
                freqncRender.LeftBottmhorn = false;
                this.AddRender(freqncRender);

            }
            else
            {
                unitTextBox = new XUnitTextBoxMul();
                unitTextBox.Size = new System.Drawing.Size(100, 24);
                unitTextBox.IsNumber = true;
                unitTextBox.NullFlag = false;
                unitTextBox.MinValue = 0;
                unitTextBox.MaxLength = 4;
                unitTextBox.Location = new Point(this.Bound.X, this.Bound.Y);
                unitTextBox.ValueTextChanged += new EventHandler(UnitTextBox_ValueTextChanged);
                this.AddRender(unitTextBox);
            
                freqncRender = new XComboBox(parent);
                freqncRender.Size = new Size(100,24);
                freqncRender.ValueTextChanged += new EventHandler(FreqncRender_ValueTextChanged);
                freqncRender.Location = new Point(unitTextBox.Bound.Right + 4, unitTextBox.Bound.Top);
                this.AddRender(freqncRender);
            }
        }

        private void UnitTextBox_ValueTextChanged(object sender, EventArgs e)
        {
            if (UnitTextBoxValueTextChanged!=null)
           {
               UnitTextBoxValueTextChanged(sender, e);
           }
        }

        private void UnitReUnder_SelectValueChanged(object sender, EventArgs e)
        {
            if (UnitReUnderSelectValueChanged != null)
            {
                UnitReUnderSelectValueChanged(sender, e);
            }
        }

        private void UnitReUnder_ValueTextChanged(object sender, EventArgs e)
        {
            if (UnitReUnderValueTextChanged != null)
            {
                UnitReUnderValueTextChanged(sender, e);
            }
        }

        private void FreqncRender_ValueTextChanged(object sender, EventArgs e)
        {
            if (FreqncRenderValueTextChanged != null)
            {
                FreqncRenderValueTextChanged(sender, e);
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
                if(this.isDoubleDrop)
                {
                    if(unitReUnder != null)
                    {
                        unitReUnder.Location = new Point(this.Bound.X, this.Bound.Y);
                        freqncRender.Location = new Point(unitReUnder.Bound.Right -1, unitReUnder.Bound.Top);
                    }
                }
                else
                {
                    if (unitTextBox != null)
                    {
                        unitTextBox.Location = new Point(this.Bound.X, this.Bound.Y);
                        freqncRender.Location = new Point(unitTextBox.Bound.Right + 4, unitTextBox.Bound.Top);
                    }
                }
                this.Invalidate();
            }
        }
    }
}
