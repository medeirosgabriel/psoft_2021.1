package com.ufcg.psoft.mercadofacil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.mercadofacil.dto.LoteDTO;
import com.ufcg.psoft.mercadofacil.exception.LoteNotFoundException;
import com.ufcg.psoft.mercadofacil.exception.ProductNotFoundException;
import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.LoteRepository;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;

@Service
public class LoteService {

	@Autowired
	private LoteRepository loteRep;
	
	@Autowired
	private ProdutoRepository produtoRep;
	
	public String addLote(LoteDTO loteDTO) throws ProductNotFoundException {
		Produto prod = this.produtoRep.getProd(loteDTO.getIdProduto());
		
		if(prod == null) throw new ProductNotFoundException("Produto: " + loteDTO.getIdProduto() + " não encontrado");
		Lote lote = new Lote(prod, loteDTO.getQuantidade());
		this.loteRep.addLote(lote);

		return lote.getId();
	}
	
	public Lote getLoteById(String id) throws LoteNotFoundException {
		Lote lote = this.loteRep.getLote(id);
		if(lote == null) throw new LoteNotFoundException("Lote: " + id + " não encontrado");
		
		return(lote);
	}
	
	public String updateLote(String id, LoteDTO loteDTO) throws ProductNotFoundException, LoteNotFoundException {
		Lote lote = this.loteRep.getLote(id);
		Produto prod = this.produtoRep.getProd(loteDTO.getIdProduto());
		if(lote == null) throw new LoteNotFoundException("Lote: " + id + " não encontrado");
		if(prod == null) throw new ProductNotFoundException("Produto: " + loteDTO.getIdProduto() + " não encontrado");
		lote.setProduto(prod);
		lote.setDataFabricacao(loteDTO.getDataFabricacao());
		lote.setDataValidade(loteDTO.getDataValidade());
		lote.setQuantidade(loteDTO.getQuantidade());
		this.loteRep.editLote(lote);
		return id;
	}
	
	public String deleteLote(String id) throws LoteNotFoundException {
		Lote lote = this.loteRep.getLote(id);
		if(lote == null) throw new LoteNotFoundException("Lote: " + id + " não encontrado");
		return this.loteRep.deleteLote(id);
	}
	
	public List<Lote> listarLotes() {
		return new ArrayList<Lote>(this.loteRep.listarLotes());
	}
}
