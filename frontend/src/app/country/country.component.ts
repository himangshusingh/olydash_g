import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-country',
  standalone: true,
  imports: [CommonModule,    
            FormsModule, 
            ReactiveFormsModule,
            HttpClientModule],
  templateUrl: './country.component.html',
  styleUrl: './country.component.css'
})
export class CountryComponent implements OnInit {

  title = 'Country'
  countries: any = []
  isGreen = true


  constructor(private router: Router, private http: HttpClient){
  }

  ngOnInit(): void {
      this.fetchAllCountries();
  }

  AddCountry(){
    console.log("AddCountry button is clicked !!!")
    this.router.navigateByUrl('/add-country')
  }


  fetchAllCountries(){
    // const headers = new HttpHeaders({
    //   'Content-Type': 'application/json',
    //   'API-KEY': '12345-abcde-67890-fghij',
    // });
  
    this.http
      .get('http://localhost:8080/country/getAll')
      .subscribe(resp => {
        this.countries = resp;
        console.log('Countries retrieved successfully:', this.countries);
      }, error => {
        console.error('Error retrieving countries:', error);
      });
  }
  

  deleteCountry(countryID:Number){
    
    const url = 'http://localhost:8080/country/delete/' +countryID
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Book deleted successfully');
      this.fetchAllCountries();
    }, error => {
      console.error('Error deleting country:', error);
    });
  }

}
