using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.controls;
using xap.cli.sdk.form;

namespace iih.ci.ord.ciobs.view
{
    public partial class VideoImage : XForm
    {
        private XBaseControl baseControl;
        public VideoImage()
        {
            InitializeComponent();

            this.MinimumSize = new Size(700, 500);

            baseControl = new XBaseControl();
            baseControl.Dock=DockStyle.Fill;
            baseControl.Paint += new PaintEventHandler(baseControl_Paint);
            this.AddRender(baseControl);

        }

        void baseControl_Paint(object sender, PaintEventArgs e)
        {
            string path = System.IO.Directory.GetCurrentDirectory() + @"\res\card\6.jpg";
            Image pic = Image.FromFile(path);
            if (pic == null)
                return;
            e.Graphics.DrawImage(pic, new Rectangle(0, 0, baseControl.Width, baseControl.Height));
        }
    }
}
