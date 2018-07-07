package com.hf.finance.service;

import java.io.InputStream;

/**
 * 流程定义service
 */
public interface ProcessDefinitionService {

    /**
     * 部署流程定义
     * @param in
     * @return
     */
    public void deploy(InputStream in);

    /**
     * 部署流程定义classpath方式
     * @param path 文件路径：例如：diagrams/leave_test.bpmn20.xml
     */
    public void deploy2(String path,String name);
}
