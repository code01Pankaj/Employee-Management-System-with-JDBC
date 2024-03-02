package test;
import java.sql.*;
import java.util.*;
public class DBCon4 {
        public static void main(String[] args) {
	  Scanner s = new Scanner(System.in);
	  try(s;){
		  try {
			  Connection con = DriverManager.getConnection
			  ("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			  PreparedStatement ps1 = con.prepareStatement
					  ("insert into Employee54 values(?,?,?,?,?)");//compilation
			  
			  PreparedStatement ps2 = con.prepareStatement
					  ("select * from Employee54");//compilation
			  
			  PreparedStatement ps3 = con.prepareStatement
					  ("select * from Employee54 where eid=?");//compilation
			  
			  PreparedStatement ps4 = con.prepareStatement
    				   ("update Employee54 set ebsal=?,etotalsal=? where eid=?");
			  
			  PreparedStatement ps5 = con.prepareStatement
    				   ("delete from Employee54 where eid=?");

			  
    		   

			  while(true) {
				  System.out.println("***** Choice******");
				  System.out.println("\t1.AddEmployee"
						  + "\n\t2.ViewAllEmployees"
						  + "\n\t3.ViewEmployeeeById"
						  + "\n\t4.UpdateEmployeeById"
						  + "\n\t5.DeleteEmployeeById"
						  + "\n\t6.exit");
				   System.out.println("Enter the choice");
				   int choice = Integer.parseInt(s.nextLine());
				   switch(choice) {
				   case 1:
					   System.out.println("----EmployeeDetails----");
					   System.out.println("Enter EmpId");
					   String eId = s.nextLine();
					   System.out.println("Enter EmpName");
					   String eName = s.nextLine();
					   System.out.println("Enter EmpDesg");
					   String eDesg = s.nextLine();
					   System.out.println("Enter EmpbSal");
					   int bSal = Integer.parseInt(s.nextLine());
					   float totSal = bSal+(0.93F*bSal)+(0.63F*bSal);
					   ps1.setString(1, eId);
					   ps1.setString(2, eName);
					   ps1.setString(3, eDesg);
					   ps1.setInt(4, bSal);
					   ps1.setFloat(5, totSal);
					   
					   int k = ps1.executeUpdate();//Execution and Update
					   if(k>0) {
						  System.out.println("Employee Added Successfully");
						  }
					   
					   break;
				   case 2:
					   ResultSet rs = ps2.executeQuery();
					   while(rs.next()) {
						   System.out.println(rs.getString(1)+
								   "\t"+rs.getString(2)+
								   "\t"+rs.getString(3)+
								   "\t"+rs.getInt(4)+
								   "\t"+rs.getFloat(5));
					   }
					   
					   break;
				   case 3:
					   System.out.println("Enter the EmpId");
					   String eId2 = s.nextLine();
					   ps3.setString(1, eId2);
					   
					   ResultSet rs2 = ps3.executeQuery();
					   if(rs2.next()) {
					    System.out.println("Name:"+rs2.getString(2)
					    +"\nDesg:"+rs2.getString(3)
					    +"\nBSal:"+rs2.getInt(4)
					    +"\nTotSal:"+rs2.getFloat(5));
					    
					    }else {
					    	System.out.println("****Invalid EmpId****");
					    }
					   break;
				   case 4:
						  System.out.println("Enter the EmpId:");
	    				  String eId3 = s.nextLine();
	    				  ps3.setString(1, eId3);
	    				  ResultSet rs3 = ps3.executeQuery();
	    				  if(rs3.next()) {
	    					 System.out.println("Enter new bSal:");
	    					 int nBSal = Integer.parseInt(s.nextLine());
	    					 float nTotSal = nBSal+(0.93F*nBSal)+(0.63F*nBSal);
	    					 ps4.setInt(1, nBSal);
	    					 ps4.setFloat(2, nTotSal);
	    					 ps4.setString(3, eId3);
	    					 int k2 = ps4.executeUpdate();
	    					 if(k2>0) {
	    						 System.out.println("Employee Updated...");
	    					 }
	    					 
	    				  }else {
	    					  System.out.println("Invalid empId...");
	    				  }
	    				  break;
	    			  case 5:
	    				  System.out.println("Enter the empId:");
	    				  String eId4 = s.nextLine();
	    				  ps3.setString(1, eId4);
	    				  ResultSet rs4 = ps3.executeQuery();
	    				  if(rs4.next()) {
	    					 ps5.setString(1, eId4);
	    					 int k3 = ps5.executeUpdate();
	    					 if(k3>0) {
	    						 System.out.println("Employee deleted...");
	    					 }
	    				  }else {
	    					  System.out.println("Invalid empId...");
	    				  }
	    				  break;

	    				  
	    			  case 6:
	    				  System.out.println("Operations Stopped..");
	    				  System.exit(0);
	    			   default:
	    				   System.out.println("Invalid Choice...");

					   
				   
				   }//end of switch
				   
				   
			  }//end of loop
		  }catch(Exception e) {e.printStackTrace();}
	  }//end of try with resource

	}

}
