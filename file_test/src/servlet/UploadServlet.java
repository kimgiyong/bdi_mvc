package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/up/*")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		String tmpPath = System.getProperty("java.io.tmpdir");
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		String savePath = "C:\\bdi_study\\workspace\\file_test\\WebContent\\upload";
		System.out.println("니가 요청하는 명령은 : " + cmd );
		DiskFileItemFactory dfac = new DiskFileItemFactory();
		dfac.setRepository(new File(tmpPath));
		
		ServletFileUpload sfu = new ServletFileUpload(dfac);
		try {
			List<FileItem> fList = sfu.parseRequest(request);
			int cnt = 0;
			for(int i=0;i<fList.size();i++) {
				FileItem fi = fList.get(i);
				if(fi.isFormField()) {
					
				}else {
					cnt++;
					String name = fi.getFieldName();
					String fileName = fi.getName();
					File saveFile = new File(savePath + File.separator + fileName);
					try {
						if(!saveFile.exists()) {
							fi.write(saveFile);
						}else {
							cnt--;
						}
					} catch (Exception e) {
						cnt--;
						e.printStackTrace();
					}
				}
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("업로드한 파일 갯수는 : " + cnt);
		}catch(FileUploadException e) {
			e.printStackTrace();
		}
	}
}
