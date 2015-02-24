package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Cooperativa;
import modelo.Feriado;
import bean.Conexion;

public class FeriadoDAO extends ConexionDAO {
	public FeriadoDAO() {
		super();
	}

	public void registrarFeriado(Feriado fer) {

		char a = 'A';

		String tiraSQL = "INSERT INTO feriado "
				+ "(dia,mes,descripcion,statusdb) " + "VALUES ('"
				+ fer.getDia() + "'," + "'" + fer.getMes() + "'," + "'"
				+ fer.getDescripcion() + "'," + "'" + a + "')";
		Conexion.ejecutar(tiraSQL);

	}

	public void eliminarFeriado(Feriado fer) {
		String tiraSQL = "update feriado set statusdb='E' where dia='"
				+ fer.getDia() + "' and mes='" + fer.getMes() + "'";

		Conexion.ejecutar(tiraSQL);

	}

	public boolean consultarFeriado(Feriado fer) {

		char a = 'A';

		boolean seEncuentra = false;

		String tiraSQL = "select * from feriado where dia ='" + fer.getDia()
				+ "' and mes ='" + fer.getMes() + "' and statusdb='" + a + "'";

		ResultSet rsFeriado = Conexion.consultar(tiraSQL);

		try {
			if (rsFeriado.next()) {
				seEncuentra = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seEncuentra;
	}

	public void actualizarFeriado(Feriado fer) {

		char a = 'A';

		String tiraSQL = "update feriado set descripcion='"
				+ fer.getDescripcion() + "' " + "where dia='" + fer.getDia()
				+ "' and mes='" + fer.getMes() + "' and statusdb='" + a + "'";

		Conexion.ejecutar(tiraSQL);

	}

	public Feriado buscarFeriado(int dia, int mes) {

		char a = 'A';
		Feriado fer = new Feriado();
		String tiraSQL = "select * from feriado where dia = '" + dia
				+ "' and mes= '" + mes + "' and statusdb='" + a + "'";
		ResultSet rsFeriado = Conexion.consultar(tiraSQL);
		try {
			while (rsFeriado.next()) {

				int diaf = rsFeriado.getInt("dia");
				int mesf = rsFeriado.getInt("mes");
				String desc = rsFeriado.getString("descripcion");

				fer.setDia(diaf);
				fer.setMes(mesf);
				fer.setDescripcion(desc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fer;
	}

	public List<Feriado> Llenarlistfer() {
		char a = 'A';

		ArrayList<Feriado> lfer = new ArrayList<Feriado>();

		String tiraSQL = "select * from feriado where statusdb='" + a + "'";

		ResultSet rs = Conexion.consultar(tiraSQL);
	
		try {
			while (rs.next()) {
				int diaf = rs.getInt("dia");
				int mesf = rs.getInt("mes");
				String descripcion = rs.getString("descripcion");

				lfer.add(new Feriado(diaf, mesf, descripcion));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lfer;
	}
}
