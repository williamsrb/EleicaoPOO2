SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE "Candidato" (
    id integer NOT NULL,
    numero integer NOT NULL,
    nome character varying NOT NULL,
    id_partido integer NOT NULL,
    id_cargo integer NOT NULL,
    nascimento date NOT NULL,
    sexo character(1) NOT NULL,
    foto character varying NOT NULL,
    site character varying,
    apelido character varying,
    nome_vice character varying,
    foto_vice character varying
);


COMMENT ON COLUMN "Candidato".id IS 'PK - Sequence';


COMMENT ON COLUMN "Candidato".numero IS 'Porção final do numero do candidato (num_partido + num_candidato)';


COMMENT ON COLUMN "Candidato".nome IS 'String';


COMMENT ON COLUMN "Candidato".id_partido IS 'FK - Int';


COMMENT ON COLUMN "Candidato".id_cargo IS 'FK - Int';


COMMENT ON COLUMN "Candidato".nascimento IS 'Date';


COMMENT ON COLUMN "Candidato".sexo IS 'Uma letra: M ou F';


COMMENT ON COLUMN "Candidato".foto IS 'Caminho relativo até  foto';


COMMENT ON COLUMN "Candidato".site IS '[Opcional] Website';


COMMENT ON COLUMN "Candidato".apelido IS '[Deputado] Apelido';


COMMENT ON COLUMN "Candidato".nome_vice IS '[Presidente/Governador] Nome do vice';


COMMENT ON COLUMN "Candidato".foto_vice IS '[Presidente/Governador] Caminho relativo até  foto do vice';

-- auto-increment start
CREATE SEQUENCE "Candidato_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER SEQUENCE "Candidato_id_seq" OWNED BY "Candidato".id;
GRANT ALL ON TABLE "Candidato_id_seq" TO PUBLIC;

SELECT pg_catalog.setval('"Candidato_id_seq"', 1, false);


ALTER TABLE "Candidato" ALTER COLUMN id SET DEFAULT nextval('"Candidato_id_seq"'::regclass);
-- auto-increment end

INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (-1, -1, 'Nulo', -1, -1, '1970-01-01', 'U', 'empty.jpg', NULL, NULL, NULL, NULL);
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (0, 0, 'Branco', 0, 0, '1970-01-01', 'U', 'empty.jpg', NULL, NULL, NULL, NULL);
--deputados de teste
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (1, 78123, 'Astra Dork', 1, 1, '1970-01-01', 'F', 'empty.jpg', NULL, 'Adok', NULL, NULL);
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (2, 59123, 'Miguxa Gatinha', 2, 1, '1970-01-01', 'F', 'empty.jpg', NULL, 'Meega', NULL, NULL);
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (3, 78456, 'Kya Geek', 1, 1, '1970-01-01', 'F', 'empty.jpg', NULL, 'Cute Sorcerer', NULL, NULL);
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (4, 31123, 'Nãoquero Jáfoi', 3, 1, '1970-01-01', 'M', 'empty.jpg', NULL, 'Anão', NULL, NULL);
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (5, 59456, 'Sad Dark Tears', 2, 1, '1970-01-01', 'M', 'empty.jpg', NULL, 'Pulsos Desfigurados', NULL, NULL);
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (6, 31456, 'Mandado Pedido', 3, 1, '1970-01-01', 'M', 'empty.jpg', NULL, 'Coméquié', NULL, NULL);
--governadores de teste
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (7, 78, 'Darth Vader', 1, 2, '1970-01-01', 'M', 'empty.jpg', NULL, NULL, 'Severus Snape', 'mini_empty.jpg');
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (8, 59, 'Smeagol Gollum', 2, 2, '1970-01-01', 'M', 'empty.jpg', NULL, NULL, 'Sauron de Mordor', 'mini_empty.jpg');
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (9, 31, 'Zangado de Neve', 3, 2, '1970-01-01', 'M', 'empty.jpg', NULL, NULL, 'Rumpelstinsky', 'mini_empty.jpg');
--presidentes de teste
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (10, 78, 'Ele', 1, 3, '1970-01-01', 'F', 'empty.jpg', NULL, NULL, 'Bundifora', 'mini_empty.jpg');
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (11, 59, 'FUUUUUUUUUU', 2, 3, '1970-01-01', 'M', 'empty.jpg', NULL, NULL, 'Troll', 'mini_empty.jpg');
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (12, 31, 'Mario', 3, 3, '1970-01-01', 'M', 'empty.jpg', NULL, NULL, 'King Koopa', 'mini_empty.jpg');


ALTER TABLE ONLY "Candidato"
    ADD CONSTRAINT "Candidato_numero_cargo_key" UNIQUE (numero, id_cargo);


ALTER TABLE ONLY "Candidato"
    ADD CONSTRAINT "Candidato_pkey" PRIMARY KEY (id);


ALTER TABLE ONLY "Candidato"
    ADD CONSTRAINT "Candidato_id_cargo_fkey" FOREIGN KEY (id_cargo) REFERENCES "Cargo"(id) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE ONLY "Candidato"
    ADD CONSTRAINT "Candidato_id_partido_fkey" FOREIGN KEY (id_partido) REFERENCES "Partido"(id) ON UPDATE CASCADE ON DELETE CASCADE;


REVOKE ALL ON TABLE "Candidato" FROM PUBLIC;
GRANT ALL ON TABLE "Candidato" TO PUBLIC;

