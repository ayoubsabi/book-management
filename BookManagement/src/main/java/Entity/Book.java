package Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="published_date")
	private LocalDate publishedDate;

    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "id", nullable=false)
	private Author author;

    public Book() { }

	public Book(String name, LocalDate publishedDate, Author author) {

		this.name = name;
		this.publishedDate = publishedDate;
		this.author = author;

	}

	public int getId() {
		
		return id;
	}

	public Book setId(int id) {
	
		this.id = id;
		
		return this;
	}

	public String getName() {
		
		return name;
	}

	public Book setName(String name) {
		
		this.name = name;
		
		return this;
	}

	public LocalDate getPublishedDate() {
		
		return publishedDate;
	}

	public Book setPublishedDate(LocalDate publishedDate) {
		
		this.publishedDate = publishedDate;
		
		return this;
	}

	public Author getAuthor() {
		
		return author;
	}

	public Book setAuthor(Author author) {
		
		this.author = author;
		
		return this;
	}
	

}