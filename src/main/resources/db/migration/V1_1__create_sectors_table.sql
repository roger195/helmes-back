CREATE TABLE sectors (
    id SERIAL PRIMARY KEY,
    key INT UNIQUE,
    label VARCHAR(255) NOT NULL,
    parent_sector_key INT,
    FOREIGN KEY (parent_sector_key) REFERENCES sectors(key)
);
