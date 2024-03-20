/**
 * Represents a data structure for solving the connectivity problem using the Quick-Find algorithm.
 * The Quick-Find algorithm maintains an array where the value of each index represents a component identifier.
 * The union operation merges two components by updating all entries in the array that match the ID of the second component.
 */
public class QuickFind implements UnionFind{
	
	
	private int[] id;  // Array to store component identifiers
	private int count; //the number of connected components
	
	/**
     * Initializes a QuickFind object with the given number of elements.
     * 
     * @param n The number of elements in the data structure.
     */
	public QuickFind(int n) {
		id = new int[n]; // Initialize array
		count = n; //n number of connected componets
		
		initialize(); // Initialize array elements
	}
	
	/**
     * Initializes the component ID array such that each element is assigned its own unique ID.
     */
	//id[0] = 0
	//id[1] = 1
	//id[2] = 2
	//complexity: N
	private void initialize() {
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	
	@Override
	public void union(int p, int q) {
		if(isConnected(p, q))
			return; 
		
		int pid = id[p];
		int qid = id[q];
		
		for (int i = 0; i < id.length; i++) {
			if(id[i]==pid)
				id[i] = qid;
		}
		
		count--;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return id[p] == id[q];
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	@Override
	public int getConnectedComponentCount() {
		return count;
	}

}
