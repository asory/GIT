package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import vista.VistaUnidad;
import modelo.Chofer;
import modelo.Unidad;
import bean.Conexion;

public class UnidadDAO extends ConexionDAO {
	
	private VistaUnidad vuni;
	
	public UnidadDAO() {
		super();
	}
	
	
	public void registrarUnidad(Unidad uni) {
		
		char a='A';
		
	String tiraSQL =	"INSERT INTO unidad "
			+ "(id,placa,tipo,id_socio,status,statusdb) "
			+ "VALUES ('"+uni.getId()+"',"
			+ "'"+uni.getPlaca()+"',"
			+ "'"+uni.getTipo()+"',"
			+ "'"+uni.getId_socio()+"',"
			+ "'"+uni.getstatus()+"',"
			+ "'" + a + "')";
	
	Conexion.ejecutar(tiraSQL);
	
			
	}
	
	public void eliminarUnidad(Unidad uni) 
	{
            String tiraSQL= "update unidad set statusdb='E' where id='" + uni.getId() + "'";
    
            Conexion.ejecutar(tiraSQL);
           
    }
	
	public void actualizarUnidad(Unidad uni) {
		
		char a='A';
		
            String tiraSQL= "update unidad set "
            		+ "placa='" + uni.getPlaca() + "', "
            		+ "tipo='"+ uni.getTipo() + "', "
            		+ "id_socio='" + uni.getId_socio() +  "' "
            		+ "where id='" + uni.getId() + "' and statusdb='" + a + "'";
            
            Conexion.ejecutar(tiraSQL);
    
    }
	
	public Unidad buscarUnidad(String idunidad) {
		
		 char a='A';
		 Unidad uni = new Unidad();
		 String tiraSQL= "select * from unidad where id = '" + idunidad + "' and statusdb='" + a + "'";
		 ResultSet rsUnidad= Conexion.consultar(tiraSQL);
		 try {
			 while (rsUnidad.next()){
				 int id = rsUnidad.getInt("id");
				 String placa = rsUnidad.getString("placa");
				 int tipo = rsUnidad.getInt("tipo");
				 String idsocio = rsUnidad.getString("id_socio");
				 boolean status = rsUnidad.getBoolean("status");
				 
				 uni.setId(id);
				 uni.setPlaca(placa);
				 uni.setTipo(tipo);
				 uni.setId_socio(idsocio);
				 uni.setStatus(status);
				 
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return uni;
	}
	
	public boolean consultarUnidad(Unidad uni) {
        
		char a='A';
		
		boolean seEncuentra= false;
            
            String tiraSQL= "select * from unidad where id ='" + uni.getId() + "' and statusdb='" + a + "'";
            
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
	
	public boolean ValidarNumero(Unidad uni) {
        
		char a='A';
		
		boolean seEncuentra= false;
            
            String tiraSQL= "select id from unidad where id ='" + uni.getId() + "' and statusdb='" + a + "'";
            
            ResultSet rsUnidad= Conexion.consultar(tiraSQL);
            
            try {
				if (rsUnidad.next())
				{     
					int id = rsUnidad.getInt("id");
					if (id == Integer.parseInt(vuni.getTextNumero().getText())){
				        seEncuentra= true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return seEncuentra;
    }
}
