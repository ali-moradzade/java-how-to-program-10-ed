package come.deitel.datastructures;

class TreeNode<T extends Comparable<T>>
{
	TreeNode<T> leftNode;
	T data;
	TreeNode<T> rightNode;
	
	public TreeNode(T nodeData)
	{
		data = nodeData;
		leftNode = rightNode = null;
	}
	
	public void insert(T insertValue)
	{
		if (insertValue.compareTo(data) < 0)
		{
			if (leftNode == null)
				leftNode = new TreeNode<>(insertValue);
			else
				leftNode.insert(insertValue);
		}
		else if (insertValue.compareTo(data) > 0)
		{
			if (rightNode == null)
				rightNode = new TreeNode<>(insertValue);
			else
				rightNode.insert(insertValue);
		}
	}
}

public class Tree<T extends Comparable<T>>
{
	private TreeNode<T> root;
	
	public Tree()
	{
		root = null;
	}
	
	public void insertNode(T insertValue)
	{
		if (root == null)
			root = new TreeNode<T>(insertValue);
		else
			root.insert(insertValue);
	}
	
	public void preorderTraversal()
	{
		preorderHleper(root);
	}
	
	private void preorderHleper(TreeNode<T> node)
	{
		if (node == null)
			return;
		
		System.out.printf("%s ", node.data);
		preorderHleper(node.leftNode);
		preorderHleper(node.rightNode);
	}
	
	public void inorderTraversal()
	{
		inorderHelper(root);
	}
	
	private void inorderHelper(TreeNode<T> node)
	{
		if (node == null)
			return;
		
		inorderHelper(node.leftNode);
		System.out.printf("%s ", node.data);
		inorderHelper(node.rightNode);
	}
	
	public void postorderTraversal()
	{
		postorderHelper(root);
	}
	
	private void postorderHelper(TreeNode<T> node)
	{
		if (node == null)
			return;
		
		postorderHelper(node.leftNode);
		postorderHelper(node.rightNode);
		System.out.printf("%s ", node.data);
	}
}



