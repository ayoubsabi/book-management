import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entity.Author;
import Entity.Book;

public class TestHibernateDatabaseConnection {

	public static void main(String[] args) {
		
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			
			Author author = entityManager.find(Author.class, 1);
			
			// List<Author> authors = entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList(); 

			System.out.println("number of books = " + author.numberOfBooks());
			
			// Author author = new Author("Ayoub", "Sabi", "3, Rue 20, Hay El Farah", LocalDate.of(1996, Month.AUGUST, 18));			
			
			// transaction.begin();
			
			// entityManager.persist(author);
			
			// transaction.commit();
			
		} finally {
			
			if(transaction.isActive()) {
				transaction.rollback();
			}
			
			entityManager.close();
			entityManagerFactory.close();
			
		}

	}

}