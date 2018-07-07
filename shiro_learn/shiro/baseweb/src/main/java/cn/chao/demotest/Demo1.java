package cn.chao.demotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/7/7 0007 10:43
 */
public class Demo1 {

    @Test
    public void testHelloWorld(){
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","1233");

        try{
            //4、登录，即身份验证
            subject.login(token);
        }catch (AuthenticationException aex){
            //5、身份验证失败
        }

        Assert.assertEquals(true,subject.isAuthenticated());//断言用户已经登录

        //6、退出
        subject.logout();


        /**
         * 如上测试的几个问题：
             1、用户名/密码硬编码在ini配置文件，以后需要改成如数据库存储，且密码需要加密存储；
             2、用户身份Token可能不仅仅是用户名/密码，也可能还有其他的，如登录时允许用户名/邮箱/手机号同时登录。
         */
    }
}
