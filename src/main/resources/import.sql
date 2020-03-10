-- This data will only be loaded when spring.jpa.hibernate.ddl-auto in application.properties is create/create-drop

insert into user_type (name) values ('Admin');
insert into user_type (name) values ('Content Maker');

insert into user (first_name, last_name, email, birth_date, password, is_active, user_type_id) values ('Riaz', 'Ahmed', 'riaz@test.com', '1980-02-01', 'test12345', 1, 1);
insert into user (first_name, last_name, email, birth_date, password, is_active, user_type_id) values ('Md Emtazul', 'Haque', 'emtaz@test.com', '1995-01-01', 'test12345', 1, 2);
insert into user (first_name, last_name, email, birth_date, password, is_active, user_type_id) values ('Anas', 'Ahmed', 'anas@test.com', '1992-11-09', 'test12345', 1, 2);
 
insert into content_category (name) values ('Novel');
insert into content_category (name) values ('Poem');
insert into content_category (name) values ('Short Story');
insert into content_category (name) values ('Documentary');

insert into content (language, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', 'Test headline. Content 1. Type novel', 'Test teaser. Content 1.', 'Test text. Content 1.', '2020-03-09', 1, 1, 'novel. content 1', 1, 1);
insert into content (language, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', 'Test headline. Content 2. Type novel', 'Test teaser. Content 2.', 'Test text. Content 2.', '2020-03-09', 0, 0, 'novel. content 2', 1, 1);
insert into content (language, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', 'Test headline. Content 3. Type Poem', 'Test teaser. Content 3.', 'Test text. Content 3.', '2018-12-19', 0, 0, 'Poem. content 3', 1, 2);
insert into content (language, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', 'Test headline. Content 4. Type Short Story', 'Test teaser. Content 4.', 'Test text. Content 4.', '2019-10-29', 1, 0, 'Short Story. content 4', 2, 3);
insert into content (language, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', 'Test headline. Content 5. Type Documentary', 'Test teaser. Content 5.', 'Test text. Content 5.', '2018-05-17', 0, 1, 'Documentary. content 5', 2, 4);
insert into content (language, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', 'Test headline. Content 6. Type Poem',	'Test teaser. Content 6.', 'Test text. Content 6.', '2019-09-18', 1, 0, 'Poem. content 6', 3, 2);
insert into content (language, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', 'Test headline. Content 7. Type Short Story',	'Test teaser. Content 7.', 'Test text. Content 7.', '2020-01-01', 0, 1, 'Short Story. content 7', 3, 3);
 
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/1/banner.jpg', 'Banner', 1);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/1/right1.jpg', 'Right 1', 1);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/1/left2.jpg', 'Left 2', 1);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/1/footer.jpg', 'Footer', 1);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/2/banner.jpg', 'Banner', 2);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/2/right2.jpg', 'Right 2', 2);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/2/left1.jpg', 'Left 1', 2);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/2/footer.jpg', 'Footer', 2);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/3/banner.jpg', 'Banner', 3);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/3/right1.jpg', 'Right 1', 3);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/3/right2.jpg', 'Right 2', 3);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/4/banner.jpg', 'Banner', 4);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/4/right2.jpg', 'Right 2', 4);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/4/footer.jpg', 'Footer', 4);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/5/banner.jpg', 'Banner', 5);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/5/right1.jpg', 'Right 1', 5);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/5/footer.jpg', 'Footer', 5);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/6/banner.jpg', 'Banner', 6);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/6/left1.jpg', 'Left 1', 6);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/6/footer.jpg', 'Footer', 6);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/7/banner.jpg', 'Banner', 7);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/7/left2.jpg', 'Left 2', 7);
insert into content_image (location, position, content_id) values ('/resources/images/contentImage/7/footer.jpg', 'Footer', 7);

insert into event (name, description, place, datetime, organizer, link, image_location, is_front, ticket_price) values ('Test event 1', 'Test event 1 description', 'Test event 1 address', '2020-03-19', 'Test event 1 organizer', 'https://www.google.de/', '/resources/images/eventImage/1.jpg', 0, 9.50);
insert into event (name, description, place, datetime, organizer, link, image_location, is_front, ticket_price) values ('Test event 2', 'Test event 2 description', 'Test event 2 address', '2020-03-29', 'Test event 2 organizer', 'https://www.xing.com/', '/resources/images/eventImage/2.jpg', 1, 7.50);
insert into event (name, description, place, datetime, organizer, link, image_location, is_front, ticket_price) values ('Test event 3', 'Test event 3 description', 'Test event 3 address', '2020-05-25', 'Test event 3 organizer', 'https://github.com/', '/resources/images/eventImage/3.jpg', 0, 11.70);

insert into front_message (message_body, is_active) values ('message body 1', 0)
insert into front_message (message_body, is_active) values ('message body 2', 1)

insert into contact_ticket (first_name, last_name, email, description) values ('Jasim', 'Uddin', 'jasim@test.com', 'Problem 1 description');
insert into contact_ticket (first_name, last_name, email, description) values ('Kazi', 'Nazrul', 'kazi@test.com', 'Problem 2 description');
insert into contact_ticket (first_name, last_name, email, description) values ('Humayan', 'Ahmed', 'humayan@test.com', 'Problem 3 description');
insert into contact_ticket (first_name, last_name, email, description) values ('Sukumar', 'Roy', 'roy@test.com', 'Problem 4 description');