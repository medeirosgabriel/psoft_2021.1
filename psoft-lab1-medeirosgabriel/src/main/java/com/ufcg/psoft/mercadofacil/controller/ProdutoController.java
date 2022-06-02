package com.ufcg.psoft.mercadofacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.psoft.mercadofacil.dto.ProdutoDTO;
import com.ufcg.psoft.mercadofacil.exception.ProductNotFoundException;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.service.ProdutoService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/produto/", method = RequestMethod.POST)
	public ResponseEntity<?> criarProduto(@RequestBody ProdutoDTO produtoDTO, UriComponentsBuilder ucBuilder) {

		String prodID = produtoService.addProduto(produtoDTO);
		return new ResponseEntity<String>("Produto cadastrado com ID:" + prodID, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarProduto(@PathVariable("id") String id) {

		Produto produto;
		try {
			produto = produtoService.getProdutoById(id);
		} catch (ProductNotFoundException e) {
			return new ResponseEntity<String>("Produto não encontrado", HttpStatus.NO_CONTENT);
		}
			
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public ResponseEntity<?> listarProdutos() {
		List<Produto> produtos = produtoService.listarProdutos();
		
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}
	
	//=/=/=/=/=/=/=/=/=/=/=/=// MY REQUESTS //=/=/=/=/=/=/=/=/=/=/=/=//
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProduto(@PathVariable("id") String id, @RequestBody ProdutoDTO produtoDTO, UriComponentsBuilder ucBuilder) {
		
		String prodId;
		try {
			prodId = produtoService.updateProduto(id, produtoDTO);
		} catch (ProductNotFoundException e) {
			return new ResponseEntity<String>("Produto não encontrado", HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<String>("Produto atualizado. ID: " + prodId, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduto(@PathVariable("id") String id, UriComponentsBuilder ucBuilder) {
		
		String prodId;
		try {
			prodId = produtoService.deleteProduto(id);
		} catch (ProductNotFoundException e) {
			return new ResponseEntity<String>("Produto não encontrado", HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<String>("Produto deletado. ID: " + prodId, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produto/lote/", method = RequestMethod.GET)
	public ResponseEntity<?> getProdutosWithLote(UriComponentsBuilder ucBuilder) {
		
		List<Produto> produtos = produtoService.getProdsWithLote();
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produto/", method = RequestMethod.GET)
	public ResponseEntity<?> getProdutosByName(@RequestParam("nome") String nome, UriComponentsBuilder ucBuilder) {
		
		List<Produto> produtos = produtoService.listarProdsByName(nome);
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produto/lote", method = RequestMethod.GET)
	public ResponseEntity<?> getProdutosWithLoteByName(@RequestParam("nome") String nome, UriComponentsBuilder ucBuilder) {
		
		List<Produto> produtos = produtoService.listarProdsLoteByName(nome);
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}
}
