package com.xefi.englishtest;

import com.xefi.englishtest.dao.VerbeDao;
import com.xefi.englishtest.pojos.Verbe;
import com.xefi.englishtest.utilities.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "indexServlet", urlPatterns = {"", "/index"})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VerbeDao verbeDao = new VerbeDao();
        List<Verbe> verbes = verbeDao.findAll();

        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}