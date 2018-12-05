package org.kurs.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kurs.beans.Request;
import org.kurs.utils.DBUtils;
import org.kurs.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/editRequest" })
public class EditRequestServlet  extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 
	    public EditRequestServlet() {
	        super();
	    }
	 
	    // Отобразить страницу редактирования договора.
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection conn = MyUtils.getStoredConnection(request);
	 
	        String id = (String) request.getParameter("id");
	 
	       Request request1 = null;
	 
	        String errorString = null;
	 
	        try {
	            request1 = DBUtils.findRequest(conn, id);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	 
	        // Ошибки не имеются.
	        //  Договор не существует для редактирования (edit).
	        
	        if (errorString != null && request1 == null) {
	            response.sendRedirect(request.getServletPath() + "/requestList");
	            return;
	        }
	 
	        // Сохранить информацию в request attribute перед тем как forward к views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("request1", request1);
	 
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/editRequestView.jsp");
	        dispatcher.forward(request, response);
	 
	    }
	 
	    // После того, как пользователь отредактировал информацию продукта и нажал на Submit.
	    // Данный метод будет выполнен.
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection conn = MyUtils.getStoredConnection(request);
	        
	        String id = (String) request.getParameter("id");
	        String FIO = (String) request.getParameter("FIO");
	        String Service = (String) request.getParameter("Service");
	        String Telephone = (String) request.getParameter("Telephone");
	        String Email = (String) request.getParameter("Email");
	        
	        Request request1= new Request (FIO,Service,Telephone,Email,id);
	        String errorString = null;
	 
	        try {
	            DBUtils.updateRequest(conn, request1);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        // Сохранить информацию в request attribute перед тем как forward к views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("request1", request1);
	 
	        // Если имеется ошибка, forward к странице edit.
	        if (errorString != null) {
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/editRequestView.jsp");
	            dispatcher.forward(request, response);
	        }
	        // Если все хорошо.
	        // Redirect к странице со списком договоров.
	        else {
	            response.sendRedirect(request.getContextPath() + "/requestList");
	        }
	    }
}
