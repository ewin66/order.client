using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord_stub.cirptlab.d
{
    public class TextCardDataTest
    {
        private string name;
        private List<string> boxData;

        public string Name
        {
            get { return name; }
            set { this.name = value; }
        }

        public List<string> BoxData
        {
            get { return boxData; }
            set { this.boxData = value; }
        }

        public TextCardDataTest()
        {

        }

        public TextCardDataTest(string name, List<string> boxData)
        {
            this.name = name;
            this.boxData = boxData;
        }
    }
}
