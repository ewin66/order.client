
using System;
using System.Collections.Generic;
using iih.ci.ord.opemergency.assi.entdi.viewmodel;
using xap.cli.sdk.render.labelcontrol;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.opemergency.assi.entdi.view
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.entdi.view    </para>    
    /// <para>类 名 称 :  EntDiDeptAssiView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/4/11 11:38:58             </para>
    /// <para>更新时间 :  2017/4/11 11:38:58             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EntDiDeptAssiView : EntDiAssiView
    {
        public EntDiDeptAssiView()
            : base()
        {
            
        }

        protected override void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.xapFormControl_FormCreated(sender, e);

            urDeptDica.Visible = true;
            urDeptDica.Enabled = true;

            Dictionary<object, string> item = new Dictionary<object, string>();
            item.Add("~", "全部");
            foreach (var caDO in (this.viewModel as EntDiDeptAssiViewModel).DeptDiagCaDOs)
            {
                item.Add(caDO.Id_deptdiagca, caDO.Name);
            }

            XComboBox cmb = urDeptDica.UserRender as XComboBox;
            cmb.DataSource = item;
            cmb.SelectIndex = 0;
            cmb.SelectValueChanged += new EventHandler(cmb_SelectValueChanged);
        }

        private void cmb_SelectValueChanged(object sender, EventArgs e)
        {
            (this.viewModel as EntDiDeptAssiViewModel).Id_dicadep = (String)(sender as XComboBox).SelectedItem;
            this.LoadData();
        }
    }
}
