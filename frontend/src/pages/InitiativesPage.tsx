import { useEffect, useState } from 'react'
import { Initiative } from '../types/Initiative'
import { getInitiatives } from '../services/initiatives'

export default function InitiativesPage() {
  const [initiatives, setInitiatives] = useState<Initiative[]>([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    getInitiatives()
      .then(setInitiatives)
      .catch(console.error)
      .finally(() => setLoading(false))
  }, [])

  if (loading) return <div>Loading...</div>

  return (
    <div>
      <h1>Initiatives</h1>
      {initiatives.length === 0 ? (
        <p>No initiatives found</p>
      ) : (
        <table style={{ width: '100%', borderCollapse: 'collapse' }}>
          <thead>
            <tr style={{ borderBottom: '2px solid #333' }}>
              <th style={{ textAlign: 'left', padding: '0.5rem' }}>Name</th>
              <th style={{ textAlign: 'left', padding: '0.5rem' }}>Status</th>
              <th style={{ textAlign: 'left', padding: '0.5rem' }}>Priority</th>
              <th style={{ textAlign: 'left', padding: '0.5rem' }}>Effort (days)</th>
            </tr>
          </thead>
          <tbody>
            {initiatives.map((initiative) => (
              <tr key={initiative.id} style={{ borderBottom: '1px solid #ccc' }}>
                <td style={{ padding: '0.5rem' }}>{initiative.name}</td>
                <td style={{ padding: '0.5rem' }}>{initiative.status}</td>
                <td style={{ padding: '0.5rem' }}>{initiative.priority}</td>
                <td style={{ padding: '0.5rem' }}>{initiative.estimatedEffortDays}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  )
}
