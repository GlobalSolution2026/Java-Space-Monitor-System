create table alertas(
    id bigint not null auto_increment,

    regiao varchar(100) not null,
    descricao varchar(255) not null,
    nivel_risco varchar(50) not null,
    data_deteccao datetime not null,
    tipo_queimada varchar(30) not null,

    logradouro varchar(100) not null,
    numero varchar(10),
    complemento varchar(100),
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    uf varchar(2) not null,
    cep varchar(9) not null,

    ativo tinyint default 1,

    primary key(id)
);