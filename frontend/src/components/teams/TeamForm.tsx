import { useState } from "react";
import { createTeam } from "../../services/teams";

export default function TeamForm() {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [overheadPct, setOverheadPct] = useState(20);
  const [memberCount, setMemberCount] = useState(0);

  const submit = async () => {
    await createTeam({ name, description, overheadPct, memberCount });
    window.location.reload();
  };

  return (
    <div style={{ padding: '1rem', border: '1px solid #ccc', borderRadius: '4px' }}>
      <h2 style={{ fontWeight: 'bold', marginBottom: '0.5rem' }}>Create Team</h2>
      <input 
        placeholder="Team name" 
        value={name}
        onChange={e => setName(e.target.value)} 
        style={{ width: '100%', padding: '0.5rem', marginBottom: '0.5rem', boxSizing: 'border-box' }}
      />
      <input 
        placeholder="Description" 
        value={description}
        onChange={e => setDescription(e.target.value)} 
        style={{ width: '100%', padding: '0.5rem', marginBottom: '0.5rem', boxSizing: 'border-box' }}
      />
      <input 
        type="number" 
        placeholder="Overhead %" 
        value={overheadPct} 
        onChange={e => setOverheadPct(Number(e.target.value))} 
        style={{ width: '100%', padding: '0.5rem', marginBottom: '0.5rem', boxSizing: 'border-box' }}
      />
      <input 
        type="number" 
        placeholder="Member count" 
        value={memberCount} 
        onChange={e => setMemberCount(Number(e.target.value))} 
        style={{ width: '100%', padding: '0.5rem', marginBottom: '0.5rem', boxSizing: 'border-box' }}
      />
      <button 
        onClick={submit}
        style={{ padding: '0.5rem 1rem', background: '#333', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
      >
        Create
      </button>
    </div>
  );
}
