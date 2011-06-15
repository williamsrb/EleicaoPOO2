--
-- PostgreSQL database dump
--

-- Started on 2011-06-15 12:38:51 BRT

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
-- TOC entry 1512 (class 1259 OID 16522)
-- Dependencies: 3
-- Name: Partido; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Partido" (
    id integer NOT NULL,
    sigla character varying NOT NULL,
    nome character varying NOT NULL,
    numero integer NOT NULL
);


--
-- TOC entry 1801 (class 0 OID 0)
-- Dependencies: 1512
-- Name: COLUMN "Partido".id; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Partido".id IS 'PK - Sequence';


--
-- TOC entry 1802 (class 0 OID 0)
-- Dependencies: 1512
-- Name: COLUMN "Partido".sigla; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Partido".sigla IS 'String';


--
-- TOC entry 1803 (class 0 OID 0)
-- Dependencies: 1512
-- Name: COLUMN "Partido".nome; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Partido".nome IS 'String';


--
-- TOC entry 1804 (class 0 OID 0)
-- Dependencies: 1512
-- Name: COLUMN "Partido".numero; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Partido".numero IS 'Número do partido, serve de prefixo ao número dos candidatos';


--
-- TOC entry 1798 (class 0 OID 16522)
-- Dependencies: 1512
-- Data for Name: Partido; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Partido" (id, sigla, nome, numero) VALUES (-1, 'NULO', 'Nulo', -1);
INSERT INTO "Partido" (id, sigla, nome, numero) VALUES (0, 'BRANCO', 'Branco', 0);


--
-- TOC entry 1795 (class 2606 OID 16531)
-- Dependencies: 1512 1512
-- Name: Partido_numero_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Partido"
    ADD CONSTRAINT "Partido_numero_key" UNIQUE (numero);


--
-- TOC entry 1797 (class 2606 OID 16529)
-- Dependencies: 1512 1512
-- Name: Partido_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Partido"
    ADD CONSTRAINT "Partido_pkey" PRIMARY KEY (id);


--
-- TOC entry 1805 (class 0 OID 0)
-- Dependencies: 1512
-- Name: Partido; Type: ACL; Schema: public; Owner: -
--

REVOKE ALL ON TABLE "Partido" FROM PUBLIC;
GRANT ALL ON TABLE "Partido" TO PUBLIC;


-- Completed on 2011-06-15 12:38:51 BRT

--
-- PostgreSQL database dump complete
--

