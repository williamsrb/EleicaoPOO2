--
-- PostgreSQL database dump
--

-- Started on 2011-06-15 12:39:13 BRT

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
-- TOC entry 1516 (class 1259 OID 16583)
-- Dependencies: 3
-- Name: Urna; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Urna" (
    senha character varying NOT NULL
);


--
-- TOC entry 1797 (class 0 OID 0)
-- Dependencies: 1516
-- Name: TABLE "Urna"; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE "Urna" IS 'Tabela de configuração';


--
-- TOC entry 1798 (class 0 OID 0)
-- Dependencies: 1516
-- Name: COLUMN "Urna".senha; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Urna".senha IS 'String';


--
-- TOC entry 1794 (class 0 OID 16583)
-- Dependencies: 1516
-- Data for Name: Urna; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "Urna" (senha) VALUES ('123456');


--
-- TOC entry 1799 (class 0 OID 0)
-- Dependencies: 1516
-- Name: Urna; Type: ACL; Schema: public; Owner: -
--

REVOKE ALL ON TABLE "Urna" FROM PUBLIC;
GRANT ALL ON TABLE "Urna" TO PUBLIC;


-- Completed on 2011-06-15 12:39:13 BRT

--
-- PostgreSQL database dump complete
--

