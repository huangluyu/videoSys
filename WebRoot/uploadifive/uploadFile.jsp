<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*, org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*, org.apache.commons.fileupload.servlet.*" %>
<%!
	
	String PATH = "\\upload\\";
	public void upload(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String savePath = this.getServletConfig().getServletContext().getRealPath("");
		savePath = savePath + PATH;
		File f1 = new File(savePath);
		System.out.println(savePath);
		//这里接收了name的值
		System.out.println(request.getParameter("name"));
		if (!f1.exists()) {
			f1.mkdirs();
		}
	
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		List fileList = null;
		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			return;
		}
		Iterator<FileItem> it = fileList.iterator();
		String name = "";
		String extName = "";
		while (it.hasNext()) {
			FileItem item = it.next();
			if (!item.isFormField()) {
				name = item.getName();
				long size = item.getSize();
				String type = item.getContentType();
				System.out.println(size + " " + type);
				if (name == null || name.trim().equals("")) {
					continue;
				}
	
				// 扩展名格式：
				if (name.lastIndexOf(".") >= 0) {
					extName = name.substring(name.lastIndexOf(".")).toLowerCase();
				}
	
				File file = null;
				do {
					// 生成文件名：
					name = UUID.randomUUID().toString();
					file = new File(savePath + name + extName);
				} while (file.exists());
	
				File saveFile = new File(savePath + name + extName);
				try {
					item.write(saveFile);//生成文件
					String sp_name = (name + extName);
					if(sp_name.endsWith("flv")||sp_name.endsWith("mp4")){
						String imgUrl = this.getServletConfig().getServletContext().getRealPath("")+"\\upload_imgs\\";
						//videoToImg((savePath + sp_name),(imgUrl + sp_name + ".jpg"));
						
						//flvToMp4((savePath + sp_name), response, (name + extName));
						//flvToTWO((savePath + sp_name), response, (name + extName), "1");
						//flvToTWO((savePath + sp_name), response, (name + extName), "2");
					}else{
						response.getWriter().write(name + extName);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//response.getWriter().write(name + extName);
	}
	
	
	
%>
<%
	upload(request, response);
%>