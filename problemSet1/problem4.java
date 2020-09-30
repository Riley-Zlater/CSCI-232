package problemSet1;

public class problem4 {
	
	int calculate(int lowBound, int breakFloor, int totalFloors) {
		
		if (totalFloors >= 1 && breakFloor <= totalFloors) {
			
			int middle = (lowBound + totalFloors) / 2;
			
			if (middle == breakFloor) {
				return middle;
			}
			
			if (middle > breakFloor) {
				return calculate(lowBound, breakFloor, middle - 1);
			}
			
			return calculate(middle + 1, breakFloor, totalFloors);
		}
		return -1;
	}

	public static void main(String[] args) {
		problem4 obj = new problem4();
		int result = obj.calculate(0, 71, 70);
		
		if (result == -1) {
			System.out.println("not found");
		
		} else {
			System.out.println("found");
		}

	}

}
