package nuc.edu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042619-赵彦博
 * @ClassName: Course
 * @Date: 2024/2/20
 * @Time: 19:33
 * @Description:添加自定义描述
 */
@Data
public class Course {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String coursename;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
