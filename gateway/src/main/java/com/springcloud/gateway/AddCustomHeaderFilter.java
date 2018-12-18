package com.springcloud.gateway;

import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 *
 * @author afiore
 * Created on 2018-12-18
 */

public class AddCustomHeaderFilter extends ZuulFilter {
	
	private int id = 1;

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletResponse servletResponse = context.getResponse();
		servletResponse.addHeader("X-Response-ID", String.valueOf(id++));
		return null;
	}

}
