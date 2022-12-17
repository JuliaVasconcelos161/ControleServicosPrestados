import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { UserLogin } from './userLogin';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username?: string;
  password?: string;
  registrating?: boolean;
  successMessage?: string;
  errors?: String[];

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  onSubmit() {
    this.router.navigate(['/home']);
  }

  prepareRegistration(event: { preventDefault: () => void; }) { //diferente
    event.preventDefault()
    this.registrating = true;
  }

  cancelRegistration() {
    this.registrating = false;
  }

  userRegistration() {
    const userLogin: UserLogin = new UserLogin();
    userLogin.username = this.username;
    userLogin.password = this.password;
    this.authService
        .saveUser(userLogin)
        .subscribe( response => {
          this.successMessage = "Cadastro realizado com sucesso! Efetue o login.";
        }, errorResponse => {
          this.successMessage = "";
          this.errors = errorResponse.error.errors;
        })
  }
}
