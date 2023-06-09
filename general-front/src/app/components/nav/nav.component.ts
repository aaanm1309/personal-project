import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  constructor(
    private router: Router,
    private authService: AuthService,
    private toast: ToastrService){}
  ngOnInit(): void {
    
    this.router.navigate(['task']);
  }

  logout(): void {
    this.authService.logOut();
    this.router.navigate(['login']);
    this.toast.info('Logout realizado com sucesso.','Logout', { timeOut: 7000})
  }

}
