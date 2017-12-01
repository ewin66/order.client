using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render.Items;
using iih.ci.ord.opemergency.controls;

namespace iih.ci.ord.ciorder.cards.controls
{
    /// <summary>
    /// 库存
    /// </summary>
    class StockTableCell : BaseValueUnitTableCell
    {
        protected override void initCellControlFormat(XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            xComboBoxUnit.ComboboxWidthPercent = 0.38;
            xComboBoxUnit.TextAlignment = System.Windows.Forms.HorizontalAlignment.Right;
            xComboBoxUnit.UnitIsEnable = false; // 禁用单位编辑
        }

        protected override void cellWillAppear(object rowDataSource, XCellRender cell)
        {

            EmsOrDrug drug = rowDataSource as EmsOrDrug;
            if (null != drug && drug.Id_srv != null && drug.Id_srv.Length != 0)
            {
                cell.SetValue(drug.Fact_count.ToString() + drug.Name_unit_sale);
            }
        }
    }
}
