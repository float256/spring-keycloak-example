import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { OAuthModule } from 'angular-oauth2-oidc';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    OAuthModule.forRoot({
      resourceServer: {
        allowedUrls: ["http://localhost:1337/"],
        sendAccessToken: true
      }
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
