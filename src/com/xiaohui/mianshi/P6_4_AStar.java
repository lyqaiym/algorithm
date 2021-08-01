package com.xiaohui.mianshi;

import java.util.ArrayList;
import java.util.List;

public class P6_4_AStar {

	public static final int[][] MAZE = { //
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

	public static int[][] MAZE_F;

	public static Grid aStarSearch(Grid start, Grid end) {
		MAZE_F = new int[MAZE.length][MAZE[0].length];
		ArrayList<Grid> openList = new ArrayList<Grid>();
		ArrayList<Grid> closeList = new ArrayList<Grid>();
		openList.add(start);
		while (openList.size() > 0) {
			Grid currentGrid = findMinGrid(openList);
			openList.remove(currentGrid);
			closeList.add(currentGrid);
			ArrayList<Grid> neighbors = findNeighbors(currentGrid, openList, closeList);
			System.out.println("currentGrid=" + currentGrid.x + "," + currentGrid.y + ",s=" + neighbors.size());
			for (Grid grid : neighbors) {
				if (!openList.contains(grid)) {
					grid.initGrid(currentGrid, end);
					openList.add(grid);
				}
			}
			for (Grid grid : openList) {
				if (grid.x == end.x && grid.y == end.y) {
					return grid;
				}
			}
		}
		return null;
	}

	private static Grid findMinGrid(ArrayList<Grid> openList) {
		Grid tempGrid = openList.get(0);
		for (Grid grid : openList) {
			if (grid.f < tempGrid.f) {
				tempGrid = grid;
			}
		}
		return tempGrid;
	}

	private static ArrayList<Grid> findNeighbors(Grid grid, List<Grid> openList, List<Grid> closeList) {
		ArrayList<Grid> gridList = new ArrayList<Grid>();
		if (isValidGrid(grid.x, grid.y - 1, openList, closeList)) {
			gridList.add(new Grid(grid.x, grid.y - 1));
		}
		if (isValidGrid(grid.x, grid.y + 1, openList, closeList)) {
			gridList.add(new Grid(grid.x, grid.y + 1));
		}
		if (isValidGrid(grid.x - 1, grid.y, openList, closeList)) {
			gridList.add(new Grid(grid.x - 1, grid.y));
		}
		if (isValidGrid(grid.x + 1, grid.y, openList, closeList)) {
			gridList.add(new Grid(grid.x + 1, grid.y));
		}
		return gridList;
	}

	private static boolean isValidGrid(int x, int y, List<Grid> openList, List<Grid> closeList) {
		if (x < 0 || x >= MAZE.length || y < 0 || y >= MAZE[0].length) {
			return false;
		}
		if (MAZE[x][y] == 1) {
			return false;
		}
		if (containGrid(openList, x, y)) {
			return false;
		}
		if (containGrid(closeList, x, y)) {
			return false;
		}
		return true;
	}

	private static boolean containGrid(List<Grid> grids, int x, int y) {
		for (Grid grid : grids) {
			if (grid.x == x && grid.y == y) {
				return true;
			}
		}
		return false;
	}

	static class Grid {
		public int x;
		public int y;
		public int f;
		public int g;
		public int h;
		public Grid parent;

		public Grid(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void initGrid(Grid parent, Grid end) {
			this.parent = parent;
			if (parent != null) {
				this.g = parent.g + 1;
			} else {
				this.g = 1;
			}
			this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
			this.f = this.g + this.h;
			MAZE_F[x][y] = f;
		}
	}

	public static void main(String[] args) {
		Grid startGrid = new Grid(5, 2);
		Grid endGrid = new Grid(2, 5);
		Grid resultGrid = aStarSearch(startGrid, endGrid);
		if (resultGrid == null) {
			System.out.println("resultGrid1=nul");
			return;
		}
		System.out.println("resultGrid1=" + resultGrid.x + "," + resultGrid.y);
		ArrayList<Grid> pathList = new ArrayList<Grid>();
		while (resultGrid != null) {
			pathList.add(new Grid(resultGrid.x, resultGrid.y));
//			System.out.println("resultGrid2=" + resultGrid.x + "," + resultGrid.y);
			resultGrid = resultGrid.parent;
		}
		System.out.println("---------------");
		for (int i = 0; i < MAZE_F.length; i++) {
			for (int j = 0; j < MAZE[i].length; j++) {
				System.out.print(MAZE_F[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("---------------");
		for (int i = 0; i < MAZE.length; i++) {
			for (int j = 0; j < MAZE[i].length; j++) {
				if (containGrid(pathList, i, j)) {
					System.out.print("*, ");
				} else {
					System.out.print(MAZE[i][j] + ", ");
				}
			}
			System.out.println();
		}
	}

}
