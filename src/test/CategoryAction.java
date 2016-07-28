package test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hly.videosys.utils.Category;
import com.opensymphony.xwork2.ModelDriven;

@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> implements ModelDriven<Category>  {  
    
    private Category category;//设置一个私有成员变量接收url带过来的参数，注意下面要写好get和set方法  
      
	public String update() {  
		System.out.println("----update----"); 
		System.out.println(model);   
		categoryService.update(model);//直接使用model  
		return "index";  
	}  
    
	public String save() {  
		System.out.println("----save----");  
		System.out.println(model); //直接使用model  
		categoryService.update(model);
		return "index";  
	} 
    
    public String query() {  
        //解决方案一，采用相应的map取代原来的内置对象，这样与jsp没有依赖，但是代码量比较大  
//     ActionContext.getContext().put("categoryList", categoryService.query()); //放到request域中  
//     ActionContext.getContext().getSession().put("categoryList", categoryService.query()); //放到session域中  
//     ActionContext.getContext().getApplication().put("categoryList", categoryService.query()); //放到application域中  
         
       //解决方案二，实现相应的接口(RequestAware,SessionAware,ApplicationAware)，让相应的map注入  
       request.put("categoryList", categoryService.query());
       session.put("categoryList", categoryService.query());
       application.put("categoryList", categoryService.query());
       return "index";
   }

}