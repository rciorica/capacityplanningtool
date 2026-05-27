import { BrowserRouter, Routes, Route } from "react-router-dom";
import AppLayout from "./components/layout/AppLayout";
import DashboardPage from "./pages/DashboardPage";
import TeamsPage from "./pages/TeamsPage";
import InitiativesPage from "./pages/InitiativesPage";
import EpicsPage from "./pages/EpicsPage";
import "./App.css";


export default function App() {
  return (
    <BrowserRouter>
      <AppLayout>
        <Routes>
          <Route path="/" element={<DashboardPage />} />
          <Route path="/teams" element={<TeamsPage />} />
          <Route path="/initiatives" element={<InitiativesPage />} />
          <Route path="/epics" element={<EpicsPage />} />
        </Routes>
      </AppLayout>
    </BrowserRouter>
  );
}
console.log("APP LOADED");
