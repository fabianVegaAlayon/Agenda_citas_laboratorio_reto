--CREACION DE SECUENCIAS PARA CADA UNA DE LAS TABLAS 
CREATE SEQUENCE test_sequence START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE affiliates_sequence START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE appoinments_sequence START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

--TABLA TEST
CREATE TABLE test (
    id          NUMBER DEFAULT test_sequence.NEXTVAL NOT NULL,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL
);

ALTER TABLE test ADD CONSTRAINT pk_id_test PRIMARY KEY ( id );
--TABLA  AFFILIATES
CREATE TABLE affiliates (
    id   NUMBER DEFAULT affiliates_sequence.NEXTVAL NOT NULL,
    name VARCHAR(100) NOT NULL,
    age  NUMBER NOT NULL,
    mail VARCHAR(50)
);

ALTER TABLE affiliates ADD CONSTRAINT pk_id_affiliates PRIMARY KEY ( id );

-- TABLA APPOINMENTS
CREATE TABLE appoinments (
    id              NUMBER DEFAULT appoinments_sequence.NEXTVAL NOT NULL,
    date_appoinment DATE NOT NULL,
    hour            DATE NOT NULL,
    id_test         NUMBER NOT NULL,
    id_affiliate    NUMBER NOT NULL
);

ALTER TABLE appoinments ADD CONSTRAINT pk_id_appoinments PRIMARY KEY ( id );

ALTER TABLE appoinments
    ADD CONSTRAINT fk_id_test FOREIGN KEY ( id_test )
        REFERENCES test ( id );

ALTER TABLE appoinments
    ADD CONSTRAINT fk_id_affiliate FOREIGN KEY ( id_affiliate )
        REFERENCES affiliates ( id );


--CREACION DE LA VISTA
CREATE OR REPLACE VIEW masters (
    id_affiliate,
    name_affiliate,
    age,
    mail,
    id_appoinment,
    date_appoinment,
    hour,
    test_name
) AS
    SELECT
        a.id,
        a.name,
        a.age,
        a.mail,
        app.id,
        app.date_appoinment,
        app.hour,
        t.name AS "test name"
    FROM
             affiliates a
        INNER JOIN appoinments app ON ( a.id = app.id_affiliate )
        INNER JOIN test        t ON ( t.id = app.id_test );

--FIN SCRIPT 

