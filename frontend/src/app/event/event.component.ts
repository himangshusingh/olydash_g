import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-event',
  standalone: true,
  imports: [CommonModule,    
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule],
  templateUrl: './event.component.html',
  styleUrl: './event.component.css'
})
export class EventComponent implements OnInit{
  title = 'Event'
  events: any = []
  isGreen = true


  constructor(private router: Router, private http: HttpClient){
  }

  ngOnInit(): void {
      this.fetchAllEvents();
  }

  AddEvent(){
    console.log("AddEvent button is clicked !!!")
    this.router.navigateByUrl('/add-event')
  }


  fetchAllEvents(){
    // const headers = new HttpHeaders({
    //   'Content-Type': 'application/json',
    //   'API-KEY': '12345-abcde-67890-fghij',
    // });
  
    this.http
      .get('http://localhost:8080/events/getAll')
      .subscribe(resp => {
        this.events = resp;
        console.log('Events retrieved successfully:', this.events);
      }, error => {
        console.error('Error retrieving events:', error);
      });
  }
  

  deleteEvent(eventID:Number){
    
    const url = 'http://localhost:8080/events/delete/' +eventID
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Event deleted successfully');
      this.fetchAllEvents();
    }, error => {
      console.error('Error deleting event:', error);
    });
  }

}
