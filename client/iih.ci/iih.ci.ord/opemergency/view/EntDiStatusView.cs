using System;
using System.Drawing;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.mw.serviceframework;
using iih.en.pv.i;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannerview;
using iih.ci.mr.mrserviceext.i;
using iih.ci.mr.cimr.d;
using iih.bd.srv.mrctmca.d;
using iih.ci.ord.opemergency.emreditor.viewmodel;
using System.Collections.Generic;
using xap.rui.engine.eventbroker;
using System.Windows.Forms;
using xap.sys.permfw.user.d;
using iih.ci.mr.per.i;
using iih.ci.mr.per.d;
using xap.rui.engine.eventbroker.Handlers;
using xap.rui.bizcontrol.bannercontrol;
using iih.ci.ord.opemergency.action.costant;
using xap.cli.sdk.form;
using iih.ci.mr.cimr.i;
using iih.bd.bc.udi;
using xap.mw.log;

namespace iih.ci.ord.opemergency.view
{

    /// <summary>
    /// <para>描    述 :  门急诊医生工作站- 【单选按钮组】视图           			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view    </para>    
    /// <para>类 名 称 :  EntDiStatusView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/12 11:16:54             </para>
    /// <para>更新时间 :  2016/7/12 11:16:54             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntDiStatusView : XapBaseControl
    {

        #region 变量定义区域       
        // 切换病历下拉框
        private XComboBox mrSelCombox;
        //private XBaseControl xBaseControl;
        // 初诊、复诊按钮组
        XRadioboxGroup xRadioGroup = XLabelControlFactory.GetRadioBoxGroup();
        // 就诊相关服务接口（更改初诊、复诊状态）
        IEnOutCmdService enOutCmdService = XapServiceMgr.find<IEnOutCmdService>();
        Ent4BannerDTO ent4BannerDTO = null;

        #region 病历相关参数

        /// <summary>
        /// 是否需要重新刷新病历，对当前病历进行保存时不重新刷新病历，仅有切换时才刷新
        /// </summary>
        private bool isReLoadCiMr = true;

        /// <summary>
        /// 加载病历
        /// </summary>
        private IMrServiceExt iMrServiceExt = XapServiceMgr.find<IMrServiceExt>();

        /// <summary>
        /// 病历数据源
        /// </summary>
        private Dictionary<object, string> mrSelDatasource = new Dictionary<object, string>();

        /// <summary>
        /// 加载病历参数
        /// </summary>
        private DictionaryEventArgs eventArgs = new DictionaryEventArgs();

        /// <summary>
        /// 牙周检查接口
        /// </summary>
        private IPerMDOCrudService iPerMDOCrudService = XapServiceMgr.find<IPerMDOCrudService>();

        /// <summary>
        /// 病历处理接口
        /// </summary>
        private ICiemrCrudService iciemrCrudService = XapServiceMgr.find<ICiemrCrudService>();


        #endregion

        #endregion

        #region 构造函数区域
        public EntDiStatusView()
        {
            this.Load += new EventHandler(EntDiStatusView_Load);
        }

        void EntDiStatusView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            //this.LoadCiMrDOs();
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            this.xRadioGroup.Location = new Point(10, 0);
            this.xRadioGroup.Size = this.Size;
            xap.cli.sdk.render.Items.XRadiobox firstDiRadioBox = new xap.cli.sdk.render.Items.XRadiobox() { ValueCode = "0" };
            firstDiRadioBox.Text = "初诊";
            this.xRadioGroup.AddRender(firstDiRadioBox);
            firstDiRadioBox.Checked = true;
            xap.cli.sdk.render.Items.XRadiobox mzDiRadioBox = new xap.cli.sdk.render.Items.XRadiobox() { ValueCode = "1" };
            mzDiRadioBox.Text = "复诊";
            this.xRadioGroup.AddRender(mzDiRadioBox);
            //             xap.cli.sdk.render.Items.XRadiobox emgyDiRadioBox = new xap.cli.sdk.render.Items.XRadiobox();
            //             emgyDiRadioBox.Text = "急诊复诊";
            //             this.xRadioGroup.AddRender(emgyDiRadioBox);
            //             xap.cli.sdk.render.Items.XRadiobox zyfzRadioBox = new xap.cli.sdk.render.Items.XRadiobox();
            //             zyfzRadioBox.Text = "住院复诊";
            //             this.xRadioGroup.AddRender(zyfzRadioBox);
            //             xap.cli.sdk.render.Items.XRadiobox otherRadioBox = new xap.cli.sdk.render.Items.XRadiobox();
            //             otherRadioBox.Text = "其他";
            //             this.xRadioGroup.AddRender(otherRadioBox);            
            this.xRadioGroup.ValueTextChanged += xRadioGroup_ValueTextChanged;

            // 切换病历下拉框
            //mrSelCombox = new XComboBox(this);

            //mrSelCombox.Size = new System.Drawing.Size(260, 20);
            //int x = this.Size.Width - mrSelCombox.Size.Width - 1;
            //int y = (this.Size.Height - mrSelCombox.Size.Height) / 2;
            //mrSelCombox.Location = new Point(x, y);

            //mrSelCombox.ValueTextChanging += MrSelCombox_ValueTextChanging;
            //mrSelCombox.ValueTextChanged += MrSelCombox_ValueTextChanged;
            this.AddRender(this.xRadioGroup);

            // 首次加载，设置返回值第一个为选中状态
            //this.FillCiMrItems(null);
            //this.AddRender(this.mrSelCombox);
        }

