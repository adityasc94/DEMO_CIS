--Create table
CREATE TABLE public.customer
(
    customer_id bigint NOT NULL,
    dob date,
    email character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    gender character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    middle_name character varying(255) COLLATE pg_catalog."default",
    primary_phone character varying(255) COLLATE pg_catalog."default",
    sec_phone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.customer
    OWNER to postgres;
    
CREATE SEQUENCE public.hibernate_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.hibernate_sequence
    OWNER TO postgres;
    
--Populate data in table
INSERT INTO public.customer VALUES (nextval('hibernate_sequence'), '2001-06-01', 'abc@efg.com', 'XYZ', 'M', 'JKL', 'QWE', '567464554', '');
INSERT INTO public.customer VALUES (nextval('hibernate_sequence'), '1994-05-18', 'jkthfj@efg.com', 'GHJ', 'M', 'QAZ', 'ERTY', '842565456', '234244424');
INSERT INTO public.customer VALUES (nextval('hibernate_sequence'), '1988-04-21', 'jhfhhs@efg.com', 'Richard', 'M', 'James', '', '24552342', '97875');
INSERT INTO public.customer VALUES (nextval('hibernate_sequence'), '1968-03-06', 'gfjgg@efg.com', 'Eden', 'M', 'Paul', '', '453544554', '786786');
INSERT INTO public.customer VALUES (nextval('hibernate_sequence'), '1991-02-15', 'hfkfk@aad.com', 'Shaun', 'M', 'Murphy', '', '99686786', '123134');
INSERT INTO public.customer VALUES (nextval('hibernate_sequence'), '1912-01-25', 'nyu@aad.com', 'Eliabeth', 'F', 'Turing', '', '5354565', '857567');
