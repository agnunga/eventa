"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var user_1 = require("./user");
var core_1 = require("@angular/core");
var CreateUserComponent = (function () {
    function CreateUserComponent(dataService, location) {
        this.dataService = dataService;
        this.location = location;
        this.user = new user_1.User;
        this.submitted = false;
    }
    CreateUserComponent.prototype.ngOnInit = function () {
    };
    CreateUserComponent.prototype.newUser = function () {
        this.submitted = false;
        this.user = new user_1.User();
    };
    CreateUserComponent.prototype.save = function () {
        this.dataService.create(this.user);
    };
    CreateUserComponent.prototype.onSubmit = function () {
        this.submitted = true;
        this.save();
    };
    CreateUserComponent.prototype.goBack = function () {
        this.location.back();
    };
    return CreateUserComponent;
}());
CreateUserComponent = __decorate([
    core_1.Component({
        selector: 'app-create-user',
        templateUrl: './create-user.component.html',
        styleUrls: ['./create-user.component.css']
    })
], CreateUserComponent);
exports.CreateUserComponent = CreateUserComponent;
