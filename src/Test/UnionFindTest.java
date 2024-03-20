import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the QuickFind class.
 */
class UnionFindTest {

	/**
     * Test case to verify the count of connected components in QuickFind.
     */
	@Test
	void testQuickFindCount() {
		QuickFind uf = new QuickFind(5);
		
		uf.union(0, 1);
		uf.union(1, 4);
		uf.union(2, 3);
		
		int actual = uf.getConnectedComponentCount();
		int expected = 2;
		
		assertEquals(expected, actual);
		
	}
	
	/**
     * Test case to verify if two elements are connected in QuickFind.
     */
	@Test
	void testQuickFindIsConnected() {
		QuickFind uf = new QuickFind(5);
		
		uf.union(0, 1);
		uf.union(1, 4);
		uf.union(2, 3);
		
		boolean actual = uf.isConnected(2,0);
		boolean expected = false;
		
		assertEquals(expected, actual);
		
	}
	
	/**
     * Test case to verify the root of an element in QuickFind.
     */
	@Test
	void testQuickFindFind() {
		QuickFind uf = new QuickFind(5);
		
		uf.union(0, 1);
		uf.union(1, 4);
		uf.union(2, 3);
		
		int actual = uf.find(2);
		int expected = 3;
		
		assertEquals(expected, actual);
		
	}

}
