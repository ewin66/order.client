using iih.ci.ord.opemergency.assi.i;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.declare;
using xap.rui.control.extentions;
using System.Collections.Generic;
using iih.bd.srv.ortpl.d;
using System;
using iih.ci.ord.common.utils.msg;

namespace iih.ci.ord.opemergency.assi.OrdertemplatePithy.view
{
    partial class OpOrderTemplateTreeViewPithy: IViewCommond
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

            this.oTree1 = new xap.rui.control.tree.otree.OTree();
            xap.rui.control.tree.options.FocusOptions focusOptions1 = new xap.rui.control.tree.options.FocusOptions();
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
       public  void saveData(){
           if (selectList.Count > 0)
           {
               int num = Buttonmodel.getOrHelperOpenOrCountLimitSet();
               if (selectList != null && selectList.Count > num)
               {
                   string[] but = new[] { "继续", "放弃" };
                   if (BizAssMessageBoxUtil.ShowMsgInfo("提示信息", "模板的数据量超过" + num + "条，保存有点慢", but))
                   {
                       EventHandler hh = delegate
                       {
                           if (saveToDb(this.selectList))
                           {
                               xapBaseControl.SetStatusMsg("保存成功！");
                               clearTreeChecked();
                           }
                           else
                           {
                               clearTreeChecked();
                           }
                       };

                       this.BeginInvoke(hh, null);
                   }
               }
               else
               {
                   EventHandler hh = delegate
                   {
                       if (saveToDb(this.selectList))
                       {
                           xapBaseControl.SetStatusMsg("保存成功！");
                           clearTreeChecked();
                       }
                       else
                       {
                           clearTreeChecked();
                       }
                   };

                   this.BeginInvoke(hh, null);
               }
           }
           else {
               this.ShowInfo("请确认已选择医嘱数据！");
           }
           
       }
       private bool saveToDb(List<OrTplNItmDO> selectList)
       {

            AssCostTimeTool costTimeTool = new AssCostTimeTool("执行医嘱模板保存" + selectList.Count + "条记录", false);

            var moreEmsDto = Buttonmodel.getMoreEmsParamDTO(this.ciEnContext, selectList.ToArray());

            costTimeTool.SaveTimeLog();


            // 是否保存成功
            bool isSaveSucc = false;

            if (moreEmsDto != null)
            {
                xapBaseControl.FireEventSent(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_TMPL_EDIT, EventCodeType.ARGKEY_EMS_TMPL_EDIT,
                     moreEmsDto));
                if (moreEmsDto.Errormap2 == null || moreEmsDto.Errormap2.Values.Count == 0)
                {
                    isSaveSucc = true;
                }
            }

            return isSaveSucc;
       }
       public void close() { }
       public object getSaveData() { return null; }
       
        #endregion
    }
}
