--
-- PostgreSQL database dump
--

-- Started on 2011-06-12 13:04:20 BRT

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
-- TOC entry 1512 (class 1259 OID 16552)
-- Dependencies: 3
-- Name: Votos; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE "Votos" (
    id bigint NOT NULL,
    id_deputado integer NOT NULL,
    id_governador integer NOT NULL,
    id_presidente integer NOT NULL
);


--
-- TOC entry 1799 (class 0 OID 0)
-- Dependencies: 1512
-- Name: COLUMN "Votos".id; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Votos".id IS 'PK - SERIAL';


--
-- TOC entry 1800 (class 0 OID 0)
-- Dependencies: 1512
-- Name: COLUMN "Votos".id_deputado; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Votos".id_deputado IS 'Deve haver checagem quanto ao cargo = deputado';


--
-- TOC entry 1801 (class 0 OID 0)
-- Dependencies: 1512
-- Name: COLUMN "Votos".id_governador; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Votos".id_governador IS 'Deve haver checagem quanto ao cargo = governador';


--
-- TOC entry 1802 (class 0 OID 0)
-- Dependencies: 1512
-- Name: COLUMN "Votos".id_presidente; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON COLUMN "Votos".id_presidente IS 'Deve haver checagem quanto ao cargo = presidente';


--
-- TOC entry 1511 (class 1259 OID 16550)
-- Dependencies: 3 1512
-- Name: Votos_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "Votos_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1803 (class 0 OID 0)
-- Dependencies: 1511
-- Name: Votos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "Votos_id_seq" OWNED BY "Votos".id;


--
-- TOC entry 1804 (class 0 OID 0)
-- Dependencies: 1511
-- Name: Votos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('"Votos_id_seq"', 1, false);


--
-- TOC entry 1790 (class 2604 OID 16555)
-- Dependencies: 1512 1511 1512
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE "Votos" ALTER COLUMN id SET DEFAULT nextval('"Votos_id_seq"'::regclass);


--
-- TOC entry 1796 (class 0 OID 16552)
-- Dependencies: 1512
-- Data for Name: Votos; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 1792 (class 2606 OID 16557)
-- Dependencies: 1512 1512
-- Name: Votos_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY "Votos"
    ADD CONSTRAINT "Votos_pkey" PRIMARY KEY (id);


--
-- TOC entry 1793 (class 2606 OID 16568)
-- Dependencies: 1508 1512
-- Name: Votos_id_deputado_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Votos"
    ADD CONSTRAINT "Votos_id_deputado_fkey" FOREIGN KEY (id_deputado) REFERENCES "Candidato"(id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 1794 (class 2606 OID 16573)
-- Dependencies: 1508 1512
-- Name: Votos_id_governador_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Votos"
    ADD CONSTRAINT "Votos_id_governador_fkey" FOREIGN KEY (id_governador) REFERENCES "Candidato"(id) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 1795 (class 2606 OID 16578)
-- Dependencies: 1508 1512
-- Name: Votos_id_presidente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "Votos"
    ADD CONSTRAINT "Votos_id_presidente_fkey" FOREIGN KEY (id_presidente) REFERENCES "Candidato"(id) ON UPDATE CASCADE ON DELETE SET NULL;


-- Completed on 2011-06-12 13:04:20 BRT

--
-- PostgreSQL database dump complete
--
