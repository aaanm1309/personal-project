import { Component, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { Tecnico } from 'src/app/models/tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-tecnico-list',
  templateUrl: './tecnico-list.component.html',
  styleUrls: ['./tecnico-list.component.css']
})
export class TecnicoListComponent {


  // displayedColumns: string[] = ['id', 'firstName', 'lastName', 'cpf', 'email', 'address', 'password', 'createdAt', 'acoes'];
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'cpf', 'email', 'address', 'createdAt', 'acoes'];
  dataSource = new MatTableDataSource<Tecnico>(null);

  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor( private service: TecnicoService){}

  ngOnInit() {
    this.findAll();
  }
  


  ngAfterViewInit() {
    
  }

  findAll() {
    this.service.findAll().subscribe(resposta=> {
      // this.ELEMENT_DATA = resposta;
      this.dataSource = new MatTableDataSource<Tecnico>(resposta);
      this.dataSource.paginator = this.paginator;
      
    });
  }

  applyFilter( event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}

