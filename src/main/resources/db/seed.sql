SET @quiz_id_1 := UUID();
SET @quiz_id_2 := UUID();
SET @quiz_id_3 := UUID();
SET @quiz_id_4 := UUID();
SET @quiz_id_5 := UUID();
SET @quiz_id_6 := UUID();
SET @quiz_id_7 := UUID();
SET @quiz_id_8 := UUID();
SET @quiz_id_9 := UUID();
SET @quiz_id_10 := UUID();

SET @question_id_1 := UUID();
SET @question_id_2 := UUID();
SET @question_id_3 := UUID();
SET @question_id_4 := UUID();
SET @question_id_5 := UUID();
SET @question_id_6 := UUID();
SET @question_id_7 := UUID();
SET @question_id_8 := UUID();
SET @question_id_9 := UUID();
SET @question_id_10 := UUID();

SET @answer_id_1 := UUID();
SET @answer_id_2 := UUID();
SET @answer_id_3 := UUID();
SET @answer_id_4 := UUID();
SET @answer_id_5 := UUID();
SET @answer_id_6 := UUID();
SET @answer_id_7 := UUID();
SET @answer_id_8 := UUID();
SET @answer_id_9 := UUID();
SET @answer_id_10 := UUID();

SET @MULTIPLE_CHOICE = 'MULTIPLE_CHOICE';
SET @FILL_IN_THE_BLANK = 'FILL_IN_THE_BLANK',
SET @MULTI_SELECT = 'MULTI_SELECT',
SET @MULTIPLE_CHOICE = 'MULTIPLE_CHOICE',
SET @ORDERING = 'ORDERING',
SET @RUE_OR_FALSE = 'RUE_OR_FALSE'

INSERT INTO quiz (id, title, creator)
VALUES
  (@quiz_id_1, 'Backend Design and Architecture', 'Quizio'),
  (@quiz_id_2, 'System Design Fundamentals', 'Quizio'),
  (@quiz_id_3, 'Modern API Development', 'Quizio'),
  (@quiz_id_4, 'Data Structures in Practice', 'Quizio'),
  (@quiz_id_5, 'Microservices Deep Dive', 'Quizio'),
  (@quiz_id_6, 'Secure Coding Essentials', 'Quizio'),
  (@quiz_id_7, 'Database Optimization', 'Quizio'),
  (@quiz_id_8, 'Clean Code Principles', 'Quizio'),
  (@quiz_id_9, 'DevOps Foundations', 'Quizio'),
  (@quiz_id_10, 'Concurrency in Java', 'Quizio');

INSERT INTO question (id, quiz_id, answer_id, type, text)
VALUES
    (@question_id_1, @quiz_id_1, @answer_id_1, @MULTIPLE_CHOICE, 'What is the main purpose of backend architecture in software development?'),
    (@question_id_2, @quiz_id_2, @answer_id_2, @MULTIPLE_CHOICE, 'Which of the following is a key principle of scalable system design?'),
    (@question_id_3, @quiz_id_3, @answer_id_3, @MULTIPLE_CHOICE, 'What is the main advantage of using RESTful APIs in modern application development?'),
    (@question_id_4, @quiz_id_4, @answer_id_4, @MULTIPLE_CHOICE, 'Which data structure provides the fastest average-time complexity for searching an element?'),
    (@question_id_5, @quiz_id_5, @answer_id_5, @MULTIPLE_CHOICE, 'What is a primary benefit of using a microservices architecture?'),
    (@question_id_6, @quiz_id_6, @answer_id_6, @MULTIPLE_CHOICE, 'Which of the following practices helps prevent SQL injection attacks?'),
    (@question_id_7, @quiz_id_7, @answer_id_7, @MULTIPLE_CHOICE, 'What is the primary purpose of creating indexes in a database?'),
    (@question_id_8, @quiz_id_8, @answer_id_8, @MULTIPLE_CHOICE, 'Which of the following best reflects the principle of writing clean code?'),
    (@question_id_9, @quiz_id_9, @answer_id_9, @MULTIPLE_CHOICE, 'What is one of the main goals of DevOps in modern software development?'),
    (@question_id_10, @quiz_id_10, @answer_id_10, @MULTIPLE_CHOICE, 'Which Java class is commonly used to create a new thread of execution?')

