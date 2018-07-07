package cn.chao.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 *
  Spring为我们提供了：
     org.springframework.web.servlet.HandlerInterceptor接口，
     org.springframework.web.servlet.handler.HandlerInterceptorAdapter适配器，
     实现这个接口或继承此类，可以非常方便的实现自己的拦截器。

  常用的处理方式：
     在preHandle中，可以进行编码、安全控制等处理；
     在postHandle中，有机会修改ModelAndView；
     在afterCompletion中，可以根据ex是否为null判断是否发生了异常，进行日志记录。
 */
public class MyInterceptor extends HandlerInterceptorAdapter{

    //Action之前执行:实现预处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Action执行前...");
        return true;

    }

    //生成视图之前执行:后处理（调用了Service并返回ModelAndView，但未进行页面渲染）
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后处理执行...");
    }

    //最后执行，可用于释放资源:返回处理（已经渲染了页面）
    //参数中的Object handler是下一个拦截器。
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("释放资源");
    }
}
