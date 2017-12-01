
using System;
using iih.bd.srv.diagdef.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.bd.srv.diagdef.d;
using iih.ci.ord.opemergency.assi.entdi.view;
using xap.mw.coreitf.d;
using iih.ci.diag_stub.i;

namespace iih.ci.ord.opemergency.assi.entdi.viewmodel
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.entdi.viewmodel    </para>    
    /// <para>类 名 称 :  EntDiAssiViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/4/11 10:47:43             </para>
    /// <para>更新时间 :  2017/4/11 10:47:43             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EntDiAssiViewModel
    {
        protected static IDiagdefMDOCrudService diagdefMDOCrudService = XapServiceMgr.find<IDiagdefMDOCrudService>();
        protected static ICidiagQryService cidiagQryService = XapServiceMgr.find<ICidiagQryService>();

        public XapDataList<DiagDefDO> diagDefDOs;

        public string TxtQuery = "";

        protected string[] strParams;

        public EntDiAssiViewModel()
        {
            diagDefDOs = new XapDataList<DiagDefDO>();

            strParams = cidiagQryService.getParamType().Split(',');
        }

        public virtual void LoadData()
        {
            string strFilter = "";
            foreach (var str in strParams)
                strFilter += String.Format("'{0}',", str);

            string strQuery = "";
            if (TxtQuery.Length > 0)
            {
                TxtQuery = TxtQuery.Replace("'", "@");
                strQuery += String.Format(" and (code like '%{4}%' or name like '%{0}%' or wbcode like '%{1}%' or pycode like '%{2}%' or mnecode like '%{3}%')", TxtQuery, TxtQuery, TxtQuery, TxtQuery, TxtQuery);
            }
            DiagDefDO[] dos = diagdefMDOCrudService.find(
                this.getSqlWhere() + String.Format(" and sd_cdsystp in ({0})", strFilter.Substring(0, strFilter.Length - 1)) + strQuery, "", FBoolean.False);

            diagDefDOs = new XapDataList<DiagDefDO>(diagdefMDOCrudService, dos);
        }

        protected virtual string getSqlWhere()
        {
            return "";
        }
    }
}
