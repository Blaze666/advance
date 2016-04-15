package asd.qwe;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// SessionFactory factory = new
		// Configuration().addAnnotatedClass(Author.class).addAnnotatedClass(Book.class).configure().buildSessionFactory();
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

//		session.beginTransaction();
		session.getTransaction().begin();
		
//		Author author = new Author("jora");
//		session.save(author);
		
//		List<Book> books = new ArrayList<>();
//		books.add(new Book("bukvar"));
//		books.add(new Book("bukvar2"));
//		
//		Author author = new Author("kora", books);
//		
//		session.persist(author);
		
		
//		Author author = session.get(Author.class, 1);
//		Book book1 = session.get(Book.class, 1);
//		Book book2 = session.get(Book.class, 2);
//		
//		book1.setAuthor(author);
//		book2.setAuthor(author);
//		
//		session.update(book1);
//		session.update(book2);
		
		
		Author author = session.load(Author.class, 1);
		Book book = author.getBooks().get(1);
		book.setTitle("pugjh");
		List<Book> books = new ArrayList<>();
		books.add(book);
		author.setBooks(books);
		
		
		
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
