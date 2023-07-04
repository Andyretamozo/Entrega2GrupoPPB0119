package Controlador;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import application.Cartas;
import application.Operacion;
import application.alertaGeneral;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VistaNivel1Controller {
 
		Stage nivelActual1;

		@FXML
	    private Button btnAvanzar;
	
	    @FXML
	    private ToggleGroup btnsF1C1;
	
	    @FXML
	    private ToggleGroup btnsF1C2;
	
	    @FXML
	    private ToggleGroup btnsF1C3;
	
	    @FXML
	    private ToggleGroup btnsF1C4;
	    
	    @FXML
	    private RadioButton rad1Car;

	    @FXML
	    private RadioButton rad2Car;

	    @FXML
	    private RadioButton rad3Car;
	    
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
	    
	    
	    private List<String> puntos; // Lista llamada "puntos"

	    public VistaNivel1Controller() {
	        puntos = new ArrayList<>(); // Inicializar la lista en el constructor de la clase
	        puntos.add("0"); // Agregar el valor inicial del "Acumulado"
	        puntos.add("200"); // Agregar el valor inicial de "puntosnivel1"
	        puntos.add("0"); //Suma avanzar

	    }
	    
	    
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
	    		    		    	   		    		
	        int resul = resultado [4];
            System.out.println("valor real de la carta superior es: " + resul);
	        
            //Se almacenan datos de las cartas en el array	        
    		Cartas.carta[0].setVal(resul);
    		Cartas.carta[0].setTemp(1);
            
    		//Se asignan valores iniciales de la carta actual
    		boolean cv1 = Cartas.carta[0].isVis();
    		boolean cb1 = Cartas.carta[0].isBloq();

    		ptoFil1Carta1.setVisible(cv1);
    		ptoFil1Carta1.setDisable(cb1);
  		
    		//Se bloquean cartas diferentes a actual
    		for (int i = 0; i < Cartas.carta.length-4; i++) {
                if (Cartas.carta[i].getTemp() == 0) {

                    String cartaVariableName = "ptoFil1Carta" + (i + 1);
                    
    	            int prue = Cartas.carta[i].getTemp();//prueba
    	            System.out.println("valor cartas a bloquear select fila 1 : " + cartaVariableName +" es "+ + prue); //prueba
    	            
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
         
            System.out.println("----------------------");//prueba
            
    		//Se desbloquean cartas diferentes inferiores sin coincidir
            for (int x = 4; x < Cartas.carta.length; x++) {
                if (Cartas.carta[x].getTemp() == 0) {

                    String cartaVariableName = "ptoFil2Carta" + (x -3);
                    
    	            int prue = Cartas.carta[x].getTemp();//prueba
    	            System.out.println("valor cartas a desbloquear al select fila sup en fila inf: " + cartaVariableName +" es "+ + prue); //prueba
    	            
                    try {
                        Field field = getClass().getDeclaredField(cartaVariableName);
                        field.setAccessible(true);
                        Node cartaNode = (Node) field.get(this);
                        cartaNode.setDisable(false);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                        e.printStackTrace();
                    }
                }
            }//fin for
            System.out.println("----------------------");//prueba

	    }//fin evento Fil1Car1
	    

	
	    @FXML
	    void Fil1Carta2(MouseEvent event) {
    		
    		//Valor de la carta
	        int resul1 = resultado1 [4];
            System.out.println("valor carta superior es: " + resul1);
            
	        //Se almacenan datos de las cartas en el array	        
    		Cartas.carta[1].setVal(resul1);
    		Cartas.carta[1].setTemp(1);
            
    		//Se asignan valores iniciales de la carta actual
    		boolean cv1 = Cartas.carta[1].isVis();
    		boolean cb1 = Cartas.carta[1].isBloq();

    		ptoFil1Carta2.setVisible(cv1);
    		ptoFil1Carta2.setDisable(cb1);
  		
    		//Se bloquean cartas diferentes a actual
            for (int i = 0; i < Cartas.carta.length-4; i++) {
                if (Cartas.carta[i].getTemp() == 0) {

                    String cartaVariableName = "ptoFil1Carta" + (i + 1);
                    
    	            int prue = Cartas.carta[i].getTemp();//prueba
    	            System.out.println("valor cartas a bloquear select fila 1 : " + cartaVariableName +" es "+ + prue); //prueba
    	            
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
            System.out.println("----------------------");//prueba
            
    		//Se desbloquean cartas diferentes inferiores sin coincidir
            for (int x = 4; x < Cartas.carta.length; x++) {
                if (Cartas.carta[x].getTemp() == 0) {

                    String cartaVariableName = "ptoFil2Carta" + (x -3);
                    
    	            int prue = Cartas.carta[x].getTemp();//prueba
    	            System.out.println("valor cartas a desbloquear al select fila sup en fila inf: " + cartaVariableName +" es "+ + prue); //prueba
    	            
                    try {
                        Field field = getClass().getDeclaredField(cartaVariableName);
                        field.setAccessible(true);
                        Node cartaNode = (Node) field.get(this);
                        cartaNode.setDisable(false);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                        e.printStackTrace();
                    }
                }
            }//fin for
            System.out.println("----------------------");//prueba	      		
	    }//fin evento Fil1Car2
	
	    @FXML
	    void Fil1Carta3(MouseEvent event) {
	    	
    		//Valor de la carta
	        int resul2 = resultado2 [4];
            System.out.println("valor carta superior es: " + resul2);
            
	        //Se almacenan datos de las cartas en el array	        
    		Cartas.carta[2].setVal(resul2);
    		Cartas.carta[2].setTemp(1);
            
    		//Se asignan valores iniciales de la carta actual
    		boolean cv1 = Cartas.carta[2].isVis();
    		boolean cb1 = Cartas.carta[2].isBloq();

    		ptoFil1Carta3.setVisible(cv1);
    		ptoFil1Carta3.setDisable(cb1);
  		
    		//Se bloquean cartas diferentes a actual
            for (int i = 0; i < Cartas.carta.length-4; i++) {
                if (Cartas.carta[i].getTemp() == 0) {

                    String cartaVariableName = "ptoFil1Carta" + (i + 1);
                    
    	            int prue = Cartas.carta[i].getTemp();//prueba
    	            System.out.println("valor cartas a bloquear select fila 1 : " + cartaVariableName +" es "+ + prue); //prueba
    	            
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
            System.out.println("----------------------");//prueba
            
    		//Se desbloquean cartas diferentes inferiores sin coincidir
            for (int x = 4; x < Cartas.carta.length; x++) {
                if (Cartas.carta[x].getTemp() == 0) {

                    String cartaVariableName = "ptoFil2Carta" + (x -3);
                    
    	            int prue = Cartas.carta[x].getTemp();//prueba
    	            System.out.println("valor cartas a desbloquear al select fila sup en fila inf: " + cartaVariableName +" es "+ + prue); //prueba
    	            
                    try {
                        Field field = getClass().getDeclaredField(cartaVariableName);
                        field.setAccessible(true);
                        Node cartaNode = (Node) field.get(this);
                        cartaNode.setDisable(false);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                        e.printStackTrace();
                    }
                }
            }//fin for
            System.out.println("----------------------");//prueba
    		
	    }//fin evento Fil1Car3
	    
	
	    @FXML
	    void Fil1Carta4(MouseEvent event) {
    		    		
    		//Valor de la carta
	        int resul3 = resultado3 [4];
            System.out.println("valor carta superior es: " + resul3);
            
	        //Se almacenan datos de las cartas en el array
    		Cartas.carta[3].setVal(resul3);
    		Cartas.carta[3].setTemp(1);

    		//Se asignan valores iniciales de la carta actual
    		boolean cv1 = Cartas.carta[3].isVis();
    		boolean cb1 = Cartas.carta[3].isBloq();

    		ptoFil1Carta4.setVisible(cv1);
    		ptoFil1Carta4.setDisable(cb1);

  		
    		//Se bloquean cartas diferentes a actual
            for (int i = 0; i < Cartas.carta.length-4; i++) {
                if (Cartas.carta[i].getTemp() == 0) {

                    String cartaVariableName = "ptoFil1Carta" + (i + 1);
                    
    	            int prue = Cartas.carta[i].getTemp();//prueba
    	            System.out.println("valor cartas a bloquear select fila 1 : " + cartaVariableName +" es "+ + prue); //prueba
    	            
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
            System.out.println("----------------------");//prueba
            
    		//Se desbloquean cartas diferentes inferiores sin coincidir
            for (int x = 4; x < Cartas.carta.length; x++) {
                if (Cartas.carta[x].getTemp() == 0) {

                    String cartaVariableName = "ptoFil2Carta" + (x -3);
                    
    	            int prue = Cartas.carta[x].getTemp();//prueba
    	            System.out.println("valor cartas a desbloquear al select fila sup en fila inf: " + cartaVariableName +" es "+ + prue); //prueba
    	            
                    try {
                        Field field = getClass().getDeclaredField(cartaVariableName);
                        field.setAccessible(true);
                        Node cartaNode = (Node) field.get(this);
                        cartaNode.setDisable(false);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                        e.printStackTrace();
                    }
                }
            }//fin for
            System.out.println("----------------------");//prueba  		

	    }
	
	    @FXML
	    void Fil2Carta1(MouseEvent event) {
	    	            
	    	//Se asigna el valor a carta actual aleatorio del array resCartas
	        int varR1 = aleaCartas[0];
	        int nunCarta1 = resCartas[varR1];
	        
	        //Se almacena el valor de la carta actual en la posicion 4 de la lista carta
	        Cartas.carta[4].setVal(nunCarta1);
    		Cartas.carta[4].setTemp(1);
	        ptoFil2Carta1.setVisible(false);
	       	      
            //se deshabilitan cartas sin coincidir fila inferior
            for (int i = 4; i < Cartas.carta.length; i++) {
                if (Cartas.carta[i].getTemp() == 0) {
                    
    	            String cartaVariableName2 = "ptoFil2Carta" + (i - 3);
    	            int prue = Cartas.carta[i].getTemp();//prueba
    	            System.out.println("valor temp a bloquear: " + cartaVariableName2 +" es "+ + prue); //prueba

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
            System.out.println("----------------------");//prueba
                 
	     
            /*
             * Se inicia verificacion de coincidencia
             */ 
            
	        int numeroBuscado = 1;
	        int posic = Cartas.buscarCartaSuperior(numeroBuscado);
	        int valCartaSup = Cartas.carta[posic].getVal();
	        	        	        
	        /*
	         * Valor de la carta superior se toma segun el radioButton seleccionado
	         * Se invoca el metodo obtenerValorRadCar de la clase Cartas para obtener el valor 
	         * segun la carta superior seleccionada
	         */   		      
	        int resul = 0;
    		if (posic==0) {
    			resul= Cartas.obtenerValorRadCar(btnsF1C1);
    			
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C1, "rad1Car");
                Cartas.bloqRadCar(btnsF1C1, "rad2Car");
                Cartas.bloqRadCar(btnsF1C1, "rad3Car"); 
                
    		}else if (posic==1) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C2);
        		
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C2, "rad1Car");
                Cartas.bloqRadCar(btnsF1C2, "rad2Car");
                Cartas.bloqRadCar(btnsF1C2, "rad3Car");
                
    		}else if (posic==2) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C3);
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C3, "rad1Car");
                Cartas.bloqRadCar(btnsF1C3, "rad2Car");
                Cartas.bloqRadCar(btnsF1C3, "rad3Car");  
     		}else if (posic==3) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C4);
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C4, "rad1Car");
                Cartas.bloqRadCar(btnsF1C4, "rad2Car");
                Cartas.bloqRadCar(btnsF1C4, "rad3Car");  
      		}
	        

    		//Se obtiene la carta que se selecciono en la fila supeior y el vBox
	        String cartaVariableName = "ptoFil1Carta" + (posic + 1);
	        String cartaVboxColor = "vBox" + (posic + 1);
	        System.out.println("valor seleccionado carta superior " + cartaVariableName +" es "+ resul + ", valor carta inferior : " + nunCarta1);//prueba
	        	        
            try {
	        // Comparar el valor con el de la carta seleccionada en la fila superior
	        if (nunCarta1 == valCartaSup && valCartaSup == resul) {
	        	
		        System.out.println("valor carta inferior y superior coinciden");//prueba
		        
		        // Se accede a los valores de la lista "puntos"
		        int acumtotal = Integer.parseInt (puntos.get(0)); // Obtener el valor de "Acumulado" de la lista
		        int ptosNivel = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        int ptosAvan = Integer.parseInt (puntos.get(2)); // Obtener el valor de "puntosnivel1" de la lista
		        		        
		        // Se incrementa puntos de nivel +10	    
		        ptosNivel += 10;
		        ptosAvan +=10;
		        System.out.println("valor carta inferior y superior coinciden puntos se suma 10 " + ptosNivel);//prueba
		        //acumtotal = ptosNivel; // Se actualiza acumulado
		        
		        // Se guardan en una variable a String
		        String ptosN1 = Integer.toString(ptosNivel);
		        String acumN1 = Integer.toString(acumtotal);
		        String avnzN1 = Integer.toString(ptosAvan);
		        
		        puntos.set(0, acumN1); // Actualizar el valor de "Acumulado" en la lista
		        puntos.set(1, ptosN1); // Actualizar el valor de "puntosnivel" en la lista
		        puntos.set(2, avnzN1); // Actualizar el valor de "puntosnivel" en la lista
		        
		        int ptosNivelpr = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        System.out.println("coinciden valor nuevo puntos de nivel " + ptosNivelpr);//prueba
		        
		        String ptoNiv1Str = (puntos.get(1));
		        String avanz2 = (puntos.get(2));
		        System.out.println("Valor acumulado para avanzar " + avanz2);//prueba
	            puntosNivel1.setText(ptoNiv1Str);
	            totAcumulado.setText(ptoNiv1Str); // @@@ ojo en este nivel acumulado es el mismo valor de puntosNivel1
	            
                
		    	 // Carta superior se tomo temporal como 2
	        	Cartas.carta[posic].setTemp(2);
		    	//Carta inferior se tomo temporal como 2
	    		Cartas.carta[4].setTemp(2); 
		    	//Se bloquea carta que coincide inferior
		        ptoFil2Carta1.setVisible(false);
		        ptoFil2Carta1.setDisable(true);
	            
		        /*
		         * Se bloquea carta que coincide Superior
		         */
                Field field = getClass().getDeclaredField(cartaVariableName);
                field.setAccessible(true);
                Node cartaNode = (Node) field.get(this);
                cartaNode.setVisible(true);
                cartaNode.setDisable(true);
                cartaNode.setOpacity(0.09);
                
                /*
                 * Cambio del color de la carta vBox
                 */
                //Se crea el color
                Color colorPersonalizado = Color.rgb(143, 57, 144);
                // Se asigna el color carta inferior
				vBox5.setBackground(new Background(new BackgroundFill(colorPersonalizado, null, null)));

                //Se asigna el color carta superior
                Field fieldBox = getClass().getDeclaredField(cartaVboxColor);
                fieldBox.setAccessible(true);
                Node vBoxNode = (Node) fieldBox.get(this);
                ((Region) vBoxNode).setBackground(new Background(new BackgroundFill(colorPersonalizado, null, null)));
                
                
                //se habilitan cartas sin coincidir de la fila superior
                for (int i = 0; i < Cartas.carta.length -4; i++) {
                    if (Cartas.carta[i].getTemp() == 0) {
                    	
                        String cartaVariableNameN1 = "ptoFil1Carta" + (i + 1);
                      
        	            int prue = Cartas.carta[i].getTemp();//prueba
        	            System.out.println("valor coincide sup a b : " + cartaVariableNameN1 +" es "+ + prue); //prueba      	         
        	            
                        try {
                        	
                            Field field1 = getClass().getDeclaredField(cartaVariableNameN1);
                            field1.setAccessible(true);
                            Node cartaNode1 = (Node) field1.get(this);
                            cartaNode1.setDisable(false);
                        	
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableNameN1);
                            e.printStackTrace();
                        }
                    }
                }//fin for
                System.out.println("----------------------");//prueba
                
                //se deshabilitan cartas sin coincidir de la fila inferior
                for (int x = 4; x < Cartas.carta.length; x++) {
                    if (Cartas.carta[x].getTemp() == 0) {

                        String cartaVariableName2 = "ptoFil2Carta" + (x -3);
                        
                        
        	            int prue = Cartas.carta[x].getTemp();//prueba
        	            System.out.println("Se bloquean cartas inferiores sin coincidir " + cartaVariableName2 +" y valor temp es "+ + prue); //prueba
        	            
                        try {
                            Field field2 = getClass().getDeclaredField(cartaVariableName2);
                            field2.setAccessible(true);
                            Node cartaNode2 = (Node) field2.get(this);
                            cartaNode2.setDisable(true);
                        } catch (NoSuchFieldException | IllegalAccessException ex) {
                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName2);
                            ex.printStackTrace();
                        }
                    }
                }//fin for
                System.out.println("----------------------");//prueba 
                
                //Se habilita boton avanzar
            	ptosAvan = Integer.parseInt (puntos.get(2));
            	if (ptosAvan==40) {
            		alertaGeneral.showAlert("Nivel Alcanzado", "Puedes avanzar de nivel");
            		   btnAvanzar.setDisable(false);
            	}

                
	            int prue = Cartas.carta[posic].getVal();
	            int prue2 = Cartas.carta[posic].getTemp();
	            System.out.println("valor carta verdadero : " + prue);
	            System.out.println("valor temp carta verdadero : " + prue2);
	            

	        } else {
	        	
		        System.out.println("valor carta inferior y superior no coinciden");//prueba
		        
			    // Se decrementa puntos de nivel -10	    	    
		        int acumtotal = Integer.parseInt (puntos.get(0)); // Obtener el valor de "Acumulado" de la lista
		        int ptosNivel = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        		        
		        // Se incrementa puntos de nivel +10	    
		        ptosNivel -= 10;
		        System.out.println("valor carta inferior y superior coinciden puntos se suma 10 " + ptosNivel);//prueba
		        
		        // Se guardan en una variable a String
		        String ptosN1 = Integer.toString(ptosNivel);
		        String acumN1 = Integer.toString(acumtotal);
		        
		        puntos.set(0, acumN1); // Actualizar el valor de "Acumulado" en la lista
		        puntos.set(1, ptosN1); // Actualizar el valor de "puntosnivel" en la lista
		        
		        int ptosNivelpr = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        System.out.println("coinciden valor nuevo puntos de nivel " + ptosNivelpr);//prueba
		        
		        //Se asigna nuevo valor al label puntosNivel1
		        String ptoNiv1Str = (puntos.get(1));
	            puntosNivel1.setText(ptoNiv1Str);
	            totAcumulado.setText(ptoNiv1Str); // @@@ ojo en este nivel acumulado es el mismo valor de puntosNivel1
	            
	            Cartas.carta[posic].setTemp(0);
	    		Cartas.carta[4].setTemp(0);

	            // Obtener el nombre de la variable de la carta correspondiente
	                Field field = getClass().getDeclaredField(cartaVariableName);
	                field.setAccessible(true);
	                Node cartaNode = (Node) field.get(this);
	                
	                PauseTransition pause = new PauseTransition(Duration.seconds(5)); // Pausa de 2 segundos
	                pause.setOnFinished(e -> {
	                	
	                	cartaNode.setVisible(true); 
	                	ptoFil2Carta1.setVisible(true);
	                	
	                //se deshabilitan cartas sin coincidir de la fila inferior
	                for (int x = 4; x < Cartas.carta.length; x++) {
	                    if (Cartas.carta[x].getTemp() == 0) {

	                        String cartaVariableName2 = "ptoFil2Carta" + (x -3);
	                        
	        	            int prue = Cartas.carta[x].getTemp();//prueba
	        	            System.out.println("Se bloquean cartas inferiores sin coincidir " + cartaVariableName2 +" y valor temp es "+ + prue); //prueba
	        	            
	                        try {
	                            Field field2 = getClass().getDeclaredField(cartaVariableName2);
	                            field2.setAccessible(true);
	                            Node cartaNode2 = (Node) field2.get(this);
	                            cartaNode2.setDisable(true);
	                        } catch (NoSuchFieldException | IllegalAccessException ex) {
	                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName2);
	                            ex.printStackTrace();
	                        }
	                    }
	                }//fin for
	                System.out.println("----------------------");//prueba
	                
	                //se habilitan cartas sin coincidir de la fila superior
	                for (int i = 0; i < Cartas.carta.length -4; i++) { // al bloquear una carta queda un campo de mas en el array
	                    if (Cartas.carta[i].getTemp() == 0) {
	                    	
	                        String cartaVariableNameN1 = "ptoFil1Carta" + (i + 1);
	           	            int prue = Cartas.carta[i].getTemp();//prueba
	        	            System.out.println("Se habilitan cartas superiores sin coincidir " + cartaVariableNameN1 +" valor temp es "+ + prue); //prueba

	                        try {
	                        	
	                            Field field1 = getClass().getDeclaredField(cartaVariableNameN1);
	                            field1.setAccessible(true);
	                            Node cartaNode1 = (Node) field1.get(this);
	                            cartaNode1.setDisable(false);
	                        	
	                        } catch (NoSuchFieldException | IllegalAccessException ex) {
	                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableNameN1);
	                            ex.printStackTrace();
	                        }
	                    }
	                }//fin for
	                System.out.println("----------------------");//prueba
	                
	                
	                /*	    	      
	    	         * Se invoca el metodo bloqRadCar de la clase Cartas para obtener el valor 
	    	         * segun la carta superior seleccionada
	    	         */   		      
	    	       
	        		if (posic==0) {	        				        			
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C1, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C1, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C1, "rad3Car"); 
	                    
	        		}else if (posic==1) {	            		
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C2, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C2, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C2, "rad3Car");
	                    
	        		}else if (posic==2) {
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C3, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C3, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C3, "rad3Car");  
	         		}else if (posic==3) {
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C4, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C4, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C4, "rad3Car");  
	          		}
	                
	                }); // Hacer visible el nodo después de la pausa
	                pause.play();
	                
	            } 
	        }catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                e.printStackTrace();
            }
   
	    }
	    
	
	    @FXML
	    void Fil2Carta2(MouseEvent event) {
	    		    	
	    	//Se asigna el valor a carta actual aleatorio del array resCartas
	        int varR2 = aleaCartas[1];
	        int nunCarta1 = resCartas[varR2];
	        
	        //Se almacena el valor de la carta actual en la posicion 5 de la lista carta
	        Cartas.carta[5].setVal(nunCarta1);
    		Cartas.carta[5].setTemp(1);
	        ptoFil2Carta2.setVisible(false);
	       	      
            //se deshabilitan cartas sin coincidir fila inferior
            for (int i = 4; i < Cartas.carta.length; i++) {
                if (Cartas.carta[i].getTemp() == 0) {
                    
    	            String cartaVariableName2 = "ptoFil2Carta" + (i - 3);
    	            int prue = Cartas.carta[i].getTemp();//prueba
    	            System.out.println("valor temp a bloquear: " + cartaVariableName2 +" es "+ + prue); //prueba

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
            System.out.println("----------------------");//prueba
	     
            /*
             * Se inicia verificacion de coincidencia
             */
	        int numeroBuscado = 1;
	        int posic = Cartas.buscarCartaSuperior(numeroBuscado);
	        int valCartaSup = Cartas.carta[posic].getVal();
	        
	        /*
	         * Valor de la carta superior se toma segun el radioButton seleccionado
	         * Se invoca el metodo obtenerValorRadCar de la clase Cartas para obtener el valor 
	         * segun la carta superior seleccionada
	         */   		      
	        int resul = 0;
	        if (posic==0) {
    			resul= Cartas.obtenerValorRadCar(btnsF1C1);
    			
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C1, "rad1Car");
                Cartas.bloqRadCar(btnsF1C1, "rad2Car");
                Cartas.bloqRadCar(btnsF1C1, "rad3Car"); 
                
    		}else if (posic==1) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C2);
        		
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C2, "rad1Car");
                Cartas.bloqRadCar(btnsF1C2, "rad2Car");
                Cartas.bloqRadCar(btnsF1C2, "rad3Car");
                
    		}else if (posic==2) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C3);
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C3, "rad1Car");
                Cartas.bloqRadCar(btnsF1C3, "rad2Car");
                Cartas.bloqRadCar(btnsF1C3, "rad3Car");  
     		}else if (posic==3) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C4);
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C4, "rad1Car");
                Cartas.bloqRadCar(btnsF1C4, "rad2Car");
                Cartas.bloqRadCar(btnsF1C4, "rad3Car");  
      		}

    		//Se obtiene la carta que se selecciono en la fila supeior y el vBox
	        String cartaVariableName = "ptoFil1Carta" + (posic + 1);
	        String cartaVboxColor = "vBox" + (posic + 1);
	        System.out.println("valor carta superior " + cartaVariableName +" es "+ valCartaSup + ", valor carta inferior : " + nunCarta1);//prueba

	        	        
            try {
	        // Comparar el valor con el de la carta seleccionada en la fila superior
	        if (nunCarta1 == valCartaSup  && valCartaSup == resul) {
	        	
		        System.out.println("valor carta inferior y superior coinciden");//prueba
		        
		     // Se accede a los valores de la lista "puntos"
		        int acumtotal = Integer.parseInt (puntos.get(0)); // Obtener el valor de "Acumulado" de la lista
		        int ptosNivel = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        int ptosAvan = Integer.parseInt (puntos.get(2)); // Obtener el valor de "puntosnivel1" de la lista
		        		        
		        // Se incrementa puntos de nivel +10	    
		        ptosNivel += 10;
		        ptosAvan +=10;
		        System.out.println("valor carta inferior y superior coinciden puntos se suma 10 " + ptosNivel);//prueba
		        
		        // Se guardan en una variable a String
		        String ptosN1 = Integer.toString(ptosNivel);
		        String acumN1 = Integer.toString(acumtotal);		        
		        String avnzN1 = Integer.toString(ptosAvan);
		        
		        puntos.set(0, acumN1); // Actualizar el valor de "Acumulado" en la lista
		        puntos.set(1, ptosN1); // Actualizar el valor de "puntosnivel" en la lista
		        puntos.set(2, avnzN1); // Actualizar el valor de "puntosnivel" en la lista
		        
		        int ptosNivelpr = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        System.out.println("coinciden valor nuevo puntos de nivel " + ptosNivelpr);//prueba
		        
		        String ptoNiv1Str = (puntos.get(1));
	            puntosNivel1.setText(ptoNiv1Str);
	            totAcumulado.setText(ptoNiv1Str); // @@@ ojo en este nivel acumulado es el mismo valor de puntosNivel1

		        
		    	 // Carta superior se tomo temporal como 2
	        	Cartas.carta[posic].setTemp(2);
		    	//Carta inferior se tomo temporal como 2
	    		Cartas.carta[5].setTemp(2);
		    	//Se bloquea carta que coincide inferior
		        ptoFil2Carta2.setVisible(false);
		        ptoFil2Carta2.setDisable(true);
	            
		        /*
		         * Se bloquea carta que coincide Superior
		         */
                Field field = getClass().getDeclaredField(cartaVariableName);
                field.setAccessible(true);
                Node cartaNode = (Node) field.get(this);
                cartaNode.setVisible(true);
                cartaNode.setDisable(true);
                cartaNode.setOpacity(0.09);
                
                /*
                 * Cambio del color de la carta vBox
                 */
                //Se crea el color
                Color colorPersonalizado = Color.rgb(35, 33, 64);
                // se asigna el color carta inferior
				vBox6.setBackground(new Background(new BackgroundFill(colorPersonalizado, null, null)));

                //Se asigna el color carta superior
                Field fieldBox = getClass().getDeclaredField(cartaVboxColor);
                fieldBox.setAccessible(true);
                Node vBoxNode = (Node) fieldBox.get(this);
                ((Region) vBoxNode).setBackground(new Background(new BackgroundFill(colorPersonalizado, null, null)));
   
                
                //se habilitan cartas sin coincidir de la fila superior
                for (int i = 0; i < Cartas.carta.length -4; i++) {
                    if (Cartas.carta[i].getTemp() == 0) {
                    	
                        String cartaVariableNameN1 = "ptoFil1Carta" + (i + 1);
                      
        	            int prue = Cartas.carta[i].getTemp();//prueba
        	            System.out.println("valor coincide sup a b : " + cartaVariableNameN1 +" es "+ + prue); //prueba      	         
        	            
                        try {
                        	
                            Field field1 = getClass().getDeclaredField(cartaVariableNameN1);
                            field1.setAccessible(true);
                            Node cartaNode1 = (Node) field1.get(this);
                            cartaNode1.setDisable(false);
                        	
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableNameN1);
                            e.printStackTrace();
                        }
                    }
                }//fin for
                System.out.println("----------------------");//prueba
                
                //se deshabilitan cartas sin coincidir de la fila inferior
                for (int x = 4; x < Cartas.carta.length; x++) {
                    if (Cartas.carta[x].getTemp() == 0) {

                        String cartaVariableName2 = "ptoFil2Carta" + (x -3);
                        
        	            int prue = Cartas.carta[x].getTemp();//prueba
        	            System.out.println("Se bloquean cartas inferiores sin coincidir " + cartaVariableName2 +" y valor temp es "+ + prue); //prueba
        	            
                        try {
                            Field field2 = getClass().getDeclaredField(cartaVariableName2);
                            field2.setAccessible(true);
                            Node cartaNode2 = (Node) field2.get(this);
                            cartaNode2.setDisable(true);
                        } catch (NoSuchFieldException | IllegalAccessException ex) {
                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName2);
                            ex.printStackTrace();
                        }
                    }
                }//fin for
                System.out.println("----------------------");//prueba 
                
                //Se habilita boton avanzar
            	ptosAvan = Integer.parseInt (puntos.get(2));
            	if (ptosAvan==40) {
            		alertaGeneral.showAlert("Nivel Alcanzado", "Puedes avanzar de nivel");
            		   btnAvanzar.setDisable(false);
            	}
                
	            int prue = Cartas.carta[posic].getVal();
	            int prue2 = Cartas.carta[posic].getTemp();
	            System.out.println("valor carta inferior verdadero : " + prue);
	            System.out.println("valor temp carta verdadero : " + prue2);
	            

	        } else {
	        	
		        System.out.println("valor carta inferior y superior no coinciden");//prueba
		        
		     // Se decrementa puntos de nivel -10	    	    
		        int acumtotal = Integer.parseInt (puntos.get(0)); // Obtener el valor de "Acumulado" de la lista
		        int ptosNivel = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        //String ptoNiv1Str = (puntos.get(1));
		        		        
		        // Se incrementa puntos de nivel +10	    
		        ptosNivel -= 10;
		        System.out.println("valor carta inferior y superior coinciden puntos se suma 10 " + ptosNivel);//prueba
		        
		        // Se guardan en una variable a String
		        String ptosN1 = Integer.toString(ptosNivel);
		        String acumN1 = Integer.toString(acumtotal);
		        
		        puntos.set(0, acumN1); // Actualizar el valor de "Acumulado" en la lista
		        puntos.set(1, ptosN1); // Actualizar el valor de "puntosnivel" en la lista
		        
		        int ptosNivelpr = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        System.out.println("coinciden valor nuevo puntos de nivel " + ptosNivelpr);//prueba
		        
		        //Se asigna nuevo valor al label puntosNivel1
		        String ptoNiv1Str = (puntos.get(1));
	            puntosNivel1.setText(ptoNiv1Str);
	            totAcumulado.setText(ptoNiv1Str); // @@@ ojo en este nivel acumulado es el mismo valor de puntosNivel1

	            Cartas.carta[posic].setTemp(0);
	    		Cartas.carta[5].setTemp(0);

	            // Obtener el nombre de la variable de la carta correspondiente
	                Field field = getClass().getDeclaredField(cartaVariableName);
	                field.setAccessible(true);
	                Node cartaNode = (Node) field.get(this);
	                
	                PauseTransition pause = new PauseTransition(Duration.seconds(5)); // Pausa de 2 segundos
	                pause.setOnFinished(e -> {
	                	
	                	cartaNode.setVisible(true); 
	                	ptoFil2Carta2.setVisible(true);
	                	
	                //se deshabilitan cartas sin coincidir de la fila inferior
	                for (int x = 4; x < Cartas.carta.length; x++) {
	                    if (Cartas.carta[x].getTemp() == 0) {

	                        String cartaVariableName2 = "ptoFil2Carta" + (x -3);
	                        
	        	            int prue = Cartas.carta[x].getTemp();//prueba
	        	            System.out.println("Se bloquean cartas inferiores sin coincidir " + cartaVariableName2 +" y valor temp es "+ + prue); //prueba
	        	            
	                        try {
	                            Field field2 = getClass().getDeclaredField(cartaVariableName2);
	                            field2.setAccessible(true);
	                            Node cartaNode2 = (Node) field2.get(this);
	                            cartaNode2.setDisable(true);
	                        } catch (NoSuchFieldException | IllegalAccessException ex) {
	                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName2);
	                            ex.printStackTrace();
	                        }
	                    }
	                }//fin for
	                System.out.println("----------------------");//prueba
	                
	                //se habilitan cartas sin coincidir de la fila superior
	                for (int i = 0; i < Cartas.carta.length -4; i++) { // al bloquear una carta queda un campo de mas en el array
	                    if (Cartas.carta[i].getTemp() == 0) {
	                    	
	                        String cartaVariableNameN1 = "ptoFil1Carta" + (i + 1);
	           	            int prue = Cartas.carta[i].getTemp();//prueba
	        	            System.out.println("Se habilitan cartas superiores sin coincidir " + cartaVariableNameN1 +" valor temp es "+ + prue); //prueba

	                        try {
	                        	
	                            Field field1 = getClass().getDeclaredField(cartaVariableNameN1);
	                            field1.setAccessible(true);
	                            Node cartaNode1 = (Node) field1.get(this);
	                            cartaNode1.setDisable(false);
	                        	
	                        } catch (NoSuchFieldException | IllegalAccessException ex) {
	                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableNameN1);
	                            ex.printStackTrace();
	                        }
	                    }
	                }//fin for
	                System.out.println("----------------------");//prueba
	                
	                /*	    	      
	    	         * Se invoca el metodo bloqRadCar de la clase Cartas para obtener el valor 
	    	         * segun la carta superior seleccionada
	    	         */   		      
	    	       
	        		if (posic==0) {	        				        			
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C1, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C1, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C1, "rad3Car"); 
	                    
	        		}else if (posic==1) {	            		
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C2, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C2, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C2, "rad3Car");
	                    
	        		}else if (posic==2) {
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C3, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C3, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C3, "rad3Car");  
	         		}else if (posic==3) {
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C4, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C4, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C4, "rad3Car");  
	          		}
	                
	                }); // Hacer visible el nodo después de la pausa
	                pause.play();
	                
	            } 
	        }catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                e.printStackTrace();
            }
	    }
	
	    @FXML
	    void Fil2Carta3(MouseEvent event) {	    		       
    			    	
	    	//Se asigna el valor a carta actual aleatorio del array resCartas
	        int varR3 = aleaCartas[2];
	        int nunCarta1 = resCartas[varR3];
	        
	        //Se almacena el valor de la carta actual en la posicion 6 de la lista carta
	        Cartas.carta[6].setVal(nunCarta1);
    		Cartas.carta[6].setTemp(1);
	        ptoFil2Carta3.setVisible(false);
	       	      
            //se deshabilitan cartas sin coincidir fila inferior
            for (int i = 4; i < Cartas.carta.length; i++) {
                if (Cartas.carta[i].getTemp() == 0) {
                    
    	            String cartaVariableName2 = "ptoFil2Carta" + (i - 3);
    	            int prue = Cartas.carta[i].getTemp();//prueba
    	            System.out.println("valor temp a bloquear: " + cartaVariableName2 +" es "+ + prue); //prueba

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
            System.out.println("----------------------");//prueba
	     
            /*
             * Se inicia verificacion de coincidencia
             */
	        int numeroBuscado = 1;
	        int posic = Cartas.buscarCartaSuperior(numeroBuscado);
	        int valCartaSup = Cartas.carta[posic].getVal();
	        
	        /*
	         * Valor de la carta superior se toma segun el radioButton seleccionado
	         * Se invoca el metodo obtenerValorRadCar de la clase Cartas para obtener el valor 
	         * segun la carta superior seleccionada
	         */   		      
	        int resul = 0;
	        if (posic==0) {
    			resul= Cartas.obtenerValorRadCar(btnsF1C1);
    			
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C1, "rad1Car");
                Cartas.bloqRadCar(btnsF1C1, "rad2Car");
                Cartas.bloqRadCar(btnsF1C1, "rad3Car"); 
                
    		}else if (posic==1) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C2);
        		
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C2, "rad1Car");
                Cartas.bloqRadCar(btnsF1C2, "rad2Car");
                Cartas.bloqRadCar(btnsF1C2, "rad3Car");
                
    		}else if (posic==2) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C3);
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C3, "rad1Car");
                Cartas.bloqRadCar(btnsF1C3, "rad2Car");
                Cartas.bloqRadCar(btnsF1C3, "rad3Car");  
     		}else if (posic==3) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C4);
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C4, "rad1Car");
                Cartas.bloqRadCar(btnsF1C4, "rad2Car");
                Cartas.bloqRadCar(btnsF1C4, "rad3Car");  
      		}
    		
    		//Se obtiene la carta que se selecciono en la fila supeior y el vBox
	        String cartaVariableName = "ptoFil1Carta" + (posic + 1);
	        String cartaVboxColor = "vBox" + (posic + 1);
	        System.out.println("valor carta superior " + cartaVariableName +" es "+ valCartaSup + ", valor carta inferior : " + nunCarta1);//prueba	      
	        
	        
            try {
	        // Comparar el valor con el de la carta seleccionada en la fila superior
	        if (nunCarta1 == valCartaSup  && valCartaSup == resul) {
	        	
		        System.out.println("valor carta inferior y superior coinciden");//prueba
		        
		     // Se accede a los valores de la lista "puntos"
		        int acumtotal = Integer.parseInt (puntos.get(0)); // Obtener el valor de "Acumulado" de la lista
		        int ptosNivel = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        int ptosAvan = Integer.parseInt (puntos.get(2)); // Obtener el valor de "puntosnivel1" de la lista
		        		        
		        // Se incrementa puntos de nivel +10	    
		        ptosNivel += 10;
		        ptosAvan +=10;
		        System.out.println("valor carta inferior y superior coinciden puntos se suma 10 " + ptosNivel);//prueba
		        
		        // Se guardan en una variable a String
		        String ptosN1 = Integer.toString(ptosNivel);
		        String acumN1 = Integer.toString(acumtotal);		        
		        String avnzN1 = Integer.toString(ptosAvan);
		        
		        puntos.set(0, acumN1); // Actualizar el valor de "Acumulado" en la lista
		        puntos.set(1, ptosN1); // Actualizar el valor de "puntosnivel" en la lista
		        puntos.set(2, avnzN1); // Actualizar el valor de "puntosnivel" en la lista
		        
		        int ptosNivelpr = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        System.out.println("coinciden valor nuevo puntos de nivel " + ptosNivelpr);//prueba
		        
		        String ptoNiv1Str = (puntos.get(1));
	            puntosNivel1.setText(ptoNiv1Str);
	            totAcumulado.setText(ptoNiv1Str); // @@@ ojo en este nivel acumulado es el mismo valor de puntosNivel1

		        
		    	 // Carta superior se tomo temporal como 2
	        	Cartas.carta[posic].setTemp(2);
		    	//Carta inferior se tomo temporal como 2
	    		Cartas.carta[6].setTemp(2); 
		    	//Se bloquea carta que coincide inferior
		        ptoFil2Carta3.setVisible(false);
		        ptoFil2Carta3.setDisable(true);
	            
		        /*
		         * Se bloquea carta que coincide Superior
		         */
                Field field = getClass().getDeclaredField(cartaVariableName);
                field.setAccessible(true);
                Node cartaNode = (Node) field.get(this);
                cartaNode.setVisible(true);
                cartaNode.setDisable(true);
                cartaNode.setOpacity(0.09);
                
                /*
                 * Cambio del color de la carta vBox
                 */
                //Se crea el color
                Color colorPersonalizado = Color.rgb(241, 0, 226);
                // se asigna el color carta inferior
				vBox7.setBackground(new Background(new BackgroundFill(colorPersonalizado, null, null)));

                // se asigna el color carta superior
                Field fieldBox = getClass().getDeclaredField(cartaVboxColor);
                fieldBox.setAccessible(true);
                Node vBoxNode = (Node) fieldBox.get(this);
                ((Region) vBoxNode).setBackground(new Background(new BackgroundFill(colorPersonalizado, null, null)));
 
                
                //se habilitan cartas sin coincidir de la fila superior
                for (int i = 0; i < Cartas.carta.length -4; i++) {
                    if (Cartas.carta[i].getTemp() == 0) {
                    	
                        String cartaVariableNameN1 = "ptoFil1Carta" + (i + 1);
                      
        	            int prue = Cartas.carta[i].getTemp();//prueba
        	            System.out.println("valor coincide sup a b : " + cartaVariableNameN1 +" es "+ + prue); //prueba      	         
        	            
                        try {
                        	
                            Field field1 = getClass().getDeclaredField(cartaVariableNameN1);
                            field1.setAccessible(true);
                            Node cartaNode1 = (Node) field1.get(this);
                            cartaNode1.setDisable(false);
                        	
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableNameN1);
                            e.printStackTrace();
                        }
                    }
                }//fin for
                System.out.println("----------------------");//prueba
                
                //se deshabilitan cartas sin coincidir de la fila inferior
                for (int x = 4; x < Cartas.carta.length; x++) {
                    if (Cartas.carta[x].getTemp() == 0) {

                        String cartaVariableName2 = "ptoFil2Carta" + (x -3);
                        
        	            int prue = Cartas.carta[x].getTemp();//prueba
        	            System.out.println("Se bloquean cartas inferiores sin coincidir " + cartaVariableName2 +" y valor temp es "+ + prue); //prueba
        	            
                        try {
                            Field field2 = getClass().getDeclaredField(cartaVariableName2);
                            field2.setAccessible(true);
                            Node cartaNode2 = (Node) field2.get(this);
                            cartaNode2.setDisable(true);
                        } catch (NoSuchFieldException | IllegalAccessException ex) {
                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName2);
                            ex.printStackTrace();
                        }
                    }
                }//fin for
                System.out.println("----------------------");//prueba
                
                //Se habilita boton avanzar
            	ptosAvan = Integer.parseInt (puntos.get(2));
            	if (ptosAvan==40) {
            		alertaGeneral.showAlert("Nivel Alcanzado", "Puedes avanzar de nivel");
            		   btnAvanzar.setDisable(false);
            	}
                                
	            int prue = Cartas.carta[posic].getVal();
	            int prue2 = Cartas.carta[posic].getTemp();
	            System.out.println("valor carta verdadero : " + prue);
	            System.out.println("valor temp carta verdadero : " + prue2);
	            

	        } else {
	        	
		        System.out.println("valor carta inferior y superior no coinciden");//prueba 
	            
		     // Se decrementa puntos de nivel -10	    	    
		        int acumtotal = Integer.parseInt (puntos.get(0)); // Obtener el valor de "Acumulado" de la lista
		        int ptosNivel = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        		        
		        // Se incrementa puntos de nivel +10	    
		        ptosNivel -= 10;
		        System.out.println("valor carta inferior y superior coinciden puntos se suma 10 " + ptosNivel);//prueba
		        
		        // Se guardan en una variable a String
		        String ptosN1 = Integer.toString(ptosNivel);
		        String acumN1 = Integer.toString(acumtotal);
		        
		        puntos.set(0, acumN1); // Actualizar el valor de "Acumulado" en la lista
		        puntos.set(1, ptosN1); // Actualizar el valor de "puntosnivel" en la lista
		        
		        int ptosNivelpr = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        System.out.println("coinciden valor nuevo puntos de nivel " + ptosNivelpr);//prueba
		        
		        //Se asigna nuevo valor al label puntosNivel1
		        String ptoNiv1Str = (puntos.get(1));
	            puntosNivel1.setText(ptoNiv1Str);
	            totAcumulado.setText(ptoNiv1Str); // @@@ ojo en este nivel acumulado es el mismo valor de puntosNivel1

	            Cartas.carta[posic].setTemp(0);
	    		Cartas.carta[6].setTemp(0);

	            // Obtener el nombre de la variable de la carta correspondiente
	                Field field = getClass().getDeclaredField(cartaVariableName);
	                field.setAccessible(true);
	                Node cartaNode = (Node) field.get(this);
	                
	                PauseTransition pause = new PauseTransition(Duration.seconds(5)); // Pausa de 2 segundos
	                pause.setOnFinished(e -> {
	                	
	                	cartaNode.setVisible(true); 
	                	ptoFil2Carta3.setVisible(true);
	                	
	                //se deshabilitan cartas sin coincidir de la fila inferior
	                for (int x = 4; x < Cartas.carta.length; x++) {
	                    if (Cartas.carta[x].getTemp() == 0) {

	                        String cartaVariableName2 = "ptoFil2Carta" + (x -3);
	                        
	        	            int prue = Cartas.carta[x].getTemp();//prueba
	        	            System.out.println("Se bloquean cartas inferiores sin coincidir " + cartaVariableName2 +" y valor temp es "+ + prue); //prueba
	        	            
	                        try {
	                            Field field2 = getClass().getDeclaredField(cartaVariableName2);
	                            field2.setAccessible(true);
	                            Node cartaNode2 = (Node) field2.get(this);
	                            cartaNode2.setDisable(true);
	                        } catch (NoSuchFieldException | IllegalAccessException ex) {
	                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName2);
	                            ex.printStackTrace();
	                        }
	                    }
	                }//fin for
	                System.out.println("----------------------");//prueba
	                
	                //se habilitan cartas sin coincidir de la fila superior
	                for (int i = 0; i < Cartas.carta.length -4; i++) { // al bloquear una carta queda un campo de mas en el array
	                    if (Cartas.carta[i].getTemp() == 0) {
	                    	
	                        String cartaVariableNameN1 = "ptoFil1Carta" + (i + 1);
	           	            int prue = Cartas.carta[i].getTemp();//prueba
	        	            System.out.println("Se habilitan cartas superiores sin coincidir " + cartaVariableNameN1 +" valor temp es "+ + prue); //prueba

	                        try {
	                        	
	                            Field field1 = getClass().getDeclaredField(cartaVariableNameN1);
	                            field1.setAccessible(true);
	                            Node cartaNode1 = (Node) field1.get(this);
	                            cartaNode1.setDisable(false);
	                        	
	                        } catch (NoSuchFieldException | IllegalAccessException ex) {
	                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableNameN1);
	                            ex.printStackTrace();
	                        }
	                    }
	                }//fin for
	                System.out.println("----------------------");//prueba
	                
	                /*	    	      
	    	         * Se invoca el metodo bloqRadCar de la clase Cartas para obtener el valor 
	    	         * segun la carta superior seleccionada
	    	         */   		      
	    	       
	        		if (posic==0) {	        				        			
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C1, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C1, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C1, "rad3Car"); 
	                    
	        		}else if (posic==1) {	            		
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C2, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C2, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C2, "rad3Car");
	                    
	        		}else if (posic==2) {
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C3, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C3, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C3, "rad3Car");  
	         		}else if (posic==3) {
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C4, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C4, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C4, "rad3Car");  
	          		}
	                
	                }); // Hacer visible el nodo después de la pausa
	                pause.play();
	                
	            } 
	        }catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                e.printStackTrace();
            }
	    }
	
	    @FXML
	    void Fil2Carta4(MouseEvent event) {
	    	   			    	
	    	//Se asigna el valor a carta actual aleatorio del array resCartas
	        int varR4 = aleaCartas[3];
	        int nunCarta1 = resCartas[varR4];
	        
	        //Se almacena el valor de la carta actual en la posicion 7 de la lista carta
	        Cartas.carta[7].setVal(nunCarta1);
    		Cartas.carta[7].setTemp(1);
	        ptoFil2Carta4.setVisible(false);
	       	      
            //se deshabilitan cartas sin coincidir fila inferior
            for (int i = 4; i < Cartas.carta.length; i++) {
                if (Cartas.carta[i].getTemp() == 0) {
                    
    	            String cartaVariableName2 = "ptoFil2Carta" + (i - 3);
    	            int prue = Cartas.carta[i].getTemp();//prueba
    	            System.out.println("valor temp a bloquear: " + cartaVariableName2 +" es "+ + prue); //prueba

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
            System.out.println("----------------------");//prueba
	     
            /*
             * Se inicia verificacion de coincidencia
             */
	        int numeroBuscado = 1;
	        int posic = Cartas.buscarCartaSuperior(numeroBuscado);
	        int valCartaSup = Cartas.carta[posic].getVal();
	        
	        /*
	         * Valor de la carta superior se toma segun el radioButton seleccionado
	         * Se invoca el metodo obtenerValorRadCar de la clase Cartas para obtener el valor 
	         * segun la carta superior seleccionada
	         */   		      
	        int resul = 0;
	        if (posic==0) {
    			resul= Cartas.obtenerValorRadCar(btnsF1C1);
    			
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C1, "rad1Car");
                Cartas.bloqRadCar(btnsF1C1, "rad2Car");
                Cartas.bloqRadCar(btnsF1C1, "rad3Car"); 
                
    		}else if (posic==1) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C2);
        		
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C2, "rad1Car");
                Cartas.bloqRadCar(btnsF1C2, "rad2Car");
                Cartas.bloqRadCar(btnsF1C2, "rad3Car");
                
    		}else if (posic==2) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C3);
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C3, "rad1Car");
                Cartas.bloqRadCar(btnsF1C3, "rad2Car");
                Cartas.bloqRadCar(btnsF1C3, "rad3Car");  
     		}else if (posic==3) {
        		resul= Cartas.obtenerValorRadCar(btnsF1C4);
                //Se bloquean radioButton carta superior selecionada
                Cartas.bloqRadCar(btnsF1C4, "rad1Car");
                Cartas.bloqRadCar(btnsF1C4, "rad2Car");
                Cartas.bloqRadCar(btnsF1C4, "rad3Car");  
      		}

    		//Se obtiene la carta que se selecciono en la fila supeior y el vBox
	        String cartaVariableName = "ptoFil1Carta" + (posic + 1);
	        String cartaVboxColor = "vBox" + (posic + 1);
	        System.out.println("valor carta superior " + cartaVariableName +" es "+ valCartaSup + ", valor carta inferior : " + nunCarta1);//prueba	      
	        
	        
            try {
	        // Comparar el valor con el de la carta seleccionada en la fila superior
	        if (nunCarta1 == valCartaSup  && valCartaSup == resul) {
	        	
		        System.out.println("valor carta inferior y superior coinciden");//prueba
		        
		     // Se accede a los valores de la lista "puntos"
		        int acumtotal = Integer.parseInt (puntos.get(0)); // Obtener el valor de "Acumulado" de la lista
		        int ptosNivel = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        int ptosAvan = Integer.parseInt (puntos.get(2)); // Obtener el valor de "puntosnivel1" de la lista
		        		        
		        // Se incrementa puntos de nivel +10	    
		        ptosNivel += 10;
		        ptosAvan +=10;
		        System.out.println("valor carta inferior y superior coinciden puntos se suma 10 " + ptosNivel);//prueba
		        
		        // Se guardan en una variable a String
		        String ptosN1 = Integer.toString(ptosNivel);
		        String acumN1 = Integer.toString(acumtotal);		        
		        String avnzN1 = Integer.toString(ptosAvan);
		        
		        puntos.set(0, acumN1); // Actualizar el valor de "Acumulado" en la lista
		        puntos.set(1, ptosN1); // Actualizar el valor de "puntosnivel" en la lista
		        puntos.set(2, avnzN1); // Actualizar el valor de "puntosnivel" en la lista
		        
		        int ptosNivelpr = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        System.out.println("coinciden valor nuevo puntos de nivel " + ptosNivelpr);//prueba
		        
		        String ptoNiv1Str = (puntos.get(1));
	            puntosNivel1.setText(ptoNiv1Str);
	            totAcumulado.setText(ptoNiv1Str); // @@@ ojo en este nivel acumulado es el mismo valor de puntosNivel1


		    	 // Carta superior se tomo temporal como 2
	        	Cartas.carta[posic].setTemp(2);
		    	//Carta inferior se tomo temporal como 2
	    		Cartas.carta[7].setTemp(2); 
		    	//Sebloquea carta que coincide inferior
		        ptoFil2Carta4.setVisible(false);
		        ptoFil2Carta4.setDisable(true);
	            
		        /*
		         * Se bloquea carta que coincide Superior
		         */
                Field field = getClass().getDeclaredField(cartaVariableName);
                field.setAccessible(true);
                Node cartaNode = (Node) field.get(this);
                cartaNode.setVisible(true);
                cartaNode.setDisable(true);
                cartaNode.setOpacity(0.09);
                
                /*
                 * Cambio del color de la carta vBox
                 */
                //Se crea el color
                Color colorPersonalizado = Color.rgb(0, 126, 241);
                // se asigna el color carta inferior
				vBox8.setBackground(new Background(new BackgroundFill(colorPersonalizado, null, null)));

                //Se asigna el color carta superior
                Field fieldBox = getClass().getDeclaredField(cartaVboxColor);
                fieldBox.setAccessible(true);
                Node vBoxNode = (Node) fieldBox.get(this);
                ((Region) vBoxNode).setBackground(new Background(new BackgroundFill(colorPersonalizado, null, null)));

                
                //se habilitan cartas sin coincidir de la fila superior
                for (int i = 0; i < Cartas.carta.length -4; i++) {
                    if (Cartas.carta[i].getTemp() == 0) {
                    	
                        String cartaVariableNameN1 = "ptoFil1Carta" + (i + 1);
                      
        	            int prue = Cartas.carta[i].getTemp();//prueba
        	            System.out.println("valor coincide sup a b : " + cartaVariableNameN1 +" es "+ + prue); //prueba      	         
        	            
                        try {
                        	
                            Field field1 = getClass().getDeclaredField(cartaVariableNameN1);
                            field1.setAccessible(true);
                            Node cartaNode1 = (Node) field1.get(this);
                            cartaNode1.setDisable(false);
                        	
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableNameN1);
                            e.printStackTrace();
                        }
                    }
                }//fin for
                System.out.println("----------------------");//prueba
                
                //se deshabilitan cartas sin coincidir de la fila inferior
                for (int x = 4; x < Cartas.carta.length; x++) {
                    if (Cartas.carta[x].getTemp() == 0) {

                        String cartaVariableName2 = "ptoFil2Carta" + (x -3);
                        
        	            int prue = Cartas.carta[x].getTemp();//prueba
        	            System.out.println("Se bloquean cartas inferiores sin coincidir " + cartaVariableName2 +" y valor temp es "+ + prue); //prueba
        	            
                        try {
                            Field field2 = getClass().getDeclaredField(cartaVariableName2);
                            field2.setAccessible(true);
                            Node cartaNode2 = (Node) field2.get(this);
                            cartaNode2.setDisable(true);
                        } catch (NoSuchFieldException | IllegalAccessException ex) {
                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName2);
                            ex.printStackTrace();
                        }
                    }
                }//fin for
                System.out.println("----------------------");//prueba
                
                //Se habilita boton avanzar
            	ptosAvan = Integer.parseInt (puntos.get(2));
            	if (ptosAvan==40) {
            		alertaGeneral.showAlert("Nivel Alcanzado", "Puedes avanzar de nivel");
            		   btnAvanzar.setDisable(false);
            	}
                                
	            int prue = Cartas.carta[posic].getVal();
	            int prue2 = Cartas.carta[posic].getTemp();
	            System.out.println("valor carta verdadero : " + prue);
	            System.out.println("valor temp carta verdadero : " + prue2);
	            

	        } else {
	        	
		        System.out.println("valor carta inferior y superior no coinciden");//prueba	            

		     // Se decrementa puntos de nivel -10	    	    
		        int acumtotal = Integer.parseInt (puntos.get(0)); // Obtener el valor de "Acumulado" de la lista
		        int ptosNivel = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista

		        		        
		        // Se incrementa puntos de nivel +10	    
		        ptosNivel -= 10;
		        System.out.println("valor carta inferior y superior coinciden puntos se suma 10 " + ptosNivel);//prueba
		        
		        // Se guardan en una variable a String
		        String ptosN1 = Integer.toString(ptosNivel);
		        String acumN1 = Integer.toString(acumtotal);
		        
		        puntos.set(0, acumN1); // Actualizar el valor de "Acumulado" en la lista
		        puntos.set(1, ptosN1); // Actualizar el valor de "puntosnivel" en la lista
		        
		        int ptosNivelpr = Integer.parseInt (puntos.get(1)); // Obtener el valor de "puntosnivel1" de la lista
		        System.out.println("coinciden valor nuevo puntos de nivel " + ptosNivelpr);//prueba
		        
		        //Se asigna nuevo valor al label puntosNivel1
		        String ptoNiv1Str = (puntos.get(1));
	            puntosNivel1.setText(ptoNiv1Str);
	            totAcumulado.setText(ptoNiv1Str); // @@@ ojo en este nivel acumulado es el mismo valor de puntosNivel1
		        
	            Cartas.carta[posic].setTemp(0);
	    		Cartas.carta[7].setTemp(0);

	            // Obtener el nombre de la variable de la carta correspondiente
	                Field field = getClass().getDeclaredField(cartaVariableName);
	                field.setAccessible(true);
	                Node cartaNode = (Node) field.get(this);
	                
	                PauseTransition pause = new PauseTransition(Duration.seconds(5)); // Pausa de 2 segundos
	                pause.setOnFinished(e -> {
	                	
	                	cartaNode.setVisible(true); 
	                	ptoFil2Carta4.setVisible(true);
	                	
	                //se deshabilitan cartas sin coincidir de la fila inferior
	                for (int x = 4; x < Cartas.carta.length; x++) {
	                    if (Cartas.carta[x].getTemp() == 0) {

	                        String cartaVariableName2 = "ptoFil2Carta" + (x -3);
	                        
	        	            int prue = Cartas.carta[x].getTemp();//prueba
	        	            System.out.println("Se bloquean cartas inferiores sin coincidir " + cartaVariableName2 +" y valor temp es "+ + prue); //prueba
	        	            
	                        try {
	                            Field field2 = getClass().getDeclaredField(cartaVariableName2);
	                            field2.setAccessible(true);
	                            Node cartaNode2 = (Node) field2.get(this);
	                            cartaNode2.setDisable(true);
	                        } catch (NoSuchFieldException | IllegalAccessException ex) {
	                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName2);
	                            ex.printStackTrace();
	                        }
	                    }
	                }//fin for
	                System.out.println("----------------------");//prueba
	                
	                //se habilitan cartas sin coincidir de la fila superior
	                for (int i = 0; i < Cartas.carta.length -4; i++) { // al bloquear una carta queda un campo de mas en el array
	                    if (Cartas.carta[i].getTemp() == 0) {
	                    	
	                        String cartaVariableNameN1 = "ptoFil1Carta" + (i + 1);
	           	            int prue = Cartas.carta[i].getTemp();//prueba
	        	            System.out.println("Se habilitan cartas superiores sin coincidir " + cartaVariableNameN1 +" valor temp es "+ + prue); //prueba

	                        try {
	                        	
	                            Field field1 = getClass().getDeclaredField(cartaVariableNameN1);
	                            field1.setAccessible(true);
	                            Node cartaNode1 = (Node) field1.get(this);
	                            cartaNode1.setDisable(false);
	                        	
	                        } catch (NoSuchFieldException | IllegalAccessException ex) {
	                            System.out.println("No se pudo acceder al campo especificado: " + cartaVariableNameN1);
	                            ex.printStackTrace();
	                        }
	                    }
	                }//fin for
	                System.out.println("----------------------");//prueba
	                
	                /*	    	      
	    	         * Se invoca el metodo bloqRadCar de la clase Cartas para obtener el valor 
	    	         * segun la carta superior seleccionada
	    	         */   		      
	    	       
	        		if (posic==0) {	        				        			
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C1, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C1, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C1, "rad3Car"); 
	                    
	        		}else if (posic==1) {	            		
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C2, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C2, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C2, "rad3Car");
	                    
	        		}else if (posic==2) {
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C3, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C3, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C3, "rad3Car");  
	         		}else if (posic==3) {
	                    //Se bloquean radioButton carta superior selecionada
	                    Cartas.desbloqRadCar(btnsF1C4, "rad1Car");
	                    Cartas.desbloqRadCar(btnsF1C4, "rad2Car");
	                    Cartas.desbloqRadCar(btnsF1C4, "rad3Car");  
	          		}
	                
	                }); // Hacer visible el nodo después de la pausa
	                pause.play();
	                
	            } 
	        }catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println("No se pudo acceder al campo especificado: " + cartaVariableName);
                e.printStackTrace();
            }

	    }
	
	    @FXML
	    void btnAvanzar(ActionEvent event) throws IOException {
	    	int ptosAvan = Integer.parseInt (puntos.get(2));
	    	System.out.println("puntos alcanzado para avanzar " + ptosAvan );
	    	if (ptosAvan ==40) {
	    	
		    	System.out.println("Nivel alcanzado");

	    	}
	    	else {

	    		System.out.println("Nivel no alcanzado");
	    	}
            
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaNivel2.fxml"));
	    	Parent root = loader.load();
	    	Scene scene = new Scene(root);
	    	nivelActual1.setScene(scene);
	      	VistaNivel2Controller controller = loader.getController();
	    	controller.init(obtUsuario.getText(), labEdadn1.getText(), totAcumulado.getText(), nivelActual1, this);
	    	nivelActual1.show();
	    	

	    }
        

	public void init(String text, String text2, Stage bienve, VistaBienvenidaController vistaBienvenidaController) {
			
		this.nivelActual1 = bienve;
		this.obtUsuario.setText(text);
		this.labEdadn1.setText(text2);
		
		//Se deshabilita boton avanzar
    	btnAvanzar.setDisable(true);
		
        //Se accede a los valores de la lista "puntos"		
		String ptoNiv1Str = (puntos.get(1));
        puntosNivel1.setText(ptoNiv1Str);
        totAcumulado.setText(ptoNiv1Str);
        
    	//Se invoca metodo Crear cartas con la instancia creada de la clase Cartas
		actCarta.crearCartas(); 
		
		//valores operacion carta 1 fila 1
        int var1 = aleatorio[0];
        int var2 = aleatorio[1];
        int var3 = aleatorio[2];
        int num1 = resultado[0];
        int num2 = resultado[1];
        //int resul = resultado [4];
        int num3 = resultado[var1];
        int num4 = resultado[var2];
        int num5 = resultado[var3];
		
        //Encabezado carta 1 de la operacion
        labOpeC1.setText(num1 +" + " + num2 + " es:");    
        //Se invoca el metodo asignarValorRadCar de Cartas para asignar los valores de los radiobutton
        Cartas.asignarValorRadCar(btnsF1C1, "rad1Car", num3);
        Cartas.asignarValorRadCar(btnsF1C1, "rad2Car", num4);
        Cartas.asignarValorRadCar(btnsF1C1, "rad3Car", num5);
        
        
        //valores operacion carta 2 fila 1       
        int var11 = aleatorio1[0];
        int var12 = aleatorio1[1];
        int var13 = aleatorio1[2];
        int num11 = resultado1[0];
        int num12 = resultado1[1];
        //int resul1 = resultado1 [4];
        int num13 = resultado1[var11];
        int num14 = resultado1[var12];
        int num15 = resultado1[var13];
        
        //Encabezado carta 2 de la operacion		
        labOpeC2.setText(num11 +" + " + num12 + " es:");   
        //Se invoca el metodo asignarValorRadCar de Cartas para asignar los valores de los radiobutton
        Cartas.asignarValorRadCar(btnsF1C2, "rad1Car", num13);
        Cartas.asignarValorRadCar(btnsF1C2, "rad2Car", num14);
        Cartas.asignarValorRadCar(btnsF1C2, "rad3Car", num15);


        //valores operacion carta 3 fila 1
        
        int var21 = aleatorio2[0];
        int var22 = aleatorio2[1];
        int var23 = aleatorio2[2];
        int num21 = resultado2[0];
        int num22 = resultado2[1];
        //int resul2 = resultado2 [4];
        int num23 = resultado2[var21];
        int num24 = resultado2[var22];
        int num25 = resultado2[var23];
		
        //Encabezado carta 3 de la operacion
        labOpeC3.setText(num21 +" + " + num22 + " es:");
        //Se invoca el metodo asignarValorRadCar de Cartas para asignar los valores de los radiobutton
        Cartas.asignarValorRadCar(btnsF1C3, "rad1Car", num23);
        Cartas.asignarValorRadCar(btnsF1C3, "rad2Car", num24);
        Cartas.asignarValorRadCar(btnsF1C3, "rad3Car", num25);

        
        
        //valores operacion carta 4 fila 1
        
        int var31 = aleatorio3[0];
        int var32 = aleatorio3[1];
        int var33 = aleatorio3[2];
        int num31 = resultado3[0];
        int num32 = resultado3[1];
        //int resul3 = resultado3 [4];
        int num33 = resultado3[var31];
        int num34 = resultado3[var32];
        int num35 = resultado3[var33];
		
        //Encabezado carta 4 de la operacion
        labOpeC4.setText(num31 +" + " + num32 + " es:");
        //Se invoca el metodo asignarValorRadCar de Cartas para asignar los valores de los radiobutton
        Cartas.asignarValorRadCar(btnsF1C4, "rad1Car", num33);
        Cartas.asignarValorRadCar(btnsF1C4, "rad2Car", num34);
        Cartas.asignarValorRadCar(btnsF1C4, "rad3Car", num35);
        
        
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



	public void init(String text, String text2, Stage resultado4, VistaResultadoController vistaResultadoController) {
		this.nivelActual1 = resultado4;
		this.obtUsuario.setText(text);
		this.labEdadn1.setText(text2);
		
		//Se deshabilita boton avanzar
    	btnAvanzar.setDisable(true);
		
        //Se accede a los valores de la lista "puntos"		
		String ptoNiv1Str = (puntos.get(1));
        puntosNivel1.setText(ptoNiv1Str);
        totAcumulado.setText(ptoNiv1Str);
        
    	//Se invoca metodo Crear cartas con la instancia creada de la clase Cartas
		actCarta.crearCartas(); 
		
		//valores operacion carta 1 fila 1
        int var1 = aleatorio[0];
        int var2 = aleatorio[1];
        int var3 = aleatorio[2];
        int num1 = resultado[0];
        int num2 = resultado[1];
        //int resul = resultado [4];
        int num3 = resultado[var1];
        int num4 = resultado[var2];
        int num5 = resultado[var3];
		
        //Encabezado carta 1 de la operacion
        labOpeC1.setText(num1 +" + " + num2 + " es:");    
        //Se invoca el metodo asignarValorRadCar de Cartas para asignar los valores de los radiobutton
        Cartas.asignarValorRadCar(btnsF1C1, "rad1Car", num3);
        Cartas.asignarValorRadCar(btnsF1C1, "rad2Car", num4);
        Cartas.asignarValorRadCar(btnsF1C1, "rad3Car", num5);
        
        
        //valores operacion carta 2 fila 1       
        int var11 = aleatorio1[0];
        int var12 = aleatorio1[1];
        int var13 = aleatorio1[2];
        int num11 = resultado1[0];
        int num12 = resultado1[1];
        //int resul1 = resultado1 [4];
        int num13 = resultado1[var11];
        int num14 = resultado1[var12];
        int num15 = resultado1[var13];
        
        //Encabezado carta 2 de la operacion		
        labOpeC2.setText(num11 +" + " + num12 + " es:");   
        //Se invoca el metodo asignarValorRadCar de Cartas para asignar los valores de los radiobutton
        Cartas.asignarValorRadCar(btnsF1C2, "rad1Car", num13);
        Cartas.asignarValorRadCar(btnsF1C2, "rad2Car", num14);
        Cartas.asignarValorRadCar(btnsF1C2, "rad3Car", num15);


        //valores operacion carta 3 fila 1
        
        int var21 = aleatorio2[0];
        int var22 = aleatorio2[1];
        int var23 = aleatorio2[2];
        int num21 = resultado2[0];
        int num22 = resultado2[1];
        //int resul2 = resultado2 [4];
        int num23 = resultado2[var21];
        int num24 = resultado2[var22];
        int num25 = resultado2[var23];
		
        //Encabezado carta 3 de la operacion
        labOpeC3.setText(num21 +" + " + num22 + " es:");
        //Se invoca el metodo asignarValorRadCar de Cartas para asignar los valores de los radiobutton
        Cartas.asignarValorRadCar(btnsF1C3, "rad1Car", num23);
        Cartas.asignarValorRadCar(btnsF1C3, "rad2Car", num24);
        Cartas.asignarValorRadCar(btnsF1C3, "rad3Car", num25);

        
        
        //valores operacion carta 4 fila 1
        
        int var31 = aleatorio3[0];
        int var32 = aleatorio3[1];
        int var33 = aleatorio3[2];
        int num31 = resultado3[0];
        int num32 = resultado3[1];
        //int resul3 = resultado3 [4];
        int num33 = resultado3[var31];
        int num34 = resultado3[var32];
        int num35 = resultado3[var33];
		
        //Encabezado carta 4 de la operacion
        labOpeC4.setText(num31 +" + " + num32 + " es:");
        //Se invoca el metodo asignarValorRadCar de Cartas para asignar los valores de los radiobutton
        Cartas.asignarValorRadCar(btnsF1C4, "rad1Car", num33);
        Cartas.asignarValorRadCar(btnsF1C4, "rad2Car", num34);
        Cartas.asignarValorRadCar(btnsF1C4, "rad3Car", num35);
        
        
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
