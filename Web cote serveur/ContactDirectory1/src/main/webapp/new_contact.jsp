<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Nouveau Contact</title>
</head>
<body>
    <h1>Ajouter un Contact</h1>
    <form method="post" action="directory">
        <label>Pr�nom: <input type="text" name="firstName" required></label><br><br>
        <label>Nom: <input type="text" name="lastName" required></label><br><br>
        <label>T�l�phone: <input type="text" name="phoneNumber" required></label><br><br>
        <button type="submit">Ajouter</button>
    </form>
    <br>
    <a href="directory">Retour � la liste des contacts</a><br>
    <a href="index.html">Retour � l'accueil</a>
</body>
</html>