        #endregion

        #region 内部事件

        /// <summary>
        /// 初诊、复诊切换按钮切换
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void xRadioGroup_ValueTextChanged(object sender, EventArgs e)
        {
            if (enOutCmdService != null && ent4BannerDTO != null)
            {
                //更新是否为初诊标识
                bool fgFirst = this.xRadioGroup.ValueCode.Equals("0");
                enOutCmdService.UpdateOpFirstFlag(this.ent4BannerDTO.Id_ent, fgFirst);
                // 初诊、复诊变化时同时影响banner中初诊、复诊状态
                this.ent4BannerDTO.Fg_first = fgFirst;

                this.fireLoadFirstVisitEmrEvent(fgFirst);
            }
        }

        /// <summary>
        /// 病历切换过程中触发，如果是牙周检查，直接弹出窗口，下拉选中的值不改变
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        //private void MrSelCombox_ValueTextChanging(object sender, ChangingEventArgs e)
        //{
        //    PerDO perDO = e.NewValue as PerDO;
        //    string str = e.NewValue as string;
        //    if (str.IndexOf("PerDO") > 0) // 当前点击的是牙周检查的下拉选项时，弹出牙周检查窗口
        //    {
        //        e.Cancel = true;
        //        this.ShowEmrPerView();
        //    }
        //    else
        //    {
        //        e.Cancel = false;
        //    }
        //    LogManager.GetLogger().InfoEx("执行病历下拉选切换！");
        //}

        /// <summary>
        /// 病历选选切换事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        //private void MrSelCombox_ValueTextChanged(object sender, EventArgs e)
        //{
        //    if (isReLoadCiMr)
        //    {
        //        // 该方法中不需要再判断选择结果是否为牙周检查。在ValueTextChanging中已加判断
        //        CiMrDO ciMrDO = (sender as XComboBox).SelectedItem as CiMrDO;
        //        this.fireLoadEmrEditorCimrEvent(ciMrDO);
        //    }
        //    isReLoadCiMr = true;
        //}

        //private void ShowEmrPerView()
        //{
        //    DictionaryEventArgs de = new DictionaryEventArgs();
        //    de.Data.Add(UIConst.UI_EVENT, "EmrPer");
        //    //弹出牙周检查窗口
        //    this.FireEventSent(this, de);
        //}

        #endregion

        #region 事件发送区域

        /// <summary>
        /// 根据病历模板列表选中结果加载病历
        /// </summary>
        //[EventPublication(EmrEditorConst.LOAD_EMR_EDITOR_CIMR_EVENT)]
        //public event EventHandler<DataEventArgs<Dictionary<string, object>>> LoadEmrEditorCimrEvent;
        //private void fireLoadEmrEditorCimrEvent(CiMrDO ciMrDO)
        //{
        //    Dictionary<string, object> paramDic = this.GetCiMrArgsDic();
        //    // 设置参数病历文书对象
        //    paramDic.Add(EmrEditorConst.PARAM_CIMRDO, ciMrDO);

        //    DataEventArgs<Dictionary<string, object>> eventArgs = new DataEventArgs<Dictionary<string, object>>(paramDic);

        //    if (LoadEmrEditorCimrEvent != null)
        //        this.LoadEmrEditorCimrEvent(this, eventArgs);
        //}


