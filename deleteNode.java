/* class defination
class treeNode{
    int val;
    treeNode left;
    treeNode right;

    public treeNode(int val){
        this.val = val;
    }
} 
*/



public static void main(String[] args) {
        treeNode root =null;
        int arr[] = {6,2,5,8,4,34,754};
        for(int i=0;i<arr.length;i++){
            root = treeBuilder(arr[i], root);
        }
        inorder(root);
        System.out.println(search(8,root));
        root = delete(34,root);
        inorder(root);
        
    }


//Delete method
public static treeNode delete(int val,treeNode root){
        //first step is searching
        if(val > root.val){
            root.right = delete(val,root.right);
        }else if(val<root.val){
            root.left = delete(val,root.left);
        }else{                  //when val == root.val deletion code starts
            //case 1 when both childs are null simply return null 
            if(root.right == null && root.left == null){
                return null;
            }
            //case 2 when single child is null
            else if(root.right == null){
                return root.left;
            }else if(root.left == null){
                return root.right;
            }
            //case 3 when none is null, then replace the value of node to be deleted with inorder succesor value and delete the in order succesor
            //inorder succesor is the left most node in the right of the node to be deleted
            else{
                treeNode IS = inordersuccesor(root.right);
                root.val = IS.val;
                root.right = delete(val,root.right);
            }
        }
        return root;
}


//method to find inorder successor
public static treeNode inordersuccesor(treeNode root){
  while(root.left != null){
    root = root.left;
  }
  return root;
}
