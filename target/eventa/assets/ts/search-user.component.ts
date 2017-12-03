import {Component, OnInit} from '@angular/core';
import {User} from './user';
import {DataService} from './data.service';

@Component({
    selector: 'app-search-users',
    templateUrl: './search-users.component.html',
    styleUrls: ['./search-users.component.css']
})

export class SearchUserComponent implements OnInit {
    lastName: string;
    users: User[];

    constructor(private dataService: DataService) {}

    ngOnInit() {
        this.lastName = "";
    }

    private searchUsers() {
        this.dataService.getUsersByLastName(this.lastName).then(users => this.users = users);
    }

    onSubmit() {
        this.searchUsers();
    }

}