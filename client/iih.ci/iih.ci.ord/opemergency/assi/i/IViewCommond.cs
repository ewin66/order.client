using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.assi.i
{
	public interface IViewCommond
	{
        void saveData();
        void close();
        object getSaveData();
	}
}
