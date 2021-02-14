package com.lsl.service.impl;

import com.lsl.dao.CategoryDao;
import com.lsl.page.Page;
import com.lsl.pojo.Category;
import com.lsl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public int add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public int update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public List<Category> list() {
        return categoryDao.list();
    }

    @Override
    //@Transactional
    public void addTwo() {
        Category category1 = new Category();
        category1.setName("短的名字");
        categoryDao.add(category1);

        Category category2 = new Category();
        category1.setName("长的名字字段装不下，长的名字字段装不下，长的名字字段装不下，长的名字字段装不下，长的名字字段装不下，" +
                "长的名字字段装不下，长的名字字段装不下，长的名字字段装不下,长的名字字段装不下");
        categoryDao.add(category2);

    }

    @Override
    public void deleteAll() {
        List<Category> list = categoryDao.list();
        for (Category category : list){
            categoryDao.delete(category.getId());
        }
    }

}
