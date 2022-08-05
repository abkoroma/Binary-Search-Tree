
public class BinarySearchTree<E extends Comparable <E>> implements BinarySearchTreeInterface<E> {
	BinarySearchTree<E> parent;
	BinarySearchTree<E> right;
	BinarySearchTree<E> left;
	BinarySearchTree<E> root;
	E value;
	public static String draw;
	
	public BinarySearchTree() {
		
	}
	
	
	public BinarySearchTree(E value) {
		this.parent = null;
		this.left = null;
		this.right = null;
		this.root = null;
		this.value = value;
	}
	
	
	@Override
	public void add(E item) {
		root = add(item, root);
	}
	
	public BinarySearchTree<E> add(E item, BinarySearchTree<E> currNode) {
		if (currNode == null) {
			currNode = new BinarySearchTree<E>(item);
		}
		if(item.compareTo(currNode.value) == 0) {
			currNode.value = item;
		}
		else {
			if(item.compareTo(currNode.value) < 0) {
				currNode.left = add(item, currNode.left);
			}
			else {
				currNode.right = add(item, currNode.right);
			}
		}
			return currNode;
	}

	@Override
	public void remove(E item) {
		root = remove(item, root);	
	}
	
	public BinarySearchTree<E> remove(E item, BinarySearchTree<E> node) {
		if (node == null) {
			return null;
		}
		else if (node.value.compareTo(item) < 0) {
			node.left = remove(item, node.left);
		}
		else if(node.value.compareTo(item) > 0) {
			node.right = remove(item, node.right);
		}
		else {
			if(node.left == null) {
				return node.right;
			}
			else if (node.right == null) {
				return node.left;
			}
			else {
				
			}
		}
		return node;
	}

	@Override
	public boolean search(E item) {
		return search(item, root);
	}
	
	public boolean search(E item, BinarySearchTree<E> node) {
		if (node == null) {
			return false;
		}
		else if (node.value.compareTo(item) == 0) {
			return true;
		}
		else {
			if(node.value.compareTo(item) > 0) {
				return search(item, node.left);
			}
			else {
				return search(item, node.right);
			}
		}
		
	}
	
	public boolean isRoot() {
		return this.parent == null;
	}
	
	public boolean isLeaf() {
		return !(left == null && right == null);
	}
	
	public BinarySearchTree<E> minNode() {
		if (this.left == null) {
			return this;
		}
		else {
			BinarySearchTree<E> node = this.left;
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}
	}
	
	public String toString() {
		String s = "";
   	 	//Your code here
		if (root == null) {
			s = "";
		}
		else {
			s = s + root.left.toString();
			if (s != null) {
				s += ",";
			}
			s += root.value;
			if (root.right != null) {
				s += ",";
				s = s + root.right.toString();
			}
		}
		
   	 	if(isRoot()) {
   	 		if(s.length() > 1)
   	 			s = s.substring(0, s.length() - 2);
   	 			s = "[" + s + "]";
   	 	}
   	 	return s;
    }
	
	public String drawTree() {
		draw = "";
		drawTreeHelper(this.root, 0);
   	 	return draw;
    }
    
    public void drawTreeHelper(BinarySearchTree<E> root, int level){
    	if(root == null)
         	return;
    	drawTreeHelper(root.right, level+1);
    	if(level!=0){
        	for(int i=0;i<level-1;i++)
            	draw += "|\t";
            	draw += "|-------"+root.value+"\n";
    	}
    	else
        	draw += root.value+"\n";
    	drawTreeHelper(root.left, level+1);
    }	

}



/*else if (node.value == item) {
return true;
}
else {
if ((int) (item) < (int)node.value) {
	return search(item, node.left);
}
else {
	return search(item, node.right);
}
}*/