struct bstNode{
  int data;
  bstNode* left;
  bstNode* right;
}

//function to create new node
bstNode* creatNode(int val){
  bstNode* newNode = new bstNode();
  newNode->data = val;
  newNode->left = newNode->right = NULL;
  return newNode;
}

//insert operation
bstNode* insert(int val,bstNode* root){
  if(root == NULL){
    bstNode* newNode = createNode(val);
    root = newNode;
    return newNode;
  }
  if(val>root->data){
    root->right = insert(val,root->right);
  }else{
    root->left = insert(val,root->left);
  }
  return root;
}
    

//delete operation
bstNode* deleteNode(int val,bstNode* root){
  if(root == NULL){
    return NULL;
  }
  if(val>root->data){
    root->right = deleteNode(val,root->right);
  }else if(val<root->data){
    root->left = deleteNode(val,root->left);
  }else{
    if(root->left == NULL){
      return root->right;
    }else if(root->right == NULL){
      return root->left;
    }else{
      bstNode* IS = inordersuccesor(root->right);
      root->data = IS->data;
      root->right = deleteNode(IS->data,root->right);
    }
  }
  return root;
}
