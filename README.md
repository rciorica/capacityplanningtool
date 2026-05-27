# Capacity Planning Tool

Prototype of a web-based strategic capacity planning tool. The tool operates at initiative and epic level — it is not a sprint planning or task tracking tool.

Stakeholders
The tool serves three groups. Derive their needs from their role and perspective.

Higher Management
Concerned with cross-team capacity, annual business plan commitments, and the
impact of new demands on existing plans.

Engineering Managers and Product Managers
Concerned with initiative delivery across teams, trade-off decisions, and planning
simulations before commitments are made.

Team Leads / Product Owners
Concerned with realistic team-level capacity given individual availability, overhead, and
support load.

Data Objects
The tool works with the following entities:
Initiative — a strategic topic with estimated effort and a target delivery date; may
involve multiple teams; typically spans months to years
Epic — a concrete deliverable belonging to one team; typically a child of an initiative;
has its own estimate and due date
Team — a group of people delivering epics; has overhead that reduces available project
capacity
Person — a team member

Deliverables

1. A working prototype — runs locally, no cloud deployment

# Full stack (requires Docker)
docker-compose up

# Backend only (requires local PostgreSQL)
cd backend && ./mvnw spring-boot:run

# Frontend only (requires running backend)
cd frontend && npm install && npm run dev

2. A short design document — includes the assumptions made where requirements were ambiguous - see Capacity Planning Tool — Design Document.pdf

