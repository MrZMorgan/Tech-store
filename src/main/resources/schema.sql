CREATE TABLE IF NOT EXISTS computer (
    id INTEGER AUTO_INCREMENT,
    serial_number VARCHAR NOT NULL,
    price BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    form_factor VARCHAR(255) CHECK (form_factor IN ('DESKTOP', 'MONO_BLOCK', 'NET_TOP'))
);

CREATE TABLE IF NOT EXISTS hdd (
    id INTEGER AUTO_INCREMENT,
    serial_number VARCHAR NOT NULL,
    price BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    capacity VARCHAR(255) check (capacity IN ('GB_128', 'GB_256', 'GB_512', 'TB_1', 'TB_2'))
);

CREATE TABLE IF NOT EXISTS laptop (
    id INTEGER AUTO_INCREMENT,
    serial_number VARCHAR NOT NULL,
    price BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    screen_size VARCHAR(255) CHECK (screen_size IN ('INC_13', 'INC_14', 'INC_15', 'INC_16', 'INC_17'))
);

CREATE TABLE IF NOT EXISTS monitor (
    id INTEGER AUTO_INCREMENT,
    serial_number VARCHAR NOT NULL,
    price BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    screen_size VARCHAR(255) CHECK (screen_size IN ('INC_14', 'INC_15', 'INC_17', 'INC_22', 'INC_24', 'INC_27'))
);
