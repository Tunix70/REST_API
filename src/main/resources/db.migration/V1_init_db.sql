CREATE TABLE IF NOT EXISTS users
(
    user_id INT,
    name VARCHAR(25),
    primary key (user_id)
);

INSERT INTO users (user_id, name)
VALUES (1, 'Nick');
INSERT INTO users (user_id, name)
VALUES (2, 'Mike');
INSERT INTO users (user_id, name)
VALUES (3, 'Dave');
INSERT INTO users (user_id, name)
VALUES (4, 'Ron');