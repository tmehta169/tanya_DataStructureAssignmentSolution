package com.greatlearning.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Skyscrapper 
{
	static Que qu;
	static Queue<Integer> que = new LinkedList<>();
	static List<Integer> rest = new ArrayList<>();
	static int floorSize;

	private static void Order() 
	{
		int day = 1;
		while (!que.isEmpty())
		{
			int max = qu.Max(que);
			int poll = que.poll();
			
			if (poll < max) 
			{
				
				rest.add(poll);
				System.out.println("Day " + day + " : " + " ");
			}
			
			else if (poll == max)
			{
				
				if (day == floorSize) 
				{
					System.out.print("Day " + day + " : " + poll + " ");
					Collections.sort(rest, Collections.reverseOrder());
					for (int k = 0; k < rest.size(); k++)
					{
						System.out.print(rest.get(k) + " ");
					}
				} 
				else 
				{
					
					que.remove(max);
					System.out.print("Day " + day + " : " + poll + " ");
					Collections.sort(rest, Collections.reverseOrder());
					for (int j = 0; j < rest.size(); j++) 
					{
						if (rest.get(j) > qu.Max(que)) 
						{
							System.out.print(rest.get(j) + " ");
							rest.remove(j);
							j--;
						}
					}
				}
				System.out.println();
			}
			day++;
		}
	}

	public static void main(String[] args) 
	{
		qu = new Que (que);
		System.out.println("Enter the total number of floors in the building :");
		Scanner scanner = new Scanner(System.in);
		floorSize = scanner.nextInt();
		if (floorSize > 0)
		{
			
			for (int i = 0; i < floorSize; i++)
			{
				System.out.println("Enter the floor size given on day : " + (i + 1));
				int floorSize = scanner.nextInt();
				if (floorSize > 0) 
				{
					qu.enque(floorSize);
				} 
				else
				{
					System.out.println("Incorrect Value!!!");
					System.exit(1);
				}
			}
			scanner.close();
			
			System.out.println("Order of construction is as follows : ");
			Order();
		} 
		else 
		{
			System.out.println("Invalid Values!!!");
		}

	}

}



