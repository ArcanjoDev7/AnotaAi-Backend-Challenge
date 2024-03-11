package com.miguelarcanjo.desafioanotaai.services;

import com.miguelarcanjo.desafioanotaai.domain.category.Category;
import com.miguelarcanjo.desafioanotaai.domain.category.exception.CategoryNotFoudException;
import com.miguelarcanjo.desafioanotaai.domain.category.product.Product;
import com.miguelarcanjo.desafioanotaai.domain.category.product.ProductDTO;
import com.miguelarcanjo.desafioanotaai.domain.category.product.exeptions.ProductNotFoudException;
import com.miguelarcanjo.desafioanotaai.repositories.ProdutRepository;
import com.miguelarcanjo.desafioanotaai.services.aws.AwsSnsService;
import com.miguelarcanjo.desafioanotaai.services.aws.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private CategoryService categoryService;
    private ProdutRepository repository;

    private AwsSnsService snsService;

    public ProductService(CategoryService categoryService, ProdutRepository produtRepository, AwsSnsService snsService) {
        this.categoryService = categoryService;
        this.repository = produtRepository;
        this.snsService = snsService;
    }

    public Product insert(ProductDTO productData){
        Category category = this.categoryService.getByID(productData.categoryId()).
                orElseThrow(CategoryNotFoudException::new);
        Product newProduct = new Product(productData);
        newProduct.setCategory(category);
        this.repository.save(newProduct);
        this.snsService.publish(new MessageDTO(newProduct.getOwnerId()));
        return newProduct;
    }
    public Product update (String id, ProductDTO productData){
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoudException::new);
        if(productData.categoryId() != null){
            this.categoryService.getByID(productData.categoryId()).
                ifPresent(product::setCategory);
        }
        if(!productData.title().isEmpty()) product.setTitle(productData.title());
        if(!productData.description().isEmpty()) product.setDescription(productData.description());
        if(!(productData.price() == null )) product.setPrice(productData.price());

        this.repository.save(product);

        this.snsService.publish(new MessageDTO(product.getOwnerId()));

        return product;
    }
    public void delete (String id){
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoudException::new);

        this.repository.save(product);

    }

    public List<Product> getAll(){
        return this.repository.findAll();
    }
}
