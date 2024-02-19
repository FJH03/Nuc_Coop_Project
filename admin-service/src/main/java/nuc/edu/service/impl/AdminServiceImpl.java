package nuc.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import nuc.edu.client.UserClient;
import nuc.edu.mapper.AdminMapper;
import nuc.edu.pojo.Admin;
import nuc.edu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: AdminServiceImpl
 * @Date: 2024/2/19
 * @Time: 15:55
 * @Description:添加自定义描述
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private UserClient userClient;
    @Override
    public void changestu(List<Long> ids, byte status) {
        userClient.changestu(ids, status);
    }
}
