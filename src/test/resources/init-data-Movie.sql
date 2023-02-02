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

TRUNCATE TABLE MOVIE CASCADE;
INSERT INTO MOVIE 	( id, id_tenant
			,TITLE
			,HOMEPAGE
			,OVERVIEW
			,POPULARITY
			,REVENUE
			,MOVIE_STATUS
			,TAGLINE
			,VOTE_AVERAGE
			)values(1, 101
			, 'title movie1'
			, 'homepage movie1'
			, 'overview movie1'
			, 'popularity movie1'
			, 'revenue movie1'
			, 'status movie1'
			, 'tagline movie1'
			, 'voteAverage movie1'
			);
INSERT INTO MOVIE 	( id, id_tenant
			,TITLE
			,HOMEPAGE
			,OVERVIEW
			,POPULARITY
			,REVENUE
			,MOVIE_STATUS
			,TAGLINE
			,VOTE_AVERAGE
			)values(2, 101
			, 'title movie2'
			, 'homepage movie2'
			, 'overview movie2'
			, 'popularity movie2'
			, 'revenue movie2'
			, 'status movie2'
			, 'tagline movie2'
			, 'voteAverage movie2'
			);
INSERT INTO MOVIE 	( id, id_tenant
			,TITLE
			,HOMEPAGE
			,OVERVIEW
			,POPULARITY
			,REVENUE
			,MOVIE_STATUS
			,TAGLINE
			,VOTE_AVERAGE
			)values(3, 101
			, 'title movie3'
			, 'homepage movie3'
			, 'overview movie3'
			, 'popularity movie3'
			, 'revenue movie3'
			, 'status movie3'
			, 'tagline movie3'
			, 'voteAverage movie3'
			);
INSERT INTO MOVIE 	( id, id_tenant
			,TITLE
			,HOMEPAGE
			,OVERVIEW
			,POPULARITY
			,REVENUE
			,MOVIE_STATUS
			,TAGLINE
			,VOTE_AVERAGE
			)values(4, 101
			, 'title movie4'
			, 'homepage movie4'
			, 'overview movie4'
			, 'popularity movie4'
			, 'revenue movie4'
			, 'status movie4'
			, 'tagline movie4'
			, 'voteAverage movie4'
			);
INSERT INTO MOVIE 	( id, id_tenant
			,TITLE
			,HOMEPAGE
			,OVERVIEW
			,POPULARITY
			,REVENUE
			,MOVIE_STATUS
			,TAGLINE
			,VOTE_AVERAGE
			)values(5, 101
			, 'title movie5'
			, 'homepage movie5'
			, 'overview movie5'
			, 'popularity movie5'
			, 'revenue movie5'
			, 'status movie5'
			, 'tagline movie5'
			, 'voteAverage movie5'
			);
