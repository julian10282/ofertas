package com.ofertas.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @Column(name = "code")
    private int code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "catalogCod")
    private int catalogCod;


    public ProductEntity() {
    }

    public ProductEntity(int code, String name, String description, int catalogCod) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.catalogCod = catalogCod;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getCatalogCod() {
        return catalogCod;
    }

    public void setCatalogCod(int catalogCod) {
        this.catalogCod = catalogCod;
    }


    @Override
    public String toString() {
        return "entity.ProductEntity[ code=" + code + " ]";
    }


}
