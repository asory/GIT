package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Ruta;
import bean.Conexion;

public class RutaDAO extends ConexionDAO {
	public RutaDAO() {
		super();
	}
	
	
	public void registrarRuta(Ruta rut) {
		
	String tiraSQL =	"INSERT INTO ruta"+
						"(codigo,destino,tipo,statusdb)"+
						"VALUES ('"+rut.getCodigo()+"',"
								+ "'"+rut.getDestino()+"',"
								+ "'"+rut.getTipo()+"',"
								+ "'A')";
	Conexion.ejecutar(tiraSQL);
			
	}
	
	public void eliminarRuta(Ruta rut) 
	{
            String tiraSQL= "update ruta set status='E' where codigo='" + rut.getCodigo() + "'";
    
            Conexion.ejecutar(tiraSQL);
           
    }
	
	public void actualizarRuta(Ruta rut) {
		
            String tiraSQL= "update ruta set " +
                        "destino='" + rut.getDestino() + "', "+
                        "tipo= '" + rut.getTipo() + "'"+
                        "where codigo='" + rut.getCodigo() + "' and status!='E'";
            
            Conexion.ejecutar(tiraSQL);
    
    }
	
	public Ruta buscarCooperativa(String coddado) {
		
		 String tiraSQL= "select * from ruta where codigo = '" + coddado + "' and status='A'";
		 ResultSet rsRuta= Conexion.consultar(tiraSQL);
		 try {
			 while (rsRuta.next()){
				 String cod = rsRuta.getString("codigo");
				 String destino = rsRuta.getString("destino");
				 int tipo = rsRuta.getInt("tipo");
				 
				 Ruta rut = new Ruta(cod,destino,tipo);
				 return rut;
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return null;
	}
	
	public boolean consultarRuta(Ruta rut) {
           
		boolean seEncuentra= false;
            
            String tiraSQL= "select codigo,destino,tipo" +
    " from ruta where codigo ='" + rut.getCodigo() + "' and status='A'";
            
            ResultSet rsRuta= Conexion.consultar(tiraSQL);
            
            try {
				if (rsRuta.next())
				{       
				        seEncuentra= true;
				        
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return seEncuentra;
    }
}	