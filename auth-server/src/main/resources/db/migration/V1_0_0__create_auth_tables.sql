create table if not exists oauth_client_details (
                                      client_id VARCHAR(256) PRIMARY KEY,
                                      resource_ids VARCHAR(256),
                                      client_secret VARCHAR(256),
                                      scope VARCHAR(256),
                                      authorized_grant_types VARCHAR(256),
                                      web_server_redirect_uri VARCHAR(256),
                                      authorities VARCHAR(256),
                                      access_token_validity INTEGER,
                                      refresh_token_validity INTEGER,
                                      additional_information VARCHAR(4096),
                                      autoapprove VARCHAR(256)
);

create table if not exists oauth_client_token (
                                    token_id VARCHAR(256),
                                    token bytea,
                                    authentication_id VARCHAR(256) PRIMARY KEY,
                                    user_name VARCHAR(256),
                                    client_id VARCHAR(256)
);

create table if not exists oauth_access_token (
                                    token_id VARCHAR(256),
                                    token bytea,
                                    authentication_id VARCHAR(256) PRIMARY KEY,
                                    user_name VARCHAR(256),
                                    client_id VARCHAR(256),
                                    authentication bytea,
                                    refresh_token VARCHAR(256)
);

create table if not exists oauth_refresh_token (
                                     token_id VARCHAR(256),
                                     token bytea,
                                     authentication bytea
);

create table if not exists oauth_code (
                            code VARCHAR(256), authentication bytea
);

create table if not exists oauth_approvals (
                                 userId VARCHAR(256),
                                 clientId VARCHAR(256),
                                 scope VARCHAR(256),
                                 status VARCHAR(10),
                                 expiresAt TIMESTAMP,
                                 lastModifiedAt TIMESTAMP
);

create table if not exists users (
                                     id serial NOT NULL PRIMARY KEY,
                                     username varchar(100) NOT NULL,
                                     "password" varchar(2048) NOT NULL,
                                     email varchar(1024) NOT NULL,
                                     account_non_expired bool NOT NULL DEFAULT true,
                                     credentials_non_expired bool NOT NULL DEFAULT true,
                                     account_non_locked bool NOT NULL DEFAULT true,
                                     enabled bool NOT NULL DEFAULT true
);

create table if not exists authorities (
                                           user_id integer NOT NULL,
                                           authority varchar(2048) NOT NULL,
                                           CONSTRAINT authorities_pkey PRIMARY KEY (user_id)
);
