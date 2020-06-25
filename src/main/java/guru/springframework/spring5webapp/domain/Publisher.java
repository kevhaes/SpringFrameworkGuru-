/**
 * @author KevHaes
 *
 */
package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author KevHaes
 *
 */
@Entity
public class Publisher {

	// params
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String address;
	private String city;

	// one publisher can have many books
	@OneToMany
	// joining Publisher with Book by publisher_id column
	@JoinColumn(name = "publisher_id")
	private Set<Book> books = new HashSet<>();

	// empty constructor
	public Publisher() {
	};

	// constructor
	public Publisher(String name, String address, String city) {
		this.name = name;
		this.address = address;
		this.city = city;
	}

	// Hash
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	// get id
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	// set ID
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	// get name
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	// set name
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	// get addrress
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	// set Address
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	// get city
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	// set city
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the books
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	// to string
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
