package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Feriado;
import bean.Conexion;

public class FeriadoDAO extends ConexionDAO {
	public FeriadoDAO() {
		super();
	}

	
	public void registrarFeriado(Feriado fer) {
		
	String tiraSQL =	"INSERT INTO feriado"+
						"(dia,mes,descripcion,statusdb)"+
						"VALUES (' "+fer.getDia()+"',"
								+ "'"+fer.getMes()+"',"
								+ "'"+fer.getDescripcion()+"',"
								+ "'A')";
	Conexion.ejecutar(tiraSQL);
						
			
	}

	public void eliminarFeriado(Feriado fer) 
	{
            String tiraSQL= "update feriado set status='E' where dia='" + fer.getDia() + "' and mes='" + fer.getMes() + "'";
    
            Conexion.ejecutar(tiraSQL);
           
    }
}	
	// ACTUALIZAR, BUSCAR y CONSULTAR? CODIGO FERIADO???
	
