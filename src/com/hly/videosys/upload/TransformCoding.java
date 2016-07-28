package com.hly.videosys.upload;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TransformCoding{
	private static String PATH; 
	private final static String destPath = "F:/video_upload/";
	private static String videoName; 
	private static String type; 
	private static boolean isMp4; 
	
	public static String transformCoding(String _videoName,String _type) throws IOException{
		isMp4 = false;
        videoName = _videoName;
        type =  _type;
		PATH = destPath + videoName + "." + type;
		System.out.println(videoName);
		System.out.println(type);
		System.out.println(PATH);
        if (!checkfile(PATH)) {  
            System.out.println(PATH + " is not file");
        }  
        if (process(type)) {  
            System.out.println("ok");  
        }
        if (!isMp4 && PATH != null && !PATH.equals(""))
        	return PATH;
        else
        	return "mp4";
    }  
	  
    private static boolean process(String _type) {  
        int type = checkContentType(_type);  
        boolean status = false;  
        if (type == 0) {  
            System.out.println("直接将文件转为mp4文件");  
            status = processMP4(PATH);// 直接将文件转为flv文件  
        } /*else if (type == 1) {  
            String avifilepath = processAVI(type);  
            if (avifilepath == null)  
                return false;// avi文件没有得到  
            status = processFLV(avifilepath);// 将avi转为flv  
        }*/
        return status;  
    }  
  
    private static int checkContentType(String type) {  
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）  
        if (type.equals("avi")) {  
            return 0;  
        } else if (type.equals("mpg")) {  
            return 0;  
        } else if (type.equals("wmv")) {  
            return 0;  
        } else if (type.equals("3gp")) {  
            return 0;  
        } else if (type.equals("mov")) {  
            return 0;  
        } else if (type.equals("mp4")) {
        	isMp4 = true;
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),  
        // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.  
        //else if (type.equals("wmv9")) {  
        //    return 1;  
        //} else if (type.equals("rm")) {  
        //    return 1;  
        //} else if (type.equals("rmvb")) {  
        //    return 1;  
        //}  
        return 9;  
    }  
  
    private static boolean checkfile(String path) {  
        File file = new File(path);  
        if (!file.isFile()) {  
            return false;  
        }  
        return true;  
    }  
  
    // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.  
  
    /* private static String processAVI(int type) {  
        List<String> commend = new ArrayList<String>();  
        commend.add("c:\\ffmpeg\\mencoder");  
        commend.add(PATH);  
        commend.add("-oac");  
        commend.add("lavc");  
        commend.add("-lavcopts");  
        commend.add("acodec=mp3:abitrate=64");  
        commend.add("-ovc");  
        commend.add("xvid");  
        commend.add("-xvidencopts");  
        commend.add("bitrate=600");  
        commend.add("-of");  
        commend.add("avi");  
        commend.add("-o");  
        commend.add("F:/uploadFiles/a.avi");  
        try {  
            ProcessBuilder builder = new ProcessBuilder();  
            builder.command(commend);  
            builder.start();  
            return "F:/uploadFiles/a.avi";  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  */
  
    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）  
    private static boolean processMP4(String oldfilepath) {  
  
        if (!checkfile(PATH)) {  
            System.out.println(oldfilepath + " is not file");  
            return false;  
        }  
          
        // 文件命名  
        Calendar c = Calendar.getInstance();  
        String savename = String.valueOf(c.getTimeInMillis())+ Math.round(Math.random() * 100000);  
        List<String> commend = new ArrayList<String>();  
        commend.add("E:/Desktop/videoClass/resources/ffmpeg/bin/ffmpeg");  
        commend.add("-i");  
        commend.add(oldfilepath);  
        commend.add("-ab");  
        commend.add("56");  
        commend.add("-ar");  
        commend.add("22050");  
        commend.add("-qscale");  
        commend.add("8");  
        commend.add("-r");  
        commend.add("15");  
        //commend.add("-s");  
        //commend.add("600x500");  
        commend.add(/*"F:\\apache-tomcat\\webapps\\VideoClass\\"*/destPath + videoName + ".mp4");  
  
        String cutCmd = screenShot(oldfilepath,videoName);
        Runtime runtime = Runtime.getRuntime();  
        try {
			Process proce = runtime.exec(cutCmd);
			if(!isMp4)
			{
				ProcessBuilder builder = new ProcessBuilder(commend);  
				builder.command(commend);  
				Process a = builder.start();
				new PrintStream(a.getErrorStream()).start();
				new PrintStream(a.getInputStream()).start();
				a.waitFor();
			}
			new PrintStream(proce.getErrorStream()).start();
			new PrintStream(proce.getInputStream()).start();
			proce.waitFor();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}  
    }  
	
    private static String screenShot(String oldfilepath,String videoName){
         String cmd = "";  
         String cut = "E:\\Desktop\\videoClass\\resources\\ffmpeg\\bin\\ffmpeg.exe -i "  
                 + oldfilepath  
                 + " -ss 1 -f image2 -t 0.001 -s 320x240 "  
                 + /*"F:\\apache-tomcat\\webapps\\VideoClass\\"*/destPath + videoName + ".jpg";  
         System.out.println("cut" + cut);
         String cutCmd = cmd + cut;  
         return cutCmd;  
    }
    
}
class PrintStream extends Thread 
{
	java.io.InputStream __is = null;
	public PrintStream(java.io.InputStream is) 
	{
		__is = is;
	} 
	
	public void run() 
	{
		try 
		{
			while(this != null) 
			{
				int _ch = __is.read();
				if(_ch != -1) 
					System.out.print((char)_ch); 
				else break;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
}
