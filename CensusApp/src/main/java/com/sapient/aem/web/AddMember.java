package com.sapient.aem.web;



import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.log4j.Logger;
import com.sapient.aem.model.FamilyMember;
import com.sapient.aem.model.Gender;
import com.sapient.aem.model.Relation;
import com.sapient.aem.model.Suffix;
import com.sapient.aem.service.FamilyMemberService;
import com.sapient.aem.service.FamilyMemberServiceImpl;




@WebServlet("/addmember")
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;




	private FamilyMemberService familyMemberService=new FamilyMemberServiceImpl();
	private Logger logger= Logger.getLogger(AddMember.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {

			String firstName=request.getParameter("firstname");
			String lastName=request.getParameter("lastname");
			String gender=request.getParameter("gender");
			Gender myGender = null;
			if(gender.equals("MALE")) {
				myGender = Gender.MALE;
			}else if(gender.equals("FEMALE")) {
				myGender = Gender.FEMALE;
			}else {
				myGender = Gender.OTHER;
			}
			String mySuffix=request.getParameter("suffix");
			Suffix suffix=null;

			if(mySuffix.equals("MISS")) {
				suffix=Suffix.MISS;
			}
			else if(mySuffix.equals("MRS")) {
				suffix=Suffix.MRS;
			}
			else if(mySuffix.equals("DR")) {
				suffix=Suffix.DR;
			}
			else {
				suffix=Suffix.MR;
			}
			LocalDate birthdate=LocalDate.parse(request.getParameter("birthdate"));
			String qualification[]=request.getParameterValues("qualification");
			String profession=request.getParameter("profession");
			String hobbies[]=request.getParameterValues("hobbies");

			String myRelation=request.getParameter("relation");
			Relation relation=null;

			if(myRelation.equals("WIFE")) {
				relation=Relation.WIFE;
			}
			else if(myRelation.equals("DAUGHTER")) {
				relation=Relation.DAUGHTER;
			}
			else if(myRelation.equals("SON")) {
				relation=Relation.SON;
			}

			String address =request.getParameter("address");
			String location=request.getParameter("location");
			String email=request.getParameter("email");
			Long mobile=Long.parseLong(request.getParameter("mobile"));
			Integer familyHeadId=Integer.parseInt(request.getParameter("familyHeadId"));

			FamilyMember member=new FamilyMember(firstName,lastName,myGender,suffix,birthdate,qualification,profession,hobbies,relation,address,location,email,mobile,familyHeadId);
			Integer familyMemberid= familyMemberService.addFamilyMember(member);
			if(familyMemberid !=null) {
				out.println("<html><body><h2><font color='green'>"+"Successfully Added!!"+"Your Id is: "+familyMemberid+"</font></h2></body></html>");
				
			}else {
				request.getRequestDispatcher("WEB-INF/views/error.jsp");
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}



}




