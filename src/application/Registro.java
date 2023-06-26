package application;



public class Registro {
	

		private String nombreUsuario;
		private int edad;
		
		public Registro(String nombreUsuario, int edad) {

		this.nombreUsuario = nombreUsuario;
		this.edad = edad;
		}

		public String getNombreUsuario() {
			return nombreUsuario;
		}

		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}
		
		/*
		private ArrayList <Registro> personas;
	    
		
		public void almacenarDatos(String nombre, int edad) {
			
		    Registro nuevoUsuario = new Registro (nombre, edad) ;
			this.personas.add(nuevoUsuario);
			}

		public ArrayList<Registro> getPersonas() {
			return personas;
		}

		public void setPersonas(ArrayList<Registro> personas) {
			this.personas = personas;
		}*/
	

}
