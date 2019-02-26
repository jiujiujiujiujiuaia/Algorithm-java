package algorithm4.SymbolTable.binary_search_tree;

//二叉搜索树
public class BST<K extends Comparable<K>,V> {
    private Node root;
    private int floor;
    class Node {
        private Node left;
        private Node right;
        private K key;
        private V value;
        private int n;

        Node(K key,V value,int n){
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    private Node put(Node root,K key,V value){
        if(root == null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(root.key);
        if(cmp > 0 ){
            root.right = put(root.right,key,value);
        }
        else if(cmp < 0){
            root.left = put(root.left,key,value);
        }
        else {
            root.key = key;
            root.value = value;
        }
        root.n = size(root.right)+size(root.left)+1;
        return root;
    }

    public void put(K key,V value){
        put(root,key,value);
    }

    public V get(K key){
        return get(key,root);
    }

    private V get(K key,Node root){
        if(root == null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if(cmp > 0 ){
            get(key,root.right);
        }
        else if(cmp < 0 ){
            get(key,root.left);
        }
        else{
            return root.value;
        }
        return null;
    }
    public int size(){
       return size(root);
    }
    private int size(Node node){
        if(node == null){
            return 0;
        }
        else{
            return node.n;
        }
    }
//    private ArrayList toArray(){
//        ArrayList arrayList = new ArrayList(root.n);
//    }

    public static void main(String[] args){
        BST bst = new BST();
        bst.put(1,1);
        bst.put(1,1);
        Integer a = 10000;
        String b = "1";
        int [] c = {1,2,3};
    }
}
