package repositorios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entidades.Lote;
import entidades.Produto;

public class LoteRepositorio {
	
	private HashMap<String, Lote> lotes;
	
	public LoteRepositorio() {
		this.lotes = new HashMap<String, Lote>();
	}

	public HashMap<String, Lote> getLotes() {
		return lotes;
	}
	
	public Lote atualizarProduto(Lote l) {
		Lote novoLote = this.lotes.get(l.getId());
		novoLote.setDataFabricacao(l.getDataFabricacao());
		novoLote.setDataValidade(l.getDataValidade());
		novoLote.setProduto(l.getProduto());
		novoLote.setQuantidade(l.getQuantidade());
		return novoLote;
	}
	
	public List<Lote> listarLotes(){
		return new ArrayList<Lote>(this.lotes.values());
	}
	
	public Lote pegarLote(String id) {
		return this.lotes.containsKey(id) ? this.lotes.get(id) : null;
	}
	
	public void adicionarLote(Lote l) {
		if (!this.lotes.containsKey(l.getId())) {
			this.lotes.put(l.getId(), l);
		}
	}
	
	public void removerLote(String id) {
		if (this.lotes.containsKey(id)) {
			this.lotes.remove(id);
		}
	}
}
