package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.CensusProfileException;
import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.service.FamilyHeadService;
import com.sapient.aem.service.FamilyHeadServiceImpl;

/**
 * Servlet implementation class DeleteFamilyHeadServlet
 */
@WebServlet("/deletefamilyhead")
public class DeleteFamilyHeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FamilyHeadService familyHeadService=new FamilyHeadServiceImpl();
	private Logger logger= Logger.getLogger(DeleteFamilyHeadServlet.class);
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		try {
			Integer familyHeadId=Integer.parseInt(request.getParameter("familyHeadId"));
			familyHeadService.deleteFamilyHead(familyHeadId);
			
			out.println("<html><body><h2><font color='red'>"+familyHeadId + " is deleted"+"</font></h2></body></html>");
			
			//request.getRequestDispatcher("WEB-INF/views/delete-headid.jsp");
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
