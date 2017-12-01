using iih.ci.ord.i;
using iih.ci.ord.opemergency.tool;
using System;
using xap.cli.sdk.controls;
using xap.cli.sdk.render.Items;
using xap.mw.serviceframework;
using xap.rui.engine.setting;

namespace iih.ci.ord.opemergency.setting
{
    class ClearCacheSettingApp : ISettingApp
    {
        #region 属性  事件（接口实现区域）
        public event EventHandler DataChanged;
        private void FireDataChanged()
        {
            if (DataChanged != null)
            {
                DataChanged(this, null);
            }
        }
        public String MenuItemName
        {
            get { return "清除缓存"; }
        }

        public bool IsModify { get; set; }

        public XAPScrollBarPanel Panel { get; set; }

        public String FunCode
        {
            get
            {
                return "461005";

            }
        }


        public String Code
        {

            get { return "ord" + "_" + "ClearCacheSettingApp"; }
        }

        public int Order
        {
            get { return 4; }
        }

        /// <summary>
        /// 当前激活节点所对应的Control
        /// </summary>
        public Object ActivedControl { set; get; }
        #endregion

        #region 构造
        public ClearCacheSettingApp()
        {
            Panel = new ClearCacheSettingControl();
            (Panel as ClearCacheSettingControl).fDelegateCallbackClearCache = DelegateCallbackClearCache;
        }
        #endregion

        #region 事件处理

        void DelegateCallbackClearCache(int isLocal)
        {
            ICiSysCacheService service = XapServiceMgr.find<ICiSysCacheService>();

            switch (isLocal)
            {
                case 0:
                    var cst0 = new AssCostTimeTool("清理本地缓存（ClearCacheSettingApp）： ", true);
                    SysParamUtils.Clear();
                    cst0.SaveTimeLog();
                    break;
                case 1:
                    var cst1 = new AssCostTimeTool("清理一级缓存（ClearCacheSettingApp）： ", true);
                    service.clearL1Cache(null);
                    cst1.SaveTimeLog();
                    break;
                case 2:
                    var cst2 = new AssCostTimeTool("清理二级缓存（ClearCacheSettingApp）： ", true);
                    service.clearL2Cache(null);
                    cst2.SaveTimeLog();
                    break;
                case 3:
                    var cst3 = new AssCostTimeTool("清理三级缓存（ClearCacheSettingApp）： ", true);
                    service.clearL3Cache(null);
                    cst3.SaveTimeLog();
                    break;
            }
            
        }


        #endregion

        #region 重写

        public void LoadMenItemPanel(XAPScrollBarPanel panel, SetMenunrender setMenunrender)
        {
            Panel = panel;
            Panel.Tag = setMenunrender;
        }

        public void Save()
        {
            this.IsModify = false;
        }

        public void Revoke()
        {

        }



        #endregion
    }

}
