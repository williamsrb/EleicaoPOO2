SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE "Urna" (
    senha character varying NOT NULL
);


COMMENT ON TABLE "Urna" IS 'Tabela de configuração';


COMMENT ON COLUMN "Urna".senha IS 'String';


INSERT INTO "Urna" (senha) VALUES ('123456');


REVOKE ALL ON TABLE "Urna" FROM PUBLIC;
GRANT SELECT ON TABLE "Urna" TO PUBLIC;

