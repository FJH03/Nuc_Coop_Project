package nuc.edu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: OperationLog
 * @Date: 2024/2/27
 * @Time: 14:34
 * @Description:添加自定义描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperateLog {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Object operateUser;
    private LocalDateTime operateTime;
    private String className;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private Long costTime;
}
