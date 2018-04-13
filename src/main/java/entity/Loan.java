package entity;

public class Loan {
	
	private Integer id;
	private Integer id_user;
	private Integer id_book;
	private Integer loan_days;
	
	
	public Integer getLoan_days() {
		return loan_days;
	}
	public void setLoan_days(Integer loan_days) {
		this.loan_days = loan_days;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	public Integer getId_book() {
		return id_book;
	}
	public void setId_book(Integer id_book) {
		this.id_book = id_book;
	}
	

}
