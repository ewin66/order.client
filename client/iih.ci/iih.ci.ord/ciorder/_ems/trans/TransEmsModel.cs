using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.cards;
using iih.ci.ord.ems.d;
using iih.ci.ord.i;
using xap.mw.core.data;
using xap.mw.serviceframework;
using iih.bd.srv.medsrv.d;

namespace iih.ci.ord.ciorder._ems.trans {
    /// <summary>
    /// 转科医疗单模型类
    /// 
    /// author:刘晓颖，zhou_zhijian li_zheng
    /// </summary>
    public class TransEmsModel : EmsModelBase {
        /// <summary>
        /// 
        /// </summary>
        private ICiOrdQryService service;
        /// <summary>
        /// 实际的模型数据（是DTO）
        /// </summary>
        //private TransEmsDataCarrier data;



        public TransEmsModel() {
            service = XapServiceMgr.find<ICiOrdQryService>();
        }

        /// <summary>
        /// 基于部门ID获取对应的护理病区
        /// </summary>
        /// <param name="id_dep"></param>
        /// <returns></returns>
        public string getNurAreaOfDep(string id_dep) {
            return service.getNurAreaOfDep(id_dep);
        }

        /// <summary>
        /// 用外部数据填充UI载体数据对象
        /// </summary>
        /// <param name="order"></param>
        /// <param name="srv"></param>
        //public void Load(CiEmsDTO dto, MedSrvDO med) {
        //    if (status == DOStatus.NEW) { //新建
        //        orDataBing.AddCommonHeadDataBing(emsDO, med); //emsDO=data
        //        orDataBing.AddTransDataBing(emsDO, med);
        //        emsDO.MedSrvDO = med;
        //    }
        //    else { //打开医嘱的情况
        //        orCiEmsToUiEms.EditEmsTrans(emsDO, dto);
        //    }
        //}

        /// <summary>
        /// 新建模式下，加载模型
        /// </summary>
        /// <param name="med"></param>
        public void Load4New(MedSrvDO med) {
            this.AddTransDataBing();
            //data.MedSrvDO = med;
        }

        /// <summary>
        /// 打开模式下，加载模型
        /// 触发模式：双击医嘱列表后触发的
        /// </summary>
        /// <param name="ciDto"></param>
        public void Load4Open(CiEmsDTO ciDto) {
            //orCiEmsToUiEms.EditEmsTrans(emsDO, dto);
        }

        /// <summary>
        /// 将模型中的数据存储到后台DTO中
        /// </summary>
        public void Save() {
            
        }

        #region 私有函数
        
        /// <summary>
        /// 
        /// </summary>
        private void AddTransDataBing() {
            //data.Emsaptrans.Id_dep_from = this.patDto.Id_dep_phy;
            //data.Emsaptrans.Id_dep_nur_from = this.patDto.Id_dep_nur;
            //data.Emsaptrans.Dt_trans_apply = this.commonLogic.GetServerDataTime();
        } 

        #endregion



    }
}


