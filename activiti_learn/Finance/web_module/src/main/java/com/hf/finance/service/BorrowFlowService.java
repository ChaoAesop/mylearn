package com.hf.finance.service;

import com.hf.finance.entity.form.BorrowForm;

import java.util.Map;

/**
 * 借支流程
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/16 0016 9:11
 */
public interface BorrowFlowService {
    /**
     * 启动借支流程
     * @param bform 申请表单
     * @return
     */
    Map<String,Object> startProcess(BorrowForm bform);

    /**
     * 部门经理任务列表
     * @param userId 当前用户id
     * @return
     */
    Map<String,Object> deptTaskList(String userId);

    /**
     * 公司任务列表
     * @param userId 用户id
     * @return
     */
    Map<String, Object> companyTaskList(String userId);


    /**
     *  财务任务列表
     * @param userId 用户id
     * @return
     */
    Map<String, Object> financeTaskList(String userId);

    /**
     *  出纳员任务列表
     * @param userId 用户id
     * @return
     */
    public Map<String, Object> cashierTaskList(String userId);
}
