using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.freqdef.d;
using iih.bd.srv.freqdef.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ordsrvdose.i;
using xap.mw.serviceframework;
using iih.ci.ord.ordsrvdose.d;
using xap.rui.appfw;

namespace iih.ci.ord.ciorder.viewmodel
{
    /// <summary>
    /// 变动用药 
    /// </summary>
    /// Author:admin
    /// Date:2015-08-28
    class OrderSrvDoseViewModel
    {
        IOrdsrvdoseCrudService service;
        private IFreqdefCrudService freqService;
        OrdSrvDoseDO[] srvDoseDOs;
        public OrderSrvDoseViewModel()
        {
            service= XapServiceMgr.find<IOrdsrvdoseCrudService>();
            freqService = XapServiceMgr.find<IFreqdefCrudService>();
        }
        public OrdSrvDoseDO[] GetSrvDose(string id_orsrv, string id_or)
        {
            if (string.IsNullOrEmpty(id_orsrv)||string.IsNullOrEmpty(id_or))return null;
       srvDoseDOs = service.find(string.Format("id_orsrv='{0}' and id_or='{1}'", id_orsrv, id_or), "", false);
            return srvDoseDOs;
        }

        public void Save(OrdSrvDoseDO[] srvDose)
        {
            service.delete(srvDoseDOs);
            service.save(srvDose);
        }

        public void Delete()
        {
            if (srvDoseDOs!=null)
            service.delete(srvDoseDOs);
        }



        /// <summary>
        /// 根据频次获取变动用药关联的频次时间
        /// </summary>
        /// <param name="freqid">The freqid.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-09-14
        //public DrugChangeDTO[] GetTime(string freqid)
        //{
        //    List<DrugChangeDTO> changes=new List<DrugChangeDTO>();
        //    if (freqid==null)
        //    {
        //        return changes.ToArray();
        //    }

        //    FreqTimeDO[] tiems = this.freqService.findById(freqid).getFreqTimeDO();
        //    foreach (FreqTimeDO freqtime in tiems)
        //    {
        //        DrugChangeDTO change=new DrugChangeDTO();
        //        change.Time = freqtime.Time_mp.Value.ToString("hh:mm");
        //        changes.Add(change);
        //    }
        //    return changes.ToArray();
        //}
        public XapDataList<EmsOrDrug> GetDrugDose(string freqid, string id_orsrv, string id_or)
        {
            XapDataList<EmsOrDrug> changeList = new XapDataList<EmsOrDrug>();
            if (freqid == null)
            {
                return changeList;
            }

            FreqdefAggDO freqAgg = this.freqService.findById(freqid);



            OrdSrvDoseDO[] srvDoses = GetSrvDose(id_orsrv, id_or); //判断一下是否已经存储过频次了 如果 有的话 赋值一下
            if (freqAgg != null && freqAgg.getFreqTimeDO() != null)
            {

            
             FreqTimeDO[] times =  freqAgg.getFreqTimeDO();

            //if (srvDose.Length>0)
            //{

            //}

            //if (times == null) return changeList;
            times.ToList().ForEach(p =>
            {
                OrdSrvDoseDO srvDose = new OrdSrvDoseDO();
                if (srvDose == null) srvDose = new OrdSrvDoseDO();
                if (srvDoses != null)
                    srvDose = srvDoses.FirstOrDefault(x => x.Id_freqtime == p.Time_mp.Value.ToString("HH:mm"));

                changeList.Add(new EmsOrDrug
                {
                    Id_emsordrug = srvDose.Id_orsrvdose,
                    //Name_srv 			 	 	 	 	 	 				 	 			 	 	 	
                    //Id_mm ,//物品id	 	 	 				 	 			 	 	 	
                    //Name_mm 	 	 			 	 	 	
                    //Spec_mm  	 	 				 	 			 	 	 	
                    Quan_med = (srvDose == null ? 0 : srvDose.Quan_dose), //剂量	   
                    //Id_unit_med	   
                    //Name_unit_med //剂量单位 从药品带过来的
                    //Quan_base	   //单次数量 从接口
                    //Id_unit_base	 
                    //Name_unit_base // 数量单位  从接口
                    //Id_haeth	   
                    //Name_heath	   
                    //Price	       
                    //Vender	       
                    //Limit	       
                    //Fact_count     
                    //Des	           
                    //Id_freqtime    
                    Name_freqtime = p.Time_mp.Value.ToString("HH:mm"), //医嘱频次
           
                    //Sortno
                    //Sv=srvDose.Sv
                });
            });
            return changeList;
        }
            changeList.Add(new EmsOrDrug());
            return changeList;
        }
    }
}
