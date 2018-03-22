package beans;

import javax.faces.bean.ManagedBean;

import dao.BookDAO;
import model.Book;

@ManagedBean
public class BookBean {
	
	Book book = new Book();
	BookDAO bookdao;	
	
	public void salvarlivro(Book book) {
		bookdao = new BookDAO();
		bookdao.salvar(book);		
	}
	
	public void imprimiConsole() {
	 System.out.println(book.getNomelivro());
	 System.out.println(book.getEditora());
	 System.out.println(book.getNomeautor());	 
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
