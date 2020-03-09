package org.example;

import static org.junit.Assert.assertTrue;

import domain.Student;
import org.junit.Assert;
import org.junit.Test;
import repository.StudentRepository;
import validation.StudentValidator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Assert.assertTrue( true );
    }

    @Test
    public void testAddStudent1() {

        StudentValidator studentValidator = new StudentValidator();
        StudentRepository repository = new StudentRepository(studentValidator);
        Student student = new Student("1234","Cramba", 932);
        repository.save(student);

        Assert.assertNotNull(repository.findOne(student.getID()));
    }

    @Test
    public void testAddStudent2() {

        StudentValidator studentValidator = new StudentValidator();
        StudentRepository repository = new StudentRepository(studentValidator);
        Student student = new Student("1234","Flavius", 933);

        Assert.assertNull(repository.findOne(student.getID()));
    }
}
