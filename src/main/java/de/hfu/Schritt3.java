import java.util.*;
public class Schritt3{
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