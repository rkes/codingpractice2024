package coding.tree.bst;

import java.util.*;
import java.util.stream.Collectors;

public class CreateTree {
    public static void main(String[] args) {
        TreeNode treeNode = generatBst();
        printBST(treeNode);
        TreeNode newTreeNode = new TreeNode(3);
        newTreeNode.right= new TreeNode(20);
        newTreeNode.right.right = new TreeNode(7);
        newTreeNode.right.left = new TreeNode(15);
        newTreeNode.left = new TreeNode(9);
        System.out.println(sumOfLeftLeaves(newTreeNode));
        System.out.println("**************");
        //leftViewOfTree(treeNode,getHeightOfTree(treeNode));
       // System.out.println("*****************");
        List<Integer> lst2 = findSpiral(treeNode);
        String s =lst2.stream().map(x->x.toString()).collect(Collectors.joining(","));
       // System.out.println(s);
       // System.out.printf("\n\n");
        int ht = getHeightOfTree(treeNode);
     //   System.out.println(getHeightOfTree(treeNode));
        Map<Integer,ArrayList<TreeNode>> mp = new HashMap<>();
        //traverseLevelOrder(treeNode,ht,mp);
        //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        List<ArrayList<Integer>> lst = levelOrder(treeNode);
        //System.out.println();
        //traverse(treeNode,treeNode.right,3 );
    }
    public static void leftViewOfTree(TreeNode node,int h){
        if(node==null) return;
        if(h>1){
           // System.out.println(node.data);
            return;
        }
        leftViewOfTree(node.left,h-1);
        leftViewOfTree(node.right,h-1);
    }
    static ArrayList<ArrayList<Integer>> levelOrder(TreeNode node)
    {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        int h =getHeight(node);
        for(int i=1;i<=h;i++){
            lst.add(levelOrder(node,i));
        }
        return lst;
    }
    static ArrayList<Integer> findSpiral(TreeNode root){
        int ht = getHeightOfTree(root);
        boolean travseOrder = true;
        ArrayList<Integer> res  =new ArrayList<>();
        for(int i=1;i<=ht;i++){
            res.addAll(findSpiralAux(root,travseOrder,i));
            travseOrder = !travseOrder;
        }
        return res;
    }
    static ArrayList<Integer> findSpiralAux(TreeNode root,boolean order,int h){
        ArrayList<Integer> lst = new ArrayList<>();
        if(root==null){
            return lst;
        }
        if(h==1) {
            lst.add(root.data);
            return lst;
        }
        if(order){
            ArrayList<Integer> lft =findSpiralAux(root.left,order,h-1);
            ArrayList<Integer> rt =findSpiralAux(root.right,order,h-1);
            lst.addAll(lft);
            lst.addAll(rt);
        }else{
            ArrayList<Integer> rt =findSpiralAux(root.right,order,h-1);
            ArrayList<Integer> lft =findSpiralAux(root.left,order,h-1);
            lst.addAll(rt);
            lst.addAll(lft);
        }
        return lst;
    }
    static int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(getHeight(node.left),getHeight(node.right))+1;
    }
    static ArrayList<Integer> levelOrder(TreeNode node , int ht ){
        ArrayList<Integer> arLst = new ArrayList<>();
        if(node==null){
            return arLst;
        }
        if(ht==1){
            arLst.add(node.data);
            return arLst;
        }
        if(ht>1){
            ArrayList<Integer> lft = levelOrder(node.left,ht-1);
            ArrayList<Integer> rght = levelOrder(node.right,ht-1);
            arLst.addAll(lft);
            arLst.addAll(rght);
        }
        return arLst;
    }
    public static int getHeightOfTree( TreeNode treeNode){
        if(treeNode==null) return 0;
        return Math.max(getHeightOfTree(treeNode.left),getHeightOfTree(treeNode.right))+1;
    }
    public static void printBST(TreeNode treeNode){
        if(treeNode!=null){
            printBST(treeNode.left);
            System.out.printf("%d ",treeNode.data);
            printBST(treeNode.right);
        }
    }
    public static TreeNode generatBst(){
        int []ar={1,2,3,4,5};
        Arrays.sort(ar);
        return generateBSTTree(ar,0,ar.length-1);
    }
    public static TreeNode generateBSTTree(int []ar,int start,int end){
        if(start>end) return null;
        if(start==end){
            return new TreeNode(ar[start]);
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(ar[mid]);
        node.left = generateBSTTree(ar,start,mid-1);
        node.right = generateBSTTree(ar,mid+1,end);
        return node;
    }
    public static void traverseDown(TreeNode node,int k){
        if(node==null || k<0){
            return ;
        }
        if(k==0){
            System.out.println(node.data);
            return;
        }
        traverseDown(node.left,k-1);
        traverseDown(node.right,k-1);
    }
    public static int traverse(TreeNode root,TreeNode target,int k){
        if(root==null || target==null || k<0){
            return -1;
        }
        if(root==target){
            traverseDown(root,k);
            return 0;
        }
        int leftTraversal = traverse(root.left,target,k);
        if(leftTraversal!=-1){
            if(leftTraversal+1==k){
                System.out.println(root.data);
            }
            else traverseDown(root.right,k-leftTraversal-2);
            return leftTraversal+1  ;
        }
        int rightTraversal = traverse(root.right,target,k);
        if(rightTraversal!=-1){
            if(rightTraversal+1==k){
                System.out.println(root.data);
            }
            else
                traverseDown(root.left,k-rightTraversal-2);
            return rightTraversal+1;
        }
        return -1;
    }
    public static boolean isLeaf(TreeNode treeNode){
        if(treeNode==null) return false;
        return treeNode.left==null && treeNode.right==null;
    }
    public static int sumOfLeftLeaves(TreeNode treeNode){
        int sum=0;
        if(treeNode == null) return sum;
        else {
            if(isLeaf(treeNode.left)){
                sum+=treeNode.left.data;
            }else{
                sum+=sumOfLeftLeaves(treeNode.left);
            }
            sum+= sumOfLeftLeaves(treeNode.right);

        }
        return sum;

    }
}
