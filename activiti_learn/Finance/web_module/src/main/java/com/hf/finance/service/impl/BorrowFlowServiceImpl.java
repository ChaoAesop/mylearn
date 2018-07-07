package com.hf.finance.service.impl;

import com.hf.finance.core.utils.state.SystemCodeStatus;
import com.hf.finance.core.utils.util.Common;
import com.hf.finance.dao.BorrowDao;
import com.hf.finance.dao.RolePermissionDao;
import com.hf.finance.dao.UserDao;
import com.hf.finance.entity.form.BorrowForm;
import com.hf.finance.entity.permission.User;
import com.hf.finance.service.BorrowFlowService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 借支流程service
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/16 0016 9:12
 */
@Service
public class BorrowFlowServiceImpl implements BorrowFlowService {

    @Resource
    private ProcessEngine pe;
    @Resource
    private BorrowDao borrowDao;
    @Resource
    private UserDao userDao;
    @Resource
    private RolePermissionDao rpDao;

    /**
     * 启动借支流程
     */
    @Override
    @Transactional
    public Map<String,Object> startProcess(BorrowForm bform) {
        //1.保存表单
        borrowDao.executeSave(bform);

        //2.根据流程定义的key启动流程，并注入businessKey
        ProcessInstance instance = pe.getRuntimeService().startProcessInstanceByKey("borrow", bform.getBid().toString());

        //3.保存流程实例的id
        bform.setInsId(instance.getId());
        borrowDao.executeUpdate(bform);

        return Common.resultMap(SystemCodeStatus.SUCCESS,"成功提交借支申请");
    }

    /**
     * 部门经理任务列表
     * @param userId 当前用户id
     * @return
     */
    @Override
    public Map<String, Object> deptTaskList(String userId) {
        User user = userDao.queryForId(Integer.valueOf(userId));
        //部门审批权限校验
        String names = rpDao.queryPermissionNames(user.getUid());
        if(names.contains("部门审批")){
            return Common.resultSuccessMap(taskList("部门审批"));
        }
        return Common.resultNullData();
    }

    /**
     *  公司任务列表
     * @param userId 用户id
     * @return
     */
    @Override
    public Map<String, Object> companyTaskList(String userId) {
        User user = userDao.queryForId(Integer.valueOf(userId));
        //公司审批权限校验
        String names = rpDao.queryPermissionNames(user.getUid());
        if(names.contains("公司审批")){
            return Common.resultSuccessMap(taskList("公司审批"));
        }
        return Common.resultNullData();
    }

    /**
     *  财务任务列表
     * @param userId 用户id
     * @return
     */
    @Override
    public Map<String, Object> financeTaskList(String userId) {
        User user = userDao.queryForId(Integer.valueOf(userId));
        //财务审批权限校验
        String names = rpDao.queryPermissionNames(user.getUid());
        if(names.contains("财务审批")){
            return Common.resultSuccessMap(taskList("财务审批"));
        }
        return Common.resultNullData();
    }

    /**
     * 出纳员任务列表
     * @param userId 用户id
     * @return
     */
    @Override
    public Map<String, Object> cashierTaskList(String userId) {
        User user = userDao.queryForId(Integer.valueOf(userId));
        //出纳付款权限校验
        String names = rpDao.queryPermissionNames(user.getUid());
        if(names.contains("出纳付款")){
            return Common.resultSuccessMap(taskList("出纳"));
        }
        return Common.resultNullData();
    }

    /**
     * 任务列表查询
     * @param groupName 任务组名称
     * @return
     */
    private List<Map<String,Object>> taskList(String groupName) {

        TaskQuery taskQuery = pe.getTaskService().createTaskQuery();
        taskQuery.taskCandidateGroup(groupName);
        List<Task> taskList = taskQuery.list();
        List<Map<String,Object>> listMap = new ArrayList<Map<String, Object>>();
        for(Task t:taskList){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("taskId",t.getId());
            map.put("taskName",t.getName());
            //通过任务的insId->获取流程实例->业务id
            String businessKey = pe.getRuntimeService().createProcessInstanceQuery().processInstanceId(t.getProcessInstanceId()).singleResult().getBusinessKey();
            map.put("borrowId",businessKey);
            map.put("insId",t.getProcessInstanceId());
            map.put("createTime",t.getCreateTime());
        }
        return listMap;
    }
}
