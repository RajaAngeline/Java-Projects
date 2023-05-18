
import java.util.ArrayList;
import java.util.Arrays;

    public class StudentManagementSystem implements StudentMgmtInterface {
        int i = 0;
        ArrayList<Student> StudentArray = new ArrayList<>(10);


        @Override
        public boolean addStudent(Student s) {
            if (i <= 10) {
                StudentArray.add(s);
                i++;
                return true;
            }
            return false;
        }

        @Override
        public boolean deleteStudent(long rollNo) throws StudentDoesntExist {
            for (Student s : StudentArray)
                if (s.getRollNo() == rollNo) {
                    StudentArray.remove(s);
                    return true;
                }
            throw new StudentDoesntExist("-------------This" + rollNo + "\t" + "   rollNumber is not  found--------");
        }

        @Override
        public void listStudents() {
            StudentArray.stream().forEach(System.out::println);
        }

        @Override
        public boolean updateStudent(long rollNo, Student std) throws StudentDoesntExist {
            for (int i = 0; i < StudentArray.size(); i++)
                if (StudentArray.get(i).getRollNo() == rollNo) {
                    StudentArray.set(i, std);
                    return true;
                }
            throw new StudentDoesntExist("-------This mentioned roll number is not found------- ");
        }

        @Override
        public Student findTopper() {
            Student d = StudentArray.get(0);
            double big = Arrays.stream(StudentArray.get(0).getMarks()).mapToDouble(x -> x).average().getAsDouble();
            for (Student s : StudentArray)
                if (big < Arrays.stream(s.getMarks()).mapToDouble(x -> x).average().getAsDouble()) {
                    big = Arrays.stream(s.getMarks()).mapToDouble(x -> x).average().getAsDouble();
                    d = s;
                }
            return d;
        }
    }







