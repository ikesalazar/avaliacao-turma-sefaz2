package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.VeiculoDAO;
import dao.VeiculoDAOImpl;
import entities.Veiculo;

@ManagedBean(name = "VeiculoBean")
@SessionScoped
public class VeiculoBean {

	private List<Veiculo> listaVeiculos;
	private Veiculo veiculo;
	private VeiculoDAO veiculoDAO;

	public VeiculoBean() {
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.veiculo = new Veiculo();
		this.veiculoDAO = new VeiculoDAOImpl();
	}

	public void criarVeiculo() {

		Veiculo nVeiculo = new Veiculo();

		nVeiculo.setTipo(this.veiculo.getTipo());
		nVeiculo.setMarca(this.veiculo.getMarca());
		nVeiculo.setModelo(this.veiculo.getModelo());
		nVeiculo.setCor(this.veiculo.getCor());
		nVeiculo.setAno(this.veiculo.getAno());

		this.veiculoDAO.inserir(nVeiculo);

		this.veiculo = new Veiculo();
	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public VeiculoDAO getVeiculoDAO() {
		return veiculoDAO;
	}

	public void setVeiculoDAO(VeiculoDAO veiculoDAO) {
		this.veiculoDAO = veiculoDAO;
	}

}
