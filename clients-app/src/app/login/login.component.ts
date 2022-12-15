import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  userName?: string;
  password?: string;
  loginError?: boolean;
  registrating?: boolean;

  constructor(
    private router: Router
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
}
