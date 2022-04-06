package com.sapient.aem.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.model.FamilyMember;
import com.sapient.aem.service.FamilyHeadService;
import com.sapient.aem.service.FamilyHeadServiceImpl;
import com.sapient.aem.service.FamilyMemberService;
import com.sapient.aem.service.FamilyMemberServiceImpl;

/**
 * Servlet implementation class GetUpdateMember
 */
@WebServlet("/update-member")
public class GetUpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger logger= Logger.getLogger(GetUpdateHead.class);
	private FamilyMemberService familyMemberService=new FamilyMemberServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer familyMemberId= Integer.parseInt(request.getParameter("id"));
			FamilyMember familyMember= familyMemberService.getFamilyMemberById(familyMemberId);
			request.setAttribute("familyMember", familyMember);

			request.getRequestDispatcher("WEB-INF/views/edit-member.jsp")
			.forward(request, response);

			}catch(Exception e) {
			logger.error(e.getMessage(), e);
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
