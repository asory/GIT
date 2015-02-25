package proxy;


import modelo.Usuario;


public class ProxyLogin implements Login{

 RealLogin reallogin;
 Usuario usuario;
  
 public ProxyLogin(Usuario usuario) {
  this.usuario = usuario;
 }

 public void performOperations(String nombre, String password) {
	   
  if(usuario.getNombre().equalsIgnoreCase(nombre) &&  
  usuario.getPassword().equalsIgnoreCase(password))
  {
   reallogin=new RealLogin();
   reallogin.performOperations();
  }
  else
  {
   System.out.println("Usted no tiene acceso, dirijase al administrador");
  }
      }

@Override
public void performOperations() {
	// TODO Auto-generated method stub
	
}
}