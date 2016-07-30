package com.hly.videosys2.action;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;

import com.hly.videosys2.utils.TransformCoding;
import com.hly.videosys2.entity.Userinfo;
import com.hly.videosys2.entity.Videoinfo;
import com.opensymphony.xwork2.ModelDriven;

public class VideoUploadAction extends BaseAction<Videoinfo> implements
		ModelDriven<Videoinfo> {
	private File myVideo;
	private String myVideoFileName;
	
	public String upload() throws InputFormatException, EncoderException, IOException
	{
		String destPath = "F:/video_upload";
		Userinfo userinfo = (Userinfo) session.get("userinfo");
		if(userinfo.getUserAuthority() != 2)
		{
			return SUCCESS;
		}
		model.setUploadByUser(userinfo.getUsername());
		System.out.println("Src File name: " + myVideo);
		System.out.println("Dst File name: " + myVideoFileName);
		//提取视频格式
		String videoName = myVideoFileName.substring(0 , myVideoFileName.lastIndexOf("."));  
		String type =  myVideoFileName.substring(myVideoFileName.lastIndexOf(".") + 1, myVideoFileName.length()).toLowerCase(); 
		model.setVideoName(videoName);
		SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmss");
		String videoUrl = df2.format(new Date()) + ((new Random()).nextInt(900) + 100);
		//现在file是由时间和随机数组成的字符串了,不是之前的名字
		model.setVideoUrl(videoUrl);
		//新建文件,名字是由字符串组成
		File destFile = new File(destPath, videoUrl + "." + type);
		//上传视频,即把视频复制过来
		FileUtils.copyFile(myVideo, destFile);
		//获取视频时长,ls单位毫秒
        Encoder encoder = new Encoder();
        long ls = 0;
        MultimediaInfo m = encoder.getInfo(destFile);
        ls = m.getDuration();
        model.setVideoLength(ls/1000 + "");
        //获取当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.setUploadTime(df.format(new Date()));
		model.setVideoSize("1");
		model.setVideoPrice("-2");
		model.setVideoSubject("未分类");
		model.setVideoGrade("未分类");
		model.setVideoPlayTimes(0);
		model.setVideoExamineState("0");
		model.setVideoUploadInfo("上传完成,等待格式转换");
		//数据库插入,至此上传完成
		videoManageService.save(model);
		try {
			//转换视频格式,转换成功前,视频状态为-2
			String oldVideoUrl = TransformCoding.transformCoding(videoUrl,type);
			model.setVideoUploadInfo("格式转换完成!");
			model.setVideoPrice("0");
			//删除原格式视频
			File file = new File(oldVideoUrl);  
		    if (file.isFile() && file.exists())
		        file.delete();  
		} catch (IOException e) {
			model.setVideoUploadInfo("格式转换出现故障!");
			e.printStackTrace();
		}
		//转换成功后,更新数据信息
		videoManageService.update(model);
		return SUCCESS;
	}

	public void setMyVideo(File myVideo) {
		this.myVideo = myVideo;
	}

	public void setMyVideoFileName(String myVideoFileName) {
		this.myVideoFileName = myVideoFileName;
	} 
    
}
