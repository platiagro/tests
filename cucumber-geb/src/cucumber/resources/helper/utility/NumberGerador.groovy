package helper.utility

import java.util.Random

public class NumberGerador {
	
	public static String number() {
               
        Random generator = new Random();

        String a = (char) (generator.nextInt(25) + 65);
        String b = (char) (generator.nextInt(25) + 65);
        String c = (char) (generator.nextInt(25) + 65);
        String n = generator.nextInt(9999);

        return a + b + c + n;
	}
}