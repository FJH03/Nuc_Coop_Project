package nuc.edu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: User
 * @Date: 2024/2/17
 * @Time: 11:20
 * @Description:添加自定义描述
 */
@Data
@NoArgsConstructor
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String username;
    private byte gender;
    private String email;
    private String avatarUrl;
    private String password;
    private String phone;
    private byte status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String remark;
    private Integer type;
}
