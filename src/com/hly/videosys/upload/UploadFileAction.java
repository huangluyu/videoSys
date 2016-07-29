package com.hly.videosys.upload;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

import org.apache.commons.io.FileUtils;

import java.io.IOException; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import com.hly.videosys2.entity.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.*;

public class UploadFileAction extends ActionSupport{
	private File myVideo;
	//private String myFileContentType;
	private String myVideoFileName;
	private String destPath;
	private String setVideoName;
	private String gradeSelect;
	private String subjectSelect;
	// for action
	private String message;
	

	public String execute()
	{
		String username;
		String filename;
		destPath = "F:/video_upload";
		/**
		 * Src File name: F:\apache-tomcat-8.0.36\work\Catalina\localhost\VideoClass2\ u pload_46b8055f_ae9c_47af_a9ed_17e5dc5cf889_00000003.tmp
		   Dst File name: 20160702160747792.mp4
		 *
		 *
		 *
		 */
		//File file=new File("."); 
		//String path=file.getAbsolutePath();
		//path = file.getPath();
		try{
			ActionContext actionContext = ActionContext.getContext();
			Map<String, Object> session = actionContext.getSession();
			Userinfo userinfo = (Userinfo) session.get("userinfo");
			if(userinfo.getUserAuthority() != 2)
			{
				message = "抱歉,您没有上传视频的权限";
				return SUCCESS;
			}
			username = (String)session.get("username");
			System.out.println("Src File name: " + myVideo);
			System.out.println("Dst File name: " + myVideoFileName);

			//提取视频格式
			//String fileName = myVideoFileName.substring(0 , _videoName.lastIndexOf(".") - 1);  
			String type =  myVideoFileName.substring(myVideoFileName.lastIndexOf(".") + 1, myVideoFileName.length()).toLowerCase(); 
			
			SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmss");
			filename = df2.format(new Date()) + ((new Random()).nextInt(900) + 100);
			myVideoFileName = filename;
			//新建文件
			File destFile = new File(destPath, myVideoFileName + "." + type);
			//上传视频
			FileUtils.copyFile(myVideo, destFile);
			//获取视频时长
	        Encoder encoder = new Encoder();
	        long ls = 0;
	        MultimediaInfo m = encoder.getInfo(destFile);
	        ls = m.getDuration();
	        //获取当前时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//设置视频名称(从网页上读取)
			if (!setVideoName.equals(""))
				filename = setVideoName;
			//数据库插入
			UploadJdbc.videoInfoAdd(filename,myVideoFileName,username,df.format(new Date()),ls/1000 + "",gradeSelect,subjectSelect);
			UploadJdbc.addUploadState(myVideoFileName, "上传完成,等待格式转换");
			//转换视频格式,转换成功前,视频状态为-2
			String oldVideoUrl = TransformCoding.transformCoding(myVideoFileName,type);
			UploadJdbc.updateUploadState(myVideoFileName, "格式转换完成!");
			UploadJdbc.updateVideoState(myVideoFileName);
			//删除原格式视频
			File file = new File(oldVideoUrl);  
		    if (file.isFile() && file.exists()) {  
		        file.delete();  
		    } 
		} catch(IOException e) {
			e.printStackTrace();
			message = "视频上传过程中出现了错误!请联系管理员!";
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			message = "视频上传过程中出现了错误!请联系管理员!";
			return SUCCESS;
		}
		message = "视频:" + filename + "上传成功!";
		return SUCCESS;
	}
	
	/*public String getMyFileContentType() {
		return myFileContentType;
	}
	
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}*/

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getGradeSelect() {
		return gradeSelect;
	}

	public void setGradeSelect(String gradeSelect) {
		this.gradeSelect = gradeSelect;
	}

	public String getSubjectSelect() {
		return subjectSelect;
	}

	public void setSubjectSelect(String subjectSelect) {
		this.subjectSelect = subjectSelect;
	}

	public File getMyVideo() {
		return myVideo;
	}

	public void setMyVideo(File myVideo) {
		this.myVideo = myVideo;
	}

	public String getMyVideoFileName() {
		return myVideoFileName;
	}

	public void setMyVideoFileName(String myVideoFileName) {
		this.myVideoFileName = myVideoFileName;
	}

	public String getSetVideoName() {
		return setVideoName;
	}

	public void setSetVideoName(String setVideoName) {
		this.setVideoName = setVideoName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
}