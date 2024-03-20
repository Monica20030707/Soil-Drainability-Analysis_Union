/***********************************************************
* Name: Monica Nguyen
* Date: 5 Jan 2023
* Description: This program used the PathCompression
* algorithm here since the other file is a constructor.
* It will print the result based on 3 sample text files.
***********************************************************/

import java.io.FileNotFoundException;

public class PathCompressionTest {

    /**
     * Main method to execute the PathCompression algorithm on sample input files.
     * PathCompression is called as (grid number (n x n), file name);
     * 
     * @param args Command-line arguments (not used).
     * @throws FileNotFoundException If any of the specified input files are not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        PathCompression readText1 = new PathCompression(5, "txtFile/text1.txt");
        PathCompression readTest2 = new PathCompression(5, "txtFile/text2.txt");
        PathCompression readText3 = new PathCompression(10, "txtFile/text3.txt");
    }
}