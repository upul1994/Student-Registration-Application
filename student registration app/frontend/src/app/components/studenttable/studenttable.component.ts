import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {StudentService} from "../../student.service";

@Component({
  selector: 'app-studenttable',
  templateUrl: './studenttable.component.html',
  styleUrls: ['./studenttable.component.css']
})
export class StudenttableComponent implements OnInit {

  constructor(private studentService:StudentService) { }

  studentList:any
  listIndex:any
  msg=false;


  ngOnInit(): void {
    this.studentService.getAllStudentDetails().subscribe(result=>{
      this.studentList =result

    })
  }


  deleteStudent(id: number) {

    this.studentList.findIndex((value:any,i:number)=>{
        if(value.id==id){
          this.listIndex =i
        }
    })

    this.studentList.splice(this.listIndex,1)
    this.studentService.deleteStudentById(id).subscribe(result=>{
      this.msg=true;
    })
  }
}
