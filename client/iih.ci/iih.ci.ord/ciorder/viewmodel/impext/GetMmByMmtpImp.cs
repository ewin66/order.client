using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;

namespace iih.ci.ord.ciorder.viewmodel.impext
{
    class GetMmByMmtpImp
    {
        ICiOrdQryService service;
        public GetMmByMmtpImp()
        {
            service = XapServiceMgr.find<ICiOrdQryService>();
        }


        //public XapDataList<EmsItemInOp> GetMmByMmtp(string id_mmtp)
        //{
        //    XapDataList<EmsItemInOp> list = new XapDataList<EmsItemInOp>();
        //    EmsOrDrug[] mms = service.getMmByMmtp(id_mmtp);
        //    mms.ToList().ForEach(p => list.Add(

        //        new EmsItemInOp
        //        {
        //            //Id_oropitem = p,	       //主键	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 	 
        //            Id_mm = p.Id_mm,	           //物品id	REF	医疗物品_基本信息	20	医疗 	 	
        //            Name_mm = p.Name_mm,	           //物品名称	SINGLE	String	50	 	 	 
        //            Id_mmtp = p.Id_mmtp,	           //物品类型id	REF	医疗物品类型_自定义档案	 	 			 	 	 	
        //            Sd_mmtp = p.Sd_mmtp,	           //物品类型编码	SINGLE	String	50	 	 	
        //            Name_mmtp = p.Name_mmtp,	       //物品类型	SINGLE	String	50	 	 	 
        //            Spec = p.Spec_mm,	           //规格	SINGLE	String	50	 	 	 
        //            //Id_sup = p,	           //厂商id	REF	医疗物品_供应商与厂商	20	 	 	 	 	
        //            Name_sup = p.Vender,	       //厂商	SINGLE	String	50	 	 	 
        //            Price = p.Price,	           //单价	SINGLE	FDouble	16	 	 	 
        //            Quan_cur = p.Quan_cur,	       //数量	SINGLE	Integer	10	 	 	 
        //            Id_unit_pkgsp = p.Id_unit_med,	   //零售包装单位id	REF	医疗物品_包装单位类 	 	 	 	
        //            Name_unit_pkgsp = p.Name_unit_med	   //零售包装单位	SINGLE	String	50	 	 	
        //            //Sortno	           //排序	SINGLE	Integer	10	 	 	 
        //            //Code_srv	       //手术 编码(code_srv)	SINGLE	String	 	 	 	
        //            //Id_srv	           //手术id（id_srv）	REF	医疗服务	20	医疗 	 	
        //            //Name_srv	       //手术名称	SINGLE	String	50	 	 	 
        //            //Des_op	           //手术描述
        //        }
        //         ));
        //    return list;

        //}

        public XapDataList<EmsOrDrug> GetMmByMmtp(string id_mmtp)
        {
            XapDataList<EmsOrDrug> list = new XapDataList<EmsOrDrug>();
            EmsOrDrug[] mms = service.getMmByMmtp(id_mmtp);
            mms.ToList().ForEach(p=>{  list.Add(p);});
            return list;
        }
       

    }
}
