PGDMP                         z            employee_java_api    14.1    14.1     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    18023    employee_java_api    DATABASE     u   CREATE DATABASE employee_java_api WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
 !   DROP DATABASE employee_java_api;
                postgres    false            ?            1259    18128    employee_id_seq    SEQUENCE     x   CREATE SEQUENCE public.employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 2;
 &   DROP SEQUENCE public.employee_id_seq;
       public          postgres    false            ?            1259    18130 	   employees    TABLE     V   CREATE TABLE public.employees (
    id bigint NOT NULL,
    name character varying
);
    DROP TABLE public.employees;
       public         heap    postgres    false            ?            1259    18129    employees_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.employees_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.employees_id_seq;
       public          postgres    false    211            ?           0    0    employees_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.employees_id_seq OWNED BY public.employees.id;
          public          postgres    false    210            ]           2604    18136    employees id    DEFAULT     l   ALTER TABLE ONLY public.employees ALTER COLUMN id SET DEFAULT nextval('public.employees_id_seq'::regclass);
 ;   ALTER TABLE public.employees ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            ?          0    18130 	   employees 
   TABLE DATA           -   COPY public.employees (id, name) FROM stdin;
    public          postgres    false    211   o       ?           0    0    employee_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.employee_id_seq', 1, false);
          public          postgres    false    209            ?           0    0    employees_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.employees_id_seq', 2, true);
          public          postgres    false    210            _           2606    18143    employees employees_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_pkey;
       public            postgres    false    211            ?      x?3?,I-.1?2?F\1z\\\ >?     