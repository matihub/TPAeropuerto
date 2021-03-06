package Controlador;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import DAO.Interfaces.AerolineaDAO;
import DAO.Interfaces.VueloDAO;
import Factory.AerolineaFactory;
import Vista.EntradaSalida;
import Modelo.Aerolinea;

public class IOAerolinea {
	
	EntradaSalida es = new EntradaSalida();
	List <Aerolinea> aerList = new ArrayList<Aerolinea>();
	Aerolinea Aer = new Aerolinea();
	AerolineaDAO AerolineaDAO = new AerolineaFactory().getImplementation("String");
	
	public void consultarAerolinea ( ) throws ParseException{
		try {
			   aerList = AerolineaDAO.getAllAerolinea();
			   if (aerList.contains(null)){
				   throw new Exception ("no existen Aerolinea");
			   }else {
				   for (int i = 0; i < aerList.size(); i++) {
					    es.pritln(aerList.get(i).getNombre()+"\t"+aerList.get(i).getAlianza()+"\t"+aerList.get(i).getVuelo()+"\t"+aerList.get(i));
					   
				} 
				  
				   
			   }
			   
			   
			  } catch (Exception e) {
			   // TODO: handle exception<
			   EntradaSalida.pritln("se debe ingresar Aerolinea");
			 
            	}
	}
	
	
	public void actualizarAerolinea() throws FileNotFoundException, IOException {
		
		
		String nom= es.leerFrase("ingrese nombre");
		aerList = AerolineaDAO.getAllAerolinea();
		
		for (int i = 0; i < aerList.size(); i++) {
			if (aerList.get(i).getNombre().equals((nom))) {
				
				aerList.set(i, ingresarAerolinea());
			}
		}
		AerolineaDAO.modifyAerolinea(aerList);
		
	}
    
	public void mostrarAerolineas() throws FileNotFoundException, IOException {
		aerList = AerolineaDAO.getAllAerolinea();
		for (int i = 0; i < aerList.size(); i++) {
			es.pritln(i+"-"+aerList.get(i).getNombre());
		}
		
	}

	public Aerolinea ingresarAerolinea() {
		// TODO Auto-generated method stub
		Aerolinea a = new Aerolinea();
		a.setNombre(mostrarAerolineastxt());
		a.setAlianza(recuperarAlianza());
        boolean pr =es.leerboolean("desea ingresar vuelo? true/false","opcion invalida");
        if (pr) {
			a.setVuelo(VueloDAO.ingresarvuelo());
		} else {
            a.setVuelo(null); 
		}
		
		
			
		
		return a;
	}

    public void borrarAerolinea() throws FileNotFoundException, IOException {
    	
    	String nom = es.leerFrase("ingrese aerolinea a eliminar");
    	aerList= AerolineaDAO.getAllAerolinea();
    	for (int i = 0; i < aerList.size(); i++) {
		 if (aerList.equals(nom)) {
			 
			 aerList.remove(i);
			 
			
		} else {
            es.pritln("no se encuentra el Aerolinea a buscar");    
		}
		 AerolineaDAO.modifyAerolinea(aerList);
		}
    	
    }

     public String  mostrarAerolineastxt() {
    	 int opcion =0;
    		ArrayList<String> l = new ArrayList<String>();
    	     l = AerolineaDAO.aeroparametrica();
    	   es.pritln("seleccione numero de aerolinea");
    	   es.pritln("     ----------------          ");
    	   for (int i = 0; i < l.size(); i++) {
			    es.pritln(i+"-"+l.get(i)+"/n"); 
		}
    	      opcion=es.leerInt("ingrese opcion", "opcion invalida");
		return l.get(opcion);
     }

	public String recuperarAlianza() {
		ArrayList<String> l = new ArrayList<String>();
		es.pritln("alianzas selecciones una opcion");
		l = AerolineaDAO.getalianza();
		for (int i = 0; i < l.size(); i++) {
			es.pritln(i+"--"+l.get(i));
		}
		int opcion = es.leerInt("seleccione una opcion", "opcion invalida");
		return l.get(opcion);
		
		
	}
}




	
