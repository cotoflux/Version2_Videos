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
		User administrador = new User("Amin", "Super", "admin","admin123");
		users.add(administrador);
		boolean endSession = false;
		Scanner entradas = new Scanner(System.in);
		
		do {
			
		
			int respuestaInicial = preguntaDeEntrada(entradas);
		

			if(respuestaInicial != 1  && respuestaInicial !=2  && respuestaInicial != 3 && respuestaInicial != 4) {
				
				System.out.println("Enter a number in between 1 and 4 to make your selection");
				System.out.println("");
				endSession=true;
			
			} else {
				switch(respuestaInicial) {
					case 1:
						System.out.println("Register for new user"); 
						createUser(entradas, users);
						System.out.println("Estas correctamente registrado");
						System.out.println(users.toString());
						endSession=true;
						break;
					
					case 2:
						System.out.println("Un registrer a user");
						unRegisterOneUser(entradas, users); 
						System.out.println("Pitty that you unregister. Remember you will welcome back any time");
						endSession= true;
						break;
					case 3:
						System.out.println("Log in a new user");
						endSession=false;
						break;
					case 4:
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
    		System.out.println("2. Unregister");
    		System.out.println("3. Login");
    		System.out.println("4. Exit");
    		respuesta= Integer.parseInt(entradas.nextLine());
        	System.out.println("The number written in the console is: "+respuesta);

        	numeroIncorrecto=false;
            
        }catch(NumberFormatException e){
        	 
             System.out.println("Error, the value you introduced is not correct. Please enter an integer to the console");
             numeroIncorrecto=true;
        }
		}while(numeroIncorrecto==true);
		
		return respuesta;
	}
	
	public static String requestNewUserName(Scanner entradas) {

		System.out.println("Type your name");
		String nameRegistered= entradas.nextLine();
		return nameRegistered;
		
	}
	
	public static String requestNewUserSurname(Scanner entradas) {
		
		System.out.println("Type your surname");
		String surnameRegistered= entradas.nextLine();
		return surnameRegistered;
		
	}
	
	public static String requestNewUserUserName(Scanner entradas) {
		

		System.out.println("Type your user name");
		String userNameRegistered= entradas.nextLine();
		return userNameRegistered;
	}

	public static String requestNewUserPassword(Scanner entradas) {
		

		System.out.println("Type your password");
		String passwordRegistered= entradas.nextLine();
		return passwordRegistered;
	}
	
	public static void createUser(Scanner entradas, List<User> users) {
		
		String name= requestNewUserName(entradas);
		String surname = requestNewUserSurname(entradas);
		String userName = requestNewUserUserName(entradas);
		String password = requestNewUserPassword(entradas);
				
		User newUsers = new User(name, surname, userName, password);
		users.add(newUsers);
	}
	
	public static void unRegisterOneUser(Scanner entradas, List<User> users) {
		String nameToUnregister= requestNewUserName(entradas);
		String surnameToUnregister = requestNewUserSurname(entradas);
		String userNameToUnregister = requestNewUserUserName(entradas);
		String passwordToUnregister = requestNewUserPassword(entradas);
		
		
		
		for(int i=0; i<users.size(); i++) {

			System.out.println(users.get(i)); 
		}
		
		
		for(User user : users){
			if(user.equals(nameToUnregister) && user.equals(surnameToUnregister) && user.equals(userNameToUnregister) && user.equals(passwordToUnregister)){
				System.out.println("Encontrado");
			} else {
				System.out.println("No encontrado");
			}
		}
		/*
		if(users.equals(nameToUnregister) && users.equals(surnameToUnregister) && users.equals(userNameToUnregister) && users.equals(passwordToUnregister) ){
			System.out.println("You have been unregistered");
		} else {
			System.out.println("We have not found this user please check your values");
	}*/

	}
}

