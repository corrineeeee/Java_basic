package web_01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig 对象
 */
public class web_02 extends HttpServlet {
	
	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//获得初始化参数的API
	//获得ServletConfig对象
	ServletConfig config = this.getServletConfig();
	String name = config.getInitParameter("username");
	String pswd = config.getInitParameter("password");
	System.out.println(name+pswd);
	
	//获得所有初始化参数的名称
	Enumeration<String> names = config.getInitParameterNames();
	while(names.hasMoreElements()){
		String name1 = names.nextElement();
		String name1value = config.getInitParameter(name1);
		System.out.println(name1+name1value);
	}
	
	//获得Servlet名称
	String servletName = config.getServletName();
	System.out.println(servletName);
	
	//获取文件MIME类型
	//先获得ServletContext对象(一个web项目只有一个)
	ServletContext context = this.getServletContext();
	String mimeType = context.getMimeType("ab.txt");
	System.out.println(mimeType);
	//获得web项目请求路径的工程名
	String contextPath = context.getContextPath();
	System.out.println(contextPath);
	
	//获得全局初始化参数
	String name2 = context.getInitParameter("username");
	String pswd2 = context.getInitParameter("password");
	System.out.println(name2+pswd2);
	Enumeration<String> names2 = context.getInitParameterNames();
	while(names2.hasMoreElements()){
		String name3 = names2.nextElement();
		String name3value = context.getInitParameter(name3);
		System.out.println(name3+name3value);
	}
	
	///ServletContext对象的作用:读取web项目下的文件
	//original();
	//improve();
	Properties properties = new Properties();
	String path = this.getServletContext().getRealPath("/WEB-INF/classes/wcl.properties");
	System.out.println(path);
	InputStream is = new FileInputStream(path);
	properties.load(is);
	String driverClassName = properties.getProperty("driverClassName");
	String url = properties.getProperty("url");
	String username = properties.getProperty("username");
	String password = properties.getProperty("password");
	System.out.println(driverClassName+url+username+password);

	//ServletContext作为域对象
	String name3 = (String) this.getServletContext().getAttribute("name");
	System.out.println(name3);
	
	//设置响应的状态码
	//response.setStatus(404);
	//完成重定向
	//response.setStatus(302);
	//response.setHeader("Location", "/web_test1/web_01");

	response.setContentType("text/html;charset=UTF-8");
	response.getWriter().println("5s restart");
	response.setHeader("Refresh", "5;url=/web_test1/web_01");
	
	
	}



	


	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute("name", "翁corrine");
	}

	private void improve() throws IOException {
		Properties properties = new Properties();
		InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/wcl.properties");
		properties.load(is);
		String driverClassName = properties.getProperty("driverClassName");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		System.out.println(driverClassName+url+username+password);
	}

	private void original() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		 InputStream is = new FileInputStream("classes/wcl.properties");
		 properties.load(is);
		 String driverClassName = properties.getProperty("driverClassName");
		 String url = properties.getProperty("url");
		 String username = properties.getProperty("username");
		 String password = properties.getProperty("password");
		 System.out.println(driverClassName+url+username+password);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
