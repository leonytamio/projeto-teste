package beans;

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
	List<User> userList = new UserDAO().listaAll();

	
	private List<User> usersList = new UserDAO().listaAll();

	public UserBean() {
		// this.showList();
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public void salvarusuario(User user) {

		
			
		userdao = new UserDAO();
		userdao.salvar(user);
		this.showList();
		this.user = new User();
		FacesContext context = FacesContext.getCurrentInstance();        
        context.addMessage(null, new FacesMessage("Successful: Cadastro realizado com sucesso!"));
	}
	
	
	

	public void excluiruser(User user) {
		userdao = new UserDAO();
		userdao.excluir(user);
		this.showList();
	}
	
	public void showList() {
		userdao = new UserDAO();
		userList = userdao.listaAll();
		System.out.println(user.getSobrenome());
	}
	
	public List<User> userList(){
		return new UserDAO().listaAll();		
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
