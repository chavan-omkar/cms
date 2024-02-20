
-- User Registration Table if registration is successful will give users details in response else error
CREATE TABLE IF NOT EXISTS public."User"
(
    id bigint NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
    username character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    mobileno bigint NOT NULL,
    created_at timestamp with time zone NOT NULL,
    CONSTRAINT "User_pkey" PRIMARY KEY (id),
    CONSTRAINT unique_mobile UNIQUE (mobileno),
    CONSTRAINT unique_username UNIQUE (username)
)

-- Menu Table Please Insert Some Data according to your project in this table
CREATE TABLE IF NOT EXISTS public."Menu"
(
    id bigint NOT NULL,
    dishname character varying COLLATE pg_catalog."default" NOT NULL,
    price numeric(10,3) NOT NULL,
    CONSTRAINT "Menu_pkey" PRIMARY KEY (id),
    CONSTRAINT unique_dish_name UNIQUE (dishname)
)

--Insert Data Into Menu Table
INSERT INTO public."Menu"(
	 id,dishname, price,created_at,day)
	VALUES
	(1,'Dosa', 85,now(),'monday'),
	(2,'Idali',35,now(),'tuesday'),
	(3,'PaniPuri', 35,now(),'monday'),
	(4,'Pongal',50,now(),'tuesday')