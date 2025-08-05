
BEGIN;

DELETE FROM appointments;

ALTER SEQUENCE public.appointments_id_seq RESTART WITH 1;

COMMIT;