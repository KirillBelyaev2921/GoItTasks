SELECT p.ID, SUM(SALARY) PRICE FROM PROJECT p
INNER JOIN project_worker pw ON p.ID = PW.PROJECT_ID
INNER JOIN worker w ON pw.WORKER_ID = w.ID
GROUP BY p.ID
ORDER BY PRICE DESC;