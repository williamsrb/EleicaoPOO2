SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE "Partido" (
    id integer NOT NULL,
    sigla character varying NOT NULL,
    nome character varying NOT NULL,
    numero integer NOT NULL
);


COMMENT ON COLUMN "Partido".id IS 'PK - Sequence';


COMMENT ON COLUMN "Partido".sigla IS 'String';


COMMENT ON COLUMN "Partido".nome IS 'String';


COMMENT ON COLUMN "Partido".numero IS 'Número do partido, serve de prefixo ao número dos candidatos';


CREATE SEQUENCE "Partido_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER SEQUENCE "Partido_id_seq" OWNED BY "Partido".id;


SELECT pg_catalog.setval('"Partido_id_seq"', 1, false);


ALTER TABLE "Partido" ALTER COLUMN id SET DEFAULT nextval('"Partido_id_seq"'::regclass);

--partidos de teste
INSERT INTO "Partido" (id, sigla, nome, numero) VALUES (-1, 'NULO', 'Nulo', -1);
INSERT INTO "Partido" (id, sigla, nome, numero) VALUES (0, 'BRANCO', 'Branco', 0);
INSERT INTO "Partido" (id, sigla, nome, numero) VALUES (1, 'PMN', 'Partido Muito Nerd', 78);
INSERT INTO "Partido" (id, sigla, nome, numero) VALUES (2, 'PXK', 'Partido Xuntos Konkistamos', 59);
INSERT INTO "Partido" (id, sigla, nome, numero) VALUES (3, 'PR', 'Partido Repartido', 31);


ALTER TABLE ONLY "Partido"
    ADD CONSTRAINT "Partido_numero_key" UNIQUE (numero);


ALTER TABLE ONLY "Partido"
    ADD CONSTRAINT "Partido_pkey" PRIMARY KEY (id);


REVOKE ALL ON TABLE "Partido" FROM PUBLIC;
GRANT ALL ON TABLE "Partido" TO PUBLIC;

