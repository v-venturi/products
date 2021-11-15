package model;

public class JavaBeans {

	private String id;
	private String descricao;
	private String preco;
	private String estoque;
	

	public JavaBeans() {
		super();

	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getPreco() {
		return preco;
	}


	public void setPreco(String preco) {
		this.preco = preco;
	}


	public String getEstoque() {
		return estoque;
	}


	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}


	public JavaBeans(String id, String descricao, String preco, String estoque) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}

	

}
