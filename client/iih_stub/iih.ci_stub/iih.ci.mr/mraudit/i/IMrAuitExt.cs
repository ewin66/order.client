using System;
using System.Collections.Generic;
using System.Linq;
using xap.wf.af.vos.i;
using iih.ci.mr.cimr.d;

namespace iih.ci.mr.mraudit.i
{
    public interface IMrAuitExt
    {

        /// 开始审批流
        CiMrDO StartProcess(string id_user, WfFormInfoCtx formInfo);

        CiMrDO NextStep(string id_user, WfFormInfoCtx formInfo, string taskId);

        CiMrDO RejectTask(string id_user, WfFormInfoCtx formInfo, string taskId, string opinion);

        CiMrDO BackTask(string id_user, WfFormInfoCtx formInfo, string taskId);

        string[] GetTodoTasks(String id_user, String id_mr);
        string GetCompletedTask(String id_user, String id_mr);

        /// <summary>
        /// 是否可以取回
        /// </summary>
        /// <param name="id_task"> 任务id</param>
        /// <returns></returns>
        bool isCanback(String id_task);
        /// <summary>
        /// 获取审签级别
        /// </summary>
        /// <param name="id_task"> 任务id</param>
        /// <returns></returns>
        string getNodeins_code(String id_task);
        /// <summary>
        /// 是否可以驳回
        /// </summary>
        /// <param name="id_task"> 任务id</param>
        /// <returns></returns>
        bool isCanReject(String id_task);

        /// <summary>
        /// 打开文书
        /// </summary>
        /// <param name="id_task"> 任务id</param>
        /// <returns></returns>
        void openTask(WfFormInfoCtx formInfo, String taskId);

        /// <summary>
        /// 关闭业务流
        /// </summary>
        /// <param name="formInfo"> 单据</param>
        /// <param name="id_task"> 任务id</param>
        /// <returns></returns>
        void closeTask(WfFormInfoCtx formInfo);

        string GetPreTasksUser(string idTask);
    }
}
