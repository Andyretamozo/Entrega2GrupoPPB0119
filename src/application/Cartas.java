package application;

import java.lang.reflect.Field;

import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class Cartas {
	
	    private int val;
	    private int temp;
	    private boolean vis;
	    private boolean bloq;
	    private int toFront;
	    

		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		
		public int getTemp() {
			return temp;
		}
		public void setTemp(int temp) {
			this.temp = temp;
		}
		
		public boolean isVis() {
			return vis;
		}
		public void setVis(boolean vis) {
			this.vis = vis;
		}
		public boolean isBloq() {
			return bloq;
		}
		public void setBloq(boolean bloq) {
			this.bloq = bloq;
		}
		
		public int getToFront() {
			return toFront;
		}
		public void setToFront(int toFront) {
			this.toFront = toFront;
		}
		

			
	public static Cartas [] carta =  new Cartas[8];
	public void  crearCartas () {
		
        for (int i = 0; i < carta.length; i++) {
            carta[i] = new Cartas();
            carta[i].setVal(0);
            carta[i].setTemp(0);
            carta[i].setVis(false);
            carta[i].setBloq(false);
            carta[i].setToFront(95);
        }
        
		
	}
	
    public static int buscarCartaSuperior(int x) {
        for (int i = 0; i < carta.length; i++) {
            if (carta[i].getTemp() == x) {
                return i;
            }
        }
        return 0; 
    }
    
    
    public static void desbCarta(int x) {
        for (int i = 0; i < carta.length; i++) {
            if (carta[i].getTemp() == x) { // Cambio en la condición de igualdad
                carta[i].setBloq(false);

            }
        }
    }
    
    public void obtenerTresVariables(int puntos) {
    for (int x = puntos; x < Cartas.carta.length-1; x++) {
        if (Cartas.carta[x].getTemp() == 0) {

            String cartaVariableName2 = "ptoFil2Carta" + (x -2);
            
            int prue = Cartas.carta[x].getTemp();//prueba
            System.out.println("valor temp : " + cartaVariableName2 +" es "+ + prue); //prueba
            
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
    
    }
    
    
    public static void asignarValorRadCar(ToggleGroup grupo,String rad, int valor) {
        for (Toggle toggle : grupo.getToggles()) {
            if (toggle instanceof RadioButton &&((RadioButton) toggle).getId().equals(rad))  {
                RadioButton radioButton = (RadioButton) toggle;
                radioButton.setText(String.valueOf(valor));
                System.out.println("valores de radio " + valor);
                break;
            }
        }
    }
    
    public static int obtenerValorRadCar(ToggleGroup grupo) {
    int resul= 0;
	Toggle selbtnsF1C = grupo.getSelectedToggle();
	if (selbtnsF1C instanceof RadioButton) {
	    RadioButton selRadBtn = (RadioButton) selbtnsF1C;
	    String valorSeleccionado = selRadBtn.getText();
	    resul= Integer.parseInt(valorSeleccionado);
	    System.out.println("Valor seleccionado: " + valorSeleccionado);
	}
	return resul;
    }
    



}
