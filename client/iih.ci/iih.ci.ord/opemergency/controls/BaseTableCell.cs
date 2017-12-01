using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.controls.DataView.Repository;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.opemergency.controls
{
    public class BaseTableCell : XRepositoryItemCtr
    {
         #region 公共属性

        public override bool Visible
        {
            get
            {
                return base.Visible;
            }
            set
            {
                if (base.Visible == value)
                {
                    return;
                }

                if (!value)
                {
                    if (this.Row != null && this.Column != null && this.Row.ColumnCellDict != null)
                    {
                        this.editorWillDisappear(this.Row.RowDataSource, this.customCtrl);
                            
                        this.cellWillAppear(this.Row.RowDataSource, this.Row.ColumnCellDict[this.Column.FieldName]);
                    }
                }
                else
                {

                    if (this.Row != null &&
                        this.Column != null &&
                        this.Row.ColumnCellDict != null &&
                        this.Row.RowDataSource != null)
                    {

                        this.editorWillAppear(this.Row.RowDataSource, this.customCtrl);
                    }
                }
                base.Visible = value;
                if (null != customCtrl)
                {
                    this.customCtrl.Visible = value;
                }
                
            }
        }

        public override XCellRender LinkedCellRender
        {
            get
            {
                return base.LinkedCellRender;
            }
            set
            {
                base.LinkedCellRender = value;
                if (base.LinkedCellRender != null)
                {
                    this.Row = base.LinkedCellRender.Row;
                    this.Column = base.LinkedCellRender.Column;
                    if (this.customCtrl != null)
                    {
                        //设置编辑器的位置
                        base.Location = base.LinkedCellRender.Location;
                        this.customCtrl.Location = base.LinkedCellRender.Location;
                        //设置编辑器的大小
                        base.Size = base.LinkedCellRender.Size;
                        this.customCtrl.Size = base.LinkedCellRender.Size;

                    }
                }
            }
        }

        #endregion


        #region 私有变量

        private XBaseUserRender customCtrl;

        #endregion

        public BaseTableCell()
        {

            this.customCtrl = this.createCustomCtrl();
            initCellControlFormat(customCtrl);
            this.AddRender(customCtrl);
        }

        #region 接口
        public XBaseUserRender GetEditControl()
        {
            return this.customCtrl;
        }
        #endregion

        #region 可重写方法
        protected virtual XBaseUserRender createCustomCtrl()
        {
            
            return null;
        }
        protected virtual void initCellControlFormat(XBaseUserRender ctrl)
        {

        }
        protected virtual void editorWillAppear(Object rowDataSource, XBaseUserRender ctrl)
        {

        }

        protected virtual void editorWillDisappear(Object rowDataSource, XBaseUserRender ctrl)
        {

        }

        protected virtual void cellWillAppear(Object rowDataSource, XCellRender cell)
        {

        }


        #endregion
    }
}
