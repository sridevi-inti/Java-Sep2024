package assign.servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get All Email Addresses by Group Servlet 
 */

public class GetAllEMailListbyGroupServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	String errors = "";
	String groupID = request.getParameter("GroupId");
        response.setContentType("text/html");

	EMailBO eMailBO = new EMailBO();
	//ArrayList eMailAddress = null;

	ArrayList<EMailAddressVOO> eMailAddress = null;

	try{
	    //ArrayList emailAddress = eMailBO.getAllEMailAddressListbyGroup(groupID);
		System.out.println("groupID is: "+ groupID);
		eMailAddress = eMailBO.getAllEMailAddressListbyGroup(groupID);

	}catch (EMailValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
		request.getSession().setAttribute("emailList", eMailAddress);	
		response.sendRedirect("/mysite/viewbygroupsuccess.jsp");
		//response.sendRedirect("/mysite/viewallcontactsuccess.jsp");

	}
	else {
		request.getSession().setAttribute("Errors", errors);
		response.sendRedirect("/mysite/viewbygroup.jsp");
	}
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

