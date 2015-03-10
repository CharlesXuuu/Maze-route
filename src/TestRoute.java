import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class TestRoute {

	
	/*
	 * Program info
	 */
	
	public static String infilename="example1.txt";
	//debug info 1 print 0 not print
	public static int debug= 1;
	
	/*
	 * Maze Info
	 */
	public static int width;
	public static int height;
	public static char[][] symbolGraph;
	
	public static ArrayList<Node> nodeArray;
	
	public static void readInput(){
		try {
			// input file
			File infile = new File(infilename);
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(infile)));
			// first line
			String graphscale[] = bufferedReader.readLine().split(" |\t");
			width = Integer.parseInt(graphscale[0]);
			height = Integer.parseInt(graphscale[1]);
			// define the symbolGraph
			symbolGraph = new char[height][width];
			for (int i = 0; i < height; i++) {
				symbolGraph[i] = bufferedReader.readLine().toCharArray();
			}

			bufferedReader.close();

			if (debug == 1) {
				// just print the info
				System.out.println("" + width + " " + height + "\n");
				for (int i = 0; i < height; i++) {
						System.out.println(symbolGraph[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	/**
	 * Find key points including check points, start and end points.
	 */
	private static void findKeypoint() {
		
		nodeArray = new ArrayList<Node>();
		int count = 0;
		
		for (int i=0; i<height; i++){
			for (int j=0; j<width; j++){
				if(symbolGraph[i][j]=='S'){
		        nodeArray.add(new Node(count, 0, i, j));		
				}
				if(symbolGraph[i][j]=='@'){
				nodeArray.add(new Node(count, 1, i, j));		
				}	
				if(symbolGraph[i][j]=='G'){
				nodeArray.add(new Node(count, 2, i, j));	
				}	
			}
		}
		
	}
	
	/**
	 * Construct the weighted graph using BFS search
	 */
	private static void constructWeightedGraph() {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * Solve the problem using dynamic programming
	 */
	private static void solve() {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * Main function
	 * @param args  command line argument
	 */
	
	public static void main(String[] args){
		readInput();
		findKeypoint();
		constructWeightedGraph();
		solve();
	}

}




class Node {
     public int id;
     public int type;
     public int w_location;
     public int h_location;
     
     public Node(int id, int type, int w_location, int h_location){
    	 this.id = id;
    	 this.type = type;
    	 this.w_location = w_location;
    	 this.h_location = h_location;
     }
     
}
