import { Component, OnInit } from '@angular/core';
import {StudentService} from "../../student.service";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private studentService:StudentService,private router: Router) { }

  msg=false;

  ngOnInit(): void {
  }

  addStudent(formdata: NgForm){
    const studentDetails={
      firstName:formdata.value.firstName,
      lastName:formdata.value.lastName,
      age:formdata.value.age,
      phoneNumber:formdata.value.phoneNumber
    }

    this.studentService.addStudentDetails(studentDetails).subscribe(result=>{
      this.msg =true;
      this.router.navigate(["/list"])

    },error => {
      console.log(error)
    })
  }



}
