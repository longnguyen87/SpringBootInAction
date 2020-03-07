package reading;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ReadingListController {
	private ReadingListRepo repo;

	@Autowired
	public ReadingListController(ReadingListRepo repo) {
		super();
		this.repo = repo;
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model) {
		List<Book> bookList = repo.findByReader(reader);
		if (bookList != null) {
			model.addAttribute("books", bookList);
		}
		// return View name as String
		return "readingList";
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.GET)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		book.setReader(reader);
		repo.save(book);
		return "redirect:/{reader}";
	}

}
