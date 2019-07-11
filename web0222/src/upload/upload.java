package upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class upload
 */
public class upload extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 创建磁盘文件项工厂
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 创建核心解析类
		ServletFileUpload FileUpload = new ServletFileUpload(
				diskFileItemFactory);
		// 临时文件存放路径
		String tempPath = getServletContext().getRealPath("/temp");
		diskFileItemFactory.setRepository(new File(tempPath));
		// 解析request
		List<FileItem> list;
		try {
			list = FileUpload.parseRequest(request);

			// 遍历
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					// 如果是普通项上传 则取文件名
					String name = fileItem.getFieldName();
					// 获得普通项的值
					String value = fileItem.getString("UTF-8");
					System.out.println(name + value);
				} else {
					// 文件上传 拿到文件的名称
					String filename = fileItem.getName();
					//文件上传兼容浏览器问题
					//如果使用IE老版本的浏览器出现一个文件名称获取错误问题。IE老版本获取文件名称的时候，会带有路径。
					int indexOf = filename.lastIndexOf("\\");
					if ( indexOf != -1 ) {
						filename = filename.substring(indexOf+1);
					}
					filename = getUUIDfilename(filename);
					// 拿到文件的内容数据
					InputStream is = fileItem.getInputStream();
					// 存放文件的文件夹的路径
					String realPath = getServletContext()
							.getRealPath("/upload");
					// 创建输出流
					FileOutputStream fos = new FileOutputStream(realPath + "/"
							+ filename);
					// 输出流和输入流对接
					int len = 0;
					byte[] b = new byte[1024];
					while ((len = is.read(b)) != -1) {
						fos.write(b, 0, len);
					}
					is.close();
					fos.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//文件上传同一个目录下文件同名问题
	public static String getUUIDfilename(String filename){
		int indexOf = filename.lastIndexOf(".");
		String substring = filename.substring(indexOf);
		String replace = UUID.randomUUID().toString().replace("-", "");
		filename = replace+substring;
		return filename;
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
