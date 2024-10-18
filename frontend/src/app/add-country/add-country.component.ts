import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { CountryComponent } from '../country/country.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-country',
  standalone: true,
  imports: [CountryComponent,
            CommonModule,
            ReactiveFormsModule,
            HttpClientModule ],
  templateUrl: './add-country.component.html',
  styleUrl: './add-country.component.css'
})
export class AddCountryComponent implements OnInit {
  countryForm : FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router){
    this.countryForm = this.formbuilder.group({
      // country_id: [],
      country_Name: [],
      iso_code: [],
    })
  }

  ngOnInit(): void {
  }

  saveCountry(){    
    const CountryData = this.countryForm.value;
    // Handle date to string
    this.http.post('http://localhost:8080/country/savecountry',CountryData)
    .subscribe(response => {
      console.log('Country saved to DB', response)
      this.router.navigateByUrl('/country')
    }, error =>{
      console.error("Error in country save", error)
    }
    );

  }

}
