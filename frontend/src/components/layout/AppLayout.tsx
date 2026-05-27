import { ReactNode } from 'react'

interface AppLayoutProps {
  children: ReactNode
}

export default function AppLayout({ children }: AppLayoutProps) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', minHeight: '100vh' }}>
      <header style={{ background: '#333', color: '#fff', padding: '1rem' }}>
        <h1>Capacity Planning Tool</h1>
        <nav style={{ marginTop: '0.5rem' }}>
          <a href="/" style={{ color: '#fff', marginRight: '1rem' }}>Dashboard</a>
          <a href="/teams" style={{ color: '#fff', marginRight: '1rem' }}>Teams</a>
          <a href="/initiatives" style={{ color: '#fff', marginRight: '1rem' }}>Initiatives</a>
          <a href="/epics" style={{ color: '#fff' }}>Epics</a>
        </nav>
      </header>
      <main style={{ flex: 1, padding: '2rem' }}>
        {children}
      </main>
    </div>
  )
}
