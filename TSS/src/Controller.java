import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import org.xml.sax.InputSource;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice=-1,counter=0;
		Random rand=new Random();
		Integer[] vertices=new Integer[10];    //array storing vertices
		Integer[][] edges=new Integer[10][10]; //array storing edges
		
		for(int i=0;i<10;i++)
			vertices[i]=i+1;
		//Generate random graph, edge value=1 means there is a edge between vertices j & k
		for(int j=0;j<10;j++)
			for(int k=0;k<10;k++)
			{
				edges[j][k]=0;
			}
		for(int j=0;j<10;j++)
			for(int k=0;k<10;k++)
			{
				int  n = rand.nextInt(40) + 1;
				if(n>25&&j!=k)
				{
					edges[j][k]=1;
					edges[k][j]=1;
				}
			}
		for(int j=0;j<10;j++)
		{
			for(int k=0;k<10;k++)
			{
				if(edges[j][k]==0)
				{
					counter++;
				}
			}
			if (counter==10)
			{
			int index=rand.nextInt(10)%10;
			edges[j][index]=1;
			edges[index][j]=1;
			}
		}
		//print graph
		for(int t=0;t<10;t++)
		{
			System.out.println("Vertex:-"+vertices[t]);
			for(int u=0;u<10;u++)
			{
				if(edges[t][u]==1)
					System.out.println(vertices[t]+"->"+vertices[u]);
			}
			System.out.println();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please choose which algorithm to run?(1/2):-");
		try {
			choice=Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (choice==1)
		{
			TSS1 tss1=new TSS1();
			tss1.algo1(vertices, edges,10);
		}
		else
		{
			TSS2 tss2=new TSS2();
			tss2.algo2(vertices, edges, 10);
		}
		
	}

}
