/**
 * Represents a data structure for solving the connectivity problem using the Weighted Quick-Union algorithm.
 * Extends the QuickUnion class to leverage the root method and other functionalities.
 * The Weighted Quick-Union algorithm maintains an array where each element represents a component's parent pointer,
 * and an additional array to store the size of each component.
 * The union operation merges two components by updating the parent pointer of the smaller component to point to the root of the larger component,
 * and updating the size of the larger component accordingly.
 */
public class WeightedQuickUnion extends QuickUnion{

	// Array to store the size of each component
	private int[] size;
	
	/**
     * Initializes a WeightedQuickUnion object with the given number of elements.
     * 
     * @param n The number of elements in the data structure.
     */
	public WeightedQuickUnion(int n) {
		super(n);
		
		size = new int[n];
		
		for (int i = 0; i < id.length; i++) {
			size[i] = 1;
		}
		
	}

	/**
     * Performs the union operation between two elements, ensuring that the smaller component is attached to the larger one.
     * Updates the size of the larger component accordingly.
     * 
     * @param p The first element.
     * @param q The second element.
     */
	@Override
	public void union(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		
		if(pRoot == qRoot)
			return;
		
		if(size[pRoot] < size[qRoot]) {
			id[pRoot] = qRoot;
			size[qRoot] += size[pRoot];
		}else {
			id[qRoot] = pRoot;
			size[pRoot] += size[qRoot];
		}
		
		count--;
		
		
	}

}