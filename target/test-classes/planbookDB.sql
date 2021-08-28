INSERT INTO subject (name) VALUES ('Math');
INSERT INTO subject (name) VALUES ('ELA');
INSERT INTO subject (name) VALUES ('Science');

INSERT INTO user (name) VALUES ('Staples');
INSERT INTO user (name) VALUES ('Crosby');
INSERT INTO user (name) VALUES ('Mincks');

INSERT INTO unit (name, subject_id) VALUES ('Geometry', 1);
INSERT INTO unit (name, subject_id) VALUES ('Fractions', 1);
INSERT INTO unit (name, subject_id) VALUES ('Place Value', 1);

INSERT INTO student_group (name, user_id) VALUES ('2A', 2);
INSERT INTO student_group (name, user_id) VALUES ('2B', 3);
INSERT INTO student_group (name, user_id) VALUES ('2C', 1);


INSERT INTO lesson (name, objective, content, unit_id) VALUES ('Identifying 2-D Shapes', 'The student will identify 2 dimensional shapes such as trapezoids, rhombuses, pentagons, hexagons,
octagons, parallelograms, and quadrilaterals', 'lesson content', 1);
INSERT INTO lesson (name, objective, content, unit_id) VALUES ('Identifying 3-D Shapes', 'The student will identify 3 dimensional shapes such as cubes, spheres, cylinders, cones, triangular
prisms, and rectangular prisms', 'lesson content', 1);
INSERT INTO lesson (name, objective, content, unit_id) VALUES ('Recognize and Draw Shapes', 'The student will recognize and draw shapes', 'lesson content', 1);

