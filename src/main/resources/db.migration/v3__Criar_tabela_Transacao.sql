create schema Transacao(
    id_Transacao Integer not null auto_increment,
    valor Decimal(8,2) not null,
    conta1 String not null,
    conta2 String not null,
    constraint PK_Id_Transacao primary key (id_Transacao),
    constraint FK_Conta1_Conta foreign key (conta1) references Conta (id),
    constraint FK_Conta2_Conta foreign key (conta2) references Conta (id)
    );