import api from './api'
import { Team } from '../types/Team'

export const getTeams = async (): Promise<Team[]> => {
  const response = await api.get('/teams')
  return response.data
}

export const createTeam = async (team: Omit<Team, 'id'>): Promise<Team> => {
  const response = await api.post('/teams', team)
  return response.data
}

export const updateTeam = async (id: string, team: Partial<Team>): Promise<Team> => {
  const response = await api.put(`/teams/${id}`, team)
  return response.data
}

export const deleteTeam = async (id: string): Promise<void> => {
  await api.delete(`/teams/${id}`)
}
