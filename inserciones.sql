--Users
INSERT INTO Users (id, username, password, type) VALUES
--(1, 'Luis10', '1234luis', 'Admin'),
(2, 'ValerieM', '1234val', 'Supplier'),
(3, 'MGLL', '1234maria', 'Supplier'),
(4, 'ValeMoli', '1234valen', 'Supplier'),
(5, 'YurleyB', '1234yurl', 'Customer'),
(6, 'LuisH', '1234henao', 'Customer'),
(7, 'YesscaA', '1234andre', 'Customer'),
(8, 'Alejita', '1234aleja', 'Customer'),
(9, 'ZullyF', '1234fercha', 'Customer'),
(10, 'Anthony', '1234fabi', 'Customer'),
(11, 'Zorobot', '1234joe', 'Customer'),
(12, 'Camila', '1234negra', 'Customer'),
(13, 'MariaO', '1234ibarra', 'Customer'),
(14, 'SandraP', '1234patico', 'Customer'),
(15, 'HerneyL', '1234cucho', 'Customer'),
(16, 'WilmerR', '1234alex', 'Customer'),
(17, 'JesusB', '1234chucho', 'Customer'),
(18, 'JerxonC', '1234tombo', 'Customer'),
(19, 'CamiloM', '1234cami', 'Customer'),
(20, 'JeanF', '1234jf', 'Customer');
--DELETE FROM Users;

--Person
INSERT INTO Persons (id, name, last_name, cellphone, email, date_register, id_user_id) VALUES
INSERT INTO Persons (id, name, last_name, cellphone, email, date_register, id_user_id) VALUES
(1, 'Luis Miguel', 'Caicedo', '3124567890', 'luis10@gmail.com', '2020-05-15', 1),
(2, 'Valerie', 'Lasso', '3568741026', 'michellasso@gmail.com', '2023-05-15', 2),
(3, 'María', 'Lizarazo', '3125478001', 'mgl27@gmail.com', '2022-05-15', 3),
(4, 'Valentina', 'Molina', '3001112233', 'vale.moli@example.com', '2023-01-15', 4),
(5, 'Yurley', 'Botello', '3002223344', 'yurley.b@example.com', '2023-02-20', 5),
(6, 'Luis', 'Henao', '3003334455', 'luis.henao@example.com', '2023-03-05', 6),
(7, 'Yessica', 'Machuca', '3004445566', 'yessica.a@example.com', '2023-04-18', 7),
(8, 'Alejandra', 'Machuca', '3005556677', 'alejita@example.com', '2023-05-12', 8),
(9, 'Zully', 'Ortiz', '3006667788', 'zully.f@example.com', '2023-06-27', 9),
(10, 'Anthony', 'Portela', '3007778899', 'anthony.f@example.com', '2023-07-09', 10),
(11, 'Joe', 'Rodriguez', '3008889900', 'zorobot@example.com', '2023-08-22', 11),
(12, 'Camila', 'Morales', '3010001122', 'camila.n@example.com', '2023-09-30', 12),
(13, 'Maria', 'Ibarra', '3011112233', 'maria.o@example.com', '2023-10-11', 13),
(14, 'Sandra', 'Leal', '3012223344', 'sandra.p@example.com', '2023-11-03', 14),
(15, 'Herney', 'Lopez', '3013334455', 'herney.l@example.com', '2023-12-17', 15),
(16, 'Wilmer', 'Rojas', '3014445566', 'wilmer.r@example.com', '2024-01-08', 16),
(17, 'Jesus', 'Bustamante', '3015556677', 'jesus.b@example.com', '2024-02-14', 17),
(18, 'Jerxon', 'Correa', '3016667788', 'jerxon.c@example.com', '2024-03-21', 18),
(19, 'Camilo', 'Machuca', '3017778899', 'camilo.m@example.com', '2024-04-10', 19),
(20, 'Jean', 'Guerrero', '3018889900', 'jean.f@example.com', '2024-05-06', 20);

