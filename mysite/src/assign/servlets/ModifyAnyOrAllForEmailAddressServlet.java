package assign.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/**
 * Servlet implementation class ModifyAnyOrAllForEmailAddressServlet
 */
public class ModifyAnyOrAllForEmailAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyAnyOrAllForEmailAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String errors ="";
		
		String firstName = request.getParameter("fName");
		String middleName = request.getParameter("mName");
		String lastName = request.getParameter("lName");
		String workPhone = request.getParameter("wPhone");
		String mobilePhone = request.getParameter("mPhone");
		String homePhone = request.getParameter("hPhone");
		String groupId = request.getParameter("groupId");
		
		EMailAddressVOO emailAddressVoo = (EMailAddressVOO) request.getSession().getAttribute("emailVO");
		
		if(firstName != null && ! (firstName.equals(""))) {
			emailAddressVoo.setfName(firstName);
			
		}
		
		if(middleName != null && ! (middleName.equals(""))) {
			emailAddressVoo.setmName(middleName);
			
		}
		
		if(lastName != null && ! (lastName.equals(""))) {
			emailAddressVoo.setlName(lastName);
			
		}
		if(workPhone != null && ! (workPhone.equals(""))) {
			emailAddressVoo.setwPhone(workPhone);
			
		}
		
		if(mobilePhone != null && ! (mobilePhone.equals(""))) {
			emailAddressVoo.setmPhone(mobilePhone);
			
		}
		
		if(homePhone != null && ! (homePhone.equals(""))) {
			emailAddressVoo.sethPhone(homePhone);
			
		}
		
		if(groupId != null && ! (groupId.equals(""))) {
			emailAddressVoo.setgroupID(groupId);
			
		}
		
		try {
    		EMailBO eMailBO = new EMailBO();
    		eMailBO.updateEMailAddress(emailAddressVoo);
		} catch (EMailValidationException e) {
			errors = e.getErrorMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		if (errors.equals("")) {
			response.sendRedirect("/mysite/home.jsp");
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/modifycontact.jsp");
		}
    	
    }
	
	

}
