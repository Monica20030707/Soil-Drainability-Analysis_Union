/**
 * Performs the union operation between two elements.
 * 
 * @param p The first element.
 * @param q The second element.
 */
public interface UnionFind {
	
	/**
     * Checks if two elements are connected.
     * 
     * @param p The first element.
     * @param q The second element.
     * @return True if the elements are connected, false otherwise.
     */
	public void union(int p, int q);

	/**
     * Checks if two elements are connected.
     * 
     * @param p The first element.
     * @param q The second element.
     * @return True if the elements are connected, false otherwise.
     */
	public boolean isConnected(int p, int q);

	/**
     * Finds the component identifier for the specified element.
     * 
     * @param p The element whose component identifier is to be found.
     * @return The component identifier of the specified element.
     */
	public int find(int p);

	/**
     * Gets the number of connected components in the data structure.
     * 
     * @return The number of connected components.
     */
	public int getConnectedComponentCount();

}
