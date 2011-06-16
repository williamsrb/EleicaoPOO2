SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE "Votos" (
    id integer NOT NULL,
    id_deputado integer NOT NULL,
    id_governador integer NOT NULL,
    id_presidente integer NOT NULL
);


COMMENT ON COLUMN "Votos".id IS 'PK - SERIAL';


COMMENT ON COLUMN "Votos".id_deputado IS 'Deve haver checagem quanto ao cargo = deputado';


COMMENT ON COLUMN "Votos".id_governador IS 'Deve haver checagem quanto ao cargo = governador';


COMMENT ON COLUMN "Votos".id_presidente IS 'Deve haver checagem quanto ao cargo = presidente';


CREATE SEQUENCE "Votos_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER SEQUENCE "Votos_id_seq" OWNED BY "Votos".id;


SELECT pg_catalog.setval('"Votos_id_seq"', 1, false);


ALTER TABLE "Votos" ALTER COLUMN id SET DEFAULT nextval('"Votos_id_seq"'::regclass);


ALTER TABLE ONLY "Votos"
    ADD CONSTRAINT "Votos_pkey" PRIMARY KEY (id);


ALTER TABLE ONLY "Votos"
    ADD CONSTRAINT "Votos_id_deputado_fkey" FOREIGN KEY (id_deputado) REFERENCES "Candidato"(id) ON UPDATE CASCADE ON DELETE SET NULL;


ALTER TABLE ONLY "Votos"
    ADD CONSTRAINT "Votos_id_governador_fkey" FOREIGN KEY (id_governador) REFERENCES "Candidato"(id) ON UPDATE CASCADE ON DELETE SET NULL;


ALTER TABLE ONLY "Votos"
    ADD CONSTRAINT "Votos_id_presidente_fkey" FOREIGN KEY (id_presidente) REFERENCES "Candidato"(id) ON UPDATE CASCADE ON DELETE SET NULL;


REVOKE ALL ON TABLE "Votos" FROM PUBLIC;
GRANT ALL ON TABLE "Votos" TO PUBLIC;

