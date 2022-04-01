import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mphKph'
})
export class MphKphPipe implements PipeTransform {

  transform(value: number, mphToKph: boolean = false): number {
    if (mphToKph) {
      return value * 1.60934;
    } else {
      return value / 1.60934;
    }
  }

}
