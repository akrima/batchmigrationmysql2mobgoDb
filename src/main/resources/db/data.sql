-- Users
INSERT INTO users (username, email, password, first_name, last_name, created_at, updated_at)
VALUES
    ('user1', 'user1@example.com', 'password1', 'John', 'Doe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user2', 'user2@example.com', 'password2', 'Jane', 'Smith', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user3', 'user3@example.com', 'password3', 'Bob', 'Johnson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user4', 'user4@example.com', 'password4', 'Alice', 'Williams', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user5', 'user5@example.com', 'password5', 'Charlie', 'Brown', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user6', 'user6@example.com', 'password6', 'Emma', 'Davis', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user7', 'user7@example.com', 'password7', 'Frank', 'Miller', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user8', 'user8@example.com', 'password8', 'Grace', 'Jones', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user9', 'user9@example.com', 'password9', 'Henry', 'Smith', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user10', 'user10@example.com', 'password10', 'Ivy', 'Johnson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user11', 'user11@example.com', 'password11', 'Jack', 'Davis', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user12', 'user12@example.com', 'password12', 'Kelly', 'Brown', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user13', 'user13@example.com', 'password13', 'Leo', 'Miller', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user14', 'user14@example.com', 'password14', 'Mia', 'Jones', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user15', 'user15@example.com', 'password15', 'Nathan', 'Smith', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user16', 'user16@example.com', 'password16', 'Olivia', 'Johnson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user17', 'user17@example.com', 'password17', 'Peter', 'Davis', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user18', 'user18@example.com', 'password18', 'Quinn', 'Brown', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user19', 'user19@example.com', 'password19', 'Rachel', 'Miller', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user20', 'user20@example.com', 'password20', 'Sam', 'Jones', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user21', 'user21@example.com', 'password21', 'Tom', 'Smith', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user22', 'user22@example.com', 'password22', 'Ursula', 'Johnson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user23', 'user23@example.com', 'password23', 'Victor', 'Davis', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user24', 'user24@example.com', 'password24', 'Wendy', 'Brown', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user25', 'user25@example.com', 'password25', 'Xavier', 'Miller', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user26', 'user26@example.com', 'password26', 'Yvonne', 'Jones', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user27', 'user27@example.com', 'password27', 'Zack', 'Smith', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user28', 'user28@example.com', 'password28', 'Eva', 'Johnson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user29', 'user29@example.com', 'password29', 'Oscar', 'Davis', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('user30', 'user30@example.com', 'password30', 'Lily', 'Brown', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);



-- Products
INSERT INTO products (name, description, price, stock_quantity, created_at, updated_at)
VALUES
    ('Product A', 'Description for Product A', 29.99, 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product B', 'Description for Product B', 39.99, 150, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product C', 'Description for Product C', 49.99, 200, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product D', 'Description for Product D', 19.99, 80, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product E', 'Description for Product E', 59.99, 120, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product F', 'Description for Product F', 69.99, 90, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product G', 'Description for Product G', 24.99, 110, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product H', 'Description for Product H', 34.99, 180, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product I', 'Description for Product I', 44.99, 70, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product J', 'Description for Product J', 54.99, 130, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product K', 'Description for Product K', 64.99, 160, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product L', 'Description for Product L', 74.99, 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product M', 'Description for Product M', 27.99, 190, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product N', 'Description for Product N', 37.99, 60, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product O', 'Description for Product O', 47.99, 140, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product P', 'Description for Product P', 57.99, 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product Q', 'Description for Product Q', 67.99, 120, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product R', 'Description for Product R', 77.99, 80, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product S', 'Description for Product S', 21.99, 150, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product T', 'Description for Product T', 31.99, 110, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product U', 'Description for Product U', 41.99, 170, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product V', 'Description for Product V', 51.99, 90, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product W', 'Description for Product W', 61.99, 130, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product X', 'Description for Product X', 71.99, 70, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product Y', 'Description for Product Y', 81.99, 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product Z', 'Description for Product Z', 23.99, 120, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product AA', 'Description for Product AA', 33.99, 80, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product BB', 'Description for Product BB', 43.99, 150, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product CC', 'Description for Product CC', 53.99, 110, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product DD', 'Description for Product DD', 63.99, 180, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product EE', 'Description for Product EE', 73.99, 70, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Product FF', 'Description for Product FF', 83.99, 130, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- Orders
INSERT INTO orders (user_id, order_date, total_amount, status, created_at, updated_at)
VALUES
    (1, '2024-01-01 12:00:00', 79.98, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, '2024-01-02 13:30:00', 129.75, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, '2024-01-03 14:45:00', 49.99, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, '2024-01-04 10:15:00', 89.50, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5, '2024-01-05 16:20:00', 179.99, 'Pending', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (6, '2024-01-06 09:00:00', 64.75, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (7, '2024-01-07 11:45:00', 94.20, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (8, '2024-01-08 15:10:00', 124.50, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (9, '2024-01-09 14:30:00', 54.99, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (10, '2024-01-10 17:05:00', 134.75, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (11, '2024-01-11 08:30:00', 74.50, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (12, '2024-01-12 18:15:00', 114.99, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (13, '2024-01-13 16:40:00', 64.75, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (14, '2024-01-14 10:20:00', 94.20, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (15, '2024-01-15 11:30:00', 124.50, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (16, '2024-01-16 15:00:00', 34.99, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (17, '2024-01-17 09:45:00', 144.75, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (18, '2024-01-18 14:10:00', 54.50, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (19, '2024-01-19 13:20:00', 84.99, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (20, '2024-01-20 16:45:00', 124.75, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (21, '2024-01-21 12:30:00', 49.50, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (22, '2024-01-22 10:55:00', 134.99, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (23, '2024-01-23 17:25:00', 74.75, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (24, '2024-01-24 11:40:00', 94.50, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (25, '2024-01-25 14:15:00', 124.99, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (26, '2024-01-26 15:50:00', 64.75, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (27, '2024-01-27 09:10:00', 114.20, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (28, '2024-01-28 13:35:00', 84.50, 'Shipped', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (29, '2024-01-29 16:05:00', 44.99, 'Completed', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (30, '2024-01-30 10:30:00', 134.75, 'Processing', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- Order Items
-- Order Items
INSERT INTO order_items (order_id, product_id, quantity, subtotal, created_at, updated_at)
VALUES
    (1, 1, 2, 59.98, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 2, 1, 49.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, 3, 3, 179.97, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, 4, 2, 189.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5, 5, 1, 134.75, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (6, 6, 2, 188.40, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (7, 7, 3, 282.60, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (8, 8, 1, 124.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (9, 9, 4, 219.96, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (10, 10, 2, 269.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (11, 11, 1, 74.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (12, 12, 3, 344.97, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (13, 13, 2, 129.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (14, 14, 1, 94.20, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (15, 15, 2, 249.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (16, 16, 1, 34.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (17, 17, 3, 434.25, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (18, 18, 2, 109.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (19, 19, 1, 84.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (20, 20, 4, 498.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (21, 21, 1, 49.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (22, 22, 2, 269.98, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (23, 23, 3, 224.25, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (24, 24, 1, 94.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (25, 25, 2, 249.98, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (26, 26, 1, 64.75, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (27, 27, 3, 342.60, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (28, 28, 2, 169.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (29, 29, 1, 84.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (30, 30, 4, 179.96, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);



-- Addresses
INSERT INTO addresses (user_id, street, city, state, zip_code, country, created_at, updated_at)
VALUES
    (1, '123 Main St', 'Cityville', 'Stateville', '12345', 'Countryland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, '456 Oak St', 'Townsville', 'Provinceville', '56789', 'Countryville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, '789 Pine St', 'Villagetown', 'Territoryville', '98765', 'Landville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, '321 Maple St', 'Hamletville', 'Regionville', '54321', 'Worldland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5, '654 Birch St', 'Metropolis', 'Districtville', '13579', 'Globaland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (6, '987 Cedar St', 'Citytown', 'Countyville', '24680', 'Planetland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (7, '135 Elm St', 'Suburbville', 'Countryville', '86420', 'Universeville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (8, '246 Pineapple St', 'Townville', 'Provinceville', '11111', 'Continentland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (9, '543 Banana St', 'Villageland', 'Territoryville', '22222', 'Landland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (10, '876 Orange St', 'Cityland', 'Stateville', '33333', 'Countryland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (11, '109 Apple St', 'Hamletland', 'Regionville', '44444', 'Worldville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (12, '210 Mango St', 'Metroville', 'Districtville', '55555', 'Globaland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (13, '431 Cherry St', 'Suburbland', 'Countyville', '66666', 'Planetland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (14, '652 Lemon St', 'Villageland', 'Territoryville', '77777', 'Universeville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (15, '873 Lime St', 'Citytown', 'Stateville', '88888', 'Continentland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (16, '194 Grape St', 'Townville', 'Provinceville', '99999', 'Landland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (17, '385 Strawberry St', 'Villagetown', 'Territoryville', '10101', 'Countryville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (18, '576 Blueberry St', 'Hamletville', 'Regionville', '20202', 'Worldland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (19, '767 Raspberry St', 'Metropolis', 'Districtville', '30303', 'Globaland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (20, '958 Blackberry St', 'Cityville', 'Stateville', '40404', 'Planetland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (21, '149 Cranberry St', 'Townsville', 'Provinceville', '50505', 'Universeville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (22, '350 Watermelon St', 'Villagetown', 'Territoryville', '60606', 'Continentland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (23, '551 Kiwi St', 'Hamletville', 'Regionville', '70707', 'Landland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (24, '752 Pineapple St', 'Citytown', 'Stateville', '80808', 'Countryland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (25, '953 Banana St', 'Suburbville', 'Countyville', '90909', 'Worldville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (26, '154 Orange St', 'Metroville', 'Districtville', '12345', 'Globaland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (27, '355 Apple St', 'Suburbland', 'Countyville', '23456', 'Planetland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (28, '556 Mango St', 'Villageland', 'Territoryville', '34567', 'Universeville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (29, '757 Cherry St', 'Cityland', 'Stateville', '45678', 'Continentland', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (30, '958 Lemon St', 'Townland', 'Provinceville', '56789', 'Landville', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);




-- Comments
-- Comments
INSERT INTO comments (user_id, product_id, comment_text, created_at, updated_at)
VALUES
    (1, 1, 'Great product!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 2, 'Awesome quality!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, 3, 'Very satisfied with my purchase.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, 4, 'Excellent service and fast delivery!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5, 5, 'Love it! Will buy again.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (6, 6, 'Impressed with the design.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (7, 7, 'Highly recommended!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (8, 8, 'Exactly what I was looking for.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (9, 9, 'Great value for money.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (10, 10, 'Fast shipping and well-packaged.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (11, 11, 'Beautiful product!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (12, 12, 'Very happy with my purchase.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (13, 13, 'Quality craftsmanship.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (14, 14, 'Prompt customer support.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (15, 15, 'Good communication from the seller.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (16, 16, 'Impressive build quality.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (17, 17, 'Perfect fit!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (18, 18, 'Exactly as described.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (19, 19, 'Great addition to my collection.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (20, 20, 'Worth every penny.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (21, 21, 'Quick and easy transaction.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (22, 22, 'Well-packaged and arrived on time.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (23, 23, 'Exactly what I needed.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (24, 24, 'Excellent customer service.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (25, 25, 'Highly recommended seller.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (26, 26, 'Great communication throughout.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (27, 27, 'Good value for the price.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (28, 28, 'Smooth transaction.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (29, 29, 'Beautiful packaging.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (30, 30, 'Impressed with the quality.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);



