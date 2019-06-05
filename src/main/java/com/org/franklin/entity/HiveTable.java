package com.org.franklin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/*******************************************************************************
 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
 * 
 *  Contributors:
 *      Samrat Basu.
 *      May 27, 2019
 ******************************************************************************/
@Entity
@Table(name = "test")
@NamedQueries({
	@NamedQuery(name="HiveTable.findQuote", query="SELECT h FROM HiveTable h WHERE h.quote =:quote"),
	@NamedQuery(name="HiveTable.findAll", query="SELECT h FROM HiveTable h")
})
public class HiveTable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	private Integer id;
	@Column(name = "user_name")
	private String user_name;
	@Column(name = "quote")
	private String quote;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
}