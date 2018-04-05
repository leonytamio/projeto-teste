package entity;

public class Book {
 
	private Integer id;
	private String nomelivro;
	private String editora;
	private String nomeautor;
	private Integer anopublic;

	public Integer getAnopublic() {
		return anopublic;
	}

	public void setAnopublic(Integer anopublic) {
		this.anopublic = anopublic;
	}

	public String getNomeautor() {
		return nomeautor;
	}

	public void setNomeautor(String nomeautor) {
		this.nomeautor = nomeautor;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
