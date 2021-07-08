package Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstname;

	@Column(name="last_name")
	private String lastname;
	
	@Column(name="address")
	private String address;

	@Column(name="birth_date")
	private LocalDate birthDate;

	@OneToMany(mappedBy="author")
	private Set<Book> books;
	
	public Author() { }

	public Author(String firstname, String lastname, String address, LocalDate birthDate) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.birthDate = birthDate;
		this.books = new HashSet<Book>();

	}
	
	public int getId() {
		
		return id;
	}

	public String getFirstname() {
		
		return firstname;
	}

	public Author setFirstname(String firstname) {

		this.firstname = firstname;
		
		return this;
	}

	public String getLastname() {
		
		return lastname;
	}

	public Author setLastname(String lastname) {

		this.lastname = lastname;
		
		return this;
	}

	public String getAddress() {
		
		return address;
	}

	public Author setAddress(String address) {

		this.address = address;
		
		return this;
	}

	public LocalDate getBirthDate() {
		
		return birthDate;
	}

	public Author setBirthDate(LocalDate birthDate) {

		this.birthDate = birthDate;
		
		return this;
	}

	public Set<Book> getBooks() {

		return this.books;
	}

	public int numberOfBooks() {

		return this.books.size();
	}
	
}