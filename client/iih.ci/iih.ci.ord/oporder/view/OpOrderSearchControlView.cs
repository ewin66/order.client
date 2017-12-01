using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.cards;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.ciorder.view;
using iih.ci.ord.ciorder.viewmodel;
using xap.cli.sdk.render.Items;
using xap.rui.appfw;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.rui.engine.registers;
using iih.ci.ord.ciorder.render;
using iih.ci.ord.ciorder.cards;
namespace iih.ci.ord.oporder.view
{
   public  class OpOrderSearchControlView:XOrderService, IXEventPublication, IRegister, IXapBaseControl
    {
       
       OrSrvForm frm;
       private string srvSearch;
       private string lastSrvCa;
       private bool Shoutflag;
       private bool Secondflag;
       OrderSrvListViewModel model = new OrderSrvListViewModel("");
       public OpOrderSearchControlView()
       {
            
            this.DataSource = this.model.srvtps;//搜索框
            this.Size = new Size(300, 24);
            this.SelectedItem = 10;
            Shoutflag = false;
            Secondflag = false;
            this.ValueTextChanging += new ChangingEventHandler(SearchControlView_ValueTextChanging);
            this.KeyClick += new KeyEventHandler(SearchControlView_KeyClick);
            this.TextBox.KeyDown += new KeyEventHandler(SearchControlView_KeyDown);
            this.TextBox.LostFocus += new EventHandler(TextBox_LostFocus);
            this.TextBox.MouseClick += new MouseEventHandler(TextBox_MouseClick);
            this.TextBox.Text = "常用模板";
            this.TextBox.ForeColor = Color.FromArgb(188,188,188);
           
       }
       OrdChildfrm form;
       void TextBox_MouseClick(object sender, MouseEventArgs e)
       {
           if (this.TextBox.Text == "常用模板")
           {
               this.TextBox.SelectionStart = 0;
               if (form == null || !form.Created)
               {
                   form = new OrdChildfrm();
                   form.btnClick += new MouseEventHandler(btnOk_MouseClick);
                   form.btnOk.Text = "Dsadsd";
                   Point p = this.ParentForm.PointToScreen(this.TextBox.Location);
                   this.ParentForm.Invalidate();
                   form.Location = new Point(p.X, p.Y + this.Size.Height-(this.TextBox.Location.Y-this.Location.Y));
                   this.form.Size = new Size(this.ParentForm.Parent.Size.Width - this.TextBox.Location.X, this.ParentForm.Parent.Size.Height - (this.Size.Height + this.Location.Y));
                   form.Show();
                   this.TextBox.Focus();
               }
               else
               {
                   Secondflag = false;
                   form.Show();
                   Secondflag = true;
                   this.TextBox.Focus();

               }
           }
       }

       void btnOk_MouseClick(object sender, MouseEventArgs e)
       {
           if (form != null)
           {
               Dictionary<string, Object> dict = new Dictionary<string, Object>();
               dict.Add("newListSelected", form.OrderRenderlist);
               DictionaryEventArgs de = new DictionaryEventArgs();
               de.Data.Add(UIConst.UI_EVENT, "ListSelected");
               de.Data.Add(UIConst.DATA, dict);
               this.EventSent(null, de);
           }
       }
       [DllImport("user32.dll")]
       private static extern IntPtr GetForegroundWindow();

       void TextBox_LostFocus(object sender, EventArgs e)
       {
           if (string.IsNullOrEmpty(this.TextBox.Text))
           {
               this.TextBox.Text = "常用模板";
               this.TextBox.ForeColor = Color.FromArgb(188, 188, 188);
           }
           if (frm != null)
           {
               //if (frm.Handle != GetForegroundWindow())
               //{
               //    if (frm != null && frm.Created && !this.TextBox.Focused)
               //    {
               //        if (Shoutflag)
               //        {
               //            frm.Hide();
               //        }
               //        Shoutflag = true;
               //    }
               //}
           }
           if (form != null)
           {
               if (form.Handle != GetForegroundWindow())
               {
                   if (form != null && form.Created && !this.TextBox.Focused)
                   {
                       if (Secondflag)
                       {
                           form.Hide();
                       }
                       Secondflag = true;
                   }
               }
           }
          
       }

       void SearchControlView_KeyDown(object sender, KeyEventArgs e)
       {
           if (e.KeyValue == 40 || e.KeyValue == 38)
           {
               int flag = 0;
               if (frm.or.gv.DataTable.SelectedRows.Count != 0)
               {
                   flag = frm.or.gv.DataTable.SelectedRows[0].Index;
               }
               else
               {
                   flag = 0;
               }
               if (e.KeyValue == 40)
               {
                   flag++;
                   frm.or.gv.SelectRow(flag);
               }
               else if (e.KeyValue == 38)
               {
                   flag--;
                   frm.or.gv.SelectRow(flag);
               }
               frm.or.Invalidate();
           }
       }

      

