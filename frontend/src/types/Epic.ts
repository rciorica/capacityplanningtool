export interface Epic {
  id: string
  name: string
  description: string
  status: 'planning' | 'in-progress' | 'completed'
  createdAt: string
  updatedAt: string
}
