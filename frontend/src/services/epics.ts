import api from './api'
import { Epic } from '../types/Epic'

export const getEpics = async (): Promise<Epic[]> => {
  const response = await api.get('/epics')
  return response.data
}

export const createEpic = async (epic: Omit<Epic, 'id' | 'createdAt' | 'updatedAt'>): Promise<Epic> => {
  const response = await api.post('/epics', epic)
  return response.data
}

export const updateEpic = async (id: string, epic: Partial<Epic>): Promise<Epic> => {
  const response = await api.put(`/epics/${id}`, epic)
  return response.data
}

export const deleteEpic = async (id: string): Promise<void> => {
  await api.delete(`/epics/${id}`)
}
