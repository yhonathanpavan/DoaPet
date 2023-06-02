INSERT INTO PROFILE(ID, NAME) VALUES
(1,'ROLE_ADMIN'),
(2,'ROLE_ONG'),
(3,'ROLE_DONOR');

-- Include ONG
INSERT INTO ONG (NAME, EMAIL, PASSWORD, PHONE_NUMBER, STREET, NUMBER, NEIGHBORHOOD, CITY, STATE, CNPJ, PIX, PRESIDENT_NAME, BIOGRAPHY, STATUS) VALUES
('ONG Focinhos Carinhosos', 'focinhoscarinhosos@email.com', '$2a$10$julfXhCK3/khOeqXy.KcpuyePdWGsWXOLrAgT.l317p7maTStANQO', '11982746982', 'Alameda Piratuba', '198', 'Residencial Morada dos Lagos', 'Barueri', 'SP','91310562000197','focinhoscarinhosos@email.com','Benedito Vicente Ribeiro','A Focinhos Carinhosos atua na cidade de Barueri desde 2007, prestando serviços e ajudando os animaizinhos necessitados.', 'TRUE');

INSERT INTO ONG (NAME, EMAIL, PASSWORD, PHONE_NUMBER, STREET, NUMBER, NEIGHBORHOOD, CITY, STATE, CNPJ, PIX, PRESIDENT_NAME, BIOGRAPHY, STATUS) VALUES
('ONG Patinhas Saudáveis', 'patinhassaudaveis@email.com', '$2a$10$julfXhCK3/khOeqXy.KcpuyePdWGsWXOLrAgT.l317p7maTStANQO', '11991702576', 'Rua dos Jequitibás', '847', 'Campestre', 'Santo André', 'SP','15461962000115','patinhassaudaveis@email.com','Renata Jacomani dos Santos','A Patinhas Saudaveis é uma ONG que visa ajudar os animais de rua e em estado de necessidade da cidade de Santo André-SP. Desde 2014 seguimos prestando serviços dos mais variados tipos, com o objetivo de transformar o mundo em um lugar melhor para nossos amigos pets', 'TRUE');

INSERT INTO ONG_PROFILES(ONG_ID, PROFILES_ID) VALUES
(1, 2);

INSERT INTO ONG_PROFILES(ONG_ID, PROFILES_ID) VALUES
(2, 2);


-- Include Donor
INSERT INTO DONOR (NAME, EMAIL, PASSWORD, PHONE_NUMBER, STREET, NUMBER, NEIGHBORHOOD, CITY, STATE, CPF, BIRTHDATE, STATUS) VALUES
('Eduardo Pedro Henrique Luiz Ramos', 'eduardo.pedro.ramos@multmed.com.br', '$2a$10$julfXhCK3/khOeqXy.KcpuyePdWGsWXOLrAgT.l317p7maTStANQO', '11999693910', 'Via de Pedestre Sonho de Verão', '339', 'Parque Guaianazes', 'São Paulo', 'SP','92188673859','2003-03-01', 'TRUE');

INSERT INTO DONOR_PROFILES(DONOR_ID, PROFILES_ID) VALUES
(1, 3);


-- Include Assistance
INSERT INTO ASSISTANCE (ASSISTANCE_CATEGORY, NAME, PRICE, STATUS, ONG_ID) VALUES
('HEALTH', 'Castração', '20.45', 'true', '1');

INSERT INTO ASSISTANCE (ASSISTANCE_CATEGORY, NAME, PRICE, STATUS, ONG_ID) VALUES
('HEALTH', 'Remoção de carrapatos', '42.99', 'true', '2');

INSERT INTO ASSISTANCE (ASSISTANCE_CATEGORY, NAME, PRICE, STATUS, ONG_ID) VALUES
('AESTHETICS', 'Limpeza profunda', '10.99', 'true', '1');


-- Include Product
INSERT INTO PRODUCT  (MEASURE, NAME, PRICE, PRODUCT_CATEGORY, STATUS, ONG_ID) VALUES
('UNITS', 'Vermifugo', '20.45', 'HEALTH', 'true', '1');

INSERT INTO PRODUCT  (MEASURE, NAME, PRICE, PRODUCT_CATEGORY, STATUS, ONG_ID) VALUES
('UNITS', 'Antiparasitário', '42.99', 'HEALTH', 'true', '2');

INSERT INTO PRODUCT  (MEASURE, NAME, PRICE, PRODUCT_CATEGORY, STATUS, ONG_ID) VALUES
('LITERS', 'Máquina de Tosa', '199.99', 'TOOL', 'true', '1');
