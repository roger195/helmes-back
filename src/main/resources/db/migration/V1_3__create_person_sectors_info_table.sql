CREATE TABLE person_info (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    session_id VARCHAR(255) UNIQUE NOT NULL,
    is_terms_accepted BOOLEAN NOT NULL
);

CREATE TABLE person_sectors_info (
     id SERIAL PRIMARY KEY,
     person_id INT NOT NULL,
     sector_key INT NOT NULL,
     FOREIGN KEY (person_id) REFERENCES person_info(id),
     FOREIGN KEY (sector_key) REFERENCES sectors(key)
);


