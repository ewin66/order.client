using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.control.preload;

namespace iih.ci.ord.preloader
{
    public class DoctorStationPreloaderContainer : PreloadFuncletContainerBase
    {
        protected override IEnumerable<IPreloader> CreatePreloaders()
        {
            List<IPreloader> ls = new List<IPreloader>();
            ls.Add(new OpUIPreloader());
            return ls;
        }

        protected override void OnUserLogin(ISession session)
        {
            base.OnUserLogin(session);
        }
    }
}
