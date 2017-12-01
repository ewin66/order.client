using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.iih.ci.ord.opemergency.i.command;
using iih.ci.ord.opemergency.assi.OrderTemplate;
using iih.ci.ord.opemergency.view;
using iih.bd.srv.ortpl.d;
using System.Windows.Forms;
using System.Drawing;
using iih.ci.ord.ems.d;
using iih.bd.srv.ems.d;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.ciorder.cards.extend;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.command
{
    /// <summary>
    /// <para>描    述 :  医嘱模板                    			</para>
    /// <para>说    明 :  助手                   			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.command    </para>    
    /// <para>类 名 称 :  OrderTemplateCommand					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  9/20/2016 2:27:11 PM             </para>
    /// <para>更新时间 :  9/20/2016 2:27:11 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    class OrderTemplateCommand : ICiCommand
    {
        public OrScArgs Args { get; set; }
        public object exec(object param)
        {
            AssButtonView owner = param as AssButtonView;
            OpOrderTemplateForm OrderSevrice_Frm = new OpOrderTemplateForm(owner,0);
                   // helperForm OrderSevrice_Frm = new helperForm(this);
                    OrderSevrice_Frm.Location = new Point(200, 400);
                    if (OrderSevrice_Frm.ShowDialog() == DialogResult.OK)
                    {
                        List<OrTplNItmDO> list = new List<OrTplNItmDO>();
                        if (OrderSevrice_Frm.view.Args != null)
                        {
                            foreach (Object item in OrderSevrice_Frm.view.Args.listObj)
                            {
                                if ((item as OrTplNItmDO) != null)
                                {
                                    list.Add(item as OrTplNItmDO);
                                }
                            }
                        }
                        //保存数据库
                        CiEnContextDTO envinfo = new CiEnContextDTO();
                        envinfo.Code_entp = owner.ent4BannerDTO.Code_entp;
                        envinfo.Id_dep_or = owner.Context.Dept.Id_dep;
                        envinfo.Id_en = owner.ent4BannerDTO.Id_ent;
                        envinfo.Id_emp_or = owner.Context.PsnInfo.Id_psndoc;
                        envinfo.Id_entp = owner.ent4BannerDTO.Id_entp;
                        envinfo.Id_grp = owner.Context.Group.Id_grp;
                        envinfo.Id_hp = owner.ent4BannerDTO.Id_hp;
                        envinfo.Id_org = owner.Context.Org.Id_org;
                        envinfo.Id_pat = owner.ent4BannerDTO.Id_pat;
                        envinfo.Emsappmode = (int)EmsAppModeEnum.IVEMSAPPMODE;//智慧版
                        MoreEmsParamDTO moreEmsDto = owner.model.getMoreEmsParamDTO(envinfo, list.ToArray());
                       
                        AssToolEx.SentMessage(owner, EventCodeType.EVENT_EMS_TMPL_EDIT,EventCodeType.ARGKEY_EMS_TMPL_EDIT, moreEmsDto);
                    }
            return null;
        }

        public string GetTitle()
        {
            return "医嘱模板";
        }
        public string getEventType() {
            return "ShortcutOpOrdTemplat";
        } 
    }
}