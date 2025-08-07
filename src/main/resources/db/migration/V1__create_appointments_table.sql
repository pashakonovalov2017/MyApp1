
CREATE TABLE appointments(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    content VARCHAR(255),
    date_time TIMESTAMP,
    appointment_type INTEGER CHECK (appointment_type IN (0,1))
);