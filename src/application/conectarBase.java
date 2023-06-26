package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conectarBase {
	

		
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bd_usuario";
	private static final String USUARIO = "root";
	private static final String CLAVE = "root";

	public static void main (String []args) {
		try {
			Class.forName(CONTROLADOR);
			//conectar();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	public static Connection conectar() {
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexión OK");

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	
	
	
	
	
	
	
	/*
	 public static void main(String[] args) {

	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            //Clase Connection que nos permite conectarnos a una base de datos
	            //dado una cadena de conexion y un usuario y pass
	            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_usuario", "root", "Andres1207*");
	            
	            /*
	            //Creamos una sentencia
	            Statement sentencia = conexion.createStatement();
	            //Resultset guarda los resultados de la consulta
	            ResultSet resultSet = sentencia.executeQuery("select * from idusuario");

	            //muestro la consulta
	            while (resultSet.next()) {

	                System.out.println(resultSet.getString("nomemp"));

	            }

	            resultSet.close();
	            sentencia.close();

	            conexion.close();

	        } catch (ClassNotFoundException | SQLException ex) {
	            System.out.println(ex.getMessage());
	            System.out.println("fallo");
	        }

	    }*/
	
	
	
	
	
	/*
	public static void main (String []args) {
		
		try {
			
			Class.forName("com.mysql.jbdc.Driver");
			
			DriverManager.getConnection("jdbc.mysql://localhost:3306/bd_usuario", "root","Andres1207*");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar controlador");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		

		
	}*/

}
