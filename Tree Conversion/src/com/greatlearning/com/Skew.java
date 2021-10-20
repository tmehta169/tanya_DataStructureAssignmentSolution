package com.greatlearning.com;

public class Skew 
{
	static Node node;
	static int order = 0;

	public static void main(String[] args) 
	{

		Skew.node = new Node(50);
		Skew.node.left = new Node(30);
		Skew.node.right = new Node(60);
	    Skew.node.left.left = new Node(10);
		Skew.node.right.left = new Node(40);
	Vertex.skewedBT(node, order);

	
	System.out.println("Right Skewed Binary Tree in ascending order : ");
    Vertex.travRightSkew_asc(Vertex.headNode);
		
	}
}


