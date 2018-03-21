import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[][]= new String[6][3];
		int itr=3;
		Scanner input=new Scanner(System.in);
		for(int i=0;i<itr;i++) {
			System.out.println("Student "+(i+1)+" Details\n");
			System.out.println("Enter Student Name:\t");
			String name = input.nextLine();
			arr[i][0]=name;
			//REG NO Input
			
			System.out.println("Enter Registration Number:\t");
			String reg_no = input.nextLine();
			int reg=Integer.parseInt(reg_no);
			Boolean unique =false;
			while(!unique) {
				int j;
				Boolean found=false;
				for(j=0;j<i;j++) {
					if(reg==Integer.parseInt(arr[j][1]))
					{
						found=true;
						break;
					}
				}
				
				if(!found)
					unique=true;
				else {
					System.out.println("Reg No Already Exists, Enter Again:\t");
					reg_no = input.nextLine();
					reg=Integer.parseInt(reg_no);
				}
			}
			
			//CGPA Input
			System.out.println("Enter CGPA:\t");
			String cgpa = input.nextLine();
			float c=Float.parseFloat(cgpa);
			while(c<0 || c>4) {
				System.out.println("Invalid CGPA\n Enter Again");
				cgpa = input.nextLine();
				c=Integer.parseInt(cgpa);
			}
			
			
			arr[i][1]=reg_no;
			arr[i][2]=cgpa;
		}
		List<Float> list = new ArrayList<Float>();
		float sum=0;
		for(int i=0;i<itr;i++) {
			sum+=Float.parseFloat(arr[i][2]);
			list.add(Float.parseFloat(arr[i][2]));
		}
		float avg=sum/itr;
		float min = Collections.min(list);
		float max= Collections.max(list);
		
		System.out.println("Average CGPA is : "+avg+"\n");
		System.out.println("Minimum CGPA is : "+min+"\n");
		System.out.println("Maximum CGPA is : "+max+"\n");
		
		
		System.out.println("\n\tSTUDENTS WITH LESS THAN AVERAGE CGPA ARE\n");
		for(int i=0;i<itr;i++) {
			if(Float.parseFloat(arr[i][2])<avg) {
				System.out.println(arr[i][0]+"\n");
			}
		}
		
		
		//Search Box
		int i=1;
		while(i==1) {
			System.out.println("\n SEACRH STUDENT");
			
			System.out.println("\nPress (1) for Name , Press (2) For Reg No\t");
			int choice=input.nextInt();
			Boolean found=false;
			if(choice==1) {
				System.out.println("Enter Name");
				input.skip("[\r\n]+");
				String sname=input.nextLine();
				for(int j=0;j<itr;j++) {
					if(arr[j][0].equals(sname))
					{
						System.out.println("Student Found\n");
						System.out.println("Name :"+ arr[j][0]+"\t Reg No : "+arr[j][1]+"\t CGPA  : "+arr[j][2]);
						found=true;
						break;
					}
				}
			}
			
			else if(choice==2) {
				System.out.println("Enter Reg No\n");
				int reg=input.nextInt();
				for(int j=0;j<itr;j++) {
					if(reg==Integer.parseInt(arr[j][1]))
					{
						System.out.println("Student Found\n");
						System.out.println("Name :"+ arr[j][0]+"\t Reg No : "+arr[j][1]+"\t CGPA  : "+arr[j][2]);
						found=true;
						break;
					}
				}
			}
			else {
				System.out.println("\nENTER VALID QUERY\n");
			}
			
			if(!found) {
				System.out.println("STUDENT NOT PRESENT\n");
			}
			System.out.println("Want to Search Again, Press (1) , To Exit Press(0)");
			i=input.nextInt();
		}
		
	}

}
