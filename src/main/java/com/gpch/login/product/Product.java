package com.gpch.login.product;


import org.hibernate.validator.constraints.URL;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    @NotNull
    @NotEmpty
    private String name;
    @Column(name = "description")
    @NotNull
    private String description;
    @Column(name = "image")
    @URL
    private String image_url;
    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return id == product.id;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    @Override
    public String toString(){
       return "Id" + getId() + "Name: " + getName()
               +"Description: " + getDescription()
               +"Price" + getPrice();
    }

}
