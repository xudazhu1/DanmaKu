package cn.xudazhu.api.service;

import cn.xudazhu.api.bean.Danma;
import cn.xudazhu.api.repository.DanmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanmaService {

    private DanmaRepository danmaRepository;

    @Autowired
    public void setDanmaRepository(DanmaRepository danmaRepository) {
        this.danmaRepository = danmaRepository;
    }

    /**
     * 添加弹幕
     *
     * @param danma 要添加的弹幕
     * @return 返回是否添加成功
     */
    public Boolean add(Danma danma) {
        return danmaRepository.save(danma) != null;
    }

    /**
     * 查找弹幕 4 视频id号
     *
     * @param id 视频id号
     * @return List<Danma>
     */
    public List<Danma> select(String id) {
        return danmaRepository.findByIdOrderByTimeAsc(id);
    }

}
