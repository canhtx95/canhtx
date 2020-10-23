--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.0

-- Started on 2020-10-22 16:36:59

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
-- TOC entry 2992 (class 1262 OID 16395)
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
-- TOC entry 203 (class 1259 OID 16437)
-- Name: staff; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.staff (
    id integer NOT NULL,
    name character varying(25),
    age integer,
    address character varying(25),
    department character varying(25)
);


ALTER TABLE public.staff OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16435)
-- Name: staff_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.staff_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.staff_id_seq OWNER TO postgres;

--
-- TOC entry 2993 (class 0 OID 0)
-- Dependencies: 202
-- Name: staff_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.staff_id_seq OWNED BY public.staff.id;


--
-- TOC entry 2854 (class 2604 OID 16440)
-- Name: staff id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff ALTER COLUMN id SET DEFAULT nextval('public.staff_id_seq'::regclass);


--
-- TOC entry 2986 (class 0 OID 16437)
-- Dependencies: 203
-- Data for Name: staff; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.staff (id, name, age, address, department) VALUES (105, 'Trinh Thang Binh', 25, 'Ba Dinh', 'Personnel');
INSERT INTO public.staff (id, name, age, address, department) VALUES (67, 'La Phong Lam', 26, 'Co Nhue', 'Production');
INSERT INTO public.staff (id, name, age, address, department) VALUES (77, 'Hoang Van Phat', 23, 'Vinh Tuy', 'Account');
INSERT INTO public.staff (id, name, age, address, department) VALUES (4, 'Nguyen Van Long', 34, 'Can Tho', 'Personnel');
INSERT INTO public.staff (id, name, age, address, department) VALUES (95, 'Chau Kiet Luan', 27, 'Thai Binh', 'Marketing');
INSERT INTO public.staff (id, name, age, address, department) VALUES (1, 'Trinh Xuan Canh', 25, 'Cau Giay', 'Security');


--
-- TOC entry 2994 (class 0 OID 0)
-- Dependencies: 202
-- Name: staff_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.staff_id_seq', 108, true);


-- Completed on 2020-10-22 16:36:59

--
-- PostgreSQL database dump complete
--

