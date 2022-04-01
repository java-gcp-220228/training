import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StatusFilterPipe } from './status-filter.pipe';
import { MphKphPipe } from './mph-kph.pipe';

@NgModule({
  declarations: [
    StatusFilterPipe,
    MphKphPipe
  ],
  exports: [
    StatusFilterPipe,
    MphKphPipe
  ],
  imports: [
    CommonModule
  ]
})
export class PipeModule { }
