[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/YmUJH1TE)
# Titlu proiect: Gestionare biblioteca
### Pop Raluca Daniela

## Descriere
Pentru un utilizator obisnuit aceata aplicatie reprezinta un sitem de rezervare si imprumut carti de la o biblioteca. Dupa ce un utilizator are creat un cont de cititor, acesta poate rezerva un exemplar al cartii dorite, din acel moment, exemplarul respectiv nu va putea fi imprumutat sau rezervat de catre o alta persoana timp de 2 zile, astfel, in acest timp cititorul poate sa mearga la biblioteca si sa imprumute exemplarul respectiv avand siguranta ca acesta este disponibil.
Pentru un utilizator cu rolul de bliotecar, aplicatia are rol administrativ oferind utilizatorului posibilitatea de a creaa conturi de utilizator pentru cititori, de a realiza imprumuturi si retururi, de a adauga exemplare si carti noi in sistem, dar si de a revizui rezervarile facute de catre cititori.
## Motivatie
Aceasta aplicatie vine in ajutorul persoanelor care doresc sa imprumute o anumita carte de la biblioteca, insa inainte de a merge fizic si a imprumuta cartea, acestia pot sa verifice daca exista un exemplar disponibil si sa faca o rezervare pentru acesta.
## Arhitectura

![diagrama clase](documentatie-ghid-utlizare-raport/diagramaClase.png)


## Functionalitati/Exemple utilizare
* Exista doua roluri in intermediu aplicatiei: cititor sau bibliotecar.
  <img src="documentatie-ghid-utlizare-raport/main.PNG" width="350" height="230">

* Pentru autentificare in cont se verifica credentialele de login, daca acestea nu sunt corecte, atunci utilizatorul va primi un mesaj de eroare.
<img src="documentatie-ghid-utlizare-raport/loginCititor.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/eroare_auth.PNG" width="350" height="230">

* Un utilizator cu rol de cititor poate sa verifice daca o anumita carte este disponibila in biblioteca si sa faca o rezervare pentru aceasta. 
<img src="documentatie-ghid-utlizare-raport/actiuni_cititor.PNG" width="350" height="230">
* pentru a realiza o rezervare, acesta trebuie sa introduca titlul si autorul cartii pe care doreste sa o rezerve. Daca se gaseste cartea dorita, se va afisa o lista de carti din care trebuie sa aleaga id-ul cartii pe care o doreste. Daca cartea nu este disponibila, sau id-ul cartii este gresit(nu se regaseste in lista de carti afisata anterior) atunci cititorul va primi un mesaj de eroare cerandu-i-se acestuia sa aleaga un alt id.
<img src="documentatie-ghid-utlizare-raport/rezervac.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/alege_id_carte_rez.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/alege_id_carte_rez_err.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/rezervac_succes.PNG" width="350" height="230">


* De asemenea, un cititor poate sa anuleze o rezervare. Se va afisa o lista cu toate rezervarile pe care acesta le are, si va trebui sa aleaga id-ul exemplarului pentru care doreste sa anuleze rezervarea. Daca id-ul nu este corect, atunci va primi un mesaj de eroare
<img src="documentatie-ghid-utlizare-raport/anulare_rez.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/anulare_rez_succes.PNG" width="350" height="230">
  

* Un utilizator cu rol de bibliotecar poate realiza imprumuturi si retunari de carti pentru utilizatorii cu rol de cititor. Acesta poate adauga carti sau exemplare noi in baza de date, dar si sa creeze conturi noi de utilizator pentru cititori sau alti bibliotecari
<img src="documentatie-ghid-utlizare-raport/bibliotecar.PNG" width="350" height="230">

* Dupa intrarea in cont, utilizatorul poate sa aleaga una dintre opiunile de mai jos:
<img src="documentatie-ghid-utlizare-raport/actiuni_bibliotecar.PNG" width="350" height="230">

* Adaugare carte noua- daca bibliotecarul alege aceasta optiune, atunci acesta va fi redirectionat catre o alta pagina unde va putea introduce informatii despre noua carte pe care doreste sa o adauge in biblioteca. Pentru aceasta, va trebui sa specifice id-ul cartii, titlu, autorul, genul cartii si numarul de zile pentru care un cititor poate imprumuta cartea. Id-ul cartii trebuie sa fie unic, daca exista deja o carte cu id-ul introdus, atunci se va primi un mesaj aferent.
<img src="documentatie-ghid-utlizare-raport/adauga_carte.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/adauga_carte_err.PNG" width="350" height="230">

