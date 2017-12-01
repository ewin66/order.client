using System.Linq;
using iih.ci.ord.cirptpathgy.d;
using iih.ci.ord.cirptpathgy.i;
using iih.ci.ord.ordappathgy.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.engine;
using xap.rui.uipattern2.basemodel.card;

namespace iih.ci.ord.opippathgy.pathgy2.model
{
    class OpippathgyCardModel2 : NCardModel<CiRptPathgy>
    {

        private ICirptpathgyCrudService sevice;
        public OpippathgyCardModel2(BaseContext ctx)
            : base(ctx)
        {
            this.sevice = XapServiceMgr.find<ICirptpathgyCrudService>();
        }

        public override void LoadData(object cond = null)
        {


            if (cond is OrdApPathgyDTO)
            {
                var pdto = cond as OrdApPathgyDTO;
                CiRptPathgyDO[] cipat = this.sevice.find("a0.id_appathgy='" + pdto.Id_appathgy + "'", null, FBoolean.False);
                if(cipat!=null&&cipat.Count()>0)
                this.data = cipat[0];
            }
           
        }


    }
}
