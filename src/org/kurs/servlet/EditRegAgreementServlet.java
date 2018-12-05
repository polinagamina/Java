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
 
@WebServlet(urlPatterns = { "/editRegAgreement" })
public class EditRegAgreementServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
    public EditRegAgreementServlet() {
        super();
    }
 
    // Отобразить страницу редактирования договора.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String id = (String) request.getParameter("id");
 
        RegAgreement regagreement = null;
 
        String errorString = null;
 
        try {
            regagreement = DBUtils.findRegAgreement(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // Ошибки не имеются.
        //  Договор не существует для редактирования (edit).
        
        if (errorString != null && regagreement == null) {
            response.sendRedirect(request.getServletPath() + "/regagreementList");
            return;
        }
 
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("regagreement", regagreement);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editRegAgreementView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // После того, как пользователь отредактировал информацию продукта и нажал на Submit.
    // Данный метод будет выполнен.
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
 
        try {
            DBUtils.updateRegAgreement(conn, regagreement);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("regagreement", regagreement);
 
        // Если имеется ошибка, forward к странице edit.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editRegAgreementView.jsp");
            dispatcher.forward(request, response);
        }
        // Если все хорошо.
        // Redirect к странице со списком договоров.
        else {
            response.sendRedirect(request.getContextPath() + "/regagreementList");
        }
    }
}
