package nuc.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import nuc.edu.mapper.AdminMapper;
import nuc.edu.pojo.Admin;
import nuc.edu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042619-赵彦博
 * @ClassName: AdminServiceImpl
 * @Date: 2024/2/19
 * @Time: 15:55
 * @Description:添加自定义描述
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    HttpServletRequest request;


    @Override
    public Admin login(Admin admin) {
        String password = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
        LambdaUpdateWrapper lambdaUpdateWrapper = new LambdaUpdateWrapper<Admin>()
                .eq(Admin::getUsername, admin.getUsername());
        Admin GM = this.getOne(lambdaUpdateWrapper);

        if (GM == null || !GM.getPassword().equals(password)) {
            return null;
        }

        //登陆成功逻辑
        request.getSession().setAttribute("admin", admin.getId());
        return GM;
    }
}
