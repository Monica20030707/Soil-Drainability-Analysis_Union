# Soil Water Drainability Analysis using Union
Soil scientists often categorize soils into different groups based on their ability to hold water. The internal structure of soil is represented as an n-by-n grid of cells, where each cell is either 1 or 0.

- **1**: Indicates that the cell allows water to drain.
- **0**: Indicates that the cell will hold the water.

The goal of this Java program is to determine whether a given soil configuration allows water to drain or if it will retain the water.

## Features

- Reads an n-by-n grid of cells from a text file.
- The program utilizes the Weighted Quick Union with Path Compression union-find algorithm.
- Determines if the soil allows water to drain or not.
- Prints the result as a console output:
  - "Allow water to drain" if the soil configuration permits drainage.
  - "Don’t allow water to drain" if the soil configuration retains water.

## Requirements

- Java Library alg4.jar from (https://algs4.cs.princeton.edu/code/)
- Text file containing the soil configuration
