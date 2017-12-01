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
using iih.ci.ord.opemergency.model.spltpres;

namespace iih.ci.ord.takedrug4outhosp.viewmodel
{
	/// <summary>
	/// 分方模型
	/// </summary>
	public class TackDrugOutSpltPrescriptionViewModel : SpltPrescriptionViewModel
	{
		#region 私有成员变量
		private ICiOrdQryService iCiOrdQryService;

		private OrdPresDTO[] szOrdPresDTO;

		// 临时测试
		private List<OrdPresDTO> listWestDrugOrdPresDTO;
		private List<OrdPresDTO> listHerbalDrugOrdPresDTO;
		#endregion

		#region 构造方法
        public TackDrugOutSpltPrescriptionViewModel(String id_ent)
            : base(id_ent) { }

		#endregion

		#region 私有方法
		public override void Init()
		{
			iCiOrdQryService = XapServiceMgr.find<ICiOrdQryService>();
			listWestDrugOrdPresDTO = new List<OrdPresDTO>();
			listHerbalDrugOrdPresDTO = new List<OrdPresDTO>();

			if (GetEnt4BannerDTO() != null)
				this.Reload(GetEnt4BannerDTO().Id_ent);
		}

		public override object GetTableDataSource()
		{
			return listWestDrugOrdPresDTO;
		}

		public override object GetFormDataSource()
		{
			return listHerbalDrugOrdPresDTO;
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
		private XapDataList<PresDrugDTO> FromOrdPresDTO(OrdPresDTO ordPress)
		{
			if (ordPress == null)
				return null;
			XapDataList<PresDrugDTO> items = new XapDataList<PresDrugDTO>();
			foreach (PresDrugDTO item in ordPress.Presdrugs)
			{
				items.Add(item);
			}
			return items;
		}
		#endregion

		#region 共有接口
		/// <summary>
		/// 根据就诊 ID 加载处方
		/// </summary>
		/// <param name="id_ent"></param>
		/// <returns></returns>
		public bool Reload(string id_ent)
		{
			this.listWestDrugOrdPresDTO.Clear();
			this.listHerbalDrugOrdPresDTO.Clear();
            if (iCiOrdQryService != null && id_ent != null)
			{
				szOrdPresDTO = iCiOrdQryService.getOrdPresInfo(id_ent);

				if (szOrdPresDTO == null)
					return false;

				// 区分出 西药 和 中药
				foreach (OrdPresDTO item in szOrdPresDTO)
				{
                    if (item.Presdrugs == null) continue;
					foreach (PresDrugDTO drug in item.Presdrugs)
					{
						if (drug.Sd_srvtp.StartsWith("0103"))
						{
							this.listHerbalDrugOrdPresDTO.Add(item);
							break;
						}
						else
						{
							this.listWestDrugOrdPresDTO.Add(item);
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
			return FromOrdPresDTO(presDto);
		}
		#endregion

		#region 获取西药处方相关信息
		public OrdPresDTO GetWestOrdPresDTO(int index)
		{
			if (index < 0 || index >= listWestDrugOrdPresDTO.Count)
				return null;

			return this.listWestDrugOrdPresDTO.ElementAt(index);
		}

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

		public int GetWestOrdPresCount()
		{
			if (listWestDrugOrdPresDTO == null)
				return 0;
			return listWestDrugOrdPresDTO.Count;
		}

		#endregion

		#region 获取中药处方相关信息
		public int GetHerbalOrdPresCount()
		{
			if (listHerbalDrugOrdPresDTO == null)
				return 0;

			return listHerbalDrugOrdPresDTO.Count;
		}

		public OrdPresDTO GetHerbalOrdPresDTO(int index)
		{
			if (index < 0 || index >= this.listHerbalDrugOrdPresDTO.Count)
				return null;

			return this.listHerbalDrugOrdPresDTO.ElementAt(index);
		}

		public string GetHerbalDrugCaption(OrdPresDTO presDto)
		{
			string strCaption = GetWestDrugCaption(presDto);
			if (strCaption.Length > 0)
				strCaption += String.Format(" 草药剂数：{0}", presDto.Presdrugs.Count);
			return strCaption;

		}

		#endregion

		#region 处方打印
		//普通西药
		public string GetWestDrugPresIds()
		{
			string ids = "";
			foreach (OrdPresDTO presDto in listWestDrugOrdPresDTO)
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
			foreach (OrdPresDTO presDto in listHerbalDrugOrdPresDTO)
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
			foreach (OrdPresDTO presDto in listWestDrugOrdPresDTO)
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
