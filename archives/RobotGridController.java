/* 
 * A class which simulates the Robot grid and finds paths
 * from top-left to bottom-right position using the moves
 * Up(U), Down(D), Right(R), Left(L).
 *
 * @class variable - counter
 *                   A static variable to count the number 
 *                   of paths possible from top-left to 
 *                   bottom-right position.	 
 */

class RobotGrid {
	
	private int gridSize, xStartPos, yStartPos, counter = 0;
	private int grid[][];

	RobotGrid(int gridSize, int xStartPos, int yStartPos, int counter) {
		this.gridSize = gridSize;
		this.xStartPos = xStartPos;
		this.yStartPos = yStartPos;
		this.counter = counter;
		grid = new int[this.gridSize][this.gridSize];
		grid[this.xStartPos][this.yStartPos] = 1;
	}

	public int getCounter() {
		return counter;
	}
	/* Utility function to print the moves of the robot.
	 * 1 - Current robot position
	 * 0 - Positions that needs to be covered
	 */
	void print() {
		System.out.println();
		for(int idx = 0;idx < gridSize; idx++) {
			for(int colIdx = 0; colIdx < gridSize; colIdx++)
				System.out.print(grid[idx][colIdx] + " ");
			System.out.println();
		}
	}
	/* It calculates the paths using backtracking. For every
	 * time, the call stack reaches the bottom-right position,
	 * increase the counter by one.
	 * @param rowIdx takes the current row position value
	 *        of the robot in the grid.
	 * @param colIdx takes the current column position value
	 *        of the robot in the grid.
	 * 
	 */
	void calculatePaths(int rowIdx, int colIdx) {
		//Base Case 1: Overflow of row and column values.
		if(rowIdx > gridSize || colIdx > gridSize || rowIdx < 0
				|| colIdx < 0)
			return;
		/*
		 * Case 2: Reach the final position in the grid.
		 *         Increase the count.
		 */
		if(rowIdx == (gridSize-1) && colIdx == (gridSize-1)) {
			++counter;
			return;
		}
		/*
		 * If taking right(R) is a valid move, then take a right
		 * and recurse on the current position.
		 * Mark the grid value as 1.
		 * After the call ends, mark the grid value as 0. 
		 */
		if(colIdx + 1 < gridSize && grid[rowIdx][colIdx + 1] != 1) {
			grid[rowIdx][colIdx + 1] = 1;
			calculatePaths(rowIdx, colIdx + 1);
			grid[rowIdx][colIdx + 1] = 0;
		}
		/*
		 * If taking down(D) is a valid move, then take a right
		 * and recurse on the current position.
		 * Mark the grid value as 1.
		 * After the call ends, mark the grid value as 0.
		 */
		if(rowIdx + 1 < gridSize && grid[rowIdx + 1][colIdx] != 1) {
			grid[rowIdx + 1][colIdx] = 1;
			calculatePaths(rowIdx + 1, colIdx);
			grid[rowIdx + 1][colIdx] = 0;
		}
		/*
		 * If taking left(L) is a valid move, then take a right
		 * and recurse on the current position.
		 * Mark the grid value as 1.
		 * After the call ends, mark the grid value as 0. 
		 */
		if(colIdx - 1 > -1 && grid[rowIdx][colIdx - 1] != 1) {
			grid[rowIdx][colIdx - 1] = 1;
			calculatePaths(rowIdx, colIdx - 1);
			grid[rowIdx][colIdx - 1] = 0;
		}
		/*
		 * If taking up(U) is a valid move, then take a right
		 * and recurse on the current position.
		 * Mark the grid value as 1.
		 * After the call ends, mark the grid value as 0.
		 */
		if(rowIdx - 1 > -1 && grid[rowIdx - 1][colIdx] != 1) {
			grid[rowIdx - 1][colIdx] = 1;
			calculatePaths(rowIdx - 1, colIdx);
			grid[rowIdx - 1][colIdx] = 0;
		}
	}
}

/* A class which controls the creation of the RobotGrid instance,
 * and plays with the gridSize, start positions of the robot.
 * 
 */
public class RobotGridController {
	public static void main(String[] args) {
		//Robot stands at (0, 0) grid position.
		int possiblePaths = 0, gridSize = 4, xStartPos = 0, yStartPos = 0;
		RobotGrid roboG = new RobotGrid(gridSize, xStartPos, yStartPos, possiblePaths);
		roboG.calculatePaths(xStartPos, yStartPos);
		possiblePaths = roboG.getCounter();
		System.out.println("\nNumber of unique ways : " + possiblePaths);
	}
}