--Tools_EquipmentConstruction
INSERT INTO Tools_Equipment_Construction (id, type, name, category, date_register, price_day, description, status, id_user_supplier_id) VALUES
(1, 'Tools', 'Taladro Bosch', 'Eléctrico', '2023-01-15', 15000.00, 'Taladro percutor 650W', 'Available', 2),
(2, 'Tools', 'Pulidora Makita', 'Eléctrico', '2023-01-18', 18000.00, 'Pulidora angular 1200W', 'Available', 3),
(3, 'Tools', 'Sierra Circular DeWalt', 'Eléctrico', '2023-02-10', 22000.00, 'Sierra de corte rápido', 'Rented', 4),
(4, 'Tools', 'Martillo Demoledor', 'Eléctrico', '2023-03-01', 25000.00, 'Martillo demoledor SDS-Max', 'Available', 2),
(5, 'Tools', 'Lijadora Orbital', 'Eléctrico', '2023-03-05', 14000.00, 'Lijadora para madera', 'Available', 3),
(6, 'Tools', 'Compresor de aire', 'Neumático', '2023-03-22', 30000.00, 'Compresor 50L', 'Damaged', 4),
(7, 'Tools', 'Amoladora Angular', 'Eléctrico', '2023-04-03', 16000.00, 'Amoladora 4½ pulgadas', 'Available', 2),
(8, 'Tools', 'Rotomartillo', 'Eléctrico', '2023-04-15', 20000.00, 'Taladro con rotación y percusión', 'Available', 3),
(9, 'Tools', 'Nivel Láser', 'Medición', '2023-05-01', 18000.00, 'Nivel de precisión', 'Available', 4),
(10, 'Tools', 'Pistola de Calor', 'Térmico', '2023-05-10', 12000.00, 'Pistola de aire caliente', 'Available', 2);

INSERT INTO Tools_Equipment_Construction (id, type, name, category, date_register, price_day, description, status, id_user_supplier_id) VALUES
(11, 'EquipmentConstructions', 'Andamio Modular', 'Altura', '2023-06-01', 50000.00, 'Andamio de 5m altura', 'Rented', 3),
(12, 'EquipmentConstructions', 'Mezcladora de Concreto', 'Mezclado', '2023-06-10', 60000.00, 'Tambor 320L', 'Available', 4),
(13, 'EquipmentConstructions', 'Pluma Grúa', 'Carga', '2023-06-15', 75000.00, 'Grúa para elevación ligera', 'Available', 2),
(14, 'EquipmentConstructions', 'Vibrador de Concreto', 'Compactación', '2023-07-01', 35000.00, 'Vibrador 220V', 'Available', 3),
(15, 'EquipmentConstructions', 'Compactador de Placa', 'Compactación', '2023-07-12', 65000.00, 'Compactador a gasolina', 'Machine_maintenance', 4),
(16, 'EquipmentConstructions', 'Escalera Extensible', 'Acceso', '2023-08-01', 20000.00, 'Hasta 10 metros', 'Available', 2),
(17, 'EquipmentConstructions', 'Bomba de Agua', 'Hidráulico', '2023-08-05', 30000.00, 'Bomba sumergible 1HP', 'Available', 3),
(18, 'EquipmentConstructions', 'Generador Eléctrico', 'Energía', '2023-08-15', 80000.00, 'Generador gasolina 3500W', 'Damaged', 4),
(19, 'EquipmentConstructions', 'Carretilla Reforzada', 'Transporte', '2023-09-01', 10000.00, 'Carretilla metálica', 'Available', 2),
(20, 'EquipmentConstructions', 'Cortadora de Baldosa', 'Corte', '2023-09-15', 22000.00, 'Corte cerámica y porcelanato', 'Available', 3);

