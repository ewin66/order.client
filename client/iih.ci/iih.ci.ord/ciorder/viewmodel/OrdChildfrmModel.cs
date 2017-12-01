using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.srvortpl.d;
using iih.bd.srv.srvortpl.i;
using iih.bd.srv.srvortplitem.d;
using iih.bd.srv.srvortplitem.i;
using iih.ci.ord.dto.ordinput.d;
using iih.ci.ord.i;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.cli.context.token;

namespace iih.ci.ord.ciorder.viewmodel
{
    /*

* ==============================================================================
*
* Filename: 树伟
* Description: 
*
* Version: 1.0
* Created: 2015/11/19 15:59:58
* Compiler: Visual Studio 2010
*
* Author: 常树伟
* Company: 北大医信
*
* ==============================================================================
*/

    public class OrdChildfrmModel
    {
        private ICiOrdQryService qryService;
        private ISrvortplMDOCrudService tplService;
        private ISrvortplitemCrudService itemService;

        public OrdChildfrmModel()
        {
          
            qryService = XapServiceMgr.find<ICiOrdQryService>();
            tplService = XapServiceMgr.find<ISrvortplMDOCrudService>();
            itemService = XapServiceMgr.find<ISrvortplitemCrudService>();

        }

        /// <summary>
        /// 医嘱录入 b 画面 一级
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="id_doctor"></param>
        /// <returns></returns>
        public OrdInputDto[] getOrdInputDto(String id_ent, string id_doctor)
        {
            return qryService.getOrdInputDto(id_ent, id_doctor);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_emp"></param>
        /// <returns></returns>
        public SrvOrdTplDO[] getSrvOrdTplDO(string id_emp)
        {
            return tplService.find("a0.id_emp='"+id_emp+"'","",FBoolean.False);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id_tpl"></param>
        /// <returns></returns>
        public SrvOrTplItemDO[] getSrvOrTplItemDO(string id_tpl)
        {
           return  itemService.find("a0.id_srvortpl = '" + id_tpl + "'", "", FBoolean.False);
        }


    }
}
