CREATE TABLE IF NOT EXISTS Practice (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    timeStarted timestamp NOT NULL,
    timeEnded timestamp NOT NULL,
    topicsCovered VARCHAR(255) NOT NULL,
    codingLanguage VARCHAR(30) NOT NULL,
    version INT
);