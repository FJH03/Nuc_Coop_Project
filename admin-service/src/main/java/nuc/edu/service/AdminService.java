package nuc.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import nuc.edu.pojo.Admin;

import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: AdminService
 * @Date: 2024/2/19
 * @Time: 15:55
 * @Description:添加自定义描述
 */
public interface AdminService extends IService<Admin> {
    void changestu(List<Long> ids, byte status);

    Page page(int page, int pageSize, String name);
}
