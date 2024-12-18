package com.zohair.controller;

import com.zohair.model.Contact;
import com.zohair.model.DirectoryManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/directory")  // Mappé sur /directory
public class DirectoryServlet extends HttpServlet {

    private DirectoryManager directoryManager;

    @Override
    public void init() throws ServletException {
        directoryManager = new DirectoryManager();
        
        // Charge les contacts depuis le fichier contacts.txt
        String filePath = getServletContext().getRealPath("/WEB-INF/contacts/contacts.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<Contact> initialContacts = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    initialContacts.add(new Contact(data[0].trim(), data[1].trim(), data[2].trim()));
                }
            }
            directoryManager.loadContacts(initialContacts);
        } catch (IOException e) {
            throw new ServletException("Erreur lors du chargement des contacts", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        // Si la page est 'new', afficher le formulaire d'ajout
        if ("new".equals(page)) {
            request.getRequestDispatcher("/new_contact.jsp").forward(request, response);
        } else {
            // Afficher la liste des contacts
            request.setAttribute("contacts", directoryManager.getContacts());
            request.getRequestDispatcher("/directory.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");

        // Créer un nouvel objet Contact
        Contact newContact = new Contact(firstName, lastName, phoneNumber);
        
        // Ajouter le contact à la liste en mémoire
        directoryManager.addContact(newContact);

        // Ajouter les informations du contact dans le fichier contacts.txt
        String filePath = getServletContext().getRealPath("/WEB-INF/contacts/contacts.txt");

        try (FileWriter writer = new FileWriter(filePath, true); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(firstName + "," + lastName + "," + phoneNumber + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServletException("Erreur d'écriture dans le fichier", e);
        }

        // Rediriger vers la page de la liste des contacts après ajout
        response.sendRedirect("directory");
    }
}
