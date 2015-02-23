package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Chofer;
import bean.Conexion;

public class ChoferDAO extends ConexionDAO {
	public ChoferDAO() {
		super();
	}
	
	
	public void registrarChofer(Chofer cho) {
		
	String tiraSQL =	"INSERT INTO chofer"+ 
						"(id_chofer,cedula,nombre,apellido,telefono,id_jefe,status,statusdb)"+ 
						"VALUES ('"+cho.getId_chofer()+"',"
								+ "'"+cho.getCi()+"',"
								+ "'"+cho.getNombre()+"',"
								+ "'"+cho.getApellido()+"',"
								+ "'"+cho.getTelefono()+"',"
								+ "'"+cho.getId_Jefe()+"',"
								+ "'"+cho.getStatus()+"',"
								+ "'A')";
	Conexion.ejecutar(tiraSQL);
		
		
	}
	
	public void eliminarChofer(Chofer cho) 
	{
            String tiraSQL= "update chofer set status='E' where id_chofer='" + cho.getId_chofer() + "'";
    
            Conexion.ejecutar(tiraSQL);
           
    }
	
	public void actualizarChofer(Chofer cho) {
		
            String tiraSQL= "update chofer set " +
            		"nombre='" + cho.getNombre() + "'," +
                    "apellido='"+ cho.getApellido() + "'," + 
                    "telefono='" + cho.getTelefono() +  "' " +
                    "where id_chofer='" + cho.getId_chofer() + "' and status!='E'";
            
            Conexion.ejecutar(tiraSQL);
    
    }
	
	public Chofer buscarChofer(String idchofer) {
		
		 String tiraSQL= "select * from chofer where id_chofer = '" + idchofer + "' and status='A'";
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
				 
				 Chofer cho = new Chofer(nombre,apellido,telef,ced,id,status,idjefe);
				 return cho;
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return null;
	}
	
	public boolean consultarChofer(Chofer cho) {
           
		boolean seEncuentra= false;
            
            String tiraSQL= "select id_chofer,cedula,nombre,apellido,telefono,id_jefe,status,statusdb" +
    " from chofer where id_chofer ='" + cho.getId_chofer() + "' and status='A'";
            
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
}