SELECT NAME, COUNT(ID) AS PROJECT_COUNT
FROM worker w
         JOIN project_worker pw on w.ID = pw.WORKER_ID
GROUP BY ID
HAVING PROJECT_COUNT =
       (SELECT MAX(x.count)
        FROM (SELECT COUNT(ID) count
              FROM worker w
                       JOIN project_worker pw on w.ID = pw.WORKER_ID
              GROUP BY ID) x)
