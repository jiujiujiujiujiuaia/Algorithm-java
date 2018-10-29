package DataStructure.graph;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;

public class SymbolGraph {
    private HashMap<Integer,String> map;
    private String[] keys;
    private Graph G;

    SymbolGraph(String filename,String sp){
        map = new HashMap<>();
        In in = new In(filename);
        while(in.hasNextLine()){
            String[] temp = in.readLine().split(sp);
        }
    }
}
