package beans;

import javax.faces.bean.ManagedBean;

import model.Book;

@ManagedBean
public class BookBean {
	
	Book book = new Book();
	
	
	public void imprimiConsole() {
	 System.out.println(book.getNomeautor());
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