--Reservations
INSERT INTO Reservations (id, start_date, end_date, request_date, status, id_user_client_id) VALUES  
INSERT INTO Reservations (id, start_date, end_date, request_date, status, id_user_client_id) VALUES  
(1, '2023-06-01', '2023-06-03', '2023-05-25', 'Approved', 5),
(2, '2023-06-10', '2023-06-12', '2023-06-01', 'Completed', 6),
(3, '2023-07-05', '2023-07-07', '2023-06-28', 'Pending', 7),
(4, '2023-07-15', '2023-07-20', '2023-07-10', 'Approved', 8),
(5, '2023-08-01', '2023-08-03', '2023-07-25', 'Completed', 9),
(6, '2023-08-10', '2023-08-12', '2023-08-05', 'Rejected', 10),
(7, '2023-09-05', '2023-09-07', '2023-09-01', 'Pending', 11),
(8, '2023-09-15', '2023-09-18', '2023-09-10', 'Approved', 12), 
(9, '2023-10-01', '2023-10-03', '2023-09-25', 'Completed', 13),
(10, '2023-10-10', '2023-10-15', '2023-10-05', 'Canceled', 14),
(11, '2023-11-01', '2023-11-03', '2023-10-25', 'Approved', 15),
(12, '2023-11-10', '2023-11-12', '2023-11-01', 'Completed', 16),
(13, '2023-12-05', '2023-12-08', '2023-12-01', 'Pending', 17),
(14, '2023-12-15', '2023-12-20', '2023-12-10', 'Approved', 18),
(15, '2024-01-01', '2024-01-05', '2023-12-28', 'Completed', 19),
(16, '2024-01-10', '2024-01-12', '2024-01-05', 'Canceled', 20),
(17, '2024-02-01', '2024-02-03', '2024-01-25', 'Pending', 5),
(18, '2024-02-10', '2024-02-13', '2024-02-01', 'Rejected', 6),
(19, '2024-03-01', '2024-03-04', '2024-02-25', 'Approved', 7),
(20, '2024-03-10', '2024-03-14', '2024-03-05', 'Completed', 8);

--Returns_Deliveries
INSERT INTO Returns_Deliveries (id, delivery_date, return_date, commentary, status, id_reservations_id) VALUES 
INSERT INTO Returns_Deliveries (id, delivery_date, return_date, commentary, status, id_reservations_id) VALUES 
(1, '2023-06-01', '2023-06-03', 'Devuelto en buen estado.', 'Good', 1),
(2, '2023-06-10', '2023-06-12', 'Herramienta funcional, sin novedades.', 'Good', 2),
(3, '2023-07-05', '2023-07-07', 'Cliente reporta maletín roto.', 'Damaged', 3),
(4, '2023-07-15', '2023-07-20', 'Equipo regresado sin accesorios.', 'Missing_Faulty', 4),
(5, '2023-08-01', '2023-08-03', 'Todo en orden.', 'Good', 5),
(6, '2023-08-10', '2023-08-12', 'Herramienta rayada pero funcional.', 'Damaged', 6),
(7, '2023-09-05', '2023-09-07', 'Equipo entregado y devuelto completo.', 'Good', 7),
(8, '2023-09-15', '2023-09-18', 'Cliente indica que uno de los cables no funcionó.', 'Damaged', 8),
(9, '2023-10-01', '2023-10-03', 'Sin observaciones.', 'Good', 9),
(10, '2023-10-10', '2023-10-15', 'Cliente canceló antes de usar.', 'Good', 10),
(11, '2023-11-01', '2023-11-03', 'Entrega y devolución puntuales.', 'Good', 11),
(12, '2023-11-10', '2023-11-12', 'Caja rota, se requiere mantenimiento.', 'Damaged', 12),
(13, '2023-12-05', '2023-12-08', 'Cliente no regresó la extensión.', 'Missing_Faulty', 13),
(14, '2023-12-15', '2023-12-20', 'Equipo devuelto mojado, requiere revisión.', 'Damaged', 14),
(15, '2024-01-01', '2024-01-05', 'Todo entregado correctamente.', 'Good', 15),
(16, '2024-01-10', '2024-01-12', 'Devolución después de la fecha pactada.', 'Good', 16),
(17, '2024-02-01', '2024-02-03', 'Herramienta con leve oxidación.', 'Damaged', 17),
(18, '2024-02-10', '2024-02-13', 'Cliente no regresó los elementos completos.', 'Missing_Faulty', 18),
(19, '2024-03-01', '2024-03-04', 'Devolución oportuna, sin novedades.', 'Good', 19),
(20, '2024-03-10', '2024-03-14', 'Accesorio dañado al regresar.', 'Damaged', 20);

