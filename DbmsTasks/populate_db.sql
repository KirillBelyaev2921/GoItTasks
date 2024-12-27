INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('Kyrylo', '2001-09-02', 'Trainee', 100);
INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('Lukas', '1952-12-29', 'Junior', 500);
INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('Lara', '1968-08-07', 'Junior', 500);
INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('Hill', '1968-11-02', 'Middle', 1000);
INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('Liana', '1968-12-31', 'Middle', 1000);
INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('Dillan', '1974-10-27', 'Senior', 2000);
INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('John', '1979-09-14', 'Senior', 2000);
INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('Sophie', '1985-05-14', 'Senior', 5000);
INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('Wilson', '1989-08-19', 'Senior', 5000);
INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('Lynn', '1990-09-01', 'Senior', 10000);

INSERT INTO client(NAME)
VALUES ('Mcgee');
INSERT INTO client(NAME)
VALUES ('Seren');
INSERT INTO client(NAME)
VALUES ('Ray');
INSERT INTO client(NAME)
VALUES ('Watkins');
INSERT INTO client(NAME)
VALUES ('Ortega');

INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (1, '2021-01-24', '2022-11-28');
INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (1, '2021-01-25', '2023-09-02');
INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (2, '2021-05-10', '2023-10-15');
INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (2, '2021-07-25', '2023-10-30');
INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (3, '2021-09-08', '2024-01-21');
INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (3, '2021-12-06', '2024-03-04');
INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (4, '2021-12-19', '2024-06-19');
INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (4, '2022-03-24', '2024-08-20');
INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (5, '2022-04-07', '2024-10-23');
INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (5, '2022-04-13', '2024-11-14');

INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (1, 1);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (2, 1);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (2, 2);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (3, 1);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (3, 2);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (3, 3);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (4, 1);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (4, 2);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (4, 3);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (4, 4);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (5, 1);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (5, 2);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (5, 3);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (5, 4);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (5, 5);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (6, 6);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (7, 6);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (7, 7);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (8, 6);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (8, 7);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (8, 8);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (9, 6);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (9, 7);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (9, 8);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (9, 9);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (10, 6);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (10, 7);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (10, 8);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (10, 9);
INSERT INTO project_worker(PROJECT_ID, WORKER_ID)
VALUES (10, 10);