package com.gpch.login.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findById(long id);
    Product findByName(String name);
    List<Product> findAllByOrderByIdAsc();
}
