package application;

import java.util.Random;

public class Operacion {
	
    public static int[] suma() {
        Random random = new Random();
        int num1 = random.nextInt(6) + 4;  // Genera un número aleatorio entre 1 y 9
        int num2 = random.nextInt(4) + 1;  // Genera un número aleatorio entre 1 y 9
		int num3 = random.nextInt(5) + num1 + 1;
		int num4 = random.nextInt(3) + num2 + 1;
        int num5 = num1 + num2;
        if (num3==num5) {
        	num3+=1;
        	}
        if (num4==num3) {
        	num4+=1;
        	}
        
        int[] numeros = {num1, num2, num3, num4, num5};
        return numeros;
    }
    
    public static int [] aleatorio () {
        int cantidadNumeros = 3; // Cantidad de números aleatorios a generar

        int[] numeros = new int[cantidadNumeros];
        Random random = new Random();

        // Llenar el arreglo con los números del 1 al 3
        for (int i = 0; i < cantidadNumeros; i++) {
            numeros[i] = i+2;
        }

        // Mezclar los elementos del arreglo de forma aleatoria
        for (int i = cantidadNumeros - 1; i > 0; i--) {
            int indiceAleatorio = random.nextInt(i + 1);
            int temp = numeros[i];
            numeros[i] = numeros[indiceAleatorio];
            numeros[indiceAleatorio] = temp;
        }

        // Asignar los números generados a variables individuales
		return numeros;
    }
    
    
    public static int [] aleatorio2 () {
        int cantidadNumeros = 4; // Cantidad de números aleatorios a generar

        int[] numeros = new int[cantidadNumeros];
        Random random = new Random();

        // Llenar el arreglo con los números del 1 al 4
        for (int i = 0; i < cantidadNumeros; i++) {
            numeros[i] = i;
        }

        // Mezclar los elementos del arreglo de forma aleatoria
        for (int i = cantidadNumeros - 1; i > 0; i--) {
            int indiceAleatorio = random.nextInt(i + 1);
            int temp = numeros[i];
            numeros[i] = numeros[indiceAleatorio];
            numeros[indiceAleatorio] = temp;
        }

        // Asignar los números generados a variables individuales
		return numeros;
    }
		
}
