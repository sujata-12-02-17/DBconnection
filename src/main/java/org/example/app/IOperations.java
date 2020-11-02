package org.example.app;

import java.util.List;

public interface IOperations {
    public List<String> readFile();
    public void saveStudent(List<String> anyList);
    public void inputStudentName();
}
