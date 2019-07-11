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
 * ServletConfig ����
 */
public class web_02 extends HttpServlet {
	
	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//��ó�ʼ��������API
	//���ServletConfig����
	ServletConfig config = this.getServletConfig();
	String name = config.getInitParameter("username");
	String pswd = config.getInitParameter("password");
	System.out.println(name+pswd);
	
	//������г�ʼ������������
	Enumeration<String> names = config.getInitParameterNames();
	while(names.hasMoreElements()){
		String name1 = names.nextElement();
		String name1value = config.getInitParameter(name1);
		System.out.println(name1+name1value);
	}
	
	//���Servlet����
	String servletName = config.getServletName();
	System.out.println(servletName);
	
	//��ȡ�ļ�MIME����
	//�Ȼ��ServletContext����(һ��web��Ŀֻ��һ��)
	ServletContext context = this.getServletContext();
	String mimeType = context.getMimeType("ab.txt");
	System.out.println(mimeType);
	//���web��Ŀ����·���Ĺ�����
	String contextPath = context.getContextPath();
	System.out.println(contextPath);
	
	//���ȫ�ֳ�ʼ������
	String name2 = context.getInitParameter("username");
	String pswd2 = context.getInitParameter("password");
	System.out.println(name2+pswd2);
	Enumeration<String> names2 = context.getInitParameterNames();
	while(names2.hasMoreElements()){
		String name3 = names2.nextElement();
		String name3value = context.getInitParameter(name3);
		System.out.println(name3+name3value);
	}
	
	///ServletContext���������:��ȡweb��Ŀ�µ��ļ�
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

	//ServletContext��Ϊ�����
	String name3 = (String) this.getServletContext().getAttribute("name");
	System.out.println(name3);
	
	//������Ӧ��״̬��
	//response.setStatus(404);
	//����ض���
	//response.setStatus(302);
	//response.setHeader("Location", "/web_test1/web_01");

	response.setContentType("text/html;charset=UTF-8");
	response.getWriter().println("5s restart");
	response.setHeader("Refresh", "5;url=/web_test1/web_01");
	
	
	}



	


	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute("name", "��corrine");
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
