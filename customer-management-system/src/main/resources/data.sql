-- src/main/resources/data.sql
-- Initial master data
INSERT INTO country (id, name)
VALUES (1, 'Sri Lanka'), (2, 'India')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO city (id, name, country_id)
VALUES (1, 'Colombo', 1),
       (2, 'Kandy',   1),
       (3, 'Mumbai',  2)
    ON DUPLICATE KEY UPDATE name = VALUES(name);
