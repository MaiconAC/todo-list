CREATE TABLE account (
	id_account SERIAL PRIMARY KEY,
	email varchar(255) UNIQUE NOT NULL,
	first_name varchar(200) NOT NULL,
	last_name varchar(200) NOT NULL,
	password varchar(128) NOT NULL
);

CREATE TABLE list (
	id_list SERIAL PRIMARY KEY,
	list_title varchar(255) NOT NULL,
	id_admin int NOT NULL REFERENCES account(id_account)
);

CREATE TABLE list_account (
	id_list_account SERIAL PRIMARY KEY,
	id_list int NOT NULL REFERENCES list(id_list),
	id_account int NOT NULL REFERENCES account(id_account)
);

CREATE TABLE section (
	id_section SERIAL PRIMARY KEY,
	section_title varchar(255) NOT NULL,
	id_list int NOT NULL REFERENCES list(id_list) 
);

CREATE TABLE task (
	id_task SERIAL PRIMARY KEY,
	id_list int NOT NULL REFERENCES list(id_list),
	id_section int REFERENCES section(id_section),
	name varchar(128) NOT NULL,
	description text,
	due_date TIMESTAMP,
	done boolean NOT NULL DEFAULT FALSE,
	finished_date TIMESTAMP
);

CREATE TABLE tag (
	id_tag SERIAL PRIMARY KEY,
	description varchar(255) NOT NULL
);

CREATE TABLE task_tag (
	id_task_tag SERIAL PRIMARY KEY,
	id_task int NOT NULL REFERENCES task(id_task),
	id_tag int NOT NULL REFERENCES tag(id_tag)
);