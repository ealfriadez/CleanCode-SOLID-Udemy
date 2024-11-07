package srp.refactored_new;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import srp.badexample_new.Book;
import srp.badexample_new.Page;

public class BookFilePersistence implements BookPersistence {
	public void save(Book book) {
		String bookFilePath = Book.BOOK_DIRECTORY_PATH + "/" + book.getTitle() + "_" + new Date().getTime();
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(bookFilePath));

			List<Page> pages = book.getPages();
			for (Page page : pages) {
				writer.write("---- Page " + page.getNumber() + " ----");
				writer.newLine();
				writer.write(page.getContent());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			throw new BookPersistenceExceptionError();
		}

	}
}
