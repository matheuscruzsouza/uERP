--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4 (Debian 10.4-2)
-- Dumped by pg_dump version 10.4 (Debian 10.4-2)

-- Started on 2020-07-29 21:33:19 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 16384)
-- Name: uerp; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA uerp;


ALTER SCHEMA uerp OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 16393)
-- Name: endereco; Type: TABLE; Schema: uerp; Owner: postgres
--

CREATE TABLE uerp.endereco (
    oid character varying NOT NULL,
    logradouro character varying NOT NULL,
    numero character varying,
    bairro character varying,
    cep character varying,
    tipo character varying,
    oidpessoa character varying NOT NULL
);


ALTER TABLE uerp.endereco OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16385)
-- Name: pessoa; Type: TABLE; Schema: uerp; Owner: postgres
--

CREATE TABLE uerp.pessoa (
    oid character varying NOT NULL,
    nome character varying NOT NULL,
    cpf character varying,
    datanascimento date NOT NULL,
    email character varying
);


ALTER TABLE uerp.pessoa OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16406)
-- Name: telefone; Type: TABLE; Schema: uerp; Owner: postgres
--

CREATE TABLE uerp.telefone (
    oid character varying NOT NULL,
    numero character varying NOT NULL,
    ddd character varying NOT NULL,
    whatsapp boolean,
    oidpessoa character varying NOT NULL
);


ALTER TABLE uerp.telefone OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16419)
-- Name: usuario; Type: TABLE; Schema: uerp; Owner: postgres
--

CREATE TABLE uerp.usuario (
    oid character varying NOT NULL,
    usuario character varying NOT NULL,
    senha character varying NOT NULL,
    oidpessoa character varying NOT NULL,
    login character varying(255)
);


ALTER TABLE uerp.usuario OWNER TO postgres;

--
-- TOC entry 2902 (class 0 OID 16393)
-- Dependencies: 198
-- Data for Name: endereco; Type: TABLE DATA; Schema: uerp; Owner: postgres
--

INSERT INTO uerp.endereco VALUES ('0001', 'Rua Texeira de Melo', '287', 'Pq. Leopoldina', '28051185', 'Residencial', '0001');


--
-- TOC entry 2901 (class 0 OID 16385)
-- Dependencies: 197
-- Data for Name: pessoa; Type: TABLE DATA; Schema: uerp; Owner: postgres
--

INSERT INTO uerp.pessoa VALUES ('0001', 'Matheus Souza', '11450554784', '1992-03-02', 'matheuscruzsouza@gmail.com');


--
-- TOC entry 2903 (class 0 OID 16406)
-- Dependencies: 199
-- Data for Name: telefone; Type: TABLE DATA; Schema: uerp; Owner: postgres
--

INSERT INTO uerp.telefone VALUES ('0001', '998506897', '22', true, '0001');


--
-- TOC entry 2904 (class 0 OID 16419)
-- Dependencies: 200
-- Data for Name: usuario; Type: TABLE DATA; Schema: uerp; Owner: postgres
--

INSERT INTO uerp.usuario VALUES ('0001', 'admin', '$2y$12$ZBDpB7XyRfUQL0MTHI0HmecWVMZ584AInN.T656gYBDg0oW8OsbmW', '0001', 'admin');


--
-- TOC entry 2772 (class 2606 OID 16400)
-- Name: endereco oidendereco; Type: CONSTRAINT; Schema: uerp; Owner: postgres
--

ALTER TABLE ONLY uerp.endereco
    ADD CONSTRAINT oidendereco PRIMARY KEY (oid);


--
-- TOC entry 2770 (class 2606 OID 16392)
-- Name: pessoa oidpessoa; Type: CONSTRAINT; Schema: uerp; Owner: postgres
--

ALTER TABLE ONLY uerp.pessoa
    ADD CONSTRAINT oidpessoa PRIMARY KEY (oid);


--
-- TOC entry 2774 (class 2606 OID 16413)
-- Name: telefone telefone_pk; Type: CONSTRAINT; Schema: uerp; Owner: postgres
--

ALTER TABLE ONLY uerp.telefone
    ADD CONSTRAINT telefone_pk PRIMARY KEY (oid);


--
-- TOC entry 2776 (class 2606 OID 16426)
-- Name: usuario usuario_pk; Type: CONSTRAINT; Schema: uerp; Owner: postgres
--

ALTER TABLE ONLY uerp.usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (oid);


--
-- TOC entry 2777 (class 2606 OID 16401)
-- Name: endereco endereco_pessoa_fk; Type: FK CONSTRAINT; Schema: uerp; Owner: postgres
--

ALTER TABLE ONLY uerp.endereco
    ADD CONSTRAINT endereco_pessoa_fk FOREIGN KEY (oidpessoa) REFERENCES uerp.pessoa(oid) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2778 (class 2606 OID 16414)
-- Name: telefone telefone_pessoa_fk; Type: FK CONSTRAINT; Schema: uerp; Owner: postgres
--

ALTER TABLE ONLY uerp.telefone
    ADD CONSTRAINT telefone_pessoa_fk FOREIGN KEY (oidpessoa) REFERENCES uerp.pessoa(oid) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2779 (class 2606 OID 16427)
-- Name: usuario usuario_pessoa_fk; Type: FK CONSTRAINT; Schema: uerp; Owner: postgres
--

ALTER TABLE ONLY uerp.usuario
    ADD CONSTRAINT usuario_pessoa_fk FOREIGN KEY (oidpessoa) REFERENCES uerp.pessoa(oid) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2020-07-29 21:33:20 -03

--
-- PostgreSQL database dump complete
--

