package DataStructuresAndAlgorithms;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        Node root = new Node(1,"Andy");
        Node node2 = new Node(2,"Simon");
        Node node3 = new Node(3,"Alex");
        Node node4 = new Node(4,"Jeff");

        bt.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);

//        System.out.println("前序");
//        bt.leftNode();

//        System.out.println("中序");
//        bt.midNode();

//        System.out.println("後序");
//        bt.rightNode();

        System.out.println("前序循環");
        Node resNode = bt.leftNodeSearch(4);
        if(resNode != null){
            System.out.println("no= "+resNode.getNo()+", Name= "+resNode.getName());
        }else{
            System.out.println("查無資料");
        }

    }
}

class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public void leftNode(){
        if(this.root != null){
            this.root.leftNode();
        }else{
            System.out.println("二元樹為空 無值");
        }
    }

    public void midNode(){
        if(this.root != null){
            this.root.midNode();
        }else{
            System.out.println("二元樹為空 無值");
        }
    }

    public void rightNode(){
        if(this.root != null){
            this.root.rightNode();
        }else{
            System.out.println("二元樹為空 無值");
        }
    }

    public Node leftNodeSearch(int no){
        if(root != null){
            return root.leftNodeSearch(no);
        }else{
            return null;
        }
    }

    public Node midNodeSearch(int no){
        if(root != null){
            return root.midNodeSearch(no);
        }else{
            return null;
        }
    }

    public Node rightNodeSearch(int no){
        if(root != null){
            return root.rightNodeSearch(no);
        }else{
            return null;
        }
    }
}

class Node {
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(){}

    public Node(int no, String name){
        this.no = no;
        this.name = name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree{ no= " + no + ", name= " + name + " }";
    }

    public void leftNode(){
        System.out.println(this);
        if(this.left != null){
            this.left.leftNode();
        }
        if(this.right != null){
            this.right.leftNode();
        }
    }

    public void midNode(){
        if(this.left != null){
            this.left.midNode();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.midNode();
        }
    }

    public void rightNode(){
        if(this.left != null){
            this.left.rightNode();
        }
        if(this.right != null){
            this.right.rightNode();
        }
        System.out.println(this);
    }

    public Node leftNodeSearch(int no){
        if(this.no == no){
            return this;
        }
        Node resNode = null;
        if(this.left != null){
            resNode = this.left.leftNodeSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.leftNodeSearch(no);
        }
        return resNode;
    }

    public Node midNodeSearch(int no){
        Node resNode = null;
        if(this.left != null){
            resNode = this.left.midNodeSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        if(this.right != null){
            resNode = this.right.midNodeSearch(no);
        }
        return resNode;
    }

    public Node rightNodeSearch(int no){
        Node resNode = null;
        if(this.left != null){
            resNode = this.left.rightNodeSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.rightNodeSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        return resNode;
    }
}
