import { Component} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,HttpClientModule,ReactiveFormsModule,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'reservation-app';



  constructor(private http:HttpClient){}

  private baseUrl:string = 'http://localhost:8080';
  private reservationUrl:string = this.baseUrl + '/room/v1/reservation/';

  rooms: Room[]=[];

  ngOnInit(){
    this.rooms = [
      new Room("127","127","150"),
      new Room("138","138","180"),
      new Room("254","254","300")
    ];
  }
}
export class Room{
  id:String;
  roomNumber:String;
  price:String;

  constructor(id: string,roomNumber: string,price: string){
    this.id = id;
    this.roomNumber = roomNumber;
    this.price = price;
    }

  }
