INSERT INTO users (email, password, username, nama_lengkap, alamat, nomor_telepon) 
VALUES 
('user1@example.com', 'password1', 'user1', 'John Doe', '123 Main Street, City A', '1234567890'),
('user2@example.com', 'password2', 'user2', 'Jane Smith', '456 Elm Street, City B', '9876543210'),
('user3@example.com', 'password3', 'user3', 'Michael Johnson', '789 Oak Street, City C', '5551234567'),
('user4@example.com', 'password4', 'user4', 'Emily Brown', '321 Pine Street, City D', '9876543210'),
('user5@example.com', 'password5', 'user5', 'David Wilson', '654 Maple Street, City E', '1234567890');

INSERT INTO product (product_name, deskripsi, harga, category_id, stok_quantity) 
VALUES 
('Nasi Goreng Spesial', 'Nasi goreng dengan campuran ayam, udang, dan telur.', 25000, 1, 50),
('Mie Ayam Bakso', 'Mie kuning dengan ayam panggang dan bakso dengan kuah kaldu.', 20000, 1, 40),
('Sate Ayam', 'Tusuk sate ayam yang dipanggang dengan bumbu kacang khas Indonesia.', 15000, 1, 30),
('Es Teh Manis', 'Teh manis dengan es batu.', 5000, 2, 60),
('Jus Jeruk Segar', 'Jus jeruk segar tanpa pemanis tambahan.', 10000, 2, 50),
('Es Krim Vanila', 'Es krim rasa vanila dengan potongan buah-buahan.', 12000, 3, 20),
('Soda Gembira', 'Minuman soda dengan campuran buah-buahan.', 15000, 3, 40),
('Pisang Goreng', 'Pisang goreng dengan taburan gula dan keju.', 8000, 3, 25);

INSERT INTO kategori (category_name)
VALUES
('Makanan'),
('Minuman'),
('Cemilan');
