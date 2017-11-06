package com.ag.controller;

import com.ag.bean.UserBean;
import com.ag.beanI.UserBeanI;
import com.ag.model.User;
import com.xag.util.MailObject;
import com.xag.util.SendMailTLS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Logger log = LoggerFactory.getLogger(UserBean.class);

    @Inject
    UserBeanI beanI;

    MailObject mo = null;

    private MailObject getMailObject() {
        return (this.mo == null) ? new MailObject() : mo;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("========ag beanI "+beanI);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = beanI.authenticate(username, password);

        HttpSession session = request.getSession();
        if (user != null) {
            /*switch (user.getRole()) {
                case ADMIN: {
                    session.setAttribute("user_c", user.getId());
                    session.setAttribute("user_a", user.getId());
                    response.sendRedirect("a");
                    break;
                }
                case MANAGEMENT: {
                    session.setAttribute("user_c", user.getId());
                    response.sendRedirect("shop");
                    break;
                }
                case ORGANIZER: {
                    session.setAttribute("user_c", user.getId());
                    session.setAttribute("user_t", user.getId());
                    response.sendRedirect("t");
                    break;
                }
                default: {
                    session.setAttribute("usersession", user.getId());
                    response.sendRedirect("shop");
                    break;
                }
            }*/
        } else {
            MailObject mo1 = getMailObject();
            mo1.setTo(username);
            mo1.setMessageSubject("Login Attempt");
            mo1.setMessageBody("Was this you?");
            request.setAttribute("message", SendMailTLS.sendMail(mo1)
                    ? "Invalid Credentials. Try again or check your email for additional information!"
                    : "Invalid Credentials. Try again"
            );
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}
