package cn.chao.demotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * 数据库域
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/7/7 0007 14:33
 */
public class JdbcDemo3 {
    @Test
    public void test1(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try{
            subject.login(token);
        }catch (AuthenticationException aex){
            System.err.println("验证失败");
        }

        boolean flag = subject.isAuthenticated();
        System.out.println("验证结果："+flag);
    }
}
