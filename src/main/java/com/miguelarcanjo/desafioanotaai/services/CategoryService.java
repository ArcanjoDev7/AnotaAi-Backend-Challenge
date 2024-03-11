package com.miguelarcanjo.desafioanotaai.services;

import com.miguelarcanjo.desafioanotaai.domain.category.Category;
import com.miguelarcanjo.desafioanotaai.domain.category.CategoryDTO;
import com.miguelarcanjo.desafioanotaai.domain.category.exception.CategoryNotFoudException;
import com.miguelarcanjo.desafioanotaai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category insert(CategoryDTO categoryData){
        Category newCategory = new Category(categoryData);
        this.repository.save(newCategory);
        return newCategory;
    }
    public Category update (String id, CategoryDTO categoryData){
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoudException::new);

        if(!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty()) category.setDescription(categoryData.description());

        this.repository.save(category);

        return category;
    }
    public void delete (String id){
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoudException::new);

        this.repository.save(category);

    }

    public List<Category> getAll(){
        return this.repository.findAll();
    }
    public Optional<Category> getByID(String id){
        return this.repository.findById(id);
    }


}
