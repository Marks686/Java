import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-08-15
 * Time: 15:11
 */
class Student {
    public int classId;
    public int studentId;
}
public class TestJackson {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
//        // readValue 把 json 格式的字符串转成java对象
//        String s = "{ \"classId\": 10, \"studentId\": 20}";
//
//
//        Student student = objectMapper.readValue(s,Student.class);
//        System.out.println(student.classId);
//        System.out.println(student.studentId);
        Student student = new Student();
        student.classId = 10;
        student.studentId = 20;
        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);
    }
}
