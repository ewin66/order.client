
using System;
using System.Collections.Generic;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.common.utils.msg;
using xap.rui.control.tree.otree;
using xap.rui.control.tree.options;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.assi.i;

namespace iih.ci.ord.opemergency.assi.ortmplconcise.view
{
    partial class OrTmplTreeView : IViewCommond
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region 组件设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            //this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;

            this.oTree1 = new OTree();
            FocusOptions focusOptions1 = new FocusOptions();
            // 
            // oTree1
            // 
            this.oTree1.BackColor = System.Drawing.Color.White;
            this.oTree1.Dock = System.Windows.Forms.DockStyle.Fill;
            focusOptions1.NodeFocusOnRefresh = xap.rui.control.tree.options.FocusOnRefreshMode.KeepFocus;
            this.oTree1.FocusOption = focusOptions1;
            this.oTree1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Pixel);
            this.oTree1.IsContainerRender = true;
            this.oTree1.Location = new System.Drawing.Point(0, 30);
            this.oTree1.Name = "oTree1";
            this.oTree1.SingleBorderStyle = false;
            this.oTree1.Size = new System.Drawing.Size(290, 600);
            this.oTree1.TabIndex = 1;
        }

        private OTree oTree1;
        #endregion

        public void saveData()
        {
            List<OrTplNItmDO> selectList = getTmplItemsToSave();
            if (selectList != null && selectList.Count > 0)
            {
                int num = this.buttonViewModel.getOrHelperOpenOrCountLimitSet();
                string[] but = new[] { "继续", "放弃" };
                if (selectList.Count <= num || BizAssMessageBoxUtil.ShowMsgInfo("提示信息", "模板的数据量超过" + num + "条，保存有点慢", but))
                {
                    EventHandler hh = delegate
                    {
                        if (this.saveToDb(selectList))
                        {
                            xapBaseControl.SetStatusMsg("医嘱保存成功！");
                        }
                        clearTreeChecked();
                    };

                    this.BeginInvoke(hh, null);
                }
            }
            else
            {
                this.ShowInfo("请勾选医嘱模板数据！");
            }

        }
        
        private bool saveToDb(List<OrTplNItmDO> selectList)
        {
            AssCostTimeTool costTimeTool = new AssCostTimeTool("执行医嘱模板保存" + selectList.Count + "条记录", false);
            var moreEmsDto = this.buttonViewModel.getMoreEmsParamDTO(this.ciEnContext, selectList.ToArray());
            costTimeTool.SaveTimeLog();
            if (moreEmsDto != null)
            {
                xapBaseControl.FireEventSent(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_TMPL_EDIT, EventCodeType.ARGKEY_EMS_TMPL_EDIT,
                     moreEmsDto));
                if (moreEmsDto.Errormap2 == null || moreEmsDto.Errormap2.Values.Count == 0)
                {
                    return true;
                }
            }
            return false;
        }
        
        public void close() 
        { }
        
        public object getSaveData() 
        { 
            return null; 
        }
    }
}
