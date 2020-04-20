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

insert into content (language, translation_of, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', null, 'Coronavirus: travellers race home amid worldwide border closures and flight warnings', 'A growing number of nations are shutting airports as global Covid-19 infection cases near 200,000', 'Travellers across the world are scrambling to find flights home as governments urged their citizens to return and some nations announced the imminent closure of airports and borders. As coronavirus cases near 200,000 globally, a growing number of countries have imposed lockdowns and barred entry to foreigners. As a result, passengers around the world are navigating rapidly changing travel advice, high fares and cancelled flights. There have been 7,944 deaths worldwide, according to Johns Hopkins University. On Tuesday, the Australian government advised citizens to return home as soon as possible by commercial means, warning that overseas travel was becoming “more complex and difficult” as countries impose travel restrictions. Canada, New Zealand, Indonesia and the United Arab Emirates have issued similar blanket advice. In the UK, the foreign office has continued to issue a flurry of updated guidance for specific countries, warning against all but essential travel to a vast number of countries across Europe, as well as elsewhere. On Tuesday evening, it announced that it was withdrawing some staff from its embassy in Myanmar and told British citizen to leave the country if they were able to do so, adding: This is due to potential pressures on medical facilities and the risk of air routes out of Myanmar being cancelled. In the UK, where 1,960 cases have now been recorded, travellers have been forced to abandon studies, work trips and holidays. Some are racing to arrive home before their own countries announce a lockdown. Countries in Asia, which are anticipating a rush of arrivals from virus hotspots in Europe, are heightening preventative measures to stop new cases from being imported into the country. A growing number of countries globally now require returnees to remain in isolation for 14 days. This also includes many countries in Europe, where leaders have announced plans to close their borders to almost all visitors, with exceptions made for European citizens and residents returning home.', '2020-03-09', 1, 1, 'novel. content 1', 1, 1);
insert into content (language, translation_of, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', null, 'Test headline. Content 2. Type novel', 'Test teaser. Content 2.', 'Test text. Content 2.', '2020-03-09', 0, 0, 'novel. content 2', 1, 1);
insert into content (language, translation_of, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', null, 'Test headline. Content 3. Type Poem', 'Test teaser. Content 3.', 'Test text. Content 3.', '2018-12-19', 0, 0, 'poem. content 3', 1, 2);
insert into content (language, translation_of, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', null, 'Test headline. Content 4. Type Short Story', 'Test teaser. Content 4.', 'Test text. Content 4.', '2019-10-29', 1, 0, 'short story. content 4', 2, 3);
insert into content (language, translation_of, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', null, 'Test headline. Content 5. Type Documentary', 'Test teaser. Content 5.', 'Test text. Content 5.', '2018-05-17', 0, 1, 'documentary. content 5', 2, 4);
insert into content (language, translation_of, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', null, 'Test headline. Content 6. Type Poem',	'Test teaser. Content 6.', 'Test text. Content 6.', '2019-09-18', 1, 0, 'poem. content 6', 3, 2);
insert into content (language, translation_of, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('en', null, 'Test headline. Content 7. Type Short Story',	'Test teaser. Content 7.', 'Test text. Content 7.', '2020-01-01', 0, 1, 'short story. content 7', 3, 3);
insert into content (language, translation_of, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('bn', 6, 'Translation Test headline. Content 6. Type Poem',	'Test teaser. Content 6.', 'Test text. Content 6.', '2019-09-18', 0, 0, 'poem. content 6', 3, 2);
insert into content (language, translation_of, headline, teaser, content_text, creation_date, is_front, is_slider, keyword, user_id, content_category_id) values ('bn', 7, 'Translation Test headline. Content 7. Type Short Story',	'Test teaser. Content 7.', 'Test text. Content 7.', '2020-01-01', 0, 0, 'short story. content 7', 3, 3);

insert into content_image (position, content_id) values ('banner', 1);
insert into content_image (position, content_id) values ('footer', 1);
insert into content_image (position, content_id) values ('banner', 2);
insert into content_image (position, content_id) values ('footer', 2);
insert into content_image (position, content_id) values ('banner', 3);
insert into content_image (position, content_id) values ('banner', 4);
insert into content_image (position, content_id) values ('footer', 4);
insert into content_image (position, content_id) values ('banner', 5);
insert into content_image (position, content_id) values ('footer', 5);
insert into content_image (position, content_id) values ('banner', 6);
insert into content_image (position, content_id) values ('footer', 6);
insert into content_image (position, content_id) values ('banner', 7);
insert into content_image (position, content_id) values ('footer', 7);

insert into event (name, description, place, datetime, organizer, link, is_front, ticket_price) values ('Test event 1', 'Test event 1 description', 'Test event 1 address', '2020-03-19', 'Test event 1 organizer', 'https://www.google.de/', 0, 9.50);
insert into event (name, description, place, datetime, organizer, link, is_front, ticket_price) values ('Test event 2', 'Test event 2 description', 'Test event 2 address', '2020-03-29', 'Test event 2 organizer', 'https://www.xing.com/', 1, 7.50);
insert into event (name, description, place, datetime, organizer, link, is_front, ticket_price) values ('Test event 3', 'Test event 3 description', 'Test event 3 address', '2020-05-25', 'Test event 3 organizer', 'https://github.com/', 1, 11.70);

insert into front_message (message_body, is_active) values ('message body 1', 1)
insert into front_message (message_body, is_active) values ('message body 2', 1)
insert into front_message (message_body, is_active) values ('message body 3', 0)
insert into front_message (message_body, is_active) values ('message body 4', 1)

insert into contact_ticket (name, email, description) values ('Jasim Uddin', 'jasim@test.com', 'Problem 1 description');
insert into contact_ticket (name, email, description) values ('Kazi Nazrul Islam', 'kazi@test.com', 'Problem 2 description');
insert into contact_ticket (name, email, description) values ('Humayan Ahmed', 'humayan@test.com', 'Problem 3 description');
insert into contact_ticket (name, email, description) values ('Sukumar Roy', 'roy@test.com', 'Problem 4 description');