CREATE DATABASE db_lj;
USE db_lj;

CREATE TABLE CLIENTE (
	codcliente int PRIMARY KEY,
	nome varchar(60),
	datanascimento date,     
	cpf varchar(11)
);
CREATE TABLE PEDIDO (
	codpedido int PRIMARY KEY,   
	codcliente int,   
	datapedido date,   
	nf varchar(12),
 	valortotal decimal(10,2)
);
CREATE TABLE PRODUTO (
	codproduto int PRIMARY KEY,   
	descricao varchar(100),   
	quantidade int
);

CREATE TABLE REQUISICAO_COMPRA (
  codrequisicaocompra int PRIMARY KEY,   
  codproduto int,   
  dt_requisicao date,   
  quantidade int
);
  
INSERT INTO CLIENTE VALUES (1, 'Sylvio Barbon', '1984-12-05', '12315541212');
INSERT INTO CLIENTE VALUES (2, 'Antonio Carlos da Silva', '1970-11-10', '12313345512');
INSERT INTO CLIENTE VALUES (3, 'Thiago Ribeiro', '1964-11-15', '12315544411');
INSERT INTO CLIENTE VALUES (4, 'Carlos Eduardo', '1924-10-25', '42515541212');
INSERT INTO CLIENTE VALUES (5, 'Maria Cristina Goes', '1991-11-03', '67715541212');
INSERT INTO CLIENTE VALUES (6, 'Ruan Manoel Fanjo', '1993-12-08', '32415541212');
INSERT INTO CLIENTE VALUES (7, 'Patrícia Marques', '1944-02-01', '77715541212');
INSERT INTO PRODUTO VALUES (1, 'Mouse', 10);
INSERT INTO PRODUTO VALUES (2, 'Teclado', 10);
INSERT INTO PRODUTO VALUES (3, 'Monitor LCD', 10);
INSERT INTO PRODUTO VALUES (4, 'Caixas Acústicas', 10);
INSERT INTO PRODUTO VALUES (5, 'Scanner de Mesa', 10);
INSERT INTO PEDIDO VALUES (1, 1, '2020-04-01', '00001', 400.00);
INSERT INTO PEDIDO VALUES (2, 2, '2020-04-01', '00002', 10.90); 
INSERT INTO PEDIDO VALUES (3, 2, '2020-04-01', '00003', 21.80); 
INSERT INTO PEDIDO VALUES (4, 3, '2020-05-01', '00004', 169.10);
INSERT INTO PEDIDO VALUES (5, 4, '2020-05-01', '00005', 100.90); 
INSERT INTO PEDIDO VALUES (6, 6, '2020-05-02', '00006', 51.35); 

ALTER TABLE CLIENTE
MODIFY codcliente INT auto_increment;

ALTER TABLE PEDIDO
MODIFY codpedido INT auto_increment,
ADD FOREIGN KEY (codcliente)   REFERENCES CLIENTE (codcliente);


ALTER TABLE PRODUTO
MODIFY codproduto INT auto_increment;


ALTER TABLE REQUISICAO_COMPRA
MODIFY codrequisicaocompra INT auto_increment,
ADD FOREIGN KEY (codproduto) REFERENCES PRODUTO(codproduto);


