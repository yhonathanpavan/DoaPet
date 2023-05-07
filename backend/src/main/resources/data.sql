INSERT INTO PROFILE(ID, NAME) VALUES
(1,'ROLE_ADMIN'),
(2,'ROLE_ONG'),
(3,'ROLE_DONOR');

INSERT INTO ONG (NAME, EMAIL, PASSWORD, PHONE_NUMBER, STREET, NUMBER, NEIGHBORHOOD, CITY, STATE, CNPJ, PIX, PRESIDENT_NAME, BIOGRAPHY, STATUS) VALUES
('ONG Focinhos Carinhosos', 'focinhoscarinhosos@email.com', '$2a$10$julfXhCK3/khOeqXy.KcpuyePdWGsWXOLrAgT.l317p7maTStANQO', '11982746982', 'Alameda Piratuba', '198', 'Residencial Morada dos Lagos', 'Barueri', 'SP','91310562000197','focinhoscarinhosos@email.com','Benedito Vicente Ribeiro','A Focinhos Carinhosos atua na cidade de Barueri desde 2007, prestando serviços e ajudando os animaizinhos necessitados.', 'TRUE');

INSERT INTO ONG_PROFILES(ONG_ID, PROFILES_ID) VALUES
(1, 2);


INSERT INTO DONOR (NAME, EMAIL, PASSWORD, PHONE_NUMBER, STREET, NUMBER, NEIGHBORHOOD, CITY, STATE, CPF, BIRTHDATE, STATUS) VALUES
('Eduardo Pedro Henrique Luiz Ramos', 'eduardo.pedro.ramos@multmed.com.br', '$2a$10$julfXhCK3/khOeqXy.KcpuyePdWGsWXOLrAgT.l317p7maTStANQO', '11999693910', 'Via de Pedestre Sonho de Verão', '339', 'Parque Guaianazes', 'São Paulo', 'SP','92188673859','2003-03-01', 'TRUE');

INSERT INTO DONOR_PROFILES(DONOR_ID, PROFILES_ID) VALUES
(1, 3);
