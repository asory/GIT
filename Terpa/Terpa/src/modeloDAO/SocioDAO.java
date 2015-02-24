package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Socio;
import modelo.Socio;
import bean.Conexion;

public class SocioDAO extends ConexionDAO {
	public SocioDAO() {
		super();
	}
	
	
	public void registrarSocio(Socio soc,String rifcoop) {
		
		char a='A';
		
	String tiraSQL =	"INSERT INTO socio "
			+ "(id_socio,cedula,nombre,apellido,telefono,cargo,statusdb,rifcoop) "
			+ "VALUES ('"+soc.getId_socio()+"',"
			+ "'"+soc.getCi()+"',"
			+ "'"+soc.getNombre()+"',"
			+ "'"+soc.getApellido()+"',"
			+ "'"+soc.getTelefono()+"',"
			+ "'"+soc.getCargo()+"',"
			+ "'" + a + "',"
			+ "'"+ rifcoop + "')";
	
	Conexion.ejecutar(tiraSQL);
			
	}
	
	public void eliminarSocio(Socio soc,String rifcoop) 
	{
            String tiraSQL= "update socio set statusdb='E' where id_socio='" + soc.getId_socio() + "' and rifcoop='" + rifcoop + "'";
    
            Conexion.ejecutar(tiraSQL);
           
    }
	
	public void actualizarSocio(Socio soc, String rifcoop) {
		
		char a='A';
		
            String tiraSQL= "update socio set "
            		+ "nombre='" + soc.getNombre() + "', "
            		+ "apellido='"+ soc.getApellido() + "', "
            		+ "telefono='" + soc.getTelefono() +  "', "
            		+ "cargo='" + soc.getCargo() + "' "
            		+ "where id_socio='" + soc.getId_socio() + "' and rifcoop='" + rifcoop + "' and statusdb='" + a + "'";
           
            Conexion.ejecutar(tiraSQL);
    
    }
	
	public Socio buscarSocio(String iddado, String rifcoop) {
		
		 char a='A';
		 Socio soc = new Socio();
		 String tiraSQL= "select * from socio where id_socio = '" + iddado + "' and rifcoop='" + rifcoop + "' and statusdb='" + a + "'";
		 ResultSet rsSocio= Conexion.consultar(tiraSQL);
		 try {
			 while (rsSocio.next()){
				 String id = rsSocio.getString("id_socio");
				 String ced = rsSocio.getString("cedula");
				 String nombre = rsSocio.getString("nombre");
				 String apellido = rsSocio.getString("apellido");
				 String telef = rsSocio.getString("telefono");
				 int cargo = rsSocio.getInt("cargo");
				 
				 soc.setId_socio(id);
				 soc.setCi(ced);
				 soc.setNombre(nombre);
				 soc.setApellido(apellido);
				 soc.setTelefono(telef);
				 soc.setCargo(cargo);
				 
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return soc;
	}
	
	public boolean consultarSocio(Socio soc, String rifcoop) {
        
		char a='A';
		
		boolean seEncuentra= false;
            
            String tiraSQL= "select * from socio where id_socio ='" + soc.getId_socio() + "' and rifcoop='" + rifcoop + "' and statusdb='" + a + "'";
            
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
	public List<Socio> Llenarlistrut() {
		char a = 'A';

		ArrayList<Socio> lfer = new ArrayList<Socio>();

		String tiraSQL = "select * from Socio where statusdb='" + a + "'";

		ResultSet rsSocio= Conexion.consultar(tiraSQL);
		 try {
			 while (rsSocio.next()){
				 String id = rsSocio.getString("id_socio");
				 String ced = rsSocio.getString("cedula");
				 String nombre = rsSocio.getString("nombre");
				 String apellido = rsSocio.getString("apellido");
				 String telef = rsSocio.getString("telefono");
				 int cargo = rsSocio.getInt("cargo");
				 
				 
				lfer.add(new Socio(id,ced,nombre,apellido,cargo,telef));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lfer;
	}
}
