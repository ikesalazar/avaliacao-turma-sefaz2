package dao;

import java.util.List;

//import entities.Peca;
import entities.Veiculo;

public interface VeiculoDAO {

	public void inserir(Veiculo veiculo);

	// public void alterar(Veiculo veiculo);

	public void remover(Veiculo veiculo);

	public Veiculo pesquisar(Long id);

	public List<Veiculo> listarTodosVeiculos();

	// public List<Peca> listarPecas();

}
