--
-- PostgreSQL database dump
--

-- Started on 2011-06-12 12:40:52 BRT

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1508 (class 1259 OID 16512)
-- Dependencies: 3
-- Name: Candidato; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

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


--
-- TOC entry 1799 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".id; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".id IS 'PK - Sequence';


--
-- TOC entry 1800 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".numero; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".numero IS 'Porção final do numero do candidato (num_partido + num_candidato)';


--
-- TOC entry 1801 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".nome; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".nome IS 'String';


--
-- TOC entry 1802 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".id_partido; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".id_partido IS 'FK - Int';


--
-- TOC entry 1803 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".id_cargo; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".id_cargo IS 'FK - Int';


--
-- TOC entry 1804 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".nascimento; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".nascimento IS 'Date';


--
-- TOC entry 1805 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".sexo; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".sexo IS 'Uma letra: M ou F';


--
-- TOC entry 1806 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".foto; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".foto IS 'Caminho relativo até  foto';


--
-- TOC entry 1807 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".site; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".site IS '[Opcional] Website';


--
-- TOC entry 1808 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".apelido; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".apelido IS '[Deputado] Apelido';


--
-- TOC entry 1809 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".nome_vice; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".nome_vice IS '[Presidente/Governador] Nome do vice';


--
-- TOC entry 1810 (class 0 OID 0)
-- Dependencies: 1508
-- Name: COLUMN "Candidato".foto_vice; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Candidato".foto_vice IS '[Presidente/Governador] Caminho relativo até  foto do vice';


--
-- TOC entry 1796 (class 0 OID 16512)
-- Dependencies: 1508
-- Data for Name: Candidato; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (-1, -1, 'Nulo', -1, -1, '1970-01-01', 'U', 'empty.jpg', NULL, NULL, NULL, NULL);
INSERT INTO "Candidato" (id, numero, nome, id_partido, id_cargo, nascimento, sexo, foto, site, apelido, nome_vice, foto_vice) VALUES (0, 0, 'Branco', 0, 0, '1970-01-01', 'U', 'empty.jpg', NULL, NULL, NULL, NULL);


--
-- TOC entry 1791 (class 2606 OID 16521)
-- Dependencies: 1508 1508
-- Name: Candidato_numero_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Candidato"
    ADD CONSTRAINT "Candidato_numero_key" UNIQUE (numero);


--
-- TOC entry 1793 (class 2606 OID 16519)
-- Dependencies: 1508 1508
-- Name: Candidato_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Candidato"
    ADD CONSTRAINT "Candidato_pkey" PRIMARY KEY (id);


--
-- TOC entry 1795 (class 2606 OID 16545)
-- Dependencies: 1508 1510
-- Name: Candidato_id_cargo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Candidato"
    ADD CONSTRAINT "Candidato_id_cargo_fkey" FOREIGN KEY (id_cargo) REFERENCES "Cargo"(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1794 (class 2606 OID 16540)
-- Dependencies: 1508 1509
-- Name: Candidato_id_partido_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Candidato"
    ADD CONSTRAINT "Candidato_id_partido_fkey" FOREIGN KEY (id_partido) REFERENCES "Partido"(id) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2011-06-12 12:40:52 BRT

--
-- PostgreSQL database dump complete
--

