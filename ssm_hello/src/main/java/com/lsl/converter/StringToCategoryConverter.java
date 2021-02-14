package com.lsl.converter;

import com.lsl.pojo.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

//字符串对象转换器
public class StringToCategoryConverter implements Converter<String,Category> {

    @Override
    public Category convert(String str) {
        //空串
        if (StringUtils.isEmpty(str))
            return null;
        //不包含指定字符
        if (str.indexOf("-") == -1)
            return null;

        String[] arr = str.split("-");

        //字符串长度不对
        if (arr.length != 2)
            return null;
        Category category = new Category();
        category.setId(Integer.parseInt(arr[0]));
        category.setName(arr[1]);
        return category;
    }
}
