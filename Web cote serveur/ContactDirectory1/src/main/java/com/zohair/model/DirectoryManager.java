package com.zohair.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DirectoryManager {
    private List<Contact> contacts;

    public DirectoryManager() {
        this.contacts = new ArrayList<>();
    }

    // Ajouter un contact et trier la liste
    public void addContact(Contact contact) {
        contacts.add(contact);
        sortContacts();
    }

    // Trier les contacts par nom et prénom
    private void sortContacts() {
        contacts.sort(Comparator.comparing(Contact::getLastName).thenComparing(Contact::getFirstName));
    }

    // Obtenir la liste des contacts
    public List<Contact> getContacts() {
        return contacts;
    }

    // Charger les contacts depuis une liste
    public void loadContacts(List<Contact> initialContacts) {
        contacts.addAll(initialContacts);
        sortContacts();
    }
}
