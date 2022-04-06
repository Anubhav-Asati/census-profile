package com.sapient.aem.web;

import java.io.IOException;
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
 * Servlet implementation class GetFamilyHead
 */
@WebServlet("/getfamilyhead")
public class GetFamilyHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FamilyHeadService familyHeadService=new FamilyHeadServiceImpl();
	private Logger logger= Logger.getLogger(GetFamilyHead.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer familyHeadId= Integer.parseInt(request.getParameter("familyHeadId"));
			FamilyHead familyhead= familyHeadService.getFamilyHeadById(familyHeadId);
			if(familyhead != null) {
				//store employee object in request object
				request.setAttribute("familyhead", familyhead);
				logger.info(familyhead);
				request.getRequestDispatcher("WEB-INF/views/show-family-head.jsp")
				.forward(request, response);		
			}else {
				request.setAttribute("message", "Invalid familyHeadId");
				request.getRequestDispatcher("WEB-INF/views/status.jsp")
				.forward(request, response);
			}

		}catch(CensusProfileException e) {
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
