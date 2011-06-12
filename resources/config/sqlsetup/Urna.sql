--
-- PostgreSQL database dump
--

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
-- Name: Urna; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Urna" (
    habilitada bit(1) NOT NULL,
    senha character varying NOT NULL
);


--
-- Name: TABLE "Urna"; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE "Urna" IS 'Tabela de configuração';


--
-- Name: COLUMN "Urna".habilitada; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Urna".habilitada IS 'Boolean - Habilitado ou Desabilitado';


--
-- Name: COLUMN "Urna".senha; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Urna".senha IS 'String';


--
-- Data for Name: Urna; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Urna" (habilitada, senha) VALUES (B'0', '123456');


--
-- PostgreSQL database dump complete
--

