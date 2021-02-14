package com.lsl.test;

import com.lsl.dao.CategoryDao;
import com.lsl.page.Page;
import com.lsl.pojo.Category;
import com.lsl.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    private CategoryDao categoryDao;


    @Test
    public void testAdd(){
        for (int i=0;i<100;i++){
            Category category = new Category();
            category.setName("testPage-"+i);
            categoryDao.add(category);
        }
    }

//    @Test
//    public void testTotal(){
//        int total = categoryDao.total();
//        System.out.println(total);
//    }
//
//    @Test
//    public void testList(){
//        Page page = new Page();
//        page.setStart(0);
//        page.setCount(5);
//        List<Category> list = categoryDao.listPage(page);
//        for(Category category:list){
//            System.out.println(category.getName());
//        }
//    }

}
