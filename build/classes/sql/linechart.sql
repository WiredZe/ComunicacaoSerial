DROP DATABASE IF EXISTS linechart;
CREATE DATABASE IF NOT EXISTS linechart;
USE linechart;

-- Tabela que armazena os dados do gráfico.
CREATE TABLE grafico(
	id_grafico INT NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(100),
	nomex VARCHAR(100),
	nomey VARCHAR(100),
	PRIMARY KEY (id_grafico)
);

-- Tabela que armazena os rotulos do eixo x de um determinado gráfico.
CREATE TABLE rotulo_x(
	id_rotulox INT NOT NULL AUTO_INCREMENT,
	id_grafico INT NOT NULL,
	valor VARCHAR(10),
	PRIMARY KEY (id_rotulox),
	FOREIGN KEY (id_grafico) REFERENCES grafico (id_grafico)
);

-- Tabela que armazena os rotulos do eixo y de um determinado gráfico.
CREATE TABLE rotulo_y(
	id_rotuloy INT NOT NULL AUTO_INCREMENT,
	id_grafico INT NOT NULL,
	valor VARCHAR(10),
	PRIMARY KEY (id_rotuloy),
	FOREIGN KEY (id_grafico) REFERENCES grafico (id_grafico)
);

-- Tabela que armazena as coordenadas de um determinado gráfico.
CREATE TABLE coordenadas(
	id_coordenadas INT NOT NULL AUTO_INCREMENT,
	id_grafico INT NOT NULL,
	valor_x DOUBLE,
	valor_y DOUBLE,
	PRIMARY KEY (id_coordenadas),
	FOREIGN KEY (id_grafico) REFERENCES grafico (id_grafico)
);

-- Insert no Banco.

INSERT INTO grafico VALUES (NULL,'Votação','Data','%');

INSERT INTO rotulo_x VALUES (NULL,1,'01/10');
INSERT INTO rotulo_x VALUES (NULL,1,'08/10');
INSERT INTO rotulo_x VALUES (NULL,1,'15/10');
INSERT INTO rotulo_x VALUES (NULL,1,'22/10');

INSERT INTO rotulo_y VALUES (NULL,1,'30%');
INSERT INTO rotulo_y VALUES (NULL,1,'35%');
INSERT INTO rotulo_y VALUES (NULL,1,'40%');
INSERT INTO rotulo_y VALUES (NULL,1,'45%');
INSERT INTO rotulo_y VALUES (NULL,1,'50%');
INSERT INTO rotulo_y VALUES (NULL,1,'55%');
INSERT INTO rotulo_y VALUES (NULL,1,'60%');

INSERT INTO coordenadas VALUES (NULL,1,120.00,500.00);
INSERT INTO coordenadas VALUES (NULL,1,200.00,200.00);
INSERT INTO coordenadas VALUES (NULL,1,300.00,400.00);
INSERT INTO coordenadas VALUES (NULL,1,425.00,125.00);
INSERT INTO coordenadas VALUES (NULL,1,570.00,290.00);
INSERT INTO coordenadas VALUES (NULL,1,600.00,420.00);
INSERT INTO coordenadas VALUES (NULL,1,750.00,125.00);

/*
INSERT INTO grafico (NULL,'Bolsa de valores','Data','Pontos');

INSERT INTO rotulo_x VALUES (NULL,2,'15/10');
INSERT INTO rotulo_x VALUES (NULL,2,'16/10');
INSERT INTO rotulo_x VALUES (NULL,2,'17/10');
INSERT INTO rotulo_x VALUES (NULL,2,'18/10');
INSERT INTO rotulo_x VALUES (NULL,2,'19/10');
INSERT INTO rotulo_x VALUES (NULL,2,'20/10');
INSERT INTO rotulo_x VALUES (NULL,2,'21/10');
INSERT INTO rotulo_x VALUES (NULL,2,'22/10');
INSERT INTO rotulo_x VALUES (NULL,2,'23/10');
INSERT INTO rotulo_x VALUES (NULL,2,'24/10');
INSERT INTO rotulo_x VALUES (NULL,2,'25/10');

INSERT INTO rotulo_y VALUES (NULL,2,'10.0');
INSERT INTO rotulo_y VALUES (NULL,2,'20.0');
INSERT INTO rotulo_y VALUES (NULL,2,'30.0');
INSERT INTO rotulo_y VALUES (NULL,2,'40.0');
INSERT INTO rotulo_y VALUES (NULL,2,'50.0');
INSERT INTO rotulo_y VALUES (NULL,2,'60.0');
INSERT INTO rotulo_y VALUES (NULL,2,'70.0');
INSERT INTO rotulo_y VALUES (NULL,2,'80.0');
INSERT INTO rotulo_y VALUES (NULL,2,'90.0');
INSERT INTO rotulo_y VALUES (NULL,2,'100.0');

INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);
INSERT INTO coordenadas (NULL,2,,);


INSERT INTO grafico VALUES (NULL,'Lucro','Messes','Valor');

INSERT INTO rotulo_x VALUES (NULL,3,'Janeiro');
INSERT INTO rotulo_x VALUES (NULL,3,'Fevereiro');
INSERT INTO rotulo_x VALUES (NULL,3,'Março');
INSERT INTO rotulo_x VALUES (NULL,3,'Abril');
INSERT INTO rotulo_x VALUES (NULL,3,'Maio');
INSERT INTO rotulo_x VALUES (NULL,3,'Junho');
INSERT INTO rotulo_x VALUES (NULL,3,'Julho');
INSERT INTO rotulo_x VALUES (NULL,3,'Agosto');
INSERT INTO rotulo_x VALUES (NULL,3,'Setembro');
INSERT INTO rotulo_x VALUES (NULL,3,'Outubro');
INSERT INTO rotulo_x VALUES (NULL,3,'Novembro');
INSERT INTO rotulo_x VALUES (NULL,3,'Dezembro');

INSERT INTO rotulo_y VALUES (NULL,3,'500.0');
INSERT INTO rotulo_y VALUES (NULL,3,'1000.0');
INSERT INTO rotulo_y VALUES (NULL,3,'1500.0');
INSERT INTO rotulo_y VALUES (NULL,3,'2000.0');
INSERT INTO rotulo_y VALUES (NULL,3,'2500.0');
INSERT INTO rotulo_y VALUES (NULL,3,'3000.0');

INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
INSERT INTO coordenadas (NULL, 3,,);
*/
