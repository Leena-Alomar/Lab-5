package com.example.lab5.Controller;
import java.util.ArrayList;
import com.example.lab5.API.ApiResponse;
import com.example.lab5.Model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student> students =new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Student> getStudents(){
        return students;
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student){
        students.add(student);
        return new ApiResponse("The Student Is Added Successfully ! ") ;
    }

    @PutMapping("/update/student/{index}")
    public ApiResponse updateStudent(@PathVariable int index,@RequestBody Student student){
        students.set(index,student);
        return new ApiResponse("The Student Is Updated Successfully !") ;
    }

    @DeleteMapping("/delete/student/{index}")
    public ApiResponse deleteStudent(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("Student Is Deleted Successfully !") ;
    }

    @GetMapping("get/honor")
    public  ApiResponse getHonor(){
        ArrayList<String> FirstHonor =new ArrayList<>();
        ArrayList<String> SecondHonor =new ArrayList<>();
        for(Student s :students){
            if(s.getGPA()>=4.50){
                FirstHonor.add(s.getName());
            }else if(s.getGPA()>=4.20&& s.getGPA()<4.50){
                SecondHonor.add(s.getName());
            }
        }
        return new ApiResponse(FirstHonor+" Students are A First Class Honor " +
                " "+SecondHonor+" Students are A Second Class Honor") ;
    }

    @GetMapping("/get/average")
    public ApiResponse getAverage(){
        double sum=0;
        int count=0;
        double average;
        for(Student st: students){
            count++;
            sum+=st.getGPA();
        }
        average=sum/count;
        for(Student stu: students){
            if(stu.getGPA()>average){
                return new ApiResponse(" The Student: "+stu.getName()+" Have A GPA Greater Than The Average") ;
            }
        }
        return new ApiResponse(" ");
    }
}
