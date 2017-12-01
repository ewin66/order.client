using System.Collections.Generic;
using System.Linq;
using iih.ci.ord.dto.blexorder.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.diagtreatview.viewmodel.bp
{
    public class SplitSrv8OrdBP
    {
        public FArrayList execN(TransSrvSplitOrderDTO[] srvsplits)
        {
            var fa = new FArrayList();

            var dicN = new Dictionary<string, Dictionary<string, List<TransSrvSplitOrderDTO>>>();
            var dict = new Dictionary<string, TransSrvSplitOrderDTO>();
            var dictmp = new Dictionary<string, TransSrvSplitOrderDTO>();
            //按服务划分
            if (srvsplits != null && srvsplits.Count() > 0)
            {
                foreach (TransSrvSplitOrderDTO splitOrderDto in srvsplits)
                {
                    //    string ss = splitOrderDto.Id_srv + "," + splitOrderDto.Id_or;
                    //长期医嘱 放入长期字典
                    if (splitOrderDto.Fg_long == FBoolean.True)
                    {
                        if (!dict.ContainsKey(splitOrderDto.Id_srv))
                        {
                            dict.Add(splitOrderDto.Id_srv, splitOrderDto);
                        }
                        else if (dict.ContainsKey(splitOrderDto.Id_srv))
                        {
                            TransSrvSplitOrderDTO sDto = dict[splitOrderDto.Id_srv];
                            if (sDto.Dt_effe.Value.CompareTo(splitOrderDto.Dt_effe.Value) > 0)
                            {
                                dict.Remove(splitOrderDto.Id_srv);
                                dict.Add(splitOrderDto.Id_srv, splitOrderDto);
                            }
                        }
                    }
                    //不在长期字典的临时医嘱 放入临时字典
                    if (splitOrderDto.Fg_long == FBoolean.False && !dict.ContainsKey(splitOrderDto.Id_srv))
                    {
                        if (!dictmp.ContainsKey(splitOrderDto.Id_srv))
                        {
                            dictmp.Add(splitOrderDto.Id_srv, splitOrderDto);
                        }
                        else
                        {
                            TransSrvSplitOrderDTO sDto = dictmp[splitOrderDto.Id_srv];
                            if (sDto.Dt_effe.Value.CompareTo(splitOrderDto.Dt_effe.Value) > 0)
                            {
                                dictmp.Remove(splitOrderDto.Id_srv);
                                dictmp.Add(splitOrderDto.Id_srv, splitOrderDto);
                            }
                        }
                    }

                    //将临时字典中已在长期字典的服务过滤
                    if (splitOrderDto.Fg_long == FBoolean.True)
                    {
                        if (dictmp.ContainsKey(splitOrderDto.Id_srv))
                        {
                            dictmp.Remove(splitOrderDto.Id_srv);
                        }
                    }


                    if (dicN.ContainsKey(splitOrderDto.Id_srv))
                    {
                        Dictionary<string, List<TransSrvSplitOrderDTO>> ordic = dicN[splitOrderDto.Id_srv];
                        if (ordic.ContainsKey(splitOrderDto.Id_or))
                        {
                            List<TransSrvSplitOrderDTO> listor = ordic[splitOrderDto.Id_or];
                            listor.Add(splitOrderDto);
                        }
                        else
                        {
                            var listor = new List<TransSrvSplitOrderDTO>();
                            listor.Add(splitOrderDto);
                            ordic.Add(splitOrderDto.Id_or, listor);
                        }
                    }
                    else
                    {
                        var ordic = new Dictionary<string, List<TransSrvSplitOrderDTO>>();
                        var list = new List<TransSrvSplitOrderDTO>();
                        list.Add(splitOrderDto);
                        ordic.Add(splitOrderDto.Id_or, list);
                        dicN.Add(splitOrderDto.Id_srv, ordic);
                    }
                }
            }
            fa.Insert(0, dicN);

            //按开立时间排序

            var orlist = new List<TransSrvSplitOrderDTO>();
            //长期医嘱
            foreach (string key in dict.Keys)
            {
                TransSrvSplitOrderDTO splitOrderDto = dict[key];

                bool flag = false;
                foreach (TransSrvSplitOrderDTO transSrvSplitOrderDto in orlist)
                {
                    if (transSrvSplitOrderDto.Dt_effe.Value.CompareTo(splitOrderDto.Dt_effe.Value) > 0)
                    {
                        flag = true;
                        orlist.Insert(orlist.IndexOf(transSrvSplitOrderDto), splitOrderDto);
                        break;
                    }
                }
                if (!flag)
                {
                    orlist.Add(splitOrderDto);
                }
            }
            //临时医嘱
            foreach (string key in dictmp.Keys)
            {
                TransSrvSplitOrderDTO splitOrderDto = dictmp[key];

                bool flag = false;
                foreach (TransSrvSplitOrderDTO transSrvSplitOrderDto in orlist)
                {
                    if (transSrvSplitOrderDto.Dt_effe.Value.CompareTo(splitOrderDto.Dt_effe.Value) > 0)
                    {
                        flag = true;
                        orlist.Insert(orlist.IndexOf(transSrvSplitOrderDto), splitOrderDto);
                        break;
                    }
                }
                if (!flag)
                {
                    orlist.Add(splitOrderDto);
                }
            }
            fa.Insert(1, orlist);
            //  fa.Add(orlist);
            return fa;
        }

        /*
         
                 public Dictionary<string, Dictionary<string, List<TransSrvSplitOrderDTO>>> exec(TransSrvSplitOrderDTO[] srvsplits)
        {
            var totaldic = new Dictionary<string, Dictionary<string, List<TransSrvSplitOrderDTO>>>();
            var dic = new Dictionary<string, List<TransSrvSplitOrderDTO>>();
            //按服务划分
            if (srvsplits != null && srvsplits.Count() > 0)
            {
                foreach (TransSrvSplitOrderDTO splitOrderDto in srvsplits)
                {
                    string ss = splitOrderDto.Id_srv + "," + splitOrderDto.Id_or;
                    if (dic.ContainsKey(splitOrderDto.Id_srv))
                    {
                        List<TransSrvSplitOrderDTO> list = dic[splitOrderDto.Id_srv];
                        list.Add(splitOrderDto);
                    }
                    else
                    {
                        var list = new List<TransSrvSplitOrderDTO>();
                        list.Add(splitOrderDto);
                        dic.Add(splitOrderDto.Id_srv, list);
                    }
                }
                //按医嘱划分
                foreach (string key in dic.Keys)
                {
                    var ordic = new Dictionary<string, List<TransSrvSplitOrderDTO>>();
                    List<TransSrvSplitOrderDTO> listsrv = dic[key];
                    foreach (TransSrvSplitOrderDTO splitOrderDto in listsrv)
                    {
                        if (ordic.ContainsKey(splitOrderDto.Id_or))
                        {
                            List<TransSrvSplitOrderDTO> list = ordic[splitOrderDto.Id_or];
                            list.Add(splitOrderDto);
                        }
                        else
                        {
                            var list = new List<TransSrvSplitOrderDTO>();
                            list.Add(splitOrderDto);
                            ordic.Add(splitOrderDto.Id_or, list);
                        }
                    }

                    totaldic.Add(key, ordic);
                }
            }
            return totaldic;
        }
         
         */
    }
}