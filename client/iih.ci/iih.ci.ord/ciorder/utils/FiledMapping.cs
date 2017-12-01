using iih.bd.bc.udi;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ems.d;
using xap.mw.core.data;
using xap.rui.appfw;

/**
 * 
 * C#端的字段映射类
 *
 * 
**/
namespace iih.ci.ord.ciorder.utils
{
   public class FiledMapping
    {

       private static FiledMapping _instance;
       public static FiledMapping GetInstance()
        {
            if (_instance == null)
            {
                lock (typeof(FiledMapping))
                {
                    _instance = new FiledMapping();
                }
            }
            return _instance;
        }


       /// <summary>
       /// 检查医疗单的映射
       /// </summary>
       /// <param name="emsDO"></param>
       /// <param name="ciEmsDto"></param>
       public void ObsViewFieldMapping(EmsUIDTO emsDO, CiEmsDTO ciEmsDto,MedSrvDO medSrvs)
       {
           FMap2 map = (FMap2) ciEmsDto.Mapinfo;
           MedsrvAggDO medSrvAgg = null;
         
           if (map != null)
           {
               medSrvAgg = map["MedsrvAggDO"] as MedsrvAggDO;
              
           }
           emsDO.Emsapobs.Id_emsobs = "";	//检查申请单主键	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_orsrv = "";//医嘱服务id	 			 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_or = "";//	医嘱医疗单	  				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_srv = ciEmsDto.Id_srv;//	服务id	  				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Name_srv = ciEmsDto.Name;//	服务名称 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_srvtp = ciEmsDto.Id_srvtp;//	服务类型 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Name_srvtp = medSrvs.Srvtp_name;//_	服务类型名称 50	 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_obstp = "";//	检查类型id	REF	检查类型_自定义档案					 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Name_obstp = "";//	检查类型名称  				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.No_applyobs = ciEmsDto.Applyno;//	检查申请单号 20	 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Fg_urgent = false;//	加急标识 1	 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Fg_mp_bed = false;//	床旁执行标志 1	 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Dt_plan = ciEmsDto.Dt_begin;//	计划检查时间  				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_di = "";//	诊断id	REF 疾病诊断	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Name_diag = "";//	诊断	 			 	 	 	 	 	 				 	 			 	 	 	
           //emsDO.Emsapobs.Str_id_di = "";//	诊断编码拼接   	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Str_name_di = "";//	诊断名称拼接 50	 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Sd_pps = "";//	检查目的编码  	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_pps = "";//	检查目的  	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Name_pps = "";//	检查目的名称  	 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Des_pps = "";//	检查目的描述 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Des_sympsign = "";//	症状体征描述	 	 	 			 	 	 	
           emsDO.Emsapobs.Id_body = medSrvAgg.getMedSrvRisDO()[0].Id_body;// 	身体部位id	REF	部位编码_自定义档案	 		 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Sd_body	 = medSrvAgg.getMedSrvRisDO()[0].Sd_body;//身体部位编码 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Name_body = medSrvAgg.getMedSrvRisDO()[0].Name_body;//	身体部位名称  	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_su_obs = "";//	检查申请单状态 		 	 			 	 	 	
           emsDO.Emsapobs.Sd_su_obs = "";//	检查申请单编码 		 	 			 	 	 	
           emsDO.Emsapobs.Id_pos =  medSrvAgg.getMedSrvRisDO()[0].Id_pos;//;	身体体位id	REF	体位编码_自定义档案	 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Sd_pos = medSrvAgg.getMedSrvRisDO()[0].Sd_pos;	//身体体位编码  	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Name_pos = medSrvAgg.getMedSrvRisDO()[0].Name_pos;	//身体体位名称 50	 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_samptp = "";//	标本类型id	REF	标本类型_自定义档案				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Name_samptp = "";//	标本类型名称 		 	 			 	 	 	
           emsDO.Emsapobs.Sd_samptp = "";//	标本类型编码 		 	 			 	 	 	
           emsDO.Emsapobs.Sortno = 1;//	序号  	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Fg_chk = false;//	选择  	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Announcements = medSrvAgg.getMedSrvRisDO()[0].Note;//	注意事项	 	备注	  				 	 	 	 	 	 				 	 			 	 	 	
           //emsDO.Emsapobs.sv	版本号	S 	 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_srvca = medSrvs.Id_srvca;//	检验分类	  				 	 	 	 	 	 				 	 			 	 	 	
            // emsDO.Emsapobs.sd_colltp	采集方法编码  	 	 				 	 	 	 	 	 				 	 			 	 	 	
            // emsDO.Emsapobs.id_colltp	采集方法id	 
            // emsDO.Emsapobs.des_labsamp	标本说明  	 	 	
            //emsDO.Emsapobs.Use_days	使用天数  	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Id_mp_dep = ciEmsDto.Id_dep_mp;//	执行科室ID  				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Name_mp_dep = "";// 	执行科室名称 50	 	 				 	 	 	 	 	 				 	 			 	 	 	
           emsDO.Emsapobs.Price = medSrvs.Pri;//	价格	  				 	 	 	 	 			 	 			 	 	 	
          //emsDO.Emsapobs.quan_cur	总量 			 	 	 	 	 			 	 			 	 	 	
          //emsDO.Emsapobs.id_unit_sale	总量单位 50	 	 				 	 	 	 	 	 				 	 			 	 	 	
          //emsDO.Emsapobs.name_unit_sale	总量单位名称 50	 	 				 	 	 	 	 	 				 	 			 	 	 	
          //emsDO.Emsapobs.fg_indic	适应症	 	 	 				 	 	 	 	 	 				 	 			 	 	 	
          //emsDO.Emsapobs.id_unit_base	计数单位ID	 	 	 			 	 	 	
          //emsDO.Emsapobs.name_unit_base	计数单位名称 	 	 			 	 	 	
          //emsDO.Emsapobs.quan_base	计数单位			 	 			 	 	 	
           emsDO.Emsapobs.Innercode_srvca = medSrvs.Srvca_innercode;//	服务分类内部编码  	 			 	 	 	
           emsDO.Emsapobs.Fg_syncfee = false;//	费用同步标识 
           //套内项目
           setObsItem(emsDO, ciEmsDto, medSrvs);

       }

