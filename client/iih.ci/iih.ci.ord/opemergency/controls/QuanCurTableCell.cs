using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render.Items;
using iih.ci.ord.ciorder.utils;
using xap.mw.core.data;
using System.Collections;
using iih.bd.bc.udi;

namespace iih.ci.ord.opemergency.controls
{
    class QuanCurTableCell : BaseValueUnitTableCell
    {
        private LogicEx logicEx = LogicEx.GetInstance();
        protected override void initCellControlFormat(XBaseUserRender ctrl)
        {
            base.initCellControlFormat(ctrl);
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            xComboBoxUnit.MaxInputNumber = 99999999.9999; // 最大长度8位整型
        }
        /// <summary>
        /// 总量单位
        /// </summary>
        /// <param name="rowDataSource"></param>
        /// <param name="ctrl"></param>
        protected override void editorWillAppear(Object rowDataSource, XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            EmsOrDrug drug = rowDataSource as EmsOrDrug;
            if (null != drug)
            {
                

                //if (xComboBoxUnit.ValueUnit.Length > 0)
                //{
                    Dictionary<object, string> items = new Dictionary<object, string>();
                    //items.Add(drug.Id_unit_sale, drug.Name_unit_sale);
                    FMap fmap = drug.Relativefieldmap;
                    if (fmap == null)
                    {
                        if (drug.Id_unit_sale != null)
                        {
                            items.Add(drug.Id_unit_sale, drug.Name_unit_sale);
                        }
                        else {
                            items.Add("", drug.Name_unit_sale);
                        }
                    }
                    else {
                        string idstr = (string)fmap[CiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC];
                        string namestr = (string)fmap[CiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME];
                        string factorstr = (string)fmap["factor"];
                        if (!string.IsNullOrEmpty(idstr) && !string.IsNullOrEmpty(namestr) && !string.IsNullOrEmpty(factorstr))
                        {
                            string[] ids = idstr.Split(new char[] { ',' });
                            string[] names = namestr.Split(new char[] { ',' });
                            string[] factors = factorstr.Split(',');
                            for (int i = 0; i < ids.Length; i++)
                            {
                                if (!items.ContainsKey(ids[i] + "," + factors[i]))
                                {
                                    items.Add(ids[i]+","+factors[i], names[i]);    
                                }
                            }
                        }
                    }
                    
                    xComboBoxUnit.DataSource = items;
                //}
                xComboBoxUnit.ValueText = (drug.Quan_cur == null ? "0" : drug.Quan_cur.ToString());
                xComboBoxUnit.ValueUnit = (drug.Name_unit_sale == null ? "" : drug.Name_unit_sale);
            }
        }

        protected override void editorWillDisappear(object rowDataSource, XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            EmsOrDrug drug = rowDataSource as EmsOrDrug;
            if (null != drug)
            {
                drug.Quan_cur = ((xComboBoxUnit.ValueText == null || xComboBoxUnit.ValueText.Length == 0) ? 0 : Double.Parse(xComboBoxUnit.ValueText));
                drug.Name_unit_sale = xComboBoxUnit.ValueUnit;
                string selectKey = xComboBoxUnit.SelectKey.ToString();
                string id_unit_sale = selectKey.Split(',')[0];
                string factor = "";
                if (selectKey.IndexOf(",") != -1) {
                   factor = selectKey.Split(',')[1];    
                }
                drug.Id_unit_sale = id_unit_sale;
                drug.Factor_cb = string.IsNullOrEmpty(factor) ? 0 : Convert.ToDouble(factor);
            }
        }

        protected override void cellWillAppear(object rowDataSource, XCellRender cell)
        {
            EmsOrDrug drug = rowDataSource as EmsOrDrug;
            if (null != drug && drug.Id_srv != null && drug.Id_srv.Length != 0)
            {
                System.Diagnostics.Debug.WriteLine("总量："+drug.Quan_cur.ToString() + "/" + drug.Name_unit_sale);
                cell.SetValue(drug.Quan_cur.ToString() + drug.Name_unit_sale);
            }
        }
    }
}
