import java.lang.String;
import java.util.Scanner;

class MAX_VAL
{
	public static int MAX_SUB = 10;
	public static int MAX_STU = 20;
	public static int CUR_SUB_CSE = 0;
	public static int CUR_SUB_ECE = 0;
	public static int CUR_SUB_IT = 0;
	public static int MAX_SUB_CSE = 10;
	public static int MAX_SUB_ECE = 10;
	public static int MAX_SUB_IT = 10;
	public static int CUR_STU = 0;
}


class Student 
{
	String sName,sEmail,sDOB;
	String lPhone;
	Dept dDept = new Dept();
	public void DisplayStu()
	{
		System.out.println(sName+" "+sEmail+" "+sDOB+" "+lPhone +" "+ dDept.sDeptName);
	}
}

class Dept extends MAX_VAL
{
	String sDeptName;
	String sSub[] = new String [MAX_SUB];
	
	void getDept(String dept)
	{
		sDeptName = dept;
	}
	
	void addSub(String str)
	{
		Scanner s=new Scanner(System.in);
		if (str.equals("CSE"))
		{
			sSub[CUR_SUB_CSE] = s.nextLine();
			CUR_SUB_CSE++;
		}
		else if (str.equals("ECE"))
		{
			sSub[CUR_SUB_ECE]=s.nextLine();
			CUR_SUB_ECE++;
		}
		else if (str.equals("IT"))
		{
			sSub[CUR_SUB_IT]=s.nextLine();	
			CUR_SUB_IT++;
		}
	}
	void DisplaySub() {
		
		System.out.print (sDeptName + " ");
		for(int i=0;i<sSub.length;i++) {
			if (sSub[i]!=null)
				System.out.print (sSub[i]+" ");
		}
	}
}

class Test_Student_Portal extends MAX_VAL{
	
	Student sStudent[] = new Student[MAX_STU];
	Dept dDept[] = new Dept[3];
	
	
	void addStudent(Dept dept)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Name: ");
		String sName=s.nextLine();
		System.out.println("Enter Email: ");
		String sEmail=s.nextLine();
		System.out.println("Enter DOB: ");
		String sDOB=s.nextLine();
		System.out.println("Enter Phone: ");
		String sPhone=s.nextLine();
		
