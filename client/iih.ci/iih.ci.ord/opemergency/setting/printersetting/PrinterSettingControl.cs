
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.cli.sdk.controls;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render;
using System.Drawing;
using xap.cli.sdk.common;
using System.Windows.Forms;
using iih.ci.ord.ciprn.i;
using xap.mw.serviceframework;
using xap.rui.control.extentions;
using xap.mw.coreitf.d;

namespace iih.ci.ord.opemergency.setting.printersetting
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.setting.printersetting    </para>    
    /// <para>类 名 称 :  PrinterSettingControl					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/9/13 15:10:51             </para>
    /// <para>更新时间 :  2017/9/13 15:10:51             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public partial class PrinterSettingControl : XAPScrollBarPanel
    {
        public delegate string DelegateGetReportPrinter();
        public DelegateGetReportPrinter fDelegateGetReportPrinter;

        private XAPScrollBarPanel xScrollPanel_PrtParams;

        private XLabel label8;
        private XComboBox comboPrinters;

        public string printerName = "";

        public PrinterSettingControl(DelegateGetReportPrinter f)
        {
            fDelegateGetReportPrinter = f;
            this.Load += PrinterSettingControl_Load;
        }

        private void PrinterSettingControl_Load(object sender, EventArgs e)
        {
            loadRender();
            SetPrinterCtrls();
        }

        private void loadRender()
        {
            this.xScrollPanel_PrtParams = new XAPScrollBarPanel();
            this.label8 = new XLabel();
            this.comboPrinters = new XComboBox(this.xScrollPanel_PrtParams);

            // lable8
            this.label8.Name = "label_prtname";
            this.label8.Location = new Point(20, 36);
            this.label8.ForeColor = Color.FromArgb(78, 78, 78);
            this.label8.Size = new Size(105, RelativeUIParam.RELATIVECELLSIZE.Height);
            this.label8.Alignment = StringAlignment.Far;
            this.label8.ValueText = "选择小票打印机";
            // comboPrinter
            this.comboPrinters.Location = new Point(label8.Bound.Right + 8, this.label8.Bound.Y);
            this.comboPrinters.Name = "comboPrinter";
            this.comboPrinters.Size = new Size(256, RelativeUIParam.RELATIVECELLSIZE.Height);
            this.comboPrinters.TabIndex = 11;
            this.comboPrinters.ValueTextChanged += new EventHandler(comboPrinters_ValueTextChanged);

            // 
            // xScrollPanel_PrtParams
            // 
            this.xScrollPanel_PrtParams.AutoScroll = true;
            this.xScrollPanel_PrtParams.Dock = System.Windows.Forms.DockStyle.Fill;
            this.xScrollPanel_PrtParams.EnabledHorizontal = false;
            this.xScrollPanel_PrtParams.EnabledVertical = false;
            //this.xScrollPanel_PrtParams.AddRender(this.label2); //打印份数
            //this.xScrollPanel_PrtParams.AddRender(this.textPrintCopies);
            this.xScrollPanel_PrtParams.AddRender(this.label8); //选择打印机
            this.xScrollPanel_PrtParams.AddRender(this.comboPrinters);
            this.xScrollPanel_PrtParams.Font = new Font("微软雅黑", 12F, FontStyle.Regular, GraphicsUnit.Pixel);
            this.xScrollPanel_PrtParams.HPreferStep = 1D;
            this.xScrollPanel_PrtParams.IsContainerRender = true;
            this.xScrollPanel_PrtParams.Name = "xScrollPanel_PrtParams";
            this.xScrollPanel_PrtParams.ScrollWidth = 10;
            this.xScrollPanel_PrtParams.SingleBorderStyle = false;
            this.xScrollPanel_PrtParams.TabStop = false;
            this.xScrollPanel_PrtParams.Text = "xScrollPanel_PrtParams";
            this.xScrollPanel_PrtParams.VPreferStep = 1D;

            this.Controls.Add(this.xScrollPanel_PrtParams);

            this.Font = new Font("Microsoft Sans Serif", 10.8F, FontStyle.Regular, GraphicsUnit.Point, ((byte)(0)));
            this.Margin = new System.Windows.Forms.Padding(2, 4, 2, 4);
            this.Name = "XForm_PrtConfig";
        }

        private void comboPrinters_ValueTextChanged(object sender, EventArgs e)
        {
            printerName = this.comboPrinters.ShowText;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xPanel_CmdBtn_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.DrawLine(new Pen(Color.FromArgb(235, 235, 235)), new Point(0, 0), new Point(this.Width, 0));
        }

        /// <summary>
        /// 打印机相关参数控件
        /// </summary>
        public void SetPrinterCtrls()
        {
            printerName = fDelegateGetReportPrinter();
            xap.dp.libcomm.print.FindPrinter findPrinter = new xap.dp.libcomm.print.FindPrinter();
            //IEnumerator<string> enumerator = findPrinter.getPrintersIter();
            Dictionary<object, string> dic = new Dictionary<object, string>();
            string[] printers = findPrinter.getPrintersArr();
            int i = 0;
            if (printers != null)
            {
                foreach (string printer in printers)
                {
                    dic.Add(i.ToString(), printer);
                    i++;
                }
            }
            //int i = 0;
            //int index = -1;
            //while (enumerator.MoveNext())
            //{
            //    if (printerName == enumerator.Current)
            //        index = i;
            //    dic.Add(i.ToString(), enumerator.Current);
            //    i++;
            //}

            this.comboPrinters.DataSource = dic;
            this.comboPrinters.ShowText = printerName;
        }


        
    }
}
