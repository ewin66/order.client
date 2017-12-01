using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.appfw;
using xap.rui.control.forms.control;
using xap.cli.sdk.controls.DataView.Base;

namespace iih.ci.ord.ciorder.utils {
    /// <summary>
    /// 已经选择的医嘱的集合的容器类
    /// </summary>
   public class OrdSelectedContainer {
        /// <summary>
        /// 承载被选择的医嘱ID的集合对象
        /// </summary>
        private List<string> selectedIds = new List<string>();

        /// <summary>
        /// 添加
        /// </summary>
        /// <param name="id"></param>
        public void add(string id) {
            if (!selectedIds.Contains(id)) {
                selectedIds.Add(id);
            }
        }
        /// <summary>
        /// 移除
        /// </summary>
        /// <param name="id"></param>
        public void remove(string id) {
            if (selectedIds.Contains(id)) {
                selectedIds.Remove(id);
            }
        }
        /// <summary>
        /// 返回id集合
        /// </summary>
        /// <returns></returns>
        public List<string> get() {
            return this.selectedIds;
        }

        /// <summary>
        /// 基于表格控件前面复选框的情况将被选择的医嘱的ID值搜集到本容器之中
        /// </summary>
        /// <param name="gv">医嘱表格控件</param>
        /// <param name="keyName">主键的名字</param>
        /// <param name="flag">是否清除过去的</param>
        public void getSelectedRow(XapFormGridControl gv, string keyName, bool flag = true) {
            if (gv == null) {
                return;
            }

            RowCollectionBase rowCollection = gv.DataTable.Rows;
            if (flag) {
                selectedIds.Clear();
            }

            int num = rowCollection.Count;
            for (int i = 0; i < num; i++) {
                string keyId = gv.DataTable.Rows[i].RowDataSource.GetPropValue(keyName) as string;
                if (!selectedIds.Contains(keyId) && gv.DataTable.Rows[i].Selected) {
                    selectedIds.Add(keyId);
                }
            }
        }
        /// <summary>
        /// 控制表格的选中状态
        /// </summary>
        /// <param name="gv"></param>
        /// <param name="keyName"></param>
        public void setSelected(XapFormGridControl gv, string keyName) {
            if (gv == null || this.selectedIds.Count == 0) {
                return;
            }

            RowCollectionBase rowCollection = gv.DataTable.Rows;
            int num = rowCollection.Count;
            for (int i = 0; i < num; i++) {
                string keyId = gv.DataTable.Rows[i].RowDataSource.GetPropValue(keyName) as string;
                if (this.selectedIds.Contains(keyId)) {
                    gv.DataTable.Rows[i].Selected = true;
                }
            }
        }
        public void clear() {
            selectedIds.Clear();
        }
    }
}
