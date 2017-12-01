using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.control.formcontrol.model;
using iih.ci.ord.ciorcof.viewmodel;
using xap.cli.sdk.render;
using iih.ci.ord.ciorder;
using System.IO;
using xap.rui.appfw;
using iih.ci.ord.ciorcof.d;
using xap.rui.control.forms.control;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorcof.view
{
    public partial class CiOrdSheetItemView : XapBaseControl
    {
      
          #region 变量定义区域
        private XapFormControl xapFormControl1;
        CiOrdSheetItemViewModel model;
        //XapFormGridControl gv;
        XapDataList<CiOrdSheet> sheetList = new XapDataList<CiOrdSheet>();
        #endregion

        #region 构造函数区域
        public CiOrdSheetItemView()
        {
         
            InitializeComponent();
           
            this.xapFormControl1 = new XapFormControl();
            this.xapFormControl1.Dock = DockStyle.Fill;
            this.Load += new EventHandler(opoverview_Load);
            this.Controls.Add(this.xapFormControl1);

            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);


        }

        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            UserRender btn = this.xapFormControl1.GetUserRender("sheet", "btnSelect");
             UserRender txt = this.xapFormControl1.GetUserRender("sheet", "txtselect");
             UserRender btnOK = this.xapFormControl1.GetUserRender("sheet", "btnOk");
             btnOK.MouseClick += new MouseEventHandler(btnOK_MouseClick);
             btn.MouseClick += delegate
             {
                 if (openFileDialog1.ShowDialog() == DialogResult.OK)
                 {
                     txt.ValueObj = openFileDialog1.FileName;
                 }
             };



        }

        void btnOK_MouseClick(object sender, MouseEventArgs e)
        {
            CiOrdSheet[] sheets = xapFormControl1.GetSelected<CiOrdSheet>("sheetItem");

          sheets.ToList().ForEach(p=>sheetList.Add(p));
          model.Save(sheetList.ToArray());//把数据保存到数据库

        }
        
        void GetObjInfo()
        {
            DirectoryInfo fdir = new DirectoryInfo(Application.StartupPath + "\\Plus");
            FileInfo[] file = fdir.GetFiles("*.dll", SearchOption.TopDirectoryOnly);
            //lup_dll.Properties.DataSource = file;
           
            string strdllName = "dll名称";
            System.Reflection.Assembly assembly = System.Reflection.Assembly.LoadFrom(Application.StartupPath + "\\Plus\\" +strdllName);
            System.Type[] types = assembly.GetTypes();
            foreach (var item in types)
            {
                if (item.BaseType.Name == "CiorderBaseControl")
                {
                    Type type = assembly.GetType(item.FullName);
                    CiorderBaseControl rm = (CiorderBaseControl)Activator.CreateInstance(type);
  
                    CiOrdSheet sheet = new CiOrdSheet();
                    sheet.Name = rm.SheetName;
                    sheet.Des = rm.SheetDes;
                    sheet.Dll_model = strdllName;
                    sheet.Dll_assembly = type.FullName;

                    sheetList.Add(sheet);
                }
            }
            //gc_dllcavas.DataSource = dt;
        }

     
        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域
      

        //[XapCommand(Name = "Open", Caption = "打开")]
        //public void OnOpen(object sender, EventArgs e)
        //{

        //}

        #endregion

        #region 事件发送区域

        //[XapEventSent(Name = "Say")]
        //public event EventHandler<XapEventArgs> Say;

        #endregion

        #region 事件接收区域

        //[XapEventRecv(Name = "Recv")]
        //public void OnRecv(object sender, XapEventArgs e)
        //{

        //}
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            model = new CiOrdSheetItemViewModel();
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_CiOrdSheetItemView;// "20160108112543091YDQ";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = model;
            this.xapFormControl1.ViewFile = file;
 
        }

        #endregion

        #region 内部事件区域
         
         

        #endregion

        #region 辅助处理函数
        void opoverview_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        #endregion

        #region 状态处理区域

        //public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        //{
        //    string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
        //    string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
        //    switch (uiEvent)
        //    {
        //        case UIEvent.REFRESH:
        //            this.LoadData();
        //            break;
        //        case UIEvent.LOAD:
        //            Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
        //            if (dic != null)
        //            {
        //                if (dic.Keys.Contains("PatientData"))
        //                {
        //                    patDo = dic["PatientData"] as PatiVisitDO;
        //                }
        //                if (dic.Keys.Contains("IsInHospitalStation"))
        //                {
        //                    patDo.Id_ent = dic["EncounterID"].ToString();
        //                }

        //                // this.OnLoadData();
        //            }

        //            break;
        //        default:
        //            break;
        //    }
        //}

        #endregion
    }
}
