using System.Linq;
using iih.bd.bc.udi;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.consrpt.d;
using iih.ci.ord.consrpt.i;
using iih.en.pv.i;
using xap.cli.context;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.extentions;
using iih.ci.ord.cior.d;
using iih.ci.ord.cior.i;

namespace iih.ci.ord.ciconsresponse.viewmodel
{
    class ConsRptViewModel
    {
        //
        public XapDataList<EmsItemInCons> consitemList=new XapDataList<EmsItemInCons>();
        private ICiorappconsultMDOCrudService consDoService;
        private ICiorderMDOCrudService ordService;
        private IEnOutQryService enservice;
        private IConsrptCrudService consrptService;
        private OrdApConsDO consDo;
        //public CiOrdConsRptDO consRptDo;
        public CiOrdConsRptDO[] rptArray;

        public EmsConsItemDO consDTO;
        

        public ConsRptViewModel(string id_orcons)
        {
            this.consDoService = XapServiceMgr.find<ICiorappconsultMDOCrudService>();
            this.consrptService = XapServiceMgr.find<IConsrptCrudService>();
            this.ordService = XapServiceMgr.find<ICiorderMDOCrudService>();
            this.enservice = XapServiceMgr.find<IEnOutQryService>();
            this.consDo = this.consDoService.findById(id_orcons);
            rptArray=this.consrptService.find(" a0.id_apcons='" + id_orcons + "' ", null, FBoolean.False);
            if (rptArray.Count() == 0)
            {
                this.consDTO = this.AddConsDo();
            }
            else
            {
                this.consDTO = this.EditConsDo();
            }
        }

        /// <summary>
        /// *******************************************获取患者类型*******************************************
        /// </summary>
        /// <param name="ident"></param>
        /// <returns></returns>
        public string getEntpattp(string ident)
        {
            string pattp = this.enservice.GetEntPatTp(ident, UserManager.getInstance().CurrentDept.Id_dep, UserManager.getInstance().CurrentPsnInfo.Id_psndoc);
            return pattp;
        }

