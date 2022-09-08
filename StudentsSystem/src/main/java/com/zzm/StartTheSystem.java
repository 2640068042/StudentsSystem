package com.zzm;

import com.zzm.mapper.ScoreMapper;
import com.zzm.mapper.StudentMapper;
import com.zzm.pojo.Score;
import com.zzm.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZZM
 * @creatTime 2022-09-07  15:55
 */
public class StartTheSystem {
    static SqlSession sqlSession=null;
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        sqlSession=sqlSessionFactory.openSession(true);
    }
    static ScoreMapper scoreMapper=sqlSession.getMapper(ScoreMapper.class);
    static StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);

    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        int doing=0;
        System.out.println("欢迎进入学生管理系统！");
        while(doing!=8) {
            System.out.println("请输入要进行的事项：");
            System.out.println("1.查询学生基本信息（学号，姓名，性别，住址，电话）");
            System.out.println("2.修改一条学生基本信息通过学号");
            System.out.println("3.删除一条学生信息通过学号");
            System.out.println("************************");
            System.out.println("4.查询一条学生详细信息通过学号");
            System.out.println("5.增加一条学生详细信息");
            System.out.println("6.修改一条学生详细信息通过学号");
            System.out.println("7.学生综合数据输出");
            System.out.println("8.退出系统\n");
            System.out.print("请输入你的选择：");
            doing=input.nextInt();
            switch(doing){
                case 1:selectBasicMessage();break;
                case 2:updateOneBasicMessage();break;
                case 3:deleteOneBasicMessage();break;
                case 4:selectOneAllMessage();break;
                case 5:insertOneAllMessage();break;
                case 6:updateOneAllMessage();break;
                case 7:selectAllMessage();break;
            }
        }
        //关闭资源
        sqlSession.close();
    }

    //1.查询学生基本信息（学号，姓名，性别，住址，电话）
    public static void selectBasicMessage() throws IOException {
        List<Student> students = studentMapper.selectAll();
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

   /* //2.录入一条学生基本信息
    public static void insertOneBasicMessage(){
        Student student=new Student();
        Scanner input=new Scanner(System.in);
        System.out.println("学号：");
        student.setStudentNumber(input.nextInt());
        System.out.println("姓名：");
        student.setName(input.next());
        System.out.println("性别：");
        student.setGender(input.next());
        System.out.println("地址：");
        student.setHomeAddress(input.next());
        Student student1 = studentMapper.selectByStudentNumber(student.getStudentNumber());
        if(student1!=null)System.out.println("已存在该学号的学生，输入错误！");
        else{
            studentMapper.insert(student);
        }
    }*/

    //2.修改一条学生基本信息通过学号
    public static void updateOneBasicMessage(){
        Student student=new Student();
        Scanner input =new Scanner(System.in);
        System.out.print("请输入要修改学生的学号：");
        int number = input.nextInt();
        Student student1 = studentMapper.selectByStudentNumber(number);
        if(student1!=null){
        System.out.println(student1);
        System.out.println("请输入修改后数据");
        System.out.print("姓名：");
        student.setName(input.next());
        System.out.print("性别：");
        student.setGender(input.next());
        System.out.print("地址：");
        student.setHomeAddress(input.next());
        studentMapper.update(student);
        System.out.println("修改完成！");}
        else{
            System.out.println("没有该学号的学生！");
        }
    }

    //3.删除一条学生信息通过学号
    public static void deleteOneBasicMessage(){
        Scanner input =new Scanner(System.in);
        System.out.println("请输入要删除的学生学号");
        int number = input.nextInt();
        Student student1 = studentMapper.selectByStudentNumber(number);
        if(student1!=null){
            System.out.println(student1);
            studentMapper.deleteByStudentNumber(number);
            scoreMapper.deleteByStudentNumber(number);
            scoreMapper.updateFinalPosition();
            scoreMapper.updateFinalPosition();
            System.out.println("删除成功！");
        }else{
            System.out.println("没有该学号的学生！");
        }
    }

    //4.查询一条学生详细信息通过学号
    public static void selectOneAllMessage(){
        Scanner input =new Scanner(System.in);
        System.out.println("请输入要查询的学生学号");
        int number = input.nextInt();
        Student student = studentMapper.selectByStudentNumber(number);
        if(student!=null){
            Score score = scoreMapper.selectByStudentNumberScore(number);
            System.out.print(student);
            System.out.println(score);
        }else{
            System.out.println("没有该学号的学生！");
        }
    }

    //5.增加一条学生详细信息
    public static void insertOneAllMessage(){
        Scanner input =new Scanner(System.in);
        System.out.println("请输入要添加的学生学号：");
        Student student=new Student();
        Score score=new Score();
        int number = input.nextInt();
        Student student1 = studentMapper.selectByStudentNumber(number);
        if(student1==null){
            student.setStudentNumber(number);
            score.setStudentNumber(number);
            System.out.print("姓名：");
            student.setName(input.next());
            System.out.print("性别：");
            student.setGender(input.next());
            System.out.print("地址：");
            student.setHomeAddress(input.next());
            System.out.println("电话：");
            student.setTelephoneNumber(input.nextInt());
            studentMapper.insert(student);
            System.out.print("语文：");
            score.setChinese(input.nextDouble());
            System.out.print("数学：");
            score.setMath(input.nextDouble());
            System.out.print("外语：");
            score.setEnglish(input.nextDouble());
            System.out.print("同学互评成绩：");
            score.setStudentScore(input.nextDouble());
            System.out.print("品德成绩：");
            score.setMoralScore(input.nextDouble());
            System.out.print("任课教师评分：");
            score.setTeacherScore(input.nextDouble());
            scoreMapper.insert(score);
            scoreMapper.updateAverageScore();
            scoreMapper.updateFinalScore();
            scoreMapper.updatePosition();
            scoreMapper.updateFinalPosition();
            System.out.println("修改成功！");
        }else{
            System.out.println("已经存在该学号的学生！");
        }
    }



    //6.修改一条学生详细信息通过学号
    public static void updateOneAllMessage(){
        Scanner input =new Scanner(System.in);
        System.out.println("请输入要修改的学生学号");
        Student student=new Student();
        Score score=new Score();
        int number = input.nextInt();
        Student student1 = studentMapper.selectByStudentNumber(number);
        if(student1!=null){
            student.setStudentNumber(number);
            score.setStudentNumber(number);
            System.out.println(student1);
            System.out.println("输入要修改的数据");
            System.out.print("姓名：");
            student.setName(input.next());
            System.out.print("性别：");
            student.setGender(input.next());
            System.out.print("地址：");
            student.setHomeAddress(input.next());
            studentMapper.update(student);
            System.out.print("语文：");
            score.setChinese(input.nextDouble());
            System.out.print("数学：");
            score.setMath(input.nextDouble());
            System.out.print("外语：");
            score.setEnglish(input.nextDouble());
            System.out.print("同学互评成绩：");
            score.setStudentScore(input.nextDouble());
            System.out.print("品德成绩：");
            score.setMoralScore(input.nextDouble());
            System.out.print("任课教师评分：");
            score.setTeacherScore(input.nextDouble());
            scoreMapper.updateByStudentNumber(score);
            scoreMapper.updateAverageScore();
            scoreMapper.updateFinalScore();
            scoreMapper.updatePosition();
            scoreMapper.updateFinalPosition();
            System.out.println("修改成功！");
        }else{
            System.out.println("没有该学号的学生！");
        }
    }
    //7.学生综合数据输出
    public static void selectAllMessage(){
        List<Student> students = studentMapper.selectAll();
        List<Score> scores=scoreMapper.selectAll();
        Iterator<Student> iterator = students.iterator();
        Iterator<Score> iterator1 = scores.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"");
            System.out.println(iterator1.next());
        }
    }
}
