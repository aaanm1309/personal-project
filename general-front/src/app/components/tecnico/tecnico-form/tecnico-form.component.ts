import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Tecnico } from 'src/app/models/tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-tecnico-form',
  templateUrl: './tecnico-form.component.html',
  styleUrls: ['./tecnico-form.component.css']
})
export class TecnicoFormComponent implements OnInit, OnChanges {
  vfirstName: FormControl = new FormControl(null, Validators.minLength(3));
  vlastName: FormControl = new FormControl(null, Validators.minLength(3));
  vcpf: FormControl = new FormControl(null, Validators.required);
  vsenha: FormControl = new FormControl(null, Validators.minLength(3));
  vaddress: FormControl = new FormControl(null, Validators.minLength(3));
  vemail: FormControl = new FormControl(null, Validators.email);
  tecnico: Tecnico = {
    id:            '',
    firstName:      '',
    lastName:       '',
    cpf:            '',
    email:          '',
    address:        '',
    password:       '',
    perfis:         [],
    gender:         'female',
    enabled:        1,
    createdAt:      ''
  };

  // groupForm: FormGroup = new FormGroup();

  constructor( 
    private service: TecnicoService,
    private toast : ToastrService ,
    private router: Router,
    private route: ActivatedRoute   ) {

  }

  action: string;
  cabec: string;
  disable_component: boolean = false;

  @Input() public tipoAcao: string ; 
  //
  // set tipoAcao(tipoAcao: string) {
  //   if (tipoAcao === 'create' || tipoAcao === 'update' || tipoAcao === 'delete'){
  //     this.action = tipoAcao;
  //     this.disable_component = false;
  //     if (tipoAcao === 'create') {
  //       this.cabec = 'Cadastrar ';
  //     } else if (tipoAcao === 'update') {
  //       this.cabec = 'Alterar ';
  //     } else if (tipoAcao === 'delete') {
  //       this.cabec = 'Deletar ';
  //       this.disable_component = true;
  //     }

  //   }
  // }
  
  ngOnInit() {
    console.log(this.action);
    if (this.action === 'update' || this.action === 'delete') {
      this.tecnico.id = this.route.snapshot.paramMap.get('id');
      this.findById();
    }
  }

  ngOnChanges() {
    if (this.tipoAcao === 'create' || this.tipoAcao === 'update' || this.tipoAcao === 'delete'){
      this.action = this.tipoAcao;
      this.disable_component = false;
      if (this.tipoAcao === 'create') {
        this.cabec = 'Cadastrar ';
      } else if (this.tipoAcao === 'update') {
        this.cabec = 'Alterar ';
      } else if (this.tipoAcao === 'delete') {
        this.cabec = 'Deletar ';
        this.disable_component = true;
      }
      // alert(this.tipoAcao);
    }
  }

  findById() {
    this.service.findById(this.tecnico.id).subscribe(resp => this.tecnico = resp);
  }

  save() : void {
    if (this.action == 'create') {
        this.create();
    } else  if (this.tipoAcao === 'update') {
      this.update();

    } else  if (this.tipoAcao === 'delete') {
      this.delete();

    }
  }


  create() : void {
    // console.log(this.tecnico);
    this.service.create(this.tecnico).subscribe(resposta => {
      this.toast.success('Técnico criado com sucesso' );
      this.router.navigate(['/tecnicos']);
    }, ex => { 
      console.log(ex);
      if (ex.error.errors) {
        ex.error.errors.forEach(element => {
          this.toast.error(element.message)
        });

      } else {
        this.toast.error(ex.error.message)
      }
     });
  }

  update() : void {
    // console.log(this.tecnico);
    this.service.update(this.tecnico).subscribe(resposta => {
      this.toast.success('Técnico atualizado com sucesso','Update' );
      this.router.navigate(['/tecnicos']);
    }, ex => { 
      console.log(ex);
      if (ex.error.errors) {
        ex.error.errors.forEach(element => {
          this.toast.error(element.message)
        });

      } else {
        this.toast.error(ex.error.message)
      }
     });
  }

  delete() : void {
    console.log(this.tecnico);
    this.toast.success('Técnico apagado com sucesso','Update' );
    this.router.navigate(['/tecnicos']);
    // this.service.update(this.tecnico).subscribe(resposta => {
    //   this.toast.success('Técnico atualizado com sucesso','Update' );
    //   this.router.navigate(['/tecnicos']);
    // }, ex => { 
    //   console.log(ex);
    //   if (ex.error.errors) {
    //     ex.error.errors.forEach(element => {
    //       this.toast.error(element.message)
    //     });

    //   } else {
    //     this.toast.error(ex.error.message)
    //   }
    //  });
  }

  addPerfil(perfil: any): void {

    if (this.tecnico.perfis.includes(perfil)) {
      this.tecnico.perfis.splice(this.tecnico.perfis.indexOf(perfil));
    } else {
      this.tecnico.perfis.push(perfil);
    }
    // console.log(this.tecnico.perfis);
  }

  carregaPerfil(perfil: any): void {  // TODO: implementar carrega perfil

    if (this.tecnico.perfis.includes(perfil)) {
      this.tecnico.perfis.splice(this.tecnico.perfis.indexOf(perfil));
    } else {
      this.tecnico.perfis.push(perfil);
    }
    // console.log(this.tecnico.perfis);
  }


  validaCampos(): boolean {
    return this.vfirstName.valid 
            && this.vlastName.valid
            && this.vcpf.valid
            && this.vemail.valid
            && this.vaddress.valid
            && this.vsenha.valid
  }

  desabilitaCampos(): boolean {
    return this.disable_component
  }

}
