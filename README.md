[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/YmUJH1TE)
# Titlu proiect: Rezervare si imprumut carti
### Pop Raluca Daniela

## Descriere
Pentru un utilizator obisnuit aceata aplicatie reprezinta un sitem de rezervare si imprumut carti de la o biblioteca. Dupa ce un utilizator are creat un cont de cititor, acesta poate rezerva un exemplar al cartii dorite, din acel moment, exemplarul respectiv nu va putea fi imprumutat sau rezervat de catre o alta persoana timp de 2 zile, astfel, in acest timp cititorul poate sa mearga la biblioteca si sa imprumute exemplarul respectiv avand siguranta ca acesta este disponibil.
Pentru un utilizator cu rolul de bliotecar, aplicatia are rol administrativ oferind utilizatorului posibilitatea de a creaa conturi de utilizator pentru cititori, de a realiza imprumuturi si retururi, de a adauga exemplare si carti noi in sistem, dar si de a revizui rezervarile facute de catre cititori.
## Motivatie
Aceasta aplicatie vine in ajutorul persoanelor care doresc sa imprumute o anumita carte de la biblioteca, insa inainte de a merge fizic si a imprumuta cartea, acestia pot sa verifice daca exista un exemplar disponibil si sa faca o rezervare pentru acesta.
## Arhitectura

![diagrama clase](documentatie-ghid-utlizare-raport/diagramaClase.png)



## Functionalitati/Exemple utilizare
Exista doua roluri in intermediu aplicatiei: cititor sau bibliotecar. 
![diagrama clase](documentatie-ghid-utlizare-raport/main.PNG)
* Pentru autentificare in cont se verifica credentialele de login, daca acestea nu sunt corecte, atunci utilizatorul va primi un mesaj de eroare.
![diagrama clase](documentatie-ghid-utlizare-raport/loginCititor.PNG)
![diagrama clase](documentatie-ghid-utlizare-raport/eroare_auth.PNG)

* Un utilizator cu rol de cititor poate sa verifice daca o anumita carte este disponibila in biblioteca si sa faca o rezervare pentru aceasta. 
![diagrama clase](documentatie-ghid-utlizare-raport/actiuni_cititor.PNG)
* pentru a realiza o rezervare, acesta trebuie sa introduca titlul si autorul cartii pe care doreste sa o rezerve. Daca se gaseste cartea dorita, se va afisa o lista de carti din care trebuie sa aleaga id-ul cartii pe care o doreste. Daca cartea nu este disponibila, sau id-ul cartii este gresit(nu se regaseste in lista de carti afisata anterior) atunci cititorul va primi un mesaj de eroare cerandu-i-se acestuia sa aleaga un alt id.
![diagrama clase](documentatie-ghid-utlizare-raport/rezervac.PNG)
![diagrama clase](documentatie-ghid-utlizare-raport/alege_id_carte_rez.PNG)
![diagrama clase](documentatie-ghid-utlizare-raport/alege_id_carte_rez_err.PNG)
![diagrama clase](documentatie-ghid-utlizare-raport/rezervac_succes.PNG)


* De asemenea, un cititor poate sa anuleze o rezervare. Se va afisa o lista cu toate rezervarile pe care acesta le are, si va trebui sa aleaga id-ul exemplarului pentru care doreste sa anuleze rezervarea. Daca id-ul nu este corect, atunci va primi un mesaj de eroare
  ![diagrama usecase](documentatie-ghid-utlizare-raport/anulare_rez.PNG)
  ![diagrama usecase](documentatie-ghid-utlizare-raport/anulare_rez_succes.PNG)
  

* Un utilizator cu rol de bibliotecar poate realiza imprumuturi si retunari de carti pentru utilizatorii cu rol de cititor. Acesta poate adauga carti sau exemplare noi in baza de date, dar si sa creeze conturi noi de utilizator pentru cititori sau alti bibliotecari
![diagrama usecase](documentatie-ghid-utlizare-raport/bibliotecar.PNG)
* Dupa intrarea in cont, utilizatorul poate sa aleaga una dintre opiunile de mai jos:
![diagrama usecase](documentatie-ghid-utlizare-raport/actiuni_bibliotecar.PNG)
* Adaugare carte noua- daca bibliotecarul alege aceasta optiune, atunci acesta va fi redirectionat catre o alta pagina unde va putea introduce informatii despre noua carte pe care doreste sa o adauge in biblioteca. Pentru aceasta, va trebui sa specifice id-ul cartii, titlu, autorul, genul cartii si numarul de zile pentru care un cititor poate imprumuta cartea. Id-ul cartii trebuie sa fie unic, daca exista deja o carte cu id-ul introdus, atunci se va primi un mesaj aferent.
![diagrama usecase](documentatie-ghid-utlizare-raport/adauga_carte.PNG)
![diagrama usecase](documentatie-ghid-utlizare-raport/adauga_carte_err.PNG)
* Adauga un exemplar in biblioteca- pentru a adauga un nou exemplar in biblioteca, bibliotecarul trebuie sa specifice id-ul cartii aferente. Daca id-ul este gresit(daca nu exista nici o carte cu id-ul specificat), bibliotecarul va primi un mesaj aferet. De asemena, id-urile exemplarelor trebuie sa fie unice, daca se inroduce un id de exemplar care deja exista(apartine altui exemplar), atunci se va afisa un mesaj aferent.
![diagrama usecase](documentatie-ghid-utlizare-raport/adauga_exemplar.PNG)
![diagrama usecase](documentatie-ghid-utlizare-raport/id_exemplar_invalid_add_ex.PNG)
![diagrama usecase](documentatie-ghid-utlizare-raport/id_carte_invalid_add_ex.PNG)



## Tabele baza de data
![tabele](documentatie-ghid-utlizare-raport/Tabele.png)
### Resurse
Markdown Guide, [Online] Available: https://www.markdownguide.org/basic-syntax/ [accesed: Mar 14, 1706]
# proiectP3
