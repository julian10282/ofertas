package com.ofertas.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "request")
public class RequestEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "clientdocument")
	private int clientDocument;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Bogota")
	@Column(name = "startdate")
	private Date startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Bogota")
	@Column(name = "finaldate")
	private Date finalDate;
	
	@Column(name = "enabled")
	private boolean enabled;

	@Transient
	private List<ItemEntity> itemEntities;

	public RequestEntity() {
	}

	public RequestEntity(int id, int clientDocument, Date startDate, Date finalDate, boolean enabled,
			List<ItemEntity> itemEntities) {
		super();
		this.id = id;
		this.clientDocument = clientDocument;
		this.startDate = startDate;
		this.finalDate = finalDate;
		this.enabled = enabled;
		this.itemEntities = itemEntities;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<ItemEntity> getItemEntities() {
		return itemEntities;
	}

	public void setItemEntities(List<ItemEntity> itemEntities) {
		this.itemEntities = itemEntities;
	}

	@Override
	public String toString() {
		return "RequestEntity [id=" + id + ", clientDocument=" + clientDocument + ", startDate=" + startDate
				+ ", finalDate=" + finalDate + ", enabled=" + enabled + ", itemEntities=" + itemEntities + "]";
	}

}
