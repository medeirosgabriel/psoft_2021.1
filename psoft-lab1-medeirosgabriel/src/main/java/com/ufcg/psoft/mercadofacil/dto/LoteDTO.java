package com.ufcg.psoft.mercadofacil.dto;

import java.util.Date;

public class LoteDTO {
	
	private String idProduto;
	
	private int quantidade; 
	
	private Date dataFabricacao;
	
	private Date dataValidade; 
	
	public LoteDTO(String idProduto, int quantidade) {
		
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}
	
	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
