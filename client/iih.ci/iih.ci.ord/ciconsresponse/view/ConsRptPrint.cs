using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.cior.d;
using iih.ci.ord.cior.i;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.consrpt.d;
using iih.ci.ord.consrpt.i;
using iih.en.pv.dto.d;
using xap.dp.optdesigner.Print.BatPrtContent;
using xap.dp.optdesigner.UI;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.control.extentions;

/********************************************************************************

** 作者： 刘晓颖

** 创始时间：2016/8/03

** 修改人：刘晓颖

** 修改时间：2016/8/03

** 描述：会诊记录打印

*********************************************************************************/
namespace iih.ci.ord.ciconsresponse.view
{
    class ConsRptPrint
    {
        private Ent4BannerDTO ent4BannerDTO;
        private CiOrdConsRptDO rptDO;
        //private OrdApConsDO consDO;
        //private CiordInviteConsDO inviteDO;
        private CiorappconsultAggDO aggDo;
        private CiOrderDO ciOrderDO;
        private ICiorderMDOCrudService ciordService;
        //private IConsrptCrudService rptService;



        public ConsRptPrint(Ent4BannerDTO dto, CiorappconsultAggDO aggdo,CiOrdConsRptDO rptDo)
        {
            this.ent4BannerDTO = dto;
            this.aggDo = aggdo;
            this.rptDO = rptDo;
            this.ciordService = XapServiceMgr.find<ICiorderMDOCrudService>();
            //this.rptService = XapServiceMgr.find<IConsrptCrudService>();
            //this.ciOrderDO = ciorder;
        }

        //打印   ent4bannerdto,ciordconsrptdo,ordapconsdo,ciorder
        public void ToPrint()
        {
            if (this.ent4BannerDTO == null || this.aggDo == null) return;
            List<BaseDO> lstDataSources = new List<BaseDO>();
            this.ciOrderDO = this.ciordService.findById(aggDo.getParentDO().Id_or);
            //this.rptDO = this.rptService.find(" id_id_apcons='" + aggDo.getParentDO().Id_apcons+ "'", null, null)[0];

            lstDataSources.Add(this.ent4BannerDTO);
            lstDataSources.Add(this.rptDO);
            lstDataSources.Add(this.aggDo.getParentDO());
            lstDataSources.Add(this.ciOrderDO);

            TemplAndDataLogicAssist prtLogic = new TemplAndDataLogicAssist();
            bool clearData = true;
            bool res = prtLogic.loadPrtTempl("461020", "会诊记录打印");
            if (!res)
            {
                this.ShowAlert(prtLogic.getLastErrMsg());
                return;
            }

            res = prtLogic.loadPrtDataAsAgg(lstDataSources.ToArray(), this.aggDo.getCiordInviteConsDO(),new PrtDORowsAssist(0), clearData);
            if (!res)
            {
                this.ShowAlert(prtLogic.getLastErrMsg());
                return;
            }
            clearData = false;
            //prtLogic.loadPrtDataSingle(ent4BannerDto);
            //prtLogic.loadPrtDataAsAgg(ent4BannerDto, lstDOs.ToArray(), true);
            //prtLogic.loadPrtDataBatch(lstDOs.ToArray());
            prtLogic.doPrint(true);
            clearData = true;
            //prtLogic.doPrint(true);

        }
    }
}
