CREATE TABLE `books` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(35) NOT NULL,
                         `year` int NOT NULL,
                         `author_id` int DEFAULT '1',
                         PRIMARY KEY (`id`),
                         KEY `fl_books` (`author_id`),
                         CONSTRAINT `fl_books` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`) ON DELETE SET NULL
);
CREATE TABLE `authors` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(35) NOT NULL,
                           PRIMARY KEY (`id`)
);
CREATE TABLE `member` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(35) NOT NULL,
                          `telephone_number` varchar(25) NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `telephone_number` (`telephone_number`)
);
CREATE TABLE `library` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `book_id` int NOT NULL,
                           `member_id` int NOT NULL,
                           `is_active` bit(1) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `unique_book_member` (`book_id`,`member_id`),
                           KEY `fl_book` (`book_id`),
                           KEY `fl_member` (`member_id`),
                           CONSTRAINT `fl_book` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON UPDATE CASCADE,
                           CONSTRAINT `fl_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
);