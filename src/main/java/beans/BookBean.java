package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.BookDAO;
import model.Book;

@ManagedBean
public class BookBean {
	
	Book book = new Book();
	BookDAO bookdao;
	List<Book> bookList  = new ArrayList<Book>();
	
	{this.showList();}
	
	public void salvarlivro(Book book) {
		bookdao = new BookDAO();
		bookdao.salvar(book);
		this.showList();
	}
	
	public void showList() {
		bookList = bookdao.listaAll();
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

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	
	
}
