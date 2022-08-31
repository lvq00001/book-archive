package com.lvq.bookArchive.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lvq.bookArchive.domain.Book;
import com.lvq.bookArchive.service.BookService;



@Controller
@RequestMapping("/")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping
	public String welcome(Model model, HttpServletRequest request) {
		String path = request.getContextPath();
		model.addAttribute("path", path);
		return "welcome";
	}

	@RequestMapping("/list")
	public String listAllBook(Model model) {
		List<Book> books = bookService.getAllBooks();
		List<String> listOfPublisher = bookService.getListOfPublisherFromBook(books);
		model.addAttribute("publisher", listOfPublisher);
		model.addAttribute("books", books);
		
		return "books";
	}


	@RequestMapping(value="/find-books", method= RequestMethod.GET)
	public String getFindBook(Model model) {
		return "findBooks";
	}

	@RequestMapping(value="/find-books", method=RequestMethod.POST)
	public String postFindBook(Model model, @RequestParam("name") String name) {
		List<Book> books = bookService.findBooks(name);
		model.addAttribute("books", books);
		List<String> listOfPublisher = bookService.getListOfPublisherFromBook(books);
		model.addAttribute("publisher", listOfPublisher);
		return "forward:/result";
		//return "forward:/WEB-INF/views/books.jsp";
	}

	@RequestMapping("/result")
	public String showResult(Model model) {
		return "books";
	}

	@RequestMapping(value="/add-book", method= RequestMethod.GET)
	public String getManageBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addBook";
	}

	@RequestMapping(value="/add-book", method= RequestMethod.POST)
	public String postManageBook(Model model, @ModelAttribute("book") @Valid Book book,
			BindingResult rs, HttpServletRequest request, @RequestParam("bookImage") MultipartFile bookImage) {

		if (rs.hasErrors()) {
			return "addBook";
		}

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (bookImage!=null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(new File(rootDirectory+"resources\\images\\"+ book.getTitle() + ".jpg"));
			} catch (Exception e) {
				throw new RuntimeException("Book Image saving failed", e);
			}
		}

		bookService.addBook(book);
		//return "redirect:/WEB-INF/views/addSuccess.jsp";
		return "addSuccess";
	}

	@RequestMapping("/addSuccess")
	public String addSuccess(Model model) {
		return "addSuccess";
	}

	@RequestMapping(value="/edit-book", method= RequestMethod.GET)
	public String getEditBook(Model model, @RequestParam("id") int id) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "editBook";
	}

	@RequestMapping(value="/edit-book", method= RequestMethod.POST)
	public String postEditBook(Model model, @ModelAttribute("book") Book book) {
		bookService.updateBook(book);
		return "redirect:/list";
	}

	@RequestMapping(value="/delete-book")
	public String deleteBook(@RequestParam("id") int id) {
		bookService.deleteBook(id);
		return "redirect:/list";
	}





}
