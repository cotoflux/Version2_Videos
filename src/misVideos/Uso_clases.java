package misVideos;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Uso_clases {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		User administrador = new User("a", "a", "a", "a");
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
						System.out.println("Register for new user____________________________________________________________________"); 
						createUser(entradas, users);
						System.out.println("You have been correctly registered! Welcome!!");
						endSession=true;
						break;
					
					case 2:
						System.out.println("Un registrer a user______________________________________________________________________");
						unRegisterOneUser(entradas, users); 
						System.out.println("Pitty that you unregister. Remember you will welcome back any time");
						endSession= true;
						break;
					case 3:
						System.out.println("Log in to the application:_______________________________________________________________");
						
							User user = logInUser(entradas, users);						
							if(user != null) {
							
							do {
								
								int videoResponse = videoQuestionsToUser(entradas);
								
								switch(videoResponse){
									case 1:
										System.out.println("Create a new video:______________________________________________________ ");
										createAVideo(entradas, user);
										endVideo=true;
										break;
									case 2:
										System.out.println("I want to see all my videos:______________________________________________ ");
										seeAllVideosForUser(entradas, user);
										endVideo=true;
										break;
									case 3:
										System.out.println("I want to exit now");
										endVideo=false;
										break;
									default:
										System.out.println("We do not have this option. Thank you to enter a valid option");
										endVideo=true;
										break;
								}
								
							} while(endVideo);
						}
						endSession=true;
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

        	menuPrincipal();

    		respuesta= Integer.parseInt(entradas.next());
        	numeroIncorrecto=false;
            
        }catch(NumberFormatException e){
             System.out.println("Error, the value you introduced is not correct. Please remember to introduce a valid integer to the console");
             numeroIncorrecto=true;
        }
		}while(numeroIncorrecto==true);
		
		return respuesta;
	}
	
	private static void menuPrincipal() {
		System.out.println("======================================================================================================================");
		System.out.println("Welcome, to start using the aplication write down an valid integer, from the options below: ");
		System.out.println("1. Register");
		System.out.println("2. Unregister");
		System.out.println("3. Login");
		System.out.println("4. Exit");
		System.out.println("======================================================================================================================");
	}

	public static String requestNewUserName(Scanner entradas) {

		System.out.println("Type your name");
		String nameRegistered= entradas.next();
		return nameRegistered;
		
	}
	
	public static String requestNewUserSurname(Scanner entradas) {
		
		System.out.println("Type your surname");
		String surnameRegistered= entradas.next();
		return surnameRegistered;
		
	}
	
	public static String requestNewUserUserName(Scanner entradas) {
		

		System.out.println("Type your user name");
		String userNameRegistered= entradas.next();
		return userNameRegistered;
	}

	public static String requestNewUserPassword(Scanner entradas) {
		

		System.out.println("Type your password");
		String passwordRegistered= entradas.next();
		return passwordRegistered;
	}
	
	public static void createUser(Scanner entradas, List<User> users) {
		
		String name= requestNewUserName(entradas);
		String surname = requestNewUserSurname(entradas);
		String userName = requestNewUserUserName(entradas);
		String password = requestNewUserPassword(entradas);
        Calendar dateRegister = GregorianCalendar.getInstance();

        System.out.println("Fecha actual: "+dateRegister.getTime());
				
		User newUsers = new User(name, surname, userName, password, dateRegister);
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
	
	public static User logInUser(Scanner entradas, List<User> users) {
	
		String userNameRegister = requestNewUserUserName(entradas);
		String passwordRegister = requestNewUserPassword(entradas);
		System.out.println(" ");
		User user1  = null;
		

		for(User user: users) {

			if(user.getUserName().equals(userNameRegister) && user.getPassword().equals(passwordRegister)) {
				user1 = user;
			}
		}
		return user1;

	}
	
	public static int videoQuestionsToUser(Scanner entradas) {
		int respuesta=0;
		boolean numeroIncorrecto=false;
		
	        try{
	        	System.out.println("**********************************************************************************************************************");
	    		System.out.println("Tell me what you want to do, insert a number from 1 to 3");
	    		System.out.println("1. Register a new Video");
	    		System.out.println("2. See my videos");
	    		System.out.println("3. Exit");
	    		System.out.println("**********************************************************************************************************************");
	    		respuesta= Integer.parseInt(entradas.next());
	
	        	numeroIncorrecto=false;
	            
	        }catch(NumberFormatException e){
	        	 
	             System.out.println("Error, the value you introduced is not correct. Please enter an integer to the console");
	             numeroIncorrecto=true;
	        } while(numeroIncorrecto==true);
		
		
		return respuesta;
	}
	
	public static String enterUrl(Scanner entradas) {
		System.out.println("Type the url of the video: ");
		String urlEntered = entradas.next();
		return urlEntered;
	}
	
	public static String enterTitle(Scanner entradas) {
		System.out.println("Type the title: ");
		String titleEntered = entradas.next();
		return titleEntered;
	}
	
	public static int enterNumberOfTaggs(Scanner entradas) {
		System.out.println("Tell me how many tags do you want to enter");
		int numberOfTags = entradas.nextInt();
		return numberOfTags;
	}
	
	public static String enterTags(Scanner entradas) {
		System.out.println("Type one tag: ");
		String taggEntered = entradas.next();
		return taggEntered;

	}
	
	public static void createAVideo(Scanner entradas, User user) {
		
		
		String userName = user.getUserName();
		String url=enterUrl(entradas);
		String title=enterTitle(entradas);
		Video creaUnVideo = new Video(userName, url, title);
		user.addVideoToUser(creaUnVideo);
		
		try{
			int numberTaggs = enterNumberOfTaggs(entradas);
			for(int i=0; i<numberTaggs; i++ ) {
				System.out.println("Entra el tag");
				String entrada = entradas.next();
				creaUnVideo.addTagg(entrada);
			}
			
			System.out.println(creaUnVideo.getListaTaggs());
			System.out.println("El v�deo se ha creado correctamente");
			
		}catch(Exception e) {
			System.out.println("//////////////////////////////////////  ERROR INFORMATION  /////////////////////////////////////////////");
			System.out.println("Error, we have not been able to do your request as you dit not enter a integer number for the Number of Taggs");
			System.out.println("//////////////////////////////////////  ERROR INFORMATION  /////////////////////////////////////////////");
		}
		
	}
	
	private static void seeAllVideosForUser(Scanner entradas, User user) {
		
		System.out.println(user.getListVideosForUser());
		String name= user.getName();
		String surname = user.getSurname();
		String userName = user.getUserName();
		String password = user.getPassword();
		System.out.println("Entra el usuario");
		String entrada = entradas.next();
		User listaDelUsuario = new User(name, surname, userName, password);
		if(listaDelUsuario.getUserName().equals(entrada)){
			System.out.println("Es igual");
			System.out.println(listaDelUsuario.getListVideosForUser());
		} else {
			System.out.println("No es igual");
		}
		
		
	}
	

}

