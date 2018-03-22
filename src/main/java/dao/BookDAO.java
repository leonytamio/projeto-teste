package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Book;
import util.ConnectionPostgresSQL;

public class BookDAO {

	public void salvar(Book book) {
	  
	  Connection conexao = null;
	  PreparedStatement pstm = null;	  
	  String sql = "INSERT INTO \"BOOK\"(\"ID\", \"NAME_BOOK\", \"PUBLISHING_BOOK\", \"AUTHOR_BOOK\") VALUES (NEXTVAL('book_seq'), ?, ?, ?);";
	 
	  try {
		conexao = ConnectionPostgresSQL.getConnection();
		pstm = conexao.prepareStatement(sql);
		pstm.setString(1,book.getNomelivro());
		pstm.setString(2,book.getEditora());
	    pstm.setString(3,book.getNomeautor());
	    pstm.execute();
		
	    System.out.println(pstm);
	  } catch(Exception e) {
		  System.out.println(e);
	  }
	  
		
	}

}
