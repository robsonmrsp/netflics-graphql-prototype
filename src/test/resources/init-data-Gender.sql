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

TRUNCATE TABLE GENDER CASCADE;
INSERT INTO GENDER 	( id, id_tenant
			,GENDER
			)values(1, 101
			, 'gender gender1'
			);
INSERT INTO GENDER 	( id, id_tenant
			,GENDER
			)values(2, 101
			, 'gender gender2'
			);
INSERT INTO GENDER 	( id, id_tenant
			,GENDER
			)values(3, 101
			, 'gender gender3'
			);
INSERT INTO GENDER 	( id, id_tenant
			,GENDER
			)values(4, 101
			, 'gender gender4'
			);
INSERT INTO GENDER 	( id, id_tenant
			,GENDER
			)values(5, 101
			, 'gender gender5'
			);
