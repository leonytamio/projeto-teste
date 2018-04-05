package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.ConnectionPostgresSQL;

public class UserDAO {
	
	Connection conexao = null;
	PreparedStatement pstm = null;

	public void salvar(User user) {

		String sql = "INSERT INTO \"USER\"(\"ID\", \"FIRST_NAME_USER\", \"LAST_NAME_USER\", \"ADRESS_USER\", \"TELEPHONE_USER\") VALUES (NEXTVAL('user_seq'), ?, ?, ?, ?);";
        	
		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, user.getNome());
			pstm.setString(2, user.getSobrenome());
			pstm.setString(3, user.getEndereco());
			pstm.setInt(4, user.getTel());
			pstm.execute();
			conexao.close();

			System.out.println(pstm);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<User> listaAll() {
		String sql = "SELECT * FROM \"USER\";";
		
		List<User> userList = new ArrayList<User>();
		conexao = null;
		pstm = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("ID"));
				user.setNome(rs.getString("FIRST_NAME_USER"));
				user.setSobrenome(rs.getString("LAST_NAME_USER"));
				user.setEndereco(rs.getString("ADRESS_USER"));
				user.setTel(rs.getInt("TELEPHONE_USER"));
				userList.add(user);	
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
		
			
		return userList;
	}
	
	public void excluir(User user) {

		String sql = "DELETE FROM \"USER\" WHERE \"ID\" = ?;";
        	
		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			System.out.println(pstm);			
			pstm.setInt(1, user.getId());
			pstm.execute();
			conexao.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
