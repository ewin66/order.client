using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.opemergency.controls
{
    /// <summary>
    /// 备血申请量
    /// </summary>
    class QuanBtTableCell : BaseValueUnitTableCell
    {
        protected override void initCellControlFormat(XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            xComboBoxUnit.ComboboxWidthPercent = 0.38;
            xComboBoxUnit.TextAlignment = System.Windows.Forms.HorizontalAlignment.Right;
            xComboBoxUnit.UnitIsEnable = false; // 禁用单位编辑
        }

        protected override void editorWillAppear(object rowDataSource, XBaseUserRender ctrl)
        {
            EmsBtItemDO btitemdo = rowDataSource as EmsBtItemDO;
            if (null != btitemdo)
            {
                XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
                xComboBoxUnit.ValueText = btitemdo.Quan_med==null?"":btitemdo.Quan_med.ToString();
                xComboBoxUnit.ValueUnit = btitemdo.Name_unit_med;
            }
        }

        protected override void editorWillDisappear(object rowDataSource, XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            EmsBtItemDO btitemdo = rowDataSource as EmsBtItemDO;
            if (null != btitemdo)
            {
                btitemdo.Quan_med = ((xComboBoxUnit.ValueText == null || xComboBoxUnit.ValueText.Length == 0) ? 0 : Double.Parse(xComboBoxUnit.ValueText));
                btitemdo.Name_unit_med = xComboBoxUnit.ValueUnit;
            }
        }

        protected override void cellWillAppear(object rowDataSource, XCellRender cell)
        {

            EmsBtItemDO btitemdo = rowDataSource as EmsBtItemDO;
            if (null != btitemdo && btitemdo.Id_srv != null && btitemdo.Id_srv.Length != 0)
            {
                cell.SetValue(btitemdo.Quan_med.ToString() + btitemdo.Name_unit_med);
            }
        }
    }
}
