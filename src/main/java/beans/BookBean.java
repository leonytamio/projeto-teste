package beans;

import java.util.ArrayList;
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
	List<Book> bookList = new ArrayList<Book>();

	public BookBean() {
		// this.showList();
	}

	public void salvarlivro(Book book) {

//			return;
//		}
//if (!isVazio(book)) {
//		
		bookdao = new BookDAO();
		bookdao.salvar(book);
		this.showList();
	}

	public boolean isVazio(Book book) {

		boolean bool = true;

		if (book.getEditora().isEmpty() || book.getEditora() == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo Editora esta vazio", null));
			bool = false;
		}
		if (book.getNomelivro().isEmpty() || book.getNomelivro() == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo nome do livro esta vazio", null));
			bool = false;
		}
		if (book.getNomeautor().isEmpty() || book.getNomeautor() == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo nome do autor esta vazio", null));
			bool = false;
		}
		if (book.getAnopublic() == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo nome do autor esta vazio", null));
			bool = false;
		}

		if (book.getGenero() == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo g�nero esta vazio", null));
			bool = false;
		}

		return bool;
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
