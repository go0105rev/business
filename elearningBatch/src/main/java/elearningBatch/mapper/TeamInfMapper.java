package elearningBatch.mapper;

import elearningBatch.model.TeamInf;

public interface TeamInfMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_inf
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    int deleteByPrimaryKey(String teamId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_inf
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    int insert(TeamInf row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_inf
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    int insertSelective(TeamInf row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_inf
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    TeamInf selectByPrimaryKey(String teamId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_inf
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    int updateByPrimaryKeySelective(TeamInf row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team_inf
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    int updateByPrimaryKey(TeamInf row);
}