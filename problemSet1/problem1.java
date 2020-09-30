package problemSet1;

import java.util.Random;
import java.awt.geom.Point2D;

public class problem1 {
	
	public static double[][] generateCoords(int numCoords) {
		
		Random rand = new Random();
		double[][] myCoords = new double[numCoords][2];
		double x;
		double y;
		
		for (int i = 0; i < numCoords; i++) {
			x = rand.nextFloat();
			y = rand.nextFloat();
			
			myCoords[i][0] = x;
			myCoords[i][1] = y;
		}
		return myCoords;
	}
	
	public static double calculateDistance(double[][] coords) {
		double resultH = 1;

		for(int i = 0; i < coords.length-1; i++) {
			for (int j = coords.length-1; j >= 0; j--) {
				if (i == j)
					break;
				double result = Point2D.distance(coords[i][0], coords[i][1], coords[j][0], coords[j][1]);
				if (result < resultH) {
					resultH = result;
				}
			}
		}
		return resultH;
	}
	
	public static void Point2D(double x, double y) {}
	
	public static void main(String[] args) {	
		int input = Integer.parseInt(args[0]);
		
		double[][] coords = generateCoords(input);
		System.out.println(calculateDistance(coords));
		
		}
	}




