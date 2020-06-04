package de.hfu;
import java.util.*;
public class Schritt3{
	/**
	 *Dieses Programm ändert Klein in Großbuchstaben um. 
	 *Leider funktioniert es nur mit einem String, daher is die if Bediengung unnötig.
	 *Ein dritter Kommentar!
	 */
	public static void main(String[] args) {
		System.out.println("Bitte Wort zum umwandeln eingeben: \n");
		Scanner scanner=new Scanner(System.in);
		String input = scanner.next();	
		for(int i=0;i<input.length();i++){
			char c=input.charAt(i);
			if(Character.isWhitespace(c))
				System.out.println(" ");
			else			
			System.out.println(Character.toUpperCase(c));		
		}
	}
}