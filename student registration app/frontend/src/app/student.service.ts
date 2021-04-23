import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student} from "./student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private httpClient:HttpClient) { }


  getAllStudentDetails():Observable<Student>{
   return this.httpClient.get<Student>("http://localhost:8080/student/getstudents")
  }

  addStudentDetails(data:object):Observable<Student>{
    return this.httpClient.post<Student>("http://localhost:8080/student/addstudent",data,);
  }

  getStudentById(id:number):Observable<Student>{
    return this.httpClient.get<Student>("http://localhost:8080/student/getstudent/"+id)
  }

  updateStudentById(data:object,id:number):Observable<Student>{
   return  this.httpClient.put<Student>("http://localhost:8080/student/update/"+id,data)
  }


   deleteStudentById(id:number):Observable<Student>{
    return this.httpClient.delete<Student>("http://localhost:8080/student/delete/"+id);
   }







}
