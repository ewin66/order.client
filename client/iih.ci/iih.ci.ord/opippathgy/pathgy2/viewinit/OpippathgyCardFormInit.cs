using iih.bd.bc.mkr.d;
using xap.rui.control.forms.model;
using xap.rui.control.inputmethod;
using xap.rui.control.refcontrol.events;
using xap.rui.engine2;
using xap.rui.uipattern2.basemodel.card;
using xap.rui.uipattern2.viewevt;

namespace iih.ci.ord.opippathgy.pathgy2.viewinit
{
    class OpippathgyCardFormInit : XapFormInitialize
    {
        public OpippathgyCardFormInit(IFunclet root) : base(null, root) {

        }
        public override void InitChildCtrlEvtHandler()
        {
            // 设置参照过滤条件
            this.xapFormWrap.AddEvt_RefFilter(this.OnRefFilter);

            // 属性值修改时的处理
            this.xapFormWrap.ModifyEvt_DataChanged(this.OnDataChanged, true);
        }
        
        #region 事件响应处理函数

        private void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            //string ref_fldname = e.BindingFieldName;

            //if (ref_fldname == "Parent_name")
            //{
            //    if (!string.IsNullOrWhiteSpace(this.model_place.DataInst.Id_plc))
            //    {
            //        e.WherePart = string.Format("Id_plc !='{0}'", this.model_place.DataInst.Id_plc);
            //    }
            //}
          
        }

        private void OnDataChanged(object sender, DataChangedEventArgs e)
        {
            // 因为使用双向绑定，需要先卸载该事件
            this.xapFormWrap.ModifyEvt_DataChanged(this.OnDataChanged, false);

            object data_obj = e.Data;
            string prop_name = e.PropName;

            if (data_obj is AnatomicOrganDO)
            {
                AnatomicOrganDO organDo = (data_obj as AnatomicOrganDO);

                switch (prop_name)
                {
                    case "Name": // 自动拼接Name_path
                   
                      CreateParentPYAndWBCode( e);
                        break;
                }
            }

            // 重新绑定该事件
            this.xapFormWrap.ModifyEvt_DataChanged(this.OnDataChanged, true);
        }
        /// <summary>
        /// 生成拼音和五笔代码(主)
        /// </summary>
        /// <param name="e"></param>
        private void CreateParentPYAndWBCode(DataChangedEventArgs e)
        {
            AnatomicOrganDO cherbPDo = e.Data as AnatomicOrganDO;
            cherbPDo.Pycode = InputMethods.GetJianPin(e.Input as string);
            cherbPDo.Wbcode = InputMethods.GetWuBi(e.Input as string);
        }
        #endregion
    }
}
