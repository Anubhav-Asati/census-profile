package com.sapient.aem.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.model.FamilyMember;
import com.sapient.aem.model.Gender;
import com.sapient.aem.model.Relation;
import com.sapient.aem.model.Suffix;
import com.sapient.aem.service.FamilyMemberService;
import com.sapient.aem.service.FamilyMemberServiceImpl;

/**
 * Servlet implementation class UpdateMember
 */
@WebServlet("/updatemember")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FamilyMemberService familyMemberService=new FamilyMemberServiceImpl();
	private Logger logger= Logger.getLogger(UpdateMemberServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer familyMemberId= Integer.parseInt(request.getParameter("familyMemberId"));
			FamilyMember familyMember= familyMemberService.getFamilyMemberById(familyMemberId);
			String firstName=request.getParameter("first_name");
			String lastName=request.getParameter("last_name");
			String gender=request.getParameter("gender");
			Gender myGender=null;
			if(gender.equals("MALE")) {
				myGender = Gender.MALE;
			}else if(gender.equals("FEMALE")) {
				myGender = Gender.FEMALE;
			}else {
				myGender = Gender.OTHER;
			}
			
			String suffix= request.getParameter("suffix");
			Suffix mySuffix=null;
			
			if(suffix.equals("MISS")) {
				mySuffix=Suffix.MISS;
			}
			else if(suffix.equals("MRS")) {
				mySuffix=Suffix.MRS;
			}
			else if(suffix.equals("DR")) {
				mySuffix=Suffix.DR;
			}
			else {
				mySuffix=Suffix.MR;
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

			String address=request.getParameter("address");
			String location=request.getParameter("location");
			String email=request.getParameter("email");
			
			Long mobile=Long.parseLong(request.getParameter("mobile"));
			Integer familyHeadId=Integer.parseInt(request.getParameter("familyHeadId"));
			familyMemberService.updateFamilyMember(familyMember);
			request.getRequestDispatcher("WEB-INF/views/update.jsp")
			.forward(request, response);
		}
		catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