       /// <summary>
       /// 检验的项目映射字段
       /// </summary>
       private void setObsItem(EmsUIDTO emsDO, CiEmsDTO ciEmsDto, MedSrvDO medSrvs)
       {

           FMap2 map = (FMap2)ciEmsDto.Mapinfo;
           MedsrvAggDO medSrvAgg = null;
           FArrayList  aggList = null;
           if (map != null)
           {
               medSrvAgg = map["MedsrvAggDO"] as MedsrvAggDO;
               aggList = map["SetItemMedsrvDO"] as FArrayList;
           }
           //套内项目
           XapDataList<EmsObsLap> obsList = new XapDataList<EmsObsLap>();
           if (medSrvs.Fg_set.Value && aggList != null)
           {

               foreach (MedsrvAggDO aggDO in aggList)
               {
                   int i = 0;
                   foreach (MedSrvRisDO itemRisDO in aggDO.getMedSrvRisDO())
                   {
                       EmsObsLap obs = new EmsObsLap();
                       obs.Id = ""; //	id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Sd_body = itemRisDO.Sd_body; //	部位编码			 	 			 	 	 	
                       obs.Name_body = itemRisDO.Name_body; //	部位名称 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Sd_pos = itemRisDO.Sd_pos; //	体位编码				 	 			 	 	 	
                       obs.Name_pos = itemRisDO.Name_pos; //	体位名称	 				 	 	 	 	 	 				 	 			 	 	 	
                       //obs.If_mp_bed = itemRisDO.If_mp_bed;//	是否可床边执行		 	 			 	 	 	
                       obs.Id_srv = aggDO.getParentDO().Id_srv; //	检验编码 				 	 			 	 	 	
                       obs.Name_srv = aggDO.getParentDO().Name; //	检验名称	 				 	 	 	 	 	 				 	 			 	 	 	
                       //sortno	序号	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Id_pos = itemRisDO.Id_pos; //	体位id 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Id_body = itemRisDO.Id_body; //	部位id 	 				 	 	 	 	 	 				 	 			 	 	 	
                       //id_orsrv	医嘱服务id	 				 	 	 	 	 	 				 	 			 	 	 	
                       //id_or	医嘱医疗单	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Id_srvtp = aggDO.getParentDO().Id_srvtp; //	服务类型	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Name_srvtp = aggDO.getParentDO().Srvtp_name; //	服务类型名称		 	 			 	 	 	
                       obs.Id_obstp = itemRisDO.Id_obstp; //检查类型id			 	 			 	 	 	
                       obs.Name_obstp = itemRisDO.Obstp_name; //	检查类型名称		 	 			 	 	 	
                       obs.No_applyobs = ciEmsDto.Applyno; //	检查申请单号		 	 			 	 	 	
                       obs.Fg_urgent = ciEmsDto.Fg_urgent; //	加急标识		 	 			 	 	 	
                       obs.Fg_mp_bed = ciEmsDto.Fg_mp_bed; //	床旁执行标志	 	 			 	 	 	
                       obs.Dt_plan = ciEmsDto.Dt_begin; //	计划检查时间		 	 			 	 	 	
                       obs.Id_di = ""; //	诊断id		 	 			 	 	 	
                       obs.Name_di = ""; //	诊断	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Str_id_di = ""; //	诊断编码拼接	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Str_name_di = ""; //	诊断名称拼接		 	 			 	 	 	
                       obs.Sd_pps = ""; //	检查目的编码	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Id_pps = ""; //	检查目的	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Des_pps = ""; //	检查目的描述 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Des_sympsign = ""; //	症状体征描述	
                       obs.Id_su_obs = CiDictCodeConst.ID_CI_OBS_SQ; //检查申请单状态
                       obs.Sd_su_obs = CiDictCodeConst.SD_CI_OBS_SQ; //检查申请单编码		 	 	
                       //obs.Id_samptp = itemRisDO.id	标本类型id			 	 			 	 	 	
                       //name_samptp	标本类型名称		 	 			 	 	 	
                       //sd_samptp	标本类型编码		 	 			 	 	 	
                       obs.Fg_chk = true; //	选择 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Announcements = itemRisDO.Note; //	注意事项		 	 			 	 	 	
                       //sv	版本号		 				 	 	 	 	 	 				 	 			 	 	 	
                       //id_srvca	检验分类 	 				 	 	 	 	 	 				 	 			 	 	 	
                       //sd_colltp	采集方法编码		 	 			 	 	 	
                       //id_colltp	采集方法id 	 				 	 	 	 	 	 				 	 			 	 	 	
                       //des_labsamp	标本说明	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       //id_contp	容器编码 	 				 	 	 	 	 	 				 	 			 	 	 	
                       //sd_contp	容器id	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Quan = aggDO.getParentDO().Quan_med; //	标本需求量	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.No_applyform = ciEmsDto.Applyno; //申请单号		 	 			 	 	 	
                       //biopsy	检查组织描述 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Fg_or = aggDO.getParentDO().Fg_or; //	医嘱标志	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Sd_srvtp = aggDO.getParentDO().Sd_srvtp; //	医嘱类型	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Id_freq = aggDO.getParentDO().Id_freq; //	医嘱频次 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Quan_medu = aggDO.getParentDO().Quan_med; //	数值_医疗单位
                       obs.Id_medu = aggDO.getParentDO().Id_unit_med; //	医疗单位 	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Fg_bl = aggDO.getParentDO().Fg_bl; //	计费标志	 				 	 	 	 	 	 				 	 			 	 	 	
                       obs.Code_srv = aggDO.getParentDO().Code; //	服务编码	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       //obs.Fg_edit = aggDO.getMedSrvSetItemDO()[i].Fg_edit; //	可选标识	 	 				 	 	 	 	 	 				 	 			 	 	 	
                       //obs.Fg_body_update = aggDO.getMedSrvSetItemDO()[i].	部位可修改标示 	 			 	 	 	
                       //56		id_quan	标本需求量单位 	 				 	 	 	 	 	 				 	 			 	 	 	
                       //obs.id_hp = emsDO.PatInfo.Id_hp;//	医保	 				 	 	 	 	 	 				 	 			 	 	 	
                       //name_hp	医保名称	 				 	 	 	 	 	 				 	 			 	 	 	
                       //id_hpsrvtp	医保类型 	 				 	 	 	 	 	 				 	 			 	 	 	
                       //sd_hpsrvtp	医保类型编码		 	 			 	 	 	
                       //eu_sourcemd	数据来源
                       i++;
                       obsList.Add(obs);
                   }
               }
               
           }
           else
           {
               EmsObsLap obs = new EmsObsLap();
               obs.Id = ""; //	id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Sd_body = medSrvAgg.getMedSrvRisDO()[0].Sd_body; //	部位编码			 	 			 	 	 	
               obs.Name_body = medSrvAgg.getMedSrvRisDO()[0].Name_body; //	部位名称 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Sd_pos = medSrvAgg.getMedSrvRisDO()[0].Sd_pos; //	体位编码				 	 			 	 	 	
               obs.Name_pos = medSrvAgg.getMedSrvRisDO()[0].Name_pos; //	体位名称	 				 	 	 	 	 	 				 	 			 	 	 	
               //obs.If_mp_bed = itemRisDO.If_mp_bed;//	是否可床边执行		 	 			 	 	 	
               obs.Id_srv = medSrvAgg.getParentDO().Id_srv; //	检验编码 				 	 			 	 	 	
               obs.Name_srv = medSrvAgg.getParentDO().Name; //	检验名称	 				 	 	 	 	 	 				 	 			 	 	 	
               //sortno	序号	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Id_pos = medSrvAgg.getMedSrvRisDO()[0].Id_pos; //	体位id 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Id_body = medSrvAgg.getMedSrvRisDO()[0].Id_body; //	部位id 	 				 	 	 	 	 	 				 	 			 	 	 	
               //id_orsrv	医嘱服务id	 				 	 	 	 	 	 				 	 			 	 	 	
               //id_or	医嘱医疗单	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Id_srvtp = medSrvAgg.getParentDO().Id_srvtp; //	服务类型	 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Name_srvtp = medSrvAgg.getParentDO().Srvtp_name; //	服务类型名称		 	 			 	 	 	
               obs.Id_obstp = medSrvAgg.getMedSrvRisDO()[0].Id_obstp; //检查类型id			 	 			 	 	 	
               obs.Name_obstp = medSrvAgg.getMedSrvRisDO()[0].Obstp_name; //	检查类型名称		 	 			 	 	 	
               obs.No_applyobs = ciEmsDto.Applyno; //	检查申请单号		 	 			 	 	 	
               obs.Fg_urgent = ciEmsDto.Fg_urgent; //	加急标识		 	 			 	 	 	
               obs.Fg_mp_bed = ciEmsDto.Fg_mp_bed; //	床旁执行标志	 	 			 	 	 	
               obs.Dt_plan = ciEmsDto.Dt_begin; //	计划检查时间		 	 			 	 	 	
               obs.Id_di = ""; //	诊断id		 	 			 	 	 	
               obs.Name_di = ""; //	诊断	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Str_id_di = ""; //	诊断编码拼接	 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Str_name_di = ""; //	诊断名称拼接		 	 			 	 	 	
               obs.Sd_pps = ""; //	检查目的编码	 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Id_pps = ""; //	检查目的	 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Des_pps = ""; //	检查目的描述 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Des_sympsign = ""; //	症状体征描述	
               obs.Id_su_obs = CiDictCodeConst.ID_CI_OBS_SQ; //检查申请单状态
               obs.Sd_su_obs = CiDictCodeConst.SD_CI_OBS_SQ; //检查申请单编码		 	 	
               //obs.Id_samptp = itemRisDO.id	标本类型id			 	 			 	 	 	
               //name_samptp	标本类型名称		 	 			 	 	 	
               //sd_samptp	标本类型编码		 	 			 	 	 	
               obs.Fg_chk = true; //	选择 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Announcements = medSrvAgg.getMedSrvRisDO()[0].Note; //	注意事项		 	 			 	 	 	
               //sv	版本号		 				 	 	 	 	 	 				 	 			 	 	 	
               //id_srvca	检验分类 	 				 	 	 	 	 	 				 	 			 	 	 	
               //sd_colltp	采集方法编码		 	 			 	 	 	
               //id_colltp	采集方法id 	 				 	 	 	 	 	 				 	 			 	 	 	
               //des_labsamp	标本说明	 	 				 	 	 	 	 	 				 	 			 	 	 	
               //id_contp	容器编码 	 				 	 	 	 	 	 				 	 			 	 	 	
               //sd_contp	容器id	 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Quan = medSrvAgg.getParentDO().Quan_med; //	标本需求量	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.No_applyform = ciEmsDto.Applyno; //申请单号		 	 			 	 	 	
               //biopsy	检查组织描述 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Fg_or = medSrvAgg.getParentDO().Fg_or; //	医嘱标志	 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Sd_srvtp = medSrvAgg.getParentDO().Sd_srvtp; //	医嘱类型	 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Id_freq = medSrvAgg.getParentDO().Id_freq; //	医嘱频次 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Quan_medu = medSrvAgg.getParentDO().Quan_med; //	数值_医疗单位
               obs.Id_medu = medSrvAgg.getParentDO().Id_unit_med; //	医疗单位 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Fg_bl = medSrvAgg.getParentDO().Fg_bl; //	计费标志	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Code_srv = medSrvAgg.getParentDO().Code; //	服务编码	 	 				 	 	 	 	 	 				 	 			 	 	 	
               obs.Fg_edit = true; //	可选标识	 	 				 	 	 	 	 	 				 	 			 	 	 	
               //obs.Fg_body_update = aggDO.getMedSrvSetItemDO()[i].	部位可修改标示 	 			 	 	 	
               //56		id_quan	标本需求量单位 	 				 	 	 	 	 	 				 	 			 	 	 	
               //obs.id_hp = emsDO.PatInfo.Id_hp;//	医保	 				 	 	 	 	 	 				 	 			 	 	 	
               //name_hp	医保名称	 				 	 	 	 	 	 				 	 			 	 	 	
               //id_hpsrvtp	医保类型 	 				 	 	 	 	 	 				 	 			 	 	 	
               //sd_hpsrvtp	医保类型编码		 	 			 	 	 	
               //eu_sourcemd	数据来源
               obsList.Add(obs);
           }

           emsDO.Emsapobs.EmsOrObsList = obsList;
       }

    }
}
