 ALTER SEQUENCE hibernate_sequence RESTART WITH 10001;

 TRUNCATE TABLE tenant CASCADE;
 TRUNCATE TABLE app_user CASCADE;
 TRUNCATE TABLE role CASCADE;
 TRUNCATE TABLE user_role CASCADE;
 TRUNCATE TABLE revinfo CASCADE;

 INSERT INTO tenant (id, cnpj, corporate_name,  phone_number, logo, name) values (101,'','JSetup Developer', '997608620','','JSetup Developer');

 INSERT INTO role( id, authority, description)  VALUES (101, 'ROLE_USER', 'Usuário do sistema');
 INSERT INTO app_user( id, id_tenant, enable, image, name, password, username, email) VALUES (101, 101, true, '', 'Usuário JSetup Comum', '$2a$10$teJrCEnsxNT49ZpXU7n22O27aCGbVYYe/RG6/XxdWPJbOLZubLIi2', 'jsetup', 'contato@jsetup.com');
 INSERT INTO user_role(id_role, id_user) values (101, 101);

TRUNCATE TABLE COUNTRY CASCADE;
INSERT INTO COUNTRY 	( id, id_tenant
			,NAME
			,COUNTRY_ISO_CODE
			)values(1, 101
			, 'name country1'
			, 'isoCode country1'
			);
INSERT INTO COUNTRY 	( id, id_tenant
			,NAME
			,COUNTRY_ISO_CODE
			)values(2, 101
			, 'name country2'
			, 'isoCode country2'
			);
INSERT INTO COUNTRY 	( id, id_tenant
			,NAME
			,COUNTRY_ISO_CODE
			)values(3, 101
			, 'name country3'
			, 'isoCode country3'
			);
INSERT INTO COUNTRY 	( id, id_tenant
			,NAME
			,COUNTRY_ISO_CODE
			)values(4, 101
			, 'name country4'
			, 'isoCode country4'
			);
INSERT INTO COUNTRY 	( id, id_tenant
			,NAME
			,COUNTRY_ISO_CODE
			)values(5, 101
			, 'name country5'
			, 'isoCode country5'
			);