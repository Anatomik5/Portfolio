import java.util.Random;
/**
 * @since 21.06.2023
 * @author Alisher Darmenov
 * Making preorder Binary Tree
 * Each Node has 2 children
 */
public class MainClass {
    public static void main(String[] args){
        Random random = new Random();
        int[] rawData = new int[10];
        System.out.println("The input Data: ");

        //Creation of random Input Data

        for (int i=0;i< rawData.length;i++){
            rawData[i]= random.nextInt(0,100);
            System.out.print(rawData[i]+"; ");
        }

         //Creation of Tree with first integer as root

        BTree tree = new BTree(new Node(null,null,rawData[0]));
        for(int i=1;i< rawData.length;i++){
            tree.insert(rawData[i]);
        }

        //The common visualization of tree

        Node[] current = new Node[]{tree.root()};
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.print("The current Binary Tree: ");
        while(current!=null) {
            System.out.println();
            for (Node node : current) {
                if (node != null) {
                    System.out.print(node.getKey() + "; ");
                } else System.out.print(" " + "; ");
            }
            Node[] next = new Node[current.length*2];
            boolean isEmpty = true;
            int count=0;
            for(int i =0;i<next.length;i=i+2){
                if(current[count]!=null&&current[count].getChildren()!=null) {
                    next[i]=current[count].getChildren()[0]!=null?current[count].getChildren()[0]:null;
                    next[i+1]=current[count].getChildren()[1]!=null?current[count].getChildren()[1]:null;
                    isEmpty=false;
                }else {
                    next[i] =null;
                    next[i+1]= null;
                }
                count++;
            }
            if(isEmpty){
                current=null;
            }else current = next;
        }
    }
}