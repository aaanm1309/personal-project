import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Credenciais, CredenciaisReturned, CredenciaisVO } from 'src/app/models/credenciais';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  creds: Credenciais = {
    usuario: '',
    senha: ''
  }

  credsVO: CredenciaisVO = {
    username: '',
    password: ''
  }

  credRet : any = {};

  usuario = new FormControl(null, Validators.minLength(4));
  senha = new FormControl(null, Validators.minLength(4));;

  constructor(
        private toast: ToastrService,
        private service: AuthService,
        private router: Router) {}

  ngOnInit(): void {
    this.service.logOut() ;
  }

  logar() {
    this.credsVO.username = this.creds.usuario;
    this.credsVO.password = this.creds.senha;
    this.service.authenticate(this.credsVO).subscribe (
      resposta => {
        this.credRet  = resposta.body;
        // console.log(this.credRet);
        this.service.sucessfullyLoggedIn(this.credRet.accessToken, this.credRet.refreshToken, this.credRet.userId)
        this.router.navigate(['home'])

      }, (error) => {
                this.toast.error('Usuario e/ou senha inválidos', 'Login')
                console.error(error.error.message);
                this.service.logOut() 
              }
              
    )

    
  }

  validaCampos(): boolean {
    return (this.usuario.valid && this.senha.valid) 
  }

}
