import java.util.*;

public class BinaryTreeBasic{
    static class Node{
        int data;
        Node left;
        Node right;
        

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{

        static int idx = -1;


        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        //Preorder = Root Left Right
        public static void preorder(Node root){
            if(root == null){
                System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        //Ineorder = Left Root Right
        public static void inorder(Node root){
            if(root == null){
                System.out.print(-1+" ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        //Postorder = Left Right Root 
        public static void postorder(Node root){
            if(root == null){
                System.out.print(-1+" ");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        //Levelorder
        public static void levelOrder(Node root){
            Queue<Node> q = new LinkedList();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }

                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }

                }
            }
        }

        public static int countOfNodes(Node root){
            if(root == null){
                return 0;
            }

            int left = countOfNodes(root.left);
            int right = countOfNodes(root.right);

            return left+right+1;
        }

        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }

            int left = sumOfNodes(root.left);
            int right = sumOfNodes(root.right);

            return left+right+root.data;
        }

        public static int height(Node root){
            if(root == null){
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            return Math.max(left, right)+1;
        }

        //Diameter of a Tree
        //Approach 1   O(n^2)
        public static int diameter1(Node root){
            if(root == null){
                return 0;
            }

            int dia1 = diameter1(root.left);
            int dia2 = diameter1(root.right);
            int dia3 = height(root.left)+height(root.right)+1;

            return Math.max(dia1,Math.max(dia2, dia3));
        }

        //Approach 2  O(n)
        static class Info{
            int dia;
            int ht;

            public Info(int dia, int ht){
                this.dia = dia;
                this.ht = ht;
            }
        }

        public static Info diameter2(Node root){
            if(root == null){
                return new Info(0, 0);
            }

            Info left = diameter2(root.left);
            Info right = diameter2(root.right);

            int dia = Math.max(Math.max(left.dia, right.dia),(left.ht+right.ht+1));
            int ht = Math.max(left.ht, right.ht)+1;

            return new Info(dia, ht);

        }


    }


    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        // tree.preorder(root);
        // System.out.println();
        // tree.inorder(root);
        // System.out.println();
        // tree.postorder(root);
        // System.out.println();

        tree.levelOrder(root);

        // System.out.println(tree.countOfNodes(root));
        // System.out.println(tree.sumOfNodes(root));

        System.out.println(tree.height(root));

        System.out.println(tree.diameter1(root));

        System.out.println(tree.diameter2(root).dia);



    }
}