		Student stu = new Student();
		stu.sName = sName;
		stu.sEmail = sEmail;
		stu.sDOB = sDOB;
		stu.lPhone = sPhone;
		stu.dDept = dept;
		sStudent[CUR_STU] = stu;
		CUR_STU++;
	}
	
	
	void populateDept()
	{
		dDept[0] = new Dept();
		dDept[1] = new Dept();
		dDept[2] = new Dept();
		
		dDept[0].sDeptName = "CSE";
		dDept[0].sSub[0] = "OS";
		dDept[0].sSub[1] = "C";
		dDept[0].sSub[2] = "C++";
		CUR_SUB_CSE  = 3;

		dDept[1].sDeptName = "ECE";
		dDept[1].sSub[0] = "ADC";
		dDept[1].sSub[1] = "DPSD";
		dDept[1].sSub[2] = "DSP";
		CUR_SUB_ECE  = 3;
		
		dDept[2].sDeptName = "IT";
		dDept[2].sSub[0] = "OS";
		dDept[2].sSub[1] = "Java";
		dDept[2].sSub[2] = "SE";
		CUR_SUB_IT  = 3;
	
	}
	void populateStudent()
	{
		sStudent[0] = new Student();
		sStudent[1] = new Student();
		sStudent[2] = new Student();
		
		sStudent[0].sName = "Ram";
		sStudent[0].sEmail = "ram@gmail.com";
		sStudent[0].sDOB = "11/12/98";
		sStudent[0].lPhone = "9445678906";
		sStudent[0].dDept = dDept[0];    //CSE
		
		sStudent[1].sName = "Raman";
		sStudent[1].sEmail = "raman@gmail.com";
		sStudent[1].sDOB = "11/10/98";
		sStudent[1].lPhone = "9445678905";
		sStudent[1].dDept = dDept[1];
		
		sStudent[2].sName = "Ramani";
		sStudent[2].sEmail = "ramani@gmail.com";
		sStudent[2].sDOB = "11/11/98";
		sStudent[2].lPhone = "9445675906";
		sStudent[2].dDept = dDept[2];
		CUR_STU = 3;
	}
	
	void viewStudent(String str)
	{
		try {
		for(int i=0;i<sStudent.length;i++) 
			if (sStudent[i].dDept.sDeptName == str)
				sStudent[i].DisplayStu();
		}catch(Exception e) {System.out.println(e);}
		
	}
	void viewSub(String str)
	{
		if (str == "CSE")
			dDept[0].DisplaySub();
		else if (str== "ECE")
			dDept[1].DisplaySub();
		else if (str== "IT")
		     dDept[2].DisplaySub();
	}
	void ViewAll() {
		for(int i=0;i<CUR_STU;i++) {
			sStudent[i].DisplayStu();
			System.out.println("");
			}
		for(int i=0;i<3;i++) {
			dDept[i].DisplaySub();
			System.out.println("");
			}
	}
	void vExecution()
	{   
		String a;
		populateDept();
		populateStudent();
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to College Portal");
		do {
		System.out.println("Please Select the Department 1.CSE 2.ECE 3.IT");
		String dept=s.nextLine();
		
		switch(dept) {
		case "CSE":{
			       System.out.println("Select the option on Course 1.Add 2.View ");
				   String op=s.nextLine();
				   switch(op) {
				   case "Add":
					  
					   System.out.println("Where do u want to add  1.Sub 2.Stu");
					   String ch=s.nextLine();
					   switch(ch) {
					   case "Sub":
						   Dept d = dDept[0];
						   if(CUR_SUB_CSE<MAX_SUB_CSE) {
							   d.addSub("CSE");
						   }
						   viewSub("CSE");
						   
						   break;
					   case "Stu":
						   d = dDept[0];
						   if(CUR_STU<20) {
							   addStudent(d);
						   }
						   viewStudent("CSE");
					       break;
					   }
					   break;
				   case "View":
					   {
						   System.out.println("Where do u want to add  1.Sub 2.Stu");
						    ch=s.nextLine();
						   switch(ch) {
						   case "Sub":
							   viewSub("CSE");
							   break;
						   case "Stu":
							   viewStudent("CSE");
							   break;
						   }
					   }
		              		break;
				   		default: System.out.println("");
				            break;
				        }
		          }
					break;
		
		case "ECE":{
			       System.out.println("Select the option on Course 1.Add 2.View ");
			       String op = s.nextLine();
		           switch(op) {
		           case "Add":
		        	   System.out.println("Where do u want to add  1.Sub 2.Stu");
					   String ch=s.nextLine();
					   switch(ch) {
					   case "Sub":
						   Dept d = dDept[1];
						   if(CUR_SUB_ECE<MAX_SUB_ECE) {
							   d.addSub("ECE");
						   }
						   viewSub("ECE");
						   
						   break;
					   case "Stu":
						   d = dDept[1];
						   if(CUR_STU<20) {
							   addStudent(d);
						   }
						   
						   viewStudent("ECE");
						   break;
					   }			    	
			               break;
		           case "View":
				   {
					   System.out.println("Where do u want to add  1.Sub 2.Stu");
					    ch=s.nextLine();
					   switch(ch) {
					   case "Sub":
						   viewSub("ECE");
						   break;
					   case "Stu":
						   viewStudent("ECE");
						   break;
					   }
				   }
	            
           		   break;
		           default:System.out.println("");
					break;
		   
		           }
			break;
		}
					
		case "IT":{
			   
			   System.out.println("Select the option on Course 1.Add 2.View ");
			   String op=s.nextLine();
			   switch(op) {
			   case "Add":
				   System.out.println("Where do u want to add  1.Sub 2.Stu");
				   String  ch=s.nextLine();
				   switch(ch) {
				   case "Sub":
					   Dept d = dDept[2];
					   if(CUR_SUB_IT<MAX_SUB_IT) {
						   d.addSub("IT");
					   }
					   viewSub("IT");
					   
					   break;
				   case "Stu":
					   d = dDept[2];
					   if(CUR_STU<20) {
						   addStudent(d);
					   }
					   viewStudent("IT");
					   break;
				   }
				          break;
			   case "View":
			   {
				   System.out.println("Where do u want to add  1.Sub 2.Stu");
				    ch=s.nextLine();
				   switch(ch) {
				   case "Sub":
					   viewSub("IT");
					   break;
				   case "Stu":
					   viewStudent("IT");
					   break;
				   }
			   }
			   break;
            
			   default:System.out.println("");
				break;
			   
			   }
				break;
		}
		default:System.out.println("");
				break;
		}
		System.out.println(" ");
		System.out.println("Do you want to continue Y/N");
		a=s.nextLine();
		}while(a.equals("Y"));
	
		ViewAll();
	
	}

}

public class Student_Portal
{
	
	public static void main(String[] args) {
		
		//System.out.println("Main Program");
		Test_Student_Portal d = new Test_Student_Portal();
		d.populateDept();
		d.populateStudent();
		d.vExecution();
	
		}
}

