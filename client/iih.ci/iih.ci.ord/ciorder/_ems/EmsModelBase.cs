using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciorder.utils;
using iih.en.pv.dto.d;
using xap.mw.core.data;

namespace iih.ci.ord.ciorder._ems {
    public class EmsModelBase {
        /// <summary>
        /// 医疗单数据的状态
        /// </summary>
        protected int status = DOStatus.UNCHANGED;
        /// <summary>
        /// 针对患者Banner上的患者信息的DTO
        /// </summary>
        protected Ent4BannerDTO patDto = null;
        /// <summary>
        /// 一些通用的业务逻辑处理类
        /// TODO:暂时的
        /// </summary>
        protected LogicEx commonLogic = LogicEx.GetInstance();

        #region 属性
        public int Status {
            get { return status; }
            set { status = value; }
        }

        public Ent4BannerDTO PatDto {
            get { return patDto; }
            set { patDto = value; }
        }

        #endregion

        //public void Load4New(MedSrvDO med) {
            
        //}
    }
}
