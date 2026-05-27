# Capacity Planning Tool — Root AGENTS.md

## Project overview
Strategic capacity planning tool (initiative & epic level) for B2B engineering orgs.
Stack: Java 21 + Spring Boot 3.x backend, React + TypeScript frontend, PostgreSQL.

## Repository layout
```
/backend    Spring Boot REST API (port 8080)
/frontend   Vite + React + TypeScript SPA (port 5173 dev / 80 prod)
docker-compose.yml   Full local stack
DESIGN.md            Architecture decisions and assumptions
```

## Running locally
```bash
# Full stack (requires Docker)
docker-compose up

# Backend only (requires local PostgreSQL)
cd backend && ./mvnw spring-boot:run

# Frontend only (requires running backend)
cd frontend && npm install && npm run dev
```

## Coding standards
- **Java**: Google Java Style, Checkstyle enforced in CI
- **TypeScript**: ESLint + Prettier, strict mode enabled
- **Git**: Conventional Commits (feat/fix/chore/docs/test/refactor)
- **Branches**: `feature/*`, `fix/*` → PR to `main`

## SOLID principles — enforced
- Controllers delegate to services; no business logic in controllers.
- Services depend on repository interfaces, not implementations.
- Strategy pattern for interchangeable capacity calculation algorithms.

## AI usage (interview disclosure)
Architecture design, code scaffolding, and test generation assisted by Claude (Anthropic).
All code reviewed and validated by the author.
