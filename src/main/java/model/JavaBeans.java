package model;

public class JavaBeans {
	
	private int id;
	private String descricao;
	private double preco;
	private int estoque;
	
	public JavaBeans() {
		super();
		
	}
	
	public JavaBeans(int id, String descricao, double preco, int estoque) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

}
