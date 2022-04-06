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
import com.sapient.aem.service.FamilyHeadService;
import com.sapient.aem.service.FamilyHeadServiceImpl;


@WebServlet("/allfamilyhead")
public class AllFamilyHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FamilyHeadService familyHeadService= new FamilyHeadServiceImpl();
	private Logger logger= Logger.getLogger(AllFamilyHead.class);

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//fetch all employees from database into List
			List<FamilyHead> familyHeadList=  familyHeadService.getAllFamilyHeads();
			//Place employeeList object in request object
			request.setAttribute("familyHeadList", familyHeadList);
			//dispatch employeeList to show-all-emp.jsp
			request.getRequestDispatcher("WEB-INF/views/show-all-head.jsp")
										.forward(request, response);
			
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
