import { useEffect, useState } from 'react'
import { Dashboard } from '../types/Dashboard'
import { getDashboard } from '../services/dashboard'

export default function DashboardPage() {
  const [dashboard, setDashboard] = useState<Dashboard | null>(null)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    getDashboard()
      .then(setDashboard)
      .catch(console.error)
      .finally(() => setLoading(false))
  }, [])

  if (loading) return <div>Loading...</div>
  if (!dashboard) return <div>Failed to load dashboard</div>

  return (
    <div>
      <h1>Dashboard</h1>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(2, 1fr)', gap: '1rem' }}>
        <div style={{ border: '1px solid #ccc', padding: '1rem' }}>
          <h3>Teams</h3>
          <p style={{ fontSize: '2rem' }}>{dashboard.teamCount}</p>
        </div>
        <div style={{ border: '1px solid #ccc', padding: '1rem' }}>
          <h3>People</h3>
          <p style={{ fontSize: '2rem' }}>{dashboard.personCount}</p>
        </div>
        <div style={{ border: '1px solid #ccc', padding: '1rem' }}>
          <h3>Initiatives</h3>
          <p style={{ fontSize: '2rem' }}>{dashboard.initiativeCount}</p>
        </div>
        <div style={{ border: '1px solid #ccc', padding: '1rem' }}>
          <h3>Epics</h3>
          <p style={{ fontSize: '2rem' }}>{dashboard.epicCount} ({dashboard.completedEpicCount} completed)</p>
        </div>
      </div>
    </div>
  )
}
