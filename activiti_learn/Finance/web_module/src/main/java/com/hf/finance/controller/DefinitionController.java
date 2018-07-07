package com.hf.finance.controller;

import com.hf.finance.service.ProcessDefinitionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 流程定义
 *
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/14 0014 9:57
 */
@Controller
@RequestMapping("/definition")
public class DefinitionController {
        @Resource
    private ProcessDefinitionService processDefinitionService;

    /**
     * 部署流程定义
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/deploy", method = RequestMethod.GET)
    public String deploy() throws IOException {
        processDefinitionService.deploy2("process/borrow.bpmn20.xml","借支单审核流程");
        return "definitionSuccess";
    }
}
