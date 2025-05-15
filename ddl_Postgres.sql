CREATE TABLE Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    type VARCHAR CHECK (type IN ('Customers', 'Suppliers', 'Admin'))
);

CREATE TABLE Person (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    lastname VARCHAR NOT NULL,
    cellphone INT,
    email VARCHAR,
    date_register DATE,
    id_users INT REFERENCES Users(id)
);
drop tABLE Person;
CREATE TABLE Tools_EquipmentConstruction (
    id SERIAL PRIMARY KEY,
    type VARCHAR CHECK (type IN ('Tool', 'EquipmentConstruction')),
    name VARCHAR NOT NULL,
    category VARCHAR,
    date_register DATE,
    price_day DOUBLE PRECISION,
    description VARCHAR,
    status VARCHAR CHECK (status IN ('Available', 'Rented', 'Damaged')),
    idUsers_Suppliers INT REFERENCES Users(id)
);

CREATE TABLE Reservations (
    id SERIAL PRIMARY KEY,
    start_date DATE,
    end_date DATE,
    request_date DATE,
    status VARCHAR CHECK (status IN ('Pending', 'Approved', 'Canceled')),
    idUsers_client INT REFERENCES Users(id),
    idTool_eqCons INT REFERENCES Tools_EquipmentConstruction(id)
);

CREATE TABLE Returns_Deliveries (
    id BIGINT PRIMARY KEY,
    delivery_date DATE,
    return_date DATE,
    commentary TEXT,
    status VARCHAR CHECK (status IN ('Good', 'Damaged')),
    idReservations INT REFERENCES Reservations(id)
);

CREATE TABLE Payments (
    id BIGINT PRIMARY KEY,
    payments_method VARCHAR,
    price_total DOUBLE PRECISION,
    payments_date DATE,
    status VARCHAR CHECK (status IN ('Pending', 'Paid', 'Canceled')),
    idReservations INT REFERENCES Reservations(id)
);

CREATE TABLE Invoices (
    id BIGINT PRIMARY KEY,
    name_ToolShare VARCHAR,
    nit VARCHAR,
    address VARCHAR,
    number_invoice INT,
    cellphone INT,
    registration_date DATE,
    invoice_generation_date DATE,
    expiration_date DATE,
    url_signature VARCHAR,
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
    status VARCHAR CHECK (status IN ('Pending', 'Under_Review', 'Solved')),
    idUsers_Report INT REFERENCES Users(id),
    idTool_eqCons INT REFERENCES Tools_EquipmentConstruction(id),
    idReservations INT REFERENCES Reservations(id)
);

CREATE TABLE Notifications (
    id BIGINT PRIMARY KEY,
    message TEXT,
    date_message DATE,
    status VARCHAR CHECK (status IN ('Payment', 'Delivery', 'Return', 'Damage')),
    idUsers INT REFERENCES Users(id)
);

CREATE TABLE Statics (
    id BIGINT PRIMARY KEY,
    quantity_timesDamaged BIGINT,
    total_income INT,
    total_rentals INT
);