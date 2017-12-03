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
var data_service_1 = require("../data.service");
var UserDetailsComponent = (function () {
    function UserDetailsComponent(dataService) {
        this.dataService = dataService;
    }
    UserDetailsComponent.prototype.delete = function () {
        var _this = this;
        this.dataService.delete(this.user.id).then(function () { return _this.goBack(); });
    };
    UserDetailsComponent.prototype.goBack = function () {
        window.location.replace('');
    };
    return UserDetailsComponent;
}());
__decorate([
    core_1.Input()
], UserDetailsComponent.prototype, "user", void 0);
UserDetailsComponent = __decorate([
    core_1.Component({
        selector: 'user-detail',
        templateUrl: './user-details.component.html',
        styleUrls: ['./user-details.component.css'],
        providers: [data_service_1.DataService]
    })
], UserDetailsComponent);
exports.UserDetailsComponent = UserDetailsComponent;
