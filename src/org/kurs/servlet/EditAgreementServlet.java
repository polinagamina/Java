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
 
import org.kurs.beans.Agreement;
import org.kurs.utils.DBUtils;
import org.kurs.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/editAgreement" })
public class EditAgreementServlet  extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	    public EditAgreementServlet() {
	        super();
	    }
	 
	    // Отобразить страницу редактирования договора.
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection conn = MyUtils.getStoredConnection(request);
	 
	        String id = (String) request.getParameter("id");
	 
	        Agreement agreement = null;
	 
	        String errorString = null;
	 
	        try {
	            agreement = DBUtils.findAgreement(conn, id);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	 
	        // Ошибки не имеются.
	        //  Договор не существует для редактирования (edit).
	        
	        if (errorString != null && agreement == null) {
	            response.sendRedirect(request.getServletPath() + "/agreementList");
	            return;
	        }
	 
	        // Сохранить информацию в request attribute перед тем как forward к views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("agreement", agreement);
	 
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/editAgreementView.jsp");
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
	        String kind = (String) request.getParameter("kind");
	        String type = (String) request.getParameter("type");
	        String price = (String) request.getParameter("price");
	        
	        Agreement agreement= new Agreement (FIO, Service, price, type, kind,id);
	 
	        String errorString = null;
	 
	        try {
	            DBUtils.updateAgreement(conn, agreement);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        // Сохранить информацию в request attribute перед тем как forward к views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("agreement", agreement);
	 
	        // Если имеется ошибка, forward к странице edit.
	        if (errorString != null) {
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/editAgreementView.jsp");
	            dispatcher.forward(request, response);
	        }
	        // Если все хорошо.
	        // Redirect к странице со списком договоров.
	        else {
	            response.sendRedirect(request.getContextPath() + "/agreementList");
	        }
	    }
}