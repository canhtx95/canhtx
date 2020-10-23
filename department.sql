--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.0

-- Started on 2020-10-22 16:38:05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2994 (class 1262 OID 16395)
-- Name: staff; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE staff WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';


ALTER DATABASE staff OWNER TO postgres;

\connect staff

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 16429)
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    id integer NOT NULL,
    name character varying(25),
    cod character varying(25),
    email character varying(25),
    phone character varying(25),
    quantity integer
);


ALTER TABLE public.department OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16427)
-- Name: department_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.department_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.department_id_seq OWNER TO postgres;

--
-- TOC entry 2995 (class 0 OID 0)
-- Dependencies: 200
-- Name: department_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.department_id_seq OWNED BY public.department.id;


--
-- TOC entry 2854 (class 2604 OID 16432)
-- Name: department id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department ALTER COLUMN id SET DEFAULT nextval('public.department_id_seq'::regclass);


--
-- TOC entry 2988 (class 0 OID 16429)
-- Dependencies: 201
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.department (id, name, cod, email, phone, quantity) VALUES (91, 'Personnel', 'Tra My', 'Personnel@gmail.com', '923654781', NULL);
INSERT INTO public.department (id, name, cod, email, phone, quantity) VALUES (87, 'Security', 'Tuan Thanh', 'scr@gmail.com', '11111111', NULL);
INSERT INTO public.department (id, name, cod, email, phone, quantity) VALUES (108, 'Marketing', 'Lam', 'asda@gmail.com', '22222', NULL);
INSERT INTO public.department (id, name, cod, email, phone, quantity) VALUES (68, 'Accounting', 'Le Trang', 'ttttttt@gmail.com', '4343223', NULL);
INSERT INTO public.department (id, name, cod, email, phone, quantity) VALUES (65, 'Product', 'Tran Van Phong', 'phong@gmal.com', '33333344', NULL);


--
-- TOC entry 2996 (class 0 OID 0)
-- Dependencies: 200
-- Name: department_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.department_id_seq', 109, true);


--
-- TOC entry 2856 (class 2606 OID 16434)
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


-- Completed on 2020-10-22 16:38:05

--
-- PostgreSQL database dump complete
--

