package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import util.ConnectionPostgresSQL;

public class BookDAO {
	
	Connection conexao = null;
	PreparedStatement pstm = null;

	public void salvar(Book book) {

		String sql = "INSERT INTO \"BOOK\"(\"ID\", \"NAME_BOOK\", \"PUBLISHING_BOOK\", \"AUTHOR_BOOK\") VALUES (NEXTVAL('book_seq'), ?, ?, ?);";

		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, book.getNomelivro());
			pstm.setString(2, book.getEditora());
			pstm.setString(3, book.getNomeautor());
			pstm.execute();
			conexao.close();

			System.out.println(pstm);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Book> listaAll() {
		String sql = "SELECT \"ID\", \"NAME_BOOK\", \"PUBLISHING_BOOK\", \"AUTHOR_BOOK\"	FROM public.\"BOOK\";";
		
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Book book = new Book();
				book.setNomeautor(rs.getString(1));
				book.setNomelivro(rs.getString(2));
				book.setEditora(rs.getString(3));
				bookList.add(book);	
			}
			
			conexao.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

			
		return bookList;
	}

}
