package com.hf.finance.controller;

import com.hf.finance.entity.form.BorrowForm;
import com.hf.finance.service.BorrowFlowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 借支流程
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/16 0016 9:50
 */
@Controller
@RequestMapping("/borrow/flow")
public class BorrowFlowController {
    @Resource
    private BorrowFlowService borrowFlowService;

    /**
     * 提交借支申请
     * @param borrow 申请表单
     * @return
     */
    @RequestMapping(name = "/apply",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> applyBorrow(BorrowForm borrow){
        return borrowFlowService.startProcess(borrow);
    }
}
