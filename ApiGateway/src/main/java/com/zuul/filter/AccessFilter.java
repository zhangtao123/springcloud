package com.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

    /*过滤器会在请求被路由之前执行*/
    @Override
    public String filterType() {
        return "pre";
    }

    /*过滤器的执行顺序，可能一个项目项会与第一个过滤器存在*/
    @Override
    public int filterOrder() {
        return 0;
    }

    /*判断该过滤器是否需要被执行*/
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        try{
            doSomething();
        }catch(Exception e){
            ctx.set("error.status_code",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.exception",e);
        }
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null){
            LOGGER.warn("access token is empty");
            /*过滤掉该请求，不对其进行路由*/
            ctx.setSendZuulResponse(false);
            /*设置其返回的错误码*/
            ctx.setResponseStatusCode(401);
            return null;
        }
        LOGGER.info("access token ok");
        return null;
    }

    private void doSomething(){
        throw new RuntimeException("Exist some error...");
    }
}
