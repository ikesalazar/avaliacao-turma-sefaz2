package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;

//import entities.Peca;
import entities.Veiculo;
import util.JdbcUtil;

@ApplicationScoped
public class VeiculoDAOImpl implements VeiculoDAO {

	public void inserir(Veiculo veiculo) {

		String sql = "INSERT INTO veiculo(id, tipo, marca, modelo, cor, ano) " + "  values(?, ?, ?, ?, ?, ?)";

		Connection conexao;
		try {
			conexao = JdbcUtil.getConexao();

			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setLong(1, veiculo.getId());
			ps.setString(2, veiculo.getTipo());
			ps.setString(3, veiculo.getMarca());
			ps.setString(4, veiculo.getModelo());
			ps.setString(3, veiculo.getCor());
			ps.setInt(4, veiculo.getAno());

			ps.execute();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Veiculo veiculo) {
		String sql = "DELETE FROM VEICULO WHERE id = ?";

		Connection conexao;
		try {
			conexao = JdbcUtil.getConexao();

			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setLong(1, veiculo.getId());

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Veiculo pesquisar(Long id) {
		String sql = "select V.ID, V.TIPO, V.MARCA, V.MODELO, V.MODELO, V.COR, V.ANO from VEICULO V where id = ?";

		Veiculo veiculo = null;

		Connection conexao;
		try {
			conexao = JdbcUtil.getConexao();

			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setLong(1, id);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				veiculo = new Veiculo();
				veiculo.setId(res.getLong("ID"));
				veiculo.setTipo(res.getString("TIPO"));
				veiculo.setMarca(res.getString("MARCA"));
				veiculo.setModelo(res.getString("MODELO"));
				veiculo.setCor(res.getString("COR"));
				veiculo.setAno(res.getInt("ANO"));
			}

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return veiculo;

	}

	public List<Veiculo> listarTodosVeiculos() {
		String sql = "select V.ID, V.TIPO, V.MARCA, V.MODELO, V.MODELO, V.COR, V.ANO from VEICULO V";

		List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

		Connection conexao;
		try {
			conexao = JdbcUtil.getConexao();

			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {

				Veiculo veiculo = new Veiculo();
				veiculo.setId(res.getLong("ID"));
				veiculo.setTipo(res.getString("TIPO"));
				veiculo.setMarca(res.getString("MARCA"));
				veiculo.setModelo(res.getString("MODELO"));
				veiculo.setCor(res.getString("COR"));
				veiculo.setAno(res.getInt("ANO"));

				listaVeiculos.add(veiculo);
			}

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaVeiculos;

	}

}
