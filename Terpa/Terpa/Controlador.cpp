#include "Controlador.h"

Controlador::Controlador()
{
	chequeo = false;
}

void Controlador::CargarDatos()
{
	MEmpleado mt;
	string c, nb;
	int t;
	float sb;
	char nombarchivo[120];
	ifstream archemp;
	ve.Limpiar();

	ve.LeerNombreArchivo("\n Ingrese el nombre del archivo de datos (Ej: Empleados.txt): \n",nombarchivo);

	if (!ve.AbrirArchivoEntrada(archemp, nombarchivo))
	    {
	        ve.ImprimirMensaje("\n ERROR: No existe el archivo\n");
	        ve.Pausa ();
	        return;
	    }

	c = ve.LeerLineaArchivo(archemp);

	if (ve.FinArchivo(archemp))
	    {
	       ve.ImprimirMensaje("\n ERROR: El archivo no tiene datos\n\n");
	       ve.Pausa ();
	return;
	    }
	ve.ImprimirMensaje("\n .....CARGANDO DATOS DE EMPLEADOS.....\n");
	chequeo = true;
	int nt = 1;
	while (!ve.FinArchivo(archemp) and memp.BuscarEmpleadoCed(c) == -1)
	{
	     nb = ve.LeerLineaArchivo(archemp);
	     t = ve.LeerDatoNroArchivo(archemp);
	     sb = ve.LeerDatoNroDecimalArchivo(archemp);
	     mt.SetCedula(c);
	     mt.SetTipo(t);
	     mt.SetNombre(nb);
	     mt.SetSueldob(sb);
	     memp.IncluirEmpleado(mt);
	     ve.ImprimirNro("\n Se ha incluido el empleado numero: ",nt);
	     ve.ImprimirLineasBlanco(1);
	     ve.Pausa();
	     c = ve.LeerLineaArchivo(archemp);
	     nt++;
	}
	ve.CerrarArchivoEntrada(archemp);

}

void Controlador::ProcesarConceptos()
{
	string ced, n;
	int pose, posc, resp1,cod;
	float m;
	bool ds;
	MConcepto mc;
	MEmpleado mt;
	MEmpresa me;

	ve.Limpiar();
	if (me.CantEmpleados() == 0)
	{
		ve.Limpiar();
		ve.ImprimirMensaje("\n\n NO existen datos de empleados \n");
		ve.Pausa();
		return;
	}
	{
		do
		{
			ced = ve.LeerString(
					"Ingrese la Cedula del trabajador que desea procesar");
			pose = me.BuscarEmpleadoCed(ced);
			if (pose == -1)
			{
				ve.Limpiar();
				ve.ImprimirMensaje(
						"\n\n ERROR: el empleado no esta registrado \n\n");
				ve.Pausa();
			}
			else
			{
				n = me.GetVecEmpleado(pose).GetNombre();
				ve.ImprimirString("Empleado: ", n);
				cod = ve.LeerValidarNro("Ingrese Codigo del concepto", 10, 49);
				posc = mt.BuscarConcepto(cod);
				if (posc != -1)
				{
					ve.Limpiar();
					ve.ImprimirMensaje(
							"\n\n El concepto ya existe para este empleado \n");
					ve.Pausa();
				}
				else
				{
					m = ve.LeerNroDecimal(
							"Ingrese el monto correspondiente al concepto");
					mt.ProcesarConcepto(mc);
					ds = me.Actualizar(mt, mc);
					if (ds == false)
					{
						ve.Limpiar();
						ve.ImprimirMensaje(
								"\n\n ERROR: el monto es muy alto la deduccion no puede proceder \n\n");
						ve.Pausa();
						return;
					}
					else
						mc.SetCodigo(cod);
					mc.SetMonto(m);
					mt.IncluirConcepto(mc);

				}
				ve.ImprimirNroDecimal("\n Total asignaciones de este empleado: \n", mt.GetAcumasig());
								ve.ImprimirNroDecimal("\n Total deducciones de este empleado: \n", mt.GetAcumded());
								memp.ModificarEmpleado(pose,mt);
			}
			ve.LeerValidarNro("¿Desea procesar otro empleado?1-Si 2-NO", 1, 2);

		} while (resp1 == 1);
		chequeo = true;
	}
}

void Controlador::Reporte()
{
	ve.Limpiar();
	if (memp.CantEmpleados() == 0)
	{
		ve.Limpiar();
		ve.ImprimirMensaje("NO HAY EMPLEADOS ");
		ve.Pausa();
		return;
	}
	vector<string> auxcedulas;
	vector<string> auxtpersonal;
	vector<float> auxsueldob;
	vector<float> auxasing;
	vector<float> auxded;
	vector<float> auxmontp;
	ve.ImprimirEncabezado("\n\n REPORTE NOMINA \n", " ==================\n\n");
	for (int i = 0; i < memp.CantEmpleados(); ++i)
	{
		auxcedulas.push_back(memp.GetVecEmpleado(i).GetCedula());
		auxtpersonal.push_back(memp.GetVecEmpleado(i).tipop());
		auxsueldob.push_back(memp.GetVecEmpleado(i).GetSueldob());
		auxasing.push_back(memp.GetVecEmpleado(i).GetAcumasig());
		auxded.push_back(memp.GetVecEmpleado(i).GetAcumded());
		auxmontp.push_back(memp.GetVecEmpleado(i).CalcularMonto());
	}
	ve.ImprimirListado(auxcedulas, auxtpersonal, auxsueldob, auxasing, auxded,
			auxmontp);
	ve.ImprimirLineasBlanco(1);
	ve.ImprimirNroDecimal("Monto Total a pagar en la nomina", memp.GetAcummp());
	ve.ImprimirNroDecimal("Monto Total deducciones del personal fijo",
			memp.GetAcummtd());
	ve.Pausa();
}

