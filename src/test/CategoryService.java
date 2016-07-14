package test;

import java.util.List;

import com.hly.videosys.utils.Category;

//CategoryService接口  
public interface CategoryService extends BaseService<Category> {  
    
  public void save(Category category); //插入  

  public void update(Category category);//更新  
    
  public void delete(int id); //删除  
    
  public Category get(int id); //获取一个Category  
    
  public List<Category> query(); //获取全部Category  

}  
