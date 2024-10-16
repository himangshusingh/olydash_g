import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sport',
  standalone: true,
  imports: [CommonModule,    
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule],
  templateUrl: './sport.component.html',
  styleUrl: './sport.component.css'
})
export class SportComponent implements OnInit{
  
  title = 'sport'
  sports: any = []
  isGreen = true


  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllSports();
  }

  AddSport(){
    console.log("AddSpoer button is clicked !")
    this.router.navigate(['/add-sport'])
  }

  fetchAllSports(){
    this.http
      .get('http://localhost:8080/sport/getAll')
      .subscribe(resp => {
        this.sports = resp;
        console.log('Sports retrieved successfully:', this.sports);
      }, error => {
        console.error('Error retrieving sports:', error);
      });
  }

  deleteSport(countryID:Number){
    
    const url = 'http://localhost:8080/sport/delete/' +countryID
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Book deleted successfully');
      this.fetchAllSports();
    }, error => {
      console.error('Error deleting country:', error);
    });
  }
}
