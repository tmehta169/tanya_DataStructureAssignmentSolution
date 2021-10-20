package com.greatlearning.com;

class Node 
{
	int val;
	Node left, right;

	public Node (int item)
	{
		val = item;
		left = right = null;
	}


}

public class Vertex 
{

	static public Vertex ver;
	static Node prevNode = null;
	static Node headNode = null;
	
	static void skewedBT(Node node, int order) 
	{


		if (node == null)
		{
			return;
		}


		if (order > 0) 
		{
			skewedBT(node.right, order);
		} 
		else 
		{
			skewedBT(node.left, order);
		}
		Node rightNode = node.right;
		Node leftNode = node.left;

		
		if (headNode == null)
		{
			headNode = node;
			node.left = null;
			prevNode = node;
		} 
		else
		{
			prevNode.right = node;
			node.left = null;
			prevNode = node;
		}

		if (order > 0)
		{
			skewedBT(leftNode, order);
		} 
		else
		{
			skewedBT(rightNode, order);
		}
	}

	static void travRightSkew_asc(Node headNode2) 
	{
		if (headNode2 == null)
		{
			return;
		}
		if (headNode2.right != null && headNode2.val > headNode2.right.val)
		{
			int temp;
			temp = headNode2.val;
			headNode2.val = headNode2.right.val;
			headNode2.right.val = temp;

		}
		System.out.print(headNode2.val + " ");
		travRightSkew_asc(headNode2.right);
	}
	
	static void travRightSkewed(Node headNode2) 
	{
		if (headNode2 == null)
		{
			return;
		}

		System.out.print(headNode2.val + " ");
		travRightSkewed(headNode2.right);
	}

}