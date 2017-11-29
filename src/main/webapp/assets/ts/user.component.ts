/**
 * Created by agufed on 11/23/17.
 */
import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { DataService } from './data.service';

@Component({
    selector: 'users-list',
    templateUrl: './users.component.html',
    styleUrls: ['./users.component.css'],
})

export class UserComponent implements OnInit {
    users: User[];
    selectedUser: User;

    constructor(private dataService: DataService) {}

    getUser() {
        this.dataService.getUser().then(users => this.users = users);
    }

    ngOnInit(): void {
        this.getUser();
    }

    onSelect(cust: User): void {
        this.selectedUser = cust;
    }
}
