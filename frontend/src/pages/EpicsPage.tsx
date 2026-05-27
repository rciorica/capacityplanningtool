import { useEffect, useState } from 'react'
import { Epic } from '../types/Epic'
import { getEpics } from '../services/epics'

export default function EpicsPage() {
  const [epics, setEpics] = useState<Epic[]>([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    getEpics()
      .then(setEpics)
      .catch(console.error)
      .finally(() => setLoading(false))
  }, [])

  if (loading) return <div>Loading...</div>

  return (
    <div>
      <h1>Epics</h1>
      {epics.length === 0 ? (
        <p>No epics found</p>
      ) : (
        <table style={{ width: '100%', borderCollapse: 'collapse' }}>
          <thead>
            <tr style={{ borderBottom: '2px solid #333' }}>
              <th style={{ textAlign: 'left', padding: '0.5rem' }}>Name</th>
              <th style={{ textAlign: 'left', padding: '0.5rem' }}>Description</th>
              <th style={{ textAlign: 'left', padding: '0.5rem' }}>Status</th>
            </tr>
          </thead>
          <tbody>
            {epics.map((epic) => (
              <tr key={epic.id} style={{ borderBottom: '1px solid #ccc' }}>
                <td style={{ padding: '0.5rem' }}>{epic.name}</td>
                <td style={{ padding: '0.5rem' }}>{epic.description}</td>
                <td style={{ padding: '0.5rem' }}>{epic.status}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  )
}
