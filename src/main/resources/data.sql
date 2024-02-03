INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES (1, 'teo@gmail.com', 'Teodor', 'Trendafilov', null, 1,
        '$2a$10$0FG2toqSiiXx0im0t9Hez.zqnYXtdSo8ho/AxYdUtjnVPBQmMsNvy');

INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_URL)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/800px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://upload.wikimedia.org/wikipedia/commons/2/2c/97-02_Ford_Escort_sedan.jpg'),
       (3, 'Yaris', 'CAR', 1999, 2000, 2, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/1200px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg');