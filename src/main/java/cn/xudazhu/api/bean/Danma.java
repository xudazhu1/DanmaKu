package cn.xudazhu.api.bean;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 弹幕pojo
 */
@Entity
@Table(name = "danma")
@Getter@Setter
public class Danma {

    /**
     * 主键 数据id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    @Column(name = "did")
    private Integer did;

    /**
     * 弹幕ID 不可重复
     */
    private String id;
    /**
     * 弹幕作者
     */
    private String author;
    /**
     * 弹幕颜色代码
     */
    private Integer color;
    /**
     * 弹幕内容
     */
    private String text;
    /**
     * 弹幕出现时间
     */
    private Double time;
    /**
     * 弹幕类型
     */
    private Integer type;

}
