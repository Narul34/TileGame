package tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Ensemble de fonctions utiles au programme

public class Utils {

	// Fonction chargeant un fichier en "String"
	public static String loadFileAsString(String path) {
		
		// Objet particulier fonctionnant comme String
		
		StringBuilder builder = new StringBuilder();
		
		
		try{
			// on stock le fichier dans un buffer
			
			BufferedReader br = new BufferedReader (new FileReader(path));
			String line;
			
			// tant que la ligne n'est pas nulle, on ajoute au builder son contenu puis un retour à la ligne
			
			while((line = br.readLine()) != null){
				builder.append(line +"\n");
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//on renvoi le contenu du builde en String
		
		return builder.toString();
	}
	
	// fonction convertissant les String en int
	
	public static int parseInt(String number) {
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
}
