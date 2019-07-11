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
		// ���������ļ����
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// �������Ľ�����
		ServletFileUpload FileUpload = new ServletFileUpload(
				diskFileItemFactory);
		// ��ʱ�ļ����·��
		String tempPath = getServletContext().getRealPath("/temp");
		diskFileItemFactory.setRepository(new File(tempPath));
		// ����request
		List<FileItem> list;
		try {
			list = FileUpload.parseRequest(request);

			// ����
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					// �������ͨ���ϴ� ��ȡ�ļ���
					String name = fileItem.getFieldName();
					// �����ͨ���ֵ
					String value = fileItem.getString("UTF-8");
					System.out.println(name + value);
				} else {
					// �ļ��ϴ� �õ��ļ�������
					String filename = fileItem.getName();
					//�ļ��ϴ��������������
					//���ʹ��IE�ϰ汾�����������һ���ļ����ƻ�ȡ�������⡣IE�ϰ汾��ȡ�ļ����Ƶ�ʱ�򣬻����·����
					int indexOf = filename.lastIndexOf("\\");
					if ( indexOf != -1 ) {
						filename = filename.substring(indexOf+1);
					}
					filename = getUUIDfilename(filename);
					// �õ��ļ�����������
					InputStream is = fileItem.getInputStream();
					// ����ļ����ļ��е�·��
					String realPath = getServletContext()
							.getRealPath("/upload");
					// ���������
					FileOutputStream fos = new FileOutputStream(realPath + "/"
							+ filename);
					// ��������������Խ�
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

	//�ļ��ϴ�ͬһ��Ŀ¼���ļ�ͬ������
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