--Payments
INSERT INTO Payments (id, payment_method, price_total, payment_date, status, id_reservations_id) VALUES
INSERT INTO Payments (id, payment_method, price_total, payment_date, status, id_reservations_id) VALUES
(1, 'Bancolombia', 550000.00, '2023-05-26', 'Paid', 1),
(2, 'Davivienda', 1100000.00, '2023-06-02', 'Paid', 2),
(3, 'Banco de Bogotá', 660000.00, '2023-07-04', 'Pending', 3),
(4, 'Banco Popular', 1460000.00, '2023-07-12', 'Paid', 4),
(5, 'Banco AV Villas', 550000.00, '2023-07-26', 'Paid', 5),
(6, 'BBVA Colombia', 770000.00, '2023-08-06', 'Failed', 6),
(7, 'Scotiabank Colpatria', 660000.00, '2023-09-02', 'Pending', 7),
(8, 'Banco Agrario', 1285000.00, '2023-09-11', 'Paid', 8),
(9, 'Banco de Occidente', 550000.00, '2023-09-26', 'Paid', 9),
(10, 'Bancolombia', 808000.00, '2023-10-06', 'Failed', 10),
(11, 'Davivienda', 920000.00, '2023-10-26', 'Paid', 11),
(12, 'Banco de Bogotá', 994000.00, '2023-11-02', 'Paid', 12),
(13, 'Banco Popular', 736000.00, '2023-12-02', 'Pending', 13),
(14, 'Banco AV Villas', 1100000.00, '2023-12-11', 'Paid', 14),
(15, 'BBVA Colombia', 1024000.00, '2023-12-29', 'Paid', 15),
(16, 'Scotiabank Colpatria', 950000.00, '2024-01-06', 'Paid', 16),
(17, 'Banco Agrario', 770000.00, '2024-01-26', 'Pending', 17),
(18, 'Banco de Occidente', 697000.00, '2024-02-02', 'Failed', 18),
(19, 'Bancolombia', 1170000.00, '2024-02-26', 'Paid', 19),
(20, 'Davivienda', 1285000.00, '2024-03-06', 'Paid', 20);

--Invoices
INSERT INTO Invoices (id, name_tool_share, nit, addres, number_invoice, cellphone, registration_date, invoice_generation_date, expiration_date, url_signature, and_total, id_client_id, id_payments_id) VALUES
(1, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1001, '302456780', '2023-05-01', '2023-05-26', '2023-06-26', 'https://firma.toolshare.com/1001', 550000.00, 1, 1),
(2, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1002, '306741026', '2023-05-01', '2023-06-02', '2023-07-02', 'https://firma.toolshare.com/1002', 1100000.00, 2, 2),
(3, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1003, '302547001', '2023-05-01', '2023-07-04', '2023-08-04', 'https://firma.toolshare.com/1003', 660000.00, 3, 3),
(4, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1004, '3001112233', '2023-05-01', '2023-07-12', '2023-08-12', 'https://firma.toolshare.com/1004', 1460000.00, 4, 4),
(5, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1005, '3002223344', '2023-05-01', '2023-07-26', '2023-08-26', 'https://firma.toolshare.com/1005', 550000.00, 5, 5),
(6, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1006, '3003334455', '2023-05-01', '2023-08-06', '2023-09-06', 'https://firma.toolshare.com/1006', 770000.00, 6, 6),
(7, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1007, '3004445566', '2023-05-01', '2023-09-02', '2023-10-02', 'https://firma.toolshare.com/1007', 660000.00, 7, 7),
(8, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1008, '3005556677', '2023-05-01', '2023-09-11', '2023-10-11', 'https://firma.toolshare.com/1008', 1285000.00, 8, 8),
(9, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1009, '3006667788', '2023-05-01', '2023-09-26', '2023-10-26', 'https://firma.toolshare.com/1009', 550000.00, 9, 9),
(10, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1010, '300777899', '2023-05-01', '2023-10-06', '2023-11-06', 'https://firma.toolshare.com/1010', 808000.00, 10, 10),
(11, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1011, '300888900', '2023-05-01', '2023-10-26', '2023-11-26', 'https://firma.toolshare.com/1011', 920000.00, 11, 11),
(12, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1012, '3010001122', '2023-05-01', '2023-11-02', '2023-12-02', 'https://firma.toolshare.com/1012', 994000.00, 12, 12),
(13, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1013, '3011112233', '2023-05-01', '2023-12-02', '2024-01-02', 'https://firma.toolshare.com/1013', 736000.00, 13, 13),
(14, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1014, '3012223344', '2023-05-01', '2023-12-11', '2024-01-11', 'https://firma.toolshare.com/1014', 1100000.00, 14, 14),
(15, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1015, '3013334455', '2023-05-01', '2023-12-29', '2024-01-29', 'https://firma.toolshare.com/1015', 1024000.00, 15, 15),
(16, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1016, '3014445566', '2023-05-01', '2024-01-06', '2024-02-06', 'https://firma.toolshare.com/1016', 950000.00, 16, 16),
(17, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1017, '301555667', '2023-05-01', '2024-01-26', '2024-02-26', 'https://firma.toolshare.com/1017', 770000.00, 17, 17),
(18, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1018, '301667788', '2023-05-01', '2024-02-02', '2024-03-02', 'https://firma.toolshare.com/1018', 697000.00, 18, 18),
(19, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1019, '301777889', '2023-05-01', '2024-02-26', '2024-03-26', 'https://firma.toolshare.com/1019', 1170000.00, 19, 19),
(20, 'ToolShare SAS', '900123456-7', 'Calle 123 #45-67, Bogotá', 1020, '301888900', '2023-05-01', '2024-03-06', '2024-04-06', 'https://firma.toolshare.com/1020', 1285000.00, 20, 20);

