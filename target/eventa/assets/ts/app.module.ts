/**
 * Created by agufed on 11/23/17.
 */
import {AppRoutingModule} from './app-routing.module';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {UserDetailsComponent} from './user-details.component';
import {UserComponent} from './user.component';
import {DataService} from './data.service';
import {CreateUserComponent} from './create-user.component';

import {enableProdMode} from '@angular/core';
import {SearchUsersComponent} from './search-user.component';

@NgModule({
    declarations: [
        AppComponent,
        UserDetailsComponent,
        UserComponent,
        CreateUserComponent,
        SearchUsersComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        AppRoutingModule
    ],
    providers: [DataService],
    bootstrap: [AppComponent]
})

export class AppModule {}