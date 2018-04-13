package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Loan;
import util.ConnectionPostgresSQL;

public class LoanDAO {

	Connection conexao = null;
	PreparedStatement pstm = null;
	
	public void salvar(Loan loan) {

		String sql = "INSERT INTO \"LOAN_BOOK\"(\"ID\", \"ID_USER\", \"ID_BOOK\", \"LOAN_DAYS\") VALUES (NEXTVAL('loan_seq'), ?, ?, ?);";
        	
		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, loan.getId_user());
			pstm.setInt(2, loan.getId_book());
			pstm.setInt(3, loan.getLoan_days());
			pstm.execute();
			conexao.close();

			System.out.println(pstm);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Loan> listaAll() {
		String sql = "SELECT * FROM \"LOAN_BOOK\";";

		List<Loan> loanList = new ArrayList<Loan>();
		conexao = null;
		pstm = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Loan loan = new Loan();
				loan.setId(rs.getInt("ID"));
				loan.setId_user(rs.getInt("ID_USER"));
				loan.setId_book(rs.getInt("ID_BOOK"));
				loan.setLoan_days(rs.getInt("LOAN_DAYS"));
				loanList.add(loan);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}		

		return loanList;
	}
	public void excluir(Loan loan) {
		
		String sql = "DELETE FROM \"LOAN_BOOK\" WHERE \"ID\" = ?;";
        	
		try {
			conexao = ConnectionPostgresSQL.getConnection();
			pstm = conexao.prepareStatement(sql);
			System.out.println(pstm);			
			pstm.setInt(1, loan.getId());
			pstm.execute();
			conexao.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
