export interface Initiative {
  id: string;
  name: string;
  description: string;
  priority: string;
  status: string;
  targetDate: string;
  estimatedEffortDays: number;
  epicCount: number;
  completedEpicCount: number;
}
