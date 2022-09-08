package com.zzm.mapper;

import com.zzm.pojo.Score;
import com.zzm.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZZM
 * @creatTime 2022-09-07  10:27
 */
public interface ScoreMapper {
    /**
     * 查询所有数据
     */
    List<Score> selectAll();

    /**
     * 查询一条数据
     */
    Score selectByStudentNumberScore(@Param("num") Integer num);

    /**
     * 插入一条数据
     */
    void insert(Score score);

    /**
     * 更新总排名
     */
    void updateFinalPosition();

    /**
     * 更新总分数
     */
    void updateFinalScore();

    /**
     * 更新平均名次
     */
    void updatePosition();

    /**
     * 更新平均成绩
     */
    void updateAverageScore();

    /**
     * 删除一条信息通过学号
     */
    void deleteByStudentNumber(@Param("num") Integer num);

    /**
     * 更新一条数据通过学号
     */
    void updateByStudentNumber(Score score);
}
