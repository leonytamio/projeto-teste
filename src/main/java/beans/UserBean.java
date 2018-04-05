package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.UserDAO;
import entity.User;


@ViewScoped
@ManagedBean

public class UserBean {

	private User user = new User();
	UserDAO userdao;
	List<User> userList = new ArrayList<User>();

	public UserBean() {
		// this.showList();
	}

	public void salvarusuario(User user) {

		if(!isVazio(user)) {
			return;
		}
			
		userdao = new UserDAO();
		userdao.salvar(user);
		this.showList();
	}
	
	public boolean isVazio(User user) {
		
		boolean bool = true;
		
		if(user.getNome().isEmpty() || user.getNome() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo nome esta vazio" , null ));
			bool = false;
		}
		if(user.getSobrenome().isEmpty() || user.getSobrenome() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo Sobrenome esta vazio" , null ));
			bool = false;
		}
		if(user.getEndereco().isEmpty() || user.getEndereco() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo Endereço esta vazio" , null ));
			bool = false;
		}
		if(user.getTel() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campo Telefone esta vazio" , null ));
			bool = false;
		}
		
		return bool;
	}

	public void excluiruser(User user) {
		userdao = new UserDAO();
		userdao.excluir(user);
		this.showList();
	}
	
	public void showList() {
		userdao = new UserDAO();
		userList = userdao.listaAll();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
