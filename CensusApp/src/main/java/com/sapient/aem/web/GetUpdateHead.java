package com.sapient.aem.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.service.FamilyHeadService;
import com.sapient.aem.service.FamilyHeadServiceImpl;

/**
 * Servlet implementation class GetUpdateHead
 */
@WebServlet("/update-head")
public class GetUpdateHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private Logger logger= Logger.getLogger(GetUpdateHead.class);
	private FamilyHeadService familyHeadService=new FamilyHeadServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer familyHeadId= Integer.parseInt(request.getParameter("id"));
			FamilyHead familyHead= familyHeadService.getFamilyHeadById(familyHeadId);
			request.setAttribute("familyHead", familyHead);

			request.getRequestDispatcher("WEB-INF/views/edit-head.jsp")
			.forward(request, response);

			}catch(Exception e) {
			logger.error(e.getMessage(), e);
			}
		
		
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
