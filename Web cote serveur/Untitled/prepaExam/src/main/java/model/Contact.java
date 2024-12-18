package model;

//bean : classe publique
public class Contact implements Comparable<Contact> {
	
	//bean : des propriétés (attributs) privées
	private String name;
    private String phone;
    private String email;
    
    //bean : un constructeur par défaut
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    //bean : Avec des méthodes publiques, appelées getter et setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //éviter les doublons
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Vérifie si c'est le même objet
        if (obj == null || getClass() != obj.getClass()) return false; // Vérifie la compatibilité
        Contact contact = (Contact) obj;
        return phone.equals(contact.phone); // Comparaison basée sur le numéro de téléphone
    }

    // compareTo pour trier par nom (ordre alphabétique)
    @Override
    public int compareTo(Contact other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}
