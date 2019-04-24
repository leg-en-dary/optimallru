import java.util.Scanner;

public class OPtimal_page_new 
{
	String ref="";
	char frame[];
	int pf;
	int hit;
	int fc=0;
	int size=0;
	Scanner scan = new Scanner(System.in);
	
	public static void main(String args[])
	{
		OPtimal_page_new obj =new OPtimal_page_new();
		obj.accept();
		obj.optimal();
	}
	
	public void accept()
	{
		System.out.println("Enter the ref. string :-");
		ref=scan.next();
		System.out.println("Enter the frame size :-");
		size=scan.nextInt();
		
		frame= new char[size];
	}
	
	public boolean search(char ch)
	{
		for(int i=0;i<size;i++)
		{
				char temp=frame[i];
				if(temp==ch)
				{
					return true;	
				}			
		}		
		return false;
	}
	
	public int future(char ch,int pos)
	{
			int result=ref.length()+1; 
			for(int i=pos+1;i<ref.length();i++)
			{
				char temp=ref.charAt(i);
				if(temp==ch)
				{
						if(i<result)
						{
								result=i;
						}
				}
			}
			return result;
	}
	
	public void optimal()
	{
		int n=ref.length();
		System.out.println("Enter the ref size:"+n);
		for(int i=0;i<n;i++)
		{
			char ch=ref.charAt(i);
			
			if(search(ch))
			{
				hit++;
			}
			else
			{
				System.out.println("Page fault :-"+i);
				pf++;
				
				if(fc<size)
				{
					frame[fc]=ch;
					fc++;
				}
				else
				{
						int optimal[]=new int [size];
					
						for(int j=0;j<size;j++)
						{
							optimal[j]=future(frame[j],i);							
						}
					
						int index=0;
						int max=optimal[0];
						
						for(int j=1;j<size;j++)
						{
							if(optimal[j]>max)
							{
								max=optimal[j];
								index=j;
							}				
						}					
						System.out.println("and page "+frame[index]+"\tIs repaced by "+ch);
						frame[index]=ch;						
				}				
				System.out.println("");
			}			
		}
		System.out.println("No of page fault :"+pf);
	}
}
