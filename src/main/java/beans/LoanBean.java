package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.LoanDAO;
import entity.Loan;

@ViewScoped
@ManagedBean
public class LoanBean {    
	
	private Loan loan = new Loan();
	LoanDAO loandao;
	List<Loan> loanList = new LoanDAO().listaAll();

	public void cadastrarEmprestimo() {
		System.out.println("Passando aqui!");
		loandao = new LoanDAO();
		loandao.salvar(loan);
		this.showList();
	}
	

	public void showList() {
		loandao = new LoanDAO();
		loanList = loandao.listaAll();
	}
	
	public void excluirloan(Loan loan) {
		loandao = new LoanDAO();
		loandao.excluir(loan);
		this.showList();
	}	

	public LoanDAO getLoandao() {
		return loandao;
	}

	public void setLoandao(LoanDAO loandao) {
		this.loandao = loandao;
	}

	public List<Loan> getLoanList() {
		return loanList;
	}

	public void setLoanList(List<Loan> loanList) {
		this.loanList = loanList;

	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
}
