package com.bookstore.back.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "AUTHOR")
public class Author {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "COUNTRYISO")
	private String countryISO;

	public Author() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountryISO() {
		return countryISO;
	}

	public void setCountryISO(String countryISO) {
		this.countryISO = countryISO;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
		// return new ToStringBuilder(this).append("ID", getId()).toString();
	}

}
