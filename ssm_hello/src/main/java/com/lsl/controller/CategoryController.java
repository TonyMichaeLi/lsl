package com.lsl.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.SerializableString;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lsl.page.Page;
import com.lsl.pojo.Category;
import com.lsl.pojo.Role;
import com.lsl.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    //测试自定义字符串对象转换器
    @ResponseBody
    @RequestMapping("/updateCategory")
    //uri:http://localhost:8080/category/updateCategory?category=11-name
    public Map<String,Object> updateCategory(Category category){
        logger.info("======================category:"+category+"==================");
        Map<String, Object> result = new HashMap<String, Object>();
        boolean flag = (service.update(category) == 1);
        result.put("success",flag);
        if (flag)
            result.put("msg","更新成功");
        else
            result.put("msg","更新失败");
        return result;
    }

    @ResponseBody //注解，使得Spring mvc把结果转化为JSON类型响应，进而找到转换器
    @RequestMapping("/getCategory")
    public Category getCategory(int id){
        Category category = service.get(id);
        return category;
    }

    //实现重定向
    @RequestMapping("/addCategory/{name}")
    public String addCategory(Model model,@PathVariable("name") String name){
        Category category = new Category();
        category.setName(name);
        int id = service.add(category);
        model.addAttribute("name",name);
        model.addAttribute("id",id);
        return "redirect:/category/showCategoryJsonInfo";
    }

    //通过ModelAndView实现重定向
    @RequestMapping("/addCategory2/{name}")
    public ModelAndView addRole2(ModelAndView mv,@PathVariable("name") String name){
        Category category = new Category();
        category.setName(name);
        int id = service.add(category);
        mv.addObject("name",name);
        mv.addObject("id",category.getId());
        mv.setViewName("redirect:/category/showCategoryJsonInfo");
        return mv;
    }

    //重定向传递POJO
    @RequestMapping("/addCategory3")
    public String addCategory(RedirectAttributes redirectAttributes,@RequestBody Category category){
        logger.info("==============="+category+"================");
        service.add(category);
        redirectAttributes.addFlashAttribute("category",category);
        return "redirect:/category/showCategoryJsonInfo";
    }

    @RequestMapping("/showCategoryJsonInfo")
    public ModelAndView showCategoryJsonInfo(Category category){
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject(category);
        return mv;
    }

    //接收前台的序列化表单
    @RequestMapping("/submitSerializeForm")
    public ModelAndView submitSerializeForm(String roleName,String note){
        logger.info("roleName==>"+roleName+"\tnote==>"+note);
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    //传递list到前台
    @RequestMapping("/getList")
    public ModelAndView getListToWeb(){
        List<Category> list = service.list();
        ModelAndView mv = new ModelAndView();
        mv.addObject(list);
        //设置json视图
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    //使用URL传递参数
    @RequestMapping("/getRole/{id}")
    public ModelAndView pathVariable(@PathVariable("id") int id){
        Category category = service.get(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(category);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    //接收json数据列表 List<Role>
    @RequestMapping("/submitList")
    public ModelAndView submitList(@RequestBody List<Role> idList){
        ModelAndView mv = new ModelAndView();
        logger.info("接收到的json数据列表为:"+idList);
        mv.addObject(idList);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @PostMapping("/submitRole")
    public String submitRole(@RequestBody Role role){
        logger.info("SSM接受到浏览器提交的json，并转换为role对象:"+role);
        return "ok";
    }

    @PostMapping("/submitCategory")
    public ModelAndView submitCategory(@RequestBody Category category){
        logger.info("\nSSM接受到浏览器提交的json，并转换为Category对象:"+category+"\n");
        Category category1 = service.get(category.getId());
        ModelAndView mv = new ModelAndView();
        mv.addObject(category1);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory() {
        Category c = new Category();
        c.setId(109);
        c.setName("第109个分类");
        JSONObject json= new JSONObject();
        json.put("category", JSONObject.toJSON(c));
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory() {
        List<Category> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("分类名称:"+i);
            cs.add(c);
        }

        return JSONObject.toJSON(cs).toString();
    }

    @RequestMapping(value = "/categorys",method = RequestMethod.GET)
    public ModelAndView list(Page page,ModelAndView mv){

        PageHelper.offsetPage(page.getStart(),page.getCount());

        List<Category> list = service.list();
        int total = (int) new PageInfo<Category>(list).getTotal();

        page.caculateLast(total);
        int totalPage = page.caculateTotalPage(total);

        logger.info("==============访问了list方法=============");

        //list.jsp 提交的start和count会自动注入到参数 page 里
        // 参数page会默认被当做值加入到ModelAndView 中，相当于：
        mv.addObject("page",page);

        mv.addObject("list",list);
        mv.addObject("total",total);
        mv.addObject("totalPage",totalPage);
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(ModelAndView mv){
        mv.setViewName("add");
        return mv;
    }

    @RequestMapping(value = "/categorys",method = RequestMethod.POST)
    public ModelAndView add(Category category,ModelAndView mv){
        service.add(category);
        //service.addTwo();
        mv.setViewName("redirect:/category/categorys");
        return mv;
    }

    @RequestMapping(value = "/categorys/{id}",method = RequestMethod.GET)
    public ModelAndView toUpdate(@PathVariable("id") int id,ModelAndView mv){
        Category category = service.get(id);
        mv.addObject("category",category);
        mv.setViewName("update");
        return mv;
    }

    @RequestMapping(value = "/categorys/{id}",method = RequestMethod.PUT)
    public ModelAndView update(Category category,ModelAndView mv){
        logger.info(category+"");
        service.update(category);
        mv.setViewName("redirect:/category/categorys");
        return mv;
    }

    @RequestMapping(value = "/categorys/{id}",method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") int id,ModelAndView mv){
        service.delete(id);
        mv.setViewName("redirect:/category/categorys");
        return mv;
    }

}
