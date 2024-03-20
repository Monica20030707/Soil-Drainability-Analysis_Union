/**
 * Represents a data structure for solving the connectivity problem using the Quick-Union algorithm.
 * The Quick-Union algorithm maintains an array where each element represents a component's parent pointer.
 * The union operation merges two components by updating the parent pointer of the root of one component to point to the root of the other component.
 */
public class QuickUnion implements UnionFind {
	
	protected int id[];
	protected int count;
	
	public QuickUnion(int n) {
		id = new int[n];
		count = n;
		
		initialize();
	}
	
	private void initialize() {
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		
		if(pRoot == qRoot)
			return;
		
		id[pRoot] = qRoot;
		
		count--;
		
	}

	@Override
	public boolean isConnected(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		return pRoot == qRoot;
	}

	@Override
	public int find(int p) {
		return root(p);
	}

	@Override
	public int getConnectedComponentCount() {
		return count;
	}
	
	/**
     * Finds the root of the component containing the specified element.
     * 
     * @param p The element whose component root is to be found.
     * @return The root of the component containing the specified element.
     */
	protected int root(int p) {
		while(id[p] != p) {
			p = id[p];
		}
		
		return p;
	}
}
