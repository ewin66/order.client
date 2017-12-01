using System;
using System.Collections.Generic;
using System.Linq;
using xap.mw.serviceframework;
using xap.wf.af.vos.i;
using iih.ci.mr.cimr.d;

namespace iih.ci.mr.mraudit.i {
    public class IMrAuitExtImpl : IMrAuitExt {
    	
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.mraudit.i.IMrAuitExt";
        //private string url = "http://127.0.0.1.:8080" + "/bin/testDOService";

        private ServiceInvocation si;

        public IMrAuitExtImpl(){
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public CiMrDO StartProcess(string id_user, WfFormInfoCtx formInfo)
        {
            List<object> ps = new List<object>();
            ps.Add(id_user);
            ps.Add(formInfo);
            CiMrDO cimrdo = si.invoke<CiMrDO>("startProcess", ps.ToArray());

            return cimrdo;
        }

        public CiMrDO NextStep(string id_user, WfFormInfoCtx formInfo, string taskId)
        {
            List<object> ps = new List<object>();
            ps.Add(id_user);
            ps.Add(formInfo);
            ps.Add(taskId);
            CiMrDO cimrdo = si.invoke<CiMrDO>("nextStep", ps.ToArray());

            return cimrdo;
        }

        public CiMrDO RejectTask(string id_user, WfFormInfoCtx formInfo, string taskId, string opinion)
        {
            List<object> ps = new List<object>();
            ps.Add(id_user);
            ps.Add(formInfo);
            ps.Add(taskId);
            ps.Add(opinion);
            CiMrDO cimrdo = si.invoke<CiMrDO>("rejectTask", ps.ToArray());

            return cimrdo;
        }

        public CiMrDO BackTask(string id_user, WfFormInfoCtx formInfo, string taskId)
        {
            List<object> ps = new List<object>();
            ps.Add(id_user);
            ps.Add(formInfo);
            ps.Add(taskId);
            CiMrDO cimrdo = si.invoke<CiMrDO>("backTask", ps.ToArray());

            return cimrdo;
        }

        public string[] GetTodoTasks(string id_user, string id_mr)
        {
            List<object> ps = new List<object>();
            ps.Add(id_user);
            ps.Add(id_mr);
            return si.invokeStringList("getTodoTasks", ps.ToArray());
        }

        public string GetCompletedTask(string id_user, string id_mr)
        {
            List<object> ps = new List<object>();
            ps.Add(id_user);
            ps.Add(id_mr);
            return si.invoke<string>("getCompletedTask", ps.ToArray());
        }

        public string GetPreTasksUser(string idTask)
        {
            List<object> ps = new List<object>();
            ps.Add(idTask);
            return si.invoke<string>("getPreTasksUser", ps.ToArray());
        }

        public bool isCanback(string id_task)
        {
            List<object> ps = new List<object>();
            ps.Add(id_task);
            return si.invoke<bool>("isCanback", ps.ToArray());
        }

        public string getNodeins_code(string id_task)
        {
            List<object> ps = new List<object>();
            ps.Add(id_task);
            return si.invoke<string>("getNodeins_code", ps.ToArray());
        }

        public bool isCanReject(string id_task)
        {
            List<object> ps = new List<object>();
            ps.Add(id_task);
            
            return si.invoke<bool>("isCanReject", ps.ToArray());
        }

        public void openTask(WfFormInfoCtx formInfo, string taskId)
        {
            List<object> ps = new List<object>();
            ps.Add(formInfo);
            ps.Add(taskId);
            si.invoke<object>("openTask", ps.ToArray());
        }

        public void closeTask(WfFormInfoCtx formInfo)
        {
            List<object> ps = new List<object>();
            ps.Add(formInfo);
            si.invoke<object>("openTask", ps.ToArray());
        }
    }
}