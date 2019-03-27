package com.evry.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormHandler extends HttpServlet {
	
	public static TestForm tf;
	public static FormHandlerDao fdao=new FormHandlerDao();
	public static boolean flag;

	  protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			tf=new TestForm();
			tf.setName(req.getParameter("patient_name"));
			tf.setAge(Integer.parseInt(req.getParameter("age")));
			tf.setBloodgroup(req.getParameter("blood_group"));
			tf.setCheckup(req.getParameter("checkup"));
			tf.setDoctorname(req.getParameter("doctor_name"));
			tf.setTestrecom(req.getParameter("Test"));
			
//			System.out.println(patientname+" "+age+" "+bloodgroup+" "+checkup+" "+doctor_name+" "+test);
			
			flag=fdao.submitForm(tf);
			
if(flag) {
		pw.println("Hi..."+req.getParameter("patient_name")+" your form  has been successfully submitted.<br>");
		pw.print("Plesae click the button below to verify the form that's been  submitted <br><br> "
				+ "<form action=\"/Hospital/viewform\" method=\"get\">"
				+ "Name :<input type=\"text\" name=\"name\"><br><button type=\"submit\">Check</button></form>");
}

else
	pw.println("Something went wrong . plese try again");
			 pw.close();

		}
	  
	  protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
		  System.out.println("Hello you entered into get method");
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			System.out.println(req.getParameter("name"));
			
			tf=fdao.viewFormData(req.getParameter("name"));
			
			pw.println("<h1>Form data Submitted:</h1>");
           pw.println("<form><table><tr><th>Name</th><th>Age</th><th>Blood_Group</th><th>Checkup_type</th><th>Doctor_Name</th><th>Test_Recommended</th></tr>"
           		+ "<tr><td>"+tf.getName()+"</td><td>"+tf.getAge()+"</td><td>"+tf.getBloodgroup()+"</td><td>"+tf.getCheckup()+"</td><td>"+tf.getDoctorname()+"</td><td>"+tf.getTestrecom()+"</td></tr></table></form>");
		
		}
}
