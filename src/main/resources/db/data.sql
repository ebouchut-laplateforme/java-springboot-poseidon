-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- src/main/Resopurces/db/data.sql
--
-- Populate the poseidon development database tables with seed data.
-- Add 2 users.
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

INSERT INTO Users(
    fullname,
    username,
    password,
    role
) VALUES (
    "Administrator",
    "admin",
    "$2a$10$pBV8ILO/s/nao4wVnGLrh.sa/rnr5pDpbeC4E.KNzQWoy8obFZdaa", "ADMIN"
 );

INSERT INTO Users(
    fullname,
    username,
    password,
    role
) VALUES (
    "User",
    "user",
    "$2a$10$pBV8ILO/s/nao4wVnGLrh.sa/rnr5pDpbeC4E.KNzQWoy8obFZdaa",
    "USER"
);