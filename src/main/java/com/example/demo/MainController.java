package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

	private BookRepo bookRepo;

	public MainController(BookRepo bookRepo){
		this.bookRepo = bookRepo;
	}

	@RequestMapping("/")
	public Object home(Model model) {

		model.addAttribute("books", bookRepo.findAll());
		return "home";
	}

	@RequestMapping("/search")
	public Object home(@RequestParam("name") String name, Model model) {

		model.addAttribute("books", bookRepo.findAllByname(name));
		return "home";
	}

	@RequestMapping("/delete/{id}")
	public Object deleteAction (@PathVariable Integer id) {

		bookRepo.deleteById(id);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/");
		return redirectView;
	}

	@RequestMapping(value = {"/addEdit/{id}", "/addEdit"})
	public Object addEditBookAction(@PathVariable(name="id", required = false) Integer id,
									@RequestParam(name="id", required = false) Integer idPassed,
									@RequestParam(name="name", required = false) String name,
									@RequestParam(name="author", required = false) String author,
									@RequestParam(name="isbn", required = false) String isbn,
									@RequestParam(name="yearOfRelease", required = false) Integer yearOfRelease,
									@RequestParam(name="publisher", required = false) String publisher,
									@RequestParam(name="amountOfPages", required = false) Integer amountOfPages,
									@RequestParam(name="price", required = false) Double price,
									Model model) {

		if(id != null) {
			Book existingBook = bookRepo.getReferenceById(id);

			model.addAttribute("caption", "Edycja książki " + existingBook.getName() +
					" (id: "+ existingBook.getId() + ")");


			model.addAttribute("name", existingBook.getName());
			model.addAttribute("author", existingBook.getAuthor());
			model.addAttribute("isbn", existingBook.getISBN());
			model.addAttribute("yearOfRelease", existingBook.getYearOfRelease());
			model.addAttribute("publisher", existingBook.getPublisher());
			model.addAttribute("amountOfPages", existingBook.getAmountOfPages());
			model.addAttribute("price", existingBook.getPrice());
		} else {
			model.addAttribute("caption", "Dodawanie nowej ksiązki");
		}


		if (name != null && author != null && isbn != null && yearOfRelease != null && publisher != null &&
		amountOfPages != null && price != null) {


			Book book;

			if(idPassed != null) {
				book = new Book(idPassed, name, author, isbn, yearOfRelease, amountOfPages, publisher, price);
				book = bookRepo.save(book);
			} else {
				book = new Book(name, author, isbn, yearOfRelease, amountOfPages, publisher, price);
				book = bookRepo.save(book);
			}


			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("/addEdit/"+ book.getId());
			return redirectView;
		}
		return "addEditBook";
	}

}
