package com.systechafrica.part2.lms;

public interface StudentInterface {
    void createStudent(Student student);
    void getStudentBorrowStatus(Student student);
    void penalize(Student student);
}