--Tools_Invoices
INSERT INTO Tools_Invoices (id, unit_value, quantity, total_value, tools_id, invoice_id) VALUES
(1, 25000.00, 5, 125000.00, 1, 1),
(2, 40000.00, 10, 400000.00, 2, 2),
(3, 50000.00, 3, 150000.00, 3, 3),
(4, 150000.00, 7, 1050000.00, 4, 4),
(5, 30000.00, 8, 240000.00, 5, 5),
(6, 60000.00, 4, 240000.00, 6, 6),
(7, 25000.00, 15, 375000.00, 7, 7),
(8, 80000.00, 5, 400000.00, 8, 8),
(9, 45000.00, 7, 315000.00, 9, 9),
(10, 70000.00, 9, 630000.00, 10, 10),
(11, 25000.00, 20, 500000.00, 11, 11),
(12, 65000.00, 6, 390000.00, 12, 12),
(13, 85000.00, 5, 425000.00, 13, 13),
(14, 40000.00, 12, 480000.00, 14, 14),
(15, 30000.00, 18, 540000.00, 15, 15),
(16, 50000.00, 14, 700000.00, 16, 16),
(17, 25000.00, 10, 250000.00, 17, 17),
(18, 45000.00, 8, 360000.00, 18, 18),
(19, 65000.00, 9, 585000.00, 19, 19),
(20, 55000.00, 6, 330000.00, 20, 20);

--Damage_Report
INSERT INTO Damage_Report (id, report_date, description, solution_date, status, id_users_report_id, id_toolsec_id, id_reservation_id) VALUES
(1, '2023-06-01', 'Herramienta presenta desgaste en la empuñadura', '2023-06-10', 'Solved', 5, 1, 1),
(2, '2023-06-15', 'Equipo de construcción con motor ruidoso', NULL, 'Pending', 6, 2, 2),
(3, '2023-07-03', 'Herramienta no enciende correctamente', '2023-07-12', 'Solved', 7, 3, 3),
(4, '2023-07-18', 'Equipo con fuga de aceite', '2023-07-25', 'Under', 8, 4, 4),
(5, '2023-08-01', 'Herramienta con cable dañado', NULL, 'Pending', 9, 5, 5),
(6, '2023-08-10', 'Equipo de construcción con problemas en el sistema eléctrico', '2023-08-20', 'Solved', 10, 6, 6),
(7, '2023-08-22', 'Herramienta presenta vibraciones excesivas', NULL, 'Under', 11, 7, 7),
(8, '2023-09-05', 'Equipo con estructura doblada', '2023-09-15', 'Solved', 12, 8, 8),
(9, '2023-09-20', 'Herramienta con partes faltantes', NULL, 'Pending', 13, 9, 9),
(10, '2023-10-02', 'Equipo con fallas en sistema hidráulico', '2023-10-12', 'Solved', 14, 10, 10),
(11, '2023-10-16', 'Herramienta con botón de encendido roto', NULL, 'Pending', 15, 11, 11),
(12, '2023-10-30', 'Equipo con desgaste en ruedas', '2023-11-10', 'Under', 16, 12, 12),
(13, '2023-11-12', 'Herramienta con batería defectuosa', '2023-11-22', 'Solved', 17, 13, 13),
(14, '2023-11-25', 'Equipo con sistema de frenado dañado', NULL, 'Pending', 18, 14, 14),
(15, '2023-12-08', 'Herramienta con grietas en la carcasa', '2023-12-18', 'Solved', 19, 15, 15),
(16, '2023-12-20', 'Equipo con pérdidas de presión', NULL, 'Under', 20, 16, 16),
(17, '2024-01-05', 'Herramienta con partes desalineadas', '2024-01-15', 'Solved', 1, 17, 17),
(18, '2024-01-18', 'Equipo con fugas de aire', NULL, 'Pending', 2, 18, 18),
(19, '2024-02-01', 'Herramienta con motor que no arranca', '2024-02-11', 'Solved', 3, 19, 19),
(20, '2024-02-15', 'Equipo con problemas eléctricos intermitentes', NULL, 'Under', 4, 20, 20);

