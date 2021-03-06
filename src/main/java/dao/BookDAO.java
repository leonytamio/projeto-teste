package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import util.ConnectionPostgresSQL;

public class BookDAO {
	
	Connection conexao = null;
	PreparedStatement pstm = null;

	public void salvar(Book book) {

		String sql = "INSERT INTO \"BOOK\"(\"ID\", \"NAME_BOOK\", \"PUBLISHING_BOOK\", \"AUTHOR_BOOK\", \"YEAR_PUBLIC\", \"GENRE_BOOK\") VALUES (NEXTVAL('book_seq'), ?, ?, ?, ?, ?);";
        	
		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, book.getNomelivro());
			pstm.setString(2, book.getEditora());
			pstm.setString(3, book.getNomeautor());
			pstm.setInt(4, book.getAnopublic());
			pstm.setString(5, book.getGenero());
			pstm.execute();
			conexao.close();

			System.out.println(pstm);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Book> listaAll() {
		String sql = "SELECT * FROM \"BOOK\";";
		
		List<Book> bookList = new ArrayList<Book>();
		conexao = null;
		pstm = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				Book book = new Book();
				book.setId(rs.getInt("ID"));
				book.setNomeautor(rs.getString("AUTHOR_BOOK"));
				book.setNomelivro(rs.getString("NAME_BOOK"));
				book.setEditora(rs.getString("PUBLISHING_BOOK"));
				book.setAnopublic(rs.getInt("YEAR_PUBLIC"));
				book.setGenero(rs.getString("GENRE_BOOK"));
				bookList.add(book);	
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
      finally {

         try {

             if (rs != null) {

                 rs.close();
             }

             if (pstm != null) {

                 pstm.close();
             }

             if (conexao != null) {
            	 conexao.close();
             }

         } catch (Exception e) {

             e.printStackTrace();
         }
     }
		
			
		return bookList;
	}
	
	
	public void editar(Book book) {
		ResultSet rs = null;
		String sql = "UPDATE public.\"BOOK\"\n" + 
				"	SET \"NAME_BOOK\"=?, \"PUBLISHING_BOOK\"=?, \"AUTHOR_BOOK\"=?, \"YEAR_PUBLIC\"=?, \"GENRE_BOOK\"=?\n" + 
				"	WHERE \"ID\"=?;";
		
				try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			rs = pstm.executeQuery();
			book.setId(rs.getInt("ID"));
			book.setNomeautor(rs.getString("AUTHOR_BOOK"));
			book.setNomelivro(rs.getString("NAME_BOOK"));
			book.setEditora(rs.getString("PUBLISHING_BOOK"));
			book.setAnopublic(rs.getInt("YEAR_PUBLIC"));
			book.setGenero(rs.getString("GENRE_BOOK"));		
			pstm.execute();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void excluir(Book book) {

		String sql = "DELETE FROM \"BOOK\" WHERE \"ID\" = ?;";
        	
		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			System.out.println(pstm);			
			pstm.setInt(1, book.getId());
			pstm.execute();
			conexao.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
