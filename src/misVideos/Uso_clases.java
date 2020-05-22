package misVideos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Uso_clases {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		boolean endSession = false;
		Scanner entradas = new Scanner(System.in);
		
		do {
			
		
			int respuestaInicial = preguntaDeEntrada(entradas);
		

			if(respuestaInicial != 1  && respuestaInicial !=2  && respuestaInicial != 3) {
				
				System.out.println("Enter a number in between 1 and 3 to make your selection");
				System.out.println("");
				endSession=true;
			
			} else {
				switch(respuestaInicial) {
					case 1:
						System.out.println("Register for new user"); 
						
						endSession=false;
						break;
					case 2:
						System.out.println("Log in a new user");
						endSession=false;
						break;
					case 3:
						System.out.println("Exit the aplication");
						endSession=true;
						break;
					default:
						endSession=true;
						break;
				}
			}
				

			
		}while(endSession);
			
	}
	
	public static int preguntaDeEntrada(Scanner entradas){
		
		boolean numeroIncorrecto=false;
		System.out.println("Welcome to our video app");
		int respuesta=0;
		do {
		
        try{

    		System.out.println("Tell me what do you want to do");
    		System.out.println("Write down an integer, if you writte other than an integer you will be promted the exception and the questions again. ");
    		System.out.println("1. Register");
    		System.out.println("2. Login");
    		System.out.println("3. Exit");
    		respuesta= Integer.parseInt(entradas.nextLine());
        	System.out.println("El numero decimal escrito ha sido "+respuesta);

        	numeroIncorrecto=false;
            
        }catch(NumberFormatException e){
        	 
             System.out.println("Error, the value you introduced is not correct. Please enter an integer to the console");
             numeroIncorrecto=true;
        }
		}while(numeroIncorrecto==true);
		
		return respuesta;
	}
	
	


}

