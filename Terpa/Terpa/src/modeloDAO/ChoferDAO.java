package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Chofer;
import bean.Conexion;

public class ChoferDAO extends ConexionDAO {
	public ChoferDAO() {
		super();
	}
	
	
	public void registrarChofer(Chofer cho) {
		
		char a='A';
		
	String tiraSQL =	"INSERT INTO chofer "
			+ "(id_chofer,cedula,nombre,apellido,telefono,id_jefe,status,statusdb) "
			+ "VALUES ('"+cho.getId_chofer()+"',"
								+ "'"+cho.getCi()+"',"
								+ "'"+cho.getNombre()+"',"
								+ "'"+cho.getApellido()+"',"
								+ "'"+cho.getTelefono()+"',"
								+ "'"+cho.getId_Jefe()+"',"
								+ "'"+cho.getStatus()+"',"
								+ "'" + a + "')";
	Conexion.ejecutar(tiraSQL);
		
		
	}
	
	public void eliminarChofer(Chofer cho) 
	{
            String tiraSQL= "update chofer set statusdb='E' where id_chofer='" + cho.getId_chofer() + "'";
    
            Conexion.ejecutar(tiraSQL);
           
    }
	
	public void actualizarChofer(Chofer cho) {
		
		char a='A';
		
            String tiraSQL= "update chofer set "
            		+ "nombre='" + cho.getNombre() + "' "
            		+ "apellido='"+ cho.getApellido() + "' "
            		+ "telefono='" + cho.getTelefono() +  "' "
            		+ "where id_chofer='" + cho.getId_chofer() + "' and statusdb='" + a + "'";
            
            Conexion.ejecutar(tiraSQL);
    
    }
	
	public Chofer buscarChofer(String idchofer) {
		
		 char a='A';
		 Chofer cho = new Chofer();
		 String tiraSQL= "select * from chofer where id_chofer = '" + idchofer + "' and statusdb='" + a + "'";
		 ResultSet rsChofer= Conexion.consultar(tiraSQL);
		 try {
			 while (rsChofer.next()){
				 String id = rsChofer.getString("id_chofer");
				 String ced = rsChofer.getString("cedula");
				 String nombre = rsChofer.getString("nombre");
				 String apellido = rsChofer.getString("apellido");
				 String telef = rsChofer.getString("telefono");
				 String idjefe = rsChofer.getString("id_jefe");
				 boolean status = rsChofer.getBoolean("status");
				 
				 cho.setId_chofer(id);
				 cho.setCi(ced);
				 cho.setNombre(nombre);
				 cho.setApellido(apellido);
				 cho.setTelefono(telef);
				 cho.setId_Jefe(idjefe);
				 cho.setStatus(status);
				 
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return cho;
	}
	
	public boolean consultarChofer(Chofer cho) {
		
		char a='A';
           
		boolean seEncuentra= false;
            
            String tiraSQL= "select * from chofer where id_chofer ='" + cho.getId_chofer() + "' and statusdb='" + a + "'";
            
            ResultSet rsChofer= Conexion.consultar(tiraSQL);
            
            try {
				if (rsChofer.next())
				{       
				        seEncuentra= true;
				        
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return seEncuentra;
    }
	
	public List<Chofer> Llenarlistrut() {
		char a = 'A';

		ArrayList<Chofer> lfer = new ArrayList<Chofer>();

		String tiraSQL = "select * from Chofer where statusdb='" + a + "'";

		ResultSet rsChofer= Conexion.consultar(tiraSQL);
		 try {
			 while (rsChofer.next()){
				 String id = rsChofer.getString("id_chofer");
				 String ced = rsChofer.getString("cedula");
				 String nombre = rsChofer.getString("nombre");
				 String apellido = rsChofer.getString("apellido");
				 String telef = rsChofer.getString("telefono");
				 String idjefe = rsChofer.getString("id_jefe");
				 boolean status = rsChofer.getBoolean("status");
				 
				 
				lfer.add(new Chofer(id,ced,nombre,apellido,telef,status,idjefe));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lfer;
	}
}