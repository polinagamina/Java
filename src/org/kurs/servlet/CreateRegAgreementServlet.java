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


import org.kurs.beans.RegAgreement;
import org.kurs.utils.DBUtils;
import org.kurs.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/createRegAgreement" })
public class CreateRegAgreementServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
    public CreateRegAgreementServlet() {
        super();
    }
 
    // Отобразить страницу создания договора.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createRegAgreementView.jsp");
        dispatcher.forward(request, response);
    }
 
    // Когда пользователь вводит информацию продукта, и нажимает Submit.
    // Этот метод будет вызван.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String id = (String) request.getParameter("id");
        String Data = (String) request.getParameter("Data");
        String FIO = (String) request.getParameter("FIO");
        String OI = (String) request.getParameter("OI");
        String type = (String) request.getParameter("type");
        String kind = (String) request.getParameter("kind");
        
       
        RegAgreement regagreement= new RegAgreement (FIO,Data,OI, type, kind, id);
 
        String errorString = null;
 
        // Кодом договора является строка [a-zA-Z_0-9]
        // Имеет минимум 1 символ.
        //String regex = "\\w+";
 
        if (id == null ) {
            errorString = "RegAgreement id invalid!";
        }
 
        if (errorString == null) {
            try {
                DBUtils.insertRegAgreement(conn, regagreement);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("regagreement", regagreement);
 
        // Если имеется ошибка forward (перенаправления) к странице 'edit'.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createRegAgreementView.jsp");
            dispatcher.forward(request, response);
        }
        // Если все хорошо.
        // Redirect (перенаправить) к странице со списком договоров.
        else {
            response.sendRedirect(request.getContextPath() + "/regagreementList");
        }
    }
}