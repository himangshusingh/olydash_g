import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-athlete',
  standalone: true,
  imports: [CommonModule,    
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule],
  templateUrl: './athlete.component.html',
  styleUrl: './athlete.component.css'
})
export class AthleteComponent {
  title = 'Athlete'
  athletes: any = []
  isGreen = true


  constructor(private router: Router, private http: HttpClient){
  }

  ngOnInit(): void {
      this.fetchAllAthletes();
  }

  AddAthlete(){
    console.log("AddAthlete button is clicked !!!")
    this.router.navigateByUrl('/add-athlete')
  }


  fetchAllAthletes(){
    // const headers = new HttpHeaders({
    //   'Content-Type': 'application/json',
    //   'API-KEY': '12345-abcde-67890-fghij',
    // });
  
    this.http
      .get('http://localhost:8080/athletes/getAll')
      .subscribe(resp => {
        this.athletes = resp;
        console.log('Countries retrieved successfully:', this.athletes);
      }, error => {
        console.error('Error retrieving countries:', error);
      });
  }
  

  deleteAthlete(athleteID:Number){
    
    const url = 'http://localhost:8080/athletes/delete/' +athleteID
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Book deleted successfully');
      this.fetchAllAthletes();
    }, error => {
      console.error('Error deleting athlete:', error);
    });
  }
}
