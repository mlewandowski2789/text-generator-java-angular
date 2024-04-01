import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  constructor(private http: HttpClient) {}

  getData(source: string, length: number): Observable<any> {
    const url = `http://localhost:8080/${source}/${length}`;
    return this.http.get<any>(url);
  }
}
