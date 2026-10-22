package in.spring.service;


import in.spring.dto.CreatestudentRequestDto;
import in.spring.dto.CreatestudentResponseDto;
import in.spring.dto.UpdatestudentRequestDto;
import in.spring.dto.UpdatestudentResponseDto;
import in.spring.entity.Student;
import in.spring.repositery.studentRepositery;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class studentService {

    private studentRepositery studRepos;
    public studentService(studentRepositery studRepos){

        this.studRepos = studRepos;
    }



    public CreatestudentResponseDto createStudent(CreatestudentRequestDto studRequestDto){

        Student student = mapToEntity(studRequestDto);
        student.setUpdatedAt(LocalDateTime.now());
        student.setCreatedAt(LocalDateTime.now());

        Student studResp = studRepos.save(student);


        return mapToDto(studResp);





    }


    public Optional<Student> getStudent(Long id){
        Optional<Student> studRespo = studRepos.findById(id);

        return  studRespo;
    }






    //update

    public  UpdatestudentResponseDto updateStudent(Long id   , UpdatestudentRequestDto stdRequest){
        Optional<Student> existingStudent =  studRepos.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setName(stdRequest.getName());
        studentToSave.setAge(stdRequest.getAge());
        studentToSave.setSubject(stdRequest.getSubject());
        studentToSave.setDeleted(false);
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student  saveStudent= studRepos.save(studentToSave);

        return mapToUpdateDto(saveStudent);

    }





    private Student mapToEntity(CreatestudentRequestDto studRequestDto ){
        Student student = new Student();
        student.setName(studRequestDto.getName());
        student.setAge(studRequestDto.getAge());
        student.setEmail(studRequestDto.getEmail());
        student.setSubject(studRequestDto.getSubject());

        student.setDeleted(false);

        return  student;
    }


    private CreatestudentResponseDto mapToDto(Student student){
        CreatestudentResponseDto responseDTO = new CreatestudentResponseDto();

        responseDTO.setName(student.getName());
        responseDTO.setId(student.getId());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setAge(student.getAge());

        responseDTO.setMessage("Record Save Successfully");
        responseDTO.setCreatedAt(student.getCreatedAt());
        responseDTO.setUpdatedAt(student.getUpdatedAt());

        return responseDTO;


    }

    private UpdatestudentResponseDto mapToUpdateDto(Student student){

        UpdatestudentResponseDto responseDTO = new UpdatestudentResponseDto();

        responseDTO.setName(student.getName());
        responseDTO.setId(student.getId());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setAge(student.getAge());

        responseDTO.setMessage("Record Updated Successfully");

        responseDTO.setUpdatedAt(student.getUpdatedAt());

        return responseDTO;



    }

}
