using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;
using iih.ci.ord.cior.i;
using xap.mw.serviceframework;
using xap.rui.appfw.collections;
using iih.ci.ord.cior.d;
using xap.rui.control.extentions;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.appfw;
using iih.ci.ord_stub.i;

namespace iih.ci.ord.ciblood.viewmodel
{
    class CiBloodCardViewModel
    {
        private ICiordrptbttestCrudService service;
        private ICiRptBtTestService _Service;
        private ICiOrdMaintainService iciOrdService;
        private ICiOrdBtTestItmDOCrudService itemService;
        private XapAggDO<CiordrptbttestAggDO> AggDo;
        public CiBloodCardViewModel(BaseContext baseContext)
        {
            this.service = XapServiceMgr.find<ICiordrptbttestCrudService>();
            this._Service = XapServiceMgr.find<ICiRptBtTestService>();
            this.itemService = XapServiceMgr.find<ICiOrdBtTestItmDOCrudService>();
            this.iciOrdService = XapServiceMgr.find<ICiOrdMaintainService>();

            CiordrptbttestAggDO CiAggDO = new CiordrptbttestAggDO();
            CiOrdBtTestDO CiDO = CiAggDO.Parent as CiOrdBtTestDO;
            CiDO.Dt_recheck = this.NowTime();
            CiDO.Id_emp_recheck = baseContext.PsnInfo.Id_psndoc;
            CiDO.Recheck_name = baseContext.PsnInfo.Name;
            this.AggDo = new XapAggDO<CiordrptbttestAggDO>(this.service, CiAggDO); 
        }

        public XapAggDO<CiordrptbttestAggDO> XapAggDO
        {
            get { return this.AggDo; }
        }

        public void Save()
        {
            CiOrdBtTestItmDO[] ItemDo = this.XapAggDO.Find(typeof(CiOrdBtTestItmDO).FullName) as XapDataList<CiOrdBtTestItmDO>;
            CiOrdBtTestDO CiDO = this.AggDo.Parent as CiOrdBtTestDO;
            for (int i = 0; i < ItemDo.Length;i++ )
            {
                ItemDo[i].Sortno = i+1;
            }
            this.AggDo.Save();
        }

        public void DataChanged(CiOrdBtTestDO ciRpDO, BaseContext baseContext)
        {
            if (ciRpDO.Applyformno == null)
            {
                return;
            }
            CiordrptbttestAggDO ciAggDO = this._Service.getRptBtTestByReqNo(ciRpDO.Applyformno);
            if (ciAggDO == null)
            {
                ciAggDO = new CiordrptbttestAggDO();
            }
            CiOrdBtTestDO CiDO = ciAggDO.Parent as CiOrdBtTestDO;
            if (CiDO.Id_rptbttest == null)
            {
                ciAggDO.Status = DOStatus.NEW;
                CiDO.Status = DOStatus.NEW;
            }
            else
            {
                ciAggDO.Status = DOStatus.UPDATED;
                CiDO.Status = DOStatus.UPDATED;
            }
            CiDO.No_applyform = ciRpDO.No_applyform;
            CiDO.Applyformno = ciRpDO.Applyformno;
            CiDO.Dt_recheck = this.NowTime();
            CiDO.Id_emp_recheck = baseContext.PsnInfo.Id_psndoc;
            CiDO.Recheck_name = baseContext.PsnInfo.Name;
            CiDO.SetUpdated();
            //this.AggDo = new XapAggDO<CiordrptbttestAggDO>(this.service, ciAggDO);
            this.AggDo.Replace(ciAggDO);
        }

        public CiOrdBtTestItmDO[] checkBarcode_bb(CiOrdBtTestItmDO[] CiItemDo)
        {
            XapDataList<CiOrdBtTestItmDO> ItemDoList = new XapDataList<CiOrdBtTestItmDO>();
            for (int i = 0; i < CiItemDo.Length; i++)
            {
                CiOrdBtTestItmDO[] result = this.itemService.find("a1.ds = 0 and a1.barcode_bb ='" + CiItemDo[i].Barcode_bb + "'", "", new FBoolean(true));
                if (CiItemDo[i].Id_rptbttestitm == null && result.Length > 0)
                {
                    ItemDoList.Add(CiItemDo[i]);
                }
                if (CiItemDo[i].Id_rptbttestitm != null && result.Length > 1)
                {
                    ItemDoList.Add(CiItemDo[i]);
                }
            }
            return ItemDoList;
        }

        public string CiOrdSubmit(CiordrptbttestAggDO xapAggDO)
        {
            CiOrdBtTestDO ciOrdBtTestDo = xapAggDO.getParentDO();

            return null;//this.iciOrdService.UpdateApbtRemaining(ciOrdBtTestDo.Id_rptbttest);
        }
    }
}
