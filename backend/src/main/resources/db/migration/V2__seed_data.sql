-- ============================
-- TEAMS
-- ============================
INSERT INTO teams (id, name, description, overhead_pct, created_at, updated_at)
VALUES
  ('11111111-1111-1111-1111-111111111111', 'Platform Team', 'Core infrastructure & tooling', 25, NOW(), NOW()),
  ('22222222-2222-2222-2222-222222222222', 'Payments Team', 'Billing, invoicing, payment integrations', 20, NOW(), NOW()),
  ('33333333-3333-3333-3333-333333333333', 'Analytics Team', 'Data pipelines & dashboards', 15, NOW(), NOW());

-- ============================
-- PERSONS
-- ============================
INSERT INTO persons (id, team_id, full_name, role, availability_pct, created_at, updated_at)
VALUES
  -- Platform Team
  ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '11111111-1111-1111-1111-111111111111', 'Alice Johnson', 'Engineer', 100, NOW(), NOW()),
  ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '11111111-1111-1111-1111-111111111111', 'Bob Smith', 'Engineer', 80, NOW(), NOW()),
  ('aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaa3', '11111111-1111-1111-1111-111111111111', 'Charlie Brown', 'Tech Lead', 90, NOW(), NOW()),

  -- Payments Team
  ('bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbb1', '22222222-2222-2222-2222-222222222222', 'Diana Prince', 'Engineer', 100, NOW(), NOW()),
  ('bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbb2', '22222222-2222-2222-2222-222222222222', 'Ethan Hunt', 'Engineer', 70, NOW(), NOW()),
  ('bbbbbbb3-bbbb-bbbb-bbbb-bbbbbbbbbbb3', '22222222-2222-2222-2222-222222222222', 'Fiona Gallagher', 'Product Owner', 100, NOW(), NOW()),

  -- Analytics Team
  ('ccccccc1-cccc-cccc-cccc-ccccccccccc1', '33333333-3333-3333-3333-333333333333', 'George Miller', 'Engineer', 100, NOW(), NOW()),
  ('ccccccc2-cccc-cccc-cccc-ccccccccccc2', '33333333-3333-3333-3333-333333333333', 'Hannah Lee', 'Data Scientist', 90, NOW(), NOW());

-- ============================
-- INITIATIVES
-- ============================
INSERT INTO initiatives (id, name, description, priority, status, target_date, estimated_effort_days, created_at, updated_at)
VALUES
  ('44444444-4444-4444-4444-444444444444', 'Unified Observability', 'Cross-team monitoring & tracing platform', 'HIGH', 'IN_PROGRESS', '2025-12-31', 300, NOW(), NOW()),
  ('55555555-5555-5555-5555-555555555555', 'Billing Modernization', 'Replace legacy billing engine', 'HIGH', 'PLANNED', '2025-09-30', 240, NOW(), NOW()),
  ('66666666-6666-6666-6666-666666666666', 'Analytics Revamp', 'New dashboards & data pipelines', 'MEDIUM', 'IN_PROGRESS', '2025-11-15', 180, NOW(), NOW());

-- ============================
-- EPICS
-- ============================
INSERT INTO epics (id, initiative_id, team_id, name, description, estimated_days, due_date, status, confidence, created_at, updated_at)
VALUES
  -- Unified Observability (Platform)
  ('77777777-7777-7777-7777-777777777771', '44444444-4444-4444-4444-444444444444', '11111111-1111-1111-1111-111111111111',
   'Tracing Infrastructure', 'Distributed tracing foundation', 60, '2025-06-30', 'IN_PROGRESS', 'HIGH', NOW(), NOW()),

  ('77777777-7777-7777-7777-777777777772', '44444444-4444-4444-4444-444444444444', '11111111-1111-1111-1111-111111111111',
   'Metrics Pipeline', 'Unified metrics ingestion', 80, '2025-08-15', 'PLANNED', 'MEDIUM', NOW(), NOW()),

  -- Billing Modernization (Payments)
  ('88888888-8888-8888-8888-888888888881', '55555555-5555-5555-5555-555555555555', '22222222-2222-2222-2222-222222222222',
   'Invoice Engine Rewrite', 'Core billing logic rewrite', 100, '2025-07-01', 'IN_PROGRESS', 'HIGH', NOW(), NOW()),

  ('88888888-8888-8888-8888-888888888882', '55555555-5555-5555-5555-555555555555', '22222222-2222-2222-2222-222222222222',
   'Payment Gateway Integration', 'Stripe + Adyen integration', 60, '2025-09-01', 'PLANNED', 'LOW', NOW(), NOW()),

  -- Analytics Revamp (Analytics)
  ('99999999-9999-9999-9999-999999999991', '66666666-6666-6666-6666-666666666666', '33333333-3333-3333-3333-333333333333',
   'Dashboard Redesign', 'New UI/UX for analytics', 70, '2025-06-15', 'IN_PROGRESS', 'HIGH', NOW(), NOW()),

  ('99999999-9999-9999-9999-999999999992', '66666666-6666-6666-6666-666666666666', '33333333-3333-3333-3333-333333333333',
   'Data Pipeline Upgrade', 'Faster ETL processing', 90, '2025-10-01', 'PLANNED', 'MEDIUM', NOW(), NOW());

-- ============================
-- PLANNING PERIODS
-- ============================
INSERT INTO planning_periods (id, name, start_date, end_date, created_at)
VALUES
  ('aaaa1111-2222-3333-4444-555566667777', 'H1 2025', '2025-01-01', '2025-06-30', NOW()),
  ('bbbb1111-2222-3333-4444-555566667777', 'H2 2025', '2025-07-01', '2025-12-31', NOW());
