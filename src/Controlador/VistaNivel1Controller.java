package Controlador;

import application.Cartas;
import application.Operacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VistaNivel1Controller {
 
	

	public VistaNivel1Controller() {
		
	}
	

	
    public static void main(String[] args) {
		

		
	}

		Stage nivelActual1;
	    
	    @FXML
	    private Button avanzar;
	
	    @FXML
	    private ToggleGroup btnsF1C1;
	
	    @FXML
	    private ToggleGroup btnsF1C2;
	
	    @FXML
	    private ToggleGroup btnsF1C3;
	
	    @FXML
	    private ToggleGroup btnsF1C4;
	    
	    @FXML
	    private RadioButton car1btn1;

	    @FXML
	    private RadioButton car1btn2;

	    @FXML
	    private RadioButton car1btn3;

	    @FXML
	    private RadioButton car2btn1;

	    @FXML
	    private RadioButton car2btn2;

	    @FXML
	    private RadioButton car2btn3;

	    @FXML
	    private RadioButton car3btn1;

	    @FXML
	    private RadioButton car3btn2;

	    @FXML
	    private RadioButton car3btn3;

	    @FXML
	    private RadioButton car4btn1;

	    @FXML
	    private RadioButton car4btn2;

	    @FXML
	    private RadioButton car4btn3;

	    @FXML
	    private Label labOpeC1;

	    @FXML
	    private Label labOpeC2;

	    @FXML
	    private Label labOpeC3;

	    @FXML
	    private Label labOpeC4;
	    
	    @FXML
	    private Label resCar1;

	    @FXML
	    private Label resCar2;

	    @FXML
	    private Label resCar3;

	    @FXML
	    private Label resCar4;
	
	    @FXML
	    private Label labEdadn1;
	
	    @FXML
	    private Label obtUsuario;
	
	    @FXML
	    private ImageView ptoFil1Carta1;
	
	    @FXML
	    private ImageView ptoFil1Carta2;
	
	    @FXML
	    private ImageView ptoFil1Carta3;
	
	    @FXML
	    private ImageView ptoFil1Carta4;
	
	    @FXML
	    private ImageView ptoFil2Carta1;
	
	    @FXML
	    private ImageView ptoFil2Carta2;
	
	    @FXML
	    private ImageView ptoFil2Carta3;
	
	    @FXML
	    private ImageView ptoFil2Carta4;
	
	    @FXML
	    private Label puntosNivel1;
	
	    @FXML
	    private Label totAcumulado;
	    
	    private Cartas actCarta = new Cartas();
	        	
	    @FXML
	    void Fil1Carta1(MouseEvent event) {

    		ptoFil1Carta1.setVisible(false);
    		ptoFil1Carta1.setDisable(false);
    		actCarta.comparar();    		
    		Cartas.carta[0].setVal(10);
    		
	    }
	
	    @FXML
	    void Fil1Carta2(MouseEvent event) {
    		ptoFil1Carta2.setVisible(false);
	    }
	
	    @FXML
	    void Fil1Carta3(MouseEvent event) {
    		ptoFil1Carta3.setVisible(false);
	    }
	
	    @FXML
	    void Fil1Carta4(MouseEvent event) {
    		ptoFil1Carta4.setVisible(false);
	    }
	
	    @FXML
	    void Fil2Carta1(MouseEvent event) {
    		ptoFil2Carta1.setVisible(false);
	    }
	
	    @FXML
	    void Fil2Carta2(MouseEvent event) {
    		ptoFil2Carta2.setVisible(false);
	    }
	
	    @FXML
	    void Fil2Carta3(MouseEvent event) {
    		ptoFil2Carta3.setVisible(false);
	    }
	
	    @FXML
	    void Fil2Carta4(MouseEvent event) {
    		ptoFil2Carta4.setVisible(false);	

	    }
	
	    @FXML
	    void btnAvanzar2(ActionEvent event) {
	    	
	    }
	    
	    	    	    		

	public void init(String text, String text2, Stage bienve, VistaBienvenidaController vistaBienvenidaController) {
			
		this.nivelActual1 = bienve;
		this.obtUsuario.setText(text);
		this.labEdadn1.setText(text2);

		
		//valores operacion carta 1 fila 1
        int[] resultado = Operacion.suma();
        int [] aleatorio = Operacion.aleatorio();
        int var1 = aleatorio[0];
        int var2 = aleatorio[1];
        int var3 = aleatorio[2];
        int num1 = resultado[0];
        int num2 = resultado[1];
        int resul = resultado [4];
        int num3 = resultado[var1];
        int num4 = resultado[var2];
        int num5 = resultado[var3];
		
        labOpeC1.setText(num1 +" + " + num2 + " es:");
        car1btn1.setText(String.valueOf(num3));
        car1btn2.setText(String.valueOf(num4));
        car1btn3.setText(String.valueOf(num5));

        
        
        //valores operacion carta 2 fila 1
        
        int[] resultado1 = Operacion.suma();
        int [] aleatorio1 = Operacion.aleatorio();
        int var11 = aleatorio1[0];
        int var12 = aleatorio1[1];
        int var13 = aleatorio1[2];
        int num11 = resultado1[0];
        int num12 = resultado1[1];
        int resul1 = resultado1 [4];
        int num13 = resultado1[var11];
        int num14 = resultado1[var12];
        int num15 = resultado1[var13];
		
        labOpeC2.setText(num11 +" + " + num12 + " es:");
        car2btn1.setText(String.valueOf(num13));
        car2btn2.setText(String.valueOf(num14));
        car2btn3.setText(String.valueOf(num15));


        //valores operacion carta 3 fila 1
        
        int[] resultado2 = Operacion.suma();
        int [] aleatorio2 = Operacion.aleatorio();
        int var21 = aleatorio2[0];
        int var22 = aleatorio2[1];
        int var23 = aleatorio2[2];
        int num21 = resultado2[0];
        int num22 = resultado2[1];
        int resul2 = resultado2 [4];
        int num23 = resultado2[var21];
        int num24 = resultado2[var22];
        int num25 = resultado2[var23];
		
        labOpeC3.setText(num21 +" + " + num22 + " es:");
        car3btn1.setText(String.valueOf(num23));
        car3btn2.setText(String.valueOf(num24));
        car3btn3.setText(String.valueOf(num25));

        
        
        //valores operacion carta 4 fila 1
        
        int[] resultado3 = Operacion.suma();
        int [] aleatorio3 = Operacion.aleatorio();
        int var31 = aleatorio3[0];
        int var32 = aleatorio3[1];
        int var33 = aleatorio3[2];
        int num31 = resultado3[0];
        int num32 = resultado3[1];
        int resul3 = resultado3 [4];
        int num33 = resultado3[var31];
        int num34 = resultado3[var32];
        int num35 = resultado3[var33];
		
        labOpeC4.setText(num31 +" + " + num32 + " es:");
        car4btn1.setText(String.valueOf(num33));
        car4btn2.setText(String.valueOf(num34));
        car4btn3.setText(String.valueOf(num35));
        
        
        //Configuracion valores cartas fila 2 de respuestas
        int[] resCartas = new int[4];
        resCartas = new int []{resul, resul1, resul2, resul3};
        int[] aleaCartas = Operacion.aleatorio2();
        int varR1 = aleaCartas[0];
        int varR2 = aleaCartas[1];
        int varR3 = aleaCartas[2];
        int varR4 = aleaCartas[3];
        int nunCarta1 = resCartas [varR1];
        int nunCarta2 = resCartas [varR2];
        int nunCarta3 = resCartas [varR3];
        int nunCarta4 = resCartas [varR4];
        
        resCar1.setText(String.valueOf(nunCarta1));
        resCar2.setText(String.valueOf(nunCarta2));
        resCar3.setText(String.valueOf(nunCarta3));
        resCar4.setText(String.valueOf(nunCarta4));
		
	}
	




}
