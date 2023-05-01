package com.deg.productservice.service;

import com.deg.productservice.model.Client;
import com.deg.productservice.model.Product;
import com.deg.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Obtener todos los productos
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Encontrar producto por id
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Crear producto
    public Product create(Product product) {
        return productRepository.save(product);
    }

    // Actualizar producto
    public Product update(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        existingProduct.setDescription(product.getDescription());
        existingProduct.setCode(product.getCode());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    }

    // Eliminar producto
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        productRepository.delete(product);
    }


}
