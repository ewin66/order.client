using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.bc.udi;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.viewmodel;
using xap.cli.context;
 
using xap.mw.core.data;
using xap.rui.control.extentions;
using iih.ci.ord.cior.d;

namespace iih.ci.ord.ciconsresponse.viewmodel
{
    class ConResDepViewModel
    {
        public XapDataList<EmsConsItemDO> consList;
        public EmsConsItemDO cons { get; set; }
        ApConsViewModel apvm = new ApConsViewModel();
        InviteConsViewModel inviteVM = new InviteConsViewModel();

        public XapDataList<EmsItemInCons> inviteList { get; set; }
        public ConResDepViewModel()
        {
            consList = new XapDataList<EmsConsItemDO>();
            cons = new EmsConsItemDO() ;
            inviteList = new XapDataList<EmsItemInCons>();
        }

        public void GetConsDep(string strWhere)
        {
            consList = apvm.GetConList(UserManager.getInstance().CurrentDept.Id_dep, strWhere);//UserManager.getInstance().CurrentDept.Id_dep

        }
        OrderInviteConsViewModel inviteCons = new OrderInviteConsViewModel();
        public void UpdateApConsInvite(string id_invite)
        {
            if(inviteList.Count==0)return;
            EmsItemInCons itemInCons = this.inviteList[0];
            CiordInviteConsDO con= inviteCons.GetInviteConsById(id_invite);
            con.Dt_response=CommonExtentions.NowTime(this);               //应答时间	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
	    	con.Fg_response =true;               //应答标志	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
            con.Id_emp_response = UserManager.getInstance().CurrentUser.Id_psn;           //应答人id	REF	用户	20	 
            con.Id_emp = itemInCons.Id_emp_doctor;
            con.Id_emp_title = itemInCons.Id_emp_title;
            con.Sd_emp_title = itemInCons.Sd_emp_title;
            cons.SetUpdated();	 	 	 	 	 	 				 	 			 	 	 	
            inviteCons.Save(new CiordInviteConsDO[] { con});

        }

        public void UpdateApConsStauts(string id_apcons)
        {
            OrdApConsDO cons = apvm.GetApConsById(id_apcons);
            cons.Id_su_cons = CiDictCodeConst.ID_CIDI_DYWSP;
            cons.Sd_su_cons = CiDictCodeConst.SD_CIDI_DYWSP;
           cons.SetUpdated();
           apvm.Save(new OrdApConsDO[] { cons });
        }
        public void GetInviteCons(string id_invite)
        {
            inviteList.Clear();
            EmsItemInCons[] invites = inviteVM.GetInviteCons(id_invite);
            invites.ToList().ForEach(p => {
                p.Dt_response = CommonExtentions.NowTime(this);
                inviteList.Add(p); });
        }




    }
}
