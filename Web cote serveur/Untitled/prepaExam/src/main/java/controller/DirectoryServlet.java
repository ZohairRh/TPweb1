package controller;

import model.DirectoryManager;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/directory")
public class DirectoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DirectoryManager directoryManager;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        directoryManager = new DirectoryManager();
       
        String filePath = getServletContext().getRealPath("/WEB-INF/lib/contacts.txt");
        directoryManager.loadContactsFromFile(filePath); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        if ("new".equals(page)) {
            request.getRequestDispatcher("/WEB-INF/new_contact.jsp").forward(request, response);
        } else {
            // Ajouter le répertoire comme attribut de requête
            request.setAttribute("contacts", directoryManager.getContacts());
            // Transférer vers la page JSP
            request.getRequestDispatcher("/WEB-INF/directory.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les informations du formulaire
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        // Utiliser DirectoryManager pour ajouter le contact
        boolean success = directoryManager.addContact(name, phone, email);

        if (success) {
            // Si l'ajout est réussi, rediriger vers directory.jsp
            response.sendRedirect("directory");
        } else {
            // Si l'ajout échoue, rediriger vers new_contact.jsp avec un message d'erreur
            request.setAttribute("errorMessage", "Les informations saisies sont invalides. Veuillez réessayer.");
            request.getRequestDispatcher("/WEB-INF/new_contact.jsp").forward(request, response);
        }
    }
}
