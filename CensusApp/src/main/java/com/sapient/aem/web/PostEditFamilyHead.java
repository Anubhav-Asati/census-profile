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

import com.sapient.aem.exception.CensusProfileException;
import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.model.Gender;
import com.sapient.aem.model.Suffix;
import com.sapient.aem.service.FamilyHeadService;
import com.sapient.aem.service.FamilyHeadServiceImpl;


@WebServlet("/post-edithead")
public class PostEditFamilyHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(PostEditFamilyHead.class);
	private FamilyHeadService familyHeadService= new FamilyHeadServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		try {
			Integer familyHeadId= Integer.parseInt(request.getParameter("familyHeadId"));
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
			String suffix=request.getParameter("suffix");
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
			String address =request.getParameter("address");
			String location=request.getParameter("location");
			String email=request.getParameter("email");
			Long mobile=Long.parseLong(request.getParameter("mobile"));
			//Integer familyHeadId=Integer.parseInt(request.getParameter("familyHeadId"));
			FamilyHead head=new FamilyHead(firstName,lastName,myGender,mySuffix,birthdate,qualification,profession,hobbies,address,location,email,mobile);
		    familyHeadService.updateFamilyHead(head);
			request.getRequestDispatcher("allfamilyhead").include(request, response);
		}
		catch(CensusProfileException e) {
			logger.error(e.getMessage(),e);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
