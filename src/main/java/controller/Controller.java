package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/edit", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans produto = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/main")) {
			produtos(request, response);

		} else if (action.equals("/insert")) {
			novoProduto(request, response);

		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/edit")) {
			selecionarProdutoParaEdicao(request, response);

		} else if (action.equals("/delete")) {
			deletarProduto(request, response);

		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);

		} else {
			response.sendRedirect("/index.html");
		}
	}

	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setDescricao(request.getParameter("descricao"));
		produto.setPreco(request.getParameter("preco"));
		produto.setEstoque(request.getParameter("estoque"));
		dao.inserirProdutos(produto);
		response.sendRedirect("main");
	}

	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarProdutos();
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("produto.jsp");
		rd.forward(request, response);

	}

	protected void selecionarProdutoParaEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		produto.setId(id);
		dao.selecionarProduto(produto);
		request.setAttribute("id", produto.getId());
		request.setAttribute("descricao", produto.getDescricao());
		request.setAttribute("preco", produto.getPreco());
		request.setAttribute("estoque", produto.getEstoque());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setId(request.getParameter("id"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setPreco(request.getParameter("preco"));
		produto.setEstoque(request.getParameter("estoque"));
		dao.alterarProduto(produto);
		response.sendRedirect("main");
	}

	protected void deletarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		produto.setId(id);
		dao.deletaProduto(produto);
		response.sendRedirect("main");
	}

	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "produtos.pdf");
			// cria o documento pdf
			PdfWriter.getInstance(documento, response.getOutputStream());
			// abre o documento e gera o conteudo
			documento.open();
			documento.add(new Paragraph("Lista de produtos:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("E-mail"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			ArrayList<JavaBeans> lista = dao.listarProdutos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getDescricao());
				tabela.addCell(lista.get(i).getPreco());
				tabela.addCell(lista.get(i).getEstoque());
			}
			documento.add(tabela);
			documento.close();

		} catch (Exception e) {
			System.err.println(e);
			documento.close();
		}
	}
}
