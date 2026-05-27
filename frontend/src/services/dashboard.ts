import api from './api'
import { Dashboard } from '../types/Dashboard'

export const getDashboard = async (): Promise<Dashboard> => {
  const response = await api.get('/dashboard')
  return response.data
}
