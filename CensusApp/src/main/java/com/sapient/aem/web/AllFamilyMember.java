package com.sapient.aem.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.CensusProfileException;
import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.model.FamilyMember;
import com.sapient.aem.service.FamilyHeadService;
import com.sapient.aem.service.FamilyHeadServiceImpl;
import com.sapient.aem.service.FamilyMemberService;
import com.sapient.aem.service.FamilyMemberServiceImpl;

/**
 * Servlet implementation class AllFamilyMember
 */
@WebServlet("/allfamilymember")
public class AllFamilyMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FamilyMemberService familyMemberService= new FamilyMemberServiceImpl();
	private Logger logger= Logger.getLogger(AllFamilyMember.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//fetch all employees from database into List
			List<FamilyMember> familyMemberList=  familyMemberService.getAllFamilyMembers();
			//Place employeeList object in request object
			request.setAttribute("familyMemberList", familyMemberList);
			//dispatch employeeList to show-all-emp.jsp
			request.getRequestDispatcher("WEB-INF/views/show-all-member.jsp")
										.forward(request, response);
			
		}catch(CensusProfileException e) {
			logger.error(e.getMessage(),e);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
