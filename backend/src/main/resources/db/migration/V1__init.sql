CREATE TABLE teams (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    overhead_pct FLOAT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE persons (
    id UUID PRIMARY KEY,
    team_id UUID NOT NULL REFERENCES teams(id),
    full_name VARCHAR(100) NOT NULL,
    role VARCHAR(50),
    availability_pct FLOAT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE initiatives (
    id UUID PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    priority VARCHAR(20),
    status VARCHAR(20),
    target_date DATE,
    estimated_effort_days INT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE epics (
    id UUID PRIMARY KEY,
    initiative_id UUID REFERENCES initiatives(id),
    team_id UUID REFERENCES teams(id),
    name VARCHAR(200) NOT NULL,
    description TEXT,
    estimated_days INT NOT NULL,
    due_date DATE,
    status VARCHAR(20),
    confidence VARCHAR(20),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE planning_periods (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    created_at TIMESTAMP
);
