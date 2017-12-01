using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.common.util
{
    public class IdChecker
    {
        public static bool CheckIDCard(string Id)
        {
            if (string.IsNullOrEmpty(Id)) {
                return false;
            }
            switch (Id.Length)
            {
                case 18:
                {

                    bool check = CheckIdCard18(Id);

                    return check;

                }
                case 15:
                {

                    bool check = CheckIdCard15(Id);

                    return check;

                }
                default:
                    return false;
            }
        }


        private static bool CheckIdCard18(string Id)
        {

            long n = 0;

            if (long.TryParse(Id.Remove(17), out n) == false || n < Math.Pow(10, 16) || long.TryParse(Id.Replace('x', '0').Replace('X', '0'), out n) == false)
            {

                return false;//数字验证

            }

            string address = "11x22x35x44x53x12x23x36x45x54x13x31x37x46x61x14x32x41x50x62x15x33x42x51x63x21x34x43x52x64x65x71x81x82x91";

            if (address.IndexOf(Id.Remove(2), StringComparison.Ordinal) == -1)
            {

                return false;//省份验证

            }

            string birth = Id.Substring(6, 8).Insert(6, "-").Insert(4, "-");

            DateTime time;

            if (!DateTime.TryParse(birth, out time))
            {

                return false;//生日验证

            }

            string[] arrVarifyCode = ("1,0,x,9,8,7,6,5,4,3,2").Split(',');

            string[] Wi = ("7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2").Split(',');

            char[] Ai = Id.Remove(17).ToCharArray();

            int sum = 0;

            for (int i = 0; i < 17; i++)
            {

                sum += int.Parse(Wi[i]) * int.Parse(Ai[i].ToString());

            }

            int y = -1;

            Math.DivRem(sum, 11, out y);

            if (arrVarifyCode[y] != Id.Substring(17, 1).ToLower())
            {

                return false;//校验码验证

            }

            return true;//符合GB11643-1999标准

        }



        private static bool CheckIdCard15(string Id)
        {

            long n = 0;

            if (long.TryParse(Id, out n) == false || n < Math.Pow(10, 14))
            {

                return false;//数字验证

            }

            string address = "11x22x35x44x53x12x23x36x45x54x13x31x37x46x61x14x32x41x50x62x15x33x42x51x63x21x34x43x52x64x65x71x81x82x91";

            if (address.IndexOf(Id.Remove(2), StringComparison.Ordinal) == -1)
            {

                return false;//省份验证

            }

            string birth = Id.Substring(6, 6).Insert(4, "-").Insert(2, "-");

            DateTime time;

            return DateTime.TryParse(birth, out time);
        }
    }
}
