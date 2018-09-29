package com.ofertas.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class SupplierEntity {

	@Id
	@Column(name = "document")
	private int document;

	@Column(name = "name")
	private String name;

	@Column(name = "mail")
	private String mail;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "createDate")
	private Date createDate;

	@Column(name = "modifyDate")
	private Date modifyDate;

	public SupplierEntity(int document, String name, String mail, String telephone, Date createDate, Date modifyDate) {
		super();
		this.document = document;
		this.name = name;
		this.mail = mail;
		this.telephone = telephone;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public SupplierEntity() {
	}

	public int getDocument() {
		return document;
	}

	public void setDocument(int document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "SupplierEntity [document=" + document + ", name=" + name + ", mail=" + mail + ", telephone=" + telephone
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

}
