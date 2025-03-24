create TABLE produto(
    id varchar(255) not null PRIMARY KEY,
    nome varchar(50) not null,
    descricao varchar(300),
    preco numeric(18, 2)
);