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
 
@WebServlet(urlPatterns = { "/createRequest" })
public class CreateRequestServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public CreateRequestServlet() {
        super();
    }
 
    // Отобразить страницу создания договора.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createRequestView.jsp");
        dispatcher.forward(request, response);
    }
 
    // Когда пользователь вводит информацию продукта, и нажимает Submit.
    // Этот метод будет вызван.
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
 
        // Кодом договора является строка [a-zA-Z_0-9]
        // Имеет минимум 1 символ.
        //String regex = "\\w+";
 
        if (id == null ) {
            errorString = "Request id invalid!";
        }
 
        if (errorString == null) {
            try {
                DBUtils.insertRequest(conn, request1);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("request1", request1);
 
        // Если имеется ошибка forward (перенаправления) к странице 'edit'.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createRequestView.jsp");
            dispatcher.forward(request, response);
        }
        // Если все хорошо.
        // Redirect (перенаправить) к странице со списком договоров.
        else {
            response.sendRedirect(request.getContextPath() + "/requestList");
        }
    }
}