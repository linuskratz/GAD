/**
 * Klasse die für ein gegebenes Labyrinth einen Weg vom Anfang bis zu dem vorgegebenen Ziel berechnen soll.
 */
public class Walker {    
    private boolean[][] maze; // gegebenes Labyrinth, "false" steht für eine leere Zelle, "true" für eine volle Zelle
    private boolean[][] visited; // besuchte Zellen
    private int goalX, goalY; // Zielpunkt im Labyrinth
    
    private int width, height; // Breite und Höhe des Labyrinths
                
    public Walker(boolean[][] maze, int goalX, int goalY) {
        this.maze = maze;
        this.goalX = goalX;
        this.goalY = goalY;
        
        this.width = maze.length;
        this.height = maze[0].length;
        this.visited = new boolean[width][height];
    }
    
    public boolean[][] getVisited() { return visited; }

    public boolean walk() {
    	return recWalk(1,0,1,-1, 0, false);
    }
    
    public boolean recWalk(int x, int y, int lastX, int lastY, int turns, boolean entered) {
    	int dy = y - lastY;
    	int dx = x - lastX;
    	
    	visited[x][y] = true;
    	//reached exit
    	if ((x == width-1) && (y == height -2)) {
    		return true;
    	}
    	//check if 4 consecutive turns have been reached
    	if (Math.abs(turns) > 4) {
    		return false;
    	}
    	//check for other potential exits
    	if (x == 0 || (y == 0 && entered) || y == height-1 || (x == width-1 && y !=height-2))
			return false;
		
    	//turn right
    	if (!maze[x - dy][y + dx]) {
    		return recWalk(x - dy,y + dx,x,y, ++turns, true);
    	}else if (!maze[x+dx][y+dy]) { //go ahead
    		return recWalk(x+ dx,y+dy,x,y, turns, true);
    	}else if (!maze[x + dy][y - dx]) { // turn left
    		return recWalk(x + dy,y - dx,x,y, --turns, true);
    	}else {	//turn around
    		return recWalk(x-dx, y-dy, x, y, turns= turns -2, true);
    	}
    }
    
}
