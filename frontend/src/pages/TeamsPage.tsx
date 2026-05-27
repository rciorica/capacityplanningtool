import { useEffect, useState } from 'react'
import { Team } from '../types/Team'
import { getTeams } from '../services/teams'

export default function TeamsPage() {
  const [teams, setTeams] = useState<Team[]>([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    getTeams()
      .then(setTeams)
      .catch(console.error)
      .finally(() => setLoading(false))
  }, [])

  if (loading) return <div>Loading...</div>

  return (
    <div>
      <h1>Teams</h1>
      {teams.length === 0 ? (
        <p>No teams found</p>
      ) : (
        <table style={{ width: '100%', borderCollapse: 'collapse' }}>
          <thead>
            <tr style={{ borderBottom: '2px solid #333' }}>
              <th style={{ textAlign: 'left', padding: '0.5rem' }}>Name</th>
              <th style={{ textAlign: 'left', padding: '0.5rem' }}>Description</th>
              <th style={{ textAlign: 'left', padding: '0.5rem' }}>Members</th>
            </tr>
          </thead>
          <tbody>
            {teams.map((team) => (
              <tr key={team.id} style={{ borderBottom: '1px solid #ccc' }}>
                <td style={{ padding: '0.5rem' }}>{team.name}</td>
                <td style={{ padding: '0.5rem' }}>{team.description}</td>
                <td style={{ padding: '0.5rem' }}>{team.memberCount}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  )
}
