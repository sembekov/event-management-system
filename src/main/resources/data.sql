INSERT INTO city (city_name) VALUES ('Astana'), ('Almaty');

INSERT INTO event (event_name, event_author, event_time, location, city_id)
VALUES ('Tech Conference', 'John Doe', '2024-05-03 10:00:00', 'Astana Expo', 1);

INSERT INTO ticket (cost, event_id)
VALUES (50.00, 1);

INSERT INTO participant (first_name, last_name, username, password, email, ticket_id)
VALUES ('Alice', 'Smith', 'alice_s', 'password123', 'alice@example.com', 1);
