package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectoryManager {
    private List<Contact> contacts;

    // Constructeur
    public DirectoryManager() {
        this.contacts = new ArrayList<>();
    }

    // Charger les contacts depuis un fichier
    public void loadContactsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); 
                if (parts.length == 3) { 
                    String name = parts[0].trim();
                    String phoneNumber = parts[1].trim();
                    String email = parts[2].trim();
                    addContact(name, phoneNumber, email); 
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    // Ajouter un contact
    public boolean addContact(String name, String phone, String email) {
        // Crée un objet Contact
        Contact contact = new Contact(name, phone, email);

        // Vérifie si le contact existe déjà (en fonction du numéro de téléphone)
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            Collections.sort(contacts); // Trie les contacts par ordre alphabétique
            return true; // Contact ajouté
        }
        return false; // Contact déjà existant
    }

    // Méthode pour récupérer la liste triée des contacts
    public List<Contact> getContacts() {
        return contacts;
    }
}
