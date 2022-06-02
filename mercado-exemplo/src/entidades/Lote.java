package entidades;
import java.util.Date;
import java.util.UUID;

public class Lote {
	
	private String id;
	
	private Produto produto;
	
	private Long quantidade; 
	
	private Date dataFabricacao;
	
	private Date dataValidade; 
	
	public Lote(Produto produto, Long quantidade) {
		
		this.id = UUID.randomUUID().toString();
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public String getId() {
		return this.id;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public Long getQuantidade() {
		return this.quantidade;
	}

	public Date getDataFabricacao() {
		return this.dataFabricacao;
	}

	public Date getDataValidade() {
		return this.dataValidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String toString() {
		return "Lote ID: " + getId() + " - Produto: " + getProduto().getNome() + " - " + getQuantidade() + " itens";
	}
}
