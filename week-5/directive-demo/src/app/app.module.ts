import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { StructuralDemoComponent } from './structural-demo/structural-demo.component';
import { AttributeDemoComponent } from './attribute-demo/attribute-demo.component';

@NgModule({
  declarations: [
    AppComponent,
    StructuralDemoComponent,
    AttributeDemoComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
