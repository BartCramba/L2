package org.example;

import static org.junit.Assert.assertTrue;

import domain.Student;
import domain.Tema;
import org.junit.Assert;
import org.junit.Test;
import repository.StudentRepository;
import repository.TemaRepository;
import validation.StudentValidator;
import validation.TemaValidator;

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

//        StudentValidator studentValidator = new StudentValidator();
//        StudentRepository repository = new StudentRepository(studentValidator);
//        Student student = new Student("1234","Cramba", 932);
//        repository.save(student);
//
//        Assert.assertNotNull(repository.findOne(student.getID()));
    }

    @Test
    public void testAddStudent2() {

//        StudentValidator studentValidator = new StudentValidator();
//        StudentRepository repository = new StudentRepository(studentValidator);
//        Student student = new Student("1234","Flavius", 933);
//
//        Assert.assertNull(repository.findOne(student.getID()));
    }

    @Test
    public void testAddAssignment1(){
        TemaValidator temaValidator = new TemaValidator();
        TemaRepository repo = new TemaRepository(temaValidator);
        Tema tema = new Tema("14", "descriere1", 8, 4);
        repo.save(tema);

        Assert.assertNotNull(repo.findOne(tema.getID()));
    }

    @Test
    public void testAddAssignment2(){
        TemaValidator temaValidator = new TemaValidator();
        TemaRepository repo = new TemaRepository(temaValidator);
        Tema tema = new Tema("15", "descriere2", 9, 4);


        Assert.assertNull(repo.findOne(tema.getID()));
    }
}
