SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE "Cargo" (
    id integer NOT NULL,
    digitos integer NOT NULL,
    nome character varying NOT NULL
);


COMMENT ON COLUMN "Cargo".id IS 'PK - Sequence';


COMMENT ON COLUMN "Cargo".digitos IS 'Quantidade de dígitos';


COMMENT ON COLUMN "Cargo".nome IS 'Descrição do cargo';


CREATE SEQUENCE "Cargo_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER SEQUENCE "Cargo_id_seq" OWNED BY "Cargo".id;
GRANT ALL ON TABLE "Cargo_id_seq" TO PUBLIC;

SELECT pg_catalog.setval('"Cargo_id_seq"', 1, false);


ALTER TABLE "Cargo" ALTER COLUMN id SET DEFAULT nextval('"Cargo_id_seq"'::regclass);


INSERT INTO "Cargo" (id, digitos, nome) VALUES (1, 5, 'Deputado');
INSERT INTO "Cargo" (id, digitos, nome) VALUES (2, 2, 'Governador');
INSERT INTO "Cargo" (id, digitos, nome) VALUES (3, 2, 'Presidente');


ALTER TABLE ONLY "Cargo"
    ADD CONSTRAINT "Cargo_nome_key" UNIQUE (nome);


ALTER TABLE ONLY "Cargo"
    ADD CONSTRAINT "Cargo_pkey" PRIMARY KEY (id);


REVOKE ALL ON TABLE "Cargo" FROM PUBLIC;
GRANT ALL ON TABLE "Cargo" TO PUBLIC;

