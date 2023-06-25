package Controlador;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import application.conectarBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VistaBienvenidaController {
	
	@SuppressWarnings("unused")
	private VistaRegistroController reController;
	private Stage Bienve;

    @FXML
    private Label nombreBienvenido;

    @FXML
    private Label labEdad;

    
    @FXML
    void btoIniciarJuego(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaNivel1.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	Bienve.setScene(scene);
      	VistaNivel1Controller controller = loader.getController();
		Bienve.setTitle("Matemax: calcula y combina");
    	controller.init(nombreBienvenido.getText(), labEdad.getText(), Bienve, this);
    	Bienve.show();
    }
        

	public void init(String text, String string, Stage stage2, VistaRegistroController vistaRegistroController) {

		this.Bienve = stage2;
		this.reController = vistaRegistroController;
	    nombreBienvenido.setText(text);
	    labEdad.setText(string);
	    conectarBase.conectar();
	    try {
	    	String nombre = text;
	    	String edad = string;
	    	String query = "SELECT * FROM usuario WHERE NOMBRE='"+nombre+"' AND edad='"+edad+"'";
			Statement st = conectarBase.conectar().createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				System.out.println ("existe");
			}else {
				System.out.println ("no existe");
				String query2 = "INSERT INTO usuario (nombre, edad, puntos) VALUES (?, ?, ?)";
	            PreparedStatement statement = conectarBase.conectar().prepareStatement(query2);
	            statement.setString(1, nombre);
	            statement.setString(2, edad);
	            statement.setInt(3, 0);
	            int rowsInserted = statement.executeUpdate();

	            if (rowsInserted > 0) {
	                System.out.println("Se agregó el nuevo usuario correctamente");
	            }
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}



    




}
