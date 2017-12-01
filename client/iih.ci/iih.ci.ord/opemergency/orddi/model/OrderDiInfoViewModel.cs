using iih.bd.bc.udi;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.cidiag.i;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.context;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.rui.control.extentions;

namespace iih.ci.ord.opemergency.orddi
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ordiag    </para>    
    /// <para>类 名 称 :  Class1					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  10/12/2016 5:05:26 PM             </para>
    /// <para>更新时间 :  10/12/2016 5:05:26 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrderDiInfoViewModel 
    {
        private Ent4BannerDTO mEnt4BannerDTO;
        // 诊断信息 Agg 查询服务，支持保存删除等操作 
        private readonly ICidiagCrudService cidiagCrud;

        private CidiagAggDO cidiagAggDO ;

        private XapDataList<CiDiagItemDO> mDataSource;

        public void SetCidiagAggDO(CidiagAggDO o)
        {
            this.cidiagAggDO = o;
        }

        public CidiagAggDO GetCidiagAggDO()
        {
            return this.cidiagAggDO;
        }

        public OrderDiInfoViewModel()
        {
            cidiagCrud = XapServiceMgr.find<ICidiagCrudService>();
        }

        public bool Reload(Ent4BannerDTO e)
        {
           
            mEnt4BannerDTO = e;
            if (mEnt4BannerDTO == null)
            {
                mDataSource.Clear();
                return false;
            }
            var sql = string.Format("a0.id_en='{0}'", e.Id_ent);
            var szCidiagAggDO = cidiagCrud.find(sql, "a0.createdtime desc", false);

            if (szCidiagAggDO.Length > 0)
            {
                SetCidiagAggDO( szCidiagAggDO.LastOrDefault()); 
            }
            else
            {
                SetCidiagAggDO(CreateCidiagAggDO(this.mEnt4BannerDTO)); 
            }


            mDataSource = (XapDataList<CiDiagItemDO>)GetCidiagAggDO().getCiDiagItemDO().ToArray();
            
            return szCidiagAggDO.Length > 0;
        }

        private CidiagAggDO CreateCidiagAggDO(Ent4BannerDTO e)
        {
            var aggdo = new CidiagAggDO();

            var pdo = new CiDiagDO{
              Code_dep_create  = UserManager.getInstance().CurrentDept.Code,
          Code_ditp  = CiDictCodeConst.SD_OPDI,
          Code_entp  = e.Code_entp,
          Createdby  = UserManager.getInstance().CurrentPsnInfo.Id_psndoc,
          Createdtime  = CommonExtentions.NowTime(this),
          //Des_di  
          //Ds  
          Dt_create  = CommonExtentions.NowTime(this),
          Dt_di  = CommonExtentions.NowTime(this),
          Dt_sign  = CommonExtentions.NowTime(this),
          Empcode  = UserManager.getInstance().CurrentPsnInfo.Code,
          Empname  = UserManager.getInstance().CurrentPsnInfo.Name,
          Fg_sign  = true,
          Id_dep  = UserManager.getInstance().CurrentDept.Id_dep,
          Id_dep_create  = UserManager.getInstance().CurrentDept.Id_dep,
          Id_dep_sign  = UserManager.getInstance().CurrentDept.Id_dep,
          //Id_di  
          Id_ditp  = CiDictCodeConst.ID_OPDI,
          Id_emp_create  = UserManager.getInstance().CurrentPsnInfo.Id_psndoc,
          Id_emp_sign  = UserManager.getInstance().CurrentPsnInfo.Id_psndoc,
          Id_en  = e.Id_ent,
          Id_entp  = e.Id_entp,
          Id_grp  = UserManager.getInstance().CurrentGroup.Id_grp,
          Id_org  = UserManager.getInstance().CurrentOrg.Id_org,
          Id_pat  = e.Id_pat,
          //Modifiedby  
          //Modifiedtime  
          Name  = "门诊诊断",
          Name_dep_create  = UserManager.getInstance().CurrentDept.Name,
          Name_dep_sign  = UserManager.getInstance().CurrentDept.Name,
          Name_ditp  = "门诊诊断",
          Sd_ditp  = CiDictCodeConst.SD_OPDI
          //Signcode  
          //Signname  
        };
            aggdo.setParentDO(pdo);
            aggdo.setCiDiagItemDO(new CiDiagItemDO[] { new CiDiagItemDO { Id_disys = CiDictCodeConst.ID_CI_DISYS_XYZDTX },
            new CiDiagItemDO{Id_disys = CiDictCodeConst.ID_CI_DISYS_ZYZDTX}});
            return aggdo;
        }

        public Object GetFormDataSource()
        {

            return mDataSource;

           
        }

        public CiDiagItemDO AddRow(string idsys)
        {
            var item = new CiDiagItemDO { Id_disys = idsys };
            mDataSource.Add(item);
            return item;
        }

        public void DeleteRow(CiDiagItemDO item)
        {
            if (null != item)
            {
                (GetFormDataSource() as XapDataList<CiDiagItemDO>).Delete(item, item.IsNEW);
            }
        }

        public CidiagAggDO[] Save()
        {
            return this.cidiagCrud.save(new CidiagAggDO[] { this.cidiagAggDO });
        }
    }
}
