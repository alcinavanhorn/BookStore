package fi.haagahelia.course.domain;

public class Book {

    private Long id;
    private String author;
    private String title;
    private String isbn;
    private int year;
    private double price;

    public Book() {}

	public Book(String author, String title, String isbn, int year, double price) {
		super();
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
