import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;


public class Controller2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			int total_no_of_nodes=-1;
			FileReader fr=new FileReader("C://Users//saura//Desktop//0.edges");
			FileReader fr2=new FileReader("C://Users//saura//Desktop//0.edges");
			BufferedReader br=new BufferedReader(fr);
			BufferedReader br2=new BufferedReader(fr2);
			String temp=" ";
			String[] temp_array=new String[2];
			while(temp!=null)
			{
				temp=br.readLine();
				if(temp!=null)
				{
				temp_array=temp.split(" ");
				int vertex1=Integer.parseInt(temp_array[0]);
				int vertex2=Integer.parseInt(temp_array[1]);
				if(total_no_of_nodes<vertex1)
				{
					total_no_of_nodes=vertex1;
				}
				if(total_no_of_nodes<vertex2)
				{
					total_no_of_nodes=vertex2;
				}
				}
			}
			br.close();
			Integer[] vertices=new Integer[total_no_of_nodes];    //array storing vertices
			Integer[][] edges=new Integer[total_no_of_nodes][total_no_of_nodes]; //array storing edges
			for(int i=0;i<total_no_of_nodes;i++)
				vertices[i]=i+1;
			for(int j=0;j<total_no_of_nodes;j++)
				for(int k=0;k<total_no_of_nodes;k++)
				{
					edges[j][k]=0;
				}			
			temp=" ";
			while(temp!=null)
			{
				temp=br2.readLine();
				if(temp!=null)
				{
				temp_array=temp.split(" ");
				int vertex1=Integer.parseInt(temp_array[0]);
				int vertex2=Integer.parseInt(temp_array[1]);
				edges[vertex1-1][vertex2-1]=1;
				edges[vertex2-1][vertex1-1]=1;
				}
			}			
			br2.close();
			
				int choice=-1;
				
				System.out.println("Total no of nodes in graph:-"+total_no_of_nodes);
				BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please choose which algorithm to run?(1/2):-");
				
					choice=Integer.parseInt(br3.readLine());
				
					
				if (choice==1)
				{
					TSS1 tss1=new TSS1();
					long time1=System.currentTimeMillis();
					tss1.algo1(vertices, edges,total_no_of_nodes);
					long time2=System.currentTimeMillis();
					System.out.println("Computation time:-"+(time2-time1)+"ms");
				}
				else
				{
					TSS2 tss2=new TSS2();
					long time3=System.currentTimeMillis();
					tss2.algo2(vertices, edges, total_no_of_nodes);
					long time4=System.currentTimeMillis();
					System.out.println("Computation time:-"+(time4-time3)+"ms");
				}
				
				}
				catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	}

}
