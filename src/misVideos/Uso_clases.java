package misVideos;

import java.awt.Component;
import java.awt.Container;
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
		List<Tagg> myTaggs = new ArrayList<Tagg>();
		User administrador = new User("Admin", "Super", "admin","admin123");
		users.add(administrador);
		boolean endSession = false;
		boolean endVideo = false;
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
						System.out.println("Log in to the application");
						logInUser(entradas, users);
						
							do {
								
								int videoResponse = videoQuestionsToUser(entradas);
								
								switch(videoResponse){
									case 1:
										System.out.println("Create a new video: ");
										createAVideo(entradas);
										endVideo=false;
										break;
									case 2:
										System.out.println("I want to see all my videos: ");
										endVideo=false;
										break;
									case 3:
										System.out.println("I want to exit now");
										endVideo=true;
										break;
									default:
										System.out.println("We do not have this option. Thank you to enter a valid option");
										endVideo=true;
										break;
								}
								
							}while(endVideo);
							
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
		int value=-1;
		String nameToUnregister= requestNewUserName(entradas);
		String surnameToUnregister = requestNewUserSurname(entradas);
		String userNameToUnregister = requestNewUserUserName(entradas);
		String passwordToUnregister = requestNewUserPassword(entradas);
		System.out.println(" ");
		
		User userToUnregister = new User(nameToUnregister, surnameToUnregister, userNameToUnregister, passwordToUnregister);
				
		for(User user : users){

			if(user.equals(userToUnregister)){
				value= users.indexOf(userToUnregister);
				System.out.println("Found, we are proceeding to delte your account");
			} 
		}
		
		users.remove(value);
		System.out.println(" ");
		
	}
	
	public static void logInUser(Scanner entradas, List<User> users) {
		String nameToUnregister= requestNewUserName(entradas);
		String surnameToUnregister = requestNewUserSurname(entradas);
		String userNameRegister = requestNewUserUserName(entradas);
		String passwordRegister = requestNewUserPassword(entradas);
		System.out.println(" ");
		
		User usersRegistered = new User(nameToUnregister, surnameToUnregister, userNameRegister, passwordRegister);
		/*
		for(int i=0; i<users.size(); i++) {
			System.out.println(users.get(i));
		}*/
		for(User user: users) {
			System.out.print(usersRegistered);
			if(user.equals(usersRegistered)) {
				System.out.println(". Estas correctamente registrado");
			} else {
				System.out.println(". No te has logeado correctamente");
				
			}
		}
	}
	
	public static int videoQuestionsToUser(Scanner entradas) {
		int respuesta=0;
		boolean numeroIncorrecto=false;
		
	        try{
	
	    		System.out.println("Tell me what you want to do, insert a number from 1 to 3");
	    		System.out.println("1. Register a new Video");
	    		System.out.println("2. See my videos");
	    		System.out.println("3. Exit");
	    		respuesta= Integer.parseInt(entradas.nextLine());
	
	        	numeroIncorrecto=false;
	            
	        }catch(NumberFormatException e){
	        	 
	             System.out.println("Error, the value you introduced is not correct. Please enter an integer to the console");
	             numeroIncorrecto=true;
	        } while(numeroIncorrecto==true);
		
		
		return respuesta;
	}
	
	public static String enterUrl(Scanner entradas) {
		System.out.println("Type the url of the video: ");
		String urlEntered = entradas.nextLine();
		return urlEntered;
	}
	
	public static String enterTitle(Scanner entradas) {
		System.out.println("Type the title: ");
		String titleEntered = entradas.nextLine();
		return titleEntered;
	}
	
	public static int enterNumberOfTaggs(Scanner entradas) {
		System.out.println("Tell me how many tags do you want to enter");
		int numberOfTags = entradas.nextInt();
		return numberOfTags;
	}
	
	public static String enterTags(Scanner entradas) {
		System.out.println("Type one tag: ");
		String taggEntered = entradas.nextLine();
		return taggEntered;
	}
	
	public static void createAVideo(Scanner entradas) {
		String url=enterUrl(entradas);
		String title=enterTitle(entradas);
		int numberTaggs = enterNumberOfTaggs(entradas);
		List<String> myTaggs = new ArrayList<String>();
		for(int i=0; i<numberTaggs; i++ ) {
			System.out.println("Entra el tag");
			myTaggs.add(entradas.next());
		}
		
		for(int j=0; j<numberTaggs; j++) {
			System.out.println(myTaggs.get(j));
		}
	}
}

