package com.ace2.mybatisplug.controller.common;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonController {
    private Log log = LogFactory.getLog(this.getClass());

    /**
     * Request对象(存在于用户的每个请求)
     */
    private HttpServletResponse response;
    private HttpServletRequest request;

    protected HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        request = servletRequestAttributes.getRequest();
        return request;
    }

    protected HttpServletResponse getResponse() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        response = servletRequestAttributes.getResponse();
        return response;
    }

//    protected Users getCurrentUser() {
//        HttpSession session = request.getSession();
//        if (request != null && session != null) {
//            if (session.getAttribute(GlobalConstant.USER_LOGIN_SESSION) != null) {
//                return (UserInfo) session.getAttribute(GlobalConstant.USER_LOGIN_SESSION);
//            }
//        }
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserName("System");
//        session.setAttribute(GlobalConstant.USER_LOGIN_SESSION, userInfo);
//        // TODO 暂时传递一个空User
//        return userInfo;
//    }


}
