create table Pacientes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null,
    cpf varchar(11) not null,
    telefone varchar(20),
    bairro varchar(100) not null,
    logradouro varchar(100),
    cep varchar(20),
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key(id)
    );
