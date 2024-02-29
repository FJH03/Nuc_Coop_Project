package nuc.edu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: Resume
 * @Date: 2024/2/29
 * @Time: 8:36
 * @Description:添加自定义描述
 */
@Data
public class Resume {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Long num;
    private String message;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
