DROP TABLE IF EXISTS PERSON;
DROP TABLE IF EXISTS CONVERSATION;
DROP TABLE IF EXISTS CONVERSATION_CATEGORY;
DROP TABLE IF EXISTS PERSON_CONVERSATION;
DROP TABLE IF EXISTS MESSAGE;

CREATE TABLE PERSON
(
    id          VARCHAR(50) PRIMARY KEY,
    email       VARCHAR(250) NOT NULL UNIQUE,
    enabled     BOOLEAN          NOT NULL DEFAULT true
);

CREATE TABLE CONVERSATION_CATEGORY
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(50) NOT NULL,
    enabled     BOOLEAN          NOT NULL DEFAULT true
);

CREATE TABLE CONVERSATION
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    con_category_id INT NOT NULL ,
    subject         VARCHAR(MAX) NOT NULL,
    created_at      TIMESTAMP NOT NULL,
    enabled         BOOLEAN  NOT NULL DEFAULT true,
    FOREIGN KEY (con_category_id) REFERENCES CONVERSATION_CATEGORY (id)
);

CREATE TABLE PERSON_CONVERSATION
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    conversation_id     INT NOT NULL ,
    person_id           VARCHAR NOT NULL,
    FOREIGN KEY (conversation_id) REFERENCES CONVERSATION (id),
    FOREIGN KEY (person_id) REFERENCES PERSON (id)
);

CREATE TABLE MESSAGE
(
    id                      INT AUTO_INCREMENT PRIMARY KEY,
    content                 VARCHAR(MAX) NOT NULL,
    person_conversation_id    INT NOT NULL ,
    posted_at                TIMESTAMP NULL,
    updated_at               TIMESTAMP NULL,
    FOREIGN KEY (person_conversation_id) REFERENCES PERSON_CONVERSATION (id)
);


