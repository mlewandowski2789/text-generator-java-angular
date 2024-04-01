import {Component, OnInit} from '@angular/core';
import {DataService} from "./data.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'Angular';

  textLength: number = 100;
  source: string = 'wiki';
  message: string = '';
  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.getData();
  }

  getData(): void {
    this.dataService.getData(this.source,this.textLength)
      .subscribe(response => {
        this.message = response.message;
      });
  }

}
