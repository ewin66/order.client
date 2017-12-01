using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.utils
{
    public class AutoLocation
    {

        public static Point GetPopuLocation(Point CurrPoint, Size ctlSize ,Size frmSize )
        {
           
            Point Np = new Point(0, 0);
            int width = SystemInformation.VirtualScreen.Width;
            //获取屏幕宽度
            int height = SystemInformation.VirtualScreen.Height;
            //获取屏幕高度

            //下 ，左突出
            Np.X = CurrPoint.X - (frmSize.Width - ctlSize.Width);
            Np.Y = CurrPoint.Y + ctlSize.Height;
            if (Np.X>0&&(Np.Y+frmSize.Height)<height)
            {
                return Np;
            }
            //上 左突出
            Np.Y = CurrPoint.Y -frmSize.Height;
            if (Np.X > 0 && Np.Y >0)
            {
                return Np;
            }
            //上 右突出
            Np.X = CurrPoint.X ;
            if (Np.X+frmSize.Width < width && Np.Y > 0)
            {
                return Np;
            }
            //下  右突出
            Np.Y = CurrPoint.Y + ctlSize.Height;

            if (Np.X+frmSize.Width<width && (Np.Y + frmSize.Height) < height)
            {
                return Np;
            }

            return Np;
        }
    }
}
