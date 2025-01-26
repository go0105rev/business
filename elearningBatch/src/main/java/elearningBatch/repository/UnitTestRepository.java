package elearningBatch.repository;

import java.util.List;

import elearningBatch.model.UnitTest;

public interface UnitTestRepository {

    List<UnitTest> findAll();
    
    long updateAsQues();
}
