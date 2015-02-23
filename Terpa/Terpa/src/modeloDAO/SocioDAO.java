package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Socio;
import bean.Conexion;

public class SocioDAO extends ConexionDAO {
	public SocioDAO() {
		super();
	}
	
	
	public void registrarSocio(Socio soc) {
		
	String tiraSQL =	"INSERT INTO socio"+
						"(id_socio,cedula,nombre,apellido,telefono,cargo,statusdb)"+
						"VALUES ('"+soc.getId_socio()+"',"
								+ "'"+soc.getCi()+"',"
								+ "'"+soc.getNombre()+"',"
								+ "'"+soc.getApellido()+"',"
								+ "'"+soc.getTelefono()+"',"
								+ "'"+soc.getCargo()+"',"
								+ "'A')";
	Conexion.ejecutar(tiraSQL);
			
	}
	
	public void eliminarSocio(Socio soc) 
	{
            String tiraSQL= "update socio set status='E' where id_socio='" + soc.getId_socio() + "'";
    
            Conexion.ejecutar(tiraSQL);
           
    }
	
	public void actualizarSocio(Socio soc) {
		
            String tiraSQL= "update socio set " +
            		"nombre='" + soc.getNombre() + "'," +
                    "apellido='"+ soc.getApellido() + "'," + 
                    "telefono='" + soc.getTelefono() +  "', " +
                    "cargo='" + soc.getCargo() + "'"+
                    "where id_socio='" + soc.getId_socio() + "' and status!='E'";
            
            Conexion.ejecutar(tiraSQL);
    
    }
	
	public Socio buscarSocio(String iddado) {
		
		 String tiraSQL= "select * from socio where id_socio = '" + iddado + "' and status='A'";
		 ResultSet rsSocio= Conexion.consultar(tiraSQL);
		 try {
			 while (rsSocio.next()){
				 String id = rsSocio.getString("id_socio");
				 String ced = rsSocio.getString("cedula");
				 String nombre = rsSocio.getString("nombre");
				 String apellido = rsSocio.getString("apellido");
				 String telef = rsSocio.getString("telefono");
				 int cargo = rsSocio.getInt("cargo");
				 
				 Socio soc = new Socio(nombre,apellido,telef,ced,cargo,id);
				 return soc;
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return null;
	}
	
	public boolean consultarSocio(Socio soc) {
           
		boolean seEncuentra= false;
            
            String tiraSQL= "select id_socio,cedula,nombre,apellido,telefono,cargo,statusdb" +
    " from socio where id_socio ='" + soc.getId_socio() + "' and status='A'";
            
            ResultSet rsSocio= Conexion.consultar(tiraSQL);
            
            try {
				if (rsSocio.next())
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
