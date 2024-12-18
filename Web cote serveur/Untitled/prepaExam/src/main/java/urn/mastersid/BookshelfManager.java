package urn.mastersid;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class BookshelfManager {

	static private Bookshelf books = new Bookshelf();
	
	static public boolean initBooks(String filePath) throws InvalidBookException {
		System.out.println(filePath);
		File bookFile = new File(filePath);
		try {
			Scanner scanner = new Scanner(bookFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tokens = line.split(",");				
				double mark = Double.parseDouble(tokens[3]);
				Book newBook = new Book(tokens[0], tokens[1], tokens[2], mark);
				books.add(newBook);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InvalidBookException e) {
			e.printStackTrace();			
		}
		return true;
	}
	
	static public Bookshelf getBookshelf() {
		return books;
	}
	
	
}
