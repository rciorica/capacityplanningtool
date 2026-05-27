import { useEffect, useState } from "react";
import { getTeams } from "../../services/teams";
import { Team } from "../../types/Team";
import Table from "../ui/Table";

export default function TeamList() {
  const [teams, setTeams] = useState<Team[]>([]);

  useEffect(() => {
    getTeams().then(setTeams);
  }, []);

  return (
    <Table
      columns={["Name", "Overhead %", "Members"]}
      rows={teams.map(t => [t.name, t.overheadPct + "%", t.memberCount])}
    />
  );
}
