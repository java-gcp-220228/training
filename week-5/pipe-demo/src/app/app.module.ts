import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MphToKphComponent } from './mph-to-kph/mph-to-kph.component';
import { FilteringDemoComponent } from './filtering-demo/filtering-demo.component';
import { PipeModule } from './pipe/pipe.module';

@NgModule({
  declarations: [
    AppComponent,
    MphToKphComponent,
    FilteringDemoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    PipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
