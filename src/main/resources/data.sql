INSERT INTO city (city_id, city_name) VALUES (1, 'Astana');
INSERT INTO city (city_id, city_name) VALUES (2, 'Almaty');
INSERT INTO city (city_id, city_name) VALUES (3, 'Shymkent');

INSERT INTO event (event_id, event_name, event_author, event_time, location, city_id)
VALUES (1, 'Concert of XYZ', 'Author1', '2024-05-15 19:00:00', 'City Stadium', 1);

INSERT INTO ticket (ticket_id, cost, event_id)
VALUES (1, 100, 1);

INSERT INTO participant (user_id, first_name, last_name, username, password, email, ticket_id)
VALUES (1, 'John', 'Doe', 'johndoe', 'password123', 'john.doe@gmail.com', 1);
