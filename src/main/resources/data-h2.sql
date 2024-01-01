INSERT INTO PERSON (id, email, enabled) VALUES ('v987456', 'email@email.com', true);
INSERT INTO PERSON (id, email, enabled) VALUES ('x12345', 'email_2@email.com', true);

INSERT INTO CONVERSATION_CATEGORY (description, enabled) VALUES ('health', true);
INSERT INTO CONVERSATION_CATEGORY (description, enabled) VALUES ('school', true);

INSERT INTO CONVERSATION (con_category_id, subject, created_at, enabled) VALUES (1, 'Anxiety symptoms in Teenagers', current_timestamp, true);
INSERT INTO CONVERSATION (con_category_id, subject, created_at, enabled) VALUES (2, 'How to recognize difficulties in Maths?', current_timestamp, true);

INSERT INTO PERSON_CONVERSATION (conversation_id, person_id) VALUES (1, 'v987456');
INSERT INTO PERSON_CONVERSATION (conversation_id, person_id) VALUES (2, 'v987456');


INSERT INTO MESSAGE (content, person_conversation_id, posted_at) VALUES ('Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.', 1, current_timestamp);
INSERT INTO MESSAGE (content, person_conversation_id, posted_at) VALUES ('There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.', 2, current_timestamp);