using iih.en.pv.dto.d;
using System;
using System.Drawing;
using System.Windows.Forms;
using xap.cli.sdk.controls;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.rui.control.basecontrol;

namespace iih.ci.ord.opemergency.orddi
{
    /// <summary>
    /// <para>描    述 :  门诊诊断管理                    			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ordiag    </para>    
    /// <para>类 名 称 :  OrderDiInfoDialog					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  10/12/2016 3:50:28 PM             </para>
    /// <para>更新时间 :  10/12/2016 3:50:28 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrderDiInfoDialog : XSingleDialog
    {
        private XLayoutPanel rootPanel = new XLayoutPanel();

        OrderDiInfoView mOrderDiInfoView;

        //下边按钮区,保存按钮 和 取消按钮
        private XButton addButton;
        private XButton deleteButton;
        private XButton saveButton;
        private XButton cancelButton;

        // 
        XapBaseControl ownerControl;
        Ent4BannerDTO ent4BannerDTO;
        #region 构造方法
        public OrderDiInfoDialog(XapBaseControl owner, Ent4BannerDTO e)
        {
            this.ownerControl = owner;
            this.ent4BannerDTO = e;

            this.Formsize = FormSize.Large;
            this.Size = new Size(800, 400);
            this.Panel.Size = this.Size;
            this.Load += OrderDiInfoDialog_Load;
            this.Text = "诊断管理";
            
        }

        private void loadBottomButtons()
        {
            addButton = new XButton();
            addButton.Size = new Size(80, 24);
            addButton.Text = "新增";
            addButton.MouseClick += addButton_MouseClick;

            deleteButton = new XButton();
            deleteButton.Size = new Size(80, 24);
            deleteButton.Text = "删除";
            deleteButton.MouseClick += deleteButton_MouseClick;

            saveButton = new XButton();
            saveButton.Size = new Size(80, 24);
            saveButton.Text = "保存";
            saveButton.MouseClick += saveButton_MouseClick;

            cancelButton = new XButton();
            cancelButton.Size = new Size(80, 24);
            cancelButton.Text = "取消";
            cancelButton.MouseClick += cancelButton_MouseClick;

            this.AddRender_Btn(addButton, deleteButton, saveButton, cancelButton);

        }

        

        void OrderDiInfoDialog_Load(object sender, EventArgs e)
        {
            rootPanel.Dock = DockStyle.None;
            rootPanel.Location = this.Panel.Location;
            rootPanel.Size = this.Panel.Size;
            this.Panel = rootPanel;

            mOrderDiInfoView = new OrderDiInfoView(this.ownerControl, this.ent4BannerDTO);

            rootPanel.AddControl(mOrderDiInfoView, ControlPosition.Center);

            loadBottomButtons();
        }
        #endregion


        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            this.Close();
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {

        }

        void deleteButton_MouseClick(object sender, MouseEventArgs e)
        {

        }

        void addButton_MouseClick(object sender, MouseEventArgs e)
        {
            mOrderDiInfoView.AddRow();
        }

    }
}
