package SymbolTable.base_array_binary_search;

public class BinarySearchST<K extends Comparable<K>,V> {

    private K[] key;
    private V[] value;
    private int length;

    public BinarySearchST(int capacity){
        key = (K[]) new Comparable[capacity];
        value = (V[]) new Object[capacity];
    }






    public static void main(String[] args){

    }
}