       void SearchControlView_KeyClick(object sender, KeyEventArgs e)
       {
           SearchControlView_ValueTextChanging(null, null);
       }
       protected override void TextboxOnLostFocus(object sender, EventArgs e)
       {
          
           //base.TextboxOnLostFocus(sender, e);
       }
       void SearchControlView_ValueTextChanging(object sender, ChangingEventArgs e)
       {
           if (!string.IsNullOrEmpty(this.TextBox.Text) && this.TextBox.Text.Contains("常用模板"))
           {
               if (!string.IsNullOrEmpty(this.TextBox.Text.Remove(this.TextBox.Text.IndexOf('常'))))
               {
                   this.TextBox.Text = this.TextBox.Text.Remove(this.TextBox.Text.IndexOf('常'));//.Substring(0, this.TextBox.Text.Length-4);
                   this.TextBox.ForeColor = Color.Black;
                   this.TextBox.SelectionStart = this.TextBox.TextLength;
               }
           }
         
               lastSrvCa = this.SelectKey as string;
               srvSearch = this.ValueText;
               if (string.IsNullOrEmpty(this.TextBox.Text) || this.TextBox.Text=="常用模板")
               {
                      
                   if (form != null)
                   {
                        form.Show();
                   }
                   this.TextBox.Focus();
                       this.TextBox.SelectionStart=0;
               }
               else
               {
                   if (frm == null || !frm.Created)
                   {
                       frm = new OrSrvForm();
                       frm.DbClickEvent += new OrSrvForm.DbClickHandle(frm_DbClickEvent);
                       //Point p = new Control().PointToScreen(new Point(this.Location.X - frm.Width, this.Location.Y + 30));//控件的右下角位置
                       //Point pc = System.Windows.Forms.Cursor.Position;
                       Point p = this.ParentForm.PointToScreen(this.Location);
                       //  this.ParentForm.BackColor = Color.Red;
                       this.ParentForm.Invalidate();
                       frm.Local = new Point(p.X, p.Y + this.Size.Height);//AutoLocation.GetPopuLocation(pc,new Size(236,30),frm.Size);
                       //ss = new Form();
                       //ss.Show();
                       //ss.StartPosition = FormStartPosition.CenterScreen;

                       //form.Hide();
                       frm.TopMost = true;
                       frm.Show();
                       SetSearchDataSouse(this.lastSrvCa, this.srvSearch);
                       Shoutflag = true;
                       this.TextBox.Focus();

                       bool fla = this.TextBox.Focused;
                   }
                   else
                   {
                       //  form.Hide();
                       Shoutflag = false;
                       frm.Show();
                       Shoutflag = true;
                       this.TextBox.Focus();
                       SetSearchDataSouse(this.lastSrvCa, this.srvSearch);
                   }
               }
       }
       void btnQuery_MouseClick(object sender, MouseEventArgs e)
       {
           if (frm==null && !frm.Created )
           {
               frm = new OrSrvForm();
               frm.DbClickEvent += new OrSrvForm.DbClickHandle(frm_DbClickEvent);
             
               //frm.Local = p;// AutoLocation.GetPopuLocation(pc,new Size(236,30),frm.Size);
               frm.Show();

               SetSearchDataSouse(this.lastSrvCa, this.srvSearch);

               this.Focus();
           }
       }

       public void SetSearchDataSouse(string srvca,string strWhere)
      {
           if (frm != null)
           {
               if (srvSearch.Length > 0)
               {
                   XapDataList<EmsOrSrvSc> list = model.GetSrv(srvca, strWhere,false);
                   frm.SCTextChanged(list);
               }
               else
               {

                   frm.SCTextChanged(new XapDataList<EmsOrSrvSc>());

               }
           }
       }
  
       /// <summary>
       /// 医嘱服务列表双击事件
       /// </summary>
       /// <param name="obj">The object.</param>
       /// Author:admin
       /// Date:2015-09-17
       void frm_DbClickEvent(OrScArgs obj)
       {

           Dictionary<string, string> dict = new Dictionary<string, string>();
           dict.Add("newListSelected", "newListSelected");
           DictionaryEventArgs de = new DictionaryEventArgs();
           de.Data.Add(UIConst.UI_EVENT, "ListSelected");
           de.Data.Add(UIConst.DATA, dict);
            
           this.EventSent(obj, de);
       }
       public event EventHandler<DictionaryEventArgs> EventSent;


       public object GetRegister()
       {
           return this;
       }
       public void OnInit()
       {
          
       }

       public void LoadData()
       {
            
       }
    }
}
