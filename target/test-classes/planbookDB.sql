INSERT INTO day (dayId, dayOfTheWeek) VALUES (1, "Monday");
INSERT INTO day (dayId, dayOfTheWeek) VALUES (2, "Tuesday");
INSERT INTO day (dayId, dayOfTheWeek) VALUES (3, "Wednesday");
INSERT INTO day (dayId, dayOfTheWeek) VALUES (4, "Thursday");
INSERT INTO day (dayId, dayOfTheWeek) VALUES (5, "Friday");

INSERT INTO grade (gradeNumber, gradeName) VALUES (1, "FirstGrade");
INSERT INTO grade (gradeNumber, gradeName) VALUES (2, "SecondGrade");
INSERT INTO grade (gradeNumber, gradeName) VALUES (3, "ThirdGrade");
-- INSERT INTO grade (gradeNumber, gradeName) VALUES (4, "FourthGrade");
-- INSERT INTO grade (gradeNumber, gradeName) VALUES (5, "FifthGrade");

INSERT INTO subject (subjectId, subjectName) VALUES (1, "Math");
INSERT INTO subject (subjectId, subjectName) VALUES (2, "ELA");
INSERT INTO subject (subjectId, subjectName) VALUES (3, "Science");
INSERT INTO subject (subjectId, subjectName) VALUES (4, "Social Studies");

INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (1, "Geometry", 1, 1);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (2, "PlaceValue", 1, 1);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (3, "AdditionAndSubtraction", 1, 1);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (4, "Measurement", 1, 1);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (5, "Time", 1, 1);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (6, "Money", 1, 1);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (7, "Data", 1, 1);

INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (8, "Geometry", 1, 2);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (9, "PlaceValue", 1, 2);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (10, "AdditionAndSubtraction", 1, 2);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (11, "Measurement", 1, 2);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (12, "Time", 1, 2);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (13, "Money", 1, 2);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (14, "Data", 1, 2);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (15, "Multiplication", 1, 2);

INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (16, "Geometry", 1, "3");
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (17, "PlaceValue", 1, 3);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (18, "AdditionAndSubtraction", 1, 3);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (19, "Measurement", 1, 3);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (20, "Time", 1, 3);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (21, "Data", 1, 3);
INSERT INTO unit (unitId, unitName, subjectId, gradeNumber) VALUES (22, "MultilpicationAndDivision", 1, 3);

INSERT INTO lesson (lessonName, objective, content, unitId) VALUES ("User Created Lesson1", "User Created Lesson1_Objective", "User Created Lesson1_Content", 1);
INSERT INTO lesson (lessonName, objective, content, unitId) VALUES ("User Created Lesson2", "User Created Lesson2_Objective", "User Created Lesson2_Content", 1);
INSERT INTO lesson (lessonName, objective, content, unitId) VALUES ("User Created Lesson3", "User Created Lesson 3_Objective", "User Created Lesson3_Content", 1);