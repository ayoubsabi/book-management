package Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entity.Author;

public class AuthorRepository {
	
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	public AuthorRepository(EntityManager entityManager) {

		this.entityManager = entityManager;
		this.transaction = this.entityManager.getTransaction();
	}
	
	public void create(Map<String, String> data) {
		
		Author author = new Author(
			data.get("firstname"),
			data.get("lastname"),
			data.get("address"),
			LocalDate.parse((data.get("birthDate")))
		);
		
		this.transaction.begin();
					
		entityManager.persist(author);
					
		this.transaction.commit();
	}
	
	public void update(Author author, Map<String, String> data) {
		
		this.transaction.begin();
					
		author
			.setFirstname(data.get("firstname"))
			.setLastname(data.get("lastname"))
			.setAddress(data.get("address"))
			.setBirthDate(LocalDate.parse((data.get("birthDate"))))
		;
					
		this.transaction.commit();
	}
	
	public void delete(Author author) {
		
		this.transaction.begin();
					
		entityManager.remove(author);
					
		this.transaction.commit();
	}

	public List<Author> all() {

		return entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();
	}
	
	public Author findOne(int id) {

		return entityManager.find(Author.class, id);
	}

}
