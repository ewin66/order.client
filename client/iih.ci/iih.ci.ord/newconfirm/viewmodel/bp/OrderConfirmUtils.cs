using System;
using System.Drawing;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render;
using xap.cli.sdk.render.DoctorOrderCard;

namespace iih.ci.ord.newconfirm.viewmodel.bp
{
    public class OrderConfirmUtils
    {
        public static ConfirmEvent GetConfirmEvent(string uievent)
        {
            ConfirmEvent uiEvent = new ConfirmEvent();
            uiEvent.UIEVENT = uievent;
            return uiEvent;
        }

        public static void OrContentDisplay(XDataRow row)
        {
            if (row != null)
            {
                foreach (UserRender render in row.UserRenderList)
                {
                    if (render is DoctorOrderCard)
                    {
                        var card = render as DoctorOrderCard;
                        card.ConfigPath = "\\modules\\iihci\\ui\\commoncontent\\OrderContent.xml";
                    }
                }
            }
        }

        public static void SetDoctorCardColor(XDataRow row,Color col)
        {
            if (row == null) return;
            foreach (UserRender render in row.UserRenderList)
            {
                if (render is DoctorOrderCard)
                {
                    var card = render as DoctorOrderCard;
                    card.ForeColor = col;
                }
            }
        }



        public static void copydrug(AddFeeDTO fee1, AddFeeDTO fee2)
        {
            //  fee1.Id_emsordrug = fee2.Id_emsordrug;
            fee1.Id_srv = fee2.Id_srv;
            fee1.Id_orsrv = fee2.Id_orsrv;
            fee1.Name_srv = fee2.Name_srv;
            fee1.Id_mm = fee2.Id_mm;
            fee1.Name_mm = fee2.Name_mm;
            fee1.Spec_mm = fee2.Spec_mm;
            fee1.Quan_med = fee2.Quan_med;
            fee1.Id_unit_med = fee2.Id_unit_med;
            fee1.Name_unit_med = fee2.Name_unit_med;
            fee1.Quan_base = fee2.Quan_base;
            fee1.Quan_cur = fee2.Quan_base;
            fee1.Id_unit_sale = fee2.Id_unit_sale;
            fee1.Name_unit_sale = fee2.Name_unit_sale;
            fee1.Id_unit_base = fee2.Id_unit_base;
            fee1.Name_unit_base = fee2.Name_unit_base;
            fee1.Id_hp = fee2.Id_hp;
            // fee1.Name_hp = fee2.Name_hp;
            fee1.Price = fee2.Price;
            // fee1.Vender = fee2.Vender;
            fee1.Limit = fee2.Limit;
            //  fee1.Fact_count = fee2.Fact_count;
            //  fee1.Des = fee2.Des;
            // fee1.Id_freqtime = fee2.Id_freqtime;
            //  fee1.Name_freqtime = fee2.Name_freqtime;
            fee1.Sortno = fee2.Sortno;
            //   fee1.Sv = fee2.Sv;
            fee1.Factor_cb = fee2.Factor_cb;
            fee1.Factor_mb = fee2.Factor_mb;
            fee1.Id_boildes = fee2.Id_boildes;
            fee1.Name_boildes = fee2.Name_boildes;
            fee1.Id_dosage = fee2.Id_dosage;
            fee1.Sd_dosage = fee2.Sd_dosage;
            fee1.Id_pharm = fee2.Id_pharm;
            fee1.Sd_pharm = fee2.Sd_pharm;
            fee1.Id_pois = fee2.Id_pois;
            fee1.Sd_pois = fee2.Sd_pois;
            fee1.Id_anti = fee2.Id_anti;
            fee1.Sd_anti = fee2.Sd_anti;
            fee1.Id_mmtp = fee2.Id_mmtp;
            fee1.Sd_mmtp = fee2.Sd_mmtp;
            fee1.Name_mmtp = fee2.Name_mmtp;
            //  fee1.Pycode = fee2.Pycode;
            //  fee1.Fg_chk = fee2.Fg_chk;
            fee1.Id_freq = fee2.Id_freq;
            fee1.Name_freq = fee2.Name_freq;
            fee1.Amt_cur = fee2.Amt_cur;
            fee1.Id_dep = fee2.Id_dep;
            fee1.Name_dep = fee2.Name_dep;
            fee1.Id_unit_sale = fee2.Id_unit_sale;
            fee1.Name_unit_sale = fee2.Name_unit_sale;
            fee1.Code_mm = fee2.Code_mm;
            fee1.Id_val = fee2.Id_val;
            fee1.Sd_val = fee2.Sd_val;
            //  fee1.Id_antipsy = fee2.Id_antipsy;
            //  fee1.Sd_antipsy = fee2.Sd_antipsy;
            fee1.Fg_otc = fee2.Fg_otc;
            //   fee1.Sd_mupkgutp = fee2.Sd_mupkgutp;
            //   fee1.Str_unit_pkg_ids = fee2.Str_unit_pkg_ids;
            fee1.Fg_mm = fee2.Fg_mm;
            fee1.Sd_srvtp = fee2.Sd_srvtp;
            fee1.Code_srv = fee2.Code_srv;
            fee1.Id_srvtp = fee2.Id_srvtp;
            fee1.Id_srvca = fee2.Id_srvca;
            //    fee1.Sd_mmbind_ip = fee2.Sd_mmbind_ip;
            fee1.Id_primd = fee2.Id_primd;
            // fee1.Hpdes = fee2.Hpdes;
            fee1.Id_orsrvmm = fee2.Id_orsrvmm;
        }

        //public static void savedataadapter(AddFeeDTO fee1)
        //{
        //    fee1.Quan_total_medu
        //}
    }
}



