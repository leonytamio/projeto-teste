package beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.BookDAO;
import entity.Book;

@ViewScoped
@ManagedBean

public class BookBean {

	private Book book = new Book();
	BookDAO bookdao;
	List<Book> bookList = new BookDAO().listaAll();

	public BookBean() {
		// this.showList();
	}

	public void salvarlivro(Book book) {		
		bookdao = new BookDAO();
		bookdao.salvar(book);
		this.showList();
		this.book = new Book();
		FacesContext context = FacesContext.getCurrentInstance();        
        context.addMessage(null, new FacesMessage("Successful: Cadastro realizado com sucesso!"));
	}	

	public void excluirbook(Book book) {
		bookdao = new BookDAO();
		bookdao.excluir(book);
		this.showList();
	}

	public void showList() {
		bookdao = new BookDAO();
		bookList = bookdao.listaAll();
	}
	
	public List<Book> bookList(){
		return new BookDAO().listaAll();
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
