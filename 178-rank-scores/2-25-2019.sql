SELECT ANY_VALUE(S1.score) 'Score', COUNT(DISTINCT ANY_VALUE(S2.score)) 'Rank' FROM Scores S1 INNER JOIN Scores S2 ON S1.score <= S2.score GROUP BY S1.Id ORDER BY ANY_VALUE(S1.score) DESC;
