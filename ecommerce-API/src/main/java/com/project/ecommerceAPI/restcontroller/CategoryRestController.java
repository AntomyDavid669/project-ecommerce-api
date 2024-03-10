package com.project.ecommerceAPI.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerceAPI.dto.CategoryInterfaceDTO;
import com.project.ecommerceAPI.dto.CategoryPostDTO;
import com.project.ecommerceAPI.service.CategoryService;
import com.project.ecommerceAPI.utils.CustomException;

@RestController
@RequestMapping("/api")
public class CategoryRestController {
    @Autowired CategoryService cs;

    @GetMapping("/category")
    public List<CategoryInterfaceDTO> getAllCategory(){
        return cs.getAllCategory();
    }

    @PostMapping("/category")
    public String insertcategory(@RequestBody CategoryPostDTO categoryPostDTO){
        try {
            cs.insertCategory(categoryPostDTO);
            String response = "Category Added successfully";
            return response;
        } catch (CustomException e) {
            String response = e.getMessage();
            return response;
        }
    }

    @PutMapping("/category")
    public String updateCategory(@RequestBody CategoryPostDTO categoryPostDTO){
        try {
            cs.updateCategory(categoryPostDTO);
            String response = "Category Updated successfully";
            return response;
        } catch (CustomException e) {
            String response = e.getMessage();
            return response;
        }
    }

    @DeleteMapping("/category")
    public String deletecategory(@RequestBody CategoryPostDTO categoryPostDTO){
        cs.deleteCategory(categoryPostDTO);
        String response = "Category Deleted successfully";
        return response;
    }
}
