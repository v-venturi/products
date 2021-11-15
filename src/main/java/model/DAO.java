package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_estoque?useTimezone=true&Timezone=UTC";
	private String user = "root";
	private String password = "root";

	private Connection conectar() {
		Connection con;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/*
	 * public void testarConexao() { try {Connection con = conectar();
	 * System.out.println("sucesso!  " + con); con.close(); } catch (Exception e) {
	 * System.out.println("erro de conexão  " + e); }
	 * 
	 * }
	 */
	public void inserirProdutos(JavaBeans produto) {
		String create = "insert into produtos (descricao, preco, estoque) values (?,?,?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, produto.getDescricao());
			pst.setString(2, produto.getPreco().replace(".", "").replace(",", "."));
			pst.setString(3, produto.getEstoque());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<JavaBeans> listarProdutos() {
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String read = "select * from produtos order by descricao";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String descricao = rs.getString(2);
				String preco = rs.getString(3);
				String estoque = rs.getString(4);
				produtos.add(new JavaBeans(id, descricao, preco, estoque));

			}
			con.close();
			return produtos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public void selecionarProduto(JavaBeans produto) {
		String read2 = "select * from produtos where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, produto.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				produto.setId(rs.getString(1));
				produto.setDescricao(rs.getString(2));
				produto.setPreco(rs.getString(3));
				produto.setEstoque(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void alterarProduto(JavaBeans produto) {
		String create = "update produtos set descricao=?,preco=?,estoque=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, produto.getDescricao());
			pst.setString(2, produto.getPreco().replace(".", "").replace(",", "."));
			pst.setString(3, produto.getEstoque());
			pst.setString(4, produto.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void deletaProduto(JavaBeans produto) {
		String delete = "delete from produtos where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.err.println(e);

		}
	}

}
