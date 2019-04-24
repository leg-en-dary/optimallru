import java.util.ArrayList;
import java.util.Scanner;

public class LRU_page 
{
	public static void main(String args[])
	{
		int i,j,f,n,fault=0,hit=0;
		boolean isfull=false;
		int search=0,pointer=0;
		Scanner scan=new Scanner(System.in);
		
		ArrayList<Integer> stack = new ArrayList<Integer>();
		
		System.out.println("Enter frame size:");
		f=scan.nextInt();
		System.out.println("Enter total input string size:");
		n=scan.nextInt();
		int input[]=new int [n];
		int frame[]=new int [f];
		int result[][]=new int [n][f];

		System.out.println("Enter element in input string");
		
		for(i=0;i<n;i++)
		{
			input[i]=scan.nextInt();
		}
		
		for(i=0;i<f;i++)
		{
			frame[i]=-1;
		}
		
		for(i=0;i<n;i++)
		{
				if(stack.contains(input[i]))
				{
						stack.remove(stack.indexOf(input[i]));
				}
				stack.add(input[i]);
				search=-1;
				for(j=0;j<f;j++)
				{
					if(frame[j]==input[i])
					{
						hit++;
						search=j;
						break;
					}
				}
				if(search==-1)
				{
					if(isfull)
					{
							int min_loc=n;
							for(j=0;j<f;j++)
							{
									if(stack.contains(frame[j]))
									{
										int temp=stack.indexOf(frame[j]);
										if(temp<min_loc)
										{
											min_loc=temp;
											pointer=j;
										}
									}
							}								
					}
					
					frame[pointer]=input[i];
					fault++;
					pointer++;
					if(pointer==f)
					{	
						pointer=0;
						isfull=true;
					}	
				}
				
				for(j=0;j<f;j++)
				{
					result[i][j]=frame[j];
				}
		}		
		System.out.println("Table :");
		for(i=0;i<f;i++)
		{
			for(j=0;j<n;j++)
			{
				System.out.print(result[j][i]);
				System.out.print("\t");
			}
			System.out.println();
		}
		
		System.out.println("Total Hits :"+hit);
		System.out.println("Total page fault :"+fault);
				
	}
}









