CREATE TABLE aircraft_type (
   id SERIAL PRIMARY KEY,
   category VARCHAR(50) NOT NULL,   -- ΜΑΧΗΤΙΚΑ, ΑΦΝΣ, Ε/Π, ΜΕΑ, ΑΛΛΑ
   type_name VARCHAR(100) NOT NULL  -- π.χ. F-16, UAV κλπ
);

CREATE TABLE entry_area (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE friendly_aircraft (
   id SERIAL PRIMARY KEY,
   type_name VARCHAR(100) NOT NULL
);

CREATE TABLE incident (
      id SERIAL PRIMARY KEY,
      incident_date DATE NOT NULL,

      entry_area_id INT REFERENCES entry_area(id),

      friendly_aircraft_id INT REFERENCES friendly_aircraft(id)
);

CREATE TABLE incoming_aircraft (
       id SERIAL PRIMARY KEY,

       incident_id INT REFERENCES incident(id) ON DELETE CASCADE,

       aircraft_type_id INT REFERENCES aircraft_type(id),

       quantity INT DEFAULT 1
);
