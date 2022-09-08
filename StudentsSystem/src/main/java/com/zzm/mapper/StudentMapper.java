package com.zzm.mapper;

import com.zzm.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZZM
 * @creatTime 2022-09-07  10:27
 */
public interface StudentMapper {
    /**
     * 查询所有数据
     * @return
     */
    List<Student> selectAll();
    /**
     * 通过学号查询一条信息
     */
    Student selectByStudentNumber(@Param("num")Integer num);

    /**
     *插入一条数据
     */
    void insert(Student student);

    /**
     * 删除一条数据通过学号
     */
    void deleteByStudentNumber(@Param("num") Integer num);

    /**
     * 修改一条信息
     * 若属性为空则不改该条属性
     */
    void update(Student student);
}
