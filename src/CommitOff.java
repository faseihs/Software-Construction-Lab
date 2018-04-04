import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.*;
import java.lang.*;

public class CommitOff {
	public void execute() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "root");
			con.setAutoCommit(false);
            String samplename="faseih";
			String address="Room ";
			Statement stmt = con.createStatement();
			long startTime=System.nanoTime();
			for (int i=0;i<5000;i++) {
				String name=samplename+i;
				String addr=address+i;
				String query="INSERT INTO student VALUES('"+name+"',"+i+",6"+",'"+addr+"');";
				stmt.executeUpdate(query);
				
			}
			con.commit();
			long endTime=System.nanoTime();
			long totalTime=endTime-startTime;
			System.out.println("The Execution Time When AutoCommit is off (Statement Class) is " +totalTime/1000000 +" ms");
			
			PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM student");
            preparedStatement.executeUpdate();
            
            
            startTime=System.nanoTime();
            for (int i=0;i<5000;i++) {
				String name=samplename+i;
				String addr=address+i;
				String query="INSERT INTO student VALUES(name=?,reg_no=?,semester=?,address=?);";
				PreparedStatement prp=con.prepareStatement(query);
				prp.setString(1, name);
				prp.setInt(2, i);
				prp.setInt(3, 6);
				prp.setString(4, addr);
				prp.executeUpdate();
				
			}
            con.commit();
			endTime=System.nanoTime();
			totalTime=endTime-startTime;
			System.out.println("The Execution Time When AutoCommit is off (Prepared Class) is " +totalTime/1000000+" ms");

			preparedStatement.executeUpdate();
			
			startTime=System.nanoTime();
			Statement stm = con.createStatement();
			for (int i=0;i<5000;i++) {
				String name=samplename+i;
				String addr=address+i;
				String query="INSERT INTO student VALUES('"+name+"',"+i+",6"+",'"+addr+"');";
				stm.addBatch(query);
			}
			startTime=System.nanoTime();
			stm.executeBatch();
			con.commit();
			endTime=System.nanoTime();
			totalTime=endTime-startTime;
			System.out.println("The Execution Time When AutoCommit is off (Batch Update) is " +totalTime/1000000+" ms");
			preparedStatement.executeUpdate();
			
		}
		
		catch(Exception ex) {
			System.out.println("The Error is " +ex.getMessage());
		}
	}

}
