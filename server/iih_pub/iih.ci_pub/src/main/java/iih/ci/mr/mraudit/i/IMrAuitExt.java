package iih.ci.mr.mraudit.i;

import iih.ci.mr.cimr.d.CiMrDO;
import xap.mw.core.data.BizException;
import xap.wf.af.server.WfFormInfoCtx;

/**
* 医疗记录审批操作接口方法服务
*/
public interface IMrAuitExt {


    /**
	*  开始审批流
	*/
    public CiMrDO startProcess(String id_user , WfFormInfoCtx formInfo) throws BizException;
    
    public CiMrDO stopProcess(String id_user , WfFormInfoCtx formInfo) throws BizException;
    
	public CiMrDO nextStep(String id_user, WfFormInfoCtx formInfo, String taskId) throws BizException;
	
	public CiMrDO rejectTask(String id_user, WfFormInfoCtx formInfo, String taskId, String opinion) throws BizException;
	
	public CiMrDO backTask(String id_user, WfFormInfoCtx formInfo, String taskId) throws BizException;
	/**
	 * 在GobackListener里实现
	 * @deprecated
	 * @param id_user
	 * @param formInfo
	 * @param taskId
	 * @throws BizException
	 */
	public CiMrDO backTask2(String id_user, WfFormInfoCtx formInfo, String taskId) throws BizException;
	
	public String[] getTodoTasks(String id_user, String id_mr);
	public String getCompletedTask(String id_user, String id_mr);
	/**
	 * 判断是否可以取回
	 *
	 */
	public boolean isCanback(String id_task);
	/**
	 * 判断是几级审签
	 *
	 */
	public String getNodeins_code(String id_task);
	/**
	 * 判断是否可以驳回
	 *
	 */
	public boolean isCanReject(String id_task);
	/**
	 * 判断是否打开文书
	 *
	 */
	public void openTask(WfFormInfoCtx formInfo, String taskId);
	/**
	 * 流程关闭
	 *
	 */
	public void closeTask(WfFormInfoCtx formInfo);
	
	/**
	 * 获取提交人
	 * @param idTask
	 * @return
	 */
	public String getPreTasksUser(String idTask);
}
