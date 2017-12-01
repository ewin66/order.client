
using iih.bd.bc.udi;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render.Items;
using xap.mw.core.data;

namespace iih.ci.ord.opemergency.controls
{
    /// <summary>
    /// <para>描    述 :  服务总量表格控件                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.controls    </para>    
    /// <para>类 名 称 :  QuanSaleUnitFeeBillTableCell					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  1/10/2017 7:50:29 PM             </para>
    /// <para>更新时间 :  1/10/2017 7:50:29 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class QuanSaleUnitFeeBillTableCell : BaseValueUnitTableCell
    {
        private LogicEx logicEx = LogicEx.GetInstance();
        /// <summary>
        /// 总量单位
        /// </summary>
        /// <param name="rowDataSource"></param>
        /// <param name="ctrl"></param>
        protected override void editorWillAppear(Object rowDataSource, XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            CiOrdFeeSrvDTO drug = rowDataSource as CiOrdFeeSrvDTO;
            if (null != drug) {
                Dictionary<object, string> items = new Dictionary<object, string>();

                FMap fmap = null;// drug.Relativefieldmap;
                if (fmap == null) {
                    if (!string.IsNullOrEmpty(drug.Id_unit_sale))
                    items.Add(drug.Id_unit_sale, drug.Name_unit_sale);
                }
                else {
                    string idstr = (string)fmap[CiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC];
                    string namestr = (string)fmap[CiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME];
                    if (!string.IsNullOrEmpty(idstr)) {
                        string[] ids = idstr.Split(new char[] { ',' });
                        string[] names = namestr.Split(new char[] { ',' });
                        for (int i = 0; i < ids.Length; i++) {
                            items.Add(ids[i], names[i]);
                        }
                    }
                }

                xComboBoxUnit.DataSource = items;
                xComboBoxUnit.ValueText = (drug.Quan_total_medu == null ? "0" : drug.Quan_total_medu.ToString());
                xComboBoxUnit.ValueUnit = (drug.Name_unit_sale == null ? "" : drug.Name_unit_sale);
            }
        }

        protected override void editorWillDisappear(object rowDataSource, XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            CiOrdFeeSrvDTO drug = rowDataSource as CiOrdFeeSrvDTO;
            if (null != drug) {
                drug.Quan_total_medu = ((xComboBoxUnit.ValueText == null || xComboBoxUnit.ValueText.Length == 0) ? 0 : Double.Parse(xComboBoxUnit.ValueText));
                drug.Name_unit_sale = xComboBoxUnit.ValueUnit;
                drug.Id_unit_sale = xComboBoxUnit.SelectKey.ToString();
            }
        }

        protected override void cellWillAppear(object rowDataSource, XCellRender cell)
        {
            CiOrdFeeSrvDTO drug = rowDataSource as CiOrdFeeSrvDTO;
            if (null != drug && drug.Id_srv != null && drug.Id_srv.Length != 0) {
                System.Diagnostics.Debug.WriteLine("总量：" + drug.Quan_total_medu.ToString() + "/" + drug.Name_unit_sale);
                cell.SetValue(drug.Quan_total_medu.ToString() + drug.Name_unit_sale);
            }
        }
    }
}
