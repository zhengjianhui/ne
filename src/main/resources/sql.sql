CREATE TABLE command_content(
	id INT UNSIGNED KEY AUTO_INCREMENT,
	content VARCHAR(2048),
	command_id INT
)


CREATE TABLE command(
	id INT UNSIGNED KEY AUTO_INCREMENT,
	COMMAND VARCHAR(16),
	DESCRIPTION VARCHAR(11)
)