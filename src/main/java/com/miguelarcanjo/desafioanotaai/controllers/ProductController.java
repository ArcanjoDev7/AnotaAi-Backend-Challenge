package com.miguelarcanjo.desafioanotaai.controllers;

import com.miguelarcanjo.desafioanotaai.domain.category.product.Product;
import com.miguelarcanjo.desafioanotaai.domain.category.product.ProductDTO;
import com.miguelarcanjo.desafioanotaai.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pruduct")
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData){
        Product newProduct = this.service.insert(productData);
        return ResponseEntity.ok().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> categories = this.service.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathParam("id") String id, @RequestBody ProductDTO productData){
        Product updateProduct = this.service.update(id, productData);
        return ResponseEntity.ok().body(updateProduct);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathParam("id") String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

