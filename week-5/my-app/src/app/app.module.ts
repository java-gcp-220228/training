import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoComponent } from './demo/demo.component';
import { TwoWayDatabindingDemoComponent } from './two-way-databinding-demo/two-way-databinding-demo.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    TwoWayDatabindingDemoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
