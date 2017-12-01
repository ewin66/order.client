using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using xap.cli.sdk.controls;
using xap.cli.sdk.render;

namespace iih.ci.ord.opemergency.setting
{
    public class ClearCacheSettingControl : XAPScrollBarPanel
    {

        private XButton _btnClearLocalCache;
        private XButton _btnClearRemoteCache;

        public delegate void DelegateCallbackClearCache(int isLocal);


        public DelegateCallbackClearCache fDelegateCallbackClearCache;


        public ClearCacheSettingControl()
        {
            LoadRender();
        }

        public void Init()
        {
            
        }

        void LoadRender()
        {
            if (_btnClearLocalCache != null)
            {
                this.RemoveRender(_btnClearLocalCache);
            }
            _btnClearLocalCache = new XButton();
            _btnClearLocalCache.Text = "清除【本地缓存】";
            _btnClearLocalCache.Location = new Point(22, 10);
            _btnClearLocalCache.Size = new Size(630, 100);
            this.AddRender(_btnClearLocalCache);
            _btnClearLocalCache.MouseClick += _btnClearLocalCache_MouseClick;

            _btnClearRemoteCache = new XButton();
            _btnClearRemoteCache.Text = "清除【一级缓存】";
            _btnClearRemoteCache.Location = new Point(22, _btnClearLocalCache.Location.Y + _btnClearLocalCache.Size.Height + 10);
           
            _btnClearRemoteCache.Size = _btnClearLocalCache.Size;
            this.AddRender(_btnClearRemoteCache);
            _btnClearRemoteCache.MouseClick += _btnClearL1Cache_MouseClick;


            XButton btn = new XButton();
            btn.Text = "清除【二级缓存】";
            btn.Location = new Point(22, _btnClearRemoteCache.Location.Y + _btnClearRemoteCache.Size.Height + 10);

            btn.Size = _btnClearLocalCache.Size;
            this.AddRender(btn);
            btn.MouseClick += _btnClearL2Cache_MouseClick;
        }

        private void _btnClearL1Cache_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (null != fDelegateCallbackClearCache)
            {
                fDelegateCallbackClearCache(1);
            }
        }

        private void _btnClearL2Cache_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (null != fDelegateCallbackClearCache)
            {
                fDelegateCallbackClearCache(2);
            }
        }

        private void _btnClearLocalCache_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (null != fDelegateCallbackClearCache)
            {
                fDelegateCallbackClearCache(0);
            }
        }
    }
}
