package algorithm.algorithm4.SymbolTable.base_array_binary_search;

public class BinarySearchST<K extends Comparable<K>,V> {

    private K[] keys;
    private V[] values;
    private int length;

    public BinarySearchST(int capacity){
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    public void put(K key,V value){
        int i = rank(key);
        if(i<length&&keys[i].equals(key)){
            values[i] = value; return;
        }
        for(int j = length;j>i;j--){
            keys[j] = keys[j-1];values[j] = values[j-1];
        }
        keys[i] = key;
        values[i]= value;
        length++;
    }

    private int rank(K key){
        int l = 0;
        int h = length-1;
       int mid;
        while(l<=h){
            mid= l+(h-l)/2;
            int result = key.compareTo(keys[mid]);
            if (result>0) l = mid+1;
            else if(result<0) h = mid-1;
            else return mid;
        }
        return l;
    }
    public String toString(){
       String str = "";
       for(int i =0;i<length;i++){
           str = str+"key :"+keys[i]+" value :"+ values[i]+"\n";
       }
       return str;
    }

    public static void main(String[] args){
        BinarySearchST st = new BinarySearchST(10);
        st.put(1,1);
        st.put(100,100);
        st.put(68,68);
        st.put(24,24);
        st.put(15,15);
        System.out.println(st);
    }
}
