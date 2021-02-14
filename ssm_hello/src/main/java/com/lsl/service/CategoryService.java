package com.lsl.service;

import com.lsl.page.Page;
import com.lsl.pojo.Category;

import java.util.List;

public interface CategoryService {

    int add(Category category);

    void delete(int id);

    int update(Category category);

    Category get(int id);

    List<Category> list();

    void addTwo();

    void deleteAll();

}
