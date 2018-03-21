package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BookBean {

	private String nomelivro;
	private String editora;
	private String nomeautor;
	private String mensagemcadastro;

	public void mensagemCadastro() {
		mensagemcadastro = "Livro Cadastrado! " + "Nome: " + nomelivro + " " + "Editora: " + editora + " " + "Autor: "
				+ nomeautor;
	}

	public String getNomelivro() {
		return nomelivro;
	}

	public void setNomelivro(String nomelivro) {
		this.nomelivro = nomelivro;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getNomeautor() {
		return nomeautor;
	}

	public void setNomeautor(String nomeautor) {
		this.nomeautor = nomeautor;
	}

	public String getMensagemcadastro() {
		return mensagemcadastro;
	}

	public void setMensagemcadastro(String mensagemcadastro) {
		this.mensagemcadastro = mensagemcadastro;
	}

}
