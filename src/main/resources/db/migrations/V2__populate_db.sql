INSERT INTO Client (id, name) VALUES
(1, 'Alice Johnson'),
(2, 'Bob Smith'),
(3, 'Carol Williams'),
(4, 'David Brown'),
(5, 'Emma Davis'),
(6, 'Frank Miller'),
(7, 'Grace Wilson'),
(8, 'Henry Moore'),
(9, 'Ivy Taylor'),
(10, 'Jack Anderson');

INSERT INTO Planet (id, name) VALUES
 ('EARTH', 'Earth'),
 ('MARS', 'Mars'),
 ('VENUS', 'Venus'),
 ('SATURN', 'Saturn'),
 ('JUPITER', 'Jupiter');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id, created_at) VALUES
(1, 'EARTH', 'MARS', '2023-01-01 10:00:00'),
(2, 'MARS', 'VENUS', '2023-01-02 11:00:00'),
(3, 'VENUS', 'JUPITER', '2023-01-03 12:00:00'),
(4, 'JUPITER', 'SATURN', '2023-01-04 13:00:00'),
(5, 'SATURN', 'EARTH', '2023-01-05 14:00:00'),
(6, 'EARTH', 'VENUS', '2023-01-06 15:00:00'),
(7, 'MARS', 'JUPITER', '2023-01-07 16:00:00'),
(8, 'VENUS', 'SATURN', '2023-01-08 17:00:00'),
(9, 'JUPITER', 'EARTH', '2023-01-09 18:00:00'),
(10, 'SATURN', 'MARS', '2023-01-10 19:00:00');