package entidades;
import java.util.UUID;

public class Produto {
	
	private String id;
	
	private String nome; 
	
	private String fabricante;

	public Produto(String nome, String fabricante) {
		this.id = UUID.randomUUID().toString();
		this.nome = nome;
		this.fabricante = fabricante;
	}
	
	public String getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getFabricante() {
		return this.fabricante;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String toString() {
		return "Produto ID: " + getId() + " - Fabricante: " + getFabricante();
	}
}
