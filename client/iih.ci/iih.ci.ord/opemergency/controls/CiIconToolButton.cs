
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using xap.cli.sdk.common;
using xap.cli.sdk.render;

namespace iih.ci.ord.opemergency.controls
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.controls    </para>    
    /// <para>类 名 称 :  CiIconToolButton					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  12/23/2016 5:52:51 PM             </para>
    /// <para>更新时间 :  12/23/2016 5:52:51 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiIconToolButton : XIconToolButton
    {
        private String imageName;

        public Boolean LargeImageMode{ get; set; }

        public CiIconToolButton()
        {
            LargeImageMode = false;
        }
        public String ImageName { get {
                return imageName;
            } set {
                imageName = value;
                SetIconToolButton(this, ImageName);
            } }
        public void OnSystemSkinChanged()
        {
            SetIconToolButton(this,ImageName);
        }

        private void SetIconToolButton(XIconToolButton button, String iconName)
        {
            String SkinPath = LargeImageMode? SkinFactory.Instance().CurrentSkin.SkinPath:SkinFactory.Instance().CurrentSkin.SmalSkinPath;
            button.NormalImage = Image.FromFile(SkinPath + string.Format("\\{0}-1.png", iconName));
            button.HoverImage = Image.FromFile(SkinPath + string.Format("\\{0}-2.png", iconName));
            button.DownImage = Image.FromFile(SkinPath + string.Format("\\{0}-3.png", iconName));
            button.DisableImage = Image.FromFile(SkinPath + string.Format("\\{0}-4.png", iconName));
            
            button.Invalidate();
        }
    }
}
