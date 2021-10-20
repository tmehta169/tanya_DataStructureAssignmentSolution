package com.greatlearning.main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Que 
{
	Queue<Integer> queue;
	Deque<Integer> deQ;

	public Que (Queue<Integer> queue) 
	{
		this.queue = queue;
		queue = new LinkedList<>();
		deQ = new ArrayDeque<>();
	}

	void enque(int data) 
	{
		while (!deQ.isEmpty() && deQ.getLast() < data)
		{
			deQ.removeLast();
		}
		deQ.addLast(data);
		queue.add(data);
	}

	public Integer Max(Queue<Integer> queue) 
	{
		Integer max = queue.remove();
		queue.add(max);
		for (int i = 0; i < queue.size() - 1; i++) 
		{
			Integer current = queue.remove();
			if (current.compareTo(max) > 0) 
			{
				max = current;
			}
			queue.add(current);
		}
		return max;
	}

}




	