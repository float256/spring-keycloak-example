import {Component, OnDestroy} from '@angular/core';
import {OAuthService} from "angular-oauth2-oidc";
import { Subscription } from 'rxjs';
import { AppService } from './app.service';
import {authConfig} from "./auth.config";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy{
  title = 'frontend';
  text = '';
  helloSubscription: Subscription;

  constructor(private oauthService: OAuthService, private appService: AppService) {
    this.configure();
    this.helloSubscription = this.appService.hello().subscribe(response => {
      this.text = response;
    });
  }

  ngOnDestroy(): void {
    this.helloSubscription.unsubscribe();
  }

  login() {
    this.oauthService.initCodeFlow();
  }

  info() {
    return this.oauthService.checkSession() 
  }

  private configure() {
    this.oauthService.configure(authConfig);
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }

  logout() {
    this.oauthService.logOut();
  }
}
