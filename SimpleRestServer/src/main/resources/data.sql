INSERT INTO state(code, description) VALUES(0, 'TODO');
INSERT INTO state(code, description) VALUES(1, 'IN-PROGRESS');
INSERT INTO state(code, description) VALUES(2, 'FINISHED');

INSERT INTO card(title, description, state_code) VALUES('Test Card 1', 'This is a test TODO', 0);
INSERT INTO card(title, description, state_code) VALUES('Test Card 2', 'This is a test IN-PROGRESS', 1);
INSERT INTO card(title, description, state_code) VALUES('Test Card 3', 'This is a test IN-PROGRESS', 1);
INSERT INTO card(title, description, state_code) VALUES('Test Card 4', 'This is a test IN-PROGRESS', 1);
INSERT INTO card(title, description, state_code) VALUES('Test Card 5', 'This is a test FINISHED', 2);