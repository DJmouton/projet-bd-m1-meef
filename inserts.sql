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

insert into FILM values (1, 'Salut les copines', 'Valérie Damidot', 'Valérie Damidot', 0, 'Drame', 10, true)
insert into FILM values (2, 'Disparition au Habbo Hotel', 'Michel Houellebecq', 'Sean Connery', 0, 'Polar', 13, true)
insert into FILM values (3, 'Renaissance Park', 'Quentin Tarantino', 'Léna Situations', 0, 'Film historique', 0, true)

