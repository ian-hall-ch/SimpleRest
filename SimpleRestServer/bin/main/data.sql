INSERT INTO state(code, description, last_modified) VALUES(0, 'TODO', SYSDATE);
INSERT INTO state(code, description, last_modified) VALUES(1, 'IN-PROGRESS', SYSDATE);
INSERT INTO state(code, description, last_modified) VALUES(2, 'FINISHED', SYSDATE);

INSERT INTO card(title, description, state_code, last_modified) VALUES('Test Card 1', 'This is a test TODO', 0, SYSDATE);
INSERT INTO card(title, description, state_code, last_modified) VALUES('Test Card 2', 'This is a test IN-PROGRESS', 1, SYSDATE);
INSERT INTO card(title, description, state_code, last_modified) VALUES('Test Card 3', 'This is a test IN-PROGRESS', 1, SYSDATE);
INSERT INTO card(title, description, state_code, last_modified) VALUES('Test Card 4', 'This is a test IN-PROGRESS', 1, SYSDATE);
INSERT INTO card(title, description, state_code, last_modified) VALUES('Test Card 5', 'This is a test FINISHED', 2, SYSDATE);