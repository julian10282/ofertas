package com.ofertas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "request")
public class RequestEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "clientdocument")
	private int clientDocument;

	@Transient
	private List<ItemEntity> itemEntities;

	public RequestEntity(int id, int clientDocument, List<ItemEntity> itemEntities) {
		super();
		this.id = id;
		this.clientDocument = clientDocument;
		this.itemEntities = itemEntities;
	}

	public RequestEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientDocument() {
		return clientDocument;
	}

	public void setClientDocument(int clientDocument) {
		this.clientDocument = clientDocument;
	}

	public List<ItemEntity> getItemEntities() {
		return itemEntities;
	}

	public void setItemEntities(List<ItemEntity> itemEntities) {
		this.itemEntities = itemEntities;
	}

	@Override
	public String toString() {
		return "RequestEntity [id=" + id + ", clientDocument=" + clientDocument + ", itemEntities=" + itemEntities
				+ "]";
	}

}
