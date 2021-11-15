package model;

/**
 * The Class JavaBeans.
 */
public class JavaBeans {

	/** The id. */
	private String id;
	
	/** The descricao. */
	private String descricao;
	
	/** The preco. */
	private String preco;
	
	/** The estoque. */
	private String estoque;
	

	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();

	}


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}


	/**
	 * Sets the descricao.
	 *
	 * @param descricao the new descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	/**
	 * Gets the preco.
	 *
	 * @return the preco
	 */
	public String getPreco() {
		return preco;
	}


	/**
	 * Sets the preco.
	 *
	 * @param preco the new preco
	 */
	public void setPreco(String preco) {
		this.preco = preco;
	}


	/**
	 * Gets the estoque.
	 *
	 * @return the estoque
	 */
	public String getEstoque() {
		return estoque;
	}


	/**
	 * Sets the estoque.
	 *
	 * @param estoque the new estoque
	 */
	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}


	/**
	 * Instantiates a new java beans.
	 *
	 * @param id the id
	 * @param descricao the descricao
	 * @param preco the preco
	 * @param estoque the estoque
	 */
	public JavaBeans(String id, String descricao, String preco, String estoque) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}

	

}
