package nuc.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import nuc.edu.mapper.ResumeMapper;
import nuc.edu.service.ResumeService;
import org.springframework.stereotype.Service;
import nuc.edu.pojo.Resume;

import java.time.LocalDateTime;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: ResumeServiceImpl
 * @Date: 2024/2/29
 * @Time: 8:32
 * @Description:添加自定义描述
 */
@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements ResumeService {
    @Override
    public void add(Resume resume) {
        resume.setCreateTime(LocalDateTime.now());
        resume.setUpdateTime(LocalDateTime.now());
        this.save(resume);
    }

    @Override
    public void updateResumeById(Resume resume) {
        resume.setUpdateTime(LocalDateTime.now());
        this.updateById(resume);
    }

    @Override
    public Page page(int page, int pageSize, String name) {
        //构造分页构造器
        Page pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper lambdaQueryWrapper = new LambdaQueryWrapper<Resume>()
                .like(StringUtils.isNotEmpty(name), Resume::getName, name)
                .orderByDesc(Resume::getUpdateTime);

        //执行查询
        return this.page(pageInfo, lambdaQueryWrapper);
    }
}
