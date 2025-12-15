package BT;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left=null;
        this.right=null;
    }
}
public class BT_Implementation {
    Node root;
    BT_Implementation(){
        root=null;
    }
    public void insert(int data){
        root = insertNew(root,data);
    }

    public Node insertNew(Node root,int data){
        if(root==null){
            root=new Node(data);
        }
        if(data<root.data){
            root.left=insertNew(root.left,data);
        }else if(data>root.data){
            root.right = insertNew(root.right,data);
        }
        return root;
    }

    public void inorder(){
        inorderRec(root);
    }
    private void inorderRec(Node root){
        if(root!=null){
            inorderRec(root.left);
            System.out.print(root.data+" ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BT_Implementation BT = new BT_Implementation();
        BT.insert(100);
        BT.insert(150);
        BT.insert(10);
        BT.insert(1100);
        BT.insert(1);
        BT.insert(90);
        BT.insert(1150);
        BT.inorder();
    }
}
