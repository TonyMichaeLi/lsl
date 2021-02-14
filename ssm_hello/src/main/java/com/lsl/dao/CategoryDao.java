package com.lsl.dao;

import com.lsl.page.Page;
import com.lsl.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {

    int add(Category category);

    void delete(int id);

    int update(Category category);

    Category get(int id);

    List<Category> list();

//    List<Category> listPage(Page page);
//
//    int total();

}
