package in.spring.dto;

import jakarta.validation.constraints.*;

public class CreatestudentRequestDto {

    @NotNull(message = "Please enter valid id")
    private Long id;

    @NotBlank(message = "Name can`t be a empty/null or blank")
    @Size(min = 2,max=50)
    private String name;

    @NotBlank(message = "Subject can`t be a empty/null or blank")
    private String subject;

    @Email
    @NotBlank(message = "Student Email Can't be blank")
    private String email;

    @NotBlank(message = "Age is Required")
    @Min(value = 18 , message = "Student Must be Atleast 18 year old")
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