        /// <summary>
        /// *******************************************    新增      *******************************************
        /// </summary>
        /// <returns></returns>
        public EmsConsItemDO AddConsDo()
        {
            if (this.consDo == null)
                return null;
            CiOrderDO orderDo = this.ordService.findById(consDo.Id_or);
            if (orderDo==null)
                return null;
            EmsConsItemDO rptDo=new EmsConsItemDO();
            rptDo.Id_emsconsitem = consDo.Id_apcons;	//主键	SINGLE	String	50	  
            //rptDo.Id_or = consDo.Id_or;      //医嘱id	SINGLE	String	50
            //rptDo.Id_srv = srv.Id_srv;
            //rptDo.Id_orsrv = srv.Id_orsrv;
            rptDo.Fg_urgent = consDo.Fg_urgent;    //加急标识	SINGLE	FBoolean  
            rptDo.Dt_plan = consDo.Dt_plan;     	//计划会诊时间	SINGLE	FDateTime 
            //rptDo.Tel = consDo.Tel;      	//联系电话	SINGLE	String	2 
            //rptDo.Id_place = consDo.Id_place;   //申请地点id	REF	地点	20	 	  
            rptDo.Name_place = consDo.Place;    //申请地点名称	SINGLE	String	5 
            rptDo.Des_emr = consDo.Des_emr;        //  病理摘要	SINGLE	备注	300	  
            rptDo.Des_psp = consDo.Des_psp;        //会诊目的	SINGLE	备注	300	  
            rptDo.Id_dep_cons = orderDo.Id_dep_or;	    // 申请科室id	REF	部门	20	 	  
            rptDo.Name_dep_cons = orderDo.Dept_or_name;	//申请科室	SINGLE	String	5 
            //rptDo.Dt_creat = orderDo.Dt_create;	    //申请时间	SINGLE	FDateTime 
            rptDo.Id_emp_cons = orderDo.Id_emp_or;	    //申请人id	REF	用户	20	 	  
            rptDo.Name_emp_cons = orderDo.Emp_phy_name; //申请人	SINGLE	String
            rptDo.Id_constp = consDo.Id_constp;//会诊类型id				 	 	 	 	 	 				 	 			 	 	 	
            rptDo.Name_constp = consDo.Name_constp;//会诊类型		 	 				 	 			 	 	 	
            rptDo.Sd_constp = consDo.Sd_constp;//会诊类型编码		 	 				 	 			 	 	 	
            rptDo.Id_su_cons = consDo.Id_su_cons;	//会诊申请状态id				 	 	 	 	 	 				 	 			 	 	 	
            rptDo.Name_su_cons = consDo.Name_su_cons;//会诊申请状态			 	 			 	 	 	
            rptDo.Sd_su_cons = consDo.Sd_su_cons;	//会诊申请状态编码	 				 	 			 	 	 	
            //rptDo.Bed_no	=consDo//床号		 			 	 	 	
            //rptDo.Name_pat	=//姓名		 			 	 	 	
            //rptDo.Name_di	=//诊断		 			 	 	 	
            //rptDo.Str_urgent=consDo.s	//加急状态			 	 			 	 	 	
            rptDo.Des_dep = consDo.Des_dep;//医务部意见			 	 			 	 	 	
            //rptDo.Id_emp_host=	//会诊主持人id		 	 			 	 	 	
            //rptDo.Name_emp_host=	//会诊主持人			 	 			 	 	 	
            //rptDo.Advice=	//会诊记录	SINGLE	

            

            return rptDo;
        }
        /// <summary>
        ///*******************************************编辑*******************************************
        /// </summary>
        /// <returns></returns>
        /// 
        public EmsConsItemDO EditConsDo()
        {
            if (this.rptArray.Count()==0)
                return null;
            CiOrdConsRptDO conrpt = this.rptArray[0];
            CiOrderDO orderDo = this.ordService.findById(consDo.Id_or);
            if (orderDo == null)
                return null;
            EmsConsItemDO rptDo = new EmsConsItemDO();
            rptDo.Id_emsconsitem = consDo.Id_apcons;	//主键	SINGLE	String	50	  
            //rptDo.Id_or = consDo.Id_or;      //医嘱id	SINGLE	String	50
            //rptDo.Id_srv = srv.Id_srv;
            //rptDo.Id_orsrv = srv.Id_orsrv;
            rptDo.Fg_urgent = consDo.Fg_urgent;    //加急标识	SINGLE	FBoolean  
            rptDo.Dt_plan = conrpt.Dt_actual;     	//计划会诊时间	SINGLE	FDateTime 
            //rptDo.Tel = consDo.Tel;      	//联系电话	SINGLE	String	2 
            rptDo.Id_place = conrpt.Id_place_actual;   //申请地点id	REF	地点	20	 	  
            rptDo.Name_place = conrpt.Name_place;    //申请地点名称	SINGLE	String	5 
            rptDo.Des_emr = consDo.Des_emr;        //  病理摘要	SINGLE	备注	300	  
            rptDo.Des_psp = consDo.Des_psp;        //会诊目的	SINGLE	备注	300	  
            rptDo.Id_dep_cons = orderDo.Id_dep_or;	    // 申请科室id	REF	部门	20	 	  
            rptDo.Name_dep_cons = orderDo.Dept_or_name;	//申请科室	SINGLE	String	5 
            //rptDo.Dt_creat = orderDo.Dt_create;	    //申请时间	SINGLE	FDateTime 
            rptDo.Id_emp_cons = orderDo.Id_emp_or;	    //申请人id	REF	用户	20	 	  
            rptDo.Name_emp_cons = orderDo.Emp_phy_name; //申请人	SINGLE	String
            rptDo.Id_constp = consDo.Id_constp;//会诊类型id				 	 	 	 	 	 				 	 			 	 	 	
            rptDo.Name_constp = consDo.Name_constp;//会诊类型		 	 				 	 			 	 	 	
            rptDo.Sd_constp = consDo.Sd_constp;//会诊类型编码		 	 				 	 			 	 	 	
            rptDo.Id_su_cons = consDo.Id_su_cons;	//会诊申请状态id				 	 	 	 	 	 				 	 			 	 	 	
            rptDo.Name_su_cons = consDo.Name_su_cons;//会诊申请状态			 	 			 	 	 	
            rptDo.Sd_su_cons = consDo.Sd_su_cons;	//会诊申请状态编码	 				 	 			 	 	 	
            //rptDo.Bed_no	=consDo//床号		 			 	 	 	
            //rptDo.Name_pat	=//姓名		 			 	 	 	
            //rptDo.Name_di	=//诊断		 			 	 	 	
            //rptDo.Str_urgent=consDo.s	//加急状态			 	 			 	 	 	
            //rptDo.Des_dep = consDo.Des_dep;//医务部意见			 	 			 	 	 	
            rptDo.Id_emp_host = conrpt.Id_emp_host;	//会诊主持人id		 	 			 	 	 	
            rptDo.Name_emp_host = conrpt.Name_emp_host;	//会诊主持人			 	 			 	 	 	
            rptDo.Advice = conrpt.Advice;	//会诊记录	SINGLE	
            
           return rptDo;
        }


