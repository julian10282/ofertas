package com.ofertas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "offer")
public class OfferEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "requestid")
	private int requestId;

	@Column(name = "total")
	private float total;

	@Transient
	private List<ItemEntity> itemEntities;

	public OfferEntity(int id, int requestId, float total, List<ItemEntity> itemEntities) {
		super();
		this.id = id;
		this.requestId = requestId;
		this.total = total;
		this.itemEntities = itemEntities;
	}

	public OfferEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<ItemEntity> getItemEntities() {
		return itemEntities;
	}

	public void setItemEntities(List<ItemEntity> itemEntities) {
		this.itemEntities = itemEntities;
	}

	@Override
	public String toString() {
		return "OfferEntity [id=" + id + ", requestId=" + requestId + ", total=" + total + ", itemEntities="
				+ itemEntities + "]";
	}

}
