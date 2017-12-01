using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.bd.srv.medsrv.d;

namespace iih.ci.ord.ciorder.viewmodel
{
    class OrderDrugDesViewModel
    {
        public OrderDrugDesViewModel()
        {
        }

        public string GetDrugDes(string id_srv)
        {
           StringBuilder strDes=new StringBuilder();
             MedSrvDrugDO des =  new GetSrvDrugPropImp().GetMedSrvDrupProp(id_srv);
           if (des!=null)
           {
               
               //strDes.AppendFormat("{0}说明书|\r\n",des.Name_chem);

               //strDes.AppendFormat("[药品名称] {0}\r\n", des.Name_chem);
               //strDes.AppendFormat("[剂型] {0}\r\n",des.Ds_name);
               //
               //strDes.AppendFormat("[价值分类] {0}\r\n",des.Name_val);
               //strDes.AppendFormat("[药理分类] {0}\r\n", des.Name_pharm);
               strDes.AppendFormat("[毒麻分类] {0}\r\n",des.Name_pois);
               strDes.AppendFormat("[抗菌药分类] {0}\r\n",des.Name_anti);
               strDes.AppendFormat("[适应症]\r\n {0}\r\n", des.Indica);
               strDes.AppendFormat("[禁忌症]\r\n {0}\r\n", des.Constr);
               //strDes.AppendFormat("[药品主要作用及用法]\r\n {0}\r\n", des.Guide);
               strDes.AppendFormat("[不良反应] \r\n{0}\r\n", des.React);
               strDes.AppendFormat("[用法用量] \r\n{0}\r\n", des.Usage);
               strDes.AppendFormat("[注意事项] \r\n{0}\r\n", des.Precaut);
               strDes.AppendFormat("[相互作用] \r\n{0}\r\n", des.Interact);


           }else
           {
               strDes.Append("数据库没有维护说明书");
           }

           return  strDes.ToString();
       
        }


       


    }


   
}
