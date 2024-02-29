package nuc.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import nuc.edu.pojo.Resume;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: ResumeService
 * @Date: 2024/2/29
 * @Time: 8:31
 * @Description:添加自定义描述
 */
public interface ResumeService extends IService<Resume> {
    void add(Resume resume);

    void updateResumeById(Resume resume);

    Page page(int page, int pageSize, String name);
}
