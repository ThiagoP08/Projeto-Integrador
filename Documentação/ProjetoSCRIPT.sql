create database if not exists eventroller_db;

use eventroller_db;

create table user (
    id int primary key auto_increment,
    email varchar(150) not null,
    senha varchar(255) not null,
    nome varchar(100) not null,
    username varchar(15) not null,
    dtNascimento date not null,
    cpf varchar(11) not null,
    endereco varchar(200),
    cep varchar(9),
    status_admin boolean default 0
);

create table categorias (
    id int primary key auto_increment,
    categoria varchar(50) not null,
    descricao varchar(255) not null,
    img_src varchar(255) not null
);

create table evento (
    id int primary key auto_increment,
    img_src varchar(255) not null,
    titulo varchar(255) not null,
    data_evento date not null,
    hora time not null,
    bairro varchar(100) not null,
    estado varchar(100) not null,
    rua varchar(100) not null,
    descricao varchar(255) not null,
    politica varchar(255) not null,
    min_lotacao int not null,
    max_lotacao int not null,
    status boolean not null,
    min_idade int not null,
    categoria_id int not null,
    foreign key (categoria_id) references categorias(id)
);

create table ingresso (
    id int primary key auto_increment,
    valor int not null,
    quantidade int not null,
    descricao varchar(55) not null,
    qrcode varchar(100),
    user_id int not null,
    evento_id int not null,
    foreign key (user_id) references user(id),
    foreign key (evento_id) references evento(id)
);

create table admin (
    id int primary key auto_increment,
    status boolean not null default 0,
    user_id int not null,
    evento_id int not null,
    foreign key (user_id) references user(id),
    foreign key (evento_id) references evento(id)
);


INSERT INTO categorias (categoria, descricao, img_src)
VALUES
    ('rock', 'Incriveis shows de rock', 'rock.jpg');

use eventroller_db;

INSERT INTO categorias (categoria, descricao, img_src)
VALUES
    ('rap', 'Incriveis shows de rap', 'rap.jpeg');


