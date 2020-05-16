package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController  //@ResponseBody（自动将类信息转换为json格式，需要导入jackson） + Controller
                 //自动将前端form装配成bean 好像是Controller自带的功能
public class CategoryController {
    @Autowired

    CategoryService categoryService;

    @GetMapping("/categories")
    public Page4Navigator<Category> list(@RequestParam(value = "start",defaultValue = "0")
    int start,@RequestParam(value = "size",defaultValue="5")int size)throws Exception{
        start = start<0? 0:start;
        Page4Navigator<Category> page = categoryService.list(start,size,5);
        return page;
    }

    @PostMapping("/categories")
    public Object add(Category bean, MultipartFile image ,HttpServletRequest request )throws Exception{
        categoryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        System.out.println(bean.getName());
        return bean;
    }
    public void saveOrUpdateImageFile(Category bean,MultipartFile image,HttpServletRequest request)throws IOException{
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img,"jpg",file);
    }

    @DeleteMapping("/categories/{id}") //PathVariable指定变量名，将url中的值绑定到参数上。
    public String delete(@PathVariable("id") int id,
    HttpServletRequest request)  throws Exception{
        categoryService.delete(id);
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        return null; //返回 null, 会被RESTController 转换为空字符串。
    }

    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id")int id)throws Exception {
        Category bean = categoryService.get(id);
        return bean;
    }

    @PutMapping("/categories/{id}") //获取url中的id，id被自动装配到bean中
    //为什么add中bean和img就可以自动注入，但是id，name就必须要获取一下参数呢？
    //因为put 方式注入不了，或许是 springmvc 的bug ?
    //结论：post和put 在获取参数的时候，不一样
    public Object update(Category bean,MultipartFile image,HttpServletRequest request) throws Exception{
        String name = request.getParameter("name");
        bean.setName(name);
        categoryService.update(bean);

        if(image!=null){
            saveOrUpdateImageFile(bean,image,request);
        }
        return bean;
    }
}
