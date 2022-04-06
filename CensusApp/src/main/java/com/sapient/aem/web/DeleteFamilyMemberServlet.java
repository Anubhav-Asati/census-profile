package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.service.FamilyMemberService;
import com.sapient.aem.service.FamilyMemberServiceImpl;


@WebServlet("/deletefamilymember")
public class DeleteFamilyMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FamilyMemberService familyMemberService=new FamilyMemberServiceImpl();
	private Logger logger= Logger.getLogger(DeleteFamilyHeadServlet.class);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		try {
			Integer familyMemberId=Integer.parseInt(request.getParameter("familyMemberId"));
			familyMemberService.deleteFamilyMember(familyMemberId);
			out.println("<html><body><h2><font color='red'>"+familyMemberId + " is deleted"+"</font></h2></body></html>");
			//request.getRequestDispatcher("WEB-INF/views/delete-memberid.jsp");
		}
		catch(Exception e) {
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
