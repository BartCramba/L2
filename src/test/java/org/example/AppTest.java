package org.example;

import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.Assert;
import org.junit.Test;
import repository.NotaRepository;
import repository.StudentRepository;
import repository.TemaRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

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
    public void testAddGrade() {

        StudentValidator studentValidator = new StudentValidator();
        StudentRepository repository = new StudentRepository(studentValidator);

        NotaValidator notaValidator = new NotaValidator();
        NotaRepository notaRepository = new NotaRepository(notaValidator);

        TemaValidator temaValidator = new TemaValidator();
        TemaRepository temaRepository = new TemaRepository(temaValidator);

        Student student = new Student("1","Cramba", 932);
        repository.save(student);

        Tema tema = new Tema("1", "hard one", 2, 1);
        temaRepository.save(tema);

        Pair pair = new Pair<>("1","1");

        Nota nota = new Nota(pair, 2, 3, "very good homework");
        notaRepository.save(nota);

        assertNotNull(notaRepository.findOne(nota.getID()));
    }

    @Test
    public void testAddAssignment12() {
        //all data is valid, assignment is added
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String idAssignment = "1";
        String description = "description";
        int deadline = 6;
        int startline = 1;

        Tema assigment = new Tema(idAssignment, description, deadline, startline);

        TemaValidator validator = new TemaValidator();
        TemaRepository assignmentRepository = new TemaRepository(validator);

        assignmentRepository.delete(idAssignment);

        assertNull(assignmentRepository.findOne(idAssignment));
        assignmentRepository.save(assigment);

        assertNotNull(assignmentRepository.findOne(idAssignment));
    }

    @Test
    public void testAddStudent1() {
        StudentValidator studentValidator = new StudentValidator();
        StudentRepository repository = new StudentRepository(studentValidator);
        repository.delete("1");
        Student student = new Student("1","Andreea", 932);
        repository.save(student);

        assertTrue(repository.findOne("1").getNume().equals("Andreea")==true);
    }

    @Test
    public void testAll() {
        testAddAssignment12();
        testAddGrade();
        testAddStudent1();
    }

}
