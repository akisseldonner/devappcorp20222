CREATE TABLE usuario (
	id serial PRIMARY KEY,
	login varchar(50),
	email varchar(50),
	nome varchar(50),
	afiliacao varchar(50)
);

CREATE TABLE evento (
	id serial PRIMARY KEY,
	nome varchar(50),
	sigla varchar(50),
	descricao varchar(150)
);


CREATE TABLE edicao (
	id serial PRIMARY KEY,
	numero integer,
	ano integer,
	data_inicial timestamp,
    data_final timestamp,
    cidade varchar(50),
    evento_id integer,
    CONSTRAINT fk_edicao_evento FOREIGN KEY(evento_id) REFERENCES evento(id)
);

create type atividade_t as enum('palestra', 'painel', 'sessão técnica', 'outros');

CREATE TABLE atividade (
	id serial PRIMARY KEY,
	nome varchar(50),
	tipo atividade_t,
	descricao varchar(50),
	data timestamp,
    hora_inicial Time without Time Zone,
    hora_final Time without Time Zone
);

CREATE TABLE espaco (
	id serial PRIMARY KEY,
	nome varchar(50),
	localizacao varchar(50),
	capacidade integer,
	recursos varchar(50)[]
);