* Adauga un exemplar in biblioteca- pentru a adauga un nou exemplar in biblioteca, bibliotecarul trebuie sa specifice id-ul cartii aferente. Daca id-ul este gresit(daca nu exista nici o carte cu id-ul specificat), bibliotecarul va primi un mesaj aferet. De asemena, id-urile exemplarelor trebuie sa fie unice, daca se inroduce un id de exemplar care deja exista(apartine altui exemplar), atunci se va afisa un mesaj aferent.
<img src="documentatie-ghid-utlizare-raport/adauga_exemplar.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/id_exemplar_invalid_add_ex.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/id_carte_invalid_add_ex.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/adauga_exemplar_succes.PNG" width="350" height="230">

* Creaza un cont de utilizator pentru un cititor. Va trebui sa se introduca CNP-ul cititorului, numele cititorului, numarul de telefon si parola de la cont. Daca CNP-ul nu are lungimea coresounzatoare, sau este deja folosit(exista de un cont de cititor care foloseste acest cnp) se vor afisa mesaje aferente.
<img src="documentatie-ghid-utlizare-raport/adauga_cititor.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/cnp_lungime_incorecta.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/adauga_cititor_err.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/adauga_cititor_succes.PNG" width="350" height="230">

* Realizeaza un imprumut -alegand aceasta optiune, un bibliotecar va putea realiza un imprumut pentru un cititor. Acesta va trebui sa specifice titlul si autorul cartii dorite. Apoi, se va afisa o lista de carti, bibliotecarul va trebui sa aleaga din lista id-ul cartii pe care doreste sa o imprumute pentru cititor, si cnp-ul cititorului. Daca id-ul cartii sau cnp-ul cititorului nu sunt valide, atunci se va afisa un mesaj de eroare.
<img src="documentatie-ghid-utlizare-raport/alege_carte_pt_imp.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/eroare_id_carte_invalid_imp.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/eroare_cnp_invalid_imp.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/imprumut_succes.PNG" width="350" height="230">

* Realizeaza un retur - alegand aceasta optiune, un bibliotecar poate sa realizeze un retur pentru o carte imprumutata de catre un cititor. Acesta trebuie sa introduca cnp-ul cititorului, daca cnp-ul este incorect(nu exista nu cont asociat acelui cnp), atunci va primi un mesaj de eroare. Se va genere o lista cu toate exemplarele imprumutate de catre cititorul respeciv, iar apoi va trebui sa se aleaga id-ul exemplarului pe are doreset sa il returneze. Daca id-ul este incorect(nu se regaseste in lista de exemplare) atunci se va afisa un mesaj specific.

<img src="documentatie-ghid-utlizare-raport/retur_scriere_cnp.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/retur_alege_id.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/retur_eroare_id.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/retur_succes.PNG" width="350" height="230">


* Revizuieste rezervarile - alegand aceasta optiune, se vor revizui automat toate rezervarile de carti facute de catre cititori. Daca o rezervare este mai veche de doua zile, atunci aceasta va fi stearsa din lista de rezervari.
<img src="documentatie-ghid-utlizare-raport/revizuieste_rezervari.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/revizuieste_rezervari_succes.PNG" width="350" height="230">

* Creaza cont de bibliotecar - alegand aceasta optiune, un bibliotecar poate sa creeze un cont de bibliotecar pentru un nou angajat. Acesta trebuie sa introduca id-ul de angajat al noului bibliotecar, numele acestuia, adresa de e-mail, numarul de telefon si o parola pentru contul acestuia. Cum id-urile sunt unice, daca acesta incearca sa introduca un id care deja exista va primi un mesaj de eroare.
<img src="documentatie-ghid-utlizare-raport/creaza_cont_biblio.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/creaza_cont_biblio_id_incorect.PNG" width="350" height="230">
<img src="documentatie-ghid-utlizare-raport/creaza_cont_biblio_succes.PNG" width="350" height="230">

<img src="documentatie-ghid-utlizare-raport/Diagrama-use-case.png" width="350" height="230">
## Tabele baza de data
<img src="documentatie-ghid-utlizare-raport/Tabele.png" width="350" height="230">
### Resurse
Markdown Guide, [Online] Available: https://www.markdownguide.org/basic-syntax/ [accesed: Mar 14, 1706]
# proiectP3
