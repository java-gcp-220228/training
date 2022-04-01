import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { TableComponent } from './table/table.component';
import { PokeSearchComponent } from './poke-search/poke-search.component';

@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    PokeSearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
