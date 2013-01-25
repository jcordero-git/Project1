package com.bookstore.back.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "GENRE")
public class Genre {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "TYPE")
	private String type;

	public Genre() {
	}

	public Genre(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
		// return new ToStringBuilder(this).append("ID", getId()).toString();
	}
}