INSERT INTO option (id, question_id, place, text)
VALUES
    (@answer_id_1, @question_id_1, 'A', 'To manage data storage, business logic, and server-side operations'),
    (UUID(), @question_id_1, 'B', 'To design the user interface and user experience'),
    (UUID(), @question_id_1, 'C', 'To create graphics and animations for the app'),
    (UUID(), @question_id_1, 'D', 'To handle client-side scripting and interactions'),

    (@answer_id_2, @question_id_2, 'A', 'Ensuring the system can handle increased load by adding resources (horizontal scaling)'),
    (UUID(), @question_id_2, 'B', 'Minimizing the number of servers regardless of load'),
    (UUID(), @question_id_2, 'C', 'Using monolithic architecture to simplify deployment'),
    (UUID(), @question_id_2, 'D', 'Avoiding data redundancy at all costs'),

    (@answer_id_3, @question_id_3, 'A', 'They allow stateless communication and scalability over HTTP'),
    (UUID(), @question_id_3, 'B', 'They require a persistent connection between client and server'),
    (UUID(), @question_id_3, 'C', 'They enforce tight coupling between client and server'),
    (UUID(), @question_id_3, 'D', 'They only support XML data format'),

    (@answer_id_4, @question_id_4, 'A', 'Hash Table'),
    (UUID(), @question_id_4, 'B', 'Linked List'),
    (UUID(), @question_id_4, 'C', 'Binary Search Tree (balanced)'),
    (UUID(), @question_id_4, 'D', 'Array'),

    (@answer_id_5, @question_id_5, 'A', 'Enables independent development, deployment, and scaling of services'),
    (UUID(), @question_id_5, 'B', 'Simplifies deployment by bundling all services into one application'),
    (UUID(), @question_id_5, 'C', 'Requires fewer servers compared to monolithic architecture'),
    (UUID(), @question_id_5, 'D', 'Avoids network communication between components'),

    (@answer_id_6, @question_id_6, 'A', 'Validating and sanitizing user inputs and using prepared statements'),
    (UUID(), @question_id_6, 'B', 'Using dynamic SQL queries constructed with string concatenation'),
    (UUID(), @question_id_6, 'C', 'Storing passwords in plain text for easy retrieval'),
    (UUID(), @question_id_6, 'D', 'Disabling all database access controls'),

    (@answer_id_7, @question_id_7, 'A', 'To speed up data retrieval operations'),
    (UUID(), @question_id_7, 'B', 'To prevent unauthorized access to data'),
    (UUID(), @question_id_7, 'C', 'To reduce the size of the database'),
    (UUID(), @question_id_7, 'D', 'To ensure foreign key constraints'),

    (@answer_id_8, @question_id_8, 'A', 'Using meaningful variable and function names'),
    (UUID(), @question_id_8, 'B', 'Writing clever one-liners to reduce file length'),
    (UUID(), @question_id_8, 'C', 'Adding as many comments as possible to explain every line'),
    (UUID(), @question_id_8, 'D', 'Minimizing whitespace and indentation for compactness'),

    (@answer_id_9, @question_id_9, 'A', 'To foster collaboration between development and operations for faster and more reliable delivery'),
    (UUID(), @question_id_9, 'B', 'To separate development and operations teams to reduce complexity'),
    (UUID(), @question_id_9, 'C', 'To speed up deployment by skipping testing phases'),
    (UUID(), @question_id_9, 'D', 'To eliminate the need for continuous integration and deployment tools'),

    (@answer_id_10, @question_id_10, 'A', 'Thread'),
    (UUID(), @question_id_10, 'B', 'Scanner'),
    (UUID(), @question_id_10, 'C', 'Collections'),
    (UUID(), @question_id_10, 'D', 'RunnableFuture')