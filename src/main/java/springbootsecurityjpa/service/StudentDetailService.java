package springbootsecurityjpa.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springbootsecurityjpa.model.Student;
import springbootsecurityjpa.model.StudentDetail;
import springbootsecurityjpa.repository.StudentRepo;

import java.util.Optional;

@Service
public class StudentDetailService implements UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(StudentDetailService.class);
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Student> student = null;
        try {
            student = studentRepo.findByName(name);
        }catch (UsernameNotFoundException e){
            log.error("NOT FOUND STUDENT", new UsernameNotFoundException(name));
        }
        //từ thông tin user truy vấn từ db lên sẽ tiến hành map nó thành object người dùng để đưa vào security quản lí
        return new StudentDetail(student.get());
    }
}
