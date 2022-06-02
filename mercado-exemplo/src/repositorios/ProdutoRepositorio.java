package repositorios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entidades.Produto;

public class ProdutoRepositorio {
	
	private HashMap<String, Produto> produtos;
	
	public ProdutoRepositorio() {
		this.produtos = new HashMap<String, Produto>();
	}

	public HashMap<String, Produto> getProdutos() {
		return produtos;
	}
	
	public Produto atualizarProduto(Produto p) {
		Produto novoProduto = this.produtos.get(p.getId());
		novoProduto.setNome(p.getNome());
		novoProduto.setFabricante(p.getFabricante());
		this.produtos.put(p.getId(), novoProduto);
		return novoProduto;
	}
	
	public List<Produto> listarProdutos(){
		return new ArrayList<Produto>(this.produtos.values());
	}
	
	public Produto pegarProduto(String id) {
		return this.produtos.containsKey(id) ? this.produtos.get(id) : null;
	}
	
	public void adicionarProduto(Produto p) {
		if (!this.produtos.containsKey(p.getId())) {
			this.produtos.put(p.getId(), p);
		}
	}
	
	public void removerProduto(String id) {
		if (this.produtos.containsKey(id)) {
			this.produtos.remove(id);
		}
	}
}
