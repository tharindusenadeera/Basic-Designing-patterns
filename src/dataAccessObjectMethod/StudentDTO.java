package dataAccessObjectMethod;

import java.util.List;

public interface StudentDTO {
    public List<Student> getAllStudents();
    public Student getStudent(int rollNo);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
}