        /// <summary>
        /// *******************************************获取人员信息*******************************************
        /// </summary>
        /// <param name="id_orcons"></param>
        public void GetConsItem(string id_orcons)
        {
            InviteConsViewModel inviteVM = new InviteConsViewModel();
            consitemList.Clear();
            EmsItemInCons[] invites = inviteVM.GetInviteConsByIdapCons(id_orcons);
            invites.ToList().ForEach(p => { consitemList.Add(p); });

        }
        /// <summary>
        /// *******************************************保存*******************************************
        /// </summary>
        /// <returns></returns>
        public bool SaveConsRpt()
        {
            CiOrdConsRptDO consRptDo;
            if (this.rptArray.Count() != 0)
            {
                consRptDo = this.rptArray[0];
                consRptDo.Status = DOStatus.UPDATED;
            }
            else
            {
                consRptDo = new CiOrdConsRptDO();
            }
            if (consDTO == null)
            {
                this.ShowInfo("会诊申请不存在，无法保存！");
                return false;
            }
            //consRptDo.id_rptcons    =	//主键	SINGLE	String	id	 	 	 	
            consRptDo.Id_apcons = consDTO.Id_emsconsitem;//会诊申请单id	 	 	 
            consRptDo.Dt_actual = consDTO.Dt_plan;//实际会诊时间	SINGLE	FD 				
            consRptDo.Advice = consDTO.Advice;//会诊意见	SINGLE	备注		 	 	
            consRptDo.Id_emp_rpt = UserManager.getInstance().CurrentUser.Id_user;//报告人	REF	用户	id 				
            consRptDo.Id_dep_rpt = UserManager.getInstance().CurrentDept.Id_dep; //报告科室	REF	部门	id			 	
            consRptDo.Dt_rpt = CommonExtentions.NowTime(this); //报告时间	SINGLE	FDateT		 	 	
            consRptDo.Id_emp_host = consDTO.Id_emp_host; //会诊主持	REF	用户	id 				
            consRptDo.Id_place_actual = consDTO.Id_place;//实际会诊地点	REF	地点				
            consRptDo.Sd_su_rpt = CiDictCodeConst.SD_SU_RPT_OPEN;//会诊记录状态编码	SINGLE 				
            consRptDo.Id_su_rpt = CiDictCodeConst.SD_SU_RPT_ID_OPEN; //会诊记录状态id	REF	St
            consRptDo.Name_place = consDTO.Name_place;
            this.consrptService.save(new CiOrdConsRptDO[] { consRptDo });
            return true;
        }
        /// <summary>
        /// *******************************************提交*******************************************
        /// </summary>
        public void SubmitRpt()
        {
            CiOrdConsRptDO consRptDo = this.rptArray[0];
            consRptDo.Dt_actual = consDTO.Dt_plan;//实际会诊时间	SINGLE	FD 				
            consRptDo.Advice = consDTO.Advice;//会诊意见	SINGLE	备注	
            consRptDo.Id_emp_host = consDTO.Id_emp_host; //会诊主持	REF	用户	id 				
            consRptDo.Id_place_actual = consDTO.Id_place;//实际会诊地点	REF	地点				
            consRptDo.Sd_su_rpt = CiDictCodeConst.SD_SU_RPT_SIGN;//会诊记录状态编码	SINGLE 				
            consRptDo.Id_su_rpt = CiDictCodeConst.SD_SU_RPT_ID_SIGN; //会诊记录状态id	REF	St
            consRptDo.Status = DOStatus.UPDATED;
            this.consrptService.save(new CiOrdConsRptDO[] {consRptDo});
        }
       
    }
}
