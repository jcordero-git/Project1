package com.bookstore.back.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "BOOK")
// @XmlRootElement(name = "Book")
public class Book {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	// @Column(name = "IDAUTHOR")
	@ManyToOne
	@JoinColumn(name = "IDAUTHOR")
	private Author author;

	@ManyToOne
	@JoinColumn(name = "IDGENRE")
	// @Column(name = "IDGENRE")
	private Genre genre;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "YEAR")
	private String year;

	public Book() {

	}

	// @XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// @XmlElement
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	// @XmlElement
	public Genre getGenre() {
		return genre;
	}

	public void setIdGenre(Genre Genre) {
		this.genre = Genre;
	}

	// @XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// @XmlElement
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
		//return new ToStringBuilder(this).append("ID", getId()).toString();
	}

}
