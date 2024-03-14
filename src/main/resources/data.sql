CREATE TABLE IF NOT EXISTS article (
                         id BIGINT AUTO_INCREMENT primary key,
                         title varchar(255) not null,
                         content varchar(255) not null
);

INSERT INTO article (title, content, created_at, updated_at) VALUES ('블로그 제목', '블로그 내용', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('블로그 제목2', '블로그 내용2', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('블로그 제목3', '블로그 내용3', NOW(), NOW());