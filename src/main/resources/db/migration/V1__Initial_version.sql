CREATE TABLE geo
(
    name     VARCHAR(255) NOT NULL PRIMARY KEY,
    distance BIGINT       NOT NULL,
    orbits   VARCHAR(255),
    is_moon  BOOLEAN      NOT NULL
);

--PLANETS
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('SUN', 0, NULL, FALSE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('MERCURY', 57910006, 'SUN', FALSE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('VENUS', 108199995, 'SUN', FALSE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('EARTH', 149599951, 'SUN', FALSE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('MARS', 227939920, 'SUN', FALSE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('JUPITER', 778330257, 'SUN', FALSE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('SATURN', 1429400028, 'SUN', FALSE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('URANUS', 2870989228, 'SUN', FALSE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('NEPTUNE', 4504299579, 'SUN', FALSE);

--MOONS
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('MOON', 384399, 'EARTH', TRUE);

INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('PHOBOS', 9380, 'MARS', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('DEIMOS', 23460, 'MARS', TRUE);

INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('IO', 421800, 'JUPITER', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('EUROPA', 671100, 'JUPITER', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('GANYMEDE', 1070400, 'JUPITER', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('CALLISTO', 1882700, 'JUPITER', TRUE);

INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('MIMAS', 185540, 'SATURN', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('ENCELADUS', 238040, 'SATURN', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('TETHYS', 294670, 'SATURN', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('DIONE', 377420, 'SATURN', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('RHEA', 527070, 'SATURN', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('TITAN', 1221870, 'SATURN', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('HYPERION', 1500880, 'SATURN', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('LAPETUS', 3560840, 'SATURN', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('PHOEBE', 12947780, 'SATURN', TRUE);

INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('ARIEL', 190900, 'URANUS', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('UMBRIEL', 266000, 'URANUS', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('TITANIA', 436300, 'URANUS', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('OBERON', 583500, 'URANUS', TRUE);
INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('MIRANDA', 129900, 'URANUS', TRUE);

INSERT INTO geo (name, distance, orbits, is_moon) VALUES ('TRITON', 354800, 'NEPTUNE', TRUE);
