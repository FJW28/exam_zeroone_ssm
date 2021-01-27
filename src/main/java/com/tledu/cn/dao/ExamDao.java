package com.tledu.cn.dao;

import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.StudentAnswer;
import com.tledu.cn.pojo.TestPaper;
import com.tledu.cn.pojo.TestQuestionBank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamDao {
    /**
     *
     * @param t_id
     * @return
     */
    public TestPaper selectTestPaper(String t_id);

    /**
     *
     * @param student
     * @return
     */
    public int studentRegist(Student student);

    /**
     *考生登录
     * @param
     * @return
     */
    public Student studentLogin(String stu_id);

    /**
     *查询试题
     * @param t_id
     * @return
     */
    public List<TestQuestionBank> selectExam(String t_id);

    /**
     * 用于保存答案
     * @param tq_id
     * @return
     */
    public StudentAnswer findStudentAnswerByTq_id(String tq_id);

    /**
     * 修改答案
     * @param studentAnswer
     * @return
     */
    public int updateAnswer(StudentAnswer studentAnswer);

    /**
     * 保存考生答案
     * @param studentAnswer
     * @return
     */
    public int saveAnswer(StudentAnswer studentAnswer);

    /**
     * 保存分数
     * @param tq_score
     * @param tq_id
     * @return
     */
    public int setScore( @Param("tq_score") int tq_score,@Param("tq_id") String tq_id);

    /**
     *
     * @param student
     * @return
     */
    public  Student findStudentById(Student student);

    /**
     *计算总分
     * @param student
     * @return
     */
    List<StudentAnswer> calculatedScore(Student student);

    /**
     * 设置交卷时间和分数
     * @param student
     * @return
     */
    public int setFinishTimeandScore(Student student);

    /**
     *答案错误
     * @param tq_id
     */
    int setScore1( String tq_id);
}
