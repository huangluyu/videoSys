package com.hly.videosys2.action.ajax;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.hly.videosys2.action.BaseAction;
import com.hly.videosys2.entity.Userinfo;
import com.opensymphony.xwork2.ModelDriven;

public class LoginVerifyAjaxAction extends BaseAction<Userinfo> implements
		ModelDriven<Userinfo> {

	private InputStream inputStream;  
	
	public InputStream getResult()  
	{  
	    return inputStream;  
	}  
	
	public String loginVerify()  
	{  
		String key = null;
		
		model = (Userinfo) session.get("userinfo");
		
		if(model != null)
			key = "{\"username\":\"" + model.getRealName() + "\",\"money\":\"" + model.getMoney() + "\",\"authority\":\"" + model.getUserAuthority() + "\"}";	
		else
			key = "{\"username\":\"null\"}";
		System.out.println(key);
	    try 
	    {  
	    	inputStream = new ByteArrayInputStream(key.getBytes("UTF-8"));  
	    }  
	    catch (UnsupportedEncodingException e)  
	    {  
	        // TODO Auto-generated catch block
	        e.printStackTrace();  
	    }  
	    return "isExist";  
	}  
	
	public String LoginVerify() {
		
		return null;
	}
}
