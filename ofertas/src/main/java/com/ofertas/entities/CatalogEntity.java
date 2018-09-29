package com.ofertas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "catalog")
public class CatalogEntity {

	@Id
	@GeneratedValue
	@Column(name = "code")
	private int code;

	@Column(name = "supplierdocument")
	private int supplierDocument;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Transient
	private List<ProductEntity> productEntities;

	public CatalogEntity(int code, int supplierDocument, String name, String description,
			List<ProductEntity> productEntities) {
		super();
		this.code = code;
		this.supplierDocument = supplierDocument;
		this.name = name;
		this.description = description;
		this.productEntities = productEntities;
	}

	public CatalogEntity() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getSupplierDocument() {
		return supplierDocument;
	}

	public void setSupplierDocument(int supplierDocument) {
		this.supplierDocument = supplierDocument;
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

	public List<ProductEntity> getProductEntities() {
		return productEntities;
	}

	public void setProductEntities(List<ProductEntity> productEntities) {
		this.productEntities = productEntities;
	}

	@Override
	public String toString() {
		return "CatalogEntity [code=" + code + ", supplierDocument=" + supplierDocument + ", name=" + name
				+ ", description=" + description + ", productEntities=" + productEntities + "]";
	}

}
