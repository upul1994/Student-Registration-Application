import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {StudentService} from "../../student.service";
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor(private studentService:StudentService,private activatedRoute:ActivatedRoute) { }

  id:any
  studentObject:any
  msg=false;

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(result=>{
      this.id =result.get("id");
    })

    this.studentService.getStudentById(this.id).subscribe(result=>{
       this.studentObject =result;
    })


  }

  updateStudent(formdata: NgForm) {

    const updatedStudent ={
      firstName:this.studentObject.firstName,
      lastName:this.studentObject.lastName,
      age:this.studentObject.age,
      phoneNumber:this.studentObject.phoneNumber
    }

   this.studentService.updateStudentById(updatedStudent,this.id).subscribe(result=>{
     this.msg =true;
   })
  }
}
