package src;
import java.util.*;
import java.io.*;
import java.lang.Math;

public class Mappings {
    private HashMap<Character, Character> map;
    private int seed;
    private Random rand;
    private int encrypt_decrypt;

    public Mappings(int seed, int encrypt_decrypt) {
        this.seed = seed;
        this.encrypt_decrypt = encrypt_decrypt;
        this.rand = new Random(seed);
        this.map = new HashMap<>();
        this.createMap(seed);
    }

    public void createMap(int seed) {
        List<Character> used = new ArrayList<Character>(26);
        for(int i = 97; i < 123; i++) {
            char mapFrom = (char)i;
            int randomIntFromSeed = this.rand.nextInt();
            char mapTo = (char) (97 + (Math.abs(randomIntFromSeed) % 26));
            //System.out.print((97 + (Math.abs(randomIntFromSeed)% 26))+ " ");   
            while(used.contains(mapTo)) {
                randomIntFromSeed = this.rand.nextInt();
                //System.out.print((97 + (Math.abs(randomIntFromSeed) % 26))+ " ");
                mapTo = (char) (97 + (Math.abs(randomIntFromSeed) % 26));
            }
            used.add(mapTo);
            map.put(mapFrom, mapTo); 
        }
        //decrypt, swap keys and values
        if(this.encrypt_decrypt == 0) {
            HashMap<Character, Character> reverseMap = new HashMap<>();
            for(Map.Entry<Character, Character> keyVal : this.map.entrySet()) {
			    reverseMap.put(keyVal.getValue(), keyVal.getKey());
		    }
            this.map = reverseMap;
        }
    }

    public HashMap<Character, Character> getMap() {
        return this.map;
    }
}
