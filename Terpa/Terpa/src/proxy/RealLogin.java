package proxy;

import vista.VistaMenuP;

public class RealLogin implements Login {

	public void performOperations(int tipo) {
		VistaMenuP vistaMenuP = null;
		if (tipo == 1) // En el caso de un trabajador del terminal
		{
			VistaMenuP.getMnCargar().setEnabled(false);
			vistaMenuP.getLogin3_1().dispose();
		}
		vistaMenuP.getLogin3_1().dispose();

	}
}
