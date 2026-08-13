create schema Conta(
    id String not null,
    saldo Decimal(8,2) not null,
    usuario Integer not null,
    constraint PK_Id_Conta primary key (id),
    constraint FK_usuario_Usuario foreign key (usuario) references Usuario (id)
    );