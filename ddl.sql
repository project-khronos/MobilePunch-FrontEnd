CREATE TABLE IF NOT EXISTS ProjectEntity (`project_id1` INTEGER NOT NULL,
`project_id2` INTEGER NOT NULL,
`client_id1` INTEGER NOT NULL,
`client_id2` INTEGER NOT NULL,
`name` TEXT,
`start_time` INTEGER,
`end_time` INTEGER,
`expected_end_time` INTEGER,
`description` TEXT,
PRIMARY KEY(`project_id1`,
`project_id2`),
FOREIGN KEY(`client_id1`,
`client_id2`) REFERENCES `ClientEntity`(`client_id1`,
`client_id2`) ON UPDATE NO ACTION ON DELETE NO ACTION )


CREATE TABLE IF NOT EXISTS EventEntity (`event_id1` INTEGER NOT NULL,
`event_id2` INTEGER NOT NULL,
`event_start_date` INTEGER,
`event_end_date` INTEGER,
`expenses` REAL, `income` REAL,
`description` TEXT,
`longitude` REAL NOT NULL,
`latitude` REAL NOT NULL,
`project_id1` INTEGER NOT NULL,
`project_id2` INTEGER NOT NULL,
`equipment_id1` INTEGER NOT NULL,
`equipment_id2` INTEGER NOT NULL,
PRIMARY KEY(`event_id1`, `event_id2`),
FOREIGN KEY(`project_id1`,
`project_id2`) REFERENCES `ProjectEntity`(`project_id1`,
`project_id2`) ON UPDATE NO ACTION ON DELETE NO ACTION ,
FOREIGN KEY(`equipment_id1`,
`equipment_id2`) REFERENCES `EquipmentEntity`(`equipment_id1`,
`equipment_id2`) ON UPDATE NO ACTION ON DELETE NO ACTION )


CREATE TABLE IF NOT EXISTS ClientEntity (`client_id1` INTEGER NOT NULL,
`client_id2` INTEGER NOT NULL,
`name` TEXT, `email` TEXT,
`alt_phone` TEXT, `phone` TEXT,
`address` TEXT, `alt_address` TEXT,
`notes` TEXT, PRIMARY KEY(`client_id1`,
`client_id2`))

CREATE TABLE IF NOT EXISTS EquipmentEntity (`equipment_id1` INTEGER NOT NULL,
`equipment_id2` INTEGER NOT NULL, `name` TEXT,
`make` TEXT, `model` TEXT, `mfcyear` TEXT,
`identification` TEXT NOT NULL, `description` TEXT,
PRIMARY KEY(`equipment_id1`, `equipment_id2`))

CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)

INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"f3d01c7dca42c05c1c516bdd26be0c29\")
