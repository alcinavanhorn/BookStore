package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("add categories");
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Non-fiction"));
			crepository.save(new Category("Satire"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Sci-fi"));
			crepository.save(new Category("Children's"));
			
			log.info("save a couple of books");
			repository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "1232323-21", 1929, 19.90, crepository.findByName("Fiction").get(0)));
			repository.save(new Book("George Orwell", "Animal Farm", "2212343-5", 1945, 25.00, crepository.findByName("Satire").get(0)));	
						
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
