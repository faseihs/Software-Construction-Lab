
public class Comparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CommitOff comOf=new CommitOff();
		CommitOn comOn=new CommitOn();
		System.out.println("AUTO COMMIT OFF");
		System.out.println("\n");
		comOf.execute();
		System.out.println("\n");
		System.out.println("AUTO COMMIT OFF");
		System.out.println("\n");
		comOn.execute();
	}

}
