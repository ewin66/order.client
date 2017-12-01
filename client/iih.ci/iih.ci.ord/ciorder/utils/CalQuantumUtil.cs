using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord_stub.i;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
namespace iih.ci.ord.ciorder.utils
{
    /// <summary>
    /// 计算医嘱总量的工具类，总次数和总量
    /// </summary>
    class CalQuantumUtil
    {
        private static CalQuantumUtil calQuantumUtil = null;
        private static ICiOrdMaintainService mainService = null;
        private CalQuantumUtil() { }
        public static CalQuantumUtil GetInstance() {
            if (calQuantumUtil == null) {
                calQuantumUtil = new CalQuantumUtil();
                mainService = XapServiceMgr.find<ICiOrdMaintainService>();
            }
            return calQuantumUtil;
        }
        /// <summary>
        /// 计算医嘱的总次数
        /// </summary>
        /// <param name="id_freq"></param>
        /// <param name="Use_days"></param>
        /// <returns></returns>
        public int getTotalTimes(string id_freq, int? Use_days)
        {
            if (Use_days == null||string.IsNullOrEmpty(id_freq)) return 0;
            return mainService.getTotalTimes(id_freq,(int)Use_days);
        }
        /// <summary>
        /// 非物品类型计算总量
        /// </summary>
        /// <param name="quan_medu"></param>
        /// <param name="times_cur"></param>
        /// <returns></returns>
        public double getUnMMQuantum(double? quan_medu, int? times_cur)
        {
            if (quan_medu == null || times_cur == null) return 0;
            return (double)quan_medu * (int)times_cur;
        }
        /// <summary>
        /// 物品类型的计算总量
        /// </summary>
        /// <param name="code_entp"></param>
        /// <param name="fg_pres_outp"></param>
        /// <param name="times"></param>
        /// <param name="id_mm"></param>
        /// <param name="id_unit_sale"></param>
        /// <param name="quan_medu"></param>
        /// <returns></returns>
        public FDouble getMMQuantum(string code_entp, FBoolean fg_pres_outp, int times, string id_mm, string id_unit_sale, FDouble quan_medu)
        {
           return mainService.getMMQuantum(code_entp,fg_pres_outp,times,id_mm,id_unit_sale,quan_medu);
        }
       /// <summary>
       /// 物品计算的核心算法
       /// </summary>
       /// <param name="sd_mupakgu"></param>
       /// <param name="quan_medu"></param>
       /// <param name="factor_mb"></param>
       /// <param name="factor"></param>
       /// <param name="times"></param>
       /// <returns></returns>
        public FDouble getMMQuantum(string sd_mupakgu, FDouble quan_medu, FDouble factor_mb, FDouble factor, int? times)
        {
            if (string.IsNullOrEmpty(sd_mupakgu) || quan_medu == null || factor_mb == null || factor == null || times==null) return 0;
		    // 按次取整
		    if (sd_mupakgu.Equals("0")) {
			    return Math.Ceiling(quan_medu/(factor_mb*factor)) * times;
		    }
		    // 按批取整
		    else if (sd_mupakgu.Equals("1")) {
                return Math.Ceiling(quan_medu * times/(factor_mb * factor));
		    }
		    // 不取整
		    else if (sd_mupakgu.Equals("4")) {
			    return quan_medu*(times)/((factor_mb*(factor)));
		    }
            return null;
	    }
        /// <summary>
        /// 计算药品领量天数
        /// </summary>
        /// <param name="sd_opmutp">药品的取整模式</param>
        /// <param name="quan_cur">总量</param>
        /// <param name="quan_medu">剂量</param>
        /// <param name="factor">换算系数</param>
        /// <param name="factor_mb">医基换算系数</param>
        /// <param name="id_freq">频次</param>
        /// <returns></returns>
        public int? getDaysAvalidate(string sd_opmutp, FDouble quan_cur, FDouble quan_medu, FDouble factor, FDouble factor_mb, String id_freq)
        {
            if (quan_cur == null || quan_medu == null || factor == null || factor_mb == null || id_freq == null)
                return null;
            return mainService.getDaysAvalidate(sd_opmutp, quan_cur, quan_medu, factor, factor_mb, id_freq);
        }
    }
}
