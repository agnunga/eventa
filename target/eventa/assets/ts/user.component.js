"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
/**
 * Created by agufed on 11/23/17.
 */
var core_1 = require("@angular/core");
var UserComponent = (function () {
    function UserComponent(dataService) {
        this.dataService = dataService;
    }
    UserComponent.prototype.getUser = function () {
        var _this = this;
        this.dataService.getUser().then(function (users) { return _this.users = users; });
    };
    UserComponent.prototype.ngOnInit = function () {
        this.getUser();
    };
    UserComponent.prototype.onSelect = function (cust) {
        this.selectedUser = cust;
    };
    return UserComponent;
}());
UserComponent = __decorate([
    core_1.Component({
        selector: 'users-list',
        templateUrl: './users.component.html',
        styleUrls: ['./users.component.css'],
    })
], UserComponent);
exports.UserComponent = UserComponent;
