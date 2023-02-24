package com.example.travelapp.service;

import com.example.travelapp.model.Category;
import com.example.travelapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public List<Category> getCategoryActive(){
        return categoryRepository.getCategoryActive();
    }


    public Map<String,Object> save(Category category){
        Map<String,Object> m=new HashMap<>();
        if(checkExistName(categoryRepository.findAll(),category.getName())==0) {
            m.put("status","1");
            m.put("message","them thanh cong");
            categoryRepository.save(category);
        }
        else {
            m.put("status","0");
            m.put("message","Ten Danh muc khong hop le");
        }
            return m;

    }

    public Category getCategory(Long id){
        return categoryRepository.findById(id).orElse(null);
    }
    public Map<String,Object> deleteCategory(Long id){
        Map<String,Object> m=new HashMap<>();
        try {
            categoryRepository.deleteById(id);
            m.put("status","1");
            m.put("message","Xoa thanh cong");
        }catch (Exception e){
            m.put("status","0");
            m.put("message","Xoa khong thanh cong");
        }
        return m;
    }
    public int update(Long id, Category category) {
        Category category1 = categoryRepository.findById(id).get();
        if(checkExistName(categoryRepository.findAll(),category.getName())==0||category1.getName().equalsIgnoreCase(category.getName())){
            category1.setContent(category.getContent());
            category1.setImage(category.getImage());
            category1.setName(category.getName());
            category1.setStatus(category.isStatus());
            categoryRepository.save(category1);
            return 1;
        }

        return 0;
    }
    public int checkExistName(List<Category> list,String name)
    {
        list = categoryRepository.findAll();
       for (int i=0;i<list.toArray().length;i++)
       {
           if(list.get(i).getName().equalsIgnoreCase(name))
               return 1;
       }
       return 0;
    }
}
