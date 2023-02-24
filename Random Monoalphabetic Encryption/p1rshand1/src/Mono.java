package src;
import java.util.*;
import java.io.*;

public class Mono {
    public static void main(String[] args) throws FileNotFoundException {
		File inFile = new File(args[0]);
		System.out.println(args.length);
		//File inFile = new File("src/"+args[1]);
		Scanner scanner = new Scanner(inFile);
		String inputString = scanner.next();
		int seed = Integer.parseInt(args[2]);
		int encrypt_decrypt = Integer.parseInt(args[3]);
		Mappings m = new Mappings(seed, encrypt_decrypt);
		File output =  new File(args[1]);
		//File output =  new File("src/"+args[2]);
		for(Map.Entry<Character, Character> keyVal : m.getMap().entrySet()) {
			System.out.print(keyVal.getKey() + "-" + keyVal.getValue() + ", ");
		}
		System.out.print("\n");
		try {
	   		FileWriter f = new FileWriter(output);
	    	PrintWriter p = new PrintWriter(f);
			for(int i = 0; i < inputString.length(); i++) {
				p.print(m.getMap().get(inputString.charAt(i)));
			}
	    	p.close();
	    	f.close();
	    	//System.out.println("Successfully wrote output file");
		}
		catch(IOException e) {
	    	System.out.println("IO ERROR");
		}
    }
}
