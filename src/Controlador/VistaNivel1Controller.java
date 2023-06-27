package Controlador;

import java.lang.reflect.Field;

import application.Cartas;
import application.Operacion;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VistaNivel1Controller {
 

		Stage nivelActual1;
		
		//Puntos de nivel 1
		int puntosNiv1 = 100;

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
	    private VBox vBox1;

	    @FXML
	    private VBox vBox2;

	    @FXML
	    private VBox vBox3;

	    @FXML
	    private VBox vBox4;

	    @FXML
	    private VBox vBox5;

	    @FXML
	    private VBox vBox6;

	    @FXML
	    private VBox vBox7;

	    @FXML
	    private VBox vBox8;

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
	    
	    //Se crea instancia de clase Cartas
	    private Cartas actCarta = new Cartas();

	    
	    //se generan valores aleatorios para las operaciones fila 1
        
	    int[] resultado = Operacion.suma();
        int [] aleatorio = Operacion.aleatorio();
        
        int[] resultado1 = Operacion.suma();
        int [] aleatorio1 = Operacion.aleatorio();
        
        int[] resultado2 = Operacion.suma();
        int [] aleatorio2 = Operacion.aleatorio();
        
        int[] resultado3 = Operacion.suma();
        int [] aleatorio3 = Operacion.aleatorio();
        
        //metodo para asignar los valores de los resultados a las cartas fila 2
        public static int[] obtenerResCartas(int []resCartas) {
        int[] aleaCartas = Operacion.aleatorio2();
        return aleaCartas;
        }
        
        int resul = resultado[4];
        int resul1 = resultado1[4];
        int resul2 = resultado2[4];
        int resul3 = resultado3[4];
        int[] resCartas = {resul, resul1, resul2, resul3};	 //este array se usa con el metodo obtenerRescartas
        int[] aleaCartas = obtenerResCartas(resCartas) ;
	        	
	    @FXML
	    void Fil1Carta1(MouseEvent event) {
	    	
	    	//Se invoca metodo Crear cartas con la instancia creada de la clase Cartas
    		actCarta.crearCartas(); 
    		
    		//Valor de la carta
	        int resul = resultado [4];

	        //Se almacenan datos de las cartas en el array
	        
    		Cartas.carta[0].setVal(resul); // valor es resul
    		Cartas.carta[0].setTemp(1);
            Cartas.desbCarta(0);
            
    		boolean cv1 = Cartas.carta[0].isVis();
    		boolean cb1 = Cartas.carta[0].isBloq();

    		ptoFil1Carta1.setVisible(cv1);
    		ptoFil1Carta1.setDisable(cb1);
    		//ptoFil1Carta3.setOpacity(opac);
  		
    		//Se bloquean cartas diferentes a actual
            for (int i = 0; i < Cartas.carta.length-4; i++) {
                if (Cartas.carta[i].getTemp() == 0) {

                    String cartaVariableName = "ptoFil1Carta" + (i + 1);

                    try {
                        Field field = getClass().getDeclaredField(cartaVariableName);
                        field.setAccessible(true);
                        Node cartaNode = (Node) field.get(this);
                        cartaNode.setDisable(true);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                        e.printStackTrace();
                    }
                }
            }//fin for

	    }
	    

	
	    @FXML
	    void Fil1Carta2(MouseEvent event) {
    		
	    	//Se invoca metodo Crear cartas con la instancia creada de la clase Cartas
    		actCarta.crearCartas(); 
    		//Valor de la carta
	        int resul1 = resultado [4];

	        //Se almacenan datos de las cartas en el array
	        
    		Cartas.carta[1].setVal(resul1);
    		Cartas.carta[1].setTemp(1);
            Cartas.desbCarta(0);
            
    		boolean cv1 = Cartas.carta[1].isVis();
    		boolean cb1 = Cartas.carta[1].isBloq();

    		ptoFil1Carta2.setVisible(cv1);
    		ptoFil1Carta2.setDisable(cb1);
    		//ptoFil1Carta2.setOpacity(opac);
  		
    		//Se bloquean cartas diferentes a actual
            for (int i = 0; i < Cartas.carta.length-4; i++) {
                if (Cartas.carta[i].getTemp() == 0) {

                    String cartaVariableName = "ptoFil1Carta" + (i + 1);

                    try {
                        Field field = getClass().getDeclaredField(cartaVariableName);
                        field.setAccessible(true);
                        Node cartaNode = (Node) field.get(this);
                        cartaNode.setDisable(true);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                        e.printStackTrace();
                    }
                }
            }//fin for

    		
	    }
	
	    @FXML
	    void Fil1Carta3(MouseEvent event) {
	    	
    		//Se invoca metodo Crear cartas con la instancia creada de la clase Cartas
    		actCarta.crearCartas(); 
    		//Valor de la carta
	        int resul2 = resultado [4];

	        //Se almacenan datos de las cartas en el array
	        
    		Cartas.carta[2].setVal(resul2);
    		Cartas.carta[2].setTemp(1);
            Cartas.desbCarta(0);
            
    		boolean cv1 = Cartas.carta[2].isVis();
    		boolean cb1 = Cartas.carta[2].isBloq();

    		ptoFil1Carta3.setVisible(cv1);
    		ptoFil1Carta3.setDisable(cb1);
    		//ptoFil1Carta2.setOpacity(opac);
  		
    		//Se bloquean cartas diferentes a actual
            for (int i = 0; i < Cartas.carta.length-4; i++) {
                if (Cartas.carta[i].getTemp() == 0) {

                    String cartaVariableName = "ptoFil1Carta" + (i + 1);

                    try {
                        Field field = getClass().getDeclaredField(cartaVariableName);
                        field.setAccessible(true);
                        Node cartaNode = (Node) field.get(this);
                        cartaNode.setDisable(true);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                        e.printStackTrace();
                    }
                }
            }//fin for
    		
	    }
	    
	
	    @FXML
	    void Fil1Carta4(MouseEvent event) {
    		
    		//Se invoca metodo Crear cartas con la instancia creada de la clase Cartas
    		actCarta.crearCartas(); 
    		
    		//Valor de la carta
	        int resul3 = resultado [4];

	        //Se almacenan datos de las cartas en el array
    		Cartas.carta[3].setVal(resul3);
    		Cartas.carta[3].setTemp(1);
            Cartas.desbCarta(0);
            
    		boolean cv1 = Cartas.carta[3].isVis();
    		boolean cb1 = Cartas.carta[3].isBloq();

    		ptoFil1Carta4.setVisible(cv1);
    		ptoFil1Carta4.setDisable(cb1);
    		//ptoFil1Carta3.setOpacity(opac);
  		
    		//Se bloquean cartas diferentes a actual
            for (int i = 0; i < Cartas.carta.length-4; i++) {
                if (Cartas.carta[i].getTemp() == 0) {

                    String cartaVariableName = "ptoFil1Carta" + (i + 1);

                    try {
                        Field field = getClass().getDeclaredField(cartaVariableName);
                        field.setAccessible(true);
                        Node cartaNode = (Node) field.get(this);
                        cartaNode.setDisable(true);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                        e.printStackTrace();
                    }
                }
            }//fin for
    		

	    }
	
	    @FXML
	    void Fil2Carta1(MouseEvent event) {

	        int varR1 = aleaCartas[0];
	        int nunCarta1 = resCartas[varR1];
	        System.out.println("valor carta inferior : " + nunCarta1);
	        
	        Cartas.carta[4].setVal(nunCarta1);
    		Cartas.carta[4].setTemp(1);
	        //Cartas.carta[4].setVis(false);
	        //Cartas.carta[4].setBloq(false);

	        //boolean cv1 = Cartas.carta[4].isVis();
	        //boolean cb1 = Cartas.carta[4].isVis();
	        ptoFil2Carta1.setVisible(false);
	        //ptoFil2Carta1.setDisable(cb1);
	        
            for (int i = 0; i < Cartas.carta.length -4; i++) {
                if (Cartas.carta[i].getTemp() == 0) {

                    String cartaVariableName2 = "ptoFil2Carta" + (i + 1);

                    try {
                        Field field2 = getClass().getDeclaredField(cartaVariableName2);
                        field2.setAccessible(true);
                        Node cartaNode2 = (Node) field2.get(this);
                        cartaNode2.setDisable(true);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName2);
                        e.printStackTrace();
                    }
                }
            }//fin for


	        int numeroBuscado = 1;
	        int posic = Cartas.buscarCartaSuperior(numeroBuscado);
	        int valCartaSup = Cartas.carta[posic].getVal();

	        String cartaVariableName = "ptoFil1Carta" + (posic + 1);
	        //System.out.println("valor nodo creado : " + cartaVariableName);
            try {
	        // Comparar el valor con el de la carta seleccionada en la fila superior
	        if (nunCarta1 == valCartaSup) {
	            
                puntosNivel1.setText( String.valueOf(puntosNiv1 + 10));
	        	Cartas.carta[posic].setTemp(2);
	    		Cartas.carta[4].setTemp(2);
	            
                Field field = getClass().getDeclaredField(cartaVariableName);
                field.setAccessible(true);
                Node cartaNode = (Node) field.get(this);
                cartaNode.setVisible(true);
                cartaNode.setDisable(true);
                cartaNode.setOpacity(0.05);
                
                for (int i = 0; i < Cartas.carta.length -4; i++) {
                    if (Cartas.carta[i].getTemp() == 0) {
                    	
                        String cartaVariableNameN1 = "ptoFil1Carta" + (i + 1);
                        String cartaVariableNameN11 = "ptoFil2Carta" + (i + 1);

                        try {
                        	
                            Field field1 = getClass().getDeclaredField(cartaVariableNameN1);
                            field1.setAccessible(true);
                            Node cartaNode1 = (Node) field1.get(this);
                            cartaNode1.setDisable(false);
                        	
                            Field field2 = getClass().getDeclaredField(cartaVariableNameN11);
                            field2.setAccessible(true);
                            Node cartaNode2 = (Node) field2.get(this);
                            cartaNode2.setDisable(false);
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableNameN11);
                            e.printStackTrace();
                        }
                    }
                }//fin for

 
                //Cartas.desbCarta(0);
                
	            int prue = Cartas.carta[posic].getVal();
	            int prue2 = Cartas.carta[posic].getTemp();
	            System.out.println("valor carta verdadero : " + prue);
	            System.out.println("valor temp carta verdadero : " + prue2);
	            

	        } else {
	        		
                puntosNivel1.setText( String.valueOf(puntosNiv1 - 10));
	            Cartas.carta[posic].setTemp(0);
	    		Cartas.carta[4].setTemp(0);

	            // Obtener el nombre de la variable de la carta correspondiente
	                Field field = getClass().getDeclaredField(cartaVariableName);
	                field.setAccessible(true);
	                Node cartaNode = (Node) field.get(this);
	                
	                PauseTransition pause = new PauseTransition(Duration.seconds(5)); // Pausa de 2 segundos
	                pause.setOnFinished(e -> {cartaNode.setVisible(true); ptoFil2Carta1.setVisible(true);}); // Hacer visible el nodo después de la pausa
	                pause.play();
	                
	                for (int i = 0; i < Cartas.carta.length -4; i++) {
	                    if (Cartas.carta[i].getTemp() == 0) {
	                    	
	                        String cartaVariableNameN1 = "ptoFil1Carta" + (i + 1);
	                        String cartaVariableNameN11 = "ptoFil2Carta" + (i + 1);

	                        try {
	                        	
	                            Field field1 = getClass().getDeclaredField(cartaVariableNameN1);
	                            field1.setAccessible(true);
	                            Node cartaNode1 = (Node) field1.get(this);
	                            cartaNode1.setDisable(false);
	                        	
	                            Field field2 = getClass().getDeclaredField(cartaVariableNameN11);
	                            field2.setAccessible(true);
	                            Node cartaNode2 = (Node) field2.get(this);
	                            cartaNode2.setDisable(false);
	                        } catch (NoSuchFieldException | IllegalAccessException e) {
	                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableNameN11);
	                            e.printStackTrace();
	                        }
	                    }
	                }//fin for
	            } 
	        }catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                e.printStackTrace();
            }
   
	    }
	    
	
	    @FXML
	    void Fil2Carta2(MouseEvent event) {
	    	
	        int varR2 = aleaCartas[1];
	    	
    		ptoFil2Carta2.setVisible(false);
	    }
	
	    @FXML
	    void Fil2Carta3(MouseEvent event) {
	    	
	        int varR3 = aleaCartas[2];
	        
    		ptoFil2Carta3.setVisible(false);
	    }
	
	    @FXML
	    void Fil2Carta4(MouseEvent event) {
	    	
	        int varR4 = aleaCartas[3];
	        
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
        
        
        //Configuracion valores cartas fila 2 (1-4) de respuestas
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
