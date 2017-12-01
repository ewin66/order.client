using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.cidiag.i;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.i;
using xap.cli.sdk.form;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.idvproperty.d;
using iih.ci.ord_stub.i;
using iih.en.pv.entdi.d;
using iih.en.pv.entdi.i;
using xap.rui.appfw;
using xap.rui.control.extentions;
using xap.rui.control.query.i;
using iih.ci.ord.i;
using System;
using iih.ci.ord.ems.d;
using iih.ci.ord.common.utils;
using iih.en.pv.dto.d;
using xap.mw.serviceframework.ex;
using xap.rui.engine;
using iih.ci.ord.ciord.d;
using iih.ci.ord.ciorder.cards.drugext.dialogform;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.ciorder.viewmodel;

namespace iih.ci.ord.takedrug4outhosp.viewmodel
{
    /// <summary>
    /// 医嘱项目
    /// </summary>
    /// Author:admin
    /// Date:2015-08-31
    internal class TakeDrugOutItemViewModel : OrderItemViewModel
    {
        public TakeDrugOutItemViewModel(string id_en, Ent4BannerDTO ent4BannerDto, BaseContext Context)
            : base(ent4BannerDto,Context)
        {
        }
        protected override string getSearchSql()
        {
            return string.Format("a0.id_en='{0}' and a0.code_entp='{1}' and a0.FG_PRES_OUTP='Y' ", id_en, code_entp);
        }
    }
}