--Notifications
INSERT INTO Notifications (id, message, date_message, status, id_user_id) VALUES
(1, 'Tu pago ha sido procesado con éxito.', '2023-06-01', 'Payments', 5),
(2, 'Tu reserva fue aprobada.', '2023-06-15', 'Reservations', 6),
(3, 'Tu herramienta fue devuelta correctamente.', '2023-07-03', 'Returns', 7),
(4, 'Se detectó un daño en el equipo alquilado.', '2023-07-18', 'Alerts', 8),
(5, 'Tu pago está pendiente de confirmación.', '2023-08-01', 'Payments', 9),
(6, 'Reserva rechazada por falta de disponibilidad.', '2023-08-10', 'Reservations', 10),
(7, 'Se ha iniciado el proceso de devolución.', '2023-08-22', 'Returns', 11),
(8, 'Alerta: vencimiento de reserva inminente.', '2023-09-05', 'Alerts', 12),
(9, 'Tu factura está lista para descargar.', '2023-09-20', 'Payments', 13),
(10, 'Tu reserva fue completada con éxito.', '2023-10-02', 'Reservations', 14),
(11, 'Se ha registrado la devolución sin novedades.', '2023-10-16', 'Returns', 15),
(12, 'Alerta: herramienta reportada como dañada.', '2023-10-30', 'Alerts', 16),
(13, 'Tu método de pago fue actualizado.', '2023-11-12', 'Payments', 17),
(14, 'Se ha aprobado una nueva reserva.', '2023-11-25', 'Reservations', 18),
(15, 'Entrega del equipo confirmada.', '2023-12-08', 'Returns', 19),
(16, 'Se reportó un daño al equipo entregado.', '2023-12-20', 'Alerts', 20),
(17, 'Tu pago fue rechazado por el sistema.', '2024-01-05', 'Payments', 5),
(18, 'Reserva en espera de aprobación.', '2024-01-18', 'Reservations', 6),
(19, 'Equipo recibido con retraso.', '2024-02-01', 'Returns', 7),
(20, 'Notificación de mantenimiento del sistema.', '2024-02-15', 'Alerts', 8);

--Stastics
INSERT INTO Stastics (id, quantity_times_damaged, total_income, total_rentals, id_tools_equipment_construction_id) VALUES
INSERT INTO Stastics (id, quantity_times_damaged, total_income, total_rentals, id_tools_equipment_construction_id) VALUES
(1, 2, 1800000, 15, 1),
(2, 0, 850000, 7, 2),
(3, 1, 950000, 8, 3),
(4, 3, 1200000, 10, 4),
(5, 0, 400000, 4, 5),
(6, 2, 1500000, 13, 6),
(7, 1, 780000, 6, 7),
(8, 0, 500000, 5, 8),
(9, 4, 1600000, 14, 9),
(10, 2, 1100000, 9, 10),
(11, 0, 620000, 6, 11),
(12, 1, 900000, 8, 12),
(13, 0, 550000, 5, 13),
(14, 3, 1400000, 11, 14),
(15, 1, 870000, 7, 15),
(16, 0, 450000, 4, 16),
(17, 2, 1050000, 9, 17),
(18, 0, 300000, 3, 18),
(19, 1, 720000, 6, 19),
(20, 0, 650000, 5, 20);