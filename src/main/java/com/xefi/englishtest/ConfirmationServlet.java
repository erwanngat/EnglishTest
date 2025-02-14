package com.xefi.englishtest;

import com.xefi.englishtest.pojos.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "confirmationServlet", value = "/confirmation")
public class ConfirmationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Member member = (Member) session.getAttribute("member");

        req.setAttribute("member", member);
        this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(req, resp);
    }
}