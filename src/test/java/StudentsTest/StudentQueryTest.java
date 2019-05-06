package StudentsTest;

import cn.org.cerambycidae.pojo.Student;
import cn.org.cerambycidae.pojo.StudentExample;
import cn.org.cerambycidae.service.Impl.StudentMybatisServiceImpl;
import cn.org.cerambycidae.service.StudentService;
import cn.org.cerambycidae.util.ShowIterator;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

public class StudentQueryTest {

    @Test
    public void Test(){
        StudentService studentService = new StudentMybatisServiceImpl();
        StudentExample studentExample = new StudentExample();
        List<Student> students = studentService.selectByExample(studentExample);
        students.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student.getName());
            }
        });
    }
}
