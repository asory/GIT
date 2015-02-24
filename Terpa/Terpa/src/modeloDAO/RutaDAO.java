package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Ruta;
import bean.Conexion;

public class RutaDAO extends ConexionDAO {
	public RutaDAO() {
		super();
	}

	public void registrarRuta(Ruta rut) {

		char a = 'A';

		String tiraSQL = "INSERT INTO ruta "
				+ "(codigo,destino,tipo,statusdb) " + "VALUES ('"
				+ rut.getCodigo() + "'," + "'" + rut.getDestino() + "'," + "'"
				+ rut.getTipo() + "'," + "'" + a + "')";

		Conexion.ejecutar(tiraSQL);

	}

	public void eliminarRuta(Ruta rut) {
		String tiraSQL = "update ruta set statusdb='E' where codigo='"
				+ rut.getCodigo() + "'";

		Conexion.ejecutar(tiraSQL);

	}

	public void actualizarRuta(Ruta rut) {

		char a = 'A';

		String tiraSQL = "update ruta set " + "destino='" + rut.getDestino()
				+ "', " + "tipo= '" + rut.getTipo() + "' " + "where codigo='"
				+ rut.getCodigo() + "' and statusdb='" + a + "'";

		Conexion.ejecutar(tiraSQL);

	}

	public Ruta buscarRuta(String coddado) {

		char a = 'A';
		Ruta rut = new Ruta();
		String tiraSQL = "select * from ruta where codigo = '" + coddado
				+ "' and statusdb='" + a + "'";
		ResultSet rsRuta = Conexion.consultar(tiraSQL);
		try {
			while (rsRuta.next()) {
				String cod = rsRuta.getString("codigo");
				String destino = rsRuta.getString("destino");
				int tipo = rsRuta.getInt("tipo");

				rut.setCodigo(cod);
				rut.setDestino(destino);
				rut.setTipo(tipo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rut;
	}

	public boolean consultarRuta(Ruta rut) {

		char a = 'A';

		boolean seEncuentra = false;

		String tiraSQL = "select * from ruta where codigo ='" + rut.getCodigo()
				+ "' and statusdb='" + a + "'";

		ResultSet rsRuta = Conexion.consultar(tiraSQL);

		try {
			if (rsRuta.next()) {
				seEncuentra = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seEncuentra;
	}

	public List<Ruta> Llenarlistrut() {
		char a = 'A';

		ArrayList<Ruta> lfer = new ArrayList<Ruta>();

		String tiraSQL = "select * from Ruta where statusdb='" + a + "'";

		ResultSet rs = Conexion.consultar(tiraSQL);

		try {
			while (rs.next()) {
				String cod = rs.getString("codigo");
				String destino = rs.getString("destino");
				int tipo = rs.getInt("tipo");

				lfer.add(new Ruta(cod, destino, tipo));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lfer;
	}
}