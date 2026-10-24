package in.spring.controller;

import in.spring.dto.*;
import in.spring.entity.Student;
import in.spring.service.studentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class studentController {

    private studentService studServ;

    public studentController(studentService studServ){
        this.studServ = studServ;
    }



    //create
    @PostMapping("/create")
    public ResponseEntity<CreatestudentResponseDto> createStudent( @Valid @RequestBody CreatestudentRequestDto studRequestDto){
        CreatestudentResponseDto studRespo = studServ.createStudent(studRequestDto);

        if(studRespo==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studRespo);

    }

    //get

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Long id){
        Optional<Student> studRespo = studServ.getStudent(id);

        if(studRespo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studRespo);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllstudentresponseDto>> getAllStudent( ){
        List<GetAllstudentresponseDto> studRespo = studServ.getAllStudent();
        return ResponseEntity.ok(studRespo);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<UpdatestudentResponseDto>updateStudent(
            @PathVariable Long id , @RequestBody UpdatestudentRequestDto stdRequest){

        UpdatestudentResponseDto studRespo = studServ.updateStudent(id ,stdRequest);

        if(studRespo ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studRespo);
    }



}
