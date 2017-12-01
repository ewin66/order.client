/************************************************************************ 
 * 项目名称 :  iih.ci.ord   
 * 项目描述 :  分方模型定义    
 * 类 名 称 :  SpltPrescriptionViewModel 
 * 版 本 号 :  v1.0.0.0  
 * 说    明 :      
 * 作    者 :  qzwang 
 * 修 改 人 :   
 * 创建时间 :  2016/6/30 13:50:05 
 * 更新时间 :  2016/6/30 13:50:05 
************************************************************************ 
 * Copyright @ 北大医信（IIH） 2016. All rights reserved. 
************************************************************************/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.i;
using xap.mw.serviceframework;
using iih.ci.ord.dto.ordpres.d;
using iih.en.pv.dto.d;
using iih.ci.ord.dicertificate.viewmodel;
using xap.sys.xbd.udi.d;
using iih.bd.bc.udi;

namespace iih.ci.ord.opemergency.model.spltpres
{
	/// <summary>
	/// 分方模型
	/// </summary>
	public class SpltPrescriptionViewModel : BaseBizViewModel
	{
		#region 私有成员变量
		private ICiOrdQryService iCiOrdQryService;

		public OrdPresDTO[] AllOrdPresDTOs;

		// 临时测试
		public List<OrdPresDTO> ListWestDrugOrdPresDTO{ get; set; }
        public List<OrdPresDTO> ListHerbalDrugOrdPresDTO { get; set; }

      
        public Dictionary<string, UdidocDO> DicPrestp;
		#endregion

       

        #region 父类继承区域
        public override void Init()
		{
			iCiOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
			ListWestDrugOrdPresDTO = new List<OrdPresDTO>();
			ListHerbalDrugOrdPresDTO = new List<OrdPresDTO>();

            
		}
		#endregion

		#region 业务处理区域
        /// <summary>
        /// 初始化处方类型
        /// </summary>
        private void InitPresTpInfo()
        {
            UdidocDO[] udidocDOs = Utils.GetUdidocDOList(CiDictCodeTypeConst.SD_PRESTP);
            DicPrestp = new Dictionary<string, UdidocDO>();
            if (null == udidocDOs)
            {
                return;
            }
            foreach (UdidocDO udidoc in udidocDOs)
            {
                DicPrestp.Add(udidoc.Code, udidoc);
            }
        }

        public void Clear()
        {
            this.ListWestDrugOrdPresDTO.Clear();
            this.ListHerbalDrugOrdPresDTO.Clear();
            this.SetEnt4BannerDTO(null);
        }

		/// <summary>
		/// 根据就诊 ID 加载处方
		/// </summary>
		/// <param name="id_ent"></param>
		/// <returns></returns>
		public bool Reload()
		{

            
            if (iCiOrdQryService != null && this.GetEnt4BannerDTO() != null)
		{
			this.ListWestDrugOrdPresDTO.Clear();
			this.ListHerbalDrugOrdPresDTO.Clear();
            InitPresTpInfo();

                AllOrdPresDTOs = iCiOrdQryService.getOrdPresInfo(GetEnt4BannerDTO().Id_ent);

				if (AllOrdPresDTOs == null)
					return false;

				// 区分出 西药 和 中药
				foreach (OrdPresDTO item in AllOrdPresDTOs)
				{
                    if (item.Presdrugs == null) continue;
					foreach (PresDrugDTO drug in item.Presdrugs)
					{
						if (drug.Sd_srvtp.StartsWith("0103"))
						{
							this.ListHerbalDrugOrdPresDTO.Add(item);
							break;
						}
						else
						{
							this.ListWestDrugOrdPresDTO.Add(item);
							break;
						}
					}
				}
				return true;
			}
			return false;
		}
		
        public XapDataList<PresDrugDTO> GetPresDrugDataSource(OrdPresDTO presDto)
		{
            if (presDto == null)
                return null;
            XapDataList<PresDrugDTO> items = new XapDataList<PresDrugDTO>();
            foreach (PresDrugDTO item in presDto.Presdrugs)
            {
                items.Add(item);
            }
            return items;
		}

		//获取西药处方相关信息
		public string GetWestDrugCaption(OrdPresDTO presDto)
		{
			if (presDto != null)
			{
				string strCaption = String.Format(" 处方号:{0}", presDto.Code);
				strCaption += String.Format("  处方类型:{0}", presDto.Name_prestp);
				strCaption += String.Format("  金额:{0}元", getPressItemsTotalPrice(presDto));
                strCaption += String.Format("  取药地点:{0}", presDto.Name_dep_mp);
				strCaption += String.Format("  医生:{0}", presDto.Name_emp_or);
				return strCaption;
			}
			return "";
		}

        private Double getPressItemsTotalPrice(OrdPresDTO opd)
        {
            if (null == opd)
                return 0;
            Double totalPrice = 0;
            foreach (PresDrugDTO drug in opd.Presdrugs)
            {
                if (null != drug.Quan_cur && drug.Price != null)
                    totalPrice += drug.Quan_cur.Value * drug.Price.Value;
            }
            return totalPrice;
        }

		//获取中药处方相关信息
		public string GetHerbalDrugCaption(OrdPresDTO presDto)
		{
			string strCaption = GetWestDrugCaption(presDto);
			if (strCaption.Length > 0)
                strCaption += String.Format(" 草药剂数:{0}", presDto.Presdrugs.Count);
			return strCaption;
		}
        #endregion

        #region 处方打印
        //普通西药
		public string GetWestDrugPresIds()
		{
			string ids = "";
			foreach (OrdPresDTO presDto in ListWestDrugOrdPresDTO)
			{
				if (presDto.Sd_prestp != "00")
				{
					ids += string.Format("'{0}',", presDto.Id_pres);
				}
			}
		   
			if(ids.Length > 0)
			{
				ids=ids.Substring(0,ids.Length - 1);
			}
			return ids;
		}
		//中药
		public string GetHerbDrugPresIds()
		{
			string ids = "";
			foreach (OrdPresDTO presDto in ListHerbalDrugOrdPresDTO)
			{
				 ids += string.Format("'{0}',", presDto.Id_pres);
			}
			
            if (ids.Length > 0)
            {
                ids = ids.Substring(0, ids.Length - 1);
            }
            return ids;
		}
		//毒麻、精一
		public string GetPoisPresIds()
		{
			string ids = "";
			foreach (OrdPresDTO presDto in ListWestDrugOrdPresDTO)
			{
				if (presDto.Sd_prestp == "00")
				{
					ids += string.Format("'{0}',", presDto.Id_pres);
				}
			}
			
            if (ids.Length > 0)
            {
                ids = ids.Substring(0, ids.Length - 1);
            }
           
            return ids;
		}
		#endregion

	}
}
