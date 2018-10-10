create table estudante (
    id int  AUTO_INCREMENT  primary key,
    nome varchar(64) not null,
    dt_nascimento date not null,
    curso varchar(64) not null,
    predio varchar(32) not null
);