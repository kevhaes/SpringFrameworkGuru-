package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

/**
 * Created by jt on 12/23/19.
 */
@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		// create instances
		Publisher publisher01 = new Publisher("Bezige Bij", "zandstraat 1", "Leuven");
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123");

		// save publisher instance
		publisherRepository.save(publisher01);

		// add book to author
		eric.getBooks().add(ddd);
		// add author to book
		ddd.getAuthors().add(eric);

		// add publisher01 to book ddd
		ddd.setPublisher(publisher01);
		// add book to publisher
		publisher01.getBooks().add(ddd);

		// save Author instance eric to Author database
		authorRepository.save(eric);
		// save book instances ddd to Book database
		bookRepository.save(ddd);
		// save publisher instance to Publisher database
		publisherRepository.save(publisher01);

		// same same for other book
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "3939459459");
		rod.getBooks().add(noEJB);
		noEJB.setPublisher(publisher01);
		noEJB.getAuthors().add(rod);
		publisher01.getBooks().add(noEJB);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher01);

		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Number of Authors: " + authorRepository.count());
		System.out.println("Number of Publishers: " + publisherRepository.count() + "\nhave total of books: "
				+ publisher01.getBooks().size());
	}
}
