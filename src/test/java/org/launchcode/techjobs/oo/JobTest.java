package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1,job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job ProductTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         String expectedName = "Product tester";
         String expectedEmployer = "ACME";
         String expectedLocation = "Desert";
         String expectedPositionType= "Quality control";
         String expectedCoreCompetency = "Persistence";

         String actualName = ProductTester.getName();
         String actualEmployer = ProductTester.getEmployer().getValue();
        String actualLocation = ProductTester.getLocation().getValue();
        String actualPositionType = ProductTester.getPositionType().getValue();
        String actualCoreCompetency = ProductTester.getCoreCompetency().getValue();

        boolean conditionClass = ProductTester instanceof Job;
        boolean conditionName = actualName.contains(expectedName);
        boolean conditionEmployer = actualEmployer.contains(expectedEmployer);
        boolean conditionLocation = actualLocation.contains(expectedLocation);
        boolean conditionPositionType = actualPositionType.contains(expectedPositionType);
        boolean conditionCoreCompetency = actualCoreCompetency.contains(expectedCoreCompetency);

        assertEquals(expectedName, actualName);
        assertEquals(expectedEmployer, actualEmployer);
        assertEquals(expectedLocation, actualLocation);
        assertEquals(expectedPositionType, actualPositionType);
        assertEquals(expectedCoreCompetency,actualCoreCompetency);

        assertTrue(conditionClass);
        assertTrue(conditionName);
        assertTrue(conditionLocation);
        assertTrue(conditionEmployer);
        assertTrue(conditionPositionType);
        assertTrue(conditionCoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        Job job1= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
   assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newline = System.lineSeparator();
        String expectedString = newline + "ID: " + job1.getId() + newline +
                "Name: " + "Product tester" + newline +
                "Employer: " + "ACME" + newline +
                "Location: " + "Desert" + newline +
                "Position Type: " + "Quality control" + newline +
                "Core Competency: " + "Persistence" + newline;

        String actualString = job1.toString();
        assertEquals(expectedString, actualString);
    }


        @Test
        public void testToStringContainsCorrectLabelsAndData(){
            Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            String newline = System.lineSeparator();
            String expectedString = newline + "ID: " + job1.getId() + newline +
                    "Name: " + job1.getName() + newline +
                    "Employer: " + job1.getEmployer() + newline +
                    "Location: " + job1.getLocation() + newline +
                    "Position Type: " + job1.getPositionType() + newline +
                    "Core Competency: " + job1.getCoreCompetency() + newline;
            String actualString = job1.toString();
            assertEquals(expectedString, actualString);

    }
    @Test
    public void testToStringHandlesEmptyField(){
        String newline = System.lineSeparator();
        String noData = "Data not available";
        Job job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expectedData = newline + "ID: " + job1.getId() + newline +
                "Name: " + noData + newline +
                "Employer: " + noData + newline +
                "Location: " + noData + newline +
                "Position Type: " + noData + newline +
                "Core Competency: " + noData + newline;
        String actualData = job1.toString();
        assertEquals(expectedData, actualData);

    }
}
