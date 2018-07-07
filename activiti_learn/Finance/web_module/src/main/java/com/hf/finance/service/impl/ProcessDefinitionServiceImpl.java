package com.hf.finance.service.impl;

import com.hf.finance.service.ProcessDefinitionService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

@Service
@Transactional
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {
	@Resource
	private ProcessEngine pe;

	/**
	 * 部署流程定义 inputStream 方式
	 * @param in
	 */
	public void deploy(InputStream in) {
		Deployment deployment = pe.getRepositoryService()//获取流程定义和部署对象相关的Service
				.createDeployment()//创建部署对象
				.addZipInputStream(new ZipInputStream(in))//使用zip方式部署，将helloworld.bpmn和helloworld.png压缩成zip格式的文件
				.deploy();//完成部署

		System.out.println("部署ID："+deployment.getId());
		System.out.println("部署时间："+deployment.getDeploymentTime());
	}

	/**
	 * 部署流程定义classpath方式
	 * @param path 文件路径：例如：diagrams/leave.bpmn20.xml
	 */
	public void deploy2(String path,String name){
		DeploymentBuilder builer = pe.getRepositoryService().createDeployment().name(name);
		builer.addClasspathResource(path);
		Deployment deploy = builer.deploy();
		System.out.println("部署ID："+deploy.getId());
		System.out.println("部署时间："+deploy.getDeploymentTime());
	}

}
