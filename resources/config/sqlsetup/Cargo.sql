--
-- PostgreSQL database dump
--

-- Started on 2011-06-12 12:40:06 BRT

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
-- TOC entry 1510 (class 1259 OID 16532)
-- Dependencies: 3
-- Name: Cargo; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Cargo" (
    id integer NOT NULL,
    digitos integer NOT NULL,
    nome character varying NOT NULL
);


--
-- TOC entry 1795 (class 0 OID 0)
-- Dependencies: 1510
-- Name: COLUMN "Cargo".id; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Cargo".id IS 'PK - Sequence';


--
-- TOC entry 1796 (class 0 OID 0)
-- Dependencies: 1510
-- Name: COLUMN "Cargo".digitos; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Cargo".digitos IS 'Quantidade de dígitos';


--
-- TOC entry 1797 (class 0 OID 0)
-- Dependencies: 1510
-- Name: COLUMN "Cargo".nome; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Cargo".nome IS 'Descrição do cargo';


--
-- TOC entry 1792 (class 0 OID 16532)
-- Dependencies: 1510
-- Data for Name: Cargo; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Cargo" (id, digitos, nome) VALUES (-1, -1, 'Nulo');
INSERT INTO "Cargo" (id, digitos, nome) VALUES (0, 0, 'Branco');


--
-- TOC entry 1791 (class 2606 OID 16539)
-- Dependencies: 1510 1510
-- Name: Cargo_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Cargo"
    ADD CONSTRAINT "Cargo_pkey" PRIMARY KEY (id);


-- Completed on 2011-06-12 12:40:07 BRT

--
-- PostgreSQL database dump complete
--

