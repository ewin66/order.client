
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using iih.common_stub.datong;
using iih.common_stub.datong.data;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.engine.eventbroker;
using xap.rui.engine;
using xap.rui.engine.eventbroker.Handlers;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.ciorder.d;
using xap.rui.control.basecontrol;
using xap.rui.bizcontrol.bannercontrol;
using iih.en.pv.dto.d;
using xap.sys.permfw.user.d;
using xap.sys.orgfw.dept.d;
using iih.bd.mm.meterial.d;
using iih.ci.ord.ordsrvmm.d;
using iih.ci.ord.opemergency.assi.rationaldrug.viewmodel;
using xap.cli.sdk.form;
using System.Windows.Forms;
using xap.mw.log;
using xap.rui.bizcontrol.bannerview;
using iih.ci.ord.opemergency.declare;


namespace iih.ci.ord.opemergency.assi.rationaldrug.view
{
    /// <summary>
    /// <para>描    述 :  hums</para>
    /// <para>说    明 :  合理用药交互类</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.rationaldrug.view    </para>    
    /// <para>类 名 称 :  RationalDrugEvent					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/9/6 11:04:37             </para>
    /// <para>更新时间 :  2016/9/6 11:04:37             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class RationalDrugEvent : XapBaseControl
    {

        #region 变量定义区域

        private Ent4BannerDTO ent4BannerDTO;

        private DatongDrugMonitor drugMonitor;

        #endregion

        #region 构造函数区域

        public RationalDrugEvent()
        {
            this.drugMonitor = new DatongDrugMonitor();
            InitializeComponent();
        }

        public RationalDrugEvent(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        /// <summary>
        /// 发送药品要点提示信息
        /// </summary>
        [EventPublication(RationalDrugConstant.FIRE_MAIN_POINTS_RESULT_EVENT)]
        public event EventHandler<DataEventArgs<string>> FireMainPointsResultEvent;
        private void fireEmrHistoryMrEvent(string tipInfo)
        {

            DataEventArgs<string> eventArgs = new DataEventArgs<string>(tipInfo);

            if (FireMainPointsResultEvent != null)
                this.FireMainPointsResultEvent(this, eventArgs);
        }

        #endregion

        #region 事件接收区域

        /// <summary>
        /// 接收获取要点提示信息事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args"></param>
        [EventSubscription(RationalDrugConstant.FIRE_MAIN_POINTS_EVENT, typeof(OnPublisher))]
        public void fireMainPointsEvent(object sender, DataEventArgs<OrdSrvMmDO> args)
        {
            OrdSrvMmDO ordSrvMm = args.Data;
            this.ClearState();
            ordSrvMm.Code_mm = "200002";
            ordSrvMm.Name_mm = "头孢克洛";
            string result = this.GetMainPoints(ordSrvMm);

        }

        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取banner信息患者
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (!(sender is bannerOpdocstation))
            {
                this.Enabled = false;
                return;
            }

            this.ent4BannerDTO = null;

            BannerData bannerData = e.Object as BannerData;
            if (bannerData != null && bannerData.Ent4BannerDTO != null)
            {
                this.ent4BannerDTO = bannerData.Ent4BannerDTO;
                string d = this.AnalysisPresResult();
            }
            else
            {
                this.ent4BannerDTO = null;
            }

            //MainPointsEvent();
            //this.ClearState();
        }

        #endregion

        #region 测试方法

        /// <summary>
        /// 药品提示
        /// </summary>
        private void MainPointsEvent() {

            OrdSrvMmDO ordSrvMm = new OrdSrvMmDO();
            this.ClearState();
            ordSrvMm.Code_mm = "200002";
            ordSrvMm.Name_mm = "头孢克洛";
            string result = this.GetMainPoints(ordSrvMm);
            

        }

        /// <summary>
        /// 处方分析
        /// </summary>
        private string AnalysisPresResult()
        {

            PresInfo presInfo = GetPresInfo();
            string analysisResult = drugMonitor.AnalysisPres(presInfo);
            return analysisResult;
        }

        /// <summary>
        /// 处方分析并保存
        /// </summary>
        /// <returns></returns>
        private string AnalysisAndSavePres()
        {

            PresInfo presInfo = GetPresInfo();
            string analysisResult = drugMonitor.AnalysisPres(presInfo);
            return analysisResult;
        }

        private PresInfo GetPresInfo() {

            PresInfo presInfo = new PresInfo();
            presInfo.Case_id = "1";
            this.GetDoctorPresInfo(ref presInfo);

            List<PresInfo.Prescription> prescriptions = new List<PresInfo.Prescription>();

            // 处方
            PresInfo.Prescription prescription = new PresInfo.Prescription();
            prescription.Pres_ID = "10";
            prescription.Pres_type = PresTypeEnum.OUTPATIENT;
            prescription.Current = true;
            prescriptions.Add(prescription);

            

            // 药品
            List<PresInfo.Medicine> medicineList = new List<PresInfo.Medicine>();

            PresInfo.Medicine medicine1 = new PresInfo.Medicine();
            PresInfo.Medicine medicine2 = new PresInfo.Medicine();
            //药品1
            medicine1.Medicine_suspension = false; // 药物悬浮液
            medicine1.Medicine_judge = true; // 药品判断
            medicine1.Group_number = null; // 组号
            medicine1.General_name = "美托洛尔";  // 通用名
            medicine1.License_number = "201153";//医院药品代码
            medicine1.Medicine_name = "美托洛尔"; //商品名
            medicine1.Single_dose = 5; //  单次计量
            medicine1.Times = "1";//频次代码
            medicine1.Days = 2; //天数
            medicine1.Unit = "mg";//单位
            medicine1.Administer_drugs = ""; //用药途径
            // 药品2
            medicine2.Medicine_suspension = false; // 药物悬浮液
            medicine2.Medicine_judge = true; // 药品判断
            medicine2.Group_number = null; // 组号
            medicine2.General_name = "氨氯地平";  // 通用名
            medicine2.License_number = "200192";//医院药品代码
            medicine2.Medicine_name = "氨氯地平"; //商品名
            medicine2.Single_dose = 5; //  单次计量
            medicine2.Times = "1";//频次代码
            medicine2.Days = 2; //天数
            medicine2.Unit = "mg";//单位
            medicine2.Administer_drugs = ""; //用药途径

            medicineList.Add(medicine1);
            medicineList.Add(medicine2);

            //prescription.Medicines = medicineList;

            presInfo.Prescriptions = prescriptions;

            return presInfo;
        }

        private void GetDoctorPresInfo(ref PresInfo presInfo) {
            UserDO user = this.Context.User;
            DeptDO dept = this.Context.Dept;

            presInfo.Doctor_job_number = user.Code; //医生工号
            presInfo.Pres_date = new DateTime(); //处方日期
            presInfo.Doctor_name = user.Name; // 医生名
            //presInfo.Doctor_type =  医生级别
            presInfo.Department_code = dept.Code;// 科室代码 ？ 开立科室
            presInfo.Department_name = dept.Name; // 科室名称
            presInfo.Case_id = "blkh0001";//病历卡号
            //presInfo.Inhos_code = 住院号
            //presInfo.Bed_no = 床号
            presInfo.Patient_weight = "100Kg";//患者体重
            presInfo.Patient_height = "170cm";//患者身高
            presInfo.Patient_birth = DateTime.Parse(ent4BannerDTO.Dt_birth); //患者出生日期
            presInfo.Patient_name = ent4BannerDTO.Name_pat; // 患者名称
            presInfo.Patient_sex = ent4BannerDTO.Name_sex; // 患者性别
            //presInfo.Physiological_statms 生理状况
            //presInfo.Boacterioscopy_effect 菌检结果
            //presInfo.Bloodpressur 血压
            //presInfo.Liver_clean 肌酐清除率
        }

        #endregion





        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 清空原有的状态，主要作用是刷新屏幕上的四个灯
        /// </summary>
        private void ClearState()
        {
            drugMonitor.BeginNewPres();
        }

        /// <summary>
        /// 获取要点提示信息
        /// </summary>
        /// <returns></returns>
        private string GetMainPoints(OrdSrvMmDO ordSrvMm)
        {
            DrugInfo drug = new DrugInfo();
            drug.General_name = ordSrvMm.Name_mm; // 药品名称
            drug.License_number = ordSrvMm.Code_mm;// 药品编码

            string mainPoints = drugMonitor.HintMainPoints(drug);
            return mainPoints;
        }

        /// <summary>
        /// 获取处方用药的分析结果
        /// </summary>
        /// <returns></returns>
        private string GetAnalysisPresResult(List<CiOrderDO> ordList)
        {
            if (this.ent4BannerDTO == null)
            {
                return "";
            }

            PresInfo presInfo = GetPresInfo(ordList);
            string analysisResult = drugMonitor.AnalysisPres(presInfo);
            return analysisResult;
        }

        private PresInfo GetPresInfo(List<CiOrderDO> ordList)
        {

            UserDO user = this.Context.User;
            DeptDO dept = this.Context.Dept;

            PresInfo presInfo = new PresInfo();
            presInfo.Doctor_job_number = user.Code; //医生工号
            presInfo.Pres_date = new DateTime(); //处方日期
            presInfo.Doctor_name = user.Name; // 医生名
            //presInfo.Doctor_type =  医生级别
            presInfo.Department_code = dept.Code;// 科室代码 ？ 开立科室
            presInfo.Department_name = dept.Name; // 科室名称
            //presInfo.Case_id = 病历卡号
            //presInfo.Inhos_code = 住院号
            //presInfo.Bed_no = 床号
            //presInfo.Patient_weight = 患者体重
            //presInfo.Patient_height = 患者身高
            presInfo.Patient_birth = DateTime.Parse(ent4BannerDTO.Dt_birth); //患者出生日期
            presInfo.Patient_name = ent4BannerDTO.Name_pat; // 患者名称
            presInfo.Patient_sex = ent4BannerDTO.Name_sex; // 患者性别
            //presInfo.Physiological_statms 生理状况
            //presInfo.Boacterioscopy_effect 菌检结果
            //presInfo.Bloodpressur 血压
            //presInfo.Liver_clean 肌酐清除率

            presInfo.AllergicHistories = this.GetAllergicHistory(); // 过敏史

            presInfo.Diagnoses = this.GetDiagnoses(); // 诊断

            presInfo.Prescriptions = this.GetPrescriptions(); // 获取处方

            return null;
        }

        /// <summary>
        /// 获取过敏史集合
        /// </summary>
        /// <returns></returns>
        private List<PresInfo.AllergicHistory> GetAllergicHistory()
        {

            List<PresInfo.AllergicHistory> allergicHistory = new List<PresInfo.AllergicHistory>();
            PresInfo.AllergicHistory allergic = new PresInfo.AllergicHistory();

            allergicHistory.Add(allergic);
            return allergicHistory;
        }

        /// <summary>
        /// 获取诊断 ? 诊断集合值是什么？诊断编码，还是诊断名？ 作用是什么
        /// </summary>
        /// <returns></returns>
        private List<string> GetDiagnoses()
        {
            List<string> diagList = new List<string>();

            return diagList;
        }

        /// <summary>
        /// 获取处方
        /// </summary>
        /// <returns></returns>
        private List<PresInfo.Prescription> GetPrescriptions()
        {

            List<PresInfo.Prescription> presList = new List<PresInfo.Prescription>();

            PresInfo.Prescription pres = new PresInfo.Prescription();
            pres.Pres_ID = "";// 处方id ？目前处方是签署之后生成
            pres.Pres_type = PresTypeEnum.OUTPATIENT; //处方类型：门诊、住院
            pres.Current = true; // 是否为当前要分析的处方
            //pres.Medicines = this.GetMedicine();

            return presList;
        }

        /// <summary>
        /// 获取药品集合
        /// </summary>
        /// <returns></returns>
        private List<PresInfo.Medicine> GetMedicine()
        {

            List<PresInfo.Medicine> medicineList = new List<PresInfo.Medicine>();

            PresInfo.Medicine medicine = new PresInfo.Medicine();
            medicine.Medicine_suspension = true; // 药品悬浮液
            medicine.Medicine_judge = true; // 药品判断 ？ 判断什么，赋值逻辑
            medicine.Group_number = "groupNum";// 组号
            medicine.General_name = "肝素钠"; // 通用名
            medicine.License_number = "200224"; //药品代码
            medicine.Medicine_name = "肝素钠";// 商品名
            medicine.Single_dose = 1.25;// 单次剂量
            medicine.Times = ""; // 频次代码
            medicine.Days = 3;// 天数
            medicine.Unit = "g"; //单位
            medicine.Administer_drugs = "";// 用药途径

            medicineList.Add(medicine);
            return medicineList;
        }

        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = AssToolEx.EventCodeOfEventArgs(eventArgs);

            if (uiEvent.Equals(EventCodeType.EVENT_ORDLIST_DATAVALIDATE))
            {
                Object dataObj = AssToolEx.ObjectOfEventArgs(eventArgs, "CiOrderDOList");
                if (null != dataObj)
                {
                    List<CiOrderDO> ordList = dataObj as List<CiOrderDO>;
                    // TODO: 校验医嘱数据有效性
                }

            }

        }

        #endregion
    }
}
