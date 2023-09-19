INSERT INTO exemplos.fabricantes (nome, cnpj, cidade, cep, uf)
VALUES('Ouro', '11222333000022', 'Sao Jose', '88101150', 'SC');

INSERT INTO exemplos.fabricantes (nome, cnpj, cidade, cep, uf)
VALUES('Pelé', '11222333000028', 'Palhoca', '88501150', 'SC');

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 1, 12.5, 0.5, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 2, 10.0, 0.5, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Chinela de tira', 1, 80.5, 0.2, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Chinela pesada', 2, 70.2, 0.3, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Chinela super pesada', 2, 90.2, 5.0, sysdate());