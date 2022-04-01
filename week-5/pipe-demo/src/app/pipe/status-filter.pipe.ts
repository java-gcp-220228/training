import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'statusFilter'
})
export class StatusFilterPipe implements PipeTransform {

  transform(value: { id: number, amount: number, status: string }[], status: string): { id: number, amount: number, status: string }[] {
    if (status === 'approved') {
      return value.filter((obj) => {
        return obj.status === 'approved';
      })
    } else if (status === 'denied') {
      return value.filter((obj) => {
        return obj.status === 'denied';
      })
    } else if (status === 'pending') {
      return value.filter((obj) => {
        return obj.status === 'pending';
      })
    } else {
      return value;
    }
  }

}
