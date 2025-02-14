package com.xefi.englishtest;

import com.xefi.englishtest.pojos.Joueur;
import com.xefi.englishtest.pojos.Ville;
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
        String password = req.getParameter("password");
        String idville = req.getParameter("ville");

        // appel fonction dao getter id
        Ville ville = new Ville("15", "ville1");
        if(nom.isEmpty()){
            erreurs += "Le champ nom est vide<br>";
        }
        if(prenom.isEmpty()){
            erreurs += "Le champ prenom est vide<br>";
        }
        if(email.isEmpty()){
            erreurs += "Le champ email est vide<br>";
        }
        if(password.isEmpty()){
            erreurs += "Le champ password est vide<br>";
        }

        if(erreurs.isEmpty()){
            Joueur joueur = new Joueur(email, nom, prenom, password, ville, "0");
            session.setAttribute("joueur", joueur);
            resp.sendRedirect("/jeu");
        }else{
            req.setAttribute("erreurs", erreurs);
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(req, resp);
        }
    }
}