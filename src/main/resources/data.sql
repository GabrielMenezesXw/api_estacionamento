--
insert into tb_endereco(logradouro, cep)
values
('rua aleatoria numero 123', '1234567890').
('rua suspeita numero 123', '1234567890'),
('Passo da areia 21', '9423596871'),
('Jardim são pedro 111', '1123659845'),
('Belém Velho 212', '3652369859'),
('Cristal 1678', '0123569874'),
('São Bento 1516',  '2013265984'),
('São carlos 632', '6532658974'),
('São tito 145', '1230236598'),
('São limo 123', '5346984299');
--
INSERT INTO tb_assinante(nome, cpf, credito_total, endereco_id)
VALUES
('João Cláudio Albuquerque', '01655489709', 200, 1),
( 'Pedro Mendes', '01616489772', 10, 2),
('Carlos Eduardo', '02155489704', 25, 3),
('Vladimir Pinto', '01623789712', 150 , 4),
('Johanna Baptista', '01697389752', 90, 5),
('daniel', '1928472942', 1, 500),
('gabriel', '1348472942', 2, 120);
--
insert into tb_veiculo(tipo_veiculo, placa, assinante_id)
values
('CARRO', 'c137g23', 1),
('MOTO', 'c137g23', 4),
('CARRO', 'c137g23', 2),
('MOTO', 'c137g23', 5),
('CARRO', 'c137g23', 7),
('CARRO', 'c137g23', 3),
('MOTO', 'c157g26', 6);
--
insert into tb_tarifa(tipo_tarifa, tipo_veiculo ,valor)
values
('ATE_MEIA_HORA', 'MOTO',15.0),
('ATE_UMA_HORA','CARRO' ,10.0);
--
insert into tb_conta(entrada, saida, veiculo_id)
values
('2022-06-13 09:10:01' ,null, 1),
('2022-06-13 09:10:01' ,null, 5),
('2022-06-13 09:10:01' ,null, 7),
('2022-06-13 09:10:01' ,null, 3),
('2022-06-13 09:10:01' ,null, 4),
('2022-06-13 09:10:01' ,null, 2);


