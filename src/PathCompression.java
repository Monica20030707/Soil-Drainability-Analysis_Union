/***********************************************************
* Name: Monica Nguyen
* Date: 5 Jan 2023
* Description: This program is an algorithm to reads from the given 
* input file, text1.txt, text2.txt and text3.txt and determine 
* whether soil allows water to drain or hold the water. Extends 
* the WeightedQuickUnion class to leverage its union-find 
* functionalities with path compression. The PathCompression 
* class reads from the given input file containing the soil 
* structure represented as an n-by-n grid of cells, where each 
* cell is either 1 (allowing water to drain) or 0 (holding the water).
* It implements the Weighted Quick Union with Path Compression 
* algorithm to determine the water drainage ability of the soil.
*
***********************************************************/

import java.io.*;
import java.util.*;
public class PathCompression extends WeightedQuickUnion{

    public static int[][] token;
    public static int size;

    /**
     * Constructs a PathCompression object with the given length and input file.
     * Initializes the data structure with the specified size and reads the soil structure from the input file.
     * 
     * @param length The size of one dimension of the soil grid.
     * @param filename The filename of the input file containing the soil structure.
     * @throws FileNotFoundException If the specified input file is not found.
     */
    public PathCompression(int length, String filename) throws FileNotFoundException {
        super(length*length);

        size= length;

        Scanner file= new Scanner(new File(filename));
        
        // we just have the biggest size for the array
        token= new int [size][size];

        // store all information into the array
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                token[row][column] = file.nextInt();
            }
        }
        
        System.out.println(testDrain());
    }

    /**
     * Performs the union operation for adjacent cells in the soil grid.
     * Uses Weighted Quick Union with Path Compression to connect cells allowing water drainage.
     */
    public void findUnion() {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {

                //Only cares about case that the value number is 1
                if (token[row][column] == 1) {

                    // if not the last row then the union the current token with the one below
                    // in the same column if that below token also has value 1
                    if (row < size-1 && token[row+1][column] == 1)
                        union(row * size + column, row * size + column + size);

                    // if not the first row then the union the current token with the one above
                    // in the same column if that above token also has value 1
                    if (row > 0 && token[row-1][column] == 1)
                        union(row * size + column, row * size + column - size);

                    // if not the leftmost column then the union the current token with the one from
                    // the right column on the same row if that token on the right also has value 1
                    if (column < size - 1 && token[row][column + 1] == 1)
                        union(row * size + column, row * size + column + 1);

                    // if not the rightmost column then the union the current token with the one from
                    // the left column on the same row if that token on the left also has value 1
                    if (column > 0 && token[row][column - 1] == 1)
                        union(row * size + column, row * size + column - 1);

                }
            }
        }
    }

    /**
     * Overrides the root method from the WeightedQuickUnion class to implement path compression.
     * 
     * @param p The element to find the root for.
     * @return The root index of the given element.
     */
    @Override 
    protected int root(int p){
        while(id[p] != p) {
            id[p] = id[id[p]];
			p = id[p];
		}
		
		return p;
    }

    /**
     * Tests whether the soil allows water to drain or holds the water.
     * 
     * @return A string indicating whether the soil allows water to drain or holds the water.
     */
    public String testDrain() {
        findUnion();
        for (int lastRow = size * size - size; lastRow < size * size; lastRow++) {
            if (root(lastRow) < size) {
                return "Allows water to drain";
            }
        }
       return "Don't allow water to drain";
    }
}
