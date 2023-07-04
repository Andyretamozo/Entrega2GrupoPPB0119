package application;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;


public class Cartas {
	
	    private int val;
	    private int temp;
	    private boolean vis;
	    private boolean bloq;
	    

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
		
		

	//Creacion y propiedades del array		
	public static Cartas [] carta =  new Cartas[8];
	public void  crearCartas () {
		
        for (int i = 0; i < carta.length-4; i++) {
            carta[i] = new Cartas();
            carta[i].setVal(0);
            carta[i].setTemp(0);
            carta[i].setVis(false);
            carta[i].setBloq(false);

        }
        for (int i = 4; i < carta.length; i++) {
            carta[i] = new Cartas();
            carta[i].setVal(0);
            carta[i].setTemp(0);
            carta[i].setVis(false);
            carta[i].setBloq(true);

        }        		
	}
	
	//Metodo para buscar la posicion de la carta superior seleccionada dentro del array
    public static int buscarCartaSuperior(int x) {
        for (int i = 0; i < carta.length; i++) {
            if (carta[i].getTemp() == x) {
                return i;
            }
        }
        return 0; 
    }
    
   
    
    //Metodo para asignar el valor a los radioButton de cada carta
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
    
    //Metodo bloquea los radioButton de la carta superior seleccionada 
    public static void bloqRadCar(ToggleGroup grupo, String rad) {
		for (Toggle selbtnsF1C : grupo.getToggles()) {
			if (selbtnsF1C instanceof RadioButton &&((RadioButton) selbtnsF1C).getId().equals(rad)) {
			    RadioButton selRadBtn = (RadioButton) selbtnsF1C;
			    selRadBtn.setDisable(true);
			    String valorSeleccionado = selRadBtn.getText();
			    //resul= Integer.parseInt(valorSeleccionado);
			    System.out.println("Valor seleccionado: " + valorSeleccionado);
			}
		}
    } 
    
    //Metodo desbloquea los radioButton si al seleccionar carta superior e inferior no coinciden
    public static void desbloqRadCar(ToggleGroup grupo, String rad) {
		for (Toggle selbtnsF1C : grupo.getToggles()) {
			if (selbtnsF1C instanceof RadioButton &&((RadioButton) selbtnsF1C).getId().equals(rad)) {
			    RadioButton selRadBtn = (RadioButton) selbtnsF1C;
			    selRadBtn.setDisable(false);
			    String valorSeleccionado = selRadBtn.getText();
			    //resul= Integer.parseInt(valorSeleccionado);
			    System.out.println("Valor seleccionado: " + valorSeleccionado);
			}
		}
    }
                     
    //Metodo utilizado para obtener el dato o valor de los radioButton
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
    
    /*
    //Metodo bloquea las cartas diferentes a la seleccionada
    public void bloqCarSup(int valTemp) {
	//Se bloquean cartas diferentes a actual
    for ( int i = 0; i < Cartas.carta.length-4; i++) {
        if (Cartas.carta[i].getTemp() == valTemp) {

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
    
    }*/


}
