package nuc.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import nuc.edu.mapper.OperateLogMapper;
import nuc.edu.service.OperateLogService;
import org.springframework.stereotype.Service;
import nuc.edu.pojo.OperateLog;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: OperateLogServiceImpl
 * @Date: 2024/2/27
 * @Time: 14:57
 * @Description:添加自定义描述
 */
@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements OperateLogService {}
