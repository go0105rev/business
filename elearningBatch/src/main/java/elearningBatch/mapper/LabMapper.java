package elearningBatch.mapper;

import elearningBatch.model.Lab;

public interface LabMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lab
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    int deleteByPrimaryKey(Integer scope);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lab
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    int insert(Lab row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lab
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    int insertSelective(Lab row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lab
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    Lab selectByPrimaryKey(Integer scope);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lab
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    int updateByPrimaryKeySelective(Lab row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lab
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    int updateByPrimaryKey(Lab row);
}