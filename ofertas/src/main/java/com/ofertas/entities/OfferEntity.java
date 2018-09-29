package com.ofertas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="offer")
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
	

}
