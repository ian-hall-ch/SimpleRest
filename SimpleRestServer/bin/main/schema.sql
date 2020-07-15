CREATE TABLE STATE(code NUMBER PRIMARY KEY,
                   description VARCHAR2(30) NOT NULL,
                   last_modified DATE);

CREATE TABLE CARD(id BIGINT PRIMARY KEY AUTO_INCREMENT,
                  title VARCHAR2(100) NOT NULL,
                  description VARCHAR2(2000) NOT NULL,
                  state_code NUMBER,
                  last_modified DATE,
                  CONSTRAINT FK_STATE FOREIGN KEY (state_code) REFERENCES STATE(code));