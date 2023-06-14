-- Include ONG

INSERT INTO ONG (NAME, EMAIL, PASSWORD, PHONE_NUMBER, STREET, NUMBER, NEIGHBORHOOD, CITY, STATE, CNPJ, PIX, PRESIDENT_NAME, BIOGRAPHY, STATUS) VALUES
('ONG Focinhos Carinhosos', 'focinhoscarinhosos@email.com', '$2a$10$julfXhCK3/khOeqXy.KcpuyePdWGsWXOLrAgT.l317p7maTStANQO', '11982746982', 'Alameda Piratuba', '198', 'Residencial Morada dos Lagos', 'Barueri', 'SP','91310562000197','focinhoscarinhosos@email.com','Benedito Vicente Ribeiro','A Focinhos Carinhosos atua na cidade de Barueri desde 2007, prestando serviços e ajudando os animaizinhos necessitados.', 'TRUE');

INSERT INTO ONG (NAME, EMAIL, PASSWORD, PHONE_NUMBER, STREET, NUMBER, NEIGHBORHOOD, CITY, STATE, CNPJ, PIX, PRESIDENT_NAME, BIOGRAPHY, STATUS) VALUES
('ONG Patinhas Saudáveis', 'patinhassaudaveis@email.com', '$2a$10$julfXhCK3/khOeqXy.KcpuyePdWGsWXOLrAgT.l317p7maTStANQO', '11991702576', 'Rua dos Jequitibás', '847', 'Campestre', 'Santo André', 'SP','15461962000115','patinhassaudaveis@email.com','Renata Jacomani dos Santos','A Patinhas Saudaveis é uma ONG que visa ajudar os animais de rua e em estado de necessidade da cidade de Santo André-SP', 'TRUE');


-- Include Donor

INSERT INTO DONOR (NAME, EMAIL, PASSWORD, PHONE_NUMBER, STREET, NUMBER, NEIGHBORHOOD, CITY, STATE, CPF, BIRTHDATE, STATUS) VALUES
('Eduardo Pedro Henrique Luiz Ramos', 'eduardo.pedro.ramos@multmed.com.br', '$2a$10$julfXhCK3/khOeqXy.KcpuyePdWGsWXOLrAgT.l317p7maTStANQO', '11999693910', 'Via de Pedestre Sonho de Verão', '339', 'Parque Guaianazes', 'São Paulo', 'SP','92188673859','2003-03-01', 'TRUE');


-- Include Assistance

INSERT INTO ASSISTANCE (ASSISTANCE_CATEGORY, NAME, PRICE, STATUS) VALUES
('HEALTH', 'Castração', '90.00', 'true');

INSERT INTO ASSISTANCE (ASSISTANCE_CATEGORY, NAME, PRICE, STATUS) VALUES
('HEALTH', 'Remoção de carrapatos', '42.99', 'true');

INSERT INTO ASSISTANCE (ASSISTANCE_CATEGORY, NAME, PRICE, STATUS) VALUES
('AESTHETICS', 'Limpeza profunda', '10.99', 'true');


-- Include Product

INSERT INTO PRODUCT  (MEASURE, NAME, PRICE, PRODUCT_CATEGORY, STATUS) VALUES
('UNITS', 'Vermifugo', '20.45', 'HEALTH', 'true');

INSERT INTO PRODUCT  (MEASURE, NAME, PRICE, PRODUCT_CATEGORY, STATUS) VALUES
('UNITS', 'Antiparasitário', '42.99', 'HEALTH', 'true');

INSERT INTO PRODUCT  (MEASURE, NAME, PRICE, PRODUCT_CATEGORY, STATUS) VALUES
('LITERS', 'Máquina de Tosa', '199.99', 'TOOL', 'true');


-- Include Order

INSERT INTO TB_ORDER  (DATE, ORDER_STATUS, PRIORITY_LEVEL_STATUS, QUANTITY,	TOTAL_PRICE, ONG_ID, PRODUCT_ID) VALUES
('2023-06-12', 'PENDING', 'MEDIUM', '2', '40.90', '1', '1');

INSERT INTO TB_ORDER  (DATE, ORDER_STATUS, PRIORITY_LEVEL_STATUS, QUANTITY,	TOTAL_PRICE, ONG_ID, ASSISTANCE_ID) VALUES
('2023-06-13', 'PENDING', 'HIGH', '5', '450.00', '1', '1');

INSERT INTO TB_ORDER  (DATE, ORDER_STATUS, PRIORITY_LEVEL_STATUS, QUANTITY,	TOTAL_PRICE, ONG_ID, ASSISTANCE_ID) VALUES
('2023-06-10', 'PENDING', 'LOW', '1', '199.99', '2', '1');