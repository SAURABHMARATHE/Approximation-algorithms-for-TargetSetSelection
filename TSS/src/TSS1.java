

public class TSS1 {

	public void algo1(Integer[] vertices,Integer[][] edges, int total_no_of_nodes) {
		// TODO Auto-generated method stub

		
		Integer[] seed1=new Integer[total_no_of_nodes];       //seed set 1
		Integer[] seed2=new Integer[total_no_of_nodes];       //seed set 2

		//we will assign hunger for each vertex
		Integer[] hunger=new Integer[total_no_of_nodes];
		//now we will define beta as maximum degree of any vertex
		int beta=0;
		Integer[] potentialbeta=new Integer[total_no_of_nodes];
		for (int i=0;i<total_no_of_nodes;i++)
			hunger[i]=0;
		for (int i=0;i<total_no_of_nodes;i++)
			potentialbeta[i]=0;
		//we will define hunger as number vertices that are neighbours of each vertex
		for(int p=0;p<total_no_of_nodes;p++)
		{
			for(int q=0;q<total_no_of_nodes;q++)
			{
				if(edges[p][q]==1)
					hunger[p]++;
			}
		}
		
		
		
		//phase 1 of algorithm
		//fix beta as maximum degree of a vertex in the graph, this is my modification
		for(int l=0;l<total_no_of_nodes;l++)
		{
			for(int m=0;m<total_no_of_nodes;m++)
			{
				if(edges[l][m]==1)
					beta++;
			}
			potentialbeta[l]=beta;
			beta=0;
		}
		
		//find maximum among potentialbeta and assign it to beta
		for(int n=0;n<total_no_of_nodes;n++)
		{
			if(beta<potentialbeta[n])
			{
				beta=potentialbeta[n];
			}
		}

		//System.out.println("hjjkhfsk"+beta);
		//find seed set 1
		for(int n=0;n<total_no_of_nodes;n++)
		{
			if(beta==potentialbeta[n])
			{
				seed1[n]=n;
				potentialbeta[n]=-1;
				hunger[n]=-1;
			}
			else
				seed1[n]=-1;
		}
		
		//phase 2 begins
		//initialize seed2
		for(int s=0;s<total_no_of_nodes;s++)
		{
			seed2[s]=-1;
		}
		int round=347;
		while(checkForHunger(hunger,round)==true)
		{
				
			//hunger is readjusted for each vertex that is not chosen
			for(int p=0;p<total_no_of_nodes;p++)
			{
				for(int q=0;q<total_no_of_nodes;q++)
				{
					if(edges[p][q]==1&&seed1[q]!=-1&&seed1[p]==-1&&seed2[p]==-1)
					{
						hunger[p]--;
						potentialbeta[p]--;
						edges[p][q]=-1;
						edges[q][p]=-1;
					}
					if(edges[p][q]==1&&seed2[q]!=-1&&seed1[p]==-1&&seed2[p]==-1)
					{
						hunger[p]--;
						potentialbeta[p]--;
						edges[p][q]=-1;
						edges[q][p]=-1;
					}	
				}
			}
			
			//redefine beta
			beta=redefineBeta(potentialbeta);
			if(beta==0)
				break;
			
			
			for(int r=0;r<total_no_of_nodes;r++)
			{
				if(beta==potentialbeta[r])
				{
					seed2[r]=r;
					potentialbeta[r]=-1;
					hunger[r]=-1;
				}
			}
			
			System.out.println("round:-"+round);
			System.out.println("new beta:-"+beta);
			System.out.println("new hunger");
			for(int i=0;i<total_no_of_nodes;i++)
			{
				System.out.println(hunger[i]);
			}
			System.out.println("seed2");
			for(int i=0;i<total_no_of_nodes;i++)
			{
				if(seed2[i]!=-1)
				System.out.println(vertices[seed2[i]]);
			}
			round--;
		}
		int finalcount=0;
		System.out.println("TSS is:-");
		for(int x=0;x<total_no_of_nodes;x++)
			if(seed1[x]!=-1)
			{
				System.out.print(vertices[seed1[x]]+" , ");
				finalcount++;
			}
		for(int y=0;y<total_no_of_nodes;y++)
			if(seed2[y]!=-1)
			{
				System.out.print(vertices[seed2[y]]+" , ");
				finalcount++;
			}
		System.out.println();
		System.out.println();
		System.out.println("Total no of nodes in graph:-"+total_no_of_nodes);
		System.out.println();
		System.out.println("No of nodes in TSS(algo1):-"+finalcount);
		System.out.println();
	}

static int redefineBeta(Integer[] potentialbeta)
{
	int beta=0;

	for(int n=0;n<potentialbeta.length;n++)
	{
		if(beta<potentialbeta[n])
		{
			beta=potentialbeta[n];
		}
		System.out.println(n+1+"->"+potentialbeta[n]);
	}
	//System.out.println(beta);
	return beta;
}

static boolean checkForHunger(Integer[] hunger,int round)
{
	for(int v=0;v<hunger.length;v++)
	{
		if(hunger[v]>0&&round>0)
			return true;
	}
	return false;
}
}
