
using iih.ci.ord.ciordems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.opemergency.controls
{
    /// <summary>
    /// <para>描    述 :  医疗费用清单数量单位控件                			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.controls    </para>    
    /// <para>类 名 称 :  QuanMedUnitFeeBillTableCell					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  12/23/2016 9:00:50 AM             </para>
    /// <para>更新时间 :  12/23/2016 9:00:50 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class QuanMedUnitFeeBillTableCell : BaseValueUnitTableCell
    {
        protected override void initCellControlFormat(XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            //xComboBoxUnit.ComboboxWidthPercent = 0.38;
            xComboBoxUnit.TextAlignment = System.Windows.Forms.HorizontalAlignment.Right;
            xComboBoxUnit.UnitIsEnable = false; // 禁用单位编辑
            xComboBoxUnit.MinInputNumber = 0.001;
        }

        protected override void editorWillAppear(object rowDataSource, XBaseUserRender ctrl)
        {
            CiOrdFeeSrvDTO drug = rowDataSource as CiOrdFeeSrvDTO;
            if (null != drug) {
                XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
                xComboBoxUnit.ValueText = (drug.Quan_med == null ? "0" : drug.Quan_med.ToString());
                xComboBoxUnit.ValueUnit = (drug.Name_unit_med == null ? "" : drug.Name_unit_med);
                if (xComboBoxUnit.ValueUnit.Length > 0) {
                    Dictionary<object, string> items = new Dictionary<object, string>();
                    items.Add(drug.Id_unit_med, drug.Name_unit_med);
                    if (drug.Id_unit_base != null && !drug.Id_unit_base.Equals(drug.Id_unit_med)) {
                        items.Add(drug.Id_unit_base, drug.Name_unit_base);
                    }

                    xComboBoxUnit.DataSource = items;
                }
            }
        }

        protected override void editorWillDisappear(object rowDataSource, XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            CiOrdFeeSrvDTO drug = rowDataSource as CiOrdFeeSrvDTO;
            if (null != drug) {
                double quan_med = ((xComboBoxUnit.ValueText == null || xComboBoxUnit.ValueText.Length == 0) ? 0 : Double.Parse(xComboBoxUnit.ValueText));
                drug.Quan_med = quan_med == 0 ? 0.001 : quan_med;
                drug.Name_unit_med = xComboBoxUnit.ValueUnit;
            }
        }

        protected override void cellWillAppear(object rowDataSource, XCellRender cell)
        {

            CiOrdFeeSrvDTO drug = rowDataSource as CiOrdFeeSrvDTO;
            if (null != drug && drug.Id_srv != null && drug.Id_srv.Length != 0) {
                cell.SetValue(drug.Quan_med.ToString() + drug.Name_unit_med);
            }
        }
    }
}
