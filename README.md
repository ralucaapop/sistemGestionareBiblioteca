[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/YmUJH1TE)
# Titlu proiect: Rezervare si imprumut carti
### Student Pop Raluca Daniela

## Descriere
Pentru un utilizator obisnuit aceata aplicatie reprezinta un sitem de rezervare si imprumut carti de la o biblioteca. Dupa ce un utilizator are creat un cont de cititor, acesta poate rezerva un exemplar al cartii dorite, din acel moment, exemplarul respectiv nu va putea fi imprumutat sau rezervat de catre o alta persoana timp de 2 zile, astfel, in acest timp cititorul poate sa mearga la biblioteca si sa imprumute exemplarul respectiv avand siguranta ca acesta este disponibil.
Pentru un utilizator cu rolul de bliotecar, aplicatia are rol administrativ oferind utilizatorului posibilitatea de a creaa conturi de utilizator pentru cititori, de a realiza imprumuturi si retururi, de a adauga exemplare si carti noi in sistem, dar si de a revizui rezervarile facute de catre cititori.
## Motivatie
Aceasta aplicatie vine in ajutorul persoanelor care doresc sa imprumute o anumita carte de la biblioteca, insa inainte de a merge fizic si a imprumuta cartea, acestia pot sa verifice daca exista un exemplar disponibil si sa faca o rezervare pentru acesta.
## Arhitectura

![diagrama clase](documentatie-ghid-utlizare-raport/diagramaClase.png)



## Functionalitati/Exemple utilizare
Exista doua roluri in intermediu aplicatiei: cititor sau bibliotecar.  
Un utilizator cu rol de cititor poate sa verifice daca o anumita carte este disponibila in biblioteca si sa faca o rezervare pentru aceasta. 
-pentru a realiza o rezervare, acesta trebuie sa introduca titlul si autorul cartii pe care doreste sa o rezerve.Daca se gaseste cartea dorita, se va afisa o lista de carti din care trebuie sa aleaga id-ul cartii pe care o doreste.
Daca cartea nu este disponibila, sau id-ul cartii este gresit(nu se regaseste in lista de carti afisata anterior) atunci cititorul va primi un mesaj de erare cerandu-i acestuia sa aleaga un alt id.
Un utilizator cu rol de bibliotecar poate realiza imprumuturi si retunari de carti pentru utilizatorii cu rol de cititor. Acesta poate adauga carti sau exemplare noi in baza de date. 
![diagrama usecase](documentatie-ghid-utlizare-raport/Diagrama-use-case.png)

## Tabele baza de data
![tabele](documentatie-ghid-utlizare-raport/Tabele.png)
### Resurse
Markdown Guide, [Online] Available: https://www.markdownguide.org/basic-syntax/ [accesed: Mar 14, 1706]
# proiectP3
