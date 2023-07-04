package Controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VistaResultadoController {

	Stage resultado;
	
	@FXML
    private Button btnInicio;

    @FXML
    private Button btnJuegoNuevo;

    @FXML
    private GridPane gridPunt;

    @FXML
    private Label top1;

    @FXML
    private Label top1Edad;

    @FXML
    private Label top1Punt;

    @FXML
    private Label top2;

    @FXML
    private Label top2Punt;

    @FXML
    private Label top3;

    @FXML
    private Label top3Edad;

    @FXML
    private Label top3Punt;

    @FXML
    private Label top4;

    @FXML
    private Label top4Edad;

    @FXML
    private Label top4Punt;

    @FXML
    private Label top5;

    @FXML
    private Label top5Edad;

    @FXML
    private Label top5Punt;

    @FXML
    void btnInicio(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaPrincipal.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	resultado.setScene(scene);
      	VistaPrincipalController controller = loader.getController();
    	//controller.init(obtUsuario.getText(), labEdadn1.getText(), totAcumulado.getText(), nivelActual3, this);
		controller.setStage(resultado);
      	resultado.show();

    }

    @FXML
    void btnJuegoNuevo(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaNivel1.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	resultado.setScene(scene);
      	VistaNivel1Controller controller = loader.getController();
    	controller.init(top1.getText(), top1Edad.getText(), resultado, this);
    	resultado.show();

    }

	public void init(String text, String text2, String text3, Stage nivelActual3,
			VistaNivel3Controller vistaNivel3Controller) {

		this.resultado = nivelActual3;
		top1.setText(text);
		top1Edad.setText(text2);
		top1Punt.setText(text3);

	}

}