        /// <summary>
        /// 根据初复诊切换病历模板
        /// </summary>
        [EventPublication(EmrEditorConst.LOAD_FIRST_VISIT_EMR_EVENT)]
        public event EventHandler<DictionaryEventArgs> LoadFirstVisitEmrEvent;
        private void fireLoadFirstVisitEmrEvent(bool fgFirst)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add("FG_First", fgFirst);

            if (LoadFirstVisitEmrEvent != null)
                this.LoadFirstVisitEmrEvent(this, args);
        }

        #endregion

        #region 事件接收区域

        //[EventSubscription("RefshEmrListEvent", typeof(OnPublisher))]
        //public void fireRefshEmrListEvent(object sender, DataEventArgs<Dictionary<string, object>> args)
        //{
        //    // 如果病历文书之前已经保存过，再次进行保存时，病历文书列表项没有变化，不进行刷新数据源
        //    // args.Data中数据项如果为0时，表明对已保存过的病历再次进行保存操作
        //    if (args.Data.Keys.Count == 0)
        //    {
        //        return;
        //    }

        //    CiMrDO ciMrDO = null;
        //    Dictionary<string, object> paramDic = args.Data as Dictionary<string, object>;

        //    if (paramDic.ContainsKey(EmrEditorConst.PARAM_CIMRDO))
        //    {
        //        ciMrDO = paramDic[EmrEditorConst.PARAM_CIMRDO] == null ? null : paramDic[EmrEditorConst.PARAM_CIMRDO] as CiMrDO;
        //    }
        //    string isciMrDONull = ciMrDO == null ? "true" : "false";
        //    LogManager.GetLogger().InfoEx("执行方法 fireRefshEmrListEvent ciMrDO是否为空=" + isciMrDONull);
        //    this.ResfreshMrComboxDataSource(ciMrDO);
        //}

        #endregion

        #region 私有方法

        /// <summary>
        /// 绑定数据源，病设置默认选中项
        /// 如果默认只有牙周检查，则不将牙周检查设置为默认选中项
        /// </summary>
        /// <param name="ciMrDO">默认选中的病历文书对象</param>
        /// <param name="isForceReload">是否强制刷新，默认不强制刷新，只有点击门诊菜单中的刷新按钮时，才强制刷新病历</param>
        //private void FillCiMrItems(CiMrDO ciMrDO, bool isForceReload = false)
        //{
        //    string isNullciMrDO = ciMrDO == null ? "true" : "false";
        //    LogManager.GetLogger().InfoEx("执行方法 FillCiMrItems ciMrDO是否为空=" + isNullciMrDO + " ;isForceReload = " + isForceReload.ToString() + " ; mrSelDatasource.Keys.Count = " + mrSelDatasource.Keys.Count);
        //    if (mrSelDatasource.Keys.Count > 0)
        //    {
        //        this.mrSelCombox.DataSource = mrSelDatasource;
        //        // 如果返回的是病历文书，设置返回的病历文书为默认选中项
        //        if (ciMrDO != null)
        //        {
        //            int index = 0;
        //            foreach (object obj in mrSelDatasource.Keys)
        //            {
        //                CiMrDO seledCiMrDO = obj as CiMrDO;
        //                if (seledCiMrDO != null && seledCiMrDO.Id_mr.Equals(ciMrDO.Id_mr))
        //                {
        //                    // 刷新下拉选数据源时，进改变选中状态，不重新加载病历，当前显示的病历就是默认应该选中的病历
        //                    isReLoadCiMr = isForceReload; // 当点击菜单中的刷新按钮时要刷新病历
        //                    this.mrSelCombox.SelectedItem = seledCiMrDO;
        //                    this.mrSelCombox.SelectIndex = index;
        //                    break;
        //                }
        //                index++;
        //            }
        //        }
        //        else
        //        {
        //            // 如果保存的是非病历文书（牙周检查）,并且当前已保存的文书仅有牙周检查时，不设置默认选中状态（牙周检查的选择时弹出，牙周维护界面）
        //            CiMrDO defalutCiMrDO = this.mrSelCombox.Items[0] as CiMrDO;
        //            this.mrSelCombox.SelectIndex = 0;
        //        }
        //    }
        //    else
        //    {
        //        mrSelDatasource.Add("a", "无已保存病历");
        //        this.mrSelCombox.DataSource = mrSelDatasource;
        //        this.mrSelCombox.SelectIndex = 0;
        //    }
        //}

        /// <summary>
        /// 设置病历下拉框数据源
        /// </summary>
        //private void LoadCiMrDOs()
        //{
        //    //清空原有数据源，否则会重复
        //    mrSelDatasource.Clear();

        //    // 如果已选用户，根据用户获取对应以保存的病历文书
        //    if (ent4BannerDTO == null)
        //    {
        //        return;
        //    }

        //    // 获取病历
        //    CiMrDO[] ciMrDOs = null;
        //    // 获取牙周检查
        //    PerDO[] PerDOs = null;
        //    string tempName = "";
        //    string strCon = " id_ent='" + ent4BannerDTO.Id_ent + "'";

        //    // 获取已保存的病历文书集合
        //    ciMrDOs = (CiMrDO[])iMrServiceExt.GetMrByMrCa(ent4BannerDTO.Id_ent, "%", ent4BannerDTO.Code_entp, ((int)(docornur.DOCTOR)).ToString());

        //    foreach (CiMrDO ciMrDO in ciMrDOs)
        //    {
        //        tempName = ciMrDO.Name + " " + this.FormatDateStr(ciMrDO.Createdtime) + " " + ciMrDO.Createby_name;
        //        mrSelDatasource.Add(ciMrDO, tempName);
        //    }

        //    // 获取已保存的牙周检查文书对象
        //    PerDOs = iPerMDOCrudService.find(strCon, null, false);
        //    foreach (PerDO perDO in PerDOs)
        //    {
        //        tempName = "牙周组织检查表";// TOTO 后续牙周增加时间，创建人 在调整显示名
        //        mrSelDatasource.Add(perDO, tempName);
        //    }
        //}

        /// <summary>
        /// 点击门诊菜单中刷新按钮事件
        /// </summary>
        //private void OpRefreshEvent()
        //{
        //    CiMrDO ciMrDO = this.mrSelCombox.SelectedItem as CiMrDO;
        //    LogManager.GetLogger().InfoEx("执行方法 OpRefreshEvent");
        //    ResfreshMrComboxDataSource(ciMrDO, true);
        //}

        /// <summary>
        /// 刷新病历切换下拉框数据以及重新加载
        /// </summary>
        /// <param name="ciMrDO"></param>
        //private void ResfreshMrComboxDataSource(CiMrDO ciMrDO, bool isForceReload = false)
        //{
        //    // 加载数据
        //    this.LoadCiMrDOs();
        //    // 判断数据源
        //    this.FillCiMrItems(ciMrDO, isForceReload);
        //}

        /// <summary>
        /// 获取加载病历的环境参数
        /// </summary>
        /// <returns></returns>
        //private Dictionary<string, object> GetCiMrArgsDic()
        //{
        //    Dictionary<string, object> emrInitParamDic = new Dictionary<string, object>();

        //    // 获取当前登录用户所在院区及科室，这个两个参数确定调用哪个模板
        //    UserDO user = this.Context.User;
        //    string idOrg = this.Context.Org.Id_org;
        //    string idDep = this.Context.Dept.Id_dep;

        //    emrInitParamDic.Add("IdOrg", idOrg);//登陆医生的医院编号
        //    emrInitParamDic.Add("idDep", idDep);//登陆医生的部门编号

        //    emrInitParamDic.Add(EmrEditorConst.PARAM_ENT4BANNERDTO, ent4BannerDTO);

        //    return emrInitParamDic;
        //}

        /// <summary>
        /// 删除当前加载的病历
        /// 如果是最后一篇病历，删除后重新加载空的病历模板
        /// </summary>
        //private void DeleteCiMrDO()
        //{

        //    string msg = null;
        //    Dictionary<object, string> dataSource = this.mrSelCombox.DataSource;
        //    CiMrDO ciMrDO = this.mrSelCombox.SelectedItem as CiMrDO;

        //    // 病历切换列表记录数(获取病历文书记录数，排除牙周检查)
        //    int ciMrCnt = dataSource.Count;
        //    // 如果包含牙周检查，病历数减一
        //    if (IsContainPerDO(dataSource))
        //    {
        //        ciMrCnt--;
        //    }

        //    if (ciMrDO != null)
        //    {
        //        if (ciMrCnt > 1)
        //        {
        //            // 提示是否删除病历，
        //            msg = "是否删除当前加载的病历！";
        //        }
        //        else if (ciMrCnt == 1)
        //        {
        //            msg = "当前为最后一份病历，删除后将重新加载病历模板";
        //        }

        //        if (!string.IsNullOrEmpty(msg))
        //        {
        //            DialogResult result = MessageBoxEx.Show(msg, "操作提示", MessageBoxButtons.OKCancel, MessageBoxIconEx.Information, MessageBoxDefaultButton.Button1);
        //            if (DialogResult.OK.Equals(result))
        //            {
        //                // 调用病历执行删除
        //                foreach (object obj in mrSelDatasource.Keys)
        //                {
        //                    CiMrDO seledCiMrDO = obj as CiMrDO;
        //                    if (seledCiMrDO != null && seledCiMrDO.Id_mr.Equals(ciMrDO.Id_mr))
        //                    {
        //                        CiMrDO delCiMrDO = iciemrCrudService.findById(ciMrDO.Id_mr);
        //                        iciemrCrudService.delete(new CiMrDO[1] { delCiMrDO });
        //                        mrSelDatasource.Remove(obj);
        //                        //this.mrSelCombox.DataSource = mrSelDatasource;                                
        //                        this.FillCiMrItems(null);
        //                        break;
        //                    }
        //                }
        //            }
        //        }
        //    }
        //    else
        //    {
        //        MessageBoxEx.Show("当前不存在可删除的病历！", "操作提示", MessageBoxButtons.OK, MessageBoxIconEx.Information, MessageBoxDefaultButton.Button1);
        //    }
        //}

        /// <summary>
        /// 判断下拉框数据源是否包含牙周检查
        /// </summary>
        /// <param name="mrSelComboxDataSource"></param>
        /// <returns></returns>
        //private bool IsContainPerDO(Dictionary<object, string> mrSelComboxDataSource)
        //{

        //    foreach (object obj in mrSelComboxDataSource.Keys)
        //    {
        //        if (obj is PerDO)
        //        {
        //            return true;
        //        }
        //    }
        //    return false;
        //}

        /// <summary>
        /// 获取指定的日期格式
        /// </summary>
        /// <param name="dateTime"></param>
        /// <returns></returns>
        //private string FormatDateStr(DateTime? dateTime)
        //{
        //    if (dateTime == null)
        //    {
        //        return "";
        //    }
        //    return string.Format("{0:g}", dateTime);
        //}
        #endregion

        #region 父类集成区
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (!this.Created || !(sender is bannerOpdocstation))
            {
                this.Enabled = false;
                return;
            }

            this.ent4BannerDTO = null;

            BannerData bannerData = e.Object as BannerData;
            if (bannerData != null && bannerData.Ent4BannerDTO != null)
            {
                this.ent4BannerDTO = bannerData.Ent4BannerDTO;
                this.Enabled = true;
                // 设置初诊复诊单选按钮默认状态
                this.xRadioGroup.ValueCode = this.ent4BannerDTO.Fg_first == true ? "0" : "1";
                //加载病历的数据源,切换用户重新绑定数据源后，设置下拉框第一项为选中状态
                LogManager.GetLogger().InfoEx("执行方法 OnSelected 中 ResfreshMrComboxDataSource 参数为空 bannerData 不为空时");
                //this.ResfreshMrComboxDataSource(null);
                // 诊毕状态初复诊按钮不可选
                if (EnDictCodeConst.SD_ENSTATUS_OP_FINISH.Equals(ent4BannerDTO.Sd_status))
                {
                    this.xRadioGroup.Enabled = false;
                }
                else
                {
                    this.xRadioGroup.Enabled = true;
                }

            }
            else
            {
                this.ent4BannerDTO = null;
                // 设置默认为初、复诊单选按钮默认勾选初诊，清空病历切换下拉列表
                this.xRadioGroup.ValueCode = "0";
                LogManager.GetLogger().InfoEx("执行方法 OnSelected 中 ResfreshMrComboxDataSource 参数为空 bannerData 为空");
                //this.ResfreshMrComboxDataSource(null);
                this.Enabled = false;
                this.xRadioGroup.Enabled = false;// 默认未加载患者是设置初复诊单选按钮不可用
            }
        }

        public override void HandleState(object sender, DictionaryEventArgs e)
        {
            // 获取事件类型
            string uiEvent = e.Data[UIConst.UI_EVENT] as string;
            switch (uiEvent)
            {
                //case OpActionConstant.EMR_DELETE_ACTION: // 删除病历事件
                //    this.DeleteCiMrDO();
                //    break;
                //case OpActionConstant.OP_REFRESH_ALL_ACTION: // 门诊刷新
                //    OpRefreshEvent();
                //    break;

            }
        }

        #endregion
    }
}
