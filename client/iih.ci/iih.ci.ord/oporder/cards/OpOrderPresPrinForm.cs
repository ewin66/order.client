using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.dto.OrderPresSplitDTO.d;

namespace iih.ci.ord.oporder.cards
{
    public partial class OpOrderPresPrinForm : Form
    {
        private OpOrderPresPrinView printview;// = new OpOrderPresPrinView();
        public OrderPresSplitDTO presdto { get; set; }
        public OpOrderPresPrinForm()
        {
            InitializeComponent();
            printview = new OpOrderPresPrinView();
            printview.Dock=DockStyle.Fill;
            this.Controls.Add(printview);
            this.Load += new EventHandler(OpOrderPresPrinForm_Load);
        }

        void OpOrderPresPrinForm_Load(object sender, EventArgs e)
        {
            printview.presdto = this.presdto;
        }

        public void printPres()
        {
            printview.presdto = this.presdto;
            printview.PrintPres();
        }
    }
}
