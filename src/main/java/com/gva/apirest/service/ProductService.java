package com.gva.apirest.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gva.apirest.model.entities.Product;
import com.gva.apirest.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) throws Exception{
        return productRepository.findById(id).orElseThrow( () -> new Exception("Objeto não encontrado"));
    }
    
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) throws Exception {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
        throw new Exception("Não foi possível pois o objeto não existe");       
    }

    public void update(Product product, Long id) throws Exception {
       Product productDB = productRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Produto não encontrado", id));
       productDB.setName(product.getName());
       productDB.setPrice(product.getPrice());
       productRepository.save(productDB);
    }
}