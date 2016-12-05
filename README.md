# Approximation-algorithms-for-TargetSetSelection

This is a complete code for two approximation algorithms. Each algorithm is run on a input graph, and the algorithm chooses a minimum target set that will eventually activate the entire graph.
TSS1 has algorithm 1. It is agorithm that uses a fixed number of 'r' rounds to generate a Target Set. It first chooses vertices with degree greater than or equal to a constant denote as 'beta' in the code. Then at each of the remaining 'r-1' rounds it will choose vertices with degrees reducing in descending order( aka greedy step)
TSS2 is algorithm 2, It uses principle of weighted vertex cover to solve target set problem using linear programming.
Here, the problem is reduced to a a few linear constraints that define 'hunger' for each vertex as degree of that vertex, and accordingly linear constraints are generated. Linear constraints say that for a given edge, only one vertex with hgiher hunger is chosen. In case of vertices having equal hunger, both the vertices are chosen.
COntroller1 generates a random graph of 10 vertices and then call TSS1 and TSS2.
Controller2 works on a graph downloaded from SNAP database of Stanford and is more accurate to real world scenario. Then it also calls TSS1 and TSS2.

Just downlad the files and configure them, apart from that also save the data file 0.edges at appropriate location in your system and then give its relevant path in the program.
