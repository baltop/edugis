package com.ziumks.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Request�� Encoding ����� ���͸��ϴ� Ŭ����
 * 
 * @author Administrator
 * 
 */
public class EncodingFilter implements Filter {
	/** ���ڵ� */
	private String encoding = null;

	/** ���� */
	protected FilterConfig filterConfig = null;

//	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * �Ҹ���
	 */
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}

	/**
	 * ���� ó��
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request.getCharacterEncoding() == null) {
			if (encoding != null) {
				request.setCharacterEncoding(encoding);
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * �ʱ�ȭ
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	/**
	 * ���͸� ���´�.
	 * 
	 * @return
	 */
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	/**
	 * ���͸� �����Ѵ�.
	 * 
	 * @param cfg
	 */
	public void setFilterConfig(FilterConfig cfg) {
		filterConfig = cfg;
	}
}
