CREATE TABLE Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    type VARCHAR CHECK (type IN ('Customer', 'Supplier', 'Admin'))
);

CREATE TABLE Person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    cellphone VARCHAR(20),
    email VARCHAR(100),
    date_register DATE,
    id_users INT REFERENCES Users(id)
);
--drop tABLE Person;
CREATE TABLE Tools_EquipmentConstruction (
    id SERIAL PRIMARY KEY,
    type VARCHAR(100) CHECK (type IN ('Tool', 'EquipmentConstruction')),
    name VARCHAR(100) NOT NULL,
    category VARCHAR(100),
    date_register DATE,
    price_day DOUBLE PRECISION,
    description VARCHAR(100),
    status VARCHAR(100) CHECK (status IN ('Available', 'Rented', 'Damaged','Under maintenance')),
    idUsers_Suppliers INT REFERENCES Users(id)
);

CREATE TABLE Reservations (
    id SERIAL PRIMARY KEY,
    start_date DATE,
    end_date DATE,
    request_date DATE,
    status VARCHAR(100) CHECK (status IN ('Pending', 'Approved', 'Canceled', 'Rejected', 'Completed')),
    idUsers_client INT REFERENCES Users(id),
    idTool_eqCons INT REFERENCES Tools_EquipmentConstruction(id)
);

CREATE TABLE Returns_Deliveries (
    id BIGINT PRIMARY KEY,
    delivery_date DATE,
    return_date DATE,
    commentary TEXT,
    status VARCHAR(100) CHECK (status IN ('Good', 'Damaged', 'Missing - Broken')),
    idReservations INT REFERENCES Reservations(id)
);

CREATE TABLE Payments (
    id BIGINT PRIMARY KEY,
    payments_method VARCHAR,
    price_total DOUBLE PRECISION,
    payments_date DATE,
    status VARCHAR(100) CHECK (status IN ('Pending', 'Paid', 'Failed')),
    idReservations INT REFERENCES Reservations(id)
);

CREATE TABLE Invoices (
    id BIGINT PRIMARY KEY,
    name_ToolShare VARCHAR,
    nit VARCHAR(100),
    address VARCHAR(100),
    number_invoice VARCHAR,
    cellphone VARCHAR(100),
    registration_date DATE,
    invoice_generation_date DATE,
    expiration_date DATE,
    url_signature VARCHAR(100),
    end_total DOUBLE PRECISION,
    idUsers_client INT REFERENCES Users(id),
    idPayments INT REFERENCES Payments(id)
);

CREATE TABLE Tools_Invoices (
    id INT PRIMARY KEY,
    unit_value DOUBLE PRECISION,
    quantity INT,
    totalValue DOUBLE PRECISION,
    idTools_eqCons INT REFERENCES Tools_EquipmentConstruction(id),
    idInvoices INT REFERENCES Invoices(id)
);

CREATE TABLE Damage_Report (
    id BIGINT PRIMARY KEY,
    report_date DATE,
    description TEXT,
    solution_date DATE,
    status VARCHAR(100) CHECK (status IN ('Pending', 'Under review', 'Resolved')),
    idUsers_Report INT REFERENCES Users(id),
    idTool_eqCons INT REFERENCES Tools_EquipmentConstruction(id),
    idReservations INT REFERENCES Reservations(id)
);

CREATE TABLE Notifications (
    id BIGINT PRIMARY KEY,
    message TEXT,
    date_message DATE,
    status VARCHAR(100) CHECK (status IN ('Payment', 'Reservation', 'Alert', 'Delivery', 'Return', 'Damage')),
    idUsers INT REFERENCES Users(id)
);

CREATE TABLE Stastics (
    id BIGINT PRIMARY KEY,
    quantity_timesDamaged BIGINT,
    total_income INT,
    total_rentals INT
);