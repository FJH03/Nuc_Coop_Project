package nuc.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import nuc.edu.pojo.Admin;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042619-赵彦博
 * @ClassName: AdminService
 * @Date: 2024/2/19
 * @Time: 15:55
 * @Description:添加自定义描述
 */
public interface AdminService extends IService<Admin> {

    Admin login(Admin admin);

    void logout();
}
