import scpsolver.constraints.LinearBiggerThanEqualsConstraint;
import scpsolver.constraints.LinearSmallerThanEqualsConstraint;
import scpsolver.lpsolver.*;
import scpsolver.lpsolver.GLPKSolver;
import scpsolver.problems.LPSolution;
import scpsolver.problems.LPWizard;
import scpsolver.problems.LinearProgram;
public class TSS2 {

	public void algo2(Integer[] vertices,Integer[][] edges,int total_no_of_nodes) {
		// TODO Auto-generated method stub
		Double[] hunger=new Double[total_no_of_nodes];
		for(int p=0;p<total_no_of_nodes;p++)
		{
			hunger[p]=0.0;
			for(int q=0;q<total_no_of_nodes;q++)
			{
				if(edges[p][q]==1)
					hunger[p]++;
			}
		}
		try{
		
		String[] variables=new String[total_no_of_nodes];
		for(int i=0;i<total_no_of_nodes;i++)
		{
			variables[i]="x"+vertices[i];
			System.out.println("q->"+variables[i]);
		}
		
		LPWizard lpw = new LPWizard();
		
		for(int j=0;j<total_no_of_nodes;j++)
		{
		lpw.plus(variables[j],hunger[j]);
		System.out.println("Hunger is"+hunger[j]);
		}
		
		String constraint_identity="c";
		int counter=0;
		for(int j=0;j<total_no_of_nodes;j++)
		{
			for(int k=0;k<total_no_of_nodes;k++)
			{
				if(edges[j][k]==1)
				{
//					counter++;
//					constraint_identity=constraint_identity+counter;
//					lpw.addConstraint(constraint_identity,1,"=").plus(variables[j],1.0).plus(variables[k],1.0);
//					edges[k][j]=-1;
//					edges[j][k]=-1;
//					constraint_identity="c";
					
					//
					counter++;
					if(hunger[j]>hunger[k])
					{
						constraint_identity=constraint_identity+counter;
						lpw.addConstraint(constraint_identity,hunger[j],">=").plus(variables[j],hunger[j]).plus(variables[k],hunger[k]);
						edges[k][j]=-1;
						edges[j][k]=-1;
					}
					else if(hunger[j]<hunger[k])
					{
						constraint_identity=constraint_identity+counter;
						lpw.addConstraint(constraint_identity,hunger[k],">=").plus(variables[j],hunger[j]).plus(variables[k],hunger[k]);
						edges[k][j]=-1;
						edges[j][k]=-1;
					}
					else
					{
						constraint_identity=constraint_identity+counter;
						lpw.addConstraint(constraint_identity,2*hunger[k],">=").plus(variables[j],hunger[j]).plus(variables[k],hunger[k]);
						edges[k][j]=-1;
						edges[j][k]=-1;
					}
					constraint_identity="c";
				}
			}
		} 
		counter=0;
		for(int i=0;i<total_no_of_nodes;i++)
		{
			counter++;
			constraint_identity=constraint_identity+counter;
			lpw.addConstraint(constraint_identity, 1, ">=").plus(variables[i],1.0);
			constraint_identity="c";
		}
		 		
		lpw.setMinProblem(false);
		LPSolution lps=lpw.solve();
		
		int total_nodes_in_tss=0;
		for(int i=0;i<total_no_of_nodes;i++)
		{

			if(lps.getDouble(variables[i])>=0.5)
			{
				total_nodes_in_tss++;
			}
		}
		System.out.println();
		System.out.println("Total no of nodes in graph:-"+total_no_of_nodes);
		System.out.println();
		System.out.println("No of nodes in TSS(algo2) is:-"+total_nodes_in_tss);
	    System.out.println();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
//	public static void main(String[] args)
//	{
//		Integer[] vertices=new Integer[10];
//		Integer[][] edges=new Integer[10][10];
//		for(int i=0;i<10;i++)
//		{
//			vertices[i]=i+1;
//		}
//		for(int i=0;i<10;i++)
//		{
//			for(int j=0;j<10;j++)
//			{
//				edges[i][j]=0;
//			}
//		}
//		
//		TSS2 tss2=new TSS2();
//		tss2.algo2(vertices,edges,10);
//	}
}
