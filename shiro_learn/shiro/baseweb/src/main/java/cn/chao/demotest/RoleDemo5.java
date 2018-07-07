package cn.chao.demotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 角色访问控之隐式角色
 * 这种方式的缺点就是如果很多地方进行了角色判断，但是有一天不需要了那么就需要修改相应代码把所有相关的地方进行删除；这就是粗粒度造成的问题。
 *
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/7/7 0007 16:06
 */
public class RoleDemo5 {
    /**
     * 验证
     * @param configFile
     * @param uname
     * @param pwd
     */
    private void login(String configFile,String uname,String pwd) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(uname,pwd);

        subject.login(token);
    }
    private Subject subject(){
        return SecurityUtils.getSubject();
    }

    @Test
    public void testHasRole(){
        login("classpath:shiro-role.ini","zhang","123");

        //用户是否有某个角色
        Assert.assertTrue(subject().hasRole("role1"));

        //用户是否有某些角色
        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2")));

        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
    }

    @Test
    public void testCheckRole() {
        login("classpath:shiro-role.ini", "zhang", "123");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        subject().checkRoles("role1", "role3");
    }
}
