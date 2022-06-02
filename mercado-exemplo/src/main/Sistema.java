package main;

import entidades.Lote;
import entidades.Produto;
import repositorios.ProdutoRepositorio;

public class Sistema {

	public static void main(String[] args) {
		
		Produto produto1 = new Produto("Leite", "Parmalat");
		Produto produto2 = new Produto("Pao", "TrigoPan");
		Produto produto3 = new Produto("Ovo", "Granja Da Galinha");
		Lote lote1 = new Lote(produto1, 10L);
		Lote lote2 = new Lote(produto2, 10L);
		Lote lote3 = new Lote(produto3, 10L);
		
		ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio();
		
		produtoRepositorio.adicionarProduto(produto1);
		produtoRepositorio.adicionarProduto(produto2);
		produtoRepositorio.adicionarProduto(produto3);
		
		for (Produto p: produtoRepositorio.listarProdutos()) {
			System.out.println(p);
		}
		
		produtoRepositorio.removerProduto(produto1.getId());
		
		System.out.println("==========");
		
		for (Produto p: produtoRepositorio.listarProdutos()) {
			System.out.println(p);
		}
		
		
		//System.out.println(produto1);
		//System.out.println(lote1);
	}
}
