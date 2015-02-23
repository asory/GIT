package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Chofer;
import modelo.Unidad;
import bean.Conexion;

public class UnidadDAO extends ConexionDAO {
	public UnidadDAO() {
		super();
	}
	
	
	public void registrarUnidad(Unidad uni) {
		
	String tiraSQL =	"INSERT INTO unidad"+
						"(id,placa,tipo,id_socio,status,statusdb)"+
						"VALUES ('"+uni.getId()+"',"
								+ "'"+uni.getPlaca()+"',"
								+ "'"+uni.getTipo()+"',"
								+ "'"+uni.getId_socio()+"',"
								+ "'"+uni.getstatus()+"',"
								+ "'A')";
	Conexion.ejecutar(tiraSQL);
						
						
			
	}
	
	public void eliminarUnidad(Unidad uni) 
	{
            String tiraSQL= "update unidad set status='E' where id='" + uni.getId() + "'";
    
            Conexion.ejecutar(tiraSQL);
           
    }
	
	public void actualizarUnidad(Unidad uni) {
		
            String tiraSQL= "update unidad set " +
            		"placa='" + uni.getPlaca() + "'," +
                    "tipo='"+ uni.getTipo() + "'," + 
                    "id_socio='" + uni.getId_socio() +  "' " +
                    "where id='" + uni.getId() + "' and status!='E'";
            
            Conexion.ejecutar(tiraSQL);
    
    }
	
	public Unidad buscarUnidad(String idunidad) {
		
		 String tiraSQL= "select * from unidad where id = '" + idunidad + "' and status='A'";
		 ResultSet rsUnidad= Conexion.consultar(tiraSQL);
		 try {
			 while (rsUnidad.next()){
				 int id = rsUnidad.getInt("id");
				 String placa = rsUnidad.getString("placa");
				 int tipo = rsUnidad.getInt("tipo");
				 String idsocio = rsUnidad.getString("id_socio");
				 boolean status = rsUnidad.getBoolean("status");
				 
				 Unidad uni = new Unidad(placa,tipo,status,idsocio,id);
				 return uni;
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return null;
	}
	
	public boolean consultarUnidad(Unidad uni) {
           
		boolean seEncuentra= false;
            
            String tiraSQL= "select id,placa,tipo,id_socio,status,statusdb" +
    " from unidad where id ='" + uni.getId() + "' and status='A'";
            
            ResultSet rsUnidad= Conexion.consultar(tiraSQL);
            
            try {
				if (rsUnidad.next())
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
