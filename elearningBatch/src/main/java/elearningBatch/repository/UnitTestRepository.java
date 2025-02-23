package elearningBatch.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import elearningBatch.model.UnitTest;

@Repository
public interface UnitTestRepository {

    List<UnitTest> findAll();

    List<UnitTest> findAsVersion0();
    
    InputStream finddataAsId(@Param("sourceId") String sourceId);
    
    long countAsQuesNum(@Param("quesNum") String quesNum, @Param("userId") String userId);

    void updateAsQues(@Param("entity") UnitTest entity,
            @Param("sourceId") String sourceId);
}
