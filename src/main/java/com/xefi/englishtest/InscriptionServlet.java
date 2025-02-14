package com.xefi.englishtest;

import com.xefi.englishtest.pojos.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "inscriptionServlet", value = "/inscription")
public class InscriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String erreurs = "";
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String date = req.getParameter("date");
        String telephone = req.getParameter("telephone");
        String sexe = req.getParameter("sexe");
        String pays = req.getParameter("pays");
        String password = req.getParameter("password");
        String confirmationPassword = req.getParameter("confirmation_password");

        if(nom.isEmpty()){
            erreurs += "Le champ nom est vide<br>";
        }
        if(prenom.isEmpty()){
            erreurs += "Le champ prenom est vide<br>";
        }
        if(email.isEmpty()){
            erreurs += "Le champ email est vide<br>";
        }
        if(date.isEmpty()){
            erreurs += "Le champ date est vide<br>";
        }
        if(telephone.isEmpty()){
            erreurs += "Le champ telephone est vide<br>";
        }
        if(sexe == null){
            erreurs += "Le champ sexe est vide<br>";
        }
        if(password.isEmpty()){
            erreurs += "Le champ password est vide<br>";
        }
        if(confirmationPassword.isEmpty()){
            erreurs += "Le champ password confirmation est vide<br>";
        }
        if(!password.equals(confirmationPassword)){
            erreurs += "La confirmation password != password";
        }

        if(erreurs.isEmpty()){
            Member member = new Member(nom, prenom, email, LocalDate.parse(date), telephone, sexe, pays, password);
            session.setAttribute("member", member);
            resp.sendRedirect("/confirmation");
        }else{
            req.setAttribute("erreurs", erreurs);
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
        }
    }
}