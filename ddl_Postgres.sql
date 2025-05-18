CREATE TABLE Users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(10) NOT NULL,
    password VARCHAR NOT NULL,
    type VARCHAR(100) NOT NULL CHECK (type IN ('Customer', 'Supplier', 'Admin'))
);

CREATE TABLE Persons (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    cellphone VARCHAR(30),
    email VARCHAR(100),
    date_register DATE NOT NULL,
    id_user BIGINT NOT NULL REFERENCES Users(id)
);
--drop tABLE Persons;
CREATE TABLE Tools_EquipmentConstruction (
    id BIGSERIAL PRIMARY KEY,
    type VARCHAR(100) NOT NULL CHECK (type IN ('Tool', 'EquipmentConstruction')),
    name VARCHAR(30) NOT NULL,
    category VARCHAR(30) NOT NULL,
    date_register DATE NOT NULL,
    price_day DOUBLE PRECISION NOT NULL,
    description TEXT NOT NULL,
    status VARCHAR(100) CHECK (status IN ('Available', 'Rented', 'Damaged', 'Under maintenance')),
    id_user_supplier BIGINT NOT NULL REFERENCES Users(id)
);

CREATE TABLE Reservations (
    id BIGSERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    request_date DATE NOT NULL,
    status VARCHAR(100) NOT NULL CHECK (status IN ('Pending', 'Approved', 'Canceled', 'Rejected', 'Completed')),
    id_user_client BIGINT NOT NULL REFERENCES Users(id)
);

CREATE TABLE Returns_Deliveries (
    id BIGSERIAL PRIMARY KEY,
    delivery_date DATE,
    return_date DATE,
    commentary TEXT,
    status VARCHAR(100) CHECK (status IN ('Good', 'Damaged', 'Missing_Faulty')),
    id_reservations BIGINT REFERENCES Reservations(id)
);

CREATE TABLE Payments (
    id BIGSERIAL PRIMARY KEY,
    payment_method VARCHAR(100) NOT NULL,
    price_total DOUBLE PRECISION NOT NULL,
    payment_date DATE NOT NULL,
    status VARCHAR(100) NOT NULL CHECK (status IN ('Pending', 'Paid', 'Failed')),
    id_reservations BIGINT NOT NULL REFERENCES Reservations(id)
);

CREATE TABLE Invoices (
    id BIGSERIAL PRIMARY KEY,
    name_tool_share VARCHAR(255) NOT NULL,
    nit VARCHAR(15) NOT NULL,
    address VARCHAR(100) NOT NULL,
    number_invoice VARCHAR(20) NOT NULL,
    cellphone VARCHAR(30),
    registration_date DATE NOT NULL,
    invoice_generation_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    url_signature VARCHAR(255) NOT NULL,
    and_total DOUBLE PRECISION NOT NULL,
    id_client BIGINT NOT NULL REFERENCES Users(id),
    id_payments BIGINT NOT NULL REFERENCES Payments(id)
);

CREATE TABLE Tools_Invoices (
    id BIGSERIAL PRIMARY KEY,
    invoice_id BIGINT REFERENCES Invoices(id),
    tools_id BIGINT REFERENCES Tools_EquipmentConstruction(id),
    unit_value DOUBLE PRECISION NOT NULL,
    quantity INT NOT NULL,
    total_value DOUBLE PRECISION NOT NULL
);

CREATE TABLE Damage_Report (
    id SERIAL PRIMARY KEY,
    report_date DATE NOT NULL,
    solution_date DATE,
    description TEXT NOT NULL,
    status VARCHAR(100) NOT NULL CHECK (status IN ('Pending', 'Under review', 'Resolved')),
    id_users_report BIGINT NOT NULL REFERENCES Users(id),
    id_tool_eqcons BIGINT NOT NULL REFERENCES Tools_EquipmentConstruction(id),
    id_reservation BIGINT NOT NULL REFERENCES Reservations(id)
);

CREATE TABLE Notifications (
    id BIGSERIAL PRIMARY KEY,
    message TEXT NOT NULL,
    date_message DATE NOT NULL,
    status VARCHAR(100) NOT NULL CHECK (status IN ('Payments', 'Reservations', 'Alerts', 'Returns')),
    id_user BIGINT NOT NULL REFERENCES Users(id)
);

CREATE TABLE Stastics (
    id BIGSERIAL PRIMARY KEY,
    quantity_timesDamaged INT NOT NULL,
    total_income INT NOT NULL,
    total_rentals INT NOT NULL,
    id_tools_equipment_construction BIGINT REFERENCES Tools_EquipmentConstruction(id)
);