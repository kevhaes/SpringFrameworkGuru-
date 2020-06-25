package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Created by jt on 12/22/19.
 */
@Entity
public class Book {

//params

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String isbn;

	// many books can have many authors
	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();

	// many books can have only 1 publisher
	@ManyToOne
	private Publisher publisher;

//constructors	

	// empty constructor
	public Book() {
	}

	// constructor
	public Book(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
	}

//getter setter

	// get ID
	public Long getId() {
		return id;
	}

	// set ID
	public void setId(Long id) {
		this.id = id;
	}

	// get title
	public String getTitle() {
		return title;
	}

	// set title
	public void setTitle(String title) {
		this.title = title;
	}

	// get isbn
	public String getIsbn() {
		return isbn;
	}

	// set isbn
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

//relations getter setters

	// Many-to-Many get author
	public Set<Author> getAuthors() {
		return authors;
	}

	// Many-to-Many set authors
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	// Many-to-one get publisher
	// Many-to-one get publisher
	// Many-to-one get publisher
	// Many-to-one get publisher
	// Many-to-one get publisher
	// Many-to-one get publisher
	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}

	// Many-to-one set publisher
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book{" + "id=" + id + ", title='" + title + '\'' + ", isbn='" + isbn + '\'' + ", authors=" + authors
				+ '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Book book = (Book) o;

		return id != null ? id.equals(book.id) : book.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
