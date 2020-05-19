package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(generator = "S_VEICULO")
	@SequenceGenerator(name = "S_VEICULO", sequenceName = "S_VEICULO", allocationSize = 1)
	private Long id;

	@Column(name = "TIPO", nullable = false)
	private String tipo;

	@Column(name = "MARCA", nullable = false)
	private String marca;

	@Column(name = "MODELO", nullable = false)
	private String modelo;

	@Column(name = "COR", nullable = false)
	private String cor;

	@Column(name = "ANO", nullable = false)
	private Integer ano;

	private List<Peca> pecas;

	public List<Peca> getPeças() {
		return pecas;
	}

	public void setPeças(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}
