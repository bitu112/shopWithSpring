package com.gpch.login.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductRepository {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }


    public void edit(long id, Product newProduct) {
        Product found = productRepository.getOne(id);
        found.setName(newProduct.getName());
        found.setImage_url(newProduct.getImage_url());
        found.setDescription(newProduct.getDescription());
        found.setPrice(newProduct.getPrice());
        save(newProduct);
    }


    public void delete(long id) {
        productRepository.delete(findById(id));
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
       return productRepository.findByName(name);
    }

    @Override
    public List<Product> findAllByOrderByIdAsc() {
        return productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
