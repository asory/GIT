package proxy;

import modelo.Usuario;
import modeloDAO.*;

public class ProxyLogin implements Login {

	RealLogin reallogin;
	Usuario usuario;

	public ProxyLogin(Usuario usuario) {
		this.usuario = usuario;
	}

	@SuppressWarnings("null")
	public void performOperations(int tipo) {
		UsuarioDAO usuariodao = null;;
		
		if (usuariodao.buscarUsuario(usuario.getNombre(), usuario.getPassword()) != null) {
			reallogin = new RealLogin();
			reallogin.performOperations(usuario.getTipo());
		} else {
			System.out
					.println("Usted no tiene acceso, dirijase al administrador");
		}
	}
}
