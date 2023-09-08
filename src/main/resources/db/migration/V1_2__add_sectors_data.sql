INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (1, 'Manufacturing', NULL),
     (3, 'Other', NULL),
     (2, 'Service', NULL);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (19, 'Construction materials', 1),
     (18, 'Electronics and Optics', 1),
     (6, 'Food and Beverage', 1),
     (13, 'Furniture', 1),
     (12, 'Machinery', 1),
     (11, 'Metalworking', 1),
     (9, 'Plastic and Rubber', 1),
     (5, 'Printing', 1),
     (7, 'Textile and Clothing', 1),
     (8, 'Wood', 1);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (342, 'Bakery & confectionery products', 6),
     (43, 'Beverages', 6),
     (42, 'Fish & fish products', 6),
     (40, 'Meat & meat products', 6),
     (39, 'Milk & dairy products', 6),
     (437, 'Other', 6),
     (378, 'Sweets & snack food', 6);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (389, 'Bathroom/sauna', 13),
     (385, 'Bedroom', 13),
     (390, 'Children’s room', 13),
     (98, 'Kitchen', 13),
     (101, 'Living room', 13),
     (392, 'Office', 13),
     (394, 'Other (Furniture)', 13),
     (341, 'Outdoor', 13),
     (99, 'Project furniture', 13);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (94, 'Machinery components', 12),
     (91, 'Machinery equipment/tools', 12),
     (224, 'Manufacture of machinery', 12),
     (97, 'Maritime', 12),
     (271, 'Aluminium and steel workboats', 97),
     (269, 'Boat/Yacht building', 97),
     (230, 'Ship repair and conversion', 97),
     (93, 'Metal structures', 12),
     (508, 'Other (Metal structures)', 93),
     (227, 'Repair and maintenance service', 12);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (67, 'Construction of metal structures', 11),
     (263, 'Houses and buildings', 11),
     (267, 'Metal products', 11),
     (542, 'Metal works', 267),
     (75, 'CNC-machining', 11),
     (62, 'Forgings, Fasteners', 11),
     (69, 'Gas, Plasma, Laser cutting', 11),
     (66, 'MIG, TIG, Aluminum welding', 11);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (54, 'Packaging', 9),
     (556, 'Plastic goods', 9),
     (559, 'Plastic processing technology', 9),
     (55, 'Blowing', 559),
     (57, 'Moulding', 559),
     (53, 'Plastics welding and processing', 559),
     (560, 'Plastic profiles', 9);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (148, 'Advertising', 5),
     (150, 'Book/Periodicals printing', 5),
     (145, 'Labelling and packaging printing', 5);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (44, 'Clothing', 7),
     (45, 'Textile', 7);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (337, 'Other (Wood)', 8),
     (51, 'Wooden building materials', 8),
     (47, 'Wooden houses', 8);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (37, 'Creative industries', 3),
     (29, 'Energy technology', 3),
     (33, 'Environment', 3);

INSERT INTO sectors (key, label, parent_sector_key) VALUES
     (25, 'Business services', 2),
     (35, 'Engineering', 2),
     (28, 'Information Technology and Telecommunications', 2),
     (581, 'Data processing, Web portals, E-marketing', 28),
     (576, 'Programming, Consultancy', 28),
     (121, 'Software, Hardware', 28),
     (122, 'Telecommunications', 28),
     (22, 'Tourism', 2),
     (141, 'Translation services', 2),
     (21, 'Transport and Logistics', 2),
     (111, 'Air', 21),
     (114, 'Rail', 21),
     (112, 'Road', 21),
     (113, 'Water', 21);