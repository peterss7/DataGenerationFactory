package creation.product;

import java.util.Random;

public class PriceGenerator {
	
	public static double generatePrice() {
		
		Random rand = new Random();
		double[] prices = new double[3];
		prices[0] = rand.nextInt(10000,100000) / rand.nextInt(1, 5);
		prices[1] = rand.nextInt(1000,10000) / rand.nextInt(1, 4);
		prices[2] = rand.nextInt(100,1000) / rand.nextInt(1, 2);
		
		double decimal = rand.nextInt(100);
		
		return (prices[rand.nextInt(0,3)]  + (decimal / 100.00) + .01);
		
	}

}
