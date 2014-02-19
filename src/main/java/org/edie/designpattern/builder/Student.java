package org.edie.designpattern.builder;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-4-5
 * Time: 上午11:38
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    private final String name;
    private final int age;
    private final int height;
    private final int sex; //0表示男性，1表示女性，其它值非法


    private final String schoolName;
    private final String profession;
    //要求分班的时候，名字相同的同学不能分配到一个班级
    private final int gradeNo;//年级编号

    //扩展信息
    private final String idCard;//身份证号
    private final String stuNo;//学号
    private final String labName;//实验室名称
    private final String dormitoryAddress;//宿舍地址

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.sex = builder.sex;

        this.schoolName = builder.schoolName;
        this.profession = builder.profession;
        this.gradeNo = builder.gradeNo;

        this.idCard = builder.idCard;
        this.stuNo = builder.stuNo;
        this.labName = builder.labName;
        this.dormitoryAddress = builder.dormitoryAddress;
    }

    public static class Builder {

        private String name;
        private int age;
        private int height;
        private int sex; //0表示男性，1表示女性，其它值非法

        private String schoolName;
        private String profession;
        //要求分班的时候，名字相同的同学不能分配到一个班级
        private int gradeNo;//年级编号

        //扩展信息
        private String idCard;//身份证号
        private String stuNo;//学号
        private String labName;//实验室名称
        private String dormitoryAddress;//宿舍地址

        public Builder(String name, int age, int height, int sex) {
            super();
            this.name = name;
            this.age = age;
            this.height = height;
            this.sex = sex;
        }

        public Builder setSchoolName(String schoolName) {
            this.schoolName = schoolName;
            return this;
        }

        public Builder setProfession(String profession) {
            this.profession = profession;
            return this;
        }

        public Builder setGradeNo(int gradeNo) {
            this.gradeNo = gradeNo;
            return this;
        }


        public Builder setIdCard(String idCard) {
            this.idCard = idCard;
            return this;
        }

        public Builder setStuNo(String stuNo) {
            this.stuNo = stuNo;
            return this;
        }

        public Builder setLabName(String labName) {
            this.labName = labName;
            return this;
        }

        public Builder setDormitoryAddress(String dormitoryAddress) {
            this.dormitoryAddress = dormitoryAddress;
            return this;
        }

        //构造器入口
        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Students [name=" + name + ", age=" + age + ", height=" + height
                + ", sex=" + sex + ", schoolName=" + schoolName
                + ", profession=" + profession + ", gradeNo=" + gradeNo + "]";
    }

    public static void main(String[] args) {
        Student stu = new Student.Builder("icecode", 22, 178, 1).setSchoolName("BUPT").setProfession("Computer Science and Technology").setGradeNo(20091012).build();
        System.out.println(stu.toString());
    }
}