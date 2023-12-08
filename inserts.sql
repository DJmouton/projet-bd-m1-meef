drop table FILM ;
drop table PRIX_LOCATION ;
drop table CLIENT ;
drop table ABONNE ;
drop table HISTORIQUE ;
drop table LOCATIONS ;

create table FILM (
    id_film number ,
    titre varchar2 ,
    realisateur varchar2 ,
    acteur_principal varchar2 ,
    popularite number ,
    genre varchar2 ,
    age number ,
    qr-code boolean ,
    constraint FILM_C1 primary key (id_film)
);

create table SUPPORT (
    id_support number ,
    bluray boolean ,
    id_film number ,
    constraint SUPPORT_C1 primary key (id_support),
    constraint SUPPORT_C2 foreign key (id_film) references FILM(id_film)
);

create table PRIX_LOCATION (
    abonnement boolean ,
    prix number ,
    constraint PRIX_LOCATION_C1 primary key (abonnement),
    constraint PRIX_LOCATION_C2 check (prix in (4,5))
);

create table CLIENT (
    id_client number ,
    cb number ,
    constraint CLIENT_C1 primary key (id_client)
);

create table ABONNE (
    id_client number ,
    nom varchar2 ,
    prenom varchar2,
    date_naissance date ,
    adresse varchar2 ,
    montant number ,
    gele boolean ,
    constraint ABONNE_C1 primary key (id_client),
    constraint ABONNE_C2 foreign key (id_client) references CLIENT(id_client)
);

create table LOCATIONS (
    id_client number ,
    id_film number ,
    support varchar2 ,
    date_location date ,
    constraint LOCATIONS_C1 primary key (id_client),
    constraint LOCATIONS_C2 primary key (id_film),
    constraint LOCATIONS_C3 foreign key (id_client) references CLIENT(id_client) ,
    constraint LOCATIONS_C4 foreign key (id_film) references FILM(id_film) ,
    constraint LOCATIONS_C5 check (support in ('qr-code','blu-ray'))
);

commit ;

insert into FILM values (1, 'Salut les copines', 'Valerie Damidot', 'Valerie Damidot', 0, 'Drame', 10, true);
insert into FILM values (2, 'Disparition au Habbo Hotel', 'Michel Houellebecq', 'Sean Connery', 0, 'Polar', 13, true);
insert into FILM values (3, 'Renaissance Park', 'Quentin Tarantino', 'Lena Situations', 0, 'Film historique', 0, true);
insert into FILM values (4, 'Douchebag', 'Emmanuel Micron', 'Karine Leclerc', 0, 'Dystopie', 18 , true);
insert into FILM values (5, "La congolexicomatisation des especes endemiques de l'ile d'Ouessant", 'Commandant Cousteau', 'Habib Dunant', 0, 'Reportage', 4, true);
insert into FILM values (6, 'Douche froide sous les tropiques', 'Ange Doume', 'Quentin Tarantino', 0, 'Drame', 12, true);
insert into FILM values (7, 'Renaissance Park 2', 'Quentine Tarantino', 'Lena Situations', 0, 'Film historique', 18, true);
insert into FILM values (8, 'Dormir dans la soupe', 'Louis de Funes', 'Dany Brillant', 0, 'Comedie', 10, true);
insert into FILM values (9, "Soulager les douleurs hemorroidaires grace a l'injection de jus de concombre", 'Michel Cymes', 'Valerie Damidot', 0, 'Reportage', 63, true);
insert into FILM values (10, 'Lent et tout mims avec du miel et des tricycles', 'Le Caillou', 'Sylvain Vilebrequin', 0, 'Course automobile', 14, true);

insert into ABONNE values (1, 'Denis', 'Grognard', 1995-10-26, '1 Rue de la Poste, 59320 Hallennes Lez Haubourdin', 29, false)
insert into ABONNE values (2, 'Pascale', 'Legitime' 1845-02-07, '256 Avenue Fochent, 38160 Chatte', 42, false);
insert into ABONNE values (3, 'Damidot', 'Valerie' 2002-06-11, '9 Impasse de Monavenir, 23600 Saint-Silvain Bas le Roc', 5, false);
insert into ABONNE values (4, 'Corinne', 'David-Souris', 2010-07-23, "44 Chemin d'Oustres, 58470 Saincaize Meauce", 88, false);
insert into ABONNE values (5, 'Travis', 'Scout', 1473-12-30, '5841 Chemin de Chelieu, 27680 Vieux Port', 13, false);
insert into ABONNE values (6, 'Frabice', 'Jaounot', 1966-08-07, "624 Rue de l'Oracle, 62142 Bellebrune", 9999, false);
insert into ABONNE values (7, 'Herve', 'Djomb', 1975-02-14, '458 Passage sous les arbres, 85320 Les Pineaux', 124, false);
insert into ABONNE values (8, 'Monique', 'Vlan', 2004-11-12, '74 Avenue Dranche, 93170 Bagnolet', 7, false);
insert into ABONNE values (9, 'Gabine', 'Tronche', 1582-09-30, "4 Privet Drive, Placard sous l'escalier, 72350 Brulon", 16, false);
insert into ABONNE values (10, 'Francis', 'Cabri', 1953-11-22, '8 Rue des Soupirs, 47000 Agen', 35, false);