package cn.xudazhu.api.repository;

import cn.xudazhu.api.bean.Danma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanmaRepository extends JpaRepository<Danma, Integer> {
    /**
     * 获取弹幕 按弹幕出现时间升序排序
     * @param id 弹幕所属视频id号
     * @return 返回所查询到的弹幕集合
     */
    List<Danma> findByIdOrderByTimeAsc(String id) ;
}
