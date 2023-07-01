package application;

import java.lang.reflect.Field;

import javafx.scene.Node;

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
    
   /*
    
    public void obtenerTresVariables(String nombre1, String nombre2, String nombre3) {
    	
    	
        try {
            Field field1 = getClass().getDeclaredField(nombre1);
            field1.setAccessible(true);
            Node variable1 = (Node) field1.get(this);
            variable1.setVisible(true);
            
            Field field2 = getClass().getDeclaredField(nombre2);
            field2.setAccessible(true);
            Node variable2 = (Node) field2.get(this);
            variable2.setVisible(true);
            
            Field field3 = getClass().getDeclaredField(nombre3);
            field3.setAccessible(true);
            Node variable3 = (Node) field3.get(this);
            variable3.setVisible(true);
            
            // Puedes realizar otras operaciones con las variables obtenidas
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("No se pudo acceder al campo especificado.");
            e.printStackTrace();
        }
    }
    
    
    
    public  void desableCartas(int r) {

        for (int i = 0; i < carta.length; i++) {
            if (carta[i].getTemp() == r) {
                carta[i].setBloq(true);
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
        }
        


    	}*/









    	



}
