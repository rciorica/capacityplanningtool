import api from './api'
import { Initiative } from '../types/Initiative'

export const getInitiatives = async (): Promise<Initiative[]> => {
  const response = await api.get('/initiatives')
  return response.data
}

export const createInitiative = async (initiative: Omit<Initiative, 'id' | 'epicCount' | 'completedEpicCount'>): Promise<Initiative> => {
  const response = await api.post('/initiatives', initiative)
  return response.data
}

export const updateInitiative = async (id: string, initiative: Partial<Initiative>): Promise<Initiative> => {
  const response = await api.put(`/initiatives/${id}`, initiative)
  return response.data
}

export const deleteInitiative = async (id: string): Promise<void> => {
  await api.delete(`/initiatives/${id}`)
}
