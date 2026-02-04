create database if not exists coursedb

use coursedb;


DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS trainer;

CREATE TABLE trainer (
    tid INT PRIMARY KEY AUTO_INCREMENT,
    tname VARCHAR(50) NOT NULL,
    experience INT NOT NULL
);

CREATE TABLE course (
    cid INT PRIMARY KEY AUTO_INCREMENT,
    cname VARCHAR(50) NOT NULL,
    duration INT NOT NULL,
    start_date DATE NOT NULL,
    tid INT,
    CONSTRAINT fk_trainer
        FOREIGN KEY (tid)
        REFERENCES trainer(tid)
        ON DELETE CASCADE
);

-- Trainers
INSERT INTO trainer (tname, experience) VALUES
('Ravi Kumar', 10),
('Anita Sharma', 8),
('Suresh Patil', 12),
('Neha Verma', 6),
('Amit Joshi', 15);

-- Courses
INSERT INTO course (cname, duration, start_date, tid) VALUES
('Java Full Stack', 120, '2025-02-01', 1),
('Python with ML', 100, '2025-02-10', 2),
('Spring Framework', 80, '2025-03-01', 1),
('Web Development', 90, '2025-03-05', 4),
('Data Structures', 70, '2025-03-15', 5);


