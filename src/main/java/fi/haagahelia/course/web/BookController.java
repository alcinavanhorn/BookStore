package fi.haagahelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository; 
	@Autowired
	private CategoryRepository crepository; 

	//Show all books
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    //Add a book
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }     
    
    //Edit a book
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	model.addAttribute("book", repository.findById(bookId));
    	model.addAttribute("categories", crepository.findAll());
    	return "editbook";
    }
    
    //Save book form
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book){
        repository.save(book);
        return "redirect:/booklist";
    }   
    
    //Remove a book
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String removeBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:/booklist";
    }
}
