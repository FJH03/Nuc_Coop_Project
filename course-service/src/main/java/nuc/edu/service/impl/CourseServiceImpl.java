package nuc.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import nuc.edu.mapper.CourseMapper;
import nuc.edu.pojo.Course;
import nuc.edu.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042619-赵彦博
 * @ClassName: CourseService
 * @Date: 2024/2/20
 * @Time: 19:30
 * @Description:添加自定义描述
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
}
