create table sensores(
    id bigint not null auto_increment,

    nome_sensor varchar(100) not null,
    localizacao varchar(100) not null,
    status varchar(50) not null,
    tipo_sensor varchar(30) not null,

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