import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MphToKphComponent } from './mph-to-kph/mph-to-kph.component';
import { MphKphPipe } from './mph-kph.pipe';
import { FilteringDemoComponent } from './filtering-demo/filtering-demo.component';
import { StatusFilterPipe } from './status-filter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    MphToKphComponent,
    MphKphPipe,
    FilteringDemoComponent,
    StatusFilterPipe
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
