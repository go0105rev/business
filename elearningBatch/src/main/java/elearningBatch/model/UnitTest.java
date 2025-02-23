package elearningBatch.model;

import java.io.InputStream;
import java.util.Date;

public class UnitTest {

    private String sourceId;
    private String userId;
    private String quesNum;
    private Short status;
    private Date savetime;
    private String strsavetime;
    private Double size;
    private Double duration;
    private Long score;
    private InputStream source;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_test.sourceid
     *
     * @return the value of unit_test.sourceid
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_test.sourceid
     *
     * @param sourceId the value for unit_test.sourceid
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_test.user_id
     *
     * @return the value of unit_test.user_id
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_test.user_id
     *
     * @param userId the value for unit_test.user_id
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_test.ques_num
     *
     * @return the value of unit_test.ques_num
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public String getQuesNum() {
        return quesNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_test.ques_num
     *
     * @param quesNum the value for unit_test.ques_num
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public void setQuesNum(String quesNum) {
        this.quesNum = quesNum == null ? null : quesNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_test.version
     *
     * @return the value of unit_test.version
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_test.version
     *
     * @param status the value for unit_test.version
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_test.savetime
     *
     * @return the value of unit_test.savetime
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public Date getSavetime() {
        return savetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_test.savetime
     *
     * @param savetime the value for unit_test.savetime
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public void setSavetime(Date savetime) {
        this.savetime = savetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_test.strsavetime
     *
     * @return the value of unit_test.strsavetime
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public String getStrsavetime() {
        return strsavetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_test.strsavetime
     *
     * @param strsavetime the value for unit_test.strsavetime
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public void setStrsavetime(String strsavetime) {
        this.strsavetime = strsavetime == null ? null : strsavetime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_test.size
     *
     * @return the value of unit_test.size
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public Double getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_test.size
     *
     * @param size the value for unit_test.size
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public void setSize(Double size) {
        this.size = size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_test.duration
     *
     * @return the value of unit_test.duration
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public Double getDuration() {
        return duration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_test.duration
     *
     * @param duration the value for unit_test.duration
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_test.score
     *
     * @return the value of unit_test.score
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public Long getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_test.score
     *
     * @param score the value for unit_test.score
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public void setScore(Long score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column unit_test.source
     *
     * @return the value of unit_test.source
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public InputStream getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column unit_test.source
     *
     * @param source the value for unit_test.source
     *
     * @mbg.generated Sun Jan 26 13:43:25 JST 2025
     */
    public void setSource(InputStream source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "UnitTest [sourceId=" + sourceId + ", userId=" + userId
                + ", quesNum=" + quesNum + ", status=" + status
                + ", savetime=" + savetime + ", strsavetime=" + strsavetime
                + ", size=" + size + ", duration=" + duration + ", score="
                + score + "]";
    }
    
    
}