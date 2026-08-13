create schema Usuario(
    id Integer not null auto_increment,
    nome_Completo varchar(200) not null,
    cpf varchar(30) not null unique,
    email varchar(200) not null unique,
    senha varchar(255) not null,
    tipo enum("Lojista", "Usuario") not null,
    constraint PK_id_Usuario primary key(id)
    );