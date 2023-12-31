CREATE TRIGGER max_nb_blueray
BEFORE INSERT
ON SUPPORT FOR EACH ROW
DECLARE
    nb_blueray NUMBER
BEGIN
    SELECT Count(*) in nb_blueray
    FROM SUPPORT
    WHERE type_supp = "blueray"
    IF (nb_blueray > 100) THEN
        RAISE_APPLICATION_ERROR("Plus de 100 Bluerays dans la machine");
    END IF;
END

CREATE TRIGGER minimum_montant_carte
BEFORE INSERT OR UPDATE
ON ABONNE FOR EACH ROW
BEGIN
    SELECT montant
    FROM ABONNE
    IF NEW.montant < 15 THEN 
        RAISE_APPLICATION_ERROR("Minimum 15€ nécessaire sur le compte");
    END IF;
END 

CREATE TRIGGER minimum_credit
BEFORE UPDATE
ON ABONNE FOR EACH ROW
BEGIN
    SELECT montant
    FROM ABONNE
    IF (NEW.montant - montant > 0 AND NEW.montant - montant < 10) THEN 
        RAISE_APPLICATION_ERROR("Montant crédité inférieur à 10€");
    END IF;
END 

CREATE TRIGGER location_total_avec_abonnement
BEFORE INSERT
ON LOCATIONS FOR EACH ROW
DECLARE
    nb_locations NUMBER
BEGIN
    SELECT Count(*) IN nb_locations
    FROM LOCATIONS JOIN ABONNE USING (id_client)
    GROUP BY id_client
    WHERE support = NULL
    IF (nb_locations > 3) THEN
        RAISE_APPLICATION_ERROR("Plus de 3 films en location pour un abonné");
    END IF;
END

CREATE TRIGGER location_total_sans_abonnement
BEFORE INSERT
ON LOCATIONS FOR EACH ROW
DECLARE
    nb_locations NUMBER
BEGIN
    SELECT Count(*) IN nb_locations
    FROM LOCATIONS
    EXCLUDE
        SELECT id_client
        FROM ABONNE
    GROUP BY id_client
    WHERE support = NULL
    IF (nb_locations > 1) THEN
        RAISE_APPLICATION_ERROR("Plus d'un film en location pour un non-abonné");
    END IF;
END

CREATE TRIGGER gel
AFTER UPDATE
ON ABONNE FOR EACH ROW
BEGIN
    SELECT montant
    FROM ABONNEe
    IF (NEW.montant < 0) THEN
        UPDATE ABONNE
        SET gele = true;
    END IF;
    IF (NEW.montant > 15) THEN
        UPDATE ABONNE
        SET gele = false;
    END IF;
END
