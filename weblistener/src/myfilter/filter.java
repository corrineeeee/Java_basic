package myfilter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class filter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
		System.out.println("filter");
		//·ÅÐÐ
		fc.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig fcon) throws ServletException {
		String filterName = fcon.getFilterName();
		String username = fcon.getInitParameter("username");
		String password = fcon.getInitParameter("password");
		Enumeration<String> names = fcon.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = fcon.getInitParameter(name);
			System.out.println(name+value);
		}
	}

